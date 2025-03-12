package Greedy;
// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        List<Integer> val = new ArrayList<>(Arrays.asList(1, 5, 7, 2, 7, 10));
        List<Integer> wt = new ArrayList<>(Arrays.asList(4, 9, 6, 3, 7, 3));
        int capacity = 24;
        System.out.println(fractionalKnapsack(val,wt,capacity));
    }
    private static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n = val.size();
        List<double []> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new double[]{i,(double)val.get(i)/wt.get(i)});
        }

        // sort the list according to valByWt or valPerWt in descending order
        // Method 1 : Using Comparator.comparing and then reversing the list
        list.sort(Comparator.comparingDouble(a -> a[1]));
        Collections.reverse(list);
        // Method 2 : Using Lambda with Collections.sort
        //Collections.sort(list,(a,b) -> Double.compare(b[1],a[1]));

        double totalWt = 0;
        int idx = 0;
        double totalVal = 0;

        while(idx < n){
            double [] arr = list.get(idx++);
            int id = (int)arr[0];
            int currWt = wt.get(id);
            int currVal = val.get(id);

            if(totalWt + currWt <= capacity){
                totalWt += currWt;
                totalVal += currVal;
            }
            else{
                totalVal += ((double)currVal/currWt)*(capacity - totalWt);
                break;
            }
        }
        return totalVal;
    }

}
