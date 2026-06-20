class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int left = 0;
        int right = 0;
        int maxLen = 0;

        Set<Character> set = new HashSet<>(); 
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }


        return maxLen;
    }
}
