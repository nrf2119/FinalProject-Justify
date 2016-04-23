package nigel.finalproject_justify;

/**
 * Created by diegoferope on 4/20/16.
 */
public class Argument {
    public String claim;
    public String evidence;
    public String justification;
    public String user;

    public Argument() {
        this("", "", "", "");
    }

    public Argument(String claim, String evidence, String justification, String user) {
        this.claim = claim;
        this.evidence = evidence;
        this.justification = justification;
        this.user = user;
    }
}
