class TimeMap {
    private HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";

        Integer floorKey =  map.get(key).floorKey(timestamp);
        if(floorKey==null)return "";
        
        return map.get(key).get(floorKey);
    }
}

class Pair{
    String value;
    int timeStamp;

    public Pair(String value, int timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
}
