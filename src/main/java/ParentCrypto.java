import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public abstract class ParentCrypto {

    protected Model model;
    protected SecretKey key;
    protected Cipher cipher=null;
    protected final String encrpytionType="AES";

    public ParentCrypto() {
        try {
            cipher = Cipher.getInstance(encrpytionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model,SecretKey key) {
        this.key=key;
        this.model = model;
    }
}
