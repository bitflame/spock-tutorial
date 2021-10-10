package org.example.demo.spock;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class NoCollisionHashTable {
    public static void main(String[] args) {
        /* exercise 3.4.4 create the hash, and if there is a collision, increase M so that there is no collision */
        NoCollisionHashTable nCHT = new NoCollisionHashTable();
        int[] values = nCHT.perfectHashFunction();
        if (values != null) {
            StdOut.println("Hi from Groovy");
            System.out.println("a = " + values[0]);
            System.out.println("m = " + values[1]);
        }
    }

    private int[] perfectHashFunction() {
        int[] values = new int[2];
        int[] letterValues = {19, 5, 1, 18, 3, 8, 24, 13, 16, 12};
        for (int m = 2; m <= 100; m++) {
            for (int a = 1; a <= 1000; a++) {
                Set<Integer> hashes = new HashSet<>();
                for (int i = 0; i < letterValues.length; i++) {
                    int hash = hashCodeFunction(a, letterValues[i], m);
                    hashes.add(hash);
                }
                if (hashes.size() == 10) {
                    // found the perfect hash function
                    values[0] = a;
                    values[1] = m;
                    return values;
                }
            }
        }
        return null;
    }

    private int hashCodeFunction(int a, int k, int m) {
        return (a * k) % m;
    }
}