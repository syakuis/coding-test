package io.github.syakuis.market;
import java.util.*;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-05
 */
public class OneTest {
    public static void main(String[] args) {
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
