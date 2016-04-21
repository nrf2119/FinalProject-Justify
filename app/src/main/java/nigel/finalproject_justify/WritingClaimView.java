package nigel.finalproject_justify;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * Created by diegoferope on 3/30/16.
 */
public class WritingClaimView extends FrameLayout {
    public EditText editText = (EditText) findViewById(R.id.inputClaim);


    public WritingClaimView(Context context) {
        super(context);
        init();
    }


    public WritingClaimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WritingClaimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)//this allows me to make this constructor work
    public WritingClaimView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }//this only contains one object, whoch the customview, we cannot adjust this

    private void init() {
        inflate(getContext(), R.layout.writing_claim_view, this);
    }
}
