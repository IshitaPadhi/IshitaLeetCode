class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans=new ArrayList<>();
             ans.add(1);
            long val=1;
        for(int col=1;col<=rowIndex;col++){
            val=val*(rowIndex-col+1);
            val=val/col;
            ans.add((int)val);
        }
        return ans;
    }
}