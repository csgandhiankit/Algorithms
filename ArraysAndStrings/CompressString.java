public class CompressString{

	public static String compress(String s){
		StringBuilder sb = new StringBuilder();
		int[] table = new int[26];
		for(int i = 0; i < s.length(); i++){
			
			if(((i + 1) < (s.length())) && s.charAt(i) == s.charAt(i+1)){
				table[s.charAt(i) - 'a']++;
				//System.out.println(table[s.charAt(i) - 'a']);
			}
			else{
				table[s.charAt(i) - 'a']++;
				System.out.println(i);
				//System.out.println(table[s.charAt(i) - 'a']);
				sb.append(s.charAt(i));
				sb.append(table[s.charAt(i) - 'a']);
				table = new int[26];
			}
		
		}

		return sb.toString().length() < s.length() ? sb.toString() : s;
	}

	//Method 2
	public static String compressStr(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}



	public static void main(String[] args)
	{
		String s = "aabcccccaaaaa";
		String exp = "a2b1c5a5";

		String actual = compress(s);
		if(actual.equals(exp)){
			System.out.println("Expected: " + exp + " Actual: " + actual);

		}
		//System.out.println("Expected: " + exp + " Actual: " + actual);
	}
}