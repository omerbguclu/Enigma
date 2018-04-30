//@EncryptingPart
public class Encrypt {
	WiringRotors WR = new WiringRotors();	
	RotorTurn RT = new RotorTurn();
	Ringstellung R = new Ringstellung();		
	Steckerverbindungen S = new Steckerverbindungen();
	InputLetters I = new InputLetters();
	
	String RotorDesign;
	String RotorSettings;
	String Plugboard;
	String Message;	
	
	int TurnDigit0;
	int TurnDigit1;
	int TurnDigit2;
	
	String [] LittleRight = new String[27];
	String [] LittleMiddle = new String[27];
	String [] LittleLeft = new String[27];
	
	String [] BigRight = new String[27];
	String [] BigMiddle = new String[27];
	String [] BigLeft = new String[27];
	
	int InputLength;
	int Order;
	int j;
	int k;
	
	String [] Encrypt ;	
	String [] Alphabet = new String[27];
	String [] ChangedAlphabet = new String[27];
	String [] PlugAlphabet;
	

	String [] Reflector = new String[27];	
	String [] Right = new String[27];
	String [] Middle = new String[27];
	String [] Left = new String[27];
	
	
	public Encrypt(){
		
	}
	public void Start(){
		
		RT.Start();
		
		this.RotorDesign = RT.RotorDesign;
		
		Right = RT.Right;
		Middle = RT.Middle;
		Left = RT.Left;
		
		BigRight = RT.BigRight;
		BigMiddle = RT.BigMiddle;
		BigLeft = RT.BigLeft;	
				
		R.Input();
		I.Input();
		S.Start();		
		
		RotorSettings = R.InputWords;
		Plugboard = S.InputWords;
		if(Plugboard==null){
			Plugboard = "Not Entered";
		}
		Message = I.InputWords;
		
		InputLength = I.InputWords.length();		
		Encrypt = new String[InputLength];		
		RT.StringToArray(I.InputWords, Encrypt,I.InputWords.length());
		RT.StringToArray(WR.getReflector(), Reflector, 27);		

		Alphabet(Alphabet);
		Alphabet(ChangedAlphabet);
		
		if(S.InputWords!=null){
			PlugAlphabet = S.InputWords.split(" ");
			PlugChanger(ChangedAlphabet, PlugAlphabet);
		}		
		
		TurnDigit0 = (int)R.InputWords.charAt(2)-65;
		TurnDigit1 = (int)R.InputWords.charAt(1)-65;
		TurnDigit2 = (int)R.InputWords.charAt(0)-65;
		
		Alphabet(LittleRight);
		Alphabet(LittleMiddle);
		Alphabet(LittleLeft);
		
		if(TurnDigit0!=0){
			for(int i=0;i<TurnDigit0;i++){
				RT.Turning(BigRight);				
				RT.Turning(LittleRight);				
			}
		}
		if(TurnDigit1!=0){
			for(int i=0;i<TurnDigit1;i++){
				RT.Turning(BigMiddle);
				RT.Turning(LittleMiddle);				
			}
		}
		if(TurnDigit2!=0){
			for(int i=0;i<TurnDigit2;i++){
				RT.Turning(BigLeft);
				RT.Turning(LittleLeft);
			}
		}

		
		for(int i=0;i<InputLength;i++){
			Order = 0;
			
			RT.Turning(BigRight);
			RT.Turning(LittleRight);
			
			if(i!=0){
				if(i%26==0){
					RT.Turning(BigMiddle);
					RT.Turning(LittleMiddle);
				}
				if(i%676==0){
					RT.Turning(BigLeft);
					RT.Turning(LittleLeft);
				}
			}
			
			System.out.println();			
			
			System.out.print((i+1)+".Turn "+Encrypt[i]+"->");
			Order = Finder(Encrypt[i],ChangedAlphabet);
			Encrypt[i] = BigRight[Order];
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleRight);			
			Encrypt[i] = BigMiddle[Order];			
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleMiddle);
			Encrypt[i] = BigLeft[Order];			
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleLeft);
			Encrypt[i] = Reflector[Order];			
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],Alphabet);
			Encrypt[i] = LittleLeft[Order];						
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],Left);
			Encrypt[i] = Alphabet[Order];						
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleLeft);
			Encrypt[i] = LittleMiddle[Order];	
			System.out.print(Encrypt[i]+"  ");

			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],Middle);
			Encrypt[i] = Alphabet[Order];	
			System.out.print(Encrypt[i]+"  ");						

			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleMiddle);
			Encrypt[i] = LittleRight[Order];
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],Right);
			Encrypt[i] = Alphabet[Order];
			System.out.print(Encrypt[i]+"  ");
			
			System.out.print(Encrypt[i]+"->");
			Order = Finder(Encrypt[i],LittleRight);
			Encrypt[i] = ChangedAlphabet[Order];
			System.out.print(Encrypt[i]+"  ");
			
			System.out.println();
		}
		

	}
	public void Alphabet(String [] S){			
		j = 65 ;
		char ch;
		S[0]=" ";
		for(int i=1;i<27;i++){
			ch = (char)j ;
			S[i] = String.valueOf(ch);
			j++;			
		}
	}
	
	public int Finder(String s,String[]S){		
		for(int i=1;i<27;i++){
			if(S[i].equals(s)){
				j = i;
				break;
			}			
		}
		return j;
	}
	
	public void PlugChanger(String [] c,String [] B){
		int first=0,second=0;
		String d;
		for(int i=0;i<B.length;i++){			
			for(int j=0;j<c.length;j++){
				if(B[i].charAt(0)==c[j].charAt(0)){
					first =j;
				}
				if(B[i].charAt(1)==c[j].charAt(0)){
					second =j;
				}
			}
			d=c[first];
			c[first]=c[second];
			c[second]=d;			
		}
	}

}
