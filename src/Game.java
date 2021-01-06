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
        while (!hasWinner) {
            System.out.println(currentPlayer.getName() + " digite uma posicao (1-9).");
            int i = scanner.nextInt();
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
                checkWinner();
                switchPlayer();
            }
        System.out.println(currentPlayer.getName() + "voce ganhou.");
        }

    public void switchPlayer() {
        if (currentPlayer.getName().equals(player1.getName())){
            currentPlayer.setName(player2.getName());
        }else {
            currentPlayer.setName(player1.getName());}
        if (currentPlayer.getMark() == 'X') {
            currentPlayer.setMark('O');
        } else {
            currentPlayer.setMark('X');
        }
        System.out.println(currentPlayer.getName() + " eh sua vez.");
    }
    public void checkWinner(){
        if((board.getMovement(0, 0) != ' ') && (board.getMovement(0, 0) == board.getMovement(0, 2)) &&
                           (board.getMovement(0, 2) == board.getMovement(0, 4))) {
            hasWinner = true;
        }else if ((board.getMovement(2, 0) != ' ') && (board.getMovement(2, 0) == board.getMovement(2, 2)) &&
                (board.getMovement(2, 2) == board.getMovement(2, 4))) {
            hasWinner = true;
        }else if((board.getMovement(4, 0) != ' ') && (board.getMovement(4, 0) == board.getMovement(4, 2)) &&
                (board.getMovement(4, 2) == board.getMovement(4, 4))){
            hasWinner = true;
        }else if((board.getMovement(0, 0) != ' ') && (board.getMovement(0, 0) == board.getMovement(2, 0)) &&
                (board.getMovement(2, 0) == board.getMovement(4, 0))) {
            hasWinner = true;
        }else if((board.getMovement(0, 2) != ' ') && (board.getMovement(0, 2) == board.getMovement(2, 2)) &&
                (board.getMovement(2, 2) == board.getMovement(4, 2))) {
            hasWinner = true;
        }else if((board.getMovement(0, 4) != ' ') && (board.getMovement(0, 4) == board.getMovement(2, 4)) &&
                (board.getMovement(2, 4) == board.getMovement(4, 4))) {
            hasWinner = true;
        }else if((board.getMovement(0, 0) != ' ') && (board.getMovement(0, 0) == board.getMovement(2, 2)) &&
                (board.getMovement(2, 2) == board.getMovement(4, 4))) {
            hasWinner = true;
        }else if((board.getMovement(0, 4) != ' ') && (board.getMovement(0, 4) == board.getMovement(2, 2)) &&
                (board.getMovement(2, 2) == board.getMovement(4, 0))) {
            hasWinner = true;
        }
            }
        }


