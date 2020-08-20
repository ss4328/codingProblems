# Dynammic Programming

## Theory
 
- Recursion is the key to understanding dynamic programming. Dynamic programming involves breaking problems down into smaller subproblems.
- Basically when you recurse without caching, and there're repeating subproblems when your recurse, you're wasting compute power in solving the same problems again and again.
- Dynammic programming is 'fancy' word for intelligent caching to solve subproblems. You basically cache information that you could use later, AND USE IT. The ultimate goal of this process is to improve runtime. Dynamic programming allows you to use more space to take less time.
- The USAGE is important, as if you just store and not use your cache, that's just dumb (I've done this and it's easier to mess up than you might think)

So how do we improve performance? 
- By optimizing the computation for **Overlapping subproblems.** 
    - for this, we need to find **Optimal Substructure**

### Overlapping Subproblems
- Overlapping subproblems means that when you split your problem into subproblems, you sometimes get the same subproblem multiple times.

With the Fibonacci example, if we want to compute fib(5), we need to compute fib(4) and fib(3). However, to compute fib(4), we need to compute fib(3) again. This is a wasted effort, since we’ve already computed the value of fib(3).

### Optimal Substructures
Optimal substructure requires that you can solve a problem based on the solutions of subproblems. For example, if you want to calculate the 5th Fibonacci number, it can be solved by computing fib(5) = fib(4) + fib(3). It is not necessary to know any more information other than the solutions of those two subproblems, in order to get the solution.

It's crucial to find optimal substructures. You could have sub-optimal substructures, then you're not unleasing the full potential of dynammic programming. If you can solve a problem recursively, it most likely has an optimal substructure. The recursive case might very likely help you find optimal substructure.

### Memoization
Memoization is the technique of writing a function that remembers the results of previous computations. This allows us to capitalize on overlapping subproblems.

### Corner cases

- Empty array
- Array with 1 or 2 elements
- Infinite recursion if you're using DP recursively

## Process for solving DP problems
1. Find a bruteforce/recursive solution
2. Find repeating subproblems
3. Use memoization to store/retrieve results for duplicate subproblems.
That's it, forget all the other fancy mumbo-jumbo you might have heard anywhere else. 

You could use DP with say a greedy approach to optimize further, but you technically are only using DP as a caching mechanism. 

## Running Example
Consider Leetcode #70: (Number of stairs)[https://leetcode.com/problems/climbing-stairs/]

1. If we were to find a recursive solution, it's easy. We find the termination case n=0,1,2, and then the recursive case: climbStairs(n) = climbStairs(n-1)+climbStairs(n-2)
```python
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        recursive solution->correct but O(2^n) time, O(n) space=depth of recursion tree which can go upto n
        if n<=0:
            return
        if n==1:
            return 1
        if n==2:
            return 2
        return self.climbStairs(n-1)+self.climbStairs(n-2)
```

2. The repeating subproblems are there in the recursive tree when we find the same computation for multiple subproblems when n!=0,1,2. In these cases we're not caching the found computations just yet.
3. Use memoization: Make a n+2 size array and keep storing the results in this array. 
```python
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        #Dynammic programming: O(N) time, O(n) space
        store = [None]*(n+2)
        store[0], store[1], store[2] = 0,1,2
        if(n<3):
            return store[n]
        for i in range(3,n+1):
            store[i]=store[i-1]+store[i-2]
        
        return store[n]
```

Here we just downsized our calculations from 2^n to just n.
#### Why does this matter?
Say n=35.
- in recursive solution, we were doing 2^n = 2^35 = around 34.36 million computations
- in the DP approach, we're just doing 35 calculations (since array retrieval is O(1))

That's an amazing improvement!

### Special notes:
- You should always look to cache only what's needed i.e. subproblem solution
- Make sure you USE the cached solutions


## Questions 
- Climbing Stairs
- Coin Change
- Longest Increasing Subsequence
- Longest Common Subsequence
- Word Break Problem
- Combination Sum
- House Robber and House Robber II
- Decode Ways
- Unique Paths
- Jump Game

## Contributing
Pull requests are welcome!

## Contact
- E-mail: shiv.suhane@gmail.com
- [LinkedIn](https://www.linkedin.com/in/shivansh-suhane/)the 