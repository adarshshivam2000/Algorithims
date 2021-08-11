import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    boolean cols [] =new boolean[n];
    boolean LtoRdia [] = new boolean[2*n-1];
    boolean RtoLdia [] = new boolean[2*n-1];
    
    solution(board,cols,LtoRdia,RtoLdia,"",0);
    
    
  }
  
  public static void solution(boolean[][] board,boolean cols [] ,boolean LtoRdia [] ,boolean RtoLdia [],String asf,int row){
      if(row==board.length)
      {
          System.out.println(asf+".");
          return;
      }
      //col ko i ke jagah liye h
      for(int i=0;i<board[0].length;i++){
          if(cols[i]==false && LtoRdia[i+row]==false && RtoLdia[row-i+board.length-1]==false){
             board[row][i]=true;
              cols[i]=true ;
              LtoRdia[i+row]=true;
              RtoLdia[row-i+board.length-1]=true;
              
              solution(board,cols,LtoRdia,RtoLdia,asf+row+"-"+i+", ",row+1);
              
              board[row][i]=false;
              cols[i]=false ;
              LtoRdia[i+row]=false;
              RtoLdia[row-i+board.length-1]=false;
              
          }
      }
  }

}
