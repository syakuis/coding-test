package io.github.syakuis.secret.musinsa;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-30
 */
public class CodingTest {
    Logger log = LoggerFactory.getLogger(CodingTest.class);

    private int[] solution1(int[][] price) {
        int[] answer = new int[2];

        int[] oneMinPrice = new int[8];
        int minPrice = 0;

        int count = price.length;
        for (int i = 0; i < count; i++) {
            int[] item = price[i];

            int sum = 0;

            for (int s = 0; s < 8; s++) {
                if (i == 0 || oneMinPrice[s] > item[s]) {
                    oneMinPrice[s] = item[s];
                }

                sum += item[s];
            }

            if (i == 0 || minPrice > sum) {
                minPrice = sum;
            }
        }

        answer[0] = Arrays.stream(oneMinPrice).sum();
        answer[1] = minPrice;

        return answer;
    }

    @Test
    void test1() {
        int[][] data = {{112, 55, 42, 90, 20, 17, 18, 23}, {105, 59, 38, 91, 21, 20, 20, 22}, {100, 62, 33, 92, 22, 19, 22, 21},
            {101, 51, 30, 95, 25, 15, 24, 20}, {107, 50, 38, 99, 23, 18, 21, 21}, {112, 72, 40, 93, 21, 16, 23, 19}, {105, 58, 39, 90, 22, 17, 21, 20},
            {108, 63, 31, 97, 21, 16, 20, 20}, {114, 67, 32, 95, 24, 17, 17, 24}};

        int[] expected = {341, 361};
        int[] actual = solution1(data);

        assertEquals( expected[0], actual[0]);
        assertEquals( expected[1], actual[1]);

    }
}
