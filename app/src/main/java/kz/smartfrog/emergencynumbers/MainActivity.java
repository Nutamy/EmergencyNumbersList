package kz.smartfrog.emergencynumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity {
    Intent intentToManualEmergencyPhones;
    Button exNumber101;
    Button exNumber102;
    Button exNumber103;
    Button exNumber104;
    Button exNumber112;
    Button manualEmergencyPhones;
    TextView textView101;
    TextView textView102;
    TextView textView103;
    TextView textView104;
    TextView textView112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp( this, "11429BC2-042A-4E59-FF22-4F9248E4DF00", "1D3DF352-7502-A80D-FF37-2C6146278A00", appVersion );

        exNumber101 = (Button)findViewById(R.id.button101);
        exNumber102 = (Button)findViewById(R.id.button102);
        exNumber103 = (Button)findViewById(R.id.button103);
        exNumber104 = (Button)findViewById(R.id.button104);
        exNumber112 = (Button)findViewById(R.id.button112);
        manualEmergencyPhones = (Button)findViewById(R.id.buttonManualEmergPhones);
        textView101 = (TextView)findViewById(R.id.textView101);
        textView102 = (TextView)findViewById(R.id.textView102);
        textView103 = (TextView)findViewById(R.id.textView103);
        textView104 = (TextView)findViewById(R.id.textView104);
        textView112 = (TextView)findViewById(R.id.textView112);
        intentToManualEmergencyPhones = new Intent(this, Main2Activity.class);

        manualEmergencyPhones.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            startActivity(intentToManualEmergencyPhones);
        }
        });

    }

}
