package DynamicProgramming;

import java.util.Arrays;

/**
 * Given a set of non negative numbers and a total, find if there exists a subset in this set whose sum is same as total.
 */
public class SubsetSum {

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,7,8,10};
		int sum = 11;
		SubsetSum s = new SubsetSum();
		System.out.println("\n" + s.isSubsetSum(nums, sum));
	}
	
	public boolean isSubsetSum(int[] nums, int sum) {
		boolean[][] cache = new boolean[nums.length + 1][sum + 1];
		
		Arrays.sort(nums);
		System.out.println();
		
		for (int i = 1; i <= nums.length && nums[i - 1] <= sum; i++) {
			for (int j = 1; j <= sum; j++) {
				if (cache[i - 1][j] == true) {
					cache[i][j] = true;
				}
				else if (nums[i - 1] == j) {
					cache[i][j] = true;
				}
				else if (j > nums[i - 1]) {
					int remainder = j - nums[i - 1];
					cache[i][j] = cache[i - 1][remainder];
				}
			}
		}
		
		print2dArray(cache, nums, sum);
		
		return cache[nums.length][sum];
	}
	
	public void print2dArray(boolean[][] array, int[] nums, int sum) {
		for (int i = 0; i <= sum; i++) {
			System.out.printf("\t%d", i);
		}
		System.out.println();
		
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.printf("0");
			}
			else {
				System.out.printf("%d", nums[i - 1]);
			}
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("\t%b", array[i][j]);
			}
			System.out.println();
		}
	}
	
}
