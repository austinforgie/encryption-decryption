package encryptdecrypt;

/**
 * This class is used to run an encrypting/decrypting Unicode cipher algorithm
 * It shifts each letter of plaintext by the specified key according to the Unicode table
 */
public class UnicodeAlgorithm implements CipherAlgorithm {
  
    @Override
    public String encrypt(int key, String data) {
        StringBuilder plaintext = new StringBuilder();
        int min = '!';
        int max = '~';

        for (char c : data.toCharArray()) {
            if ((c + key) > max) {
                // takes the difference of the max to the character and shifts right from the min based on key - difference
                plaintext.append((char) (min + (key - (max - c)) - 1));
            } else {
                // shifts to the right from the character by the key
                plaintext.append((char) (c + key));
            }
        }

        return plaintext.toString();
    }

    @Override
    public String decrypt(int key, String data) {
        return encrypt(-key, data);
    }
}
