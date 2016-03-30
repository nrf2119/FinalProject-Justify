package nigel.finalproject_justify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeeOthersActivity extends AppCompatActivity {
    private List<OtherClaim> otherClaims;
    private OtherClaimsAdapter otherClaimsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_others);

        initialData();

        RecyclerView mrRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mrRecyclerView.setHasFixedSize(true);
        mrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        otherClaimsAdapter =new OtherClaimsAdapter(otherClaims, this);
        mrRecyclerView.setAdapter(otherClaimsAdapter);

    }

    private void initialData() {
        otherClaims = new ArrayList<>();
        otherClaims.add(new OtherClaim("Nigel", R.drawable.icon_agree));
        otherClaims.add(new OtherClaim("Diego", R.drawable.icon_disagree));
        otherClaims.add(new OtherClaim("Jenna", R.drawable.icon_disagree));
        otherClaims.add(new OtherClaim("Sandra", R.drawable.icon_disagree));
        otherClaims.add(new OtherClaim("Claude", R.drawable.icon_agree));
        otherClaims.add(new OtherClaim("Lincoln", R.drawable.icon_agree));

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
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
