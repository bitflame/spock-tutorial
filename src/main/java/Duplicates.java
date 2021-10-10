import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;
/* You are not keeping track of 3rd, 4th, and ... possibilities. Consider using an array to store the numbers
 * and using the generated number as the index of the count */

public class Duplicates {
    public static void main(String[] args) {
        // T - trials
        int T = Integer.parseInt(args[0]);

        int newValue;
        StdOut.println("Trial(T)  SampleSize(N)  Maximum Value(M) Number of Duplicates ExpectedNumOfDuplicates");
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(args[1]);
            for (; N < 1000000; N = N * 10) {
                for (int M = N / 2; M <= 2 * N; M = M * 2) {
                    int duplicates = 0;
                    Set<Integer> values = new HashSet<>();
                    for (int j = 0; j < N; j++) {
                        newValue = StdRandom.uniform(M);
                        if (values.contains(newValue)) duplicates++;
                        else values.add(newValue);
                    }
                    StdOut.printf("%8d%10d%15d%20d%20f\n", i, N, M, duplicates,Duplicates.expectedDuplicateCount(N,M) );
                }
            }
        }
    }
    private static double expectedDuplicateCount(int N, int M) {
        double alpha = ((double) N) / ((double) M);
        return (M*(1 - Math.pow(Math.E, -alpha)));
    }
}
