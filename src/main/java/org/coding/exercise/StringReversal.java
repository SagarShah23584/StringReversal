package org.coding.exercise;

import java.io.*;

public class StringReversal {
    public String readStringFromFile(String srcFilePath) throws IOException {
        String strToReverse = "";

        System.out.println("Source file path is : " + srcFilePath);

        try (FileReader fileReader = new FileReader(srcFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            strToReverse = bufferedReader.readLine();

            System.out.println("String read from source file is : " + strToReverse);
        } catch (IOException e) {
            System.out.println("Encountered IO exception in StringReversal.readStringFromFile() method");
            throw new IOException("Encountered IO exception in StringReversal.readStringFromFile() method");
        }

        return strToReverse;
    }

    public String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);

        return stringBuilder.reverse().toString();
    }

    public void writeReversedStringToFile(String strToReverse) throws IOException {
        String destFilePath = "src/main/resources/ReversedString.txt";
        String strReversed = "";

        try (FileWriter fileWriter = new FileWriter(destFilePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            strReversed = reverseString(strToReverse);

            System.out.println("Reversed string is : " + strReversed);

            bufferedWriter.write(strReversed);

            System.out.println("Reversed string '" + strReversed + "' has been written to " + destFilePath + " successfully.");
        } catch (IOException e) {
            System.out.println("Encountered IOException - " + e.getMessage());
            throw new IOException("IO exception in StringReversal.writeReversedStringToFile() method");
        }
    }

    public static void main(String[] args) {
        final String FILE_PATH = "src/main/resources/ActualString.txt";

        StringReversal objStringReversal = new StringReversal();
        try {
            objStringReversal.writeReversedStringToFile(objStringReversal.readStringFromFile(FILE_PATH));
        } catch (IOException e) {
            System.out.println("Encountered IOException - " + e.getMessage());
        }
    }
}