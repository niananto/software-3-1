package problem01;

import problem01.sumCalculator.TildeSeparatedSum;

public class Main {
    public static void main(String[] args) {
        TildeSeparatedSum s = new TildeSeparatedSum();
        int sum = s.calculateSum("tildeSeparatedNumbers.txt");
        System.out.println(sum);
    }
}
