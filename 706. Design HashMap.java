/**
 * LeetCode Problem: https://leetcode.com/problems/design-hashmap/
 * 
 * 💭 Thought Process:
 * - We need to design a hash map that supports put, get, and remove operations.
 * - Use an array of size 10,000 to act as the main bucket storage.
 * - Since multiple keys can map to the same index (collision), use a linked list at each index.
 * - Each bucket starts with a dummy node to simplify insert, delete, and update operations.
 * 
 * ✅ Final Approach:
 * - Use a fixed-size array of ListNode as buckets.
 * - Each bucket contains a linked list of key-value pairs.
 * - `put`: Insert new (key, value) or update if key already exists.
 * - `get`: Return value if key exists, else -1.
 * - `remove`: Remove key by skipping over the node if found.
 * - `findElement`: Returns the node just before the one with the matching key.
 * 
 * ⏱️ Time Complexity:
 * - `put`, `get`, `remove`: Average O(1), Worst-case O(n) in case of collisions
 * 
 * 🧠 Space Complexity:
 * - O(n) for the array and the linked list nodes
 * 
 * 🧪 Edge Cases:
 * - Multiple keys hashing to the same index → handled via chaining
 * - Removing the only key in a bucket → dummy node still persists
 * 
 * 📌 Notes:
 * - Dummy head nodes simplify linked list operations by avoiding special cases at the start
 */
class MyHashMap {

    ListNode[] nodes;

    public MyHashMap() {
        this.nodes = new ListNode[10000];
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);

        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);

        return prev.next != null ? prev.next.value : -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        ListNode prev = findElement(key, index);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private int getIndex(int key) {
        return key % nodes.length;
    }

    private ListNode findElement(int key, int index) {
        if(nodes[index] == null){
            return nodes[index] = new ListNode(-1, -1);
        }
        
        ListNode prev = nodes[index];
        while(prev.next != null && prev.next.key != key){
            prev = prev.next;
        }

        return prev;
    }

    private static class ListNode {
        int key, value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */