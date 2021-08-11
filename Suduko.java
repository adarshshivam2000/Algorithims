import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    if(i==board.length){
        display(board);
        return;
    }
    int ni =0;
    int nj =0;
    if(j==board[0].length-1){
        ni = i+1;
        nj=0;
    }
    else{
        ni=i;
        nj=j+1;
    }
    
    if(board[i][j]!=0)
    {
        solveSudoku(board,ni,nj);
    }
    else{
        for(int po=1;po<=9;po++){ // posible option =po
            if(Isvalid(board,i,j,po)){
                board[i][j]=po;
                solveSudoku(board,ni,nj);
                board[i][j]=0;
            }
        }
    }
  }
  
  public static boolean Isvalid(int arr[][], int X , int Y, int pos){

        for(int j=0; j<arr[0].length;j++)
        {
            if(arr[X][j]==pos)
            return false;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i][Y]==pos)
            return false;
        }
        
        int x = X/3 *3;
        int y = Y/3*3;
        for(int ival =0;ival<3;ival++)
        {
            for(int jval=0;jval<3;jval++){
                if(arr[x+ival][y+jval]==pos)
                return false;
            }
        }
        return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
