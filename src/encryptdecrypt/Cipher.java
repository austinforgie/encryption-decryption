package encryptdecrypt;

import file.FileProcessor;

/**
 * This class contains methods to initialize a cipher algorithm and output its results
 */
public class Cipher implements FileProcessor {
     /**
     * Default fields
     */
    private CipherAlgorithm algorithm;
    private String mode = "enc"; // used to encrypt or "dec" which is used to decrypt
    private int key = 0; // used by a cipher algorithm to encrypt plaintext or decrypt ciphertext
    private String data = ""; // either passed in from the command line or read from a file
    private String filename = ""; // name of file that contains crypt data
    private String method = "unicode"; // encoding method used by a cipher algorithm which utilizes the english alphabet or "unicode" which uses unicode
    private String processedData; // data that has been processed by a cipher algorithm

    /**
     * Sets the program's fields by parsing the passed in command-line values
     * @param args passed in from the command-line
     */
    private void inputData(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    data = FileProcessor.readFile(args[i + 1]);
                    break;
                case "-out":
                    filename = args[i + 1];
                    break;
                case "-alg":
                    method = args[i + 1];
                    break;
            }
        }
    }

    /**
     * Sets which cipher algorithm to use given the set parameters
     */
    private void setAlgorithm() {
        if (method.equals("shift")) {
            algorithm = new ShiftAlgorithm();
        } else if (method.equals("unicode")) {
            algorithm = new UnicodeAlgorithm();
        }
    }

     /**
     * Runs the set algorithm and stores the processed data
     */
    private void runAlgorithm() {
        if (mode.equals("enc")) {
            processedData = algorithm.encrypt(key, data);
        } else if (mode.equals("dec")) {
            processedData = algorithm.decrypt(key, data);
        }
    }

    /**
     * Outputs the processed data either to a file or to the console
     */
    private void outputData() {
        if (filename.isEmpty()) {
            System.out.print(processedData);
        } else {
            FileProcessor.writeToFile(filename, processedData);
        }
    }

    /**
     * Executes the methods used to initialize and run the cipher program using the passed in command-line arguments
     * @param args passed in from the command-line
     */
    public void execute(String[] args) {
        inputData(args);
        setAlgorithm();
        runAlgorithm();
        outputData();
    }
}
