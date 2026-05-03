class Solution {

    public String encode(List<String> strs) {
        StringBuilder lengthSb = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String encode = "JAYSURYA";
        for(String st:strs){
            sb.append(st);
            lengthSb.append(st.length());
            lengthSb.append(" ");
        }
        lengthSb.append(encode);
        lengthSb.append(sb);
        String str = lengthSb.toString();
        System.out.println(str);
        return str;
    }

    public List<String> decode(String str) {
        String decode = "JAYSURYA";
        String[] strs = str.split(decode);

        if(strs.length<1)return new ArrayList<>();

        String[] lengthStr = strs[0].split(" ");
        String strList = "";
        if(strs.length>1){
            strList = strs[1];
        }
        
        List<String> result = new ArrayList<>();
        int current = 0;
        for(int i=0;i<lengthStr.length;i++){
            int length = Integer.parseInt(lengthStr[i]);
            result.add(strList.substring(current,current+length));
            current += length;
        }
        return result;
    }
}
