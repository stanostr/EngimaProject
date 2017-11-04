
public class Enigma{

	static char[] Plug = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	//initialize the 8 rotors and the default
	static final char[] DEFAULT = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};	
	static final char[] ROTOR1 = new char[]{'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
	static final char[] ROTOR2 = new char[]{'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
	static final char[] ROTOR3 = new char[]{'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
	static final char[] ROTOR4 = new char[]{'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
	static final char[] ROTOR5 = new char[]{'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
	static final char[] ROTOR6 = new char[]{'J','P','G','V','O','U','M','F','Y','Q','B','E','N','H','Z','R','D','K','A','S','X','L','I','C','T','W'};
	static final char[] ROTOR7 = new char[]{'N','Z','J','H','G','R','C','X','M','Y','S','W','B','O','U','F','A','I','V','L','P','E','K','Q','D','T'};
	static final char[] ROTOR8 = new char[]{'F','K','Q','H','T','L','X','O','C','B','J','S','P','D','Z','R','A','M','E','W','N','I','U','Y','G','V'};
	static final char[] REFLECTORB = new char[]{'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'};

	static int[] DefaultInt = new int[26];
	static int[] Rotor1Int = new int[26];
	static int[] Rotor2Int = new int[26];
	static int[] Rotor3Int = new int[26];
	static int[] Rotor4Int = new int[26];
	static int[] Rotor5Int = new int[26];
	static int[] Rotor6Int = new int[26];
	static int[] Rotor7Int = new int[26];
	static int[] Rotor8Int = new int[26];
	static int[] PlugInt = new int[26];
	static int[] ReflectorInt = new int[26];
	
	static int[] Rotor1Turn = new int[]{16,16};
	static int[] Rotor2Turn = new int[]{4,4};
	static int[] Rotor3Turn = new int[]{21,21};
	static int[] Rotor4Turn = new int[]{9,9};
	static int[] Rotor5Turn = new int[]{25,25};
	static int[] Rotor6Turn = new int[]{12,25};
	static int[] Rotor7Turn = new int[]{12,25};
	static int[] Rotor8Turn = new int[]{12,25};
	

/**
 * for this debugger enter the input as follows in console:
 * @param args[0-2] rotor numbers, left to right 
 * args[3-5] ring settings, as characters, left to right
 * args[6-8] grund settings, as characters, left to right
 * args[9] input string
 * example: 1 2 3 A A A A A A wewillsolvethishavehope
 */
public static void main(String[] args){
	if(args.length<10)
	{
		System.out.println("Not enough argumentss passed. Read the damn comments in program code."); System.exit(1);
	}
	int leftRotor = Integer.parseInt(args[0]);
	int middleRotor = Integer.parseInt(args[1]);
	int rightRotor = Integer.parseInt(args[2]);
	int leftRing = charToInt(args[3].charAt(0));
	int middleRing = charToInt(args[4].charAt(0));
	int rightRing = charToInt(args[5].charAt(0));
	int leftGround = charToInt(args[6].charAt(0));
	int middleGround = charToInt(args[7].charAt(0));
	int rightGround = charToInt(args[8].charAt(0));
	String input = args[9];
	int[] settings = {leftRotor, middleRotor, rightRotor, leftRing, middleRing,
			rightRing, leftGround, middleGround, rightGround};
	String output = enc(settings, input);
	System.out.println("Output: " + output);
}
	
public static String enc(int[] settings, String inputString)
{
	convertArrays();
	int leftRotor = settings[0];
	int middleRotor = settings[1];
	int rightRotor = settings[2];
	int leftRing = settings[3];
	int middleRing = settings[4];
	int rightRing = settings[5];
	int leftGround = settings[6];
	int middleGround = settings[7];
	int rightGround = settings[8];
	
	int[] rightRotorArray;
	int[] middleRotorArray;
	int[] leftRotorArray;
	
	if(rightRotor==1) rightRotorArray = Rotor1Int; 
	else if(rightRotor==2) rightRotorArray = Rotor2Int;
	else if(rightRotor==3) rightRotorArray = Rotor3Int;
	else if(rightRotor==4) rightRotorArray = Rotor4Int;
	else if(rightRotor==5) rightRotorArray = Rotor5Int;
	else if(rightRotor==6) rightRotorArray = Rotor6Int;
	else if(rightRotor==7) rightRotorArray = Rotor7Int;
	else rightRotorArray = Rotor8Int;
	
	if(middleRotor==1) middleRotorArray = Rotor1Int; 
	else if(middleRotor==2) middleRotorArray = Rotor2Int;
	else if(middleRotor==3) middleRotorArray = Rotor3Int;
	else if(middleRotor==4) middleRotorArray = Rotor4Int;
	else if(middleRotor==5) middleRotorArray = Rotor5Int;
	else if(middleRotor==6) middleRotorArray = Rotor6Int;
	else if(middleRotor==7) middleRotorArray = Rotor7Int;
	else middleRotorArray = Rotor8Int;
	
	if(leftRotor==1) leftRotorArray = Rotor1Int; 
	else if(leftRotor==2) leftRotorArray = Rotor2Int;
	else if(leftRotor==3) leftRotorArray = Rotor3Int;
	else if(leftRotor==4) leftRotorArray = Rotor4Int;
	else if(leftRotor==5) leftRotorArray = Rotor5Int;
	else if(leftRotor==6) leftRotorArray = Rotor6Int;
	else if(leftRotor==7) leftRotorArray = Rotor7Int;
	else leftRotorArray = Rotor8Int;
	
	//determines the spots where the rotors will the turn the next one
	int middleRotorTurn[];
	int rightRotorTurn[];
	
	if(middleRotor==1) middleRotorTurn = Rotor1Turn; 
	else if(middleRotor==2) middleRotorTurn = Rotor2Turn;
	else if(middleRotor==3) middleRotorTurn = Rotor3Turn;
	else if(middleRotor==4) middleRotorTurn = Rotor4Turn;
	else if(middleRotor==5) middleRotorTurn = Rotor5Turn;
	else if(middleRotor==6) middleRotorTurn = Rotor6Turn;
	else if(middleRotor==7) middleRotorTurn = Rotor7Turn;
	else middleRotorTurn = Rotor8Turn;
	
	if(rightRotor==1) rightRotorTurn = Rotor1Turn; 
	else if(rightRotor==2) rightRotorTurn = Rotor2Turn;
	else if(rightRotor==3) rightRotorTurn = Rotor3Turn;
	else if(rightRotor==4) rightRotorTurn = Rotor4Turn;
	else if(rightRotor==5) rightRotorTurn = Rotor5Turn;
	else if(rightRotor==6) rightRotorTurn = Rotor6Turn;
	else if(rightRotor==7) rightRotorTurn = Rotor7Turn;
	else rightRotorTurn = Rotor8Turn;
		
	char[] input = inputString.toCharArray();
	char[] output = new char[inputString.length()];
	
	for(int i=0; i<inputString.length(); i++)
	{	
		//regular turning spots	
		if(rightGround == rightRotorTurn[0] || rightGround == rightRotorTurn[1]){
			if(middleGround == middleRotorTurn[0] || middleGround == middleRotorTurn[1]){
				leftGround = (leftGround + 1) % 26;
				}
		middleGround = (middleGround + 1) % 26;
		
		}
		else{
			//double step
			if(middleGround == middleRotorTurn[0] || middleGround == middleRotorTurn[1]){
				leftGround = (leftGround + 1) % 26;
				middleGround = (middleGround + 1) % 26;
				}
		}
		
		//turn for right rotor each run
		rightGround = (rightGround + 1) % 26;
				
		int c = charToInt(input[i]);
		c = PlugSwap(c);
		c = rotor(c, rightRotorArray, rightGround, rightRing);
		c = rotor(c, middleRotorArray, middleGround, middleRing);
		c = rotor(c, leftRotorArray, leftGround, leftRing);
		c = ReflectorB(c);
		c = rotorInverse(c, leftRotorArray, leftGround, leftRing);
		c = rotorInverse(c, middleRotorArray, middleGround, middleRing);
		c = rotorInverse(c, rightRotorArray, rightGround, rightRing);
		c = PlugSwap(c);
		
		output[i] = intToChar(c);
	
	}
	String outputString = new String(output);
	return outputString;
	
}
	
public static int rotor(int inputChar, int[] inputRotor, int GrundSetting, int RingSetting){
	//takes value and adds the grund shift value.
	int AdjustedValue = ((inputChar + GrundSetting) - RingSetting + 26) % 26;
	//takes output from array and subtracts grund shift value.
	int ReturnValue = (inputRotor[AdjustedValue] - GrundSetting + RingSetting + 26) % 26;
	
	return ReturnValue;
}
	
public static int rotorInverse(int inputChar, int[] inputRotor, int grundSetting, int RingSetting){
	char[] Default = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	int[] DefaultInt = new int[26];
	for(int a = 0; a < 26 ; a++){
		DefaultInt[a] = charToInt(Default[a]);
	}
		
	//takes value and subtracts the grund shift value.
	int AdjustedValue = ((inputChar + grundSetting - RingSetting) + 26) % 26;
			
	int index = 0;
	while(inputRotor[index] != AdjustedValue){
		index++;
	}
	
	index = (index - grundSetting + RingSetting + 26) % 26;
	
	//takes output from array and subtracts grund shift value.
	return DefaultInt[index];
}
	

public static int ReflectorB(int inputChar){	
	return ReflectorInt[inputChar];
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
	boolean Check = false;
	for(int a = 0; a < 26 && Check == false ; a++){
		if(Input == DEFAULT[a]){
				Check = true;
			}
	}
	return Check;
}
	
//Converts input into the plug swapped value.
public static int PlugSwap(int Input){
		return charToInt(Plug[Input]);
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

/**
 * @deprecated Stan's old implementation of rotation -- Kevin made better implementation
 * decides whether the middle rotor should be turn based on the number and position of right rotor
 * @return whether or not middle rotor should be rotated 
 */
private static boolean turnMiddle(int rightRotor, int position)
{
	if((rightRotor==6||rightRotor==7||rightRotor==8)&&(position==0||position==13))
		return true;
	if((rightRotor==1)&&(position==17)) return true;
	if((rightRotor==2)&&(position==5)) return true;
	if((rightRotor==3)&&(position==22)) return true;
	if((rightRotor==4)&&(position==10)) return true;
	if((rightRotor==5)&&(position==0)) return true;
	return false;
}

/**
 * @deprecated
 * decides whether the left rotor should be turn based on the number and position of middle rotor
 * @return whether or not middle rotor should be rotated
 */
private static boolean turnLeft(int middleRotor, int position)
{
	if((middleRotor==6||middleRotor==7||middleRotor==8)&&(position==0||position==13))
		return true;
	if((middleRotor==1)&&(position==17)) return true;
	if((middleRotor==2)&&(position==5)) return true;
	if((middleRotor==3)&&(position==22)) return true;
	if((middleRotor==4)&&(position==10)) return true;
	if((middleRotor==5)&&(position==0)) return true;
	return false;
}
	
	/**
	 * I think we need to remove this part and update the original arrays instead to int... more efficient- Stan
	 */
	private static void convertArrays()
	{
		//convert them into int arrays for easier usage
		for(int a = 0; a < 26 ; a++){
			DefaultInt[a] = charToInt(DEFAULT[a]);
			Rotor1Int[a] = charToInt(ROTOR1[a]);
			Rotor2Int[a] = charToInt(ROTOR2[a]);
			Rotor3Int[a] = charToInt(ROTOR3[a]);
			Rotor4Int[a] = charToInt(ROTOR4[a]);
			Rotor5Int[a] = charToInt(ROTOR5[a]);
			Rotor6Int[a] = charToInt(ROTOR6[a]);
			Rotor7Int[a] = charToInt(ROTOR7[a]);
			Rotor8Int[a] = charToInt(ROTOR8[a]);
			ReflectorInt[a] = charToInt(REFLECTORB[a]);
		}
		PlugInt = DefaultInt.clone();
	}
}