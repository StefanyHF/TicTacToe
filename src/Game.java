import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Board board = new Board();
    Player player1 = new Player();
    Player player2 = new Player();
    Player currentPlayer = new Player();
    boolean hasWinner;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> usedPosition = new ArrayList<>();

    public void start() {
        System.out.println("Digite o nome do jogador 1 : ");
        player1.setName(scanner.next());
        System.out.println("Digite o nome do jogador 2 : ");
        player2.setName(scanner.next());
        System.out.println(getFirstPlayer() + " voce comeca!");
        board.printBoard();
    }

    public String getFirstPlayer() {
        Random r = new Random();
        int i = r.nextInt(2);
        switch (i) {
            case 0:
                currentPlayer.setName(player1.getName());
                player1.setMark('X');
                player2.setMark('O');

            case 1:
                currentPlayer.setName(player2.getName());
                player2.setMark('X');
                player1.setMark('O');

            default:
                break;
        }
        currentPlayer.setMark('X');
        return currentPlayer.getName();
    }

    public void getUserInput() {
        while (hasWinner == false) {
            System.out.println(currentPlayer.getName() + " digite uma posicao (1-9).");
            int i = scanner.nextInt();
            int check = usedPosition.indexOf(i);
            if (check < 0) {
                System.out.println("Posicao ja escolhida. Escolha outra.");
                break;
            } else {

                switch (i) {
                    case 1:
                        board.setMark(0, 0, currentPlayer.getMark());
                        usedPosition.add(1);
                        break;
                    case 2:
                        board.setMark(0, 2, currentPlayer.getMark());
                        usedPosition.add(2);
                        break;
                    case 3:
                        board.setMark(0, 4, currentPlayer.getMark());
                        usedPosition.add(3);
                        break;
                    case 4:
                        board.setMark(2, 0, currentPlayer.getMark());
                        usedPosition.add(4);
                        break;
                    case 5:
                        board.setMark(2, 2, currentPlayer.getMark());
                        usedPosition.add(5);
                        break;
                    case 6:
                        board.setMark(2, 4, currentPlayer.getMark());
                        usedPosition.add(6);
                        break;
                    case 7:
                        board.setMark(4, 0, currentPlayer.getMark());
                        usedPosition.add(7);
                        break;
                    case 8:
                        board.setMark(4, 2, currentPlayer.getMark());
                        usedPosition.add(8);
                        break;
                    case 9:
                        board.setMark(4, 4, currentPlayer.getMark());
                        usedPosition.add(9);
                        break;
                    default:
                        System.out.println("Posicao invalida. Escolha outra");
                }
                board.printBoard();
                switchPlayer();
            }
            checkWinner();
        }
    }

    public void switchPlayer() {
        if (currentPlayer.getName() == player1.getName()) {
            System.out.println(player2.getName() + " eh sua vez.");
        } else {
            System.out.println(player1.getName() + " eh sua vez.");
        }
        if (currentPlayer.getMark() == 'X') {
            currentPlayer.setMark('O');
        }
    }
    public boolean checkWinner(){
        int possibilities = 8;
        for(int i = 1; i < possibilities; i++ ){
            switch (i){
                case 1:
                    (board.getMovement(0,0) == 'X') || (board.getMovement(0,2) == 'X') ||
                            (board.getMovement(0,4) == 'X');
                    hasWinner = true;
                case 2 :
                    board.getMovement(0,0) == 'X' || board.getMovement(0,2) == 'X' ||
                            board.getMovement(0,4) == 'X';

            }
        }

    }
}

