
public class RekursionTest {
	
	public void ausgabe() {
		System.out.println("Ausgabe");
		ausgabe();
	}
	
	public void erstelle(int b) { 
		if (b >= 1) {
			erstelle(b - 1); 
			System.out.println("Gegner erstellt: " + b);
		}
	}

	
	public static void main(String[] args) {
		// Rekursion = "Schleife"
		
		RekursionTest rTest = new RekursionTest();
//		rTest.ausgabe();
		
//		while(true) {
//			System.out.println("Test");
//		}
		
		int a = 10;
		
		while(a >= 1) {
			System.out.println("Feind erstellt");
			a--;
		}
		
		int b = 10;
		rTest.erstelle(b);
		
		
	}

}
