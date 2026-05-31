class Solution {

    public String encode(List<String> strs) {
        //We will use string builder for O(n) performance.
        StringBuilder str = new StringBuilder();
        for(String s: strs){
            str.append(s.length()).append('#').append(s);
        }

        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while(i<str.length()){
            int j = i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            i = j+1;

            String word = str.substring(i, i+len);
            list.add(word);

            i = i+len;
        }

        return list;
    }
}
