package daos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;
import model.SocialMediaPlayer;
import repositories.Repository;

/**
 *
 * @author Work
 */
public class DAOImpl implements DAOInterface {

    static final char DELIMITER = ',';

    @Override
    public Repository load(String filename) {
        Repository repository = new Repository();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] temp;
            String line = br.readLine();
            while (line != null) {
                temp = line.split(Character.toString(DELIMITER));
                int id = Integer.parseInt(temp[0]);
                String playerName = stripQuotes(temp[1]);
                int pointsEarned = Integer.parseInt(temp[2]);
                int currentLevel = Integer.parseInt(temp[3]);
                if (temp.length > 4) {
                    String socialMediaApp = stripQuotes(temp[4]);
                    String socialMediaIdentifier = stripQuotes(temp[5]);
                    SocialMediaPlayer socialMediaPlayer = new SocialMediaPlayer(id, playerName, pointsEarned, currentLevel, socialMediaApp, socialMediaIdentifier);
                    repository.add(socialMediaPlayer);
                } else {
                    Player player = new Player(id, playerName, pointsEarned, currentLevel);
                    repository.add(player);
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {

    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}
