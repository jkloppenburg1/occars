package edu.orangecoastcollege.cs273.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends Activity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton threeYearsRadioButton;
    private RadioButton fourYearsRadioButton;
    private RadioButton fiveYearsRadioButton;



    private Car currentCar = new Car();

    private String monthlyPaymentText;
    private String loanSummaryText;

    // When associating the button with an event, set the onClick property
    // Define the method as public void (with one parameter View view)
    public void activateLoanReport(View view)
    {
        double price;
        double downPayment;
        try
        {
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }

        int loanTerm;

        if (fiveYearsRadioButton.isChecked())
        {
            loanTerm = 5;
        }
        else if (fourYearsRadioButton.isChecked())
        {
            loanTerm = 4;
        }
        else
        {
            loanTerm = 3;
        }

        currentCar.setPrice(price);
        currentCar.setDownPayment(downPayment);
        currentCar.setLoanTerm(loanTerm);

        constructLoanSummaryText();

        // Create the Intent to share data with LoanSummaryActivity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary", loanSummaryText);
        //Start the new activity with the intent data
        startActivity(loanSummaryIntent);
    }

    private void constructLoanSummaryText()
    {
        monthlyPaymentText = getString(R.string.report_line1) + currentCar.calculateMonthlyPayment();

        loanSummaryText = getString(R.string.report_line2) + currentCar.getPrice()
                + getString(R.string.report_line3) + currentCar.getDownPayment()
                + getString(R.string.report_line5) + currentCar.calculateTaxAmount()
                + getString(R.string.report_line6) + currentCar.calculateTotalAmount()
                + getString(R.string.report_line7) + currentCar.calculateBorrowedAmount()
                + getString(R.string.report_line8) + currentCar.calculateInterestAmount()
                //+ getString(R.string.report_line4) + currentCar.getLoanTerm()
                + getString(R.string.report_line9)
                + getString(R.string.report_line10)
                + getString(R.string.report_line11);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        threeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        carPriceEditText.addTextChangedListener(carPriceChangedListener);
        downPaymentEditText.addTextChangedListener(downPaymentChangedListener);


    }

    private TextWatcher carPriceChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try
            {
                if (charSequence.length() > 0) {
                    double amount = Double.parseDouble(charSequence.toString());
                    currentCar.setPrice(amount);
                }
                else
                {
                    double amount = 0.0;
                    currentCar.setPrice(amount);
                }

            }
            catch (NumberFormatException e)
            {
                carPriceEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private TextWatcher downPaymentChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try
            {
                if (charSequence.length() > 0) {
                    double amount = Double.parseDouble(charSequence.toString()) / 100.0;
                    currentCar.setDownPayment(amount);
                }
                else
                {
                    double amount = 0.0;
                    currentCar.setDownPayment(amount);
                }

            }
            catch (NumberFormatException e)
            {
                downPaymentEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
