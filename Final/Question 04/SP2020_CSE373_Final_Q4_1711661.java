package com.nsu.spring2020.ID1711661;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class SP2020_CSE373_Final_Q4_1711661 {

	static int[][] cost;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("C:\\Program Files\\Git\\1711661_SP2020_CSE373_Final\\Final\\Question 04\\FinalQ1Input.txt"));
        int n =200;
        cost = new int[n][n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = 99999;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\t");
            int v = Integer.parseInt(s[0]);
            for (int j = 1; j < s.length; j++) {
                String[] ls = s[j].split(",");
                cost[v - 1][Integer.parseInt(ls[0]) - 1] = Integer.parseInt(ls[1]);
            }
        }

           shortestPath(0,n);
    }
    static void shortestPath(int v, int n) {
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = 0;
            dist[i] = cost[v][i];
        }
        s[v] = 1;
        dist[v] = 0;
        for (int i = 1; i < n - 1; i++) {
            int u = 0, dis = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == 0) {
                    dis = dist[j];
                    u = j;
                    for (int k = j + 1; k < s.length; k++) {

                        if (dis > dist[k] && s[k] == 0) {
                            dis = dist[k];
                            u = k;
                        }
                    }
                    break;
                }

            }
            s[u] = 1;
            for (int j = 1; j < n; j++) {
                if (s[j] == 0) {
                    if (dist[j] > (dist[u] + cost[u][j])) {
                        dist[j] = dist[u] + cost[u][j];

                    }
                }
            }
        }

    }

}
