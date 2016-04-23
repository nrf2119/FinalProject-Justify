package nigel.finalproject_justify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.List;

public class InquiryActivity extends AppCompatActivity {

    private List<Inquiry> inquiries;
    private InquiriesAdapter inquiryAdapter;
    private Firebase rootRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        Intent intent = getIntent();

        rootRef = new Firebase("https://justify.firebaseio.com/");
        Firebase inquiriesRef = rootRef.child("inquiries");


        RecyclerView mrRecyclerView = (RecyclerView) findViewById(R.id.inquiry_recycler_view);
        mrRecyclerView.setHasFixedSize(true);
        mrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        inquiryAdapter = new InquiriesAdapter(inquiriesRef, this, true);
        mrRecyclerView.setAdapter(inquiryAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inquiry_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "You can share it :)", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
