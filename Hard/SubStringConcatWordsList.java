import java.util.*;
import java.io.*;

public class SubStringConcatWordsList{

/********************** Brute Force *************************/
	public static List<Integer> findSubstringBF(String s, String[] words) {
       	List<Integer> indices = new ArrayList<Integer>();
       	ArrayList<String> possibleConcat = generateConcat(words);

       	for(String ss: possibleConcat){
       		System.out.println(ss);
       	}
       	

		for(int i  = 0; i < possibleConcat.size(); i++){
			int lastIdx = -1;
			int len = 0;
			while(lastIdx < s.length()){
				String word = possibleConcat.get(i);
				int idx = s.indexOf(word, lastIdx+1);
				
				if(idx != -1)
				{
					indices.add(idx);
					lastIdx = idx;
				}
				if(len++ == s.length()) break;	
			}
		}
		

		return indices;
	}


	 public static ArrayList<String> generateConcat(String[] words){
    	ArrayList<String> possibleConcat = new ArrayList<String>();
    	int len = 0;
    	for(String ss: words){
    		len += ss.length();
    	}
    	generateConcat(words.length, -1, words, "", possibleConcat, len);
 
    	return possibleConcat;
    }

    public static void generateConcat(int n, int excluded, String[] words,  String prefix, ArrayList<String> list, int len){
    	if(n == 0 && len == prefix.length()) list.add(prefix);
    	if(n == 0 ) return;
    	else{
    		for(int i = 0; i < words.length; i++){
    			String rem = prefix.contains(words[i]) ? prefix : prefix + words[i];
    			if(i != excluded) generateConcat(n-1, i, words, rem,  list, len);

    		}
    	}
    }

  /********************* optimal ************************/

	public static List<Integer> findSubstring(String s, String[] words){
 	
	List<Integer> indices = new ArrayList<Integer>();

	if(s == null || words.length == 0 || words == null) return indices;


	int lenWord = words[0].length(); //length per word

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	for(String word : words){
		map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1); //map word frequency 
	}


	for(int i = 0; i <= s.length() - (lenWord * words.length); i++){
		HashMap<String, Integer> temp = new HashMap<String, Integer>(map);

		for(int j = 0; j < words.length; j++){
			String str = s.substring(i + (j*lenWord), i + j*lenWord + lenWord);
			if(temp.containsKey(str)){
				int count = temp.get(str);
					if(count == 1) temp.remove(str);
					else temp.put(str, count - 1);		
					if(temp.isEmpty()){
						indices.add(i);
						break;
					}
					
				} else break;	
			}
		}
		return indices;
    }

   


	public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = {"foo", "bar", "the"};


		String s1 = "wordgoodgoodgoodbestword";
		String[] L = {"word","good","best","good"};

		

		List<Integer> indices = findSubstring(s1, L);
		System.out.println("Indices ...");
		for(int i : indices){
			System.out.print(i + " ");
		}


	}
}