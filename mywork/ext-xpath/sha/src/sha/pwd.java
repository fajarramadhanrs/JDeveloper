package sha;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class pwd {
    public static String main(String text)throws NoSuchAlgorithmException, UnsupportedEncodingException
        {
            
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] data = new byte[40];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            data = md.digest();
            
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < data.length; i++) {
                int halfbyte = (data[i] >>> 4) & 0x0F;
                int two_halfs = 0;
                do {
                    if ((0 <= halfbyte) && (halfbyte <= 9)) {
                        buf.append((char) ('0' + halfbyte));
                    } else {
                        buf.append((char) ('a' + (halfbyte - 10)));
                    }
                    halfbyte = data[i] & 0x0F;
                } while (two_halfs++ < 1);
            }
            String result=buf.toString();
            return result;
        }
}
