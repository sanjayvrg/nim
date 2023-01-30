import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class NimGame {
    private ArrayList<Player> players;
    private int pileSize;
    private Player currentPlayer;
    private Random rand;
    private Scanner sc;
    private int numPlayers;
// constructor that creates new instance of the game
  public NimGame() {
    sc = new Scanner(System.in);
    System.out.print("How many players? ");
    numPlayers = sc.nextInt();
    players = new ArrayList<Player>();
    // loop through number of players, asking for player name and creating new player object
    for (int i = 0; i < numPlayers; i++) {
        System.out.print("Enter player " + (i+1) + " name: ");
        String name = sc.next();
        players.add(new Player(name));
    }
    rand = new Random();
    // sets pile size between 10-50
    pileSize = rand.nextInt(41) + 10;
    currentPlayer = players.get(rand.nextInt(numPlayers));
}

  public void play() {
    // randomly select starting player
    currentPlayer = players.get(rand.nextInt(players.size()));
    while (pileSize > 1) {
        System.out.println("Pile size: " + pileSize);
        System.out.println(currentPlayer.getName() + " it's your turn.");
        int piecesToTake = 0;
        if (pileSize <= 1) {
            piecesToTake = 1;
        } else {
            System.out.print("How many pieces would you like to take? ");
            piecesToTake = sc.nextInt();
            // check if move is valid
            while (piecesToTake < 1 || piecesToTake > pileSize / 2) {
                System.out.println("Invalid move. Please take at least one piece and no more than half the pile size.");
                System.out.print("How many pieces would you like to take? ");
                piecesToTake = sc.nextInt();
            }
            pileSize -= piecesToTake;
        }
        // change current player to next player
        currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }
    System.out.println("The game is over.");
    if (pileSize == 1) {
        System.out.println(currentPlayer.getName() + " loses!");
    }
    System.out.println("Scores: ");
    for (Player p : players) {
        if (p != currentPlayer) {
            p.incrementScore();
        }
    }
    for (Player p : players) {
        System.out.println(p.getName() + ": " + p.getScore());
    }
    System.out.print("Would you like to play again? (y/n) ");
    String playAgain = sc.next();
    if (playAgain.equals("y")) {
        pileSize = rand.nextInt(41) + 10;
        play();
    } 
  }
}
