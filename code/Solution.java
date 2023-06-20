import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the radius (k): ");
        int k = scanner.nextInt();

        int[] averages = getAverages(nums, k);

        System.out.println("K-Radius Averages:");
        for (int average : averages) {
            System.out.print(average + " ");
        }
    }

    public static int[] getAverages(int[] nums, int k) {
        // When a single element is considered, its average will be the number itself only.
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        // Any index will not have 'k' elements on its left and right.
        if (2 * k + 1 > n) {
            return averages;
        }

        // Generate 'prefix' array for 'nums'.
        // 'prefix[i + 1]' will be the sum of all elements of 'nums' from index '0' to 'i'.
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Iterate only on those indices which have at least 'k' elements on their left and right.
        // i.e. indices from 'k' to 'n - k'
        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int average = (int) (subArraySum / (2 * k + 1));
            averages[i] = average;
        }

        return averages;
    }
}
