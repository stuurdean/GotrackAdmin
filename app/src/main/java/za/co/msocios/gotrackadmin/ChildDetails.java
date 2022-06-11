package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Models.Child;

public class ChildDetails extends AppCompatActivity {

    Button btnAssign,btnCall;
    TextView fullname,age,address,parentname,parentPhone,schoolname,schoolAdress,grade,startTime,outTime,drivername;
    String docId ;
    ImageView image;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        docId = getIntent().getStringExtra("docId");

        btnAssign = findViewById(R.id.btndriver);
        fullname = findViewById(R.id.txtFullnames);
        age = findViewById(R.id.age);
        address = findViewById(R.id.txt_address);
        parentname = findViewById(R.id.txt_parent);
        parentPhone = findViewById(R.id.txt_parentPhone);
        schoolname = findViewById(R.id.txtSchoolName);
        schoolAdress = findViewById(R.id.txt_schooladdress);
        grade = findViewById(R.id.txt_grade);
        startTime = findViewById(R.id.txt_In);
        outTime = findViewById(R.id.txt_out);
        drivername = findViewById(R.id.txt_driverName);

        btnCall = findViewById(R.id.btn_call);

        image = findViewById(R.id.childImageView);


        fullname.setText(Common.selectedChild.getFullNames());
        age.setText(Common.selectedChild.getDateOfBirth());
        address.setText(Common.selectedChild.getAddress());
        // parentname.setText(Common.selectedChild.);
        // parentPhone = findViewById(R.id.txt_parentPhone);
        schoolname.setText(Common.selectedChild.getSchoolName());
        schoolAdress.setText(Common.selectedChild.getAddress());
        grade.setText(Common.selectedChild.getGrade());
        startTime.setText(Common.selectedChild.getInTime());
        outTime.setText(Common.selectedChild.getOutTime());


        Picasso.get().load(Common.selectedChild.getImage()).into(image);




        drivername.setText(Common.selectedChild.getDriver());



        firestore.collection("Parents").document(Common.selectedChild.getParent()).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();

                        if (document.exists())
                        {
                            parentname.setText(document.get("names").toString());
                            parentPhone.setText(document.get("phoneNumber").toString());
                        }
                    }
                });





        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }
}