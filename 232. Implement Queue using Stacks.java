/**
 * LeetCode Problem: https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * 💭 Thought Process:
 * - We need to build a queue (FIFO) using only stacks (LIFO).
 * - Use two stacks: one (`s1`) for incoming elements, and another (`s2`) for outgoing elements.
 * - When popping or peeking, move elements from `s1` to `s2` only if `s2` is empty.
 * - This way, the front of the queue ends up on top of `s2`.
 * 
 * ✅ Final Approach:
 * - `push(x)`: Always push to `s1`
 * - `pop()`: If `s2` is empty, move all elements from `s1` to `s2`, then pop
 * - `peek()`: Same as `pop()` but return `peek()` instead
 * - `empty()`: Return true only if both stacks are empty
 * 
 * ⏱️ Time Complexity:
 * - `push`: O(1)
 * - `pop`, `peek`: Amortized O(1), worst-case O(n) when transferring
 * - `empty`: O(1)
 * 
 * 🧠 Space Complexity:
 * - O(n), where n is the number of elements in the queue
 * 
 * 🧪 Edge Cases:
 * - Multiple pop() or peek() calls will work correctly without moving elements again, as long as s2 still has elements.
 * 
 * 📌 Notes:
 * - This transfer approach ensures each element is moved at most once from `s1` to `s2`
 */

 class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();    
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */