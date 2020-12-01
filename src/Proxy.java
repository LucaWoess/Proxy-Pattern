import java.util.Scanner;

public class Proxy implements Konto {
	
	private String passwort;
	private Konto luca;
	
	Proxy(String name, int kontoNr, double kontostand, String passwort){
		luca = new LockBankKonto(name,kontoNr,kontostand);
		this.passwort = passwort;
	}
	
	@Override
	public void waehleAktion() throws Exception {
		luca.waehleAktion();
	}

	public void checkPasswort() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben Sie Ihr Passwort ein:");
		String e = sc.next();
		while(!e.equals(passwort)) {
			System.out.println("Falsches Passwort!");
			System.out.println("Geben Sie Ihr Passwort erneut ein:");
			e = sc.next();
		}
		waehleAktion();
	}
	
}
