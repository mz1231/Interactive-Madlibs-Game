import javax.swing.JOptionPane;

import edu.stanford.nlp.simple.*;

import java.util.Properties;

// class of methods that detect the part of speech of the users input in the Madlib game using the Stanford NLP library,
// determine whether it matches the intended POS, and generate random options if it doesn't
public class Game {
    // returns the part of speech a word is using the NLP library
    public String POS(String currentInput) {
        Sentence input = new Sentence(currentInput);
        String outputPOS = input.posTag(0);
        return outputPOS;
    }

    // chooses a random word from an array of Strings
    public String randomWord(String[] arr) {
        int index = (int) (Math.random() * 7);
        return arr[index];
    }

    // checks if the inputted String is a adjective; if it is, then it returns the inputted String, otherwise, it
    // returns a random adjective from an array of Strings
    public String checkAdj(String input) {
        String[] backup = {"rigid", "momentous", "hollow",
                "fluffy", "threatening", "hypnotic", "tangy"};
        if (input.length() < 3) {
            return randomWord(backup);
        }
        if (POS(input).substring(0, 2).equals("JJ")) {
            return input;
        } else {
            return randomWord(backup);
        }
    }

    // checks if the inputted String is a noun; if it is, then it returns the inputted String, otherwise, it
    // returns a random noun from an array of Strings
    public String checkNoun(String input) {
        String[] backup = {"telephone", "mad cow", "toaster", "karate",
                "trust fund", "volcano", "toothpaste"};
        if (input.length() < 3) {
            return randomWord(backup);
        }
        if (POS(input).substring(0, 2).equals("NN")) {
            return input;
        } else {
            return randomWord(backup);
        }
    }

    // checks if the inputted String is a past tense verb; if it is, then it returns the inputted String, otherwise, it
    // returns a random past tense verb from an array of Strings
    public String checkVerb(String input) {
        String[] backup = {"fled", "confessed", "sang", "painted",
                "battled", "biked", "warned"};
        if (input.length() < 3 || POS(input).length() < 3) {
            return randomWord(backup);
        }
        if (POS(input).substring(0, 3).equals("VBD") || POS(input).substring(0, 3).equals("VBN")) {
            return input;
        } else {
            return randomWord(backup);
        }
    }

    // checks if each of the words in an inputted String array are their correct part of speech and replaces any that
    // aren't with a random word of the correct part of speech; stores each output into a new array and returns it
    public String[] checkPOS(String[] input) {
        String[] output = new String[7];
        for (int i = 0; i < 7; i++) {
            if (i == 0 || i == 6) {
                output[i] = checkAdj(input[i]);
            } else if (i == 1 || i == 2 || i == 4) {
                output[i] = checkNoun(input[i]);
            } else {
                output[i] = checkVerb(input[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {

    }

}
