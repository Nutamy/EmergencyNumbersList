package kz.smartfrog.emergencynumbers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.playlog.internal.LogEvent;

public class MainActivity extends AppCompatActivity {
    Intent intentToManualEmergencyPhones;
    Intent intentCall;
    ImageView imageView101;
    ImageView imageView102;
    ImageView imageView103;
    ImageView imageView104;
    ImageView imageView112;
    ImageButton exNumber101;
    ImageButton exNumber102;
    ImageButton exNumber103;
    ImageButton exNumber104;
    ImageButton exNumber112;
    Button manualEmergencyPhones;
    TextView textView101;
    TextView textView102;
    TextView textView103;
    TextView textView104;
    TextView textView112;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp(this, "11429BC2-042A-4E59-FF22-4F9248E4DF00", "1D3DF352-7502-A80D-FF37-2C6146278A00", appVersion);

        exNumber101 = (ImageButton) findViewById(R.id.imageButton101);
        exNumber102 = (ImageButton) findViewById(R.id.imageButton102);
        exNumber103 = (ImageButton) findViewById(R.id.imageButton103);
        exNumber104 = (ImageButton) findViewById(R.id.imageButton104);
        exNumber112 = (ImageButton) findViewById(R.id.imageButton112);
        manualEmergencyPhones = (Button) findViewById(R.id.buttonManualEmergPhones);
        imageView101 = (ImageView)findViewById(R.id.imageView101);
        imageView102 = (ImageView)findViewById(R.id.imageView102);
        imageView103 = (ImageView)findViewById(R.id.imageView103);
        imageView104 = (ImageView)findViewById(R.id.imageView104);
        imageView112 = (ImageView)findViewById(R.id.imageView112);
        textView101 = (TextView) findViewById(R.id.textView101);
        textView102 = (TextView) findViewById(R.id.textView102);
        textView103 = (TextView) findViewById(R.id.textView103);
        textView104 = (TextView) findViewById(R.id.textView104);
        textView112 = (TextView) findViewById(R.id.textView112);
        intentToManualEmergencyPhones = new Intent(this, Main2Activity.class);

        imageView101.setClickable(true);
        imageView102.setClickable(true);
        imageView103.setClickable(true);
        imageView104.setClickable(true);
        imageView112.setClickable(true);

        manualEmergencyPhones.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentToManualEmergencyPhones);
            }
        });


        View.OnClickListener call101 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:101"));

                Log.d("TAG", intentCall.getData().toString());
                startActivity(intentCall);
                Log.d("TAG", "call 101");
            }
        };

        exNumber101.setOnClickListener(call101);
        imageView101.setOnClickListener(call101);

        View.OnClickListener call102 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:102"));

                Log.d("TAG", intentCall.getData().toString());
                startActivity(intentCall);
                Log.d("TAG", "call 102");
            }
        };

        exNumber102.setOnClickListener(call102);
        imageView102.setOnClickListener(call102);

        View.OnClickListener call103 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:103"));

                Log.d("TAG", intentCall.getData().toString());
                startActivity(intentCall);
                Log.d("TAG", "call 103");
            }
        };

        exNumber103.setOnClickListener(call103);
        imageView103.setOnClickListener(call103);


        View.OnClickListener call104 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:104"));

                Log.d("TAG", intentCall.getData().toString());
                startActivity(intentCall);
                Log.d("TAG", "call 104");
            }
        };

        exNumber104.setOnClickListener(call104);
        imageView104.setOnClickListener(call104);

        View.OnClickListener call112 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall = new Intent(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:112"));
                Log.d("TAG", intentCall.getData().toString());
                startActivity(intentCall);
                Log.d("TAG", "call 112");
            }
        };

        exNumber112.setOnClickListener(call112);
        imageView112.setOnClickListener(call112);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://kz.smartfrog.emergencynumbers/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://kz.smartfrog.emergencynumbers/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
