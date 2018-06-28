public class Permutations{

	public static  void generatePerm(String str){
		generatePerm(str, "");

	}

	// Run time = O (n^2 * n!)
	//not efficient
	public static void generatePerm(String str, String prefix){
		if(str.length() == 0) System.out.println(prefix); //base case 

		//recursive call
		else{
			for(int i = 0; i < str.length(); i++)
			{
				String rem = str.substring(0, i) + str.substring(i+1);

				generatePerm(rem, prefix + str.charAt(i));
				System.out.println("Rem : " + rem + " Prefix: " + prefix);
			}
		}

	}

	public static boolean checkPerm(String s1, String s2){
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		java.util.Arrays.sort(str1);
		java.util.Arrays.sort(str2);

		return new String(str1).equals(new String(str2));	

	}

	//method 2 assuming chars are ascii
	public static boolean checkPerm2(String s1, String s2){
		if(s1.length() != s2.length()) return false;

		int[] table = new int[128];
		for(int i = 0 ; i < s1.length(); i++)
		{
			table[s1.charAt(i)]++;;
		}
		for(int i = 0 ; i < s2.length(); i++)
		{
			table[s2.charAt(i)]--;
			if(table[s2.charAt(i)] < 0) return false;
		}
			
		return true; //letters have no neg value, and therefore no pos value either
	}

	public static void main(String[] args)
	{
		String a =  "carrot";
		String b  = "arorct";

		String ap = "apploe";
		String app = "pplpea";

			
		System.out.println(checkPerm2(a, b));
		System.out.println(checkPerm2(ap, app));

		//generatePerm(a);
		//generatePerm(b);
		

	}
}