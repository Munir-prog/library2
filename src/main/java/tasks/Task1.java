package tasks;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {


        List<Integer> list = List.of(1, 3, 5, 6, 7, 2, 4, 8, 9);
        var integers = sortToOdd(list);
        System.out.println(integers);


        var integers1 = List.of(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);

        var i = countUnique(integers1);
        System.out.println(i);

    }

    private static int countUnique(List<Integer> integers1) {
        return new HashSet<>(integers1).size();
    }

    public static List<Integer> sortToOdd(List<Integer> list){
        List<Integer> result = new ArrayList<>(list);
        for (Integer integer : list) {
            if (integer % 2 != 0){
                result.add(integer);
            }
        }
        return result;
    }

}
