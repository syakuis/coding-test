import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int num = n;
        int result = num;

        while(num > 1) {
            num = num / m;
            result += num;
        }

        System.out.print(result);
    }
}

//import java.util.Arrays;
//    import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        Integer a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).min().getAsInt();
//
//        Integer b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();
//
//        System.out.println(a + b);
//    }
//}