package za.co.msocios.gotrackadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Models.Child;

public class ChildDetails extends AppCompatActivity {

    Button btnAssign;
    TextView fullname,age,address,parentname,parentPhone,schoolname,schoolAdress,grade,startTime,outTime,drivername;
    String docId ;

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
        schoolAdress = findViewById(R.id.txt_address);
        grade = findViewById(R.id.txt_grade);
        startTime = findViewById(R.id.txt_In);
        outTime = findViewById(R.id.txt_out);
        drivername = findViewById(R.id.txt_driverName);


        fullname.setText(Common.selectedChild.getFullNames());
        age.setText(Common.selectedChild.getDateOfBirth());
        address.setText(Common.selectedChild.getAddress());
       // parentname.setText(Common.selectedChild.);
       // parentPhone = findViewById(R.id.txt_parentPhone);
        schoolname.setText(Common.selectedChild.getSchoolName());
        schoolAdress.setText(Common.selectedChild.getSchoolAddress());
        grade.setText(Common.selectedChild.getGrade());
        startTime.setText(Common.selectedChild.getInTime());
        outTime.setText(Common.selectedChild.getOutTime());
        drivername.setText(Common.selectedChild.getDriver());


        btnAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ChildDetails.this,AssignDriverActivity.class));
            }
        });


    }
}