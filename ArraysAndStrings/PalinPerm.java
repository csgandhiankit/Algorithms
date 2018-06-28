public class PalinPerm{

	public static boolean isPalinPerm(String str){
		str = str.toLowerCase().replaceAll("\\s+", "");
		//System.out.println(str);
		char[] c = str.toCharArray();
		int[] table = new int[26];
		for(char ch: c)
		{
			//System.out.println("in here");
			if(ch - 'a' < 26 && ch - 'a' > 0){
			table[ch - 'a']++;
		}
		else
		{
			//ignore
			//System.out.println(ch);
		}
		}
		int count = 0;
		for(int i: table)
		{
			if(i % 2 == 0)
			{
				//do nothing
			}
			else{
				count++;
			}
		}
		if(count > 1){
			return false;
		}
		return true;

	}



	public static void main(String[] args)
	{

		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac", "Tact Coa" , "atco cta",
							"asda", "sup", "brotha"};
		for(String s: strings){
			//System.out.println(s);
		System.out.println(isPalinPerm(s));
	}


	}
}