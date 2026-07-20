

public List<List<Integer>> ans=new ArrayList<>();
public int[][] alternatingParityPermutations(int n) {
  boolean used[]=new boolean[n+1];
  generate(n,new ArrayList<>(),used);//to gen all perm
  //to convert list to array
  int result[][]=new int[ans.size()][n];
  for(int i=0;i<ans.size();i++){
    for(int j=0;j<n;j++){
      result[i][j]=ans.get(i).get(j);
    }
  }
  return result;
}
void generate(int n,List<Integer> curr,boolean used[]){
  //if perm is complete
  if(curr.size()==n){
    //check for alternate parity
    if(isValid(curr)){
      ans.add(new ArrayList<>(curr));
    }
    return;
  }
  // har unused number try karo
  for(int i=1;i<=n;i++){
    if(used[i]){
      continue;
    }
    used[i]=true;
    curr.add(i);
    generate(n,curr,used);
    //backtracking
    curr.remove(curr.size()-1);
    used[i]=false;
  }
}
  public boolean isValid(List<Integer>list){
    for(int i=1;i<list.size();i++){
      if(list.get(i)%2==list.get(i-1)%2){
        return false;
      }
    }
    return true;
  }

