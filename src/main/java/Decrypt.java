
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decrypt extends ParentCrypto implements Decryptable{
    public Model decrpyt() {
        Model newModel = new Model();
        SecretKey tempKey;
        try {
            //decrypt key
            cipher.init(Cipher.DECRYPT_MODE, this.key);
            byte[] keyDecoded=Base64.getDecoder().decode(model.getKey());
            byte[] keyDecrypted=cipher.doFinal(keyDecoded);
            tempKey = new SecretKeySpec(keyDecrypted,encrpytionType);

            //decrypt data
            cipher.init(Cipher.DECRYPT_MODE, tempKey);
            for (int i = 0; i < model.getData().size(); i++) {
                String data = "";
                byte[] bytePass= Base64.getDecoder().decode(model.getData().get(i));
                data = new String(cipher.doFinal(bytePass), StandardCharsets.UTF_8);
                newModel.getData().add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newModel;
    }
}
