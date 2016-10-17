package edu.wisc.ece.ece454minilab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LinearLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getApplicationContext(),
                "Now you are in LinearLayoutActivity", Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_linear_layout);
    }

    public void onGoBackClicked(View v) {

        Intent intent = new Intent(LinearLayoutActivity.this,
                MainLayoutActivity.class);
        startActivity(intent);
    }

}