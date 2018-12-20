import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encrypt extends ParentCrypto implements Encryptable {
    public Model encrypt() {
        Model newModel=new Model();
        SecretKey tempKey=null;
        try {
            //generate tempKey
            KeyGenerator keygen= KeyGenerator.getInstance(encrpytionType);
            tempKey=keygen.generateKey();

            //store and encrypt tempKey
            cipher.init(Cipher.ENCRYPT_MODE,this.key);
            byte[] encrypted=cipher.doFinal(tempKey.getEncoded());
            String cipherText=Base64.getEncoder().encodeToString(encrypted);
            newModel.setKey(cipherText);

            //encrypt data
            cipher.init(Cipher.ENCRYPT_MODE,tempKey);
            for (int i = 0; i < model.getPassword().size(); i++) {
                String currentPass=model.getPassword().get(i);
                encrypted=cipher.doFinal(currentPass.getBytes());
                cipherText=Base64.getEncoder().encodeToString(encrypted);
                newModel.getPassword().add(cipherText);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return newModel;
    }
}
