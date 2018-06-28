public class LongestConsChar{



//O(N) runtime , space complexity O(1)
	public static void findLongestConsChar(String s){

		int maxCt = 0;
		int tempCt = 1;
		char maxChar = '\0';
		char ch = '\0';
		for(int i = 0; i < s.length() -1; i++){
			if(s.charAt(i) == s.charAt(i + 1)){
				ch = s.charAt(i);
				tempCt++;
			}else{
				tempCt = 1;
			}
			if(tempCt > maxCt){
				System.out.println("maxchar: " + ch + " count : "+ maxCt);
					maxCt = tempCt;
					maxChar = ch;
			}		
		

		}

		System.out.println("Max char :" + maxChar + " Count : " + maxCt);

	}


	public static void main(String[] args) {
		String[] tests = {"BCDDBBBBEA", "AAAAAAAABDEEFFEEDDEEEEE", "aaaabbbb", "AAASSSSEEEEEEE", "AA", "a"};

		for(String s: tests){
			findLongestConsChar(s);
		}
	}
}