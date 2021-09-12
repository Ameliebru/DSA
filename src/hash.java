import java.math.BigInteger;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
	
	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final String HASH_FUNCTION = "SHA3-256";
		    
	public static byte[] sha3(byte[] input) {
		MessageDigest md;
		try { /*Verification du HASH*/ 
			md = MessageDigest.getInstance(HASH_FUNCTION);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		byte[] result = md.digest(input);
		return result;
	}
	
	public static BigInteger bytesToInt(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) { 
			sb.append(String.format("%02x", b)); //conversion du bytes en hexa 
		}
		String ch =  sb.toString();
		BigInteger bigInt = new BigInteger(ch, 16); //conversion de la string en int 
		return bigInt;
		        
	}
		    
	public static BigInteger functionHash(String message)
	{
		byte[] shaInBytes = hash.sha3(message.getBytes(UTF_8));
		return bytesToInt(shaInBytes); 
	}	    
}
