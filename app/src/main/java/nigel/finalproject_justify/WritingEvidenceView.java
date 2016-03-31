package nigel.finalproject_justify;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by diegoferope on 3/30/16.
 */
public class WritingEvidenceView extends FrameLayout {
    private TextView textView;

    public WritingEvidenceView(Context context) {
        super(context);
        init();
    }


    public WritingEvidenceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WritingEvidenceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)//this allows me to make this constructor work
    public WritingEvidenceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }//this only contains one object, whoch the customview, we cannot adjust this

    private void init() {
        inflate(getContext(), R.layout.writing_evidence_view, this);
        textView = (TextView) findViewById(R.id.evidencetext);
        textView.setText("This is my position");
    }
}
