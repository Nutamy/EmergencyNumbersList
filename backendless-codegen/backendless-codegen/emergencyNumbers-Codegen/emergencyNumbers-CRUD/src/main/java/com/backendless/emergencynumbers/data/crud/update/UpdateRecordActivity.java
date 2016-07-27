package com.backendless.emergencynumbers.data.crud.update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.backendless.emergencynumbers.data.*;
import com.backendless.emergencynumbers.data.crud.R;
import com.backendless.emergencynumbers.data.crud.common.DataApplication;
import com.backendless.emergencynumbers.data.crud.common.DefaultCallback;
import com.backendless.emergencynumbers.data.crud.common.SendEmailActivity;
import com.backendless.geo.GeoPoint;

import java.util.Collections;

import java.util.Random;
import java.util.UUID;

public class UpdateRecordActivity extends Activity
{
  private TextView titleView;
  private EditText codeView;
  private Button runCodeButton, sendCodeButton;

  private String code;
  private String table;

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
    codeView = (EditText) findViewById( R.id.sampleCodeEdit );
    runCodeButton = (Button) findViewById( R.id.runCodeButton );
    sendCodeButton = (Button) findViewById( R.id.sendCodeButton );

    String titleTemplate = getResources().getString( R.string.update_title_template );
    String title = String.format( titleTemplate, table );

    titleView.setText( title );

    if( table.equals( "ManualEmergencyPhones" ) )
    {
      code = getManualEmergencyPhonesUpdateCode();
    }

    codeView.setText( code );

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
      updateManualEmergencyPhonesRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Update" );
    startActivity( nextIntent );
  }

  private String getManualEmergencyPhonesUpdateCode()
  {
    return "public void update( ManualEmergencyPhones manualEmergencyPhones )\n"
            + "{\n"
            + "  manualEmergencyPhones.setNameOfCompanyKZ( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.setNameOfCompanyENG( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.setPhoneNumber( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.setCity( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.setCountry( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.setNameOfCompanyRU( UUID.randomUUID().toString() );\n"
            + "  manualEmergencyPhones.saveAsync( new AsyncCallback<ManualEmergencyPhones>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( ManualEmergencyPhones updatedRecord )\n"
            + "    {\n"
            + "      //work with object\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void updateManualEmergencyPhonesRecord()
  {
    ManualEmergencyPhones.findFirstAsync( new DefaultCallback<ManualEmergencyPhones>( UpdateRecordActivity.this )
    {
      @Override
      public void handleResponse( ManualEmergencyPhones response )
      {
        super.handleResponse( response );
        ManualEmergencyPhones manualEmergencyPhones = response;
        manualEmergencyPhones.setNameOfCompanyKZ( UUID.randomUUID().toString() );
        manualEmergencyPhones.setNameOfCompanyENG( UUID.randomUUID().toString() );
        manualEmergencyPhones.setPhoneNumber( UUID.randomUUID().toString() );
        manualEmergencyPhones.setCity( UUID.randomUUID().toString() );
        manualEmergencyPhones.setCountry( UUID.randomUUID().toString() );
        manualEmergencyPhones.setNameOfCompanyRU( UUID.randomUUID().toString() );

        manualEmergencyPhones.saveAsync( new DefaultCallback<ManualEmergencyPhones>( UpdateRecordActivity.this )
        {
          @Override
          public void handleResponse( ManualEmergencyPhones response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( UpdateRecordActivity.this, UpdateSuccessActivity.class );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }
}