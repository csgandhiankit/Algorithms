import java.util.*;
import java.io.*;





class StringComparator implements Comparator<Player>{
       public int compare(Player p1, Player p2)
       {
           String name1 = p1.name;
           String name2 = p2.name;
           int score1 = p1.score;
           int score2 = p2.score;
           if(score2 == score1){
               return name1.compareTo(name2);
           }else{
               return score2 - score1;
           }
       }
    
}



class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        StringComparator checker = new StringComparator();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    // //Input format 
    // 5
    // amy 100
    // david 100
    // heraldo 50
    // aakansha 75
    // aleksa 150


}