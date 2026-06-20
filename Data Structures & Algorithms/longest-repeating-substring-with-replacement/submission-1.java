class Solution {
    public int characterReplacement(String s, int k) {
          int left = 0;
          int right = 0;
          int longSub = 1;
          int maxFreq = 0;

          Map<Character, Integer> map = new HashMap<>();

          while(right < s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

            while((right-left+1 - maxFreq) > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }

            longSub = Math.max(longSub, right-left+1);
            right++;
          }


          return longSub;
    }

    // public int maxFreq(Map<Character,Integer> map){
    //     int max = 0;
    //     for(Map.Entry<Character, Integer> entry: map.entrySet()){
    //         max = Math.max(max, entry.getValue());
    //     }

    //     return max;
    // }
}
