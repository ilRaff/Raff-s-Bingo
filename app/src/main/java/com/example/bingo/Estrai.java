package com.example.bingo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Estrai {

    public int[] SceltaNum() {
        int[] numeri = new int[6];
        Random rand = new Random();
        int n;
        boolean esci = false;
        List<Integer> numUsati = new ArrayList<Integer>();

        for (int i = 0; i < 6; i++)
        {
            esci=false;
            n = 1+rand.nextInt(30);
            do {
                if (numUsati.contains(n)) {
                    n = 1+rand.nextInt(30);
                } else {
                    numeri[i] = n;
                    numUsati.add(n);
                    esci = true;
                }
            } while (!esci);
        }
        return numeri;
    }

    public int NumEstratto()
    {
        Random rand = new Random();
        int n;
        n= 1+rand.nextInt(30);
        return n;
    }
}
