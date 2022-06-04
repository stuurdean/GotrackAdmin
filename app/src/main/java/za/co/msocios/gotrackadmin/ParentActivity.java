package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ParentActivity extends AppCompatActivity {
    String uid,FullName,phoneNumer,Email;
    FirebaseFirestore firestore;
    TextView fullnamestxt,phonetxt,emailtxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        uid = getIntent().getStringExtra("uid");


        fullnamestxt = findViewById(R.id.textnames);
        phonetxt = findViewById(R.id.txt_call);
        emailtxt =findViewById(R.id.txt_email);
        firestore = FirebaseFirestore.getInstance();


        firestore.collection("Parents").document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists())
                    {
                        FullName = document.get("Names").toString();
                       // phoneNumer = document.get("phonumber").toString();
                       // Email = document.get("email").toString();


                        fullnamestxt.setText(FullName);
                       //phonetxt.setText(phoneNumer);
                       //emailtxt.setText(Email);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {


            }
        });

    }
}