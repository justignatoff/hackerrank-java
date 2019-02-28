package Introduction;

import java.security.MessageDigest;
import java.util.Scanner;


public class JavaSHA256 {
    public static String getMD5Checksum(byte[] checksum) throws Exception {
        byte[] b = checksum;
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.reset();
        messageDigest.update(s.getBytes());
        System.out.println(getMD5Checksum(messageDigest.digest()));

    }
}
