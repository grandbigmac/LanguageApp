import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class securePassword {

    public String hashPassword(String r) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(r.getBytes());
            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();

        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger("SHA-512").log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");

        byte[] salt = new byte[16];

        secureRandom.nextBytes(salt);

        return salt;
    }

    public static byte[] getSaltedHashSHA512(String password, byte[] salt) throws NoSuchAlgorithmException {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            md.update(salt);

            byte byteData[] = md.digest(password.getBytes());

            md.reset();

            return byteData;
        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger("SHA-512").log(Level.SEVERE, "SHA-512 is not a valid algorithm name", ex);
            return null;
        }

    }

    public static byte[] fromHex(String hex) {

        byte[] binary = new byte[hex.length()/ 2];

        for (int i = 0; i < binary.length; i++) {

            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return binary;
    }

    public static byte[] toHex(String hex) {

        byte[] binary = new byte[hex.length() / 2];

        for (int i = 0; i < binary.length; i++) {
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return binary;
    }

    public static boolean slowEquals(byte[] a, byte[] b) {

        int diff = a.length ^ b.length;

        for (int i = 0; i < a.length && i < b.length; i++) {

            diff |= a[i] ^ b[i];
        }
        System.out.println(diff == 0);
        return diff == 0;
    }

    public static String toHex(byte[] array) {

        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();

        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        }
        else {
            return hex;
        }
    }

    public static String generateStrongHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

        int iterations = 1000;
        char[] passwordAsCharArray = password.toCharArray();
        byte[] salt = getSalt();
        PBEKeySpec spec = new PBEKeySpec(passwordAsCharArray, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();

        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }


}
