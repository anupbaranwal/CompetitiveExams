import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class GraphEdgeExistence {

    public static void main(String[] args) throws Exception {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Nodes");
        int N = sc.nextInt();
        System.out.println("Enter no of Edges");
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            System.out.println("Enter node 1");
            int A = sc.nextInt();
            System.out.println("Enter node 2");
            int B = sc.nextInt();
            if(adjacencyList.containsKey(A)) {
                adjacencyList.get(A).add(B);
            } else {
                Set<Integer> list1 = new HashSet<>();
                list1.add(B);
                adjacencyList.put(A, list1);
            }
            // For bi-Direction graph
            if(adjacencyList.containsKey(B)) {
                adjacencyList.get(B).add(A);
            } else {
                Set<Integer> list2 = new HashSet<>();
                list2.add(A);
                adjacencyList.put(B, list2);
            }
        }
        System.out.println("How many queries?");
        int noOfQueries = sc.nextInt();
        for (int i = 0; i < noOfQueries; i++) {
            System.out.println("Enter node 1");
            int A = sc.nextInt();
            System.out.println("Enter node 2");
            int B = sc.nextInt();
            if(adjacencyList.get(A).contains(B) && adjacencyList.get(B).contains(A)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
