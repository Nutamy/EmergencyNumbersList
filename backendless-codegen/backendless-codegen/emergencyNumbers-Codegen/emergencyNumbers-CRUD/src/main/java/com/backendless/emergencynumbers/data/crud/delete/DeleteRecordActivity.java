package com.backendless.emergencynumbers.data.crud.delete;

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

public class DeleteRecordActivity extends Activity
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

    String titleTemplate = getResources().getString( R.string.delete_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );

    if( table.equals( "ManualEmergencyPhones" ) )
    {
      code = getManualEmergencyPhonesDeletionCode();
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
      deleteManualEmergencyPhonesRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Delete" );
    startActivity( nextIntent );
  }

  private String getManualEmergencyPhonesDeletionCode()
  {
    return "public void remove( ManualEmergencyPhones manualEmergencyPhones )\n"
            + "{\n"
            + "  manualEmergencyPhones.removeAsync( new AsyncCallback<Long>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( Long deletionTime )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), \"Deletion time: \" + new Date( deletionTime ).toString(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void deleteManualEmergencyPhonesRecord()
  {
    ManualEmergencyPhones.findFirstAsync( new DefaultCallback<ManualEmergencyPhones>( DeleteRecordActivity.this )
    {
      @Override
      public void handleResponse( ManualEmergencyPhones response )
      {
        super.handleResponse( response );
        ManualEmergencyPhones firstManualEmergencyPhones = response;
        firstManualEmergencyPhones.removeAsync( new DefaultCallback<Long>( DeleteRecordActivity.this )
        {
          @Override
          public void handleResponse( Long response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( getBaseContext(), DeleteSuccessActivity.class );
            nextIntent.putExtra( "time", response );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }
}