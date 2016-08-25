package kz.smartfrog.emergencynumbers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView listViewEmergencyPhones;
    ManualEmergencyPhones emergencyPhones;
    Intent intentToMainAct;
    Button back;
    Button buttonUpdate;
    String savedBasePhones = "";

    List<String> textlist = new ArrayList<>();
    List<ManualEmergencyPhones> listCompanyNames;
    List<ManualEmergencyPhones> companiesList;

    // SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        final String savedBaseNumbersReturn = sharedPref.getString("key", "");
        String [] sarray;
        Log.d("TAG", "here");
        listViewEmergencyPhones = (ListView) findViewById(R.id.listViewEmergencyPhones);

        sarray = savedBaseNumbersReturn.split("\n");
        final ArrayList<String> sarraylist = new ArrayList<>();
        for (int i = 0; i < sarray.length-1; i++) {
            sarraylist.add(sarray[i]);
            Log.d("TAG", "here again");
            Log.d("TAG", sarraylist.get(i));

        }
        //String whereClause = "city =  'Almaty'";
        try {
            if (sarraylist.get(0) != null) {

                //dataQuery.setWhereClause(whereClause);


                listViewEmergencyPhones = (ListView) findViewById(R.id.listViewEmergencyPhones);

                ArrayAdapter<String> adapterOrganisationPhones = new ArrayAdapter<>(Main2Activity.this, R.layout.listview, R.id.textViewInListView, sarraylist);

                listViewEmergencyPhones.setAdapter(adapterOrganisationPhones);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            textlist.clear();

            String whereClause = "city = 'Almaty'";
            BackendlessDataQuery dataQuery = new BackendlessDataQuery( whereClause );
            QueryOptions queryOptions = new QueryOptions(15,0);
            queryOptions.setRelationsDepth( 1 );
            dataQuery.setQueryOptions( queryOptions );

//            BackendlessCollection<ManualEmergencyPhones> friends = Backendless.Data.of(ManualEmergencyPhones.class ).find( dataQuery, new AsyncCallback<BackendlessCollection<ManualEmergencyPhones>> );
//
//            for( ManualEmergencyPhones friend : friends.getData() )
//            {
//
//            }





            Backendless.Persistence.of(ManualEmergencyPhones.class).find(dataQuery, new AsyncCallback<BackendlessCollection<ManualEmergencyPhones>>() {

                @Override
                public void handleResponse(BackendlessCollection<ManualEmergencyPhones> foundContacts) {

                    companiesList = foundContacts.getData();

                    //String text = "";


                    for (int i = 0; i < companiesList.size(); i++) {
                        textlist.add(companiesList.get(i).getNameOfCompanyRU() + " " + companiesList.get(i).getPhoneNumber() + "\n");

                    }

                    //  listViewEmergencyPhones.getAdapter().

                    ArrayAdapter<String> adapterOrganisationPhones = new ArrayAdapter<>(Main2Activity.this, R.layout.listview, R.id.textViewInListView, textlist);
                    listViewEmergencyPhones.setAdapter(adapterOrganisationPhones);


                    for (int i = 0; i < textlist.size(); i++) {
                        savedBasePhones += textlist.get(i);
                        Log.d("TAG", savedBasePhones);
                    }
                    editor.putString("key", savedBasePhones);
                    editor.commit();

                    listViewEmergencyPhones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            int position  = i;
                            Intent call = new Intent(Intent.ACTION_DIAL);

                            call.setData(Uri.parse("tel:" + companiesList.get(position).getPhoneNumber()));
                            startActivity(call);

                        }
                    });

                }   // all Contact instances have been found

                @Override
                public void handleFault(BackendlessFault fault) {
                    String errorret = fault.getCode() + " " + fault.getDetail() + " " + fault.getMessage();// an error has occurred, the error code can be retrieved with fault.getCode()


                }
            });

        }
        });



        intentToMainAct = new Intent(this, MainActivity.class);
        back = (Button)findViewById(R.id.back);
        //   searchView = (SearchView)findViewById(R.id.searchView);



        // List<String> organisationPhones = loadListEmergencyPhones();


        back.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {
            startActivity(intentToMainAct);
        }
        });

        // ListView Item Click Listener
        /*listViewEmergencyPhones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String  itemValue = (String) listViewEmergencyPhones.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });*/




    }

//    private List<String> loadListEmergencyPhones() {
//        final List<ManualEmergencyPhones> list = new ArrayList<ManualEmergencyPhones>();
//
//
////        for (int i = 0; i <20 ; i++) {
////            list.add("Телефон доверия  "+"  115");
////            list.add("Центр обслуживания населения  "+"  1414");
////            list.add("Телефон доверия бытового насилия (для женщин)  "+ "  1415");
////            list.add("Защита прав потребителя  "+"  2040");
////        }
//
//
//        return list;
//    }


}
