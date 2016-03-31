package nigel.finalproject_justify;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by diegoferope on 3/30/16.
 */
public class ReadClaimView extends FrameLayout {
    private TextView textView;

    public ReadClaimView(Context context) {
        super(context);
        init();
    }


    public ReadClaimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReadClaimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)//this allows me to make this constructor work
    public ReadClaimView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }//this only contains one object, whoch the customview, we cannot adjust this

    private void init() {
        inflate(getContext(), R.layout.reading_claim_view, this);
        textView = (TextView) findViewById(R.id.otherclaimtext);
        textView.setText("This is my position");
    }
}
