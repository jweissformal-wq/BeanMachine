package first1;

import java.util.Scanner;
public class SummBeanMach {

	public static void randomdrop(int ballNum, int slotsNum, char[] direction, int[] allFinalD){ //randomizes the way the ball drops down the bean machine
		
		for (int i=0; i<direction.length; i++){ //the for loop randomizes direction
			int turn = (int) (Math.random()*2); //a random number 0 or 1 is made
			if (turn == 0) { //if its 0 then it will be marked as the ball going left
				direction[i] = 'L'; //its Left
			}else{ //other wise, meaning it generated 1, it will be market as the ball going right
				direction[i] = 'R'; //its right
			}
		}
		
		for(int i = 0; i < direction.length; i++) { //prints every turn ball went
		System.out.print(direction[i]);//prints a single direction of right or left and the for loop gives the total combination of Rs and Ls
	    }
		System.out.println("");//allows the method to eventually print the direction of the next ball on a new line
		
		
		allFinalD[ballNum] = placement(direction, slotsNum); //finds what ball we are looking for the final destination of and finds the positon of it
		
		
	}
	
	public static int placement(char[] direction, int slotsNum) { //find final placement of the balls
		int rightnum = 0; //will count how many times the ball went right to determine the final slot the ball went in, goes right once then second slot, twice the third slot, thrice the fourth slot, and so on
		for(int i = 0; i<direction.length; i++) { //goes through each turn the ball took
			if (direction[i] == 'R') { //if the ball turned right in the array that contains the turns(direction)at the spot we are looking at [i] we add 1 to the total amount of right turns
				rightnum = rightnum+1;//adds 1
			}
		}
		if (rightnum<slotsNum-1) { //checks if the max number of right turns is less than the max slot
			return rightnum;//return number of right turns
		}else {//if it is not less than the max slot, this returns max slot
			return slotsNum-1;//return max slot
		}
		
		
	}
	public static void visual(int ballNum, int slotsNum, int[] allFinalD) {//visualize the balls filling each slot method
		
		int[] slotcounts = new int[slotsNum]; //counts how many balls are in each slot, why it has the same length as number of slots
		
		for (int i=0; i<ballNum; i++) {//counts up how many balls ended up in every slot
			if (allFinalD[i]<slotsNum) { //is the slot valid
				slotcounts[allFinalD[i]] = slotcounts[allFinalD[i]]+1;//increase the number of balls in each slot
			}
		}
		
		int mostBalls = 0;//tracks the most balls in any slot starting at 0 assuming every slot starts with 0 balls
		for (int i=0; i<slotcounts.length; i++) {//find the max amount in any slot, loops through max of every slot
			if(slotcounts[i] > mostBalls) {//is the current slot's amount of balls greater than the current max balls 
				mostBalls = slotcounts[i];//adjusts accordingly if the if statement is true
			}
			
		}
		//where we begin printing the slots
		for (int i = mostBalls; i > 0; i--) { //starts counting from the highest amount of balls going down
			for (int k = 0; k < slotsNum; k++) { //go through every single slot 
				if (slotcounts[k] >= i) { //if the slot has enough balls to print in that given horizontal row/line of balls
					System.out.print("O");//we print the ball
				}else {//otherwise there are not enough balls
					System.out.print(" ");//we fill the empty space with a space because there is no ball to fill that spot
				}
				
			}
			System.out.println();//go to next horizontal line/row of balls
		}
		
		
	}
	public static void main(String[] args) { //main method
		Scanner s = new Scanner (System.in); //declare the scanner for the user to enter info
		
		
		System.out.println("Welcome to the BEAN MACHINE!!!"); //says the user is in a bean machine program
		
		System.out.println("How many balls do you want to drop (enter a postive integer like 1 or 12 and not -4 or 0)?"); //prompts user to enter how many balls to drop
		int ballsDrop = s.nextInt(); //registers the amount of balls they want
		System.out.println("How many slots do you want to store the balls (enter a postive integer like 1 or 12 and not -4 or 0)?"); //prompts user to enter how many slots should the balls be able to fill
		int slotsNum = s.nextInt(); //registers the amount of slots they want
		
		char[] direction = new char[slotsNum-1]; //finds the way the balls are going with Ls and Rs
		int[] allFinalD = new int[ballsDrop]; //finds final destination of the ball in what slots
		for (int i=0; i< ballsDrop; i++) { //randomly drops each of the balls and calculates direction and eventually position
			randomdrop(i, slotsNum, direction, allFinalD); //refers to randomdrop method
		}
		
		visual(ballsDrop, slotsNum, allFinalD); //visualize the slots given the amount of balls to drop, number of slots, and final destination of each of the balls
		
		
	}

}
