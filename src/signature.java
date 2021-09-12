import java.math.BigInteger;

public class signature {

	public static BigInteger[] gen(String m, BigInteger x, BigInteger p, BigInteger q, BigInteger g, BigInteger k, BigInteger invK)
	{
		BigInteger zero = BigInteger.ZERO; 
		BigInteger[] res = new BigInteger[2];
		BigInteger r = (g.modPow(k, p)).mod(q);
		BigInteger hashM = hash.functionHash(m);
		
		int outlen = hashM.bitLength();
		int N = q.bitLength(); 
		int minimum = Integer.min(outlen, N); 
		
		BigInteger z = new BigInteger(hashM.toString(2).substring(0, minimum), 2);
		BigInteger s = invK.multiply(z.add((x.multiply(r)))).mod(q);
		
		if (r.compareTo(zero) == 0  || s.compareTo(zero) == 0)
		{
			gen(m, x, p,q,g, k, invK);
		}
	
		res[0] = r;
		res[1] = s; 
		return res;
	}
}
