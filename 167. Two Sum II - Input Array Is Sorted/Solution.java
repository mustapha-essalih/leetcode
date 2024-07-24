class Solution {

    public static void main(String[] args) {
     
        // int[] numbers = {-1,0};
        int[] numbers = {1,2,3,4,4,9,56,90}; // test 20/23
        int target = 8;

        int[] rtn = twoSum(numbers,target);
        for (int i : rtn) {
            System.out.println(i);
        }
    }
 

    private static int[] twoSum(int[] numbers, int target) 
    {
        int pointer1 = 0;
        int pointer2 = numbers.length - 1;

        while(pointer1 < pointer2)
        {
            int result = numbers[pointer1] + numbers[pointer2];
            if (result == target) 
                return new int[]{pointer1 + 1, pointer2 + 1};
            else if(result > target) 
                pointer2--;
            else
                pointer1++;
        }
        return new int[]{0,0};
    }
}