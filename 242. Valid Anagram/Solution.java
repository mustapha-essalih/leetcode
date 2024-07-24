class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        String sorted1 = new String(s1);
        String sorted2 = new String(s2);

        if (sorted1.equals(sorted2) == true) 
        {
            return true;    
        }
        return false;
    }
}