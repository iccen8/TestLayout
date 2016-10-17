package edu.wisc.ece.ece454minilab5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RelativeLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_relative_layout);
    }


    public void onClickIcon(View v) {

        Toast.makeText(this, "Keep Calm, and On Wisconsin!",
                Toast.LENGTH_LONG).show();

    }

}