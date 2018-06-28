public class URLify{

	//not in place probably less efficient in terms of space complexity
	public static String urlify(String str){
		char[] arr = str.trim().toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : arr)
		{
			if(c == ' ')
			{
				sb.append("%20");
			}
			else
			{
				sb.append(c);
			}
		}
		return sb.toString();
	}

	// method 2 to do replacement in place
	public static void replaceSpaces(char[] arr, int truelength){
		int spacecount = 0, index, i = 0;
		for(i = 0; i < truelength; i++)
		{
			if(arr[i] == ' ')
			{
				spacecount++;
			}
		}
		//System.out.println(spacecount);

		index =  truelength + spacecount * 2;
		//System.out.println(index);
		if(truelength < arr.length) {

			arr[truelength] = '\0';
		}

		for(i = truelength - 1; i >=0; i--)
		{
			if(arr[i] == ' '){
				arr[index-1] = '0';
				arr[index-2] = '2';
				arr[index-3] = '%';
				index = index-3;
			}
			else{
				arr[index-1] = arr[i];
				index--; 
			}
		}
	}

	public static int findTruelength(char[] str)
	{
		int truelength = 0;
		for(int i = str.length - 1; i >= 0; i--)
		{
			if(str[i] != ' ')
			{
				return i;
			}
		}
		return -1;
	}


	public static String charArrayToString(char[] array) {
		StringBuilder buffer = new StringBuilder(array.length);
		for (char c : array) {
			if (c == 0) {
				break;
			}
			buffer.append(c);
		}
		return buffer.toString();
	}


	public static void main(String[] args)
	{
		String test =  "Mr John Smith    ";
		char[] str = test.toCharArray();
		int truelength = findTruelength(str) + 1;
		replaceSpaces(str, truelength);
		
		System.out.println("\"" + charArrayToString(str).trim() + "\"");

	}
}