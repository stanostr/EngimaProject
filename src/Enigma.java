
public class Enigma{

	static char[] Plug = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	//initialize the 8 rotors and the default
	static char[] Default = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};	
	static char[] Rotor1 = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
	static char[] Rotor2 = new char[]{'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	static char[] Rotor3 = new char[]{'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
	static char[] Rotor4 = new char[]{'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
	static char[] Rotor5 = new char[]{'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
	static char[] Rotor6 = new char[]{'J','P','G','V','O','U','M','F','Y','Q','B','E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W'};
	static char[] Rotor7 = new char[]{'N','Z','J','H','G','R','C','X','M','Y','S','W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T'};
	static char[] Rotor8 = new char[]{'F','K','Q','H','T','L','X','O','C','B','J','S','P','D','Z','R','A','M','E','W','N','I','U','Y','G','V'};

	static int[] DefaultInt = new int[26];
	static int[] Rotor1Int = new int[26];
	static int[] Rotor2Int = new int[26];
	static int[] Rotor3Int = new int[26];
	static int[] Rotor4Int = new int[26];
	static int[] Rotor5Int = new int[26];
	static int[] Rotor6Int = new int[26];
	static int[] Rotor7Int = new int[26];
	static int[] Rotor8Int = new int[26];

	public static void main(String[] args){
		
		//convert them into int arrays for easier usage
		for(int a = 0; a < 26 ; a++){
			DefaultInt[a] = charToInt(Default[a]);
			Rotor1Int[a] = charToInt(Rotor1[a]);
			Rotor2Int[a] = charToInt(Rotor2[a]);
			Rotor3Int[a] = charToInt(Rotor3[a]);
			Rotor4Int[a] = charToInt(Rotor4[a]);
			Rotor5Int[a] = charToInt(Rotor5[a]);
			Rotor6Int[a] = charToInt(Rotor6[a]);
			Rotor7Int[a] = charToInt(Rotor7[a]);
			Rotor8Int[a] = charToInt(Rotor8[a]);
		}
		

//test input and output
System.out.println(Rotor('D',Rotor1Int,'C'));
System.out.println(Rotor('D',Rotor1Int,'C'));
System.out.println(RotorInverse('E',Rotor3Int,'B'));
System.out.println(ReflectorB('Y'));

System.out.println(PlugSwap('D'));
PlugSetup('D','Z');

System.out.println(Rotor(PlugSwap('Z'),Rotor1Int,'C'));
}
	
	public static char Rotor(char inputChar, int[] InputRotor, char GrundSetting){
		
		//Change the setup so that the Rotor arrays are not in main method and you just input a # from 1-8 instead and it will choose the array for you

		//takes value and adds the grund shift value.
		int AdjustedValue = (charToInt(inputChar) + charToInt(GrundSetting)) % 26;
		
		//takes output from array and subtracts grund shift value.
		return intToChar((InputRotor[AdjustedValue] - charToInt(GrundSetting)) % 26);
	}
	
	public static char RotorInverse(char inputChar, int[] InputRotor, char GrundSetting){
		char[] Default = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] DefaultInt = new int[26];
		for(int a = 0; a < 26 ; a++){
		DefaultInt[a] = charToInt(Default[a]);
		}
		
		//Change the setup so that the Rotor arrays are not in main method and you just input a # from 1-8 instead and it will choose the array for you

		//takes value and subtracts the grund shift value.
		int AdjustedValue = (charToInt(inputChar) - charToInt(GrundSetting)) % 26;
			
		int index = 0;
		while(InputRotor[index] != AdjustedValue){
			index++;
		}
		
		//takes output from array and subtracts grund shift value.
		return intToChar(DefaultInt[index]);
	}
	
	public static char ReflectorB(char inputChar){
		
		char[] RefB = new char[]{'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'};
		
		return RefB[charToInt(inputChar)];
	}
	
	public static int charToInt(char z)
	{
		char x = Character.toUpperCase(z);
		if(x=='A')return 0;
		if(x=='B')return 1;
		if(x=='C')return 2;
		if(x=='D')return 3;
		if(x=='E')return 4;
		if(x=='F')return 5;
		if(x=='G')return 6;
		if(x=='H')return 7;
		if(x=='I')return 8;
		if(x=='J')return 9;
		if(x=='K')return 10;
		if(x=='L')return 11;
		if(x=='M')return 12;
		if(x=='N')return 13;
		if(x=='O')return 14;
		if(x=='P')return 15;
		if(x=='Q')return 16;
		if(x=='R')return 17;
		if(x=='S')return 18;
		if(x=='T')return 19;
		if(x=='U')return 20;
		if(x=='V')return 21;
		if(x=='W')return 22;
		if(x=='X')return 23;
		if(x=='Y')return 24;
		else return 25;
	}
	
	public static char intToChar(int x) 
	{
		x = x % 26;
		if(x==0)return 'A';
		if(x==1)return 'B';
		if(x==2)return 'C';
		if(x==3)return 'D';
		if(x==4)return 'E';
		if(x==5)return 'F';
		if(x==6)return 'G';
		if(x==7)return 'H';
		if(x==8)return 'I';
		if(x==9)return 'J';
		if(x==10)return 'K';
		if(x==11)return 'L';
		if(x==12)return 'M';
		if(x==13)return 'N';
		if(x==14)return 'O';
		if(x==15)return 'P';
		if(x==16)return 'Q';
		if(x==17)return 'R';
		if(x==18)return 'S';
		if(x==19)return 'T';
		if(x==20)return 'U';
		if(x==21)return 'V';
		if(x==22)return 'W';
		if(x==23)return 'X';
		if(x==24)return 'Y';
		else return 'Z';
	}
	
	public static boolean checkInput(char Input){
		char[] Default = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean Check = false;
		for(int a = 0; a < 26 && Check == false ; a++){
			if(Input == Default[a]){
				Check = true;
			}
		}
		return Check;
	}
	
	//Converts input into the plug swapped value.
	public static char PlugSwap(char Input){
		return Plug[charToInt(Input)];
	}
	
	//Takes two inputs and swaps them. Edits the array. (A would be 0 so if you swap A to Z, it would set Plug[0] to Z and Plug[25] to A)
	//By default they are in normal order. (A -> Z)
	public static void PlugSetup(char Input1, char Input2){
		if(checkInput(Input1) && checkInput(Input2)){
			int InputOne = charToInt(Input1);
			int InputTwo = charToInt(Input2);
			Plug[InputOne] = Input2;
			Plug[InputTwo] = Input1;
		}
		else{
			System.out.println("Not Valid Input for PlugSwag");
		}
		
	}
}