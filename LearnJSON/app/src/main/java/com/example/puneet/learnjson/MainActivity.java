package com.example.puneet.learnjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button orderButton;
    private PersonInformation[] personInformations;
    private int counter;
    public EditText phoneNumber;
    public EditText name;
    //private JSONArray jsonObject[];
    protected TextView printName, printActualName, printPhone, printActualPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = (EditText) findViewById(R.id.phoneId);
        name = (EditText) findViewById(R.id.nameId);
        orderButton = (Button) findViewById(R.id.buttonId);
        printName = (TextView) findViewById(R.id.printNameId);
        printActualName = (TextView) findViewById(R.id.printActualNameId);
        printPhone = (TextView) findViewById(R.id.printPhoneId);
        printActualPhone= (TextView) findViewById(R.id.printActualPhoneId);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void enterJSONData(View view){

        //jsonObject[counter] = new JSONObject();
        JSONObject newJsonObject = new JSONObject();
        //personInformations[counter] = new PersonInformation(name.getText().toString(), phoneNumber.getText().toString());

        try {
            newJsonObject.put("name", name.getText());
            newJsonObject.put("phone", phoneNumber.getText());

            String strCounter = String.format("Contact%d", counter);

            //jsonObject[counter].put(strCounter, newJsonObject);
            printInformation(newJsonObject);
        }

        catch(JSONException ex) {
            ex.printStackTrace();
        }

    }

    public void printInformation(JSONObject newJsonObject){
        try{
            String strCounter = String.format("Contact%d", counter);
            String name = newJsonObject.getString("name");
            String phoneNumber = newJsonObject.getString("phone");
           //String myObject = newJsonObject.getString(strCounter);
          //JSONObject anotherJsonObject = new JSONObject();

            printName.setText("Name         :    ");
            printActualName.setText(name);
            printPhone.setText("Phone Number : ");
            printActualPhone.setText(phoneNumber);

        }
        catch(JSONException ex){
            ex.printStackTrace();
        }
    }
}
