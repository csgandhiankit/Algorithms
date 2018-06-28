import java.util.*;
import java.io.*;

public class MissingNumbers{



     
    public static void processLists(int[] l1, int[] l2)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for(int i : l1)
        {
            if(!map.containsKey(i))
            {
                map.put(i, 1);
            }
            else{
                map.put(i, map.get(i) + 1);
            }
        }

        for(int i : l2)
        {
             if(!map2.containsKey(i))
            {
                 
                map2.put(i, 1);
            }
            else{
                map2.put(i, map2.get(i) + 1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i : map2.keySet())
        {
            if(!map.containsKey(i))
            {
                result.add(i);
            }else if(map.containsKey(i)){
                if(map2.get(i) > map.get(i))
                {
                    result.add(i);
                }
            }
        }
        Collections.sort(result);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size1 = in.nextInt();

        int[] list1 = new int[size1];
        for(int i = 0; i < size1; i++)
        {
            list1[i] = in.nextInt();
        
        }
        int size2 = in.nextInt();
    
        int[] list2 = new int[size2];
        for(int i = 0; i < size2; i++)
        {
            list2[i] = in.nextInt();
        }
        processLists(list1, list2);



  //       10
		// 203 204 205 206 207 208 203 204 205 206
		// 13
		// 203 204 204 205 206 207 205 208 203 206 205 206 204
    }
}