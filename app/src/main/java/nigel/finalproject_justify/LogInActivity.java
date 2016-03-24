package nigel.finalproject_justify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class LogInActivity extends AppCompatActivity {

    private Firebase myFirebase;
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        myFirebase = new Firebase("https://justify.firebaseio.com/");
        emailEditText = (EditText) findViewById(R.id.edit_text_email);
        passwordEditText = (EditText) findViewById(R.id.edit_text_password);
    }

    public void logIn(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        myFirebase.authWithPassword(email, password, new Firebase.AuthResultHandler() {

            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(LogInActivity.this, "You are logged in", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(LogInActivity.this, "Unable to log in: " + firebaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void signUp(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        myFirebase.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {

            @Override
            public void onSuccess(Map<String, Object> result) {
                Toast.makeText(LogInActivity.this, "Successfully created user with uid: " + result.get("uid"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Toast.makeText(LogInActivity.this, "Unable to sign up: " + firebaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
