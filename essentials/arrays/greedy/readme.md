# Greedy Methods

## Theory
 
- Design you can adopt to solve a specific group of problems: **Optimization Problems**.

## Optimization Problems
- Greedy methods are used to solve optimization problems: Problems which require minimum or maximum result within some constraints.
- A problem might have many solutions, but only some solutions are **Feasible**. The problem becomes choosing the best among feasible approach. There could be only **ONE Optimum Solution**
- If a problem require a minimum or maximum result, we define that as **Optimization Problem**
- DP, Greedy, or Branch & Bound methods work best for solving optimization problems.

## Greedy Method
- Greedy methods say that a problem should be solved in stages
- In each stage we'll consider one input from a given problemn, if that input is feasible, we'll include it in the solution
- So by includeing all the feasible inputs, we'll get an optimal solution

### Approach
```python
def greedy(arr,n):
    solution = []
    for i in range(n):
        x = select_by_criteria(arr)
        if feasible(x):
            solution += x
    return solution

```
You have your own criteria to select the best among data in each stage, then you use it. These criteria are where the greedy magic happens, choose them intelligently.



## Running Examples
We'll consider a extremely famous and widely asked problem: knapsack.

### knapsack problem
Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. **Fractional values are allowed, this is not 0-1 knapsack**

Items: { A, B, C, D, E, F, G }
Profits: { 10, 5, 15, 7, 6, 18, 3 }
Weights: { 2, 3, 5, 7, 1, 4, 1 }
Knapsack capacity: 15

**Solution**

Let's name the bag as knapsack, it's capacity is 15. The problem is the filling of this knapsack. This becomes an optimization (Maximization) problem, we want the max profit (so we're **Greedy!**)

Constaints:
1. sum(weights_chosen)<=15 
2. let x[i] be the amount we take from weights[i]; 0<=x<=1. Basically means that we can take a fraction of total objects. 

Let's create another array x = [], we'll put x[i] here.

**select_by_criteria**
We want to maximize profit. Here, one great way to select any weight whose **profit per unit weight** is maximum. We'll put these in knapsack first. 

p_per_weight = [5, 1.3, 3, 1, 6, 4.5, 3]  
We'll put all of E first, cap = 15-1 = 14

then we'll put all of A,  cap = 14-2 = 12

then we'll put all of F,  cap = 12-4 = 8

then we'll put all of C,  cap = 8-5 = 3

then we'll put all of G,  cap = 3-1 = 2

then we'll put 2/3 of B,  cap = 2-0 = 0

This will be the most optimal solution, based on greedy method.
x = (1, 2/3, 1, 0, 1, 1, 1)

Now, we'll see the profit we get.
1x10 + 2/3 x5 + 1x15 + 1x6 + 1x18 + 1x3 = 54.6
This is the maximum profit achievable under given constraints (sum(weights_chosen)<=15)

## Questions 
- Partition Labels
- Meeting Rooms II
- Employee Free Time
- Jump Game II
- Reorganize String

## Contributing
Pull requests are welcome!

## Contact
- E-mail: shiv.suhane@gmail.com
- [LinkedIn](https://www.linkedin.com/in/shivansh-suhane/)the 