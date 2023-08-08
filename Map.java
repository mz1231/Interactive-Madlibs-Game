import java.awt.Color;
import javax.swing.JOptionPane;

import edu.stanford.nlp.simple.*;

import java.util.Properties;

// class of methods that handle the creation of a fantasy map and interactive buttons for the locations in it, along
// with the user input and final output of the Madlibs game
public class Map {
    // filename of map
    private String filename;
    // x coordinates of the buttons that correspond to each location on the map
    private double[] xCords;
    // y coordinates of the buttons that correspond to each location on the map
    private double[] yCords;

    // creates a map with the given filename and button coordinates for each map location
    public Map(String filename, double[] xCords, double[] yCords) {
        this.filename = filename;
        this.xCords = xCords;
        this.yCords = yCords;
    }

    // returns array of the x cords of each map location
    public double[] getXCords() {
        return xCords;
    }

    // returns array of the y cords of each map location
    public double[] getYCords() {
        return yCords;
    }

    // sets up and draws the map to StdDraw using the object's filename
    public void drawMap() {
        StdDraw.setCanvasSize(950, 700);
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 800);
        StdDraw.picture(500, 400, this.filename);
    }

    // draws filled circles to StdDraw using the object's button coordinates
    public void drawButtons(double radius) {
        StdDraw.setPenColor(Color.GREEN);
        for (int i = 0; i < xCords.length; i++) {
            StdDraw.filledCircle(xCords[i], yCords[i], radius);
        }
    }

    // returns true if the distance from the input coordinate to any of the button coordinates in the map
    // is less than 25
    public boolean checkDistance(double x, double y) {
        for (int i = 0; i < getXCords().length; i++) {
            double distance = Math.sqrt(Math.pow((x
                    - getXCords()[i]), 2) + Math.pow((y
                    - getYCords()[i]), 2));
            if (distance < 25) {
                return true;
            }
        }
        return false;
    }

    // returns the distance from the input coordinates to any button coordinate, as long as the distance is less than 25
    public int getDistance(double x, double y) {
        int index = 0;
        for (int i = 0; i < getXCords().length; i++) {
            double distance = Math.sqrt(Math.pow((x
                    - getXCords()[i]), 2) + Math.pow((y
                    - getYCords()[i]), 2));
            if (distance < 25) {
                index = i;
            }
        }
        return index;
    }

    // prompts the user to input adjectives, nouns, or verbs through JOptionPane, stores them into a String array
    // and returns the array
    public String[] requestWords() {
        String adj1 = JOptionPane.showInputDialog("enter a adjective");
        String noun1 = JOptionPane.showInputDialog("enter a noun");
        String noun2 = JOptionPane.showInputDialog("enter a noun");
        String verb1 = JOptionPane.showInputDialog("enter a past tense verb");
        String noun3 = JOptionPane.showInputDialog("enter a noun");
        String verb2 = JOptionPane.showInputDialog("enter a past tense verb");
        String adj2 = JOptionPane.showInputDialog("enter a adjective");
        String[] words = {adj1, noun1, noun2, verb1, noun3, verb2, adj2};
        return words;
    }

    // takes in a String array of chosen words and returns the Bellheim story with the chosen words
    // inserted into the story
    public String bellheim(String[] input) {
        return "Once upon a time, in the kingdom of Bellheim, there was a prophecy that the " + input[0] +
                " wizards of a faraway kingdom would come to Bellheim. \nOnly, Sir " + input[1] +
                ", a brave knight heard the prophecy. Assuming they would try stealing the magical " + input[2] +
                ", the knight " + input[3] + " to prepare for the arrival of the wizards. \nHe finally convinced" +
                " King " +
                "Lancelot of the prophecy’s truth. Shortly after, a large group of wizards arrived at Bellheim on a "
                + input[4] + ". They claimed they " + input[5] + " enemy \ninvaders and were peaceful people. King" +
                " Lancelot was hesitant, but when the wizards presented their " + input[6] + " sword as a peace " +
                "offering, he threw a feast in their honor and \nwelcomed them with open arms.";

    }

    // takes in a String array of chosen words and returns the Forsoccen Hills story with the chosen words
    // inserted into the story
    public String forsoccenHills(String[] input) {
        return "Once upon a time, hidden in the Forsoccen Hills, there was a " + input[0] + " cabin. Traveling " +
                "through the woods was \nthe fastest way for the duchess of " + input[1] + " to return home. One day," +
                " she decided to explore the cabin; no one was home, but there was a small journal on the wooden" +
                " table. \nIt had tales of " + input[2] + " and secret waterfalls. Suddenly, a man " + input[3] +
                " through the front door, claiming to be the owner of the cabin. The duchess apologized for the" +
                " intrusion, \nand asked the man why he lived here. He told her about the " + input[4] + ", where," +
                " fighting on behalf of the kingdom, he made enemies who " + input[5] + " him everywhere. She felt "
                + input[6] + " that these were the \nconsequences of his bravery, so she invited him to live in her" +
                " castle, where they quickly became the best of friends.";

    }

    // takes in a String array of chosen words and returns the No Man's Sea story with the chosen words
    // inserted into the story
    public String noMansSea(String[] input) {
        return "Once upon a time, there was a merchant by the name of Octavius, who frequently traveled through" +
                " No Man’s Land. He sold everything from " + input[0] + " pots to " + input[1] +
                ". \nOne day, he met with a soldier from a neighboring kingdom, who wanted to buy a  " + input[2] +
                " from Octavius. In exchange, he offered Octavius a rare black egg, a Myrkheim \ndelicacy. They met " +
                "in a mysterious cavern, where the soldier " + input[3] + ". The next week, when Octavius was" +
                " sailing \nback through No Man’s Land, at the alarm of his " + input[4] + ", the egg began to crack." +
                " In shock, Octavius " + input[5] + " the egg, only to see a " + input[6] + " dragon a second" +
                " later. \nThe dragon, despite its fiery temperament, became Octavius’ most valued trade.";

    }

    // takes in a String array of chosen words and returns the Prymheir story with the chosen words
    // inserted into the story
    public String prymheir(String[] input) {
        return "Once upon a time, in the village of Prymheir, there lived a " + input[0] +
                " man by the name of Peter. When he was a child, he found a baby phoenix stuck in a " + input[1] +
                ". \nAfter releasing the bird, it flew right back to him. He kept the bird, naming him " + input[2] +
                ". Many years later, news got out Peter owned a rare phoenix, whose tears famously healed wounds. " +
                "\nPrincess and merchants and soldiers bargained and " + input[3] + " for Pipsqueak, but Peter" +
                " refused. One day, a thief stole Pipsqueak, intent on hoarding his healing powers" +
                " for himself. \nPeter’s" +
                " quest to find Pipsqueak took him on a 24 day journey, encountering a troll, " + input[4] +
                ", and pirates. Finally, he " + input[5] + " the thief and demanded Pipsqueak’s return. \nThe "
                + input[6] + " thief complied, and Peter and Pipsqueak were reunited.";

    }

    // takes in a String array of chosen words and returns the Forsoccen Deep story with the chosen words
    // inserted into the story
    public String theForsakenDeep(String[] input) {
        return "Once upon a time, in The Forsaken Deep there lived a mermaid, " +
                "Ariel, who wanted nothing more than to explore the " + input[0] + " sea." +
                " One day, she swam out beyond theborders of mermaid \nland, where she encountered" +
                " a dolphin, orca, and " + input[1] + ". She even came across a ship with a treasure" +
                " chest full of " + input[2] + ". Ariel explored the ship and found a secret compartment" +
                " \nwith a magical pearl. She decided to search for the owners of the pearl. After " + input[3] +
                " for six hours, she came across a strange island with \nfairies and " + input[4] +
                ". The magical pearl she found was an ancient treasure from the ancestors of the fairies. The fairies"
                + input[5] + ",  and to thank Ariel, \noffered her " + input[6] +
                " pixie dust. Ariel often visited the fairies from then on.";
    }

    // draws an interactive fantasy map in which the user can pick a location and play a game of madlibs that creates a
    // story specific to the picked location
    public static void main(String[] args) {
        // creates a new game
        Game game = new Game();
        // array of places in Myrkheim
        String[] places = {
                "Bellheim", "Forsoccen Hills", "No Man's Sea",
                "Prymheir", "The Forsaken Deep"
        };
        // arrays of x and y cords corresponding to the buttons that will be drawn to each location on the map
        double[] xCords = {680, 900, 490, 620, 130};
        double[] yCords = {660, 230, 510, 210, 190};

        // creates a map of Myrkheim with the filename of the map and the arrays of the button locations
        Map map = new Map("Map.jpeg", xCords, yCords);

        // Introduces the user to a intro screen using JOptionPane
        JOptionPane.showMessageDialog(null, "Select where in the fantasical world of "
                + "Myrkheim you would like to "
                + "write a story about");
        // draws the map and buttons to StdDraw once the user continues from the intro screen
        map.drawMap();
        map.drawButtons(10);

        // waits for user to click near one of the buttons
        int index;
        while (true) {
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                if (map.checkDistance(x, y)) {
                    index = map.getDistance(x, y);
                    break;
                }
            }
        }
        // prompts the user to enter a series of nouns, adjectives, or verbs and stores them into an array
        String[] input = map.requestWords();
        // checks to see if the user inputted the   correct part of speech; if they did not it replaces the user's word
        // with a correct random word from an predestined array of Strings; returns the new array
        String[] properInput = game.checkPOS(input);

        // returns the story of whatever location the user chose with their chosen words
        String finalOutput;
        if (index == 0) {
            finalOutput = map.bellheim(properInput);
        } else if (index == 1) {
            finalOutput = map.forsoccenHills(properInput);
        } else if (index == 2) {
            finalOutput = map.noMansSea(properInput);
        } else if (index == 3) {
            finalOutput = map.prymheir(properInput);
        } else {
            finalOutput = map.theForsakenDeep(properInput);
        }
        JOptionPane.showMessageDialog(null, finalOutput);

    }
}
