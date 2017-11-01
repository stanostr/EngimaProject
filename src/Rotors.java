
public class Rotors {

	/**
	 * for debugging only
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rotorIencrypt('a', 'a'));
	}
	/**
	 * an implementation of rotor 1 for encrypting i.e coming from left to right on the schematic
	 * this will clearly be a very tedious machine to construct but I think this is how each rotor works
	 * @param inputChar self-explanatory
	 * @param groundsetting the letter on the grundstellung of this rotor
	 * @return the output character
	 */
	public static char rotorIencrypt(char inputChar, char groundsetting)
	{
		int output=-1;
		int input = CharConverter.charToInt(inputChar);
		int offset = CharConverter.charToInt(groundsetting);
		input = (input + offset)%26;
		if(input==0) output= 4;
		if(input==1) output=10;
		if(input==2) output= 12;
		if(input==3) output= 5;
		if(input==4) output= 11;
		if(input==5) output= 6;
		if(input==6) output= 3;
		if(input==7) output= 16;
		if(input==8) output= 21;
		if(input==9) output= 25;
		if(input==10) output= 13;
		if(input==11) output= 19;
		if(input==12) output= 14;
		if(input==13) output= 22;
		if(input==14) output= 24;
		if(input==15) output= 7;
		if(input==16) output= 23;
		if(input==17) output= 20;
		if(input==18) output= 18;
		if(input==19) output= 15;
		if(input==20) output= 0;
		if(input==21) output= 8;
		if(input==22) output= 1;
		if(input==23) output= 17;
		if(input==24) output= 2;
		if(input==25) output= 9;
		if(output-offset >= 0) output = output - offset;
		else output = 26-(output-offset);
		return CharConverter.intToChar(output);

	}

}
