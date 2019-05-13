package mahdihadian.gholhak.ehealth.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import mahdihadian.gholhak.ehealth.R;

public class ValidateActivity extends AppCompatActivity {

    EditText code;
    Button check;

    Toolbar toolbar_validate;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
//        this activity gets validation number and activates the account
//        and redirects to login activity
        bind();

        setSupportActionBar(toolbar_validate);

        back.setOnClickListener(V -> {
            finish();
        });

        check.setOnClickListener(v -> {
//           if code == true
            startActivity(new Intent(this, LoginActivity.class));
        });

    }

    private void bind() {
        code = findViewById(R.id.code);
        check = findViewById(R.id.check);

        toolbar_validate = findViewById(R.id.toolbar_validate);
        back = findViewById(R.id.back);
    }
}
