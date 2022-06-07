package io.github.syakuis.secret.musinsa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-30
 */
public class Coding2Test {
    Logger log = LoggerFactory.getLogger(Coding2Test.class);

    public String[] solution(String[][] friends, String user_id) {
        int count = friends.length;

        Map<String, Set<String>> table = new HashMap<>();

        for (int i =0; i < count; i++) {
            String left = friends[i][0];
            String right = friends[i][1];
            if (table.containsKey(left)) {
                table.get(left).add(right);
            } else {
                Set<String> leftSet = new HashSet<>();
                leftSet.add(right);
                table.put(left, leftSet);
            }
        }

        Set<String> myFriend = table.get(user_id);
        List<String> newFriend = new ArrayList<>();

        for (String key : table.keySet()) {
            if (myFriend.contains(key)) {
                for(String key2 : table.keySet()) {
                    if (table.get(key).contains(key2)) {
                        newFriend.add(key2);
                    }
                }
            }
        }

        myFriend.forEach(o -> newFriend.addAll(table.get(o)));

        newFriend.remove(user_id);
        newFriend.removeAll(myFriend);
        Collections.sort(newFriend);

        log.debug("{}", table);
        log.debug("{}", myFriend);
        log.debug("{}", newFriend);

        return newFriend.toArray(new String[0]);
    }

    @Test
    void test() {
        String[][] data = {{"david","demi"},{"frank", "demi"},{"demi", "james"}};
        String[] expected = {"david", "james"};
        String[] actual = solution(data, "frank");

        assertArrayEquals(expected, actual);
    }

    @Test
    void test2() {
        String[][] data2 = {{"david","frank"},{"demi", "david"},{"frank", "james"},{"demi", "james"},{"claire", "frank"}};

        String[] expected2 = {"james"};
        String[] actual2 = solution(data2, "david");

        assertArrayEquals(expected2, actual2);
    }
}
