package beans;

import java.io.Serializable;

public class Scoreboard implements Serializable{
    private String username;
    private int rightUserSolutions;
    private long averageGamingTime;
    private String gameType;
    private String gameDifficulty;

    public Scoreboard() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRightUserSolutions() {
        return rightUserSolutions;
    }

    public void setRightUserSolutions(int rightUserSolutions) {
        this.rightUserSolutions = rightUserSolutions;
    }

    public long getAverageGamingTime() {
        return averageGamingTime;
    }

    public void setAverageGamingTime(long averageGamingTime) {
        this.averageGamingTime = averageGamingTime;
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
}
