package repositories;

import daos.DAOImpl;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Player;


public class Repository implements RepositoryInterface {
    private ArrayList<Player> items;    
    
    public Repository() {
        this.items = new ArrayList<>();       
    }
    
    public Repository(ArrayList<Player> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        DAOImpl dao = new DAOImpl();
        this.items = dao.load(filename).getItems();  
    }
    
    @Override
    public ArrayList<Player> getItems() {        
        return this.items;
    }
    
    @Override
    public void setItems(ArrayList<Player> items) {        
        this.items = items;
    }
    
    @Override
    public void add(Player item) {
        this.items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<Player> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
    }
    
    @Override
    public Player getItem(int id) {
        for (Player item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }    
    
    public String toString(char delimiter){
       String output = "";
        for (Player item: this.items){
            output += item.toString(delimiter) + '\n';
        }
        return output;
    }
    
    @Override
    public void store(String filename) {       
        DAOImpl dao = new DAOImpl();
        dao.store(filename, this);        
    }        
}
