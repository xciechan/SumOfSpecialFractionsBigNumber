package pl.interview.tasks;

import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {

    /**
     Created by xciechan
     on 2022-05-06

     The application calculates sum of "n" fraction "n/d(n)", where d(n) is defined to be sum of the digits of "n".
     */

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1234567890123456789");
        System.out.println("F("+ bigInteger + ") = " + scientificNotationRounded(sumOfSpecialFraction(bigInteger)));

    }

    public static BigDecimal sumOfSpecialFraction(BigInteger n){
        BigDecimal FN = new BigDecimal("0");

        BigDecimal counter = new BigDecimal("0");
        BigDecimal nominativeCase = new BigDecimal("0");
        BigDecimal fraction = new BigDecimal("0");

        for (BigInteger i = new BigInteger("1"); n.compareTo(i)>=0; i = i.add(BigInteger.ONE)){
            counter = new BigDecimal(i);
            nominativeCase = new BigDecimal(sumOfDigitsOfNumber(i));
            fraction = counter.divide(nominativeCase,13, RoundingMode.CEILING);
        //    System.out.println(counter + " : " + nominativeCase + " = " + fraction); // test

            FN = FN.add(fraction);
        }
        return FN;
    }

    public static BigInteger sumOfDigitsOfNumber(BigInteger n){
        BigInteger sumOfDigitsOfNumber = new BigInteger("0");

        while (n.compareTo(BigInteger.ZERO) > 0){
            sumOfDigitsOfNumber = sumOfDigitsOfNumber.add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }

        return (sumOfDigitsOfNumber);
    }

    public static String scientificNotationRounded(BigDecimal bigDecimal) {
        NumberFormat numberFormat = new DecimalFormat("0.############E0");
        return numberFormat.format(bigDecimal).toLowerCase();
    }

}
