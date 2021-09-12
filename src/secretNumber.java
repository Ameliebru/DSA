import java.math.BigInteger;
import java.util.Random;

public class secretNumber {
	/*B.2.1 Per-Message Secret Number Generation Using Extra Random Bits*/
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
		BigInteger k =  (c.mod(q.subtract(one))).add(one); 
		BigInteger invK = k.modInverse(q); 
		
		res[0] = k;
		res[1] = invK; 
		return res;
		}
}
