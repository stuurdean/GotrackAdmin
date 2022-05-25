package za.co.msocios.gotrackadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.textfield.TextInputEditText;
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
        signUp = findViewById(R.id.btnSignUp);


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
}