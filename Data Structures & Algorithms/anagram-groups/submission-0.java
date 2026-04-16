class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean visited[] = new boolean[strs.length];
        List<List<String>> mainList = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            if(!visited[i]){
                visited[i] = true;
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                pushSimilarAnagrams(mainList, list, visited, strs[i], strs);
            }
        }
        return mainList;
    }
    public void pushSimilarAnagrams(List<List<String>> mainList, List<String> list, boolean visited[], String target, String[] strs){
        for(int i=0; i<strs.length; i++){
            if(!visited[i] && isAnagram(strs[i], target)){
                list.add(strs[i]);
                visited[i] = true;
            }
        }
        mainList.add(list);
    }
    public boolean isAnagram (String src, String target){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: src.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch: target.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        for(Character ch: map.keySet()){
            if(map.get(ch) !=0) return false;
        }
        return true;
    }
}
