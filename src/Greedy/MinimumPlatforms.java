package Greedy;
// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int [] arr = {646, 1812, 1953, 1859, 46, 1935, 1624, 617, 1645, 628};
        int [] dep = {805, 2200, 2106, 2333, 1554, 2047, 2020, 1900, 2048, 2351};
        System.out.println(minPlatforms(arr,dep));
    }
    private static int minPlatforms(int [] arr, int [] dep){

        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;
        int i = 0, j = 0, cnt = 0, maxCount = 0;

        while(i < n){
            if(arr[i] <= dep[j]){
                cnt++;
                i++;
            }
            else{
                cnt--;
                j++;
            }
            maxCount = Math.max(maxCount,cnt);
        }
        return maxCount;
    }
}
