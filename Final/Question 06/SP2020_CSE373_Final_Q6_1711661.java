package com.nsu.spring2020.ID1711661;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SP2020_CSE373_Final_Q6_1711661 {

	public static void main(String[] args) throws Exception {
		
		
		File file = new File("C:\\Users\\fahim\\eclipse-workspace\\FinalAss\\src\\com\\nsu\\spring2020\\ID1711661\\SP2020_CSE373_FinalQ6_1711661.txt"); 
	    Scanner sc = new Scanner(file); 
	    int n = Integer.parseInt(sc.nextLine());
		sc.close();
	
	}
	public static Double[] hillClimb (Double[] orgPoint, Double[][] coords, Double count, Double stepSize){
	count++; //count number of steps

	ArrayList<Double[]> neighbours = new ArrayList<Double[]>(); //array list to store neighboures
	Double[] neighbourVal = new Double[2];
	for (int x = 0; x < 100; x++) {
		Double[] val = coords[x];
		if ((Math.abs(orgPoint[0] - val[0]) <= stepSize) || (Math.abs(orgPoint[1] - val[1]) <= stepSize)){
				neighbourVal[0] = val[0];
				neighbourVal[1] = val[1];
				neighbours.add(neighbourVal);
		}
	}
	Double max = -Math.abs(orgPoint[0]-2)- Math.abs(0.5*orgPoint[1]+1) +3;
	Boolean triggered = false;
	for (int y = 0; y < neighbours.size(); y++) {
		Double[] val = neighbours.get(y);
		
		Double opt = -Math.abs(val[0]-2)- Math.abs(0.5*val[1]+1) +3;
		
		if (opt > max) {
			max = opt;
			triggered = true;
		}
		if (triggered == true) {
			Double[] returnArr = hillClimb(val, coords, count, stepSize);
			count = returnArr[1];
			max = returnArr[0];	
		}
	}
	Double[] returnArr = new Double [2];
	returnArr[0] = max;
	returnArr[1] = count;
	return returnArr;
}
private static int[][] calculatePMoves(int[] currentBoard) {
		
		int[][] isboard = new int[currentBoard.length][currentBoard.length];
		for (int i = 0; i < currentBoard.length; i++) {
			int[] newBoard = currentBoard.clone();
			for (int j = 0; j < currentBoard.length; j++) {
				newBoard[i] = j;
				if(i == currentBoard[j]) {
					isboard[i][j] = 1000;
				}
			}
		}
		return isboard;
	}
private static int[] traverseToNeighbor(int min, int printCount, int[] currentBoard, int[][] cboard) 
{
	ArrayList<int[]> minimumPositions = new ArrayList<>();
	
	int[] cb = new int[currentBoard.length];
	cb = currentBoard.clone();
	
	for (int i = 0; i < cboard.length; i++) {
		for (int j = 0; j < cboard.length; j++) {
			if (min == cboard[i][j] && currentBoard[j]!=i) {
				int[] position = {i, j};
				minimumPositions.add(position);
			}
		}
	}
	return cb;
 }
}