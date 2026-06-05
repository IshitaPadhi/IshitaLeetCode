import java.util.*;

class Solution {
     ArrayList<Integer> arr;

    public void initializeHeap() {
         arr = new ArrayList<>();
    }

    public void insert(int key) {
        arr.add(key);
        int x=arr.size()-1;
        while(x>0){
            int par = (x-1)/2;
            if(arr.get(x)>arr.get(par)){
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x=par;

            }else{
                break;
            }
        }
    }

    public void changeKey(int index, int newVal) {
        int oldVal=arr.get(index);
        arr.set(index,newVal);
        if(newVal>oldVal){
            while(index>0){
                int par=(index-1)/2;
                if(arr.get(index)>arr.get(par)){
                    int temp=arr.get(index);
                    arr.set(index,arr.get(par));
                    arr.set(par,temp);
                    index=par;
                }else{
                    break;
                }
            }
        }else{
             heapify(index);
        }

        
    }

    private void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<arr.size() && arr.get(maxIdx)<arr.get(left)){
            maxIdx=left;
        }
        if(right <arr.size() && arr.get(maxIdx)<arr.get(right)){
            maxIdx=right;
        }
        if(maxIdx!=i){
            //swap
            int temp=arr.get(i);
            arr.set(i,arr.get(maxIdx));
            arr.set(maxIdx,temp);
            heapify(maxIdx);
        }

    }

    public int  extractMax() {
        int data=arr.get(0);
        //swap first and last 
        int temp=arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1,temp);
        //delete last 
        arr.remove(arr.size()-1);
        //heapfy 
        heapify(0);
        return data;

        
    }

    public boolean isEmpty() {
        return arr.size()==0;

        
    }

    public int getMax() {
        return arr.get(0);
       
    }

    public int heapSize() {
        return arr.size();
    }
}
