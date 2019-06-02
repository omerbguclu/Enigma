//@Rotor Wirings 
public class WiringRotors {
	String RotorI;
	String RotorII;
	String RotorIII;
	String Reflector;

	public WiringRotors(){
		RotorI  = " EKMFLGDQVZNTOWYHXUSPAIBRCJ";	
		RotorII  = " AJDKSIRUXBLHWTMCQGZNPYFVOE";
		RotorIII  = " BDFHJLCPRTXVZNYEIWGAKMUSQO";
		Reflector = " YRUHQSLDPXNGOKMIEBFZCWVJAT";
	}
	public String getRotorI() {
		return RotorI;
	}
	public String getRotorII() {
		return RotorII;
	}
	public String getRotorIII() {
		return RotorIII;
	}
	public String getReflector() {
		return Reflector;
	}
}
