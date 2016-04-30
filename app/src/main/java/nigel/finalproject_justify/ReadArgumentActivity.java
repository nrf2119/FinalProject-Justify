package nigel.finalproject_justify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ReadArgumentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Argument argument;


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


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
