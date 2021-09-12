import java.math.BigInteger;
import java.util.Random;


public class keypairs {

	/*B.1.1 Key Pair Generation Using Extra Random Bits */
	public static BigInteger[] gen(BigInteger p, BigInteger q, BigInteger g)
	{
		int N = q.bitLength();
		BigInteger one = BigInteger.ONE; 
		BigInteger[] res = new BigInteger[2]; 
		Random rd = new Random(); 
		String returned_bits = "";
		
		for (int i = 0; i < N + 64; i++)
		{
			returned_bits += rd.nextInt(2);
		}
		
		BigInteger c = new BigInteger(returned_bits, 2); 
		BigInteger x = (c.mod(q.subtract(one))).add(one); 
		BigInteger y = g.modPow(x, p); 
		
		res[0] = x; 
		res[1] = y; 
		return res;
	}
}
