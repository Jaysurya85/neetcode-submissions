class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Point> queue = new PriorityQueue<>((a,b) -> {
            int aDiss = a.x*a.x + a.y*a.y;
            int bDiss = b.x*b.x + b.y*b.y;
            return Integer.compare(aDiss,bDiss);
        });

        for(int i=0;i<n;i++){
            Point point = new Point(points[i][0],points[i][1]);
            queue.add(point);
        }

        int[][] ans = new int[k][2];
        int ind = 0;

        while(!queue.isEmpty() && ind<k){
            Point point = queue.poll();
            ans[ind][0] = point.x;
            ans[ind][1] = point.y;
            ind++;
        }
        return ans;
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
