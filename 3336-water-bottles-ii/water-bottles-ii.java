class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int numOfBottles=numBottles;
        int empties=numBottles;
        while(empties>=numExchange){
            empties-=numExchange;
            numExchange++;
            numOfBottles++;
            empties++;
        }
         return numOfBottles;
        
    }
   
}