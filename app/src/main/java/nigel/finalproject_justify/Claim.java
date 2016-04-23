package nigel.finalproject_justify;

/**
 * Created by diegoferope on 4/22/16.
 */
public class Claim {
    public String text;
    public String user;

    public Claim() {
        this("", "");
    }

    public Claim(String text, String user) {
        this.text = text;
        this.user = user;
    }
}


