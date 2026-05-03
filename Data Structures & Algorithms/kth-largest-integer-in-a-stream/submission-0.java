class KthLargest {
    PriorityQueue<Integer> queue;
    int max;
    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.max = k;
        for(int i=0;i<nums.length;i++){
            this.add(nums[i]);
        }
    }
    
    public int add(int val) {
        this.queue.add(val);
        while(this.queue.size()>this.max)this.queue.poll();

        return this.queue.peek();
    }
}
