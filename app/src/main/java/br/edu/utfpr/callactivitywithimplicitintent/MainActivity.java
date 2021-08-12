package br.edu.utfpr.callactivitywithimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openUtfprWebsite(View view) {
        openWebsite("http://www.utfpr.edu.br");
    }

    private void openWebsite( String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(address));

        intent.resolveActivity(getPackageManager());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this,
                    R.string.there_is_no_app_to_run_this_action,
                    Toast.LENGTH_LONG).show();
        }
    }
}