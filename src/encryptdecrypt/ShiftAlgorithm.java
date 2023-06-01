package encryptdecrypt;

/**
 * This class is used to run an encrypting/decrypting shifting cipher algorithm
 * It shifts each letter of plaintext by the specified key according to its order in the alphabet (in circle)
 * It encodes only English letters (from 'a' to 'z' as the first circle and from 'A' to 'Z' as the second
 * circle i.e. after 'z' comes 'a' and after 'Z' comes 'A')
 */
public class ShiftAlgorithm implements CipherAlgorithm {

    @Override
    public String encrypt(int key, String data) {
        StringBuilder text = new StringBuilder();

        for (char c : data.toCharArray()) {
            char min = Character.isUpperCase(c) ? 'A' : 'a';
            char max = Character.isUpperCase(c) ? 'Z' : 'z';

            // Does not encode non-letter characters
            if (!Character.isLetter(c)) {
                text.append(c);
            } else {
                if (key < 0 && (c + key) < min) {
                    // takes the difference of the character to the min and shifts left from the max based on key - difference
                    text.append((char) (max - (Math.abs(key) - (c - min)) + 1));
                } else if ((c + key) > max) {
                    // takes the difference of the max to the character and shifts right from the min based on key - difference
                    text.append((char) (min + (key - (max - c)) - 1));
                } else {
                    // shifts to the right from the character by the key
                    text.append((char) (c + key));
                }
            }
        }

        return text.toString();
    }

    @Override
    public String decrypt(int key, String data) {
        return encrypt(-key, data);
    }
}
