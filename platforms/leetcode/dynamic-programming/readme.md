# Dynamic programming

Generally speaking,
dynamic programming is the technique of storing repeated
computations in memory, rather than recomputing them every
time you need them. The ultimate goal of this process is to
improve runtime. Dynamic programming allows you to use
more space to take less time.

Dynamic programming is only possible if we have underlying repeated computations which in-turn can be only possible by having:
* Optimal sub-structure: 
Optimal substructure requires that you can solve a problem
based on the solutions of subproblems. For example, if you
want to calculate the 5th Fibonacci number, it can be solved by
computing fib(5) = fib(4) + fib(3).
* Overlapping sub-problems: Overlapping subproblems means that when you split your
problem into subproblems, you sometimes get the same
subproblem multiple times. With the Fibonacci example, if
we want to compute fib(5), we need to compute fib(4) and
fib(3). However, to compute fib(4), we need to compute fib(3)
again. This is a wasted effort, since we’ve already computed the
value of fib(3).

All DP Problems have these 2^ underlying criteria. Hence, All dynamic programming problems are therefore, quite similar.

There's somewhat of a general process to solve DP problems: 
1) Find repeated work
2) Eliminate repeated work by using Memoization

Yeah yeah, no crap repeated work's gotta go. In DP, a good strategy is: 
* First/Bruteforce Solution
* Analyzing the ^ solution
* Subproblems/sub-structure identification
* Turning the solution

or, FAST method. 

Good, succinct theory can be found at:
www.dynamicprogrammingbook.com

This list will be updated constantly. 

## Practice problems:

These are the ones I did: 

Easies: 
1) Fibonacci numbers (LC#509)
2) Maximum subarray (LC#53) 
3) Best day to buy/sell stocks (LC #121) 
4) Climbing stairs (LC #70)

Mediums: 
1) Longest Palindromic Substring (LC #5)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

More succinct theory is always appreciated. 

## License
[MIT](https://choosealicense.com/licenses/mit/)
