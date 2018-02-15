package hackerrank.implementation;

import java.util.Scanner;

public class CatsAndAMouse {

	static String catAndMouse(int x, int y, int z) {
        int distA = Math.abs(z - x);
        int distB = Math.abs(z - y);
        
        if (distA < distB) {
        		return "Cat A";
        } else if (distA > distB) {
        		return "Cat B";
        } else {
        		return "Mouse C";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            String result = catAndMouse(x, y, z);
            System.out.println(result);
        }
        in.close();
    }
}
