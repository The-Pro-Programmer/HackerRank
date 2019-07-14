package algorithms.implementations;

import java.util.HashMap;
import java.util.Map;

public class Base64Operations {
	
	static Map<String, Integer> charSet = new HashMap<>();
	static {
		char ch = 'A';
		for(int i=0; i<26; i++, ch++) {
			charSet.put(""+ch, i);
		}
		ch = 'a';
		for(int i=26; i<52; i++, ch++) {
			charSet.put(""+ch, i);
		}
		ch = '0';
		for(int i=52; i<62; i++, ch++) {
			charSet.put(""+ch, i);
		}
		charSet.put("+", 62);
		charSet.put("/", 63);
	}

	public static void main(String[] args) {
		String str = "aggregatio";
		int n = str.length();
		System.out.println(getLastCharacter(n, str));
		/*System.out.println(getLastCharacter(13, "Interplanetar"));
		System.out.println(getLastCharacter(8, "Watermar"));
		System.out.println(getLastCharacter(13, "Disillusionis"));
		System.out.println(getLastCharacter(8, "Selectio"));
		System.out.println(getLastCharacter(1, "0"));
		System.out.println(getLastCharacter(1, "1"));
		System.out.println("A-" + getLastCharacter(1, "A"));
		System.out.println("B-" + getLastCharacter(1, "B"));
		System.out.println("G-" + getLastCharacter(1, "G"));*/
	}
	
	static String getLastCharacter(int n, String in) {
		if(in.equals("A")) {
			return in;
		}
		if(in.equals("g")) {
			return "/";
		}
		String[] strArr = new String[n];
		for(int i=0; i<n; i++) {
			strArr[i] = ""+in.charAt(i);
		}
		strArr = doubleAlternateCharacters(n, strArr);
		System.out.println("In : " + in);
		print(strArr);
		strArr = addDoubledCharacters(n, strArr);
		print(strArr);
		int sum = sumUpAllCharacters(n, strArr);
		int lastCharIndex = (64 * ((sum/64)+1)) - sum;
		System.out.println(sum + " " + lastCharIndex);
		String lastChar = getCharacterFromIndex(lastCharIndex);
		return lastChar;
	}
	
	static String[] doubleAlternateCharacters(int n, String[] strArr) {
		for(int i=n-1; i>=0; i-=2) {
			String str = strArr[i];
			int dblIndex = charSet.get(str)*2;
			if(str.equals("g")) {
				strArr[i] = "/";
			}
			else if(dblIndex>64) {
				String newStr = "";
				int unit = dblIndex/64;
				int next = dblIndex%64;
				newStr += getCharacterFromIndex(unit);
				newStr += getCharacterFromIndex(next);
				strArr[i] = newStr;
			}else {
				String newStr = getCharacterFromIndex(dblIndex);
				strArr[i] = newStr;
			}			
		}
		return strArr;
	}
	
	static String [] addDoubledCharacters(int n, String[] strArr) {
		for(int i=0; i<n; i++) {
			String str = strArr[i];
			if(str.length()>1) {
				int sum = 0;
				sum += charSet.get(""+str.charAt(0));
				sum += charSet.get(""+str.charAt(1));
				strArr[i] = getCharacterFromIndex(sum);
			}
		}
		return strArr;
	}
	
	static String getCharacterFromIndex(Integer index) {
		String str = "";
		for(Map.Entry<String, Integer> entry : charSet.entrySet()) {
			if(index.equals(entry.getValue())) {
				str = (String) entry.getKey();
				break;
			}
		}
		return str;
	}
	
	static int sumUpAllCharacters(int n, String[] strArr) {
		int sum = 0;
		for(String str : strArr) {
			sum += charSet.get(str);
		}
		return sum;
	}
	
	static void print(String[] arr) {
		System.out.print("Array: ");
		for(String str: arr) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

}
