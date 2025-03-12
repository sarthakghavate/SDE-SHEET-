package Greedy;
// https://chatgpt.com/share/67d13296-b4d8-8006-8fb2-5928ca74cfbe
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CustomSorting {
    public static void main(String[] args) {
        List<int []> list = new ArrayList<>();
        list.add(new int[]{1,3});
        list.add(new int[]{2,5});
        list.add(new int[]{4,2});
        list.add(new int[]{8,7});

        // Q : Sort list in ascending order according to second value in array
        // Using Comparator.compareInt()
        list.sort(Comparator.comparingInt(a -> a[1]));
        // Using Collections.sort() with lambda expression
        list.sort((a, b) -> Integer.compare(a[1], b[1]));

        // Q : Sort list in descending   order according to second value in array
        // Using Comparator.compareInt()
        list.sort(Comparator.comparingInt(a -> a[1]));
        Collections.reverse(list);
        // Using Collections.sort() with lambda expression
        list.sort((a, b) -> Integer.compare(b[1], a[1]));

    }
}
