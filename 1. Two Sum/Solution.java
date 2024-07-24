class Solution {
    public  int[] twoSum(int[] nums, int target) 
    {
        int[] indices = new int[2];
        
        Map<Integer , Integer> arrMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            arrMap.put(nums[i] , i);
        }

        for (int i = 0; i < nums.length; i++) 
        {
            int item = target - nums[i];
            if (arrMap.containsKey(item) && arrMap.get(item) != i) // not equals sam index 
            {
                indices[0] = i;
                indices[1] = arrMap.get(item);    
                return indices;
            }
        }
        return null;
    }
}