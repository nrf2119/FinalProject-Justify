package nigel.finalproject_justify;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ccteadmin on 3/29/16.
 */
public class Inquiry extends Argument implements Serializable {
    public String question;
    public String photo;
    public int photoId;
    public Map<String, Argument> arguments;

    public Inquiry() {
    }

    public Inquiry(String question, int photoId) {
        this.question = question;
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Inquiry))
            return false;

        Inquiry inquiry = (Inquiry) object;
        return question.equals(inquiry.question);
    }

}
