class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> tempMap = new HashMap<>();

        for (String string : strs) 
        {
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);

            if (!tempMap.containsKey(sortedString)) 
            {
                tempMap.put(sortedString, string);
                map.put(string, new ArrayList<>());
                map.get(string).add(string);
                
            }
            else
            {
                String key = tempMap.get(sortedString);
                map.get(key).add(string);
            }
        }
        
        return new ArrayList<>(map.values());
    }
}