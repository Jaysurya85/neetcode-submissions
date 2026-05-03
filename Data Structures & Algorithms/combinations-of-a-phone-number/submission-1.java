class Solution {

    public void makeString(HashMap<Integer, String> map, List<String> ans, StringBuilder currentString, String digits, int current){
        if(current==digits.length()){
            ans.add(currentString.toString());
            return;
        }
        String charecters = map.get(digits.charAt(current)-'0');
        for(int i=0;i<charecters.length();i++){
            currentString.append(charecters.charAt(i));
            makeString(map,ans,currentString,digits,current+1);
            currentString.deleteCharAt(currentString.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc"); 
        map.put(3,"def"); 
        map.put(4,"ghi"); 
        map.put(5,"jkl"); 
        map.put(6,"mno"); 
        map.put(7,"pqrs"); 
        map.put(8,"tuv"); 
        map.put(9,"wxyz"); 

        List<String> ans =  new ArrayList<>();

        makeString(map, ans, new StringBuilder(), digits, 0);
        return ans;
    }
}
