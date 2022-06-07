package io.github.syakuis.market;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-05
 */
class TwoTest {

    @Test
    void test() {
        int to = 100;
        int from = 200;
        int result = 0;
        for (; to <= from; to++) {
            int n = to;

//            List<Integer> store = new ArrayList<>();
//            store.add(n);
            int count = 1;
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
//                store.add(n);
                count++;
            }

            if (result < count) {
                result = count;
            }
        }

        System.out.println(result);
//        result.forEach(it -> System.out.print(it + " "));
    }
}
