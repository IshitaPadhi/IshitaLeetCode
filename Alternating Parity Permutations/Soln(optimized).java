public List<List<Integer>> ans=new ArrayList<>();
public int[][] alternatingParityPermutations(int n) {
  ans.clear();
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
 if(curr.size()==n){
   ans.add(new ArrayList<>(curr));
   return;
 }
        // 1 se n tak loop -> lexicographical order maintain rahega
  for(int i=1;i<=n;i++){
    if(used[i]){
      continue;
    }
    //if first element we will take it directly if not then we will compare last
    //element's partity with the current element
    if(curr.size()==0 || curr.get(curr.size()-1)%2!=i%2){
      used[i]=true;
      curr.add(i);
      generate(n,curr,used);
      curr.remove(curr.size()-1);
      used[i]=false;
    }
    
  }
  
}

