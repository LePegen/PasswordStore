import javax.crypto.SecretKey;
import java.util.ArrayList;

public class Model {
    private String key;
    private ArrayList<String> password;

    public Model() {
        this.password=new ArrayList<String>();
    }

    public ArrayList<String> getPassword() {
        return password;
    }

    public void setPassword(ArrayList<String> password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
