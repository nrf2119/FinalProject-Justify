package nigel.finalproject_justify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ReadArgumentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private EditText inputMessage;
    private Argument argument;
//    private TextView readClaimTextView;
//    private TextView readEvidenceTextView;
//    private TextView readJustificationTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_argument);
        viewPager = (ViewPager) findViewById(R.id.reading_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.reading_tabs);

        Intent intent = getIntent();
        argument = (Argument) intent.getSerializableExtra(Keys.CHOSEN_INQUIRY_CARD);

        viewPager.setAdapter(new ReadingTabPagerAdapter(argument));
        tabLayout.setupWithViewPager(viewPager);

//        readClaimTextView = (TextView) findViewById(R.id.otherclaimtext);
//        readEvidenceTextView = (TextView) findViewById(R.id.otherevidencetext);
//        readJustificationTextView = (TextView) findViewById(R.id.otherjustificationtext);
//        readClaimTextView.setText(argument.claim);

//        readClaimTextView.setText(argument.claim);
//        readEvidenceTextView.setText(argument.evidence);
//        readJustificationTextView.setText(argument.justification);
    }

//    protected void onPause() {
//        super.onPause();
//    }


}
