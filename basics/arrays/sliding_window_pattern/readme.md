# Sliding Window pattern

In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size.

Following are some ways you can identify that the given problem might require a sliding window:
1. The problem input is a linear data structure such as a linked list, array, or string
2. You’re asked to find the longest/shortest substring, subarray, or a desired value

#### Example Input

```bash
Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
```

Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array.

1. For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
2. The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
3. For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4

#### Output

```bash
Output: [2.2, 2.8, 2.4, 3.6, 2.8]
```

## Bruteforce

```python
def find_averages_of_subarrays(K, arr):
  result = []
  for i in range(len(arr)-K+1):
    # find sum of next 'K' elements
    _sum = 0.0
    for j in range(i, i+K):
      _sum += arr[j]
    result.append(_sum/K)  # calculate average

  return result


def main():
  result = find_averages_of_subarrays(5, [1, 3, 2, 6, -1, 4, 1, 8, 2])
  print("Averages of subarrays of size K: " + str(result))


main()

```

#### Bruteforce Time complexity

Since for every element of the input array, we are calculating the sum of its next ‘K’ elements, the time complexity of the above algorithm will be O(N*K)O(N∗K) where ‘N’ is the number of elements in the input array.

## Sliding Window Approach

For any problem where there is a better approach, there always exists some duplicate work that we must get rid of to enhance the computations. Here, the inefficiency is that for any two consecutive subarrays of size ‘5’, the overlapping part (which will contain four elements) will be evaluated twice. 

There are four overlapping elements between the subarray (indexed from 0-4) and the subarray (indexed from 1-5).

The efficient way to solve this problem would be to visualize each contiguous subarray as a sliding window of ‘5’ elements. This means that when we move on to the next subarray, we will slide the window by one element. So, to reuse the sum from the previous subarray, we will subtract the element going out of the window and add the element now being included in the sliding window. This will save us from going through the whole subarray to find the sum and, as a result, the algorithm complexity will reduce to O(N).

This is how we do it:

```python
def find_averages_of_subarrays(K, arr):
  result = []
  windowSum, windowStart = 0.0, 0
  for windowEnd in range(len(arr)):
    windowSum += arr[windowEnd]  # add the next element
    # slide the window, we don't need to slide if we've not hit the required window size of 'k'
    if windowEnd >= K - 1:
      result.append(windowSum / K)  # calculate the average
      windowSum -= arr[windowStart]  # subtract the element going out
      windowStart += 1  # slide the window ahead

  return result


def main():
  result = find_averages_of_subarrays(5, [1, 3, 2, 6, -1, 4, 1, 8, 2])
  print("Averages of subarrays of size K: " + str(result))


main()
```


## Practice problems

Common problems you use the sliding window pattern with:
1. Maximum sum subarray of size ‘K’ (easy)
2. Longest substring with ‘K’ distinct characters (medium)
3. String anagrams (hard)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Credits:
Grokking coding interview patterns by educative.

[Hackernoon](https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed)

## License
[MIT](https://choosealicense.com/licenses/mit/)
