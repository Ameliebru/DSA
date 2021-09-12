import java.math.BigInteger;

public class dsa {
	
	static BigInteger two = BigInteger.TWO; 
	static public BigInteger l = two.pow(160).add(BigInteger.valueOf(7));  
	static public BigInteger p = two.pow(864).add(BigInteger.valueOf(218)).multiply(l).add(BigInteger.valueOf(1));
	static public BigInteger q = l; 
	static public BigInteger g = two.modPow(p.subtract(BigInteger.valueOf(1)).divide(l),p); 
	static public BigInteger y ; 
	static public BigInteger r; 
	static public BigInteger s;
	static public String m; 
	static private BigInteger k; 
	static private BigInteger invK; 
	static private BigInteger x;

	static void gen()
	{
		BigInteger[] key = keypairs.gen(p,q,g);
		x = key[0];
		y = key[1];
	
		BigInteger[] ks = secretNumber.gen(p, q, g); 
		k = ks[0]; 
		invK = ks[1]; 
		m = "Hello world!";
		
    	BigInteger[] sig = signature.gen(m, x ,  p, q, g, k, invK); 
    	r = sig[0];
    	s = sig[1]; 
		
	}
	
	static boolean verif()
	{
		return verification.sign(m, p, g, q, r,  s, y); 
	}
}
