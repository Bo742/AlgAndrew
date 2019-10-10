package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Dat> dat = new ArrayList<>();
        long amountDat = in.nextLong();
        for (int i = 0; i < amountDat ; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            dat.add(new Dat());
            dat.get(dat.size()-1).setNumberDat(i+1);
            dat.get(dat.size()-1).setX(x);
            dat.get(dat.size()-1).setY(y);
        }
        Sort sort = new Sort(dat);
        dat = sort.getDat();
        AlgAndrew algFirst = new AlgAndrew(0);
        algFirst.push(dat.get(0));
        algFirst.push(dat.get(1));
        for (int i = 2; i <dat.size() ; i++) {
            algFirst.alg(dat.get(i));
        }
        ArrayList<Dat> firstAlg = algFirst.getStackDat();
        System.out.println();
        AlgAndrew algSecond = new AlgAndrew(1);
        algSecond.push(dat.get(0));
        algSecond.push(dat.get(1));
        for (int i = 2; i <dat.size() ; i++) {
            algSecond.alg(dat.get(i));
        }
        ArrayList<Dat> secondAlg = algSecond.getStackDat();
        
        String answer = "";
        for (int i = 0; i <firstAlg.size() ; i++) {
            answer += firstAlg.get(i).getNumberDat();
        }
        for (int i = secondAlg.size()-2; i >0 ; i--) {
            answer += secondAlg.get(i).getNumberDat();
        }

        System.out.print(answer);
    }
}
