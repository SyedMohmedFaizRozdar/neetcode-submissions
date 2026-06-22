class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map1 = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        String result = "";
        int left = 0;
        Map<Character, Integer> map2 = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            map2.put(rChar, map2.getOrDefault(rChar, 0) + 1);

            while (containsAllChars(map1, map2)) {
                if (result.isEmpty() || (right - left + 1) < result.length()) {
                    result = s.substring(left, right + 1);
                }

                char lChar = s.charAt(left);
                map2.put(lChar, map2.get(lChar) - 1);
                left++;
            }
        }

        return result;
    }

    public boolean containsAllChars(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (entry.getValue() > map2.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}