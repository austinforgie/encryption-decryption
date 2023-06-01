import encryptdecrypt.Cipher;

/**
 * This class contains the main method used to execute the program
 */
public class Main {
    /**
     * Default constructor
     */
    private Main() {}

    /**
     * Main method used to execute the cipher program with command-line arguments
     */
    public static void main(String[] args) {
        new Cipher().execute(args);
    }
}
