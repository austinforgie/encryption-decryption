package encryptdecrypt;

/**
 * CipherAlgorithm interface
 */
public interface CipherAlgorithm {
   /**
     * This method is to be implemented by a cipher algorithm for encryption
     * @param key used by cipher algorithm 
     * @param data to be processed by cipher algorithm
     * @return processed data
     */
    String encrypt(int key, String data);

     /**
     * This method is to be implemented by a cipher algorithm for decryption
     * @param key used by cipher algorithm 
     * @param data to be processed by cipher algorithm
     * @return processed data
     */
    String decrypt(int key, String data);
}
