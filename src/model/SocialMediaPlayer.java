package model;

/**
 *
 * @author mga
 */
public class SocialMediaPlayer extends Player {
    
    /**
     *
     */
    protected String socialMediaApp;

    /**
     *
     */
    protected String socialMediaIdentifier;

    /**
     *
     */
    public SocialMediaPlayer() {
        super();
        this.socialMediaApp = "Unknown";
        this.socialMediaIdentifier = "Unknown";        
    }

    /**
     *
     * @param playerName
     * @param socialMediaApp
     * @param socialMediaIdentifier
     */
    public SocialMediaPlayer(String playerName, String socialMediaApp, String socialMediaIdentifier) {
        super(playerName);
        this.socialMediaApp = socialMediaApp;
        this.socialMediaIdentifier = socialMediaIdentifier;
    }

    /**
     *
     * @param id
     * @param playerName
     * @param currentLevel
     * @param pointsEarned
     * @param socialMediaApp
     * @param socialMediaIdentifier
     */
    public SocialMediaPlayer(int id, String playerName, int currentLevel, int pointsEarned, String socialMediaApp, String socialMediaIdentifier) {
        super(id, playerName, currentLevel, pointsEarned);
        this.socialMediaApp = socialMediaApp;
        this.socialMediaIdentifier = socialMediaIdentifier;
    }

    public String getSocialMediaApp() {
        return socialMediaApp;
    }

    public void setSocialMediaApp(String socialMediaApp) {
        this.socialMediaApp = socialMediaApp;
    }

    public String getSocialMediaIdentifier() {
        return socialMediaIdentifier;
    }

    public void setSocialMediaIdentifier(String socialMediaIdentifier) {
        this.socialMediaIdentifier = socialMediaIdentifier;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + "\nApp: " + this.socialMediaApp +  " - App Id: " + this.socialMediaIdentifier;
    }
    
    @Override
    public String toString(char delimiter) {
        String output = super.toString(delimiter)
                + delimiter + this.socialMediaApp
                + delimiter + this.socialMediaIdentifier;
        return output;
    }
}
