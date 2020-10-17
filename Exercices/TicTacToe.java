package Exercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args){
        char[][] gameBoard = {{' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '},
        {'-','+','-','+','-'},
        {' ','|',' ','|',' '}};
        Scanner scanner = new Scanner(System.in);

        printGameBoard(gameBoard);

        while(true){
            
            System.out.print("Your turn. Enter your placement (1-9):");
            int playerPosition = scanner.nextInt();
            while(playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)){
                playerPosition = scanner.nextInt();
            }

            placeX(gameBoard, playerPosition, "player");
            printGameBoard(gameBoard);

            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            System.out.println("CPU turn");
            while(playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)){
                cpuPosition = random.nextInt(9) + 1;
            }

            placeX(gameBoard, cpuPosition, "cpu");
            printGameBoard(gameBoard);   

            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
        scanner.close();
    }

    public static void printGameBoard(char[][] gameBoard){
        

        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placeX(char[][] gameBoard, int position, String user){
        
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch(position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner(){

        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);
        List<Integer> lftCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> rgtCol = Arrays.asList(3,6,9);
        List<Integer> diag1 = Arrays.asList(1,5,9);
        List<Integer> diag2 = Arrays.asList(7,5,3);

        @SuppressWarnings("rawtypes")
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(lftCol);
        winning.add(midCol);
        winning.add(rgtCol);
        winning.add(diag1);
        winning.add(diag2);

        for (List<?> l: winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations! YOU WON!";
            } else if(cpuPositions.containsAll(l)){
                return "CPU WON!";
            } else if(playerPositions.size() + cpuPositions.size() == 9){
                return "TIE!";
            }
        }
        

        return "";
    }
}
