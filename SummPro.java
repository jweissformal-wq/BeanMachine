package first1;

import java.util.Scanner;

public class SummPro {

    public static void randomdrop(int ballNum, int slotsNum, char[] direction, int[] allFinalD) {
        // Randomly assign 'L' or 'R' for each direction
    	for (int i = 0; i < direction.length; i++) {
    	    int turn = (int) (Math.random() * 2);
    	    if (turn == 0) {
    	        direction[i] = 'L';
    	    } else {
    	        direction[i] = 'R';
    	    }
    	}

        // Print directions for this ball
        for (int i = 0; i < direction.length; i++) {
            System.out.print(direction[i]);
        }
        System.out.println("");

        // Determine final position based on directions
        allFinalD[ballNum] = placement(direction, slotsNum);
    }

    public static int placement(char[] direction, int slotsNum) {
        int rightnum = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i] == 'R') {
                rightnum++;
            }
        }
        if (rightnum < slotsNum - 1) {
            return rightnum;
        } else {
            return slotsNum - 1;
        }
    }

    public static void visual(int ballNum, int slotsNum, int[] allFinalD) {
        int[] slotCounts = new int[slotsNum];

        // Count how many balls ended in each slot
        for (int i = 0; i < ballNum; i++) {
            if (allFinalD[i] < slotsNum) {
                slotCounts[allFinalD[i]]++;
            }
        }

        // Find the maximum number of balls in any slot
        int mostBalls = 0;
        for (int i = 0; i < slotCounts.length; i++) {
            if (slotCounts[i] > mostBalls) {
                mostBalls = slotCounts[i];
            }
        }

        // Visual representation of the slots, stacking vertically
        for (int i = mostBalls; i > 0; i--) {
            for (int k = 0; k < slotsNum; k++) {
                if (slotCounts[k] >= i) {
                    System.out.print("O ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

      
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to the BEAN MACHINE!!!");
        System.out.println("How many balls do you want to drop (enter a positive integer)?");
        int ballsDrop = s.nextInt();
        System.out.println("How many slots do you want to store the balls (enter a positive integer)?");
        int slotsNum = s.nextInt();

        char[] direction = new char[slotsNum - 1]; // Allocate for the pegs
        int[] allFinalD = new int[ballsDrop]; // Store results for each ball

        // Simulate dropping balls
        for (int i = 0; i <= ballsDrop; i++) { // Start from 0
            randomdrop(i, slotsNum, direction, allFinalD); // Use 'i' as the index for each ball
        }

        // Visualize the results
        visual(ballsDrop, slotsNum, allFinalD);
    }
}
