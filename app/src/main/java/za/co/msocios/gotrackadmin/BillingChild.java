package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Models.Invoice;

public class BillingChild extends AppCompatActivity {

    TextView fullname,address,schoolname,invoiceno,invoicedate,invoiceAmount,invoiceStatus;
    Button sendInvoice;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    CardView invoiceCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing_child);

        String uid = getIntent().getStringExtra("docId");

        fullname = findViewById(R.id.txtFullnames);
        address = findViewById(R.id.txt_address);
        schoolname = findViewById(R.id.txtSchool);
        sendInvoice = findViewById(R.id.btn_Invoice);
        invoiceCard = findViewById(R.id.iinvoice);
        invoiceno =findViewById(R.id.invoiveNo);
        invoicedate = findViewById(R.id.txtdate);
        invoiceAmount = findViewById(R.id.txtAmount);
        invoiceStatus = findViewById(R.id.txtStatus);


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
                                Invoice invoice = new Invoice();

                                invoice = document.toObject(Invoice.class);

                                invoiceCard.setVisibility(View.VISIBLE);
                                invoiceno.setText(uid);
                                invoicedate.setText(invoice.getInvoicedate());
                                invoiceAmount.setText(invoice.getInvoiceAmount());
                                invoiceStatus.setText(invoice.getStatus());

                            }else
                            {
                                sendInvoice.setVisibility(View.VISIBLE);

                            }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        Invoice invoice = new Invoice();
        sendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                invoice.setInvoicedate(getCurrentDateAndTime());
                invoice.setInvoiceAmount("R 700.00");
                invoice.setStatus("Pending Payments");

                firestore.collection("Invoices").document(uid).set(invoice)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(BillingChild.this, "Successfully sended invoice", Toast.LENGTH_SHORT).show();
                                sendInvoice.setVisibility(View.GONE);
                                invoiceCard.setVisibility(View.VISIBLE);

                                invoiceno =findViewById(R.id.invoiveNo);
                                invoiceno.setText(uid);
                                invoicedate.setText(invoice.getInvoicedate());
                                invoiceAmount.setText(invoice.getInvoiceAmount());
                                invoiceStatus.setText(invoice.getStatus());


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(BillingChild.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
    public static String getCurrentDateAndTime(){
        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = simpleDateFormat.format(c);
        return formattedDate;
    }
}