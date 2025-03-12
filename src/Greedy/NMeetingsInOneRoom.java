package Greedy;
// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int [] start = {1, 3, 0, 5, 8, 5};
        int [] end=  {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start,end));
    }
    public static int maxMeetings(int [] start, int [] end) {
        // Create pairs of start and end time
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            list.add(new int[]{start[i],end[i]});
        }

        // now use comparator to sort by end time
        list.sort(Comparator.comparingInt(a -> a[1]));

        // Now write meeting allocation logic

        int cnt = 1;
        int [] first = list.get(0);
        int prevEndTime = first[1];

        for(int i = 1; i < start.length; i++){
            int [] curr = list.get(i);
            if(curr[0] > prevEndTime){
                cnt++; // increment count
                prevEndTime = curr[1];
            }
        }
        return cnt;
    }
}
