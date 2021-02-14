package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] a={5, 7, 6, 9, 10, 8, 4, 3};
        a= divide(a);
        for(int x:a) System.out.println(x);
    }

    public static int[] divide(int[] a) {
        if (a.length != 1) {
            int mid = (a.length - 1) / 2;
            int[] array1 = new int[mid + 1];
            int[] array2 = new int[a.length - (mid + 1)];
            for (int i = 0; i < a.length; i++) {
                if (i <= mid) {
                    array1[i] = a[i];
                } else {
                    array2[i - (mid + 1)] = a[i];
                }
            }
            return Merge(divide(array1), divide(array2));
        }
        return a;
    }

    public static int[] Merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];
        while (k < c.length) {
            if (i == a.length) {
                while (j < b.length) {
                    c[k] = b[j];
                    k++;
                    j++;
                }
            }
            else if (j == b.length) {
                while (i < a.length) {
                    c[k] = a[i];
                    k++;
                    i++;
                }
            }
            else if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c;
    }
}

