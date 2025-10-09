import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int target = 100;
        int[] position = { 0, 2, 4 };
        int[] speed = { 4, 2, 1 };

        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        if (n == 1) {
            return 1;
        }

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, c) -> c[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        int fleet = 0;
        for (int i = 0; i < cars.length; i++) {

            double car = (double) (target - cars[i][0]) / cars[i][1];
            if (!stack.empty()) {
                if (car <= stack.peek()) {
                    continue;
                } else {
                    stack.clear();
                    fleet++;
                }
            }
            stack.add(car);
        }
        if (fleet == 0) {
            return 1;
        }
        return stack.empty() == false ? fleet + 1 : fleet;
    }
}