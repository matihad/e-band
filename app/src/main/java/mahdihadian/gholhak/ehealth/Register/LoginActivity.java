package mahdihadian.gholhak.ehealth.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import mahdihadian.gholhak.ehealth.MainActivity;
import mahdihadian.gholhak.ehealth.R;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginbtn, signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bind();

        loginbtn.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });

        signupbtn.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
    }

    private void bind() {
        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        loginbtn = findViewById(R.id.loginbtn);
        signupbtn = findViewById(R.id.signupbtn);
    }
}
