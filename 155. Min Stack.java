/**
 * LeetCode Problem: https://leetcode.com/problems/min-stack/
 * 
 * 💭 Thought Process:
 * - We need to track the minimum value in the stack at all times in O(1) time.
 * - Use two stacks: one for actual values (`s1`), and one for the current min at each level (`s2`).
 * - Maintain a `min` variable to hold the current minimum globally.
 * - On every push, compare the new value with `min` and push the updated min to `s2`.
 * 
 * ✅ Final Approach:
 * - `s1` stores the actual stack values.
 * - `s2` stores the minimum value at the time of each push.
 * - `min` is updated during `push()` and restored during `pop()` based on `s2.peek()`.
 * 
 * ⏱️ Time Complexity:
 * - `push`, `pop`, `top`, `getMin`: O(1)
 * 
 * 🧠 Space Complexity:
 * - O(n), where n is the number of elements pushed (due to the auxiliary stack)
 * 
 * 🧪 Edge Cases:
 * - Popping the last element → reset `min` to Integer.MAX_VALUE
 * - Pushing duplicate min values → handled by ensuring update of `s2` with each new value and checking if it's a new `min`
 * 
 * 📌 Notes:
 * - This approach duplicates min at each push in s2, simplifying restoration on pop.
 */

class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int min;

    public MinStack() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val < min){
            min = val;
        }
        s1.push(val);
        s2.push(min);
    }
    
    public void pop() {
        if(s1.size() != 0){
            s1.pop();
            s2.pop();

            if(s1.size() != 0) {
                min = s2.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */