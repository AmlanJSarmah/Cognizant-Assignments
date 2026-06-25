1. Singly Linked List: each node has data and a pointer to the next node; traversal is one-directional. Doubly Linked List: each node has pointers to both next and previous nodes, allowing bidirectional traversal but using more memory.

2. add (at end): O(n) without tail pointer, O(1) with tail. search: O(n). traverse: O(n). delete (by value): O(n) to find, O(1) to remove once found.

3. Linked lists grow and shrink dynamically with no fixed size limit. Insertions and deletions (once positioned) are O(1) vs O(n) for arrays. No wasted memory from pre-allocation. Better for frequent insertions/deletions where random access is not needed.
