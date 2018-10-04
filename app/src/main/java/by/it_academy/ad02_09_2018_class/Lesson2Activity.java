package by.it_academy.ad02_09_2018_class;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lesson2Activity extends Activity {
    private EditText usernmeEditText;
    private EditText passwordEditText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson2);

        usernmeEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        Button button = findViewById(R.id.log_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSecondActivity();
            }
        });

//        Log.d("MyLog","msg");

    }

    private void startSecondActivity() {
//        if (TextUtils.isEmpty(passwordEditText.getText()) || TextUtils.isEmpty(passwordEditText.getText())) {
//            Toast.makeText(this, R.string.login_error, Toast.LENGTH_SHORT).show();
//            return;
//        }

        Lesson2SecondActivity.show(this, String.valueOf(usernmeEditText.getText()), String.valueOf(passwordEditText.getText()));
    }
}
