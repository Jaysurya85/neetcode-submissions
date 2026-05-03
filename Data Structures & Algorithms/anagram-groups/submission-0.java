class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
           char[] str = strs[i].toCharArray();
           Arrays.sort(str);
           String sortedStr = Arrays.toString(str);
           System.out.println(sortedStr);
           if(!map.containsKey(sortedStr))map.put(sortedStr,new ArrayList<>());
           map.get(sortedStr).add(strs[i]); 
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> mp: map.entrySet()){
            ans.add(mp.getValue());
        }
return ans;
    }
}
