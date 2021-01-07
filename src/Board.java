public class Board {

    private char[][] board = new char[][]{  {' ', '|', ' ', '|', ' '},
                                            {'-', '*', '-', '*', '-'},
                                            {' ', '|', ' ', '|', ' '},
                                            {'-', '*', '-', '*', '-'},
                                            {' ', '|', ' ', '|', ' '} };;

    public char[][] getBoard() {
        return board;
    }

    public char getMovement(int x, int y){
        return board[x][y];
    }

    public void printBoard() {
        for (int i = 0; i < getBoard().length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(getMovement(i,j));
            }
            System.out.println();
        }
    }

    public void setMark(int x, int y, char mark){
        board[x][y] = mark;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }
}
