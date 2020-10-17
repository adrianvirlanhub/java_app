package Exercices;

public class Sudoku {
    
    public static int[][] gameBoard = {{8,0,0,0,0,0,0,0,0},
                                        {0,0,3,6,0,0,0,0,0},
                                        {0,7,0,0,9,0,2,0,0},
                                        {0,5,0,0,0,7,0,0,0},
                                        {0,0,0,0,4,5,7,0,0},
                                        {0,0,0,1,0,0,0,3,0},
                                        {0,0,1,0,0,0,0,6,8},
                                        {0,0,8,5,0,0,0,1,0},
                                        {0,9,0,0,0,0,4,0,0}};
    private int[][] board;

    public Sudoku(int[][] board){
        this.board = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.board[i][j] = board[i][j];
            }
        }
    }

    //we check if a possible number is already in arow
    private boolean rowCond(int row, int number){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == number)
            return true;
        }
        return false;
    }

    //we check if a possible number is already in a column
    private boolean colCond(int column, int number){
        for(int i = 0; i < 9; i++){
            if(board[i][column] == number)
            return true;
        }
        return false;
    }

    //we check if a possible number is in subsistem
    private boolean subSectCond(int row, int column, int number){
        int r = row - row % 3;
        int c = column - column % 3;
        for(int i = r; i < r + 3 ; i++){
            for(int j = c; j < c + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    // a method that checks all conditions ar met
    private boolean isValid(int row, int column, int number){
        return !colCond(column, number)  && !rowCond(row, number) && !subSectCond(row, column, number);        
    }

    // solver method using backtracking algo
    public boolean solve(){
        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                //searching for an empty cell
                if(board[row][column] == 0){
                    //give possible numbers
                    for(int number = 1; number <= 9; number++){
                        if(isValid(row,column,number)){
                            board[row][column] = number;
                            //start of recursive backtracking
                            if (solve()){
                                return true;
                            }else{
                                board[row][column] = 0;//when the solve fails 
                            }
                        }
                    }
                    return false;//not solved
                }
            }
        }
        return true;//solved
    }

    public void printBoard(){
        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++){
                System.out.print(" "+ board[row][column]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Sudoku sudoku = new Sudoku(gameBoard);
        System.out.println("Sudoku to solve:");
        sudoku.printBoard();
        sudoku.solve();
        if(sudoku.solve()){
            System.out.println("Solved! Here is the solution:");
            sudoku.printBoard();
        }else{
            System.out.println("Unsolvable...");
        }
    }
}
