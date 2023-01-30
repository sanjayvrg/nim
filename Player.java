class Player {
  private String name; // variable to hold the player's name
  private int score; // variable to hold the player's score
  public Player(String name) {
    // constructor that takes a string as input and assigns it to the name variable and initializes the score variable to 0
    this.name = name;
    this.score = 0;
}

  public String getName() {
    // method to return the player's name
    return name;
}

  public int getScore() {
    // method to return the player's score
    return score;
}

  public void incrementScore() {
    // method to increment the player's score by 1
    score++;
}


