import java.util.InputMismatchException;
import java.util.Scanner;

public class LockBankKonto implements Konto {
	public String name;
	public int kontoNr;
	private double kontostand;

	
	
	LockBankKonto(String name, int kontoNr, double kontostand){
		this.name = name;
		this.kontoNr = kontoNr;
		this.kontostand = kontostand;
	}

	public void zeigeKontostand() throws Exception {
		System.out.println("Ihr Kontostand betr�gt: "+kontostand+"�");
		
	}

	public void geldAbheben() throws Exception {	
		double e = 0.00;
		System.out.println("Wie viel m�chten Sie abheben:");
		boolean ok;
		do {
			ok = true;
			try {
				Scanner sc = new Scanner(System.in);
				e = sc.nextDouble();
				}
			catch (InputMismatchException ex) {
				System.out.println("Dies ist kein g�ltiger Betrag! \nVersuchen Sie es erneut: ");
				ok = false;
				}
			if(e<0) {
				ok = false;
				System.out.println("Dies ist kein g�ltiger Betrag! \nVersuchen Sie es erneut: ");
			}
			if(e>kontostand) {
				ok = false;
				System.out.println("Dieser Betrag ist h�her als ihr Guthaben("+kontostand+"�)! \nVersuchen Sie es erneut: ");
			}
		}
		while(!ok);
		kontostand -= e;
		zeigeKontostand();
	}

	public void geldEinzahlen() throws Exception {
		double e = 0.00;
		System.out.println("Wie viel m�chten Sie einzahlen:");
		boolean ok;
		do {
			ok = true;
			try {
				Scanner sc = new Scanner(System.in);
				e = sc.nextDouble();
				}
			catch (InputMismatchException ex) {
				System.out.println("Dies ist kein g�ltiger Betrag! \nVersuchen Sie es erneut: ");
				ok = false;
				}
			if(e<0) {
				ok = false;
				System.out.println("Dies ist kein g�ltiger Betrag! \nVersuchen Sie es erneut: ");
			}
		}
		while(!ok);
		kontostand += e;
		zeigeKontostand();
	}

	@Override
	public void waehleAktion() throws Exception {
		System.out.println("Geld einzahlen(Dr�cke 0)");
		System.out.println("Geld abheben(Dr�cke 1)");
		System.out.println("Kontostand anzeigen(Dr�cke 2)");
		System.out.println("W�hle eine Aktion: ");
		int e = -1;
		boolean ok;
		do {
			ok = true;
			try {
				Scanner sc = new Scanner(System.in);
				e = sc.nextInt();
				}
			catch (InputMismatchException ex) {
				ok = false;
				}
			if(e>2 || e<0) {
				ok = false;
				System.out.println("Falsche Eingabe! \nVersuchen Sie es erneut: ");
			}
		}
		while(!ok);
		switch (e) {
			
			case 0:
				geldEinzahlen();
				break;
			case 1:
				geldAbheben();
				break;
			case 2:
				zeigeKontostand();
				break;
		}
	}
	
}

