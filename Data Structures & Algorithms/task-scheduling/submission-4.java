class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        List<Task> taskList = new ArrayList<>();

        for(Map.Entry<Character,Integer> mp : map.entrySet()){
            taskList.add(new Task(mp.getKey(),mp.getValue()));
        }

        Collections.sort(taskList, (a,b) -> Integer.compare(b.count,a.count));

        int finalAns = taskList.get(0).count*(n+1) - n;

        for(int i=1;i<taskList.size();i++){
            if(taskList.get(i).count==taskList.get(0).count)finalAns++;
        }
        return Math.max(finalAns,tasks.length);
    }
}

class Task{
    char val;
    int count;

    public Task(char val, int count){
        this.val = val;
        this.count = count;
    }
}
