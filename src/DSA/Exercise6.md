1. Linear search scans each element sequentially until the target is found — simple, works on any data. Binary search repeatedly divides a sorted array in half, comparing the middle element to the target — much faster but requires sorted data.

2. Linear search: O(n) time in worst and average cases. Binary search: O(log n) time in all cases (best O(1) if middle element matches).

3. Use linear search for small datasets (n < ~100) or unsorted data where sorting overhead isn't worth it. Use binary search for large sorted datasets where the O(log n) performance provides significant speedup over O(n).
