/**
 * A custom implementation of a Min Heap using a 1-indexed array.
 * 
 * 💭 Thought Process:
 * - A Min Heap maintains the invariant that every parent is less than or equal to its children.
 * - We use an array to store the heap, starting at index 1 to make parent/child indexing simple.
 * - For any node at index i:
 *    - Parent = i / 2
 *    - Left child = 2 * i
 *    - Right child = 2 * i + 1
 * - Insertion pushes the new element up if it's smaller than its parent.
 * - Removal of the min element (the root) replaces the root with the last element,
 *   then pushes it down to restore the heap property.
 *
 * ✅ Final Approach:
 * - Maintain `Heap[]`, `size`, and `maxSize`.
 * - Use `minHeapify` to restore order after removal or construction.
 * - Insert elements by appending and bubbling up as needed.
 * - Swap nodes where necessary to ensure min-heap structure.
 * 
 * ⏱️ Time Complexity:
 * - Insertion: O(log n)
 * - Deletion (remove): O(log n)
 * - Heapify: O(log n)
 * 
 * 🧠 Space Complexity:
 * - O(n) for storing the heap in an array.
 * 
 * 🧪 Edge Cases:
 * - Trying to insert into a full heap is ignored.
 * - Removing from an empty heap (if handled) would need extra guard logic.
 * 
 * 📌 Notes:
 * - Index 0 is unused and initialized to Integer.MIN_VALUE as a dummy value.
 * - Class uses 1-based indexing for simpler parent-child relationships.
 */
class minHeap{
    
    private int[] Heap;
    private int size;
    private int maxSize;

    // First valid index from where we start storing our heap elements
    private static final int FRONT = 1;

    // Initialise minHeap instance
    public minHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // Returns the position of the parent
    private int parent(int pos){
        return pos/2;
    }

    // Returns the position of the left child
    private int leftChild(int pos){
        return (pos*2);
    }

    // Returns the positon of the right child
    private int rightChild(int pos){
        return (pos*2) + 1;
    }

    // Return if the element is a leaf node(has no children)
    private boolean isLeaf(int pos){
        return pos > (size/2) ? true : false;
    }

    // Swaps the elements on position 1 and 2
    private void swap(int pos1, int pos2){
        int temp = Heap[pos2];
        Heap[pos2] = Heap[pos1];
        Heap[pos1] = temp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = pos;

            boolean hasLeft = left <= size;
            boolean hasRight = right <= size;

            // Find the smallest among pos, left, right
            if (hasLeft && Heap[left] < Heap[smallest]) {
                smallest = left;
            }
            if (hasRight && Heap[right] < Heap[smallest]) {
                smallest = right;
            }

            // If a smaller child is found, swap and recurse
            if (smallest != pos) {
                swap(pos, smallest);
                minHeapify(smallest);
            }
        }
    }

    private void insert(int element){
        if(size >= maxSize){
            return;
        }

        Heap[++size] = element;
        int current = size;

        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Removes the Root of the tree
    private int remove(){
        int min = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return min;
    }

    private void print(){
        System.out.println("Current MinHeap elements are: ");
        for(int i = FRONT; i <= size/2; i++){
            System.out.print("Parent: " + Heap[i]);
            System.out.print("; Left Child : " + Heap[i * 2]);
            System.out.println("; Right Child : " + Heap[(i * 2) + 1]);
        }
    }

    public static void main(String[] arg){
        minHeap heap = new minHeap(15);

        heap.insert(15);
        heap.insert(23);
        heap.insert(17);
        heap.insert(12);
        heap.insert(81);
        heap.insert(21);
        heap.insert(2);
        heap.insert(23);
        heap.insert(8);

        // Print all elements of the heap
        heap.print();

        System.out.println("The Min val is " + heap.remove());

    }

}