class Solution {

    public String encode(List<String> strs) {
        int len = strs.size();
        String encodedStr = "";
        for(int i=0; i<len; i++){
            encodedStr += strs.get(i)+'\u0000';
        }
        return encodedStr;
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length();

        String listStr = "";
        for(int i=0;i<n;i++){
            if(str.charAt(i)!='\u0000') listStr+=str.charAt(i);
            else{
                list.add(listStr);
                listStr = "";
            }
        }

        return list;
    }
}
