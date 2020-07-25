# codingProblems

I'll maintain the questions list here, along with the function name, and it's purpose.

#Questions: Array rotations

-> array rotation count
-> search in sorted array
-> rotate by k amount


1. Find the Rotation Count in Rotated Sorted array Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k. Examples: Input : arr[] = {15, 18, 2, 3, 6, 12} Output: 2 Explanation : Initial array must be {2, 3, 6, 12, 15, 18}. We get the given array after rotating the initial array twice. 
Input : arr[] = {7, 9, 11, 12, 5} Output: 4 
Input: arr[] = {7, 9, 11, 12, 15}; Output: 0 


2. Search an element in a sorted and rotated array An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
key = 3 Output : Found at index 8 
Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
key = 30 Output : Not found 
Input : arr[] = {30, 40, 50, 10, 20} 
key = 10 Output : Found at index 3 


3. Given a sorted and rotated array, find if there is a pair with a given sum Given an array that is sorted and then rotated around an unknown point. Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct. Examples : Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16 Output: true There is a pair (6, 10) with sum 16 
Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35 Output: true There is a pair (26, 9) with sum 35 
Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45 Output: false There is no pair with sum 45. 


4. Maximum sum of i*arr[i] among all rotations of a given array Given an array arr[] of n integers, find the maximum that maximizes sum of value of i*arr[i] where i varies from 0 to n-1. Examples : Input : arr[] = {8, 3, 1, 2} Output : 29 Explanation : Let us see all rotations {8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11 {3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29 {1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27 {2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17 
Input : arr[] = {3, 2, 1} Output : 7 
