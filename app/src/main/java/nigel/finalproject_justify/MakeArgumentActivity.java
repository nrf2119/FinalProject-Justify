package nigel.finalproject_justify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class MakeArgumentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private EditText inputMessage;
    private SharedPreferences sharedPreferences;

    private Firebase rootRef;
    private Firebase userRef;

    String key;
    private boolean agreement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_argument);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager.setAdapter(new WritingTabPagerAdapter());//we need to set this adapter
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        key = intent.getStringExtra(Keys.CHOSEN_INQUIRY_KEY).toString();
        agreement = intent.getBooleanExtra(Keys.AGREE_OR_DISAGREE, false);
    }

    public void publish(View view) {
//        Intent intent = new Intent(this, SeeOthersActivity.class);
//        startActivity(intent);

        EditText editText1 = (EditText) findViewById(R.id.inputClaim);
        EditText editText2 = (EditText) findViewById(R.id.inputEvidence);
        EditText editText3 = (EditText) findViewById(R.id.inputJustification);

        String one = editText1.getText().toString();
        String two = editText2.getText().toString();
        String three = editText3.getText().toString();
        String user = "user";

        Argument argument = new Argument(one, two, three, user);
        argument.agreement = agreement;

        rootRef = new Firebase("https://justify.firebaseio.com/");
        rootRef.child("inquiries/" + key + "/arguments").push().setValue(argument);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "You have published an argument", Toast.LENGTH_SHORT).show();
    }


    protected void onPause() {
        super.onPause();
//        sharedPreferences.edit().putString("message", inputMessage.getText().toString()).apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.make_argument_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save:
//                String message = inputMessage.getText().toString();
//                if (message.length() != 0 && !message.equals("")) {
//                    Intent intent = new Intent();
//                    intent.putExtra("message", message);//Put Message to pass over intent
//
//                    setResult(RESULT_OK, intent);//Set result is OK
//
//                    finish();//finish activity
//                } else
                    Toast.makeText(MakeArgumentActivity.this, "Please enter a message.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

