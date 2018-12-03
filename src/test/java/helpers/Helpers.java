package helpers;

public class Helpers {
	
	public static void esperarUnMomento(long segundos) {
		try {
			Thread.sleep(segundos*1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
