package io.github.syakuis.market;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-06
 */
public class CoTest {

    @Test
    void test() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Integer a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).min().getAsInt();

        Integer b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();

        System.out.println(a + b);



    }
}
