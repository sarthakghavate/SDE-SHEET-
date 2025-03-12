package Greedy;

public class NumberOfCoins {
    public static void main(String[] args) {
        int change = 49;
        int [] coins = {1,2,5,10,20,50,100,500,1000};
        System.out.println(minCoins(coins,change));
    }
    private static int minCoins(int [] coins, int change){
        int count = 0;
        for(int i = coins.length-1; i >= 0; i--){
            if(coins[i] <= change){
                count += change/coins[i];
                change %= coins[i];
            }
        }
        return count;
    }
}
