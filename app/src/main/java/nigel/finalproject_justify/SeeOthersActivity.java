package nigel.finalproject_justify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.List;

public class SeeOthersActivity extends AppCompatActivity {
    private List<Argument> otherClaims;
    private OtherClaimsAdapter otherClaimsAdapter;
    private TextView otherClaimsUserTextView;
    private ImageView imageView;

    private Firebase rootRef;
    private Firebase argsRef;
    String key;
    Argument argument;

    TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_others);

        rootRef = new Firebase("https://justify.firebaseio.com/");
        questionTextView = (TextView) findViewById(R.id.other_claims_question);

        otherClaimsUserTextView = (TextView) findViewById(R.id.other_user_name);
        imageView = (ImageView) findViewById(R.id.position_photo);

        Intent intent = getIntent();
        argument = (Argument) intent.getSerializableExtra(Keys.CHOSEN_INQUIRY_CARD);
        key = intent.getStringExtra(Keys.CHOSEN_INQUIRY_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Firebase argumentsRef = rootRef.child("inquiries/" + key + "/arguments");

        RecyclerView mrRecyclerView = (RecyclerView) findViewById(R.id.others_recycler_view);
        mrRecyclerView.setHasFixedSize(true);
        mrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        otherClaimsAdapter = new OtherClaimsAdapter(argumentsRef, this);
        mrRecyclerView.setAdapter(otherClaimsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_see_others, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(this, "You can add!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.go_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
