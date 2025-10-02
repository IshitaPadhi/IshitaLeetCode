class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numOfBottles=numBottles;
        while(numBottles>=numExchange){
            int t = numBottles/numExchange;
            int rem = numBottles % numExchange;
            numOfBottles+=t;
            numBottles=t+rem;

        }
        return numOfBottles;
    }
}