package model;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author mga
 */
public class Player implements Comparable<Player> {
    /**
     *
     */
    protected final int id;

    /**
     *
     */
    protected String playerName;

    /**
     *
     */
    protected int currentLevel;

    /**
     *
     */
    protected int pointsEarned;

    protected static int lastIdAllocated = 0;
    protected static final char EOLN = '\n';
    protected static final String QUOTE = "\"";

    /**
     *
     */
    public Player() {
        this.id = ++lastIdAllocated;
        this.playerName = "Unknown";
        this.currentLevel = 1;
        this.pointsEarned = 0;
    }

    /**
     *
     * @param playerName
     */
    public Player(String playerName) {
        this.id = ++lastIdAllocated;
        this.playerName = playerName;
        this.currentLevel = 1;
        this.pointsEarned = 0;
    }

    /**
     *
     * @param id
     * @param playerName
     * @param currentLevel
     * @param pointsEarned
     */
    public Player(int id, String playerName, int currentLevel, int pointsEarned) {
        this.id = id;
        this.playerName = playerName;
        this.currentLevel = currentLevel;
        this.pointsEarned = pointsEarned;
        if (id > Player.lastIdAllocated) {
            Player.lastIdAllocated = id;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public static int getLastIdAllocated() {
        return lastIdAllocated;
    }

    public static void setLastIdAllocated(int lastIdAllocated) {
        Player.lastIdAllocated = lastIdAllocated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.playerName);
        hash = 29 * hash + this.currentLevel;
        hash = 29 * hash + this.pointsEarned;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.currentLevel != other.currentLevel) {
            return false;
        }
        if (this.pointsEarned != other.pointsEarned) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nPlayer Id: " + this.id + " - Player Name: " + this.playerName
                + " - Current Level: " + this.currentLevel
                + " - Points: " + this.pointsEarned;
    }

    public String toString(char delimiter) {
        String output = this.id + delimiter
                + QUOTE + this.playerName + QUOTE
                + this.currentLevel + this.pointsEarned;
        return output;
    }
    
    @Override
    public int compareTo(Player comparePlayer) {
        int playerPoints2 = ((Player) comparePlayer).getPointsEarned();
        return playerPoints2 - this.pointsEarned;
    }
}
