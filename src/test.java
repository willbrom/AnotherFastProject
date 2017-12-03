
import java.util.ArrayList;
import java.util.Random;

public class test {

    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static Random random = new Random();
    private static int randNum;
    private static int count = 0;

    public static void main(String[] args) {
        randNum = random.nextInt(7);
        while (arrayList.size() < 7) {
            if (!arrayList.contains(randNum))
                arrayList.add(randNum);
            else
                randNum = random.nextInt(7);
        }

        while (arrayList.contains(randNum)) {
            randNum = random.nextInt(8);
        }
//
//        for (int i : arrayList) {
//            System.out.println(i);
//        }
    }
}
