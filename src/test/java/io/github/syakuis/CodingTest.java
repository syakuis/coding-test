package io.github.syakuis;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-05
 */
public class CodingTest {
    @Test
    void test() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = Integer.parseInt(str);

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            String sss = sc.nextLine();
            nums.add(Integer.parseInt(sss));
        }

        List<Integer> store = new ArrayList<>();
        Set<Integer> result = new HashSet<>();

        List<Integer> aNums = nums.stream().map(it -> {
            if (it < 0) {
                int num = it * -1;
                store.add(num);
                return num;
            }

            return it;
        }).sorted().collect(Collectors.toList());

        for(int i = 0; i < store.size(); i++) {
            int index = aNums.indexOf(store.get(i));

            if (index > 1) {
                result.add(aNums.get(index - 1));
            }

            result.add(store.get(i));

            if (index < aNums.size()) {
                result.add(aNums.get(index + 1));
            }
        }

        System.out.println(result.size());
    }
}
