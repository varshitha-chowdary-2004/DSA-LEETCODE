class Solution {
    public class Triplet implements Comparable<Triplet>{
        ListNode node;
        
        Triplet(ListNode node){
            this.node  = node;
        }
        public int compareTo(Triplet t){
            return this.node.val - t.node.val; 
        }
    }
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0) return null;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=null) pq.add(new Triplet(arr[i]));
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(pq.size()>0){
            Triplet t = pq.remove();
            if(t.node.next!=null) pq.add(new Triplet(t.node.next));
            temp.next = t.node;
            temp = temp.next;
        }
        return head.next;
    }
}