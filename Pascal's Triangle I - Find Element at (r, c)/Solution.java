class Solution {
    public int findncr(int n,int r){
        int res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);

        }
        return res;
    }
    public int pascalTriangleI(int r, int c) {
        return findncr((r-1),(c-1));

    }
}
