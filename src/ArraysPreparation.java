import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 * Example Input: 1
 * 5 12
 * 1 2 3 7 5
 * Output : 2 4
 * Failing for below
 * 1
 * 42 468
 * 135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134
 */
public class ArraysPreparation {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfTestCases = sc.nextInt();
    for (int i = 0; i < noOfTestCases; ++i) {
      int lengthOfArray = sc.nextInt();
      int sumOfContinuesNumbers = sc.nextInt();
      int[] array = new int[lengthOfArray];
      for (int j = 0; j < lengthOfArray; ++j) {
        array[j] = sc.nextInt();
      }
      printContinuesSubArray(array, sumOfContinuesNumbers, lengthOfArray);
    }
  }

  private static void printContinuesSubArray(int[] array, int sumOfContinuesNumbers, int lengthOfArray) {
    int windowsSum = 0, removingIndex = 0;
    boolean subarrayFound = false;
    for (int i = 0; i < lengthOfArray; ++i) {
      // adding the elements into window
      windowsSum += array[i];
      //Removing the excess element from left from window
      while(windowsSum > sumOfContinuesNumbers) {
        windowsSum = windowsSum - array[removingIndex];
        removingIndex++;
      }
      // At last check if found
      if(windowsSum == sumOfContinuesNumbers) {
        subarrayFound = true;
        System.out.println((removingIndex + 1) + " " + (i+1));
        break;
      }
    }
    if(!subarrayFound) {
      System.out.println(-1);
    }
  }
}
