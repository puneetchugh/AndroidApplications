package com.example.puneet.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private int price = 5;
    private String name;
    private EditText customerName;
    private CheckBox whippedCreamOption;
    private TextView newQuantity;
    private TextView priceCalculate;
    private StringBuilder orderSummaryString = new StringBuilder();
    private TextView orderSummary;
    private Button orderButton;
    private String email;
    private EditText customerEmailId;
    Intent intent = new Intent(Intent.ACTION_SEND);
    //Button increment = new Button(this);
    //Button decrement = new Button(this);
    //TextView newQuantity = new TextView(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newQuantity = (TextView) findViewById(R.id.quantityOrderedId);
        priceCalculate = (TextView) findViewById(R.id.priceCalculateId);
        whippedCreamOption = (CheckBox) findViewById(R.id.whippedCreamId);
        customerName = (EditText) findViewById(R.id.customerNameId);
        orderSummary = (TextView) findViewById(R.id.orderSummaryId);
        orderButton = (Button) findViewById(R.id.orderButtonId);
        customerEmailId = (EditText) findViewById(R.id.emailId);

        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "chughpuneet2005@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(Intent.createChooser(intent, "Send Email"));


        //orderSummary.append(String.format("Order Summary%n%n"));
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

    /**
     * incrementFunction() increments the quantity of coffee cups and keeps it to less than equal to 10
     * Returns nothing
     * @param v
     */

    public void incrementFunction(View v) {
        if(quantity<= 9){
            quantity++;

            //newQuantity.setText(String.valueOf(quantity));
            display(String.valueOf(quantity), newQuantity);
            calculatePrice();
        }

        else{
        Log.d("MainActivity", "greater than 10");
        Toast.makeText(this, "You cannot add more than 10 coffee-cups. You can make another order instead.", Toast.LENGTH_SHORT).show();
            //AlertDialog.Builder b = new AlertDialog.Builder(this);
            //b.setTitle("Quantity");
            //b.setMessage("You cannot add more than 10 coffees. You can make another order instead.");
            //b.show();

        }


    }

    /**
     * decrementFunction() decrements the quantity of the cups of coffee and keeps it to equal to or more than 1
     * Returns nothing
     * @param v
     */
    public void decrementFunction(View v) {
        if(quantity>1){
            quantity--;
            //String myQuantity = quantity.toString();
            //newQuantity.setText(String.valueOf(quantity));
            display(String.valueOf(quantity), newQuantity);
            calculatePrice();
        }
        else{
        Toast.makeText(this, "Your order cannot be less than 1 cup of coffee.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *calculatePrice() calculates the final price of the coffee
     * Returns nothing
     */
    public void calculatePrice(){
        //int price = 0;
        StringBuilder stringForPrice = new StringBuilder();
        price = quantity * 5;
        //priceCalculate.setText("Price  :  " + (quantity * 5));
        stringForPrice.append(String.format("Price  :  $%d", price));
        display(stringForPrice.toString(), priceCalculate);
    }

    public void display(String stringToDisplay, TextView viewToBeUsed){
        viewToBeUsed.setText(stringToDisplay);
    }

    public void onCheckBoxClick(View v){

        if(whippedCreamOption.isChecked()){
            price = price + (1 * quantity);
            Log.d("MainActivity", "whippedCreamOptionSelected");
        }
    }

    /**
     * orderSummaryFunction() is called upon the ORDER button press from the android screen. It builds up the order and sends an email to the customer.
     * @param view
     */
    public void orderSummaryFunction(View view){

        StringBuilder onlyEmailId = new StringBuilder();
        name = customerName.getText().toString();
        email = customerEmailId.getText().toString();
        orderSummaryString.append(String.format("Order Summary%n%n"));
        orderSummaryString.append(name);
        orderSummaryString.append("! Your coffee is ready.");
        if(whippedCreamOption.isChecked()){
            orderSummaryString.append(String.format("%nWhipped Cream : Yes%n" ));
        }
        else{
            orderSummaryString.append(String.format("%nWhipped Cream : No%n"));
        }
        orderSummaryString.append(String.format("Total : $%d%n", price));
        orderSummary.setText(orderSummaryString.toString());
        //onlyEmailId.append("mailto");
        //onlyEmailId.append(email);

        intent.putExtra(Intent.EXTRA_SUBJECT, "Your coffee order at Just-Java");
        intent.putExtra(Intent.EXTRA_TEXT, orderSummaryString.toString());

    }


}
