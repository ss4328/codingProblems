# 0/1 Knapsack

## Problem:
Write a program that selects a subset of items that has a **maximum value** and satisfies a given weight constraint. **We cannot take fractional objects**

Weights: {5, 3, 4, 2}
Profits: {60, 50, 70, 30}
Knapsack capacity: 5

## Solution:
if we were allowed to split the set, we'd essentially find p/w of all, sort it in decreasing order, and stop when capacity<=cur_weight (split it when this might happen to fully fill knapsack). However, that's the greedy solution and described more in the greedy folder as a running example. However, we can't do that here as we can't split items(given constraint). We need to think little more. 

### Bruteforce
- Make a set of all the subsets of the given sets. 
- Do a complete search to find the subset with max profit value. 

however, this is **O(2^n)** so exponential complexity. 


### Dynammic programming approach. 

We use dynammic programming here as it's an optimization problem. 
- In dynammic programming, we solve by considering decision at stages.

If we try each combination it's 2^n combinations for n elements.
- We could do this problem via a sort of tabulation method. 

### Approach
```python
 

```

## Contributing
Pull requests are welcome!

## Contact
- E-mail: shiv.suhane@gmail.com
- [LinkedIn](https://www.linkedin.com/in/shivansh-suhane/)the 