package boggle;

import java.util.HashSet;
import java.util.Set;

/**
 * The BoggleStats class for the first Assignment in CSC207, Fall 2022
 * The BoggleStats will contain statsitics related to game play Boggle 
 */
public class BoggleStats {

    /**
     * set of words the player finds in a given round 
     */  
    private Set<String> playerWords = new HashSet<String>();  
    /**
     * set of words the computer finds in a given round 
     */  
    private Set<String> computerWords = new HashSet<String>();
    /**
     * the player's score for the current round
     */  
    private int pScore; 
    /**
     * the computer's score for the current round
     */  
    private int cScore; 
    /**
     * the player's total score across every round
     */  
    private int pScoreTotal; 
    /**
     * the computer's total score across every round
     */  
    private int cScoreTotal; 
    /**
     * the average number of words, per round, found by the player
     */  
    private double pAverageWords; 
    /**
     * the average number of words, per round, found by the computer
     */  
    private double cAverageWords; 
    /**
     * the current round being played
     */  
    private int round; 

    /**
     * enumarable types of players (human or computer)
     */  
    public enum Player {
        Human("Human"),
        Computer("Computer");
        private final String player;
        Player(final String player) {
            this.player = player;
        }
    }

    /* BoggleStats constructor
     * ----------------------
     * Sets round, totals and averages to 0.
     * Initializes word lists (which are sets) for computer and human players.
     */
    public BoggleStats() {
        round = 0;
        pScore = 0;
        cScore = 0;
        pScoreTotal = 0;
        cScoreTotal = 0;
        pAverageWords = 0;
        cAverageWords = 0;
        playerWords = new HashSet<String>();
        computerWords = new HashSet<String>();

    }

    /* 
     * Add a word to a given player's word list for the current round.
     * You will also want to increment the player's score, as words are added.
     *
     * @param word     The word to be added to the list
     * @param player  The player to whom the word was awarded
     */
    public void addWord(String word, Player player) {
        if(player.player.equalsIgnoreCase("human")){
            playerWords.add(word);
            pScore++;
        }
        else{
            computerWords.add(word);
            cScore++;
        }
        //throw new UnsupportedOperationException(); //change this!!
    }

    /* 
     * End a given round.
     * This will clear out the human and computer word lists, so we can begin again.
     * The function will also update each player's total scores, average scores, and
     * reset the current scores for each player to zero.
     * Finally, increment the current round number by 1.
     */
    public void endRound() {
        playerWords.clear();
        computerWords.clear();
        pScoreTotal+=pScore;
        cScoreTotal+=cScore;
        pScore = 0;
        cScore = 0;
        round++;
        pAverageWords = pScoreTotal/round;
        cAverageWords = cScoreTotal/round;
        //throw new UnsupportedOperationException(); //change this!!
    }

    /* 
     * Summarize one round of boggle.  Print out:
     * The words each player found this round.
     * Each number of words each player found this round.
     * Each player's score this round.
     */
    public void summarizeRound() {
        System.out.println("Human Words: " + playerWords);
        System.out.println("Computer Words: " + computerWords);
        System.out.println("Human found " + pScore + " words in this round.");
        System.out.println("Computer found " + cScore + " words in this round");
        System.out.println("Human score in this round : " + pScore);
        System.out.println("Computer score in this round: " + cScore);
        //throw new UnsupportedOperationException(); //change this!!
    }

    /* 
     * Summarize the entire boggle game.  Print out:
     * The total number of rounds played.
     * The total score for either player.
     * The average number of words found by each player per round.
     */
    public void summarizeGame() {
        System.out.println("Total rounds played: " + round);
        System.out.println("Human total score: " + pScoreTotal);
        System.out.println("Computer total score: " + cScoreTotal);
        System.out.println("Human average number of words found: " + pAverageWords);
        System.out.println("Computer average number of words found: " + cAverageWords);
        //throw new UnsupportedOperationException(); //change this!!
    }

    /* 
     * @return Set<String> The player's word list
     */
    public Set<String> getPlayerWords() {
        return this.playerWords;
    }

    /*
     * @return int The number of rounds played
     */
    public int getRound() { return this.round; }

    /*
    * @return int The current player score
    */
    public int getScore() {
        return this.pScore;
    }

}
