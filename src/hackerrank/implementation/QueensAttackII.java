package hackerrank.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QueensAttackII {

	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int cr = r_q, cc = c_q, canAttack = 0;
        Map<String, Boolean> mapObstacles = new HashMap<String, Boolean>();
        for (int i = 0; i < k; i++) {
        		mapObstacles.put(obstacles[i][0] + "-" + obstacles[i][1], true);
        }
        
        //north
        cr++;
        while (cr <= n) {
        		if (mapObstacles.containsKey(cr+"-"+cc)) {
        			break;
        		}
        		//System.out.println("("+cr+","+cc+")");
        		cr++;
        		canAttack++;
        }
        
        //northeast
        cr = r_q+1; cc = c_q+1;
        while (cr <= n && cc <= n) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cr++;
	    		cc++;
	    		canAttack++;
	    }
        
        //east
        cr = r_q; cc = c_q+1;
        while (cc <= n) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cc++;
	    		canAttack++;
	    }
        
        //south east
        cr = r_q-1; cc = c_q+1;
        while (cc <= n && cr >= 1) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cc++;
	    		cr--;
	    		canAttack++;
	    }
        
        //south
        cr = r_q-1; cc = c_q;
        while (cr >= 1) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cr--;
	    		canAttack++;
	    }
        
        //southwest
        cr = r_q-1; cc = c_q-1;
        while (cr >= 1 && cc >= 1) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cr--;
	    		cc--;
	    		canAttack++;
	    }
        
        //west
        cr = r_q; cc = c_q-1;
        while (cc >= 1) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cc--;
	    		canAttack++;
	    }
        
        //northwest
        cr = r_q+1; cc = c_q-1;
        while (cc >= 1 && cr <= n) {
	    		if (mapObstacles.containsKey(cr+"-"+cc)) {
	    			break;
	    		}
	    		//System.out.println("("+cr+","+cc+")");
	    		cc--;
	    		cr++;
	    		canAttack++;
	    }
        return canAttack;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int r_q = in.nextInt();
        int c_q = in.nextInt();
        int[][] obstacles = new int[k][2];
        for(int obstacles_i = 0; obstacles_i < k; obstacles_i++){
            for(int obstacles_j = 0; obstacles_j < 2; obstacles_j++){
                obstacles[obstacles_i][obstacles_j] = in.nextInt();
            }
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        in.close();
    }
}
