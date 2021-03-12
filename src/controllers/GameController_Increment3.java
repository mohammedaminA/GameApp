package controllers;

import helpers.InputHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import model.Player;
import model.SocialMediaPlayer;
import repositories.Repository;

/**
 *
 * @author mga
 */
public class GameController {
    private final Repository repository;
    ArrayList<Player> players = new ArrayList<>();
    
    /**
     *
     */
        
    public GameController() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Player File (Y/N)?");
        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");               
            this.repository = new Repository(fileName);
        }
        else {
            this.repository = new Repository();
        }
        listPlayers();
    }
   
    /**
     *
     */
    public void run() {
        boolean finished = false;
        
        do {
            char choice = displayGameMenu();
            switch (choice) {
                case 'A': 
                    addPlayer();
                    listPlayers();
                    break;
                case 'B':  
                    listPlayersInPointsOrder();
                    break;
                case 'C': 
                    updatePlayer();
                    listPlayers();
                    break;                    
                case 'Q': 
                    finished = true;
            }
        } while (!finished);
    }
    
    private char displayGameMenu() {
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Player");
        System.out.print("\tB. List Players");        
        System.out.print("\tC. Update Player");      
        System.out.print("\tQ. Quit\n");         
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }    
    
    private void addPlayer() {
        System.out.format("\033[31m%s\033[0m%n", "Add Player");
        System.out.format("\033[31m%s\033[0m%n", "==========");
        InputHelper inputHelper = new InputHelper();
        char playerType = inputHelper.readCharacter("Is this a Social Media Player?(Y/N)");
        String playerName = inputHelper.readString("Enter Player Name");
        if (playerType == 'Y' || playerType == 'y') {
            String socialMediaApp = inputHelper.readString("Enter Social Media App");
            String socialMediaIdentifier = inputHelper.readString("Enter Social Media Identifier");
            SocialMediaPlayer socialMediaPlayer = new SocialMediaPlayer(playerName, socialMediaApp, socialMediaIdentifier);
            repository.add(socialMediaPlayer);
        }
        else {
            Player player = new Player(playerName);
            repository.add(player);
        }
    }
    
    private void listPlayers() {        
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        players = repository.getItems();
        Iterator it = players.iterator(); 
        while (it.hasNext()) 
            System.out.print(it.next() + "\n");
    }    
      
    private void listPlayersInPointsOrder() {        
        System.out.format("\033[31m%s\033[0m%n", "Players");
        System.out.format("\033[31m%s\033[0m%n", "=======");
        
        Collections.sort(players);
        Iterator it = players.iterator(); 
        while (it.hasNext()) 
            System.out.print(it.next() + "\n");
    } 
    
    
    private void updatePlayer() {        
        System.out.format("\033[31m%s\033[0m%n", "Update Player");
        System.out.format("\033[31m%s\033[0m%n", "============="); 
    }    
    
}
