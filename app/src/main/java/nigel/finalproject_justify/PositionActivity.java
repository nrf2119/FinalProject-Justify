package nigel.finalproject_justify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PositionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        Intent intent = getIntent();

    }

    public void disagree(View view) {
        Toast.makeText(this, "You disagree", Toast.LENGTH_SHORT).show();

    }

    public void agree(View view) {
        Toast.makeText(this, "You agree", Toast.LENGTH_SHORT).show();
    }
}
