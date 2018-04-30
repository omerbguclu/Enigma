import java.util.Scanner;

//@ROTORSSETTINGS
public class Ringstellung {
	RotorTurn RT = new RotorTurn();
	String InputWords;
	Scanner reader;
	boolean TF;
	
	
	public Ringstellung(){
		
	}
	public void Input(){		
		TF = false ;
		while(!TF){		
			System.out.println("Enter your Rotor Settings(Exp:KLM POL): ");
			reader = new Scanner(System.in);
			InputWords = reader.nextLine();
			if(InputWords.length()!=3){
				System.out.println("Enter 3 Letters!");
				continue;
			}else if(!InputWords.matches("^[a-zA-Z]+$")){
				System.out.println("Enter only English Characters!");
				continue;
			}else{
				TF=true;
			}					
			InputWords = InputWords.toUpperCase();
		}
	}	
}
