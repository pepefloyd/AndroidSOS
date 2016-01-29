package com.example.jgarciaponce.mysosapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String getEmail(){
        EditText field;
        field   = (EditText)findViewById(R.id.email);
        return field.getText().toString();
    }

    private String getDeploymentId(){
        EditText field;
        field  = (EditText)findViewById(R.id.deploymentid);
        return field.getText().toString();
    }

    private String getOrgId(){
        EditText field;
        field  = (EditText)findViewById(R.id.orgid);
        return field.getText().toString();
    }
    private String getAPIEndpoint(){
        EditText field;
        field  = (EditText)findViewById(R.id.endpoint);
        return field.getText().toString();
    }

    private Boolean validateFields(){

        if (isNullOrBlank(getDeploymentId()) || isNullOrBlank(getAPIEndpoint()) || isNullOrBlank(getOrgId()) ){

            toastError("validation");
            return false;
        }
        return true;
    }

    private void toastError(String errorType){
        if(errorType == "validation"){
            Toast.makeText(getApplicationContext(), getString(R.string.validationerror), Toast.LENGTH_LONG).show();
        }
        else if(errorType == "exception"){
            Toast.makeText(getApplicationContext(), getString(R.string.exceptionerror), Toast.LENGTH_LONG).show();
        }
    }
    private Boolean isNullOrBlank(String s){
        return s == null || s.equals("") ? true : false;
    }

    public void handleSOSButton(View view) {

        try{
            if (validateFields()){
                SOSHandler SOS = new SOSHandler();
                SOS.startSos( getAPIEndpoint(), getOrgId(), getDeploymentId(),getEmail(), this);
            }
        }
        catch(Exception e){
            toastError("exception");
        }

    }




}
