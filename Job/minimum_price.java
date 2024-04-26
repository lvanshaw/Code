import java.util.*;

class minimum_price {
    static List<Integer> size;

    // Function to find if we place prize here
    // what would be sum of prize
    static int traversal(List<Integer> ans, List<List<Integer>> adj, int node, int parent, int depth) {
        size.set(node, 1);
        for (int a : adj.get(node)) {
            if (a != parent) {
                size.set(node, size.get(node) + traversal(ans, adj, a, node, depth + 1));
            }
        }
        ans.add(size.get(node) - depth);
        return size.get(node);
    }

    // Function to find maximise sum of prizes
    // grabbed by persons.
    static long findMaxPrizes(int n, int m, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int i = 0;
        size = new ArrayList<>(Collections.nCopies(n + 1, 0));

        // Adding edges in adj
        while (i < edges.size()) {
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);

            adj.get(x).add(y);
            adj.get(y).add(x);
            i++;
        }

        traversal(ans, adj, 1, -1, 1);
        Collections.sort(ans, Collections.reverseOrder());
        i = 0;
        int sum = 0;
        while (i < n - m) {
            sum += ans.get(i);
            i++;
        }

        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        int n = 7;
        int m = 3;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(1, 4),
                Arrays.asList(2, 5), Arrays.asList(2, 6), Arrays.asList(4, 7)
        );

        // Function call
        System.out.println(findMaxPrizes(n, m, edges));
    }
}
