import java.util.Scanner;
import java.util.InputMismatchException;
//@ROTORS
public class Walzenlage {
	
	Scanner reader ;
	String SortString ;
	String RotorRight;
	String RotorMiddle;
	String RotorLeft;
	int SortInt ;
	int first,second,third;
	boolean TF;
	WiringRotors WR = new WiringRotors();
	
	
	public Walzenlage(){
	}
	
	public void Input(){
		TF = false;
		while(!TF){
		try
		{
		    reader = new Scanner(System.in);
			System.out.println("Enter the rotor desing(Exp: 123,231):");
			SortString = reader.next();
			TF = true;
			SortInt = Integer.parseInt(SortString); 
			int length = (int)(Math.log10(SortInt)+1);
			first = SortInt%10;
			second = (SortInt/10)%10;
			third = (SortInt/100)%10;
			if(length!=3){
				System.out.println("Enter 3 Digits!");
				TF=false;
			}
			if(first != 1 && first!=2 && first != 3){
				System.out.println("Enter 1,2 or 3!");
				TF=false;
			}
			if(second != 1 && second!=2 && second != 3){
				System.out.println("Enter 1,2 or 3!");
				TF=false;
			}
			if(third != 1 && third!=2 && third != 3){
				System.out.println("Enter 1,2 or 3!");
				TF=false;
			}
			if(first==second){
				System.out.println("Digits must be unique");
				TF=false;
			}else if(first==third){
				System.out.println("Digits must be unique");
				TF=false;
			}else if(second==third){
				System.out.println("Digits must be unique");
				TF=false;
			}
		}
		catch(InputMismatchException e)            
		{			
		    System.out.println("Enter only integer!");
		    TF = false;
		}
		catch(NumberFormatException e)            
		{			
		    System.out.println("Enter only integer!");
		    TF = false;
		}		
		}
	}
	
	public void RotorSorting(){		
		if(SortInt%10 == 1){
			RotorRight = WR.getRotorI();
		}else if(SortInt%10 == 2){
			RotorRight = WR.getRotorII();
		}else{
			RotorRight = WR.getRotorIII();
		}
		
		if((SortInt/10)%10 == 1){
			RotorMiddle = WR.getRotorI();
		}else if((SortInt/10)%10 == 2){
			RotorMiddle = WR.getRotorII();
		}else{
			RotorMiddle = WR.getRotorIII();
		}
		
		if((SortInt/100)%10 == 1){
			RotorLeft = WR.getRotorI();
		}else if((SortInt/100)%10 == 2){
			RotorLeft = WR.getRotorII();
		}else{
			RotorLeft = WR.getRotorIII();
		}
	}

	public String getRotorRight(){
		return RotorRight;
	}
	public String getRotorMiddle(){
		return RotorMiddle;
	}
	public String getRotorLeft(){
		return RotorLeft;
	}
	public int getSortInt(){
		return SortInt;
	}
}
