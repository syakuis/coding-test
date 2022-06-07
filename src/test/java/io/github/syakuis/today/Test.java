package io.github.syakuis.today;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-09
 */
public class Test {

    @org.junit.jupiter.api.Test
    void test() {
        String a = "abcabcdefabc";

        String[] data = a.split("");

        for (int i = 0; i < data.length; i++) {
            String item = data[i];
            int seq = 0;
            for (int x = 0; x < data.length; x++) {
                String find = data[x];
                if (Objects.equals(item, find)) {
                    seq++;
                }
            }

            if (seq > 1) {
                a = a.replace(item, "");
            }
        }

        System.out.println(a);
    }

}
