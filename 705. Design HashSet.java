/**
 * LeetCode Problem: https://leetcode.com/problems/design-hashset/
 * 
 * 💭 Thought Process:
 * - Can't use built-in `HashSet`, so we need to design the underlying structure.
 * - Need a way to map a key to a 2D array to simulate hashing behavior.
 * - To save space, we can use inner arrays only when needed.
 * - Max key is 10^6, so we need to design a structure that supports this range efficiently in the form of a 10^3 2-Dimensional matrix.
 * 
 * ✅ Final Approach:
 * - Use a 2D boolean array `storage[buckets][bucketItems]`
 * - Split key using:
 *    - `getBucket(key)` → row index (outer array)
 *    - `getBucketItem(key)` → column index (inner array)
 * - Initialize inner arrays only when necessary
 * - Use boolean flags to represent if a key exists or not
 * 
 * ⏱️ Time Complexity:
 * - `add`, `remove`, `contains`: O(1) average time
 * 
 * 🧠 Space Complexity:
 * - Worst-case: O(n), where n is the number of inserted keys (due to lazy initialization)
 * 
 * 🧪 Edge Cases:
 * - Adding or removing the same key multiple times
 * - Handling keys at upper bound like 1_000_000
 * 
 * 📌 Notes:
 * - This implementation is based on double hashing with memory allocation for the 
     'bucketItems' array only when required.
 */

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];

    public MyHashSet() {
        this.buckets = 1001;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    private int getBucket(int key){
        return key / buckets;
    }

    private int getBucketIteam(int key){
        return key % bucketItems;
    }
    
    public void add(int key) {
        if(storage[getBucket(key)] == null){
            storage[getBucket(key)] = new boolean[bucketItems];
        }

        storage[getBucket(key)][getBucketIteam(key)] = true;
    }
    
    public void remove(int key) {
        if(contains(key)){
            storage[getBucket(key)][getBucketIteam(key)] = false;
        }
    }
    
    public boolean contains(int key) {
        if(storage[getBucket(key)] == null){
           return false;
        }
        return  storage[getBucket(key)][getBucketIteam(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */