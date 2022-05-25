package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    TextInputEditText email,password;
    Button signIn,forgotPassword,signUp;
    FirebaseAuth auth;
    AwesomeValidation validation;
    ProgressDialog progressDialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        //binding variables
        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        signIn = findViewById(R.id.btnSignIn);
        forgotPassword = findViewById(R.id.btnPassword);



        //progress d

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait");

        builder = new AlertDialog.Builder(this);


        //Firebase hooks
        auth = FirebaseAuth.getInstance();

        //validation

        validation = new AwesomeValidation(ValidationStyle.BASIC);
        validation.addValidation(this,R.id.inputEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        validation.addValidation(this,R.id.inputPassword, RegexTemplate.NOT_EMPTY,R.string.invalid_passord);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // checking inputs errors
                if (validation.validate())
                {
                    // calling login method

                    logging();
                }
            }
        });


    }
    private void logging() {

        // get edittext value and converting them to string
        progressDialog.show();
        String inputEmail =email.getText().toString();
        String inputPassword = password.getText().toString();

        auth.signInWithEmailAndPassword(inputEmail,inputPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                progressDialog.dismiss();

                // startActivity(new Intent(ParentSignIn.this,ParentDashboard.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                // Use the Builder class for convenient dialog construction
                // AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR").setIcon(R.drawable.ic_baseline_error_24)
                        .setMessage(e.getMessage())
                        .setCancelable(false)

                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                                dialog.cancel();
                            }
                        }).show();
                // Create the AlertDialog object and return it
                //builder.create();

                //  builder.show();

            }
        });

    }
}