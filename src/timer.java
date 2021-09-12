public class timer {

	public static void main(String[] args) {

		long begin; 
		long end; 
		float gen = 0; 
		float ver = 0;
		for (int i = 0; i < 10000; i ++)
		{		
			begin = System.nanoTime(); 
			dsa.gen();
			end = System.nanoTime(); 
			gen += (end - begin); 	
			begin = System.nanoTime(); 
			dsa.verif();
			end = System.nanoTime(); 
			ver += end - begin; 
		}
		
		System.out.println("Temps pour la generation : " + gen/1000000000 + " secondes");
		System.out.println("Temps pour la verification : " + ver/1000000000+" secondes");
	
    }
}
