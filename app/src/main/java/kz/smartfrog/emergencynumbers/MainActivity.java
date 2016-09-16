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


        View.OnClickListener callTo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton101:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:101"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 101");
                    break;

                    case R.id.imageView101:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:101"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 101");
                        break;

                    case R.id.textView101:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:101"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 101");
                        break;

                    case R.id.imageButton102:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:102"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 102");
                        break;

                    case R.id.imageView102:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:102"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 102");
                        break;

                    case R.id.textView102:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:102"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 102");
                        break;

                    case R.id.imageButton103:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:103"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 103");
                        break;

                    case R.id.imageView103:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:103"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 103");
                        break;

                    case R.id.textView103:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:103"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 103");
                        break;

                    case R.id.imageButton104:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:104"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 104");
                        break;

                    case R.id.imageView104:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:104"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 104");
                        break;

                    case R.id.textView104:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:104"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 104");
                        break;

                    case R.id.imageButton112:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:112"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 112");
                        break;

                    case R.id.imageView112:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:112"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 112");
                        break;

                    case R.id.textView112:
                        intentCall = new Intent(Intent.ACTION_DIAL);
                        intentCall.setData(Uri.parse("tel:112"));
                        Log.d("TAG", intentCall.getData().toString());
                        startActivity(intentCall);
                        Log.d("TAG", "call 112");
                        break;
                }
            }
        };

        exNumber101.setOnClickListener(callTo);
        exNumber102.setOnClickListener(callTo);
        exNumber103.setOnClickListener(callTo);
        exNumber104.setOnClickListener(callTo);
        exNumber112.setOnClickListener(callTo);
        imageView101.setOnClickListener(callTo);
        imageView102.setOnClickListener(callTo);
        imageView103.setOnClickListener(callTo);
        imageView104.setOnClickListener(callTo);
        imageView112.setOnClickListener(callTo);
        textView101.setOnClickListener(callTo);
        textView102.setOnClickListener(callTo);
        textView103.setOnClickListener(callTo);
        textView104.setOnClickListener(callTo);
        textView112.setOnClickListener(callTo);



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
