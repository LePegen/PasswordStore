import java.util.ArrayList;

public class Model {
    private String key;
    private ArrayList<String> data;

    public Model() {
        this.data =new ArrayList<String>();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
