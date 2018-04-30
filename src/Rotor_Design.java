import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Rotor_Design {
	
	Scanner reader ;
	int Sort ;
	boolean TF;
	
	public Rotor_Design(){
		
		TF = false;
		while(!TF){
		try
		{
		    Scanner reader = new Scanner(System.in);
			System.out.println("Enter the rotor desing(Exp: 1 2 3);");
			int Sort = reader.nextInt();
			TF = true;
		}
		catch(InputMismatchException e)            
		{
			
		    System.out.println("sayý gir amuakoduum");
		    TF = false;
		}
		}

	}
	public int getSort(){
		return Sort ;
	}
	

}
