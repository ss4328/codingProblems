# codingProblems

I'll maintain the questions list here, along with the function name, and it's purpose.

#Arrays - SORTING
1. Alternative Sorting
Given an array of integers, print the array in such a way that the first element is first maximum and second element is first minimum and so on.
Examples :
Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
Output : 7 1 6 2 5 3 4
 
Input : arr[] = {1, 6, 9, 4, 3, 7, 8, 2}
Output : 9 1 8 2 7 3 6 4

2. Sort a nearly sorted (or K sorted) array
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
Examples:
Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
        	k = 3
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 
Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
     	k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 

3. Sort an array according to absolute difference with given value
Given an array of n distinct elements and a number x, arrange array elements according to the absolute difference with x, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.
Examples :
Input : arr[] : x = 7, arr[] = {10, 5, 3, 9, 2}
Output : arr[] = {5, 9, 10, 3, 2}
Explanation:
7 - 10 = 3(abs)
7 - 5 = 2
7 - 3 = 4
7 - 9 = 2(abs)
7 - 2 = 5
So according to the difference with X,
elements are arranged as 5, 9, 10, 3, 2.
 
Input : x = 6, arr[] = {1, 2, 3, 4, 5}  
Output :  arr[] = {5, 4, 3, 2, 1}
 
Input : x = 5, arr[] = {2, 6, 8, 3}  
Output :  arr[] = {6, 3, 2, 8}
 
 
4. Sort an array in wave form
Given an unsorted array of integers, sort the array into a wave like array. An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
Examples:
 Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
 Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
             	{20, 5, 10, 2, 80, 6, 100, 3} OR
             	any other array that is in wave form
 
 Input:  arr[] = {20, 10, 8, 6, 4, 2}
 Output: arr[] = {20, 8, 10, 4, 6, 2} OR
             	{10, 8, 20, 2, 6, 4} OR
             	any other array that is in wave form
 
 Input:  arr[] = {2, 4, 6, 8, 10, 20}
 Output: arr[] = {4, 2, 8, 6, 20, 10} OR
             	any other array that is in wave form
 
 Input:  arr[] = {3, 6, 5, 10, 7, 20}
 Output: arr[] = {6, 3, 10, 5, 20, 7} OR
             	any other array that is in wave form
 
5. Merge an array of size n into another array of size m+n
There are two sorted arrays. First one is of size m+n containing only m elements. Another one is of size n and contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.

Input: array with m+n elements (mPlusN[]).
NA => Value is not filled/available in array mPlusN[]. There should be n such array blocks.
Input: array with n elements (N[]).
Output: N[] merged into mPlusN[] (Modified mPlusN[])
 
 
6. Sort an array which contain 1 to n values
You have given an array which contain 1 to n element, your task is to sort this array in an efficient way and without replace with 1 to n numbers.
Examples :
Input : arr[] = {10, 7, 9, 2, 8,
             	3, 5, 4, 6, 1};
Output : 1 2 3 4 5 6 7 8 9 10
 
 
7. Sort 1 to N by swapping adjacent elements
Given an array, A of size N consisting of elements 1 to N. A boolean array B consisting of N-1 elements indicates that if B[i] is 1, then A[i] can be swapped with A[i+1].
Find out if A can be sorted by swapping elements.
Examples:
Input : A[] = {1, 2, 5, 3, 4, 6}
    	B[] = {0, 1, 1, 1, 0}
Output : A can be sorted
We can swap A[2] with A[3] and then A[3] with A[4].
 
Input : A[] = {2, 3, 1, 4, 5, 6}
    	B[] = {0, 1, 1, 1, 1}
Output : A can not be sorted
We can not sort A by swapping elements as 1 can never be swapped with A[0]=2.
  
 
8. Sort an array containing two types of elements
We are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
Examples:
Input :  arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
Output : arr[] = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 
Input :  arr[] = [1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1]
Output : arr[] = [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]
 
 
9. Sort elements by frequency
Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.

Examples:
Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 
Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 
10. Count Inversions in an array 
Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
Example:
The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

11. 1.Find the Rotation Count in Rotated Sorted array
Consider an array of distinct numbers sorted in increasing order. The array
has been rotated (clockwise) k number of times. Given such an array, find
the value of k.
Examples:
Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after
rotating the initial array twice.
Input : arr[] = {7, 9, 11, 12, 5}
Output: 4
Input: arr[] = {7, 9, 11, 12, 15};
Output: 0

12. 2.Search an element in a sorted and rotated array
An element in a sorted array can be found in O(log n) time via binary
search. But suppose we rotate an ascending order sorted array at some
pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become
3 4 5 1 2.

Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
key = 3
Output : Found at index 8
Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
key = 30
Output : Not found
Input : arr[] = {30, 40, 50, 10, 20}
key = 10
Output : Found at index 3

13. Given a sorted and rotated array, find if there is a pair with a given sum
Given an array that is sorted and then rotated around an unknown point.
Find if the array has a pair with a given sum ‘x’. It may be assumed that all
elements in the array are distinct.
Examples :
Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16
Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35
Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.

14. Maximum sum of i*arr[i] among all rotations of a given array
Given an array arr[] of n integers, find the maximum that maximizes sum of
value of i*arr[i] where i varies from 0 to n-1.
Examples :
Input : arr[] = {8, 3, 1, 2}
Output : 29
Explanation : Let us see all rotations
{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
{3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
{1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
{2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17
Input : arr[] = {3, 2, 1}
Output : 7