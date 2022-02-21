import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list2 = new MyArrayList<>();
        Random g = new Random();
        for (int i = 0; i < 2;i++){
            list2.add(g.nextInt(60)+1);
        }


         list2.sort(Integer::compareTo);
        for (int i = 0; i < list2.size(); i++){
            System.out.println(list2.get(i));
        }






    }
}
