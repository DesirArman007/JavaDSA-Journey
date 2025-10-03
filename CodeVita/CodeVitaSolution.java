package CodeVita;

import java.util.*;

public class CodeVitaSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] arr = new String[n];
        int[] cost = new int[n];
        int[] worth = new int[n];
        boolean[][] bad = new boolean[n][n];

        for (int i = 0; i < n; i++) arr[i] = sc.next();
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            worth[i] = getWorth(arr[i]);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);

        for (int i = 0; i < m; i++) {
            String a = sc.next();
            String b = sc.next();
            int u = map.get(a);
            int v = map.get(b);
            bad[u][v] = true;
            bad[v][u] = true;
        }

        int budget = sc.nextInt();
        boolean[] taken = new boolean[n];
        int[] ans = new int[1];

        solve(0, 0, 0, taken, budget, ans, n, bad, cost, worth);

        System.out.println(ans[0]);
    }

    static int getWorth(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += (s.charAt(i) - 'a' + 1);
        return sum;
    }

    static void solve(int index, int currentCost, int currentWorth, boolean[] taken,
                      int budget, int[] ans, int n, boolean[][] bad, int[] cost, int[] worth) {

        if (currentCost > budget) return;
        if (currentWorth > ans[0]) ans[0] = currentWorth;
        if (index == n) return;

        solve(index + 1, currentCost, currentWorth, taken, budget, ans, n, bad, cost, worth);

        boolean isTrue = true;
        for (int i = 0; i < n; i++) {
            if (taken[i] && bad[index][i]) {
                isTrue = false;
                break;
            }
        }

        if (isTrue && currentCost + cost[index] <= budget) {
            taken[index] = true;
            solve(index + 1, currentCost + cost[index], currentWorth + worth[index],
                    taken, budget, ans, n, bad, cost, worth);
            taken[index] = false;
        }
    }
}
