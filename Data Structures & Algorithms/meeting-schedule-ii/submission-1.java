/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start,b.start));
        for(Interval interval: intervals){
            if(!pq.isEmpty()){
                int minEndTime = pq.peek();
                if(interval.start>=minEndTime){
                    pq.poll();
                }
            }
            pq.add(interval.end);
        }
        return pq.size();
    }
}
