package test;

import java.util.Random;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args){
        int N=1000,lambda=30;
        int randnum;
        double sum = 0,sum2 = 0;
        int i;
        for(i = 0;i < N;i++){
            randnum = rand_p(lambda);
            System.out.println(randnum);
            sum+=randnum;
            sum2+=pow(randnum,2);
        }
    }

    static int rand_p(double lambda){
        int RAND_MAX = 100;
        Random random = new Random();
        double u = (double)random.nextInt(RAND_MAX)/(double)RAND_MAX;
        int x = 0;
        double cdf=exp(-1.0*lambda);
        while (u>=cdf){
            x++;
            cdf += PDF(lambda,x);
        }
        return x;
    }

    static double PDF(double lambda, int k){
        double pdf=1;
        int i;
        for(i = 1;i<=k;i++){
            pdf*=lambda/i;
        }
        return pdf*exp(-1.0*lambda);
    }


}
