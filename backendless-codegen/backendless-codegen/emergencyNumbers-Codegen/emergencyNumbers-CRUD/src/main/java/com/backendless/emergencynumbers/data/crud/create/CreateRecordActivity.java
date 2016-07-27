package com.backendless.emergencynumbers.data.crud.create;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.backendless.emergencynumbers.data.*;
import com.backendless.emergencynumbers.data.crud.R;
import com.backendless.emergencynumbers.data.crud.common.DataApplication;
import com.backendless.emergencynumbers.data.crud.common.DefaultCallback;
import com.backendless.emergencynumbers.data.crud.common.SendEmailActivity;
import com.backendless.geo.GeoPoint;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateRecordActivity extends Activity
{
  private TextView titleView;
  private EditText codeEdit;
  private Button runCodeButton, sendCodeButton;

  private String code;
  private String table;

                                    
  class CreateManualEmergencyPhonesRecordTask extends AsyncTask<Void, Void, ManualEmergencyPhones>
  {
    ManualEmergencyPhones manualEmergencyPhones = new ManualEmergencyPhones();

    @Override
    protected void onPreExecute()
    {
      manualEmergencyPhones.setNameOfCompanyKZ( UUID.randomUUID().toString() );
      manualEmergencyPhones.setNameOfCompanyENG( UUID.randomUUID().toString() );
      manualEmergencyPhones.setPhoneNumber( UUID.randomUUID().toString() );
      manualEmergencyPhones.setCity( UUID.randomUUID().toString() );
      manualEmergencyPhones.setCountry( UUID.randomUUID().toString() );
      manualEmergencyPhones.setNameOfCompanyRU( UUID.randomUUID().toString() );
    }

    @Override
    protected ManualEmergencyPhones doInBackground( Void... voids )
    {
      return manualEmergencyPhones.save();
    }
  };
                                    

  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.sample_code_template );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    initUI();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.sampleCodeTitle );
    codeEdit = (EditText) findViewById( R.id.sampleCodeEdit );
    runCodeButton = (Button) findViewById( R.id.runCodeButton );
    sendCodeButton = (Button) findViewById( R.id.sendCodeButton );

    String titleTemplate = getResources().getString( R.string.create_record_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );

    if( table.equals( "ManualEmergencyPhones" ) )
    {
      code = getManualEmergencyPhonesCreationCode();
    }

    codeEdit.setText( code );

    runCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onRunCodeButtonClicked();
      }
    } );

    sendCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onSendCodeButtonClicked();
      }
    } );
  }

  private void onRunCodeButtonClicked()
  {
    if( table.equals( "ManualEmergencyPhones" ) )
    {
      createManualEmergencyPhonesRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Create" );
    startActivity( nextIntent );
  }

  private String getManualEmergencyPhonesCreationCode()
  {
    return "ManualEmergencyPhones manualEmergencyPhones = new ManualEmergencyPhones();\n"
            + "manualEmergencyPhones.setNameOfCompanyKZ( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.setNameOfCompanyENG( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.setPhoneNumber( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.setCity( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.setCountry( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.setNameOfCompanyRU( UUID.randomUUID().toString() );\n"
            + "manualEmergencyPhones.saveAsync( new AsyncCallback<ManualEmergencyPhones>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( ManualEmergencyPhones savedManualEmergencyPhones )\n"
            + "  {\n"
            + "    manualEmergencyPhones = savedManualEmergencyPhones;\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "});";
  }

  private void createManualEmergencyPhonesRecord()
  {
    ManualEmergencyPhones manualEmergencyPhones = null;

    try
    {
      manualEmergencyPhones = new CreateManualEmergencyPhonesRecordTask().execute().get( 30, TimeUnit.SECONDS );
    }
    catch ( Exception e )
    {
      Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
      return;
    }

    Intent nextIntent = new Intent( CreateRecordActivity.this, CreateSuccessActivity.class );
    startActivity( nextIntent );
  }
}