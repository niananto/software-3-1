package problem01.sumCalculator;

import java.io.*;

public class TildeSeparatedSum {
    public int calculateSum(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String intermediateFile = "spaceSeparatedNumbers.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(intermediateFile, false));
            while(true) {
                String line = br.readLine();
                if (line == null) break;

                String[] intStrings = line.split("~");
                for (String s : intStrings) {
                    bw.write(s);
                    bw.write(" ");
                }
                bw.flush();
            }

            // call the space separated calculated sum
            SpaceSeparatedSum spaceSeparatedSum = new SpaceSeparatedSum();
            int sum = spaceSeparatedSum.calculateSum(intermediateFile);

            br.close();
            bw.close();

            // delete the intermediate file
            File toDelete = new File(intermediateFile);
            toDelete.delete();

            return sum;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
