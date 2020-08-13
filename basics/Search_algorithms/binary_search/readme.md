## Binary Search

A binary search algorithm finds an item in a sorted list in  O(lg(n)) time.

A brute force search would walk through the whole list, taking O(n) time in the worst case.

Let's say we have a sorted list of numbers. To find a number with a binary search, we:

1. Start with the middle number: is it bigger or smaller than our target number? Since the list is sorted, this tells us if the target would be in the left half or the right half of our list.
2. We've effectively divided the problem in half. We can "rule out" the whole half of the list that we know doesn't contain the target number.
3. Repeat the same approach (of starting in the middle) on the new half-size problem. Then do it again and again, until we either find the number or "rule out" the whole set.

## Python Template
Following code and theory was taken from a [Great leetcode discussion](https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems) about the same topic. 

Whenever implementing Binary search, I've also experienced a little ahem.. time lag (in absence of a better word) while coding. Although the concept of Binary search is easy, there're many moving parts which could distract you from actually pursuing the solution. 

When you're implementing binary search in a problem, your solution could be amazing, but if you ignmored b_search implementation's eccentricities, you could easily mess up edge cases, termination case, or worse your code could enter an infinite loop. In a tournament, or in a coding interview, when you have a time-crunch, these issues could easily snowball and turn deadly on your valuable time. 

Some of the most common problems include:

- When to exit the loop? Should we use left < right or left <= right as the while loop condition?
- How to initialize the boundary variable left and right?
- How to update the boundary? How to choose the appropriate combination from left = mid, left = mid + 1 and right = mid, right = mid - 1?

So, this B_search template. 

```python
def binary_search(array) -> int:
    def condition(value) -> bool:
        pass

    left, right = min(search_space), max(search_space) # could be [0, n], [1, n] etc. Depends on problem
    while left < right:
        mid = left + (right - left) // 2
        if condition(mid):
            right = mid
        else:
            left = mid + 1
    return left

```

That's it, you just need to change a tiny portion of this code (atmost 3 places) and be done with the implementation. 

- Correctly initialize the boundary variables left and right to specify search space. Only one rule: set up the boundary to include all possible elements;
- Decide return value. Is it return left or return left - 1? Remember this: after exiting the while loop, left is the minimal k​ satisfying the condition function;
- Design the condition function. This is the most difficult and most beautiful part. Needs lots of practice.  


## Questions tried:
278. First Bad Version [Easy]
69. Sqrt(x) [Easy]
35. Search Insert Position [Easy]
1011. Capacity To Ship Packages Within D Days [Medium]
410. Split Array Largest Sum [Hard]
875. Koko Eating Bananas [Medium]
1482. Minimum Number of Days to Make m Bouquets [Medium]
668. Kth Smallest Number in Multiplication Table [Hard]
719. Find K-th Smallest Pair Distance [Hard]
1201. Ugly Number III [Medium]
1283. Find the Smallest Divisor Given a Threshold [Medium]

### Credits:
[Zhilun_liao](https://leetcode.com/zhijun_liao/)
[Original Post - prone to removal/change](https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems)