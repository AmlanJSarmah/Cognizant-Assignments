1. Recursion is a technique where a function calls itself to solve a smaller instance of the same problem. It simplifies problems that can be broken into identical sub-problems (e.g., tree traversal, Fibonacci, future value calculation) by expressing the solution directly in terms of itself.

2. The recursive future value algorithm makes exactly n recursive calls, each doing O(1) work. Time complexity is O(n). Space complexity is also O(n) due to the call stack.

3. This specific problem can be optimized by using an iterative loop (O(n) time, O(1) space) or the direct formula FV = PV * (1 + rate)^n using `Math.pow()` (O(1) time). For more complex recursions (e.g., Fibonacci), memoization stores previously computed results to avoid redundant calls.
