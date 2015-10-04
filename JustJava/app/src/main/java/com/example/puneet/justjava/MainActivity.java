package com.example.puneet.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int quantity = 1;
    private int price = 0;
    String name;
    EditText customerName;
    CheckBox whippedCreamOption;
    TextView newQuantity;
    TextView priceCalculate;
    StringBuilder orderSummaryString = new StringBuilder();
    TextView orderSummary;
    //Button increment = new Button(this);
    //Button decrement = new Button(this);
    //TextView newQuantity = new TextView(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // increment = (Button) findViewById(R.id.incrementId);
       /* increment.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(){


                                        }
                                     }
        );*/
        //decrement = (Button) findViewById(decrementId);
        //decrement.setOnClickListener(this);
        newQuantity = (TextView) findViewById(R.id.quantityOrderedId);
        priceCalculate = (TextView) findViewById(R.id.priceCalculateId);
        whippedCreamOption = (CheckBox) findViewById(R.id.whippedCreamId);
        customerName = (EditText) findViewById(R.id.customerNameId);
        orderSummary = (TextView) findViewById(R.id.orderSummaryId);
        name = customerName.getText().toString();
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

        if(v == whippedCreamOption){
            price = price + 1;
            Log.d("MainActivity", "whippedCreamOptionSelected");
        }
    }
/*
    public void getCustomerName(View view){
        customerName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    orderSummaryString.append(customerName.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });
    }*/
    public void orderSummaryFunction(View view){
       // customerName.getText();
        orderSummaryString.append(String.format("Order Summary%n%n"));
        orderSummaryString.append(name);
        if(whippedCreamOption.isChecked()){
            orderSummaryString.append(String.format("%nCream Topping : Yes%n" ));
        }
        else{
            orderSummaryString.append(String.format("Cream Topping : No%n"));
        }
        orderSummaryString.append(String.format("Total : %d%n", price));
        orderSummary.setText(orderSummaryString.toString());
        //orderSummaryString.append(customerName);
    }
    /*
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.decrementId: {
                decrementFunction();
                break;
            }

            case R.id.incrementId: {
                incrementFunction();
                break;
            }

        }
    }*/

}
