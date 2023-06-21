# K-Radius Subarray Averages

This is a Java solution for the problem of calculating the k-radius averages for subarrays in an array of integers. Given an array `nums` of size `n` and an integer `k`, the program calculates the k-radius average for each subarray centered at index `i`.

## Problem Description

You are given a 0-indexed array `nums` of `n` integers and an integer `k`. The k-radius average for a subarray of `nums` centered at some index `i` with the radius `k` is the average of all elements in `nums` between the indices `i - k` and `i + k` (inclusive). If there are fewer than `k` elements before or after the index `i`, then the k-radius average is -1.

The program builds and returns an array `avgs` of length `n` where `avgs[i]` is the k-radius average for the subarray centered at index `i`.

The average of `x` elements is the sum of the `x` elements divided by `x`, using integer division. The integer division truncates toward zero, which means losing its fractional part.

## Solution

The solution is implemented in the `Solution` class. The `getAverages` method takes an array of integers `nums` and an integer `k` as input and returns an array `averages` of k-radius averages for each subarray centered at index `i`.

The algorithm works as follows:

1. If `k` is 0, the average of each element is the element itself, so the original array `nums` is returned.
2. An array `averages` of size `n` is created and initialized with -1.
3. If the subarray size (2 * k + 1) is greater than the length of `nums`, there are not enough elements to calculate the k-radius average for any index. In this case, the array `averages` containing all -1's is returned.
4. A prefix sum array `prefix` is generated from `nums`, where `prefix[i + 1]` represents the sum of all elements from index 0 to i.
5. The iteration starts from `k` and goes up to `n - k - 1`. These are the indices where we have at least `k` elements on both sides to calculate the k-radius average.
6. For each valid index `i`, the left and right bounds are set to `i - k` and `i + k` respectively.
7. The variable `subArraySum` calculates the sum of elements in the subarray from the left bound to the right bound using the prefix sum array `prefix`.
8. The average of the subarray is calculated as `subArraySum / (2 * k + 1)`, and it is stored in the `averages` array at index `i`.
9. Finally, the `averages` array is returned as the result.

## Usage

To use the solution, follow these steps:

1. Clone the repository or download the `Solution.java` file.
2. Ensure you have Java installed on your system.
3. Compile the `Solution.java` file: `javac Solution.java`.
4. Run the program: `java Solution`.
5. Follow the prompts to enter the number of elements, the elements of the array, and the radius (k).
6. The program will calculate the k-radius averages and display the results.

## Example

Suppose we have an array `nums = [1, 2, 3, 4, 5]` and the radius `k = 1`. The program will calculate the k-radius averages for each subarray centered at index `i`:
```
Enter the number of elements in the array: 5
Enter the elements of the array:
1
2
3
4
5
Enter the radius (k): 1
K-Radius Averages:
1 2 3 4 5
```


In this case, since the radius is 1 and there are no elements before or after each index, the k-radius averages are equal to the elements themselves.

## Complexity Analysis

The time complexity of the solution is O(n), where n is the number of elements in the array `nums`. This is because we iterate through the array once to calculate the prefix sum array and then iterate again to calculate the k-radius averages.

The space complexity is O(n) as well, as we use additional space to store the prefix sum array and the array of k-radius averages.

