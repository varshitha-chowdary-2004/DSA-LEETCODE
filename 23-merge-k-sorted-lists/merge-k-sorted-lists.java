class Solution {
    public class Triplet implements Comparable<Triplet>{
        ListNode node;
        int row;
        int col;
        Triplet(ListNode node,int row,int col){
            this.node  = node;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t){
            return this.node.val - t.node.val; 
        }
    }
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0) return null;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null) pq.add(new Triplet(arr[i],i,0));
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(pq.size()>0){
            Triplet t = pq.remove();
            if(t.node.next!=null) pq.add(new Triplet(t.node.next,t.row,t.col+1));
            temp.next = t.node;
            temp = temp.next;
        }
        return head.next;
    }
}