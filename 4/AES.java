import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import java.util.Scanner;

class AES {
    static byte[] raw;
    static String inputMessage;

    static void generateSymmetricKey() {
        try {
            Random r = new Random();
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(String.valueOf(r.nextInt(10000)).getBytes());
            kgen.init(256, sr);
            raw = kgen.generateKey().getEncoded();
            System.out.println("DES Symmetric key = "+raw.toString());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw,"AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted)throws Exception
    {
        SecretKeySpec skeySpec = new SecretKeySpec(raw,"AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }
    public static void main(String args[]) {
        Scanner sc  = new Scanner(System.in);
        try
        {
            generateSymmetricKey();
            System.out.println("Enter message to encrypt");
            inputMessage= sc.nextLine();
            byte[] ibyte = inputMessage.getBytes();
            byte[] ebyte=encrypt(raw, ibyte);
            String encryptedData = new String(ebyte);
            System.out.println("Encrypted message "+encryptedData);
            byte[] dbyte= decrypt(raw,ebyte);
            String decryptedMessage = new String(dbyte);
            System.out.println("Decrypted message"+decryptedMessage);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
