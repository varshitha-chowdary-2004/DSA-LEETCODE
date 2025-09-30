class Solution {
    public class Triplet implements Comparable<Triplet>{
        int r;
        int c;
        int d;
        Triplet(int r,int c,int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
        public int compareTo(Triplet t){
            return this.d-t.d;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length,col = heights[0].length;
        int[][] diff = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                diff[i][j] = Integer.MAX_VALUE;
            }
        }
        diff[0][0] = 0;
        PriorityQueue<Triplet> q = new PriorityQueue<>();
        q.add(new Triplet(0,0,0));
        while(q.size()>0){
            Triplet top = q.remove();
            if (top.d > diff[top.r][top.c]) continue;
            if (top.r == row - 1 && top.c == col - 1) return top.d;

            //right 
            if((top.c)+1<col){
                int eff = heights[top.r][top.c] - heights[top.r][(top.c)+1];
                eff = Math.max(Math.abs(eff),top.d);
                if(diff[top.r][(top.c)+1]>eff){
                    diff[top.r][(top.c)+1]=eff;
                    q.add(new Triplet(top.r,(top.c)+1,eff));
                }
            }
            //bottom
            if((top.r)+1<row){
                int eff = heights[top.r][top.c] - heights[(top.r)+1][top.c];
                eff = Math.max(Math.abs(eff),top.d);
                if(diff[(top.r)+1][top.c]>eff){
                    diff[(top.r)+1][top.c]=eff;
                    q.add(new Triplet((top.r)+1,top.c,eff));
                }
            }
            //top
            if((top.r)-1>=0){
                int eff = heights[top.r][top.c] - heights[(top.r)-1][top.c];
                eff = Math.max(Math.abs(eff),top.d);
                if(diff[(top.r)-1][top.c] > eff){
                    diff[(top.r)-1][top.c] = eff;
                    q.add(new Triplet((top.r)-1,top.c,eff));
                }
            }
            //left
            if((top.c)-1>=0){
                int eff = heights[top.r][top.c] - heights[top.r][(top.c)-1];
                eff = Math.max(Math.abs(eff),top.d);
                if(diff[top.r][(top.c)-1]>eff){
                    diff[top.r][(top.c)-1]=eff;
                    q.add(new Triplet(top.r,(top.c)-1,eff));
                }
            }
        }
        return diff[row-1][col-1];

    }
}