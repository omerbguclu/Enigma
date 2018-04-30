
public class RotorTurn {
	Walzenlage WL = new Walzenlage();
	InputLetters I = new InputLetters();
	String [] Right = new String[27];
	String [] Middle = new String[27];
	String [] Left = new String[27];
	String [] BigRight = new String[27];
	String [] BigMiddle = new String[27];
	String [] BigLeft = new String[27];
	String Data;
	String Hold;
	int SortInt;
	int first,second,third;
	String RotorDesign;
	
	public RotorTurn(){
	}
	public void Start(){
		
		WL.Input();		
		RotorDesign = Integer.toString(WL.SortInt);
		
		this.SortInt=WL.SortInt;
		this.first =WL.first;
		this.second =WL.second;
		this.third =WL.third;
		
		WL.RotorSorting();
		
		StringToArray(WL.getRotorRight(), Right,27);
		StringToArray(WL.getRotorMiddle(), Middle,27);
		StringToArray(WL.getRotorLeft(), Left,27);
		
		StringToArray(WL.getRotorRight(), BigRight,27);
		StringToArray(WL.getRotorMiddle(), BigMiddle,27);
		StringToArray(WL.getRotorLeft(), BigLeft,27);	

	}
	public void Turning(String[] s){		
		for(int i=1;i<26;i++){
			Hold = s[i+1];
			s[i+1] = s[i];
			s[i]=Hold; 
		}
	}	
	
	public void StringToArray(String s,String [] S,int lenght){		
		for(int i=0 ;i<S.length ;i++){			
			S[i]=String.valueOf(s.charAt(i));
		}
	}	

	
	public void showArray(String[]s){		
		for(int i = 0;i<s.length;i++){		
		System.out.print(s[i]);
		}		
	}

}