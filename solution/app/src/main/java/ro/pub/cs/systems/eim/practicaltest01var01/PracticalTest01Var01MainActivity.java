package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private Button butonNord;
    private Button butonVest;
    private Button butonEst;
    private Button butonSud;
    private Button buttonSecondActivity;
    private EditText editTextLog;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        butonNord = findViewById(R.id.buttonNord);
        butonVest = findViewById(R.id.buttonVest);
        butonEst = findViewById(R.id.buttonEst);
        butonSud = findViewById(R.id.buttonSud);
        editTextLog = findViewById(R.id.editTextLog);
        buttonSecondActivity = findViewById(R.id.buttonChangeActivity);

        if (savedInstanceState != null) {
            Toast.makeText(this, savedInstanceState.getString("counter"), Toast.LENGTH_SHORT).show();
            Log.d("afis", counter + "");
            counter = Integer.parseInt(savedInstanceState.getString("counter"));
        } else {
            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();
            Log.d("afis", "0");
            counter = 0;
        }

        buttonSecondActivity.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondaryAction.class);
                Bundle bundle = new Bundle();
                bundle.putString("send", editTextLog.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });

        butonNord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastLog = editTextLog.getText().toString();
                editTextLog.setText(lastLog + ", " + "N");
                counter++;
                Toast.makeText(getApplicationContext(), counter + "", Toast.LENGTH_SHORT).show();

                testStartService();
            }
        });

        butonVest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastLog = editTextLog.getText().toString();
                editTextLog.setText(lastLog + ", " + "V");
                counter++;

                Toast.makeText(getApplicationContext(), counter + "", Toast.LENGTH_SHORT).show();

                testStartService();
            }
        });

        butonEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastLog = editTextLog.getText().toString();
                editTextLog.setText(lastLog + ", " + "E");
                counter++;

                Toast.makeText(getApplicationContext(), counter + "", Toast.LENGTH_SHORT).show();

                testStartService();
            }
        });

        butonSud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lastLog = editTextLog.getText().toString();
                editTextLog.setText(lastLog + ", " + "S");
                counter++;

                Toast.makeText(getApplicationContext(), counter + "", Toast.LENGTH_SHORT).show();
                testStartService();
            }
        });
    }

    private void testStartService() {

        if (counter == 4) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        Log.d("save", "on save state");
        savedInstanceState.putString("counter", counter + "");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

            Toast.makeText(this, savedInstanceState.getString("counter"), Toast.LENGTH_SHORT).show();
            Log.d("afis", counter + "");
            counter = Integer.parseInt(savedInstanceState.getString("counter"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            editTextLog.setText("");
            counter = 0;
            if (resultCode == 0)
                Toast.makeText(this, "register " + resultCode, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "cancel  " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
