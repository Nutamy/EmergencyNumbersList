package kz.smartfrog.emergencynumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listViewEmergencyPhones;
    Intent intentToMainAct;
    Button back;
   // SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intentToMainAct = new Intent(this, MainActivity.class);
        back = (Button)findViewById(R.id.back);
     //   searchView = (SearchView)findViewById(R.id.searchView);
        listViewEmergencyPhones = (ListView)findViewById(R.id.listViewEmergencyPhones);


        List<String> organisationPhones = loadListEmergencyPhones();
        ArrayAdapter<String> adapterOrganisationPhones = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, organisationPhones);

        listViewEmergencyPhones.setAdapter(adapterOrganisationPhones);

        back.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            startActivity(intentToMainAct);
        }
        });
    }

    private List<String> loadListEmergencyPhones() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <20 ; i++) {
            list.add("Телефон доверия  "+"  115");
            list.add("Центр обслуживания населения  "+"  1414");
            list.add("Телефон доверия бытового насилия (для женщин)  "+ "  1415");
            list.add("Защита прав потребителя  "+"  2040");
        }


        return list;
    }
}
