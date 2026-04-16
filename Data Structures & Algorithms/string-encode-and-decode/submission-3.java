class Solution {

    public String encode(List<String> strs) {
        String str="";
        for(int i=0;i<strs.size();i++){
            str+=strs.get(i)+'\0';
        }
        return str;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        String newStr="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='\0'){
                list.add(newStr);
                newStr="";
            }else{
                newStr+=str.charAt(i);
            }
        }
        return list;
    }
}
