package assignment1_solution;

/* Dunia Jaser - 1201345.
 Lecture N0. 3
 Instructor Bassem Sayrafi.*/
import java.util.Scanner;

public class Assignment1_solution {

	public static void main(String[] args) {
		System.out.print(
				"Enter the number of days that a patient has entered the hospital(it should be a positive integer larger than 1):");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		double[][] Reading_Temperature = new double[n][];
		int i;
		double Sum = 0;
		double x = 0;
		int y;
		int totalTemp = 0;
		for (i = 0; i < Reading_Temperature.length; i++) {
			System.out.print(
					"Enter the number of times that nurse read the temperature of the patient (it should be a positive integer larger than 1) in the "
							+ (i + 1) + " day:");
			y = input.nextInt();
			if (y == 0) {
				System.out.println(
						"If the nurse did not take the temperature, why is the patient in the hospital?, it does not make any sense!");
				System.out.println("please try again!");
				System.out.print("Enter the number of times that nurse read the temperature of the patient in the "
						+ (i + 1) + " day:");
				y = input.nextInt();
				Reading_Temperature[i] = new double[y];
			}
			Reading_Temperature[i] = new double[y];
			for (int h = 0; h < Reading_Temperature[i].length; h++) {
				System.out.print("Enter the " + (h + 1) + " reading in Celsius:");
				x = input.nextDouble();
				if (x <= 30 || x >= 45) {
					System.out.println("There is an error, please check whether the reading is right, and try again");
					System.out.print("Enter the " + (h + 1) + " reading in Celsius:");
					x = input.nextDouble();
					Reading_Temperature[i][h] = x;
					Sum += Reading_Temperature[i][h];
					totalTemp += 1;

				}
				Reading_Temperature[i][h] = x;
				Sum += Reading_Temperature[i][h];
				totalTemp += 1;
			}

		}
		System.out.println();
		System.out.println("---------------------------------------------");
		double[] Array_Of_Avg_max_min = new double[3];
		Array_Of_Avg_max_min = Summary(Reading_Temperature, Sum, totalTemp);
		System.out.println("The average of all Temperatures is " + Array_Of_Avg_max_min[0]);
		System.out.println("The max Temperature is " + Array_Of_Avg_max_min[1]);
		System.out.println("The min Temperature is " + Array_Of_Avg_max_min[2]);
		System.out.println("---------------------------------------------");
		double[] Above_Below_avg = new double[2];
		Above_Below_avg = countbelowAboveAverage(Array_Of_Avg_max_min[0], Reading_Temperature);
		System.out.println("The number of temperatures less than or equal to the average of temperatures is "
				+ Above_Below_avg[0]);
		System.out.println("The number of temperatures above the average of temperatures is " + Above_Below_avg[1]);
		System.out.println("---------------------------------------------");
		double[][] sortedArray = new double[Reading_Temperature.length][];
		sortedArray = sortArray(Reading_Temperature);
		printArray(sortedArray);
		System.out.println("---------------------------------------------");
		System.out.println("Ask me:(if The patient can leave the hospital)");
		String variable = input.next();
		if (leaveHospital(sortedArray))
			System.out.println(
					"The patient can leave the hospital!~because the average for last two highest read of temperatures were around normal (35.5-36.5)C.");
		else
			System.out.println(
					"The patient can not leave the hospital!~because the average for last two highest read of temperatures were not around normal (35.5-36.5)C.");

	}

// i can return more than one value in method using array of any size(depends on how many values I want to return).
	public static double[] Summary(double[][] tempArray, double sum, int totalNum) {
		double average = sum / totalNum;
		double[] myArray = new double[3];
		// 3 because I want to return the average, the minimum, and the maximum temp.
		myArray[0] = average;
		double max = tempArray[0][0];
		double min = tempArray[0][0];
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = 0; j < tempArray[i].length; j++) {
				if (tempArray[i][j] > max)
					max = tempArray[i][j];
				if (tempArray[i][j] < min)
					min = tempArray[i][j];
			}
		}
		myArray[1] = max;
		myArray[2] = min;
		return myArray;
	}

	public static double[] countbelowAboveAverage(double x, double[][] array) {
		double[] aboveBelow = new double[array.length];
		int countBelow = 0, countAbove = 0;
		int i, j;
		if (array.length == 1) {

		}
		for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[i].length; j++) {

				if (x >= array[i][j])
					countBelow += 1;
				if (x < array[i][j])
					countAbove += 1;
			}
		}
		aboveBelow[0] = countBelow;
		aboveBelow[1] = countAbove;
		return aboveBelow;
	}

	/*
	 * this method is used for sorting the 2D array in ascending order of
	 * temperatures.
	 */
	public static double[][] sortArray(double[][] tempArray) {
		int i;
		for (i = 0; i < tempArray.length; i++) {
			java.util.Arrays.sort(tempArray[i]);
		}
		return tempArray;
	}

	public static void printArray(double[][] sortedArray) {
		int i, j;
		System.out.println("The temperatures of each day in ascending order:");
		for (i = 0; i < sortedArray.length; i++) {
			System.out.print("In the " + (i + 1) + " day,the nurse took a " + sortedArray[i].length
					+ " raeds, the temperatures are :");
			for (j = 0; j < sortedArray[i].length; j++) {
				System.out.print(sortedArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * this method purpose is to check whether if the patient can leave the
	 * hospital.
	 */
	public static boolean leaveHospital(double[][] tempArray) {
		boolean canLeaveTheHospital = true;
		int i, j;
		double sumOfMax = 0;
		/*
		 * the array is already sorted so I take the last two index(they have the 2
		 * maximum temperature in that day.)
		 */
		for (i = tempArray.length - 2; i < tempArray.length - 1; i++) {
			for (j = tempArray[i].length - 2; j < tempArray[i].length; j++) {
				sumOfMax += tempArray[i][j];
			}
		}
		for (i = tempArray.length - 1; i < tempArray.length; i++) {
			for (j = tempArray[i].length - 2; j < tempArray[i].length; j++) {
				sumOfMax += tempArray[i][j];
			}
		}
		double average;
		average = sumOfMax / 4;
		/*
		 * 4 is the sum of numbers of the two highest temperatures in the two last days.
		 */
		System.out
				.println("The average for the last two highest read temperatures in the last two days is: " + average);

		if (average < 35.5 || average > 36.5) {
			canLeaveTheHospital = false;
		}
		return canLeaveTheHospital;
	}

}