//import jdk.internal.org.jline.reader.LineReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    static String inputFile = "sonnet18.txt";
    static String cryptFile = "sonnet18.enc";
    static String decryptFile = "sonnet18.dec";

public static String readFile(String fileName)throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)));

}

public static void writeFile(String fileName, String content) throws IOException {
    Files.write(Paths.get(fileName), content.getBytes());
}


    public static void main(String[] args) throws IOException {
    try {
        ROT13 rot13 = new ROT13();
        String originalText = readFile(inputFile);
        String encryptedText = rot13.encrypt(originalText);
        writeFile(cryptFile, encryptedText);
        String encryptedContent = readFile(cryptFile);
        String decryptedText = rot13.decrypt(encryptedContent);
        writeFile(decryptFile, decryptedText);

        if (Files.mismatch(Paths.get(inputFile), Paths.get(decryptFile)) == -1) {
            System.out.println("Decrypted file matches original file");
        } else {
            System.out.println("The decrypted file does match the original file");
        }
    }catch (IOException e){
        e.printStackTrace();
    }
    }
}