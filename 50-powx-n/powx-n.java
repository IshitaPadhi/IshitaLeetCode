class Solution {
    public double myPow(double x, int n) {
        //x is the base number and n is the number 
        double ans=1.0;
        long  nn= n;//storing the original n
        if(nn<0) nn=-1*nn; //if power is -ve we make it positive by mult with -1
        while(nn>0){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }else{
                x=x*x;
                nn=nn/2;
            }
        }
        if(n<0) ans=(1.0)/ans;
        return ans;

    }
}