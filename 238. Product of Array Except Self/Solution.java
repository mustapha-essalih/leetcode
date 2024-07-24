import java.util.Arrays;

class Solution {
    public  int[] productExceptSelf(int[] nums) 
    {
        int n = nums.length;
   
        int[] answer = new int[n];

        Arrays.fill(answer, 1);
        
        answer[0] =  1;
        answer[1] = nums[0];
        
        // calc the prefix
        for (int i = 2; i < n; i++) answer[i] = answer[i - 1] * nums[i - 1];

        int val = 1;

        // calc the suffic in place
        for (int i = n - 2; i >= 0; i--) 
        {
            int tmp = nums[i + 1] * val;
            val = nums[i];
            nums[i] = tmp;
        }
        
        for (int i = 0; i < n - 1; i++) nums[i] *= answer[i];
        nums[n - 1] = answer[n - 1];
        
        return nums;
    }
}