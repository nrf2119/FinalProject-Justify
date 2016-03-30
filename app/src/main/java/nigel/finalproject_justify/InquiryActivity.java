package nigel.finalproject_justify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InquiryActivity extends AppCompatActivity {

    private List<Inquiry> inquiries;
    private InquiriesAdapter inquiryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        Intent intent = getIntent();

        initialData();

        RecyclerView mrRecyclerView = (RecyclerView) findViewById(R.id.inquiry_recycler_view);
        mrRecyclerView.setHasFixedSize(true);
        mrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        inquiryAdapter = new InquiriesAdapter(inquiries, this);
        mrRecyclerView.setAdapter(inquiryAdapter);
    }



    private void initialData() {
        inquiries = new ArrayList<>();
        inquiries.add(new Inquiry("Can Facebook be used as a learning tool in schools?", R.drawable.facebook_school));
        inquiries.add(new Inquiry("Has Barack Obama been a good president?", R.drawable.sad_obama));
        inquiries.add(new Inquiry("Does eating locally help the environment?", R.drawable.eat_local));

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
