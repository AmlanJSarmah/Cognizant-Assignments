1. Big O notation describes how an algorithm's runtime grows with input size. It helps compare algorithm efficiency by focusing on the worst-case growth rate, ignoring constants and lower-order terms.

2. Linear search: best O(1) (first element), average O(n/2) ~ O(n), worst O(n) (last or not found). Binary search: best O(1) (middle element), average O(log n), worst O(log n).

3. Linear search is O(n) — it checks every element. Binary search is O(log n) — it halves the search space each step. Binary search is much faster for large sorted datasets.

4. Binary search is more suitable when the data is sorted and search operations are frequent, as it scales logarithmically. For small or unsorted datasets, linear search is simpler and requires no preprocessing.
