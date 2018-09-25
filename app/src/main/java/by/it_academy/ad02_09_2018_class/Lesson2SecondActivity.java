package by.it_academy.ad02_09_2018_class;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Lesson2SecondActivity extends Activity {
    public static final String EXTRA_USERNAME = "EXTRA_USERNAME";
    public static final String EXTRA_PASSWORD = "EXTRA_PASSWORD";

    private ImageView imageView;

    public static void show(Activity activity, String username, String password) {
        Intent intent = new Intent(activity, Lesson2SecondActivity.class);
        intent.putExtra(Lesson2SecondActivity.EXTRA_USERNAME, String.valueOf(username));
        intent.putExtra(Lesson2SecondActivity.EXTRA_PASSWORD, String.valueOf(password));
        activity.startActivity(intent);
//        activity.overridePendingTransition(R.anim...;R.anim....); //first to previously, second to next;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson2second);
//        imageView = findViewById(R.id.imageView);
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);

        Intent intent = getIntent();

        String username = intent.getStringExtra(EXTRA_USERNAME);
        String password = intent.getStringExtra(EXTRA_PASSWORD);

        TextView textView = findViewById(R.id.resultTextView);
        textView.setText(BuildConfig.SERVER_URL + " " + password);


    }

    // To back to the previously activity
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        activity.overridePendingTransition(R.anim...;R.anim....)
//    }


//    @Override
//    protected void onResume() {
//        start animation
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        pause animation
//        super.onResume();
//    }
}
