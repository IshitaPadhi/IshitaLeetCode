class Solution {
    public List<List<Integer>> generate(int numRows) {//O(n^2)
        List<List<Integer>> ans=new ArrayList<>();
            // Har row generate karenge
        for(int row=1;row<=numRows;row++){
            List<Integer>ansRow=new ArrayList<>();
            long val=1;
            ansRow.add(1);
             // Remaining elements nCr formula se niklenge
            for(int col=1;col<row;col++){
                // Previous value se next value calculate karo
                val = val * (row -col );
                //then we divide by col 
                val= val /col;
                ansRow.add((int)val);
            }
            ans.add(ansRow);
        }
        return ans;
        
    }
}