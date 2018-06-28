public class UniqueChars{



public boolean isUnique(String str){

	char[] arr = str.trim().toCharArray();
	boolean[] table = new boolean[128]; //There are only 128 ASCII chars, hence if length > 128, return false; else create an array of size 128

	for(char c: arr)
	{
		if(table[c]) return false;
		table[c] = true;
	}

	return true;
}


//Method 2 assuming characters from a-z
public boolean hasUniqueChars(String str)
{

	int checker = 0;
	for(int i = 0; i < str.length(); i++)
	{
		int val = str.charAt(i) - 'a';
		System.out.println(checker);
		if((checker & (1 << val)) > 0)
		{
			return false;
		}
		checker |= (1 << val);

	}
	return true;
}

public static void main(String[] args){
	UniqueChars u = new UniqueChars();
	String unique = "abc";
	String non_uni = "HiThereHowYou";
	// System.out.println(u.isUnique(unique));
	// System.out.println(u.isUnique(non_uni));
	System.out.println(u.hasUniqueChars(unique));
	//System.out.println(u.hasUniqueChars(non_uni));

}


}