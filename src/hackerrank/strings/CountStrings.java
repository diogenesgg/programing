package hackerrank.strings;

public class CountStrings {

	static abstract class R {
		abstract int matches(String s, int from);
		
		public boolean matches(String s) {
			return matches(s, 0) == s.length();
		}
	}
	
	static class Concat extends R {
		
		private R left;
		private R right;
		
		public Concat(R l, R r) {
			this.left = l;
			this.right = r;
		}

		@Override
		public int matches(String s, int from) {
			int leftResult = left.matches(s, from);
			if (leftResult == -1) {
				return -1;
			}
			return right.matches(s, leftResult);
		}
		
	}
	
	static class Or extends R {
		
		private R left;
		private R right;
		
		public Or(R l, R r) {
			this.left = l;
			this.right = r;
		}
		
		@Override
		public int matches(String s, int from) {
			int leftResult = left.matches(s, from);
			if (leftResult > -1) {
				return leftResult;
			}
			return right.matches(s, from);
		}
	}
	
	static class ZeroOrMore extends R {
		
		private R r;
		
		public ZeroOrMore(R r) {
			this.r = r;
		}
		
		@Override
		public int matches(String s, int from) {
			if (from == s.length()) return s.length();
			
			int i = from, last = i;
			
			while (true) {
				from = r.matches(s, from);
				if (from == -1) {
					return last;
				} else if (from >= s.length()){
					return from;
				} else {
					last = from;
				}
			}
		}
	}
	
	static class Single extends R {
		
		char single;
		
		public Single(char s) {
			this.single = s;
		}
		
		@Override
		public int matches(String s, int from) {
			if (from >= 0 && from < s.length() && s.charAt(from) == single) {
				return from+1;
			} else {
				return -1;
			}
		}
	}
	
	static int count(R pattern, String s, int l)  {
		if (s.length() == l) {
			if (pattern.matches(s)) {
				//System.out.println(s);
				return 1;
			} else {
				return 0;
			}
		}
		return count(pattern, s + "a", l) + count(pattern, s+"b", l);
	}
	
	static R parse(String s) {
		return null;
	}
	
	public static void main(String[] args) {
		//R r = new ZeroOrMore(new Or(new Single('a'), new Single('b')));
		//((a*)(b(a*))) 100
		R r = new Concat(new ZeroOrMore(new Single('a')), new Concat(new Single('b'), new ZeroOrMore(new Single('a'))));
		System.out.println(count(r, "", 10));
    }
}
