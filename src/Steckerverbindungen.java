import java.util.Scanner;

//@Plugboard
public class Steckerverbindungen {
	String InputWords;
	String Check;
	Scanner reader;
	boolean [] TF;
	boolean FT;	
	
	public Steckerverbindungen() {
		
	}
	public void Start(){
		FT=false;
		
		while(!FT){		
			System.out.println("Enter the letters you want to change(Exp:AK UM YN): ");
			reader = new Scanner(System.in);
			InputWords = reader.nextLine();
			if(InputWords.isEmpty()){
				InputWords=null;
				break;
			}
			Control(InputWords);
			if(InputWords.matches("(.*)[i](.*)")){				
				InputWords =InputWords.replace("i", "I");				
			}
			InputWords = InputWords.toUpperCase();
		}
	}
	public void Control(String s){
		boolean ct=false;
		String [] b = s.split(" ");
		TF = new boolean[b.length];
		
 		for (int m = 0; m <1; m++) {
			for (int i = 0; i < b.length; i++) {
				Check = b[i];
				try {
					if (b[i].charAt(0) == b[i].charAt(1)) {
						System.out.println("You cant plug same letters!");
						FT = false;
						ct=true;
						break;						
					}
				} catch (Exception e) {
					System.out.println("Enter double groups!");
					ct=true;
					break;
				}
				if (Check.length() != 2 && Check.length() != 0) {
					System.out.println("Enter only Dual Groups!");
					ct=true;
					FT = false;
					break;
				}
				if (b[i].matches("^[a-zA-Z]+$")) {
					TF[i] = true;
				} else {
					TF[i] = false;
				}
				if (b.length > 13) {
					System.out.println("You can enter 13 dual group! ");
					FT = false;
					ct=true;
					break;
				}
			}
			if(ct){break;}
			for (int j = 0; j < TF.length; j++) {
				if (!TF[j]) {
					FT = false;
					System.out.println("Enter only English Characters!");
					ct=true;
					break;
				} else {
					FT = true;
				}
			}
			if(ct){break;}
			for (int k = 0; k < b.length; k++) {
				for (int l = 1; l < b.length; l++) {					
					if(k==l){						
						continue;
					}					
					if (b[k].equals(b[l])) {
						System.out.println("You entered the same doubles!");
						FT = false;
						ct = true;
						break;
					}
					if(b[k].charAt(0)==b[l].charAt(1)){						
						System.out.println("You already entered "+b[k].charAt(0)+" letter");
						ct = true;
						FT = false;
						break;
					}
					if(b[k].charAt(1)==b[l].charAt(0)){						
						System.out.println("You already entered "+b[k].charAt(1)+" letter");
						ct = true;
						FT = false;
						break;
					}
				}
				if(ct){break;}
			} 
		}
	}
}
