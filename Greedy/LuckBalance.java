// Lena is preparing for an important coding competition that is preceded by  sequential preliminary contests. She believes in "saving luck", and wants to check her theory. Each contest is described by two integers,  and :

//  is the amount of luck that can be gained by winning the contest. If Lena wins the contest, her luck balance will decrease by ; if she loses it, her luck balance will increase by .
//  denotes the contest's importance rating. It's equal to  if the contest is important, and it's equal to  if it's unimportant.
// If Lena loses no more than  important contests, what is the maximum amount of luck she can have after competing in all the preliminary contests? This value may be negative.


import java.util.*;
import java.io.*;

public class LuckBalance{

	static class LuckRating{
		private int luck;
		private int rating;
		public LuckRating(int l, int r){
			this.luck = l;
			this.rating = r;
		}
		public static class SortByLuck implements Comparator<LuckRating>{
			@Override
			public int compare(LuckRating l1, LuckRating l2){
				return l1.luck > l2.luck ? 1 : (l1.luck < l2.luck? -1 : 0);
			}
		}
		public static class SortByImportance implements Comparator<LuckRating>{
			@Override
			public int compare(LuckRating l1, LuckRating l2){
				return l1.rating > l2.rating ? -1 : (l1.rating < l2.rating? 1 : 0);
			}
		}

	}

	public static int calcLuck(ArrayList<LuckRating> list, int K)
	{
		int numImportant = 0;
		int totalLuck = 0;
		for(LuckRating l : list){
			int L = l.luck;
			int T = l.rating;
			totalLuck += L;

			if(T == 1) numImportant++;
			
		}
		int compsToWin = numImportant - K;
		int totalLuckLose = 0;
		for(int i =0; i < compsToWin; i++){
			totalLuckLose += list.get(i).luck; 
		}

		return totalLuck - (2*totalLuckLose);


	}



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();

		ArrayList<LuckRating> list = new ArrayList<LuckRating>();
	
		for(int i = 0; i < N; i++){
			int L = in.nextInt();
			int T = in.nextInt();

			list.add(new LuckRating(L, T));
		}
		
		Collections.sort(list, new LuckRating.SortByLuck()); //sort list by luck 
		Collections.sort(list, new LuckRating.SortByImportance()); //sort by importance

		int res = calcLuck(list, K);
		System.out.println(res);
	}
}