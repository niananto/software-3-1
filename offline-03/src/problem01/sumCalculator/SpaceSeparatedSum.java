package problem01.sumCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SpaceSeparatedSum {
    int calculateSum(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int sum = 0;
            while(true) {
                String line = br.readLine();
                if (line == null) break;

                String[] intStrings = line.split(" ");
                for (String s : intStrings) {
                    sum += Integer.parseInt(s);
                }
            }
            br.close();
            return sum;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
