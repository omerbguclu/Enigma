//@MainPart
public class Enigma {

	public static void main(String[] args) {
		RotorTurn RT = new RotorTurn();
		Encrypt E = new Encrypt();		
		
		E.Start();			

		System.out.println();
		System.out.println("******Your Settings and Result******");
		System.out.println("Rotor Design: "+ E.RotorDesign);
		System.out.println("Rotor Settings: "+ E.RotorSettings);
		System.out.println("Plugboard Settings: "+ E.Plugboard);
		System.out.println("Your Message: "+ E.Message);
		System.out.print("Your Encrypted Message: ");
		RT.showArray(E.Encrypt);		

	}

}
