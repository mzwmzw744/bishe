package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zushu = sc.nextInt();
        List<Test4> list = new ArrayList();
        while (zushu-- > 0) {
            Test4 test4 = new Test4();
            int jiao = sc.nextInt();
            double min = jiao/4.0;
            int min1 = jiao/4;
            double max = jiao/2.0;
            int max1 = jiao/2;
            if((min != min1 && max!=max1) || jiao%2 != 0) {
                test4.setOne(0);
                test4.setTwo(0);
                list.add(test4);
                continue;
            }
            int shu1 = (jiao - 4*min1)/2+min1;
            int shu2 = (jiao - 2*max1)/2+max1;
            test4.setOne(shu1);
            test4.setTwo(shu2);
            list.add(test4);
        }
        for( Test4 t : list ) {
            System.out.println(t.getOne()+" "+t.getTwo());
        }
    }
}
 class Test4{
        int one;
        int two;

        public int getOne() {
            return one;
        }

        public void setOne(int one) {
            this.one = one;
        }

        public int getTwo() {
            return two;
        }

        public void setTwo(int two) {
            this.two = two;
        }
}
