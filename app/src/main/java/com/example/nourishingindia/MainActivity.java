package com.example.nourishingindia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public EditText numberofempET, numberofdaysET, mealplanET;
public Button submitBTN;
public Integer numberofemp, numberofdays, mealplan;
public Integer roti,sabji, dalrice,dessert,total;
public TextView mealresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberofempET=findViewById(R.id.idEmpInput);
        numberofdaysET=findViewById(R.id.idDaysInput);
        mealplanET=findViewById(R.id.idMealInput);
        submitBTN=findViewById(R.id.idSubmit);
        mealresult=findViewById(R.id.idResult);

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getvalues();
                selectmealplan();
            }
        });

    }

    private void selectmealplan() {
        switch (mealplan){
            case 110:
                dalrice=1;
                roti=3;
                sabji=2;
                break;
            case 145:
                dalrice=1;
                roti=3;
                sabji=2;
                dessert=1;
                break;
            default:
                dalrice=1;
                roti=1;
                sabji=1;
        }
        calulatetotal();
        displaymealplan();
    }

    private void calulatetotal() {
        total=numberofemp*numberofdays*mealplan;
    }

    private void displaymealplan() {
        String Result = String.format(
                " Roti %d \n Sabji %d \n Daal-Rice %d"
                +"\n Total %d"
                ,roti,sabji,dalrice,total);
        mealresult.setText(Result);
    }

    private void getvalues() {
        numberofdays=Integer.parseInt( numberofdaysET.getText().toString() );
        numberofemp=Integer.parseInt( numberofempET.getText().toString() );
        mealplan=Integer.parseInt( mealplanET.getText().toString() );
    }
}