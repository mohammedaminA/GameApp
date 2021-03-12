package repositories;

import java.util.ArrayList;
import model.Player;

public interface RepositoryInterface {

    /**
     *
     * @param item
     */
    void add(Player item);

    /**
     *
     * @param id
     * @return
     */
    Player getItem(int id);

    ArrayList<Player> getItems();

    /**
     *
     * @param id
     */
    
    void remove(int id);

    void setItems(ArrayList<Player> items);

    /**
     *
     * @param filename
     */
    
    void store(String filename);

    /**
     *
     * @return
     */
    @Override
    String toString();
    
}
