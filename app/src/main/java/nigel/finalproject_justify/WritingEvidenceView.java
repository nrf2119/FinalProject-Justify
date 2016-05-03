package nigel.finalproject_justify;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * Created by diegoferope on 3/30/16.
 */
public class WritingEvidenceView extends FrameLayout {

    public EditText editText;

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
    }//this only contains one object, which the customview, we cannot adjust this

    private void init() {
        inflate(getContext(), R.layout.writing_evidence_view, this);
        WebView webView = (WebView) findViewById(R.id.web_view_1);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
