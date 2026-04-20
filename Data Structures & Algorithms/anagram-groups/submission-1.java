class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);

            if(!map.containsKey(sortedStr)){
                List<String> list = new ArrayList<>();
                map.put(sortedStr, list);
            }

            map.get(sortedStr).add(str);
        }

        List<List<String>> mainList = new ArrayList<>();

        for(String key: map.keySet()){
            mainList.add(map.get(key));
        }

        return mainList;
    }
}
