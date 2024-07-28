import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {



    ROT13(Character cs, Character cf) {


    }

    ROT13() {

    }

    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder shift = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char shiftedChar = text.charAt(i);
            if (shiftedChar >= 'a' && shiftedChar <= 'm') {
                shiftedChar += 13;
            } else if (shiftedChar >= 'A' && shiftedChar <= 'M') {
                shiftedChar += 13;
            } else if (shiftedChar >= 'n' && shiftedChar <= 'z') {
                shiftedChar -= 13;
            } else if (shiftedChar >= 'N' && shiftedChar <= 'Z') {
                shiftedChar -= 13;

            }
            shift.append(shiftedChar);


        }
        return shift.toString();
    }
    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
    StringBuilder rotatedString = new StringBuilder();

    String leftRotate = s.substring(s.indexOf(c));
    String rightRotate = s.substring(0,s.indexOf(c));

    rotatedString.append(leftRotate);
    rotatedString.append(rightRotate);
        return rotatedString.toString();
    }

//    private static String leftRotate(String s, int i) {
//        String leftRotate = s.substring(i) + s.substring(0, i);
//        return leftRotate;
//    }

}
