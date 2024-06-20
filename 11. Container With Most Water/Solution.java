class Solution {
    public static void main(String[] args) {
        int[] height = { 1,8,6,2,5,4,8,3,7 };
       System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {

        int i = 0;
        int n = height.length - 1;
        int res1 = (n - 0) * Math.min(height[0], height[n]);
        if (height[0] < height[n])
            i = 1;
        else
            n -= 1;
        while (i < n) {
            int res2 = (n - i) * Math.min(height[i], height[n]);
            if (res1 < res2)
                res1 = res2;
            if (height[i] < height[n])
                i++;
            else
                n--;
        }
        return res1;
    }
}

