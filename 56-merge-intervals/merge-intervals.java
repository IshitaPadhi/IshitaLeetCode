class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            //if previous megred interval covers the current one then we skip it for ex [1,6] already covers [2,5] toh we won't need to merge
            if(!ans.isEmpty()&& end<=ans.get(ans.size()-1)[1]) //most recent ka we want to compare the end 
            {continue;
            }
            for(int j=i+1;j<n;j++){
                //if there is an overlap then update the end
                if(intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);

                }else{
                    //if there is not overlap then break
                    break;
                }

            }
            //we'll add the final merged interval to the ans list
            ans.add(new int[]{start,end});
            
            
        }

    // List<int[]> ko int[][] mein convert kar do
        return ans.toArray(new int[ans.size()][]);
    }
}