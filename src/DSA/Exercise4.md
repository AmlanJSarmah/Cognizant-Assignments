1. Arrays are stored as contiguous blocks of memory where each element occupies the same fixed size. The address of element i is base_address + i * element_size, enabling direct access via index. Advantages include cache locality, constant-time indexing, and low memory overhead.

2. add (at end with capacity): O(1) amortized. search (unsorted): O(n). traverse: O(n). delete (by index + shift): O(n), or O(1) if swapping with last element.

3. Arrays have fixed size — resizing requires creating a new array and copying. Insertions and deletions in the middle are O(n) due to shifting. Use arrays when size is known in advance, random access is frequent, and memory overhead must be minimal.
