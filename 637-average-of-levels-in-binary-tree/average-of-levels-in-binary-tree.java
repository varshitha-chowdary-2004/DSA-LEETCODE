class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public void NthLevel(TreeNode root,List<Integer> arr,int lvl,int l){
        if(root==null) return ;
        
        if(l==lvl){
            arr.add(root.val);
            return;
        }
        NthLevel(root.left,arr,lvl,l+1);
        NthLevel(root.right,arr,lvl,l+1);
    }
    public double getSum(List<Integer> arr){
        double sum =0;
        for(double ele:arr){
            sum+=ele;
        }
        return sum;
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i=0;i<lvl;i++){
            List<Integer> arr = new ArrayList<>();
            NthLevel(root,arr,i,0);
            double sum = getSum(arr);
            Double x = sum/arr.size();
            ans.add(x);
        }
        return ans;

    }
}