package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Models.Driver;

public class DriverActivity extends AppCompatActivity {


    TextView txtname,txtsurname,txtphone,txtemail,txtcar,txtcarReg,txtstatus;
    Button approve;
    FirebaseFirestore firestore;
    ImageView imageView;

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
        txtstatus  = findViewById(R.id.txtStatus);
        approve = findViewById(R.id.btnApprove);
        firestore = FirebaseFirestore.getInstance();
        imageView = findViewById(R.id.license);


        txtname.setText("Name: "+Common.selectedDriver.getNames());
        txtsurname.setText("Surname: "+Common.selectedDriver.getSurname());
        txtphone.setText(Common.selectedDriver.getPhoneNumber());
        txtemail.setText(Common.selectedDriver.getEmail());
        txtcar.setText("Car: "+Common.selectedDriver.getCarName());
        txtcarReg.setText("Registration: "+Common.selectedDriver.getCarReg());
        txtstatus.setText("Status: "+Common.selectedDriver.getStatus());

        Picasso.get().load(Common.selectedDriver.getLicense()).into(imageView);


        if (Common.selectedDriver.getStatus().equals("Approved"))
        {
            approve.setVisibility(View.GONE);
        }

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 update();
            }
        });



    }

    private void update() {


        firestore.collection("Drivers").document(Common.selectedDriver.getDriverUID())
                .update("status","Approved")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        approve.setVisibility(View.GONE);
                        Driver driver = new Driver();

                        Common.selectedDriver.setStatus("Approved");

                        txtstatus.setText(Common.selectedDriver.getStatus());
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}