import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Solution
 */
public class Solution {

    
    public static void main(String[] args) 
    {
        int[] nums = {100,4,200,1,3,2};
        // int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        // int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConsecutive(nums));
    }

    
    private static int longestConsecutive(int[] nums) 
    {
        Map<Integer,Integer> map = new TreeMap<>();
        int n = nums.length;
        
        if(n <= 1) return n;

        for (int i = 0; i < n; i++) map.put(nums[i] , nums[i]);

      
        int len = 1;
        int tmp = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet())  
        {
            if (map.containsKey(entry.getKey() + 1)) 
            {
                len++;
            }
            else
            {
                if (tmp < len)   
                    tmp = len;
                len = 1;
            }
        }
        len = len >= tmp ? len : tmp;
        return len;
    }
}



