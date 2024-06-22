
public class Solution {

    public static void main(String[] args) {
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height = {4,2,0,3,2,5}; // 4,2,0,3,2,5 4,2,3
        int[] height = { 4, 2, 3 }; // 4,2,0,3,2,5 4,2,3
        trap(height);
    }

    private static int trap(int[] height) 
    {
        int n = height.length;
        int water = 0;

        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on   left of current element
            int maxLeft = height[i];
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find maximum element on   right of current element
            int maxRight = height[i];
            for (int j = i + 1; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // the algo 
            water += Math.min(maxLeft, maxRight) - height[i];
        }
        return water;
    }

}
