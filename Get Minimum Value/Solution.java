public class Solution{
  int ans=Integer.MAX_VALUE;
public int getMinimumValue(int[] data, int maxOperations) {
  ArrayList<Integer>arr=new ArrayList<>();
  for(int x:data){
    arr.add(x);//converting array to arrayList
  }
 solve(arr,maxOperations);
  return ans; 
}
private void solve(ArrayList<Integer>arr,int OperationsLeft){
  //if all operations are done
  if(OperationsLeft==0){
    int currMin=Integer.MAX_VALUE;
    for(int x:arr){
      currMin=Math.min(currMin,x);//finding the smallest element in the array
    }
    ans=Math.min(ans,currMin);
    return;
  }
  int size=arr.size();
  //we'll try every possible pair
  for(int i=0;i<size;i++){
    for(int j=i+1;j<size;j++){
      int diff=Math.abs(arr.get(i)-arr.get(j));
      arr.add(diff);
      //solve remaining operations
      solve(arr,OperationsLeft-1);
      //backtracking we'll remove whatever we had added
      arr.remove(arr.size()-1);
    }
  }
  
}
}
