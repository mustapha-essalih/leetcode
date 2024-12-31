import java.util.Stack;

class Solution {
    

    public static void main(String[] args){
        
        // int[] temperatures = {73,74,75,71,69,72,76,73}; // 
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        // int[] temperatures = {90, 100, 100, 1001};
        dailyTemperatures(temperatures);
    }
    
    private static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length ;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 1; i < n; i++)
        {
            if(temperatures[i] > temperatures[ i - 1]){
                answer[i - 1] = 1;
                while (!stack.empty() && temperatures[stack.lastElement()] < temperatures[i]) {
                    answer[stack.lastElement()] = i - stack.pop();
                }
            }
            else
                stack.add(i - 1);
        }
        return answer;
    }

}