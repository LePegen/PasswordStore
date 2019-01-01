import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class KeyDerivation {

    /**
     * Returns a derived key when the hashed password the the inputted hash is equal
     *
     * @param password inputted password of the user to compare with passed hash
     * @param hash     inputted hash compared with the hash of the inputted password
     * @return returns a derived key
     * @throws WrongPasswordException
     */
    public SecretKey assertPassword(String password, String hash) throws WrongPasswordException {
        if (!getHash(password).equals(hash)) {
            throw new WrongPasswordException();
        }
        return getKey(password);
    }

    /**
     * Generates hash based on the input of the user
     *
     * @param toHash input of user to hash
     * @return hashed input of the user
     */
    public String getHash(String toHash) {
        String hashed = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.digest(toHash.getBytes());
            hashed = new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashed;
    }

    /**
     * Derives key based on the inputted string.
     * The methods get the first 16 bits of the hashed string and derives a secret key from it.
     *
     * @param toDerive string to derive secret key
     * @return the derviced secret key
     */
    private SecretKey getKey(String toDerive) {
        SecretKey key = null;
        //get 16 bytes of hash
        byte[] bytes = getHash(toDerive).getBytes();
        byte[] bytes16 = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes16[i] = bytes[i];
        }

        key = new SecretKeySpec(bytes16, "AES");

        return key;
    }
}
