class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Character ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)-1);
        }
        for(Integer val: map.values()){
            if(val < 0 || val > 0){ return false; }
        }
        return true;
    }
}
