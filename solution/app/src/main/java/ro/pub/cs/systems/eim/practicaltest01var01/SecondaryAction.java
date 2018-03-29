package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryAction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        Intent intent = getIntent();

        Bundle bund = intent.getExtras();
        String af = (String) bund.get("send");

        EditText ed = findViewById(R.id.editTextLog);
        ed.setText(af);

        Button register = findViewById(R.id.registerButton);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setResult(0);
                finish();
            }
        });

        Button cancel = findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setResult(1);
                finish();
            }
        });

    }
}
