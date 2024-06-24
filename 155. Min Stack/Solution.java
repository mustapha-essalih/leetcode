import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


class MinStack {
 
    private int top;
    private List<Integer> stack;
    private List<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
        this.top = -1;
    }
    
    public void push(int val) 
    {
        if (stack.isEmpty()) {
            stack.add(val);
            minStack.add(val);
            top++;
            return ;
        }
        stack.add(val);
        if (val < minStack.get(top)) 
            minStack.add(val);    
        else
            minStack.add(minStack.get(top));
        top++;
    }
    
    public void pop() {
        if (top != -1) 
        { 
            stack.remove(top);
            minStack.remove(top);
            top--;
        }
    }
    
    public int top() {
        if (top != -1) 
            return stack.get(top);
        return -1;
    }
    
    public int getMin() {
        if (top != -1) 
        {
            return minStack.get(top);
        }
        return -1;
    }
}

public class Solution {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);

        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.top());    // return -1
        minStack.pop();
        System.out.println(minStack.getMin()); // return -2
 
 


    }
}