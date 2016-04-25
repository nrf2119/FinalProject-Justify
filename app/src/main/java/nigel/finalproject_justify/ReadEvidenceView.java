package nigel.finalproject_justify;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by diegoferope on 3/30/16.
 */
public class ReadEvidenceView extends FrameLayout {
    private TextView textView;

    public ReadEvidenceView(Context context) {
        super(context);
        init();
    }


    public ReadEvidenceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReadEvidenceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public ReadEvidenceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.reading_evidence_view, this);
        textView = (TextView) findViewById(R.id.otherevidencetext);
        textView.setText("This is my position");
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
