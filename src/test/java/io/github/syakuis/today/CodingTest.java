package io.github.syakuis.today;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-09
 */
class CodingTest {

    private enum Direction {
        E {
            String go(Direction s) {
                if (Direction.S == s) {
                    return "right";
                }

                if (Direction.N == s) {
                    return "left";
                }

                return null;
            }
        }, S {
            String go(Direction s) {
                if (Direction.W == s) {
                    return "right";
                }

                if (Direction.E == s) {
                    return "left";
                }

                return null;
            }
        }, N {
            String go(Direction s) {
                if (Direction.E == s) {
                    return "right";
                }

                if (Direction.W == s) {
                    return "left";
                }

                return null;
            }
        }, W {
            String go(Direction s) {
                if (Direction.N == s) {
                    return "right";
                }

                if (Direction.S == s) {
                    return "left";
                }

                return null;
            }
        };

        abstract String go(Direction s);
    }


    private String[] solution(String path) {
        List<Navigation> street = new LinkedList<>();

        String[] data = path.split("");
        Direction direction = null;
        int seq = 0;
        for (int i = 0; i < data.length; i++) {
            String item = data[i];
            Direction aDirection = Direction.valueOf(item);
            if (direction == null || aDirection == direction) {
                seq++;
            } else {
                street.add(new Navigation(direction, seq, aDirection));
                seq = 1;
            }

            if (i == data.length -1) {
                street.add(new Navigation(direction, seq, null));
            }

            direction = aDirection;
        }

        int go = 0;
        List<String> result = new ArrayList<>();
        for (Navigation navigation : street) {
            go += navigation.street;
            if (navigation.street > 5 && navigation.nextDirection != null) {
                result.add(navigation.getMessage(go - 5, 5));
                continue;
            }

            if (navigation.nextDirection != null) {
                result.add(navigation.getMessage(go - navigation.street, navigation.street));
            }
        }

        System.out.println(result);

        return result.toArray(new String[0]);
    }

    @Test
    void test() {
        solution("SSSSSSWWWNNNNNN");
//        assertEquals(new String[]{"Time 0: Go straight 300m and turn right", "Time 3: Go straight 100m and turn left", "Time 5: Go straight 500m and turn left"}, solution("EEESEEEEEENNNN"));
    }


    class Navigation {
        private final Direction direction;
        private final int street;
        private final Direction nextDirection;

        public Navigation(Direction direction, int street, Direction nextDirection) {
            this.direction = direction;
            this.street = street;
            this.nextDirection = nextDirection;
        }

        public String getMessage(int time, int go) {
            return "Time " + time + ": Go straight " + go * 100 + "m and turn " + Direction.valueOf(direction.name()).go(nextDirection);
        }

        @Override
        public String toString() {
            return "Navigation{" +
                "direction=" + direction +
                ", street=" + street +
                ", nextDirection=" + nextDirection +
                '}';
        }
    }
}
