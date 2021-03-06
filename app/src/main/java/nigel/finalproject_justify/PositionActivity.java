package nigel.finalproject_justify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PositionActivity extends AppCompatActivity {

    private ImageView chosenInquiryImageView;
    private TextView chosenInquiryTextView;
    String key;
    Inquiry inquiry;
    EditText editText;
    String nameThatAppears = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        chosenInquiryImageView = (ImageView) findViewById(R.id.inquiry_photo);
        chosenInquiryTextView = (TextView) findViewById(R.id.inquiry_question);
        editText = (EditText) findViewById(R.id.user_name_edit_text);

        Intent intent = getIntent();
        inquiry = (Inquiry) intent.getSerializableExtra(Keys.CHOSEN_INQUIRY_CARD);
        key = intent.getStringExtra(Keys.CHOSEN_INQUIRY_KEY);
        chosenInquiryImageView.setImageBitmap(byteStringToBitmap(inquiry.photo));
        chosenInquiryTextView.setText(inquiry.question);
    }


    public void disagree(View view) {
        nameThatAppears = editText.getText().toString();
        if (!nameThatAppears.equals("")) {
            Intent intent = new Intent(this, MakeArgumentActivity.class);
            intent.putExtra(Keys.CHOSEN_INQUIRY_CARD, inquiry);
            intent.putExtra(Keys.CHOSEN_INQUIRY_KEY, key);
            intent.putExtra(Keys.AGREE_OR_DISAGREE, false);
            intent.putExtra(Keys.NAME_THAT_APPEARS, nameThatAppears);
            Toast.makeText(this, "You disagree", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please type your name", Toast.LENGTH_SHORT).show();
        }
    }

    public void agree(View view) {
        nameThatAppears = editText.getText().toString();
        if (!nameThatAppears.equals("")) {
            Intent intent = new Intent(this, MakeArgumentActivity.class);
            intent.putExtra(Keys.CHOSEN_INQUIRY_CARD, inquiry);
            intent.putExtra(Keys.CHOSEN_INQUIRY_KEY, key);
            intent.putExtra(Keys.AGREE_OR_DISAGREE, true);
            intent.putExtra(Keys.NAME_THAT_APPEARS, nameThatAppears);
            Toast.makeText(this, "You agree", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please type your name", Toast.LENGTH_SHORT).show();
        }
    }

    private Bitmap byteStringToBitmap(String byteString) {
        byte[] imageAsBytes = Base64.decode(byteString.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }
}
