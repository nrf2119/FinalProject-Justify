package nigel.finalproject_justify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SeeOthersActivity extends AppCompatActivity {
    private List<Argument> otherClaims;
    private OtherClaimsAdapter otherClaimsAdapter;

    private TextView otherClaimsQuestionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_others);


        RecyclerView mrRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mrRecyclerView.setHasFixedSize(true);
        mrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        otherClaimsAdapter = new OtherClaimsAdapter(otherClaims, this);
        mrRecyclerView.setAdapter(otherClaimsAdapter);

        otherClaimsQuestionTextView = (TextView) findViewById(R.id.other_claims_question);
//        this is where we change the text of the top
//        otherClaimsQuestionTextView.setText();

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
