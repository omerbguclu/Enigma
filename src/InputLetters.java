//@InputLetters
import java.util.Scanner;

public class InputLetters {
	String  InputWords;
	Scanner reader;
	boolean [] TF;
	boolean FT;	
	
	
	public InputLetters() {
		
	}
	public void Input(){
		FT=false;
		
		while(!FT){		
			System.out.println("Enter that you want to encyrpt letters(Exp:UBOOTWILLBOMBYOU): ");
			reader = new Scanner(System.in);
			InputWords = reader.nextLine();
			Control(InputWords);
			if(InputWords.matches("(.*)[i](.*)")){				
				InputWords =InputWords.replace("i", "I");				
			}
			InputWords = InputWords.toUpperCase();
			InputWords = InputWords.trim();						
		}
	}
	public void Control(String s){
		String [] b = s.split(" ");
		TF = new boolean[b.length];
 		for(int i =0;i<b.length;i++){
 			if(b[i].matches("^[a-zA-Z]+$")){
 				TF[i]=true;
 			}else
 			{
 				TF[i]=false;
 			} 				
 		}
 		for(int j=0;j<TF.length;j++){
 			if(!TF[j]){
 				FT=false;
 				System.out.println("Enter only English Characters!");
 				break;
 			}else{
 				FT=true;
 			}
 				
 		}
			
	}

}
