package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static sbu.cs.CalculatePi.PiCalculator.addTouSum;
import static sbu.cs.CalculatePi.PiCalculator.calculateN;


public class Denominator implements Runnable{
    int N;
    int Fp ;
    public Denominator(int N, int fp) {
        this.N = (N);
        this.Fp = fp;
    }

    @Override
    public void run() {
        MathContext FP = new MathContext((Fp+1));
        BigDecimal sign = new BigDecimal("1");
        if (N%2 == 1){
            sign = sign.multiply(BigDecimal.valueOf(-1));
        }
        BigDecimal n = BigDecimal.valueOf(calculateN(N));
        BigDecimal Two = new BigDecimal("2");
        BigDecimal four = new BigDecimal("4");
        BigDecimal temp = new BigDecimal("0");
        BigDecimal temp2 = new BigDecimal("4");
        temp = n.multiply((n.add(BigDecimal.ONE)).multiply(n.add(Two)));
        temp2 = sign.multiply(temp2);
        temp2 = four.divide( temp , new MathContext(1001));
        addTouSum(temp2);
    }
}