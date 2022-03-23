package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Quicksort qs = new Quicksort();

        int[] array = {1,2,1,4,6,2,9,4,74,322,13};
        System.out.println(Arrays.toString(array));
        qs.quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
