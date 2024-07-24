class Solution {

    public static void main(String[] args) 
    {
        // String s = "A man, a plan, a canal: Panama"; // true
        // String s = "radar"; // true
        // String s = "0P";
        String s = "0P";
        System.out.println(isPalindrome(s));
        
    }

    public static boolean isPalindrome(String s) {
        
        int pointerOne = 0;
        int pointerTwo = s.length() - 1;
        s = s.toLowerCase();
        
        if (s.isBlank())
            return true;
        while (pointerOne < pointerTwo) 
        {
            while (!isAlphanumericCharacter(s.charAt(pointerOne)) && pointerOne < pointerTwo) pointerOne++;
            while (!isAlphanumericCharacter(s.charAt(pointerTwo)) && pointerOne < pointerTwo) pointerTwo--;
        
            if (s.charAt(pointerOne) == s.charAt(pointerTwo)) 
            {
                pointerOne++;
                pointerTwo--;
            }
            else return false;
        }        
        
        return pointerTwo == s.length() - 1 && pointerOne == s.length() ? false : true;
    }
    private static boolean isAlphanumericCharacter(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
}

 