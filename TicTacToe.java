
/**
 * Write a description of class TicTacToe here.
 * 
 * @author Cole DiGrazia 
 * @version 0.1
 */

import java.util.*;
public class TicTacToe
{
    static String[] board = new String[9];

    public static int getInput(){
        Scanner getInput = new Scanner(System.in);
        int inpt = getInput.nextInt();
        return inpt;
    }

    public static String drawBoard(){
        String boardLayout = " ";
        boardLayout += (" "+board[0]+" | "+board[1]+" | "+board[2]+"  \n");
        boardLayout += ("----|---|----\n");
        boardLayout += (" "+board[3]+"  | "+board[4]+" | "+board[5]+"  \n");
        boardLayout += ("----|---|----\n");
        boardLayout += (" "+board[6]+"  | "+board[7]+" | "+board[8]+"  \n");
        return boardLayout;
    }

    public static void makeABoard(){
        for (int i = 0; i < 9; i++){
            board[i] = " ";
        }
    }

    public static String checkEnd(){
        if (board[0].equals(board[1])&&board[1].equals(board[2])){
            return board[0];
        }
        else if (board[3].equals(board[4])&&board[4].equals(board[5])){
            return board[3];
        }
        else if (board[6].equals(board[7])&&board[7].equals(board[8])){
            return board[6];
        }
        else if (board[1].equals(board[4])&&board[4].equals(board[7])){
            return board[1];
        }
        else if (board[2].equals(board[5])&&board[5].equals(board[8])){
            return board[5];
        }
        else if (board[0].equals(board[3])&&board[3].equals(board[6])){
            return board[0];
        }
        else if (board[0].equals(board[4])&&board[4].equals(board[8])){
            return board[0];
        }
        else if (board[2].equals(board[4])&&board[4].equals(board[6])){
            return board[2];
        }
        else {
            return "nothing"; 
        }
    }

    public static String getMark(String currentPlayer){
        if (currentPlayer.equals("x")){
            currentPlayer = "o";
        }
        else if (currentPlayer.equals("o")){
            currentPlayer = "x";
        }
        return currentPlayer;
    }
    
    public static Boolean checkMove(int position){
        if (!board[position].equals("x") && !board[position].equals("o")){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        makeABoard();
        drawBoard();
        String currentPlayer = "x";
        int pos = 10;
        for (int i = 0; i < 9; i++) {
            
            boolean next = false;
            while (!next){
                System.out.println("Next Move");
                pos = getInput();
                next = checkMove(pos);
            }
            board[pos] = currentPlayer;
            System.out.print(drawBoard());
            if (checkEnd().equals("x") || checkEnd().equals("o")){
                System.out.println(checkEnd() + " Wins!");
                break;
            }
            currentPlayer = getMark(currentPlayer);
        }
        drawBoard();
    }
}

