class Solution {
    public int[][] merge(int[][] intervals) {//nlogn for sorting +O(n^2), sc is O(n)
        int n=intervals.length;
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ans.add(new int[]{intervals[0][0],intervals[0][1]}); 
        //add the first interval in the list to avoid nested loops then start from the second merged list
            for(int i=1;i<n;i++){
                //current interval
                int start=intervals[i][0];
                int end=intervals[i][1];
                 // Answer list ka last merged interval
                int []lastMerged=ans.get(ans.size()-1);
                //if there is an overlap like (1,3) and (2,6) then we will merge it (1,6)
                if(start<=lastMerged[1]){
                    // End ko jitna bada ho utna update kar do
                    lastMerged[1]=Math.max(end,lastMerged[1]);
                }else{
                    //if there is no overlap we add it in the final list
                    ans.add(new int[]{start,end});
                }
 
            }
           
              // List<int[]> ko int[][] mein convert kar do
        return ans.toArray(new int[ans.size()][]);
            
        }

  
    }
