import java.util.Stack;

class Solution {
    

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        // String[] tokens = {"10","6","-"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        int val1;
        int val2;
        int res = 0;
        for (int i = 0; i < n; i++) 
        {
            if (tokens[i].equals("+")) 
            {
                val1 = stack.pop();
                val2 = stack.pop();
                res = val1 + val2;
                stack.push(res);
            }
            else if (tokens[i].equals("-")) {
                
                val1 = stack.pop();
                val2 = stack.pop();
                res =  val2 - val1;
                stack.push(res);
            }
            else if (tokens[i].equals("*")) {
                
                val1 = stack.pop();
                val2 = stack.pop();
                res = val1 * val2;
                stack.push(res);
            }
            else if (tokens[i].equals("/")) {
                
                val1 = stack.pop();
                val2 = stack.pop();
                res =  val2 / val1;
                stack.push(res);
            }
            else 
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();        
    }
}