public boolean hasPermission(String[] roles, String[] parents, String[][] allowLists, String[][] denyLists, String role, String permission) {
  String currentRole=role;//current role
  //till we don't reach to the rote
  while(!currentRole.equals("")){
    int index=-1;
    for(int i=0;i<roles.length;i++){
      if(roles[i].equals(currentRole)){
        index=i;
        break;
      }
    }
    for(String p:denyLists[index]){//first check the deny list 
      if(p.equals(permission)){
        return false;
      }
    }
    for(String p:allowLists[index]){//then check the allow list
      if(p.equals(permission)){
        return true;
      }
    }
    //if we did not find the permission then we will move to parent
    currentRole=parents[index];
  }
  return false;
  
}
