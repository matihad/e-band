package mahdihadian.gholhak.ehealth.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import mahdihadian.gholhak.ehealth.R;

public class SignUpActivity extends AppCompatActivity {


    Toolbar toolbar_sign_up;
    ImageButton back;

    EditText username_signup, email_signup, password_signup, password2;
    Button signup;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bind();
        setSupportActionBar(toolbar_sign_up);

        back.setOnClickListener(V -> {
            finish();
        });

        ArrayAdapter<CharSequence> account_types = ArrayAdapter
                .createFromResource(this, R.array.account_types, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(account_types);


        signup.setOnClickListener(v -> {
            startActivity(new Intent(this, ValidateActivity.class));
        });
    }

    private void bind() {
        username_signup = findViewById(R.id.username_signup);
        email_signup = findViewById(R.id.email_signup);
        password_signup = findViewById(R.id.password_signup);
        password2 = findViewById(R.id.password2_signup);
        signup = findViewById(R.id.signup);
        spinner = findViewById(R.id.spinner);

        toolbar_sign_up = findViewById(R.id.toolbar_sign_up);
        back = findViewById(R.id.back);

    }
}
