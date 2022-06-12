package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import za.co.msocios.gotrackadmin.Common.Common;

public class BillingChild extends AppCompatActivity {

    TextView fullname,age,address,schoolname;
    Button sendInvoice;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_child);

        String uid = getIntent().getStringExtra("docId");

        fullname = findViewById(R.id.txtFullnames);
        address = findViewById(R.id.txt_address);
        schoolname = findViewById(R.id.txtSchool);
        sendInvoice = findViewById(R.id.btn_Invoice);


        fullname.setText(Common.selectedChild.getFullNames());
        address.setText(Common.selectedChild.getAddress());
        schoolname.setText(Common.selectedChild.getSchoolName());

        firestore.collection("Invoices").document(uid).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists())
                            {

                            }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



    }
}