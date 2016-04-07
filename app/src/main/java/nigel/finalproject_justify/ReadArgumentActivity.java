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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_argument);
        viewPager = (ViewPager) findViewById(R.id.reading_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.reading_tabs);

        viewPager.setAdapter(new ReadingTabPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
    }

    protected void onPause() {
        super.onPause();
    }


}
