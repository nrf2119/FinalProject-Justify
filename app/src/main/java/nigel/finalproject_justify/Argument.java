package nigel.finalproject_justify;

import java.io.Serializable;

/**
 * Created by diegoferope on 4/20/16.
 */
public class Argument implements Serializable {
    public String claim;
    public String evidence;
    public String justification;
    public String user;
    public String position;

    public Argument() {
        this("", "", "", "");
    }

    public Argument(String claim, String evidence, String justification, String user) {
        this.claim = claim;
        this.evidence = evidence;
        this.justification = justification;
        this.user = user;
    }
    //one change :)
}
