import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Main{

    public static void main(String[] args) 
    {
        // int[] nums = {1,1,-2,-1,-3,-2,-1 ,-3, 5  ,-3, 5, 5, 5};
         int[] nums = {4,1,-1,2,-1,2,3};
        // int[] nums = {-1 , -1};
        // int[] nums = {1,2};
        // int[] nums = {1};
        // int k = 1;
        int k = 2;
        topKFrequent(nums , k);
    }

    private static int[] topKFrequent(int[] nums, int k) 
    {
        Map<Integer,Integer> map = new HashMap<>();
        int[] rtn = new int[k];
        int n = nums.length;

        for (int i = 0; i < n; i++) 
        {
            if (!map.containsKey(nums[i]))  map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);                
        }

        List<Integer>list=new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        for (int i = 0; i < k; ++i)
            rtn[i] = list.get(i);
        return rtn;     
    }
    /* 
    In this comparator `(a, b) -> map.get(b) - map.get(a)`, the subtraction `map.get(b) - map.get(a)` effectively compares the values associated with keys `a` and `b`. 
    - If the result of `map.get(b) - map.get(a)` is negative, it means that the value associated with key `b` is less than the value associated with key `a`, implying that `b` should come before `a` in the sorted list.
    - If the result is positive, it means that the value associated with key `b` is greater than the value associated with key `a`, implying that `a` should come before `b` in the sorted list.
    - If the result is zero, it means that the values associated with keys `a` and `b` are equal, so their order relative to each other doesn't matter.
    Therefore, this comparator sorts the list in descending order based on the values associated with the keys in the map.
    */
}

