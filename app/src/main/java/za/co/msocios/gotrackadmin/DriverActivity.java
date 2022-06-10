package za.co.msocios.gotrackadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import za.co.msocios.gotrackadmin.Common.Common;

public class DriverActivity extends AppCompatActivity {


    TextView txtname,txtsurname,txtphone,txtemail,txtcar,txtcarReg,txtstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        txtname = findViewById(R.id.txtname);
        txtsurname=  findViewById(R.id.txtsurname);
        txtphone=  findViewById(R.id.txtphone);
        txtemail= findViewById(R.id.txtemail);
        txtcar = findViewById(R.id.txtCar);
        txtcarReg = findViewById(R.id.txtReg);
        txtstatus  = findViewById(R.id.txtState);


        txtname.setText(Common.selectedDriver.getNames());
        txtsurname.setText(Common.selectedDriver.getSurname());
       // txtphone.setText(Common.selectedDriver.get);
       // txtemail.setText();
        txtcar.setText(Common.selectedDriver.getCarName());
        txtcarReg.setText("Registration: "+Common.selectedDriver.getCarReg());
       // txtstatus.setText();

    }
}