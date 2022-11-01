import java.math.BigInteger; import java.security.*;
public class SHA1 {
public static String encryptThisString(String input)
{
try {
MessageDigest md = MessageDigest.getInstance("SHA-1"); byte[] messageDigest = md.digest(input.getBytes()); BigInteger no = new BigInteger(1, messageDigest);
String hashtext = no.toString(16); while (hashtext.length() < 32) {
hashtext = "0" + hashtext;
}
return hashtext;
}
catch (NoSuchAlgorithmException e) { throw new RuntimeException(e);
}
}
public static void main(String args[]) throws NoSuchAlgorithmException
{
System.out.println("Name: Mohan Patil\nRoll No.: 19141267"); System.out.println("HashCode Generated For Given String: ");
String s1 = "MohanPatil";
System.out.println("\n" + s1 + " : " + encryptThisString(s1));
}
}
