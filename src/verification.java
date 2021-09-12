import java.math.BigInteger;

public class verification {

	static boolean sign(String M, BigInteger p, BigInteger g, BigInteger q,  BigInteger r, BigInteger s, BigInteger y)
	{
		
		int N = q.bitLength();
		if (r.compareTo(BigInteger.ZERO) != 1 || (r.compareTo(q) != -1) || (s.compareTo(BigInteger.ZERO)) != 1 || (s.compareTo(q) != -1)) 
		{
			return false; 
		}
		
		BigInteger w = s.modInverse(q); 
		BigInteger hashM = hash.functionHash(M);
		
		int outlen = hashM.bitLength();
		int minimum = Integer.min(outlen, N); 
		
		BigInteger z = new BigInteger(hashM.toString(2).substring(0, minimum), 2);
		BigInteger u1 = (z.multiply(w)).mod(q); 
		BigInteger u2 = (r.multiply(w)).mod(q); 
		BigInteger g_u1 = g.modPow(u1, p); 
		BigInteger y_u2 = y.modPow(u2,p); 
		BigInteger v = ((g_u1.multiply(y_u2)).mod(p)).mod(q); 

		if ( v.compareTo(r) == 0)
		{
			return true; 
		}
		return false; 
	}
}
