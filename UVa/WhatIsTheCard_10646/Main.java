// UVa 10646
import java.util.*;
import java.io.*;

public class Main {

    private String solve(String s) {
        String[] arr = s.split(" ");

        // 52 cords
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < 52 - 25; i++)
            deque.push(arr[i]);

        int y = 0;
        for (int i = 0; i < 3; i++) {
            int x = value(deque.pop());
            y += x;
            for (int j = 0; j < 10 - x; j++)
                deque.pop();
        }

        for (int i = 52 - 25; i < arr.length; i++)
            deque.push(arr[i]);

        String ans = null;
        for (int i = 0; i < y; i++)
            ans = deque.pollLast();

        return ans;
    }

    private int value(String card) {
        char c = card.charAt(0);
        if ('2' <= c && c <= '9')
            return c - '0';
        return 10;
    }

    public static void main(String[] args) throws IOException {
        Main solution = new Main();
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCases; i++)
                answers.add(solution.solve(br.readLine()));
        }
        int counter = 0;
        for (String answer : answers)
            System.out.println("Case " + (++counter) + ": " + answer);
    }
}