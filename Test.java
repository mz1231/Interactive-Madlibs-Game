import java.awt.Color;
import javax.swing.JOptionPane;

import edu.stanford.nlp.simple.*;

import java.util.Properties;

// tests the project features by seeing if Map.java and Game.java methods function as intended
public class Test {
    public static void main(String[] args) {
        String[] places = {
                "Bellheim", "Forsoccen Hills", "No Man's Sea",
                "Prymheir", "The Forsaken Deep"
        };
        // Test for feature 1- game setup
        double[] xCords = {650, 880, 460, 640, 100};
        double[] yCords = {690, 210, 550, 240, 170};
        Map map = new Map("Map.jpeg", xCords, yCords);
        Game game = new Game();
        // manually setsup and draws the map
        StdDraw.setCanvasSize(950, 700);
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 800);
        StdDraw.picture(500, 400, "Map.jpeg");
        // manually draws filled circles corresponding to each location to test buttons
        StdDraw.setPenColor(Color.GREEN);
        // Bellheim
        StdDraw.filledCircle(650, 690, 10);
        // Forsoccen Hills
        StdDraw.filledCircle(880, 210, 10);
        // No Man's Sea
        StdDraw.filledCircle(460, 550, 10);
        // Prymheir
        StdDraw.filledCircle(640, 240, 10);
        // The Forsaken Deep
        StdDraw.filledCircle(100, 170, 10);

        // tests JOptionFrame and stores input into a String
        String adj1 = JOptionPane.showInputDialog("enter a adjective");
        String noun1 = JOptionPane.showInputDialog("enter a noun");
        String noun2 = JOptionPane.showInputDialog("enter a noun");
        String verb1 = JOptionPane.showInputDialog("enter a past tense verb");
        String noun3 = JOptionPane.showInputDialog("enter a noun");
        String verb2 = JOptionPane.showInputDialog("enter a past tense verb");
        String adj2 = JOptionPane.showInputDialog("enter a adjective");
        // I typed "funny, girl, frog, ran, train, walked, yellow" and compared it to the output
        String[] words = {adj1, noun1, noun2, verb1, noun3, verb2, adj2};
        for (int i = 0; i < 7; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
        // Test for feature 2- GUI testing

        // shows that taking mouse click as user input works properly by printing x and y coords of the click
        while (!StdDraw.isMousePressed()) {

        }
        double x1 = StdDraw.mouseX();
        double y1 = StdDraw.mouseY();
        System.out.println(x1 + " " + y1);
        // prints the mouse click's distance to every place and prints the name of the place if the distance
        // is less than 25 on its own line

        for (int i = 0; i < xCords.length; i++) {
            double distance = Math.sqrt(Math.pow((x1
                    - xCords[i]), 2) + Math.pow((y1
                    - yCords[i]), 2));
            System.out.println("Distance from mouse click to " + places[i] + " is " + distance);
            if (distance < 25) {
                System.out.println(places[i]);
            }
        }
        System.out.println();
        // shows that a distance < 25 from a location will output the correct location
        // Belheim
        System.out.println(places[map.getDistance(640, 680)]);
        // Forsoccen Hills
        System.out.println(places[map.getDistance(880, 205)]);
        // No Man's Sea
        System.out.println(places[map.getDistance(454, 550)]);
        // Prymheir
        System.out.println(places[map.getDistance(640, 220)]);
        // The Forsaken Deep
        System.out.println(places[map.getDistance(101, 162)]);

        System.out.println();
        // shows that a point that is not close to any location will return false
        System.out.println(map.checkDistance(1, 1));

        // Test for Feature 3- part of speech testing

        // sets up String arrays for adjectives, nouns, and verbs, each with valid and invalid respnses
        String[] adjTest = {"cool", "frog", "trash", "funny", "hairy", "Harry"};
        String[] nounTest = {"toast", "lemon", "walked", "jumped", "jumprope", "gum"};
        String[] verbTest = {"ran", "run", "laughed", "george", "jogged", "went"};

        String[] checkedAdj = new String[6];
        String[] checkedNouns = new String[6];
        String[] checkedVerbs = new String[6];
        // tests if POS() method can correctly identify part of speech
        for (int i = 0; i < 6; i++) {
            System.out.println(adjTest[i] + " " + game.POS(adjTest[i]));
            checkedAdj[i] = game.checkAdj(adjTest[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(nounTest[i] + " " + game.POS(nounTest[i]));
            checkedNouns[i] = game.checkNoun(nounTest[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(verbTest[i] + " " + game.POS(verbTest[i]));
            checkedVerbs[i] = game.checkVerb(verbTest[i]);
        }
        // tests if checkAdj(), checkNoun(), checkVerb() methods correctly replace any invalid responses
        // should print arrays with only designated POS
        for (int i = 0; i < 6; i++) {
            System.out.print(checkedAdj[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(checkedNouns[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(checkedVerbs[i] + " ");
        }
        System.out.println();
        
    }
}
