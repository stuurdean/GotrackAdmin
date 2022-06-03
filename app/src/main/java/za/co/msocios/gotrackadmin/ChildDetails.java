package za.co.msocios.gotrackadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildDetails extends AppCompatActivity {

    Button btnAssign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        btnAssign = findViewById(R.id.btndriver);


        btnAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ChildDetails.this,AssignDriverActivity.class));
            }
        });


    }
}