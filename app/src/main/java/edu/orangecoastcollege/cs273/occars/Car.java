package edu.orangecoastcollege.cs273.occars;

/**
 * Created by jkloppenburg1 on 9/15/2016.
 */
public class Car {

    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;

    private static final double TAX_RATE = 0.08;

    public Car() {
        this.mDownPayment = 0.0;
        this.mLoanTerm = 1;
        this.mPrice = 0.0;
    }

    public Car(double mDownPayment, int mLoanTerm, double mPrice) {
        this.mDownPayment = mDownPayment;
        this.mLoanTerm = mLoanTerm;
        this.mPrice = mPrice;
    }

    public double calculateBorrowedAmount()
    {return 0.0;}

    public double calculateInterestAmount()
    {return 0.0;}

    public double calculateMonthlyPayment()
    {return 0.0;}

    public double calculateTaxAmount()
    {return 0.0;}

    public double calculateTotalAmount()
    {return 0.0;}

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double mDownPayment) {
        this.mDownPayment = mDownPayment;
    }

    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int mLoanTerm) {
        this.mLoanTerm = mLoanTerm;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }
}
