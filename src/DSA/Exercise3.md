1. Bubble Sort repeatedly swaps adjacent elements if out of order — O(n^2). Insertion Sort builds the sorted list one element at a time by inserting into correct position — O(n^2) worst, O(n) best. Quick Sort picks a pivot, partitions around it, recurses — O(n log n) average, O(n^2) worst. Merge Sort divides in half, sorts each, merges — O(n log n) always.

2. Bubble Sort is O(n^2) in all cases. Quick Sort is O(n log n) average and O(n^2) worst-case (bad pivot choices). Quick Sort is exponentially faster on large datasets.

3. Quick Sort is preferred because it has O(n log n) average time vs Bubble Sort's O(n^2), making it drastically faster for large datasets. It also has good cache performance and can be optimized with random pivot selection.
