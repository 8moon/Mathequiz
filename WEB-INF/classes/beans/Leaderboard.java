//Erstellt von Thomas Theinert

package beans;

import java.io.Serializable;

public class Leaderboard implements Serializable {

    private String userName;
    private String gameType;
    private String gameDifficulty;
    private int rightUserSolutions;
    private int playedGames;
    private int averageGamingTime;

    public Leaderboard() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(String gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public int getRightUserSolutions() {
        return rightUserSolutions;
    }

    public void setRightUserSolutions(int rightUserSolutions) {
        this.rightUserSolutions = rightUserSolutions;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getAverageGamingTime() {
        return averageGamingTime;
    }

    public void setAverageGamingTime(int averageGamingTime) {
        this.averageGamingTime = averageGamingTime;
    }
}
