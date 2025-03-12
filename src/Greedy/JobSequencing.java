package Greedy;
// https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
import java.util.*;

public class JobSequencing {
    public static void main(String[] args) {
        int [] id = {1, 2, 3, 4};
        int [] deadline = {4, 1, 1, 1};
        int [] profit ={20, 1, 40, 30};
        System.out.println(jobSequencing(id,deadline,profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] id, int[] deadline, int[] profit) {
        // we need to perform tasks with early deadline first
        // so sort deadline and profit according to deadline
        int n = deadline.length;
        int maxDead = -1;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            maxDead = Math.max(maxDead,deadline[i]);
            list.add(new int[]{id[i],deadline[i],profit[i]});
        }

        list.sort(Comparator.comparingInt(a -> a[2]));
        Collections.reverse(list);

        int cnt = 0, totalProfit = 0;
        int [] arr = new int[maxDead + 1];
        Arrays.fill(arr,-1);

        for(int [] a : list){
            int jid = a[0];
            int dl =  a[1];
            int prt = a[2];
            int poss = isPossible(arr,dl);
            if(poss != -1){
                cnt++;
                totalProfit += prt;
                arr[poss] = jid;
            }
        }
        return new ArrayList<>(Arrays.asList(cnt,totalProfit));
    }

    private static int isPossible(int [] arr, int dl){
        for(int i = dl; i > 0; i--){
            if(arr[i] == -1){
                return i;
            }
        }
        return -1;
    }
}
