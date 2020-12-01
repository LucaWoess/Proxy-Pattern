
public class BankTerminal {

	public static void main(String[] args) {
		Proxy luca = new Proxy("Luca",187,500,"lafamilia");
		
		try {
			luca.checkPasswort();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
