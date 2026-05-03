class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++){
            queue.add(stones[i]);
        }
        while(!queue.isEmpty()){
            int first = queue.poll();
            if(queue.isEmpty())return first;
            int second = queue.poll();
            if(first==second)continue;
            queue.add(Math.abs(first-second));
        }
        return 0;
    }
}
