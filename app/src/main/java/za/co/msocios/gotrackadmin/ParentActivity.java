package za.co.msocios.gotrackadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.Models.Child;
import za.co.msocios.gotrackadmin.ViewModels.ChildViewHolder;

public class ParentActivity extends AppCompatActivity {
    String uid,FullName,phoneNumer,Email;
    FirebaseFirestore firestore;
    TextView fullnamestxt,phonetxt,emailtxt;
    RecyclerView recyclerView;
    Query query;

    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions options;


    @Override
    protected void onStart() {
        super.onStart();

        adapter.startListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        uid = getIntent().getStringExtra("uid");


        fullnamestxt = findViewById(R.id.textnames);
        phonetxt = findViewById(R.id.txt_call);
        emailtxt =findViewById(R.id.txt_email);
        firestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.childrecycle);




        query= firestore.collection("Children").whereEqualTo("parent",uid);

        options = new FirestoreRecyclerOptions.Builder<Child>().setQuery(query,Child.class).build();

        adapter = new FirestoreRecyclerAdapter<Child, ChildViewHolder>(options) {
            @NonNull
            @Override
            public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ChildViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false));
            }

            @Override
            protected void onBindViewHolder(@NonNull ChildViewHolder holder, int position, @NonNull Child model) {

                holder.childName.setText(model.getFullNames());
                holder.schoolName.setText(model.getSchoolName());
                holder.childState.setText(model.getState());

                Picasso.get().load(model.getImage()).into(holder.childPic);
                final  String docId = getSnapshots().getSnapshot(position).getId();


                final Child ClickItem = model;
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Common.selectedChild = model;
                        Toast.makeText(getApplicationContext(),"Clicked"+model.getFullNames(),Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(ParentActivity.this, ChildDetails.class);
                        intent.putExtra("docId",docId);
                        startActivity(intent);
                    }
                });
            }
        };






        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.startListening();



        fullnamestxt.setText(Common.selectedParent.getNames());
        phonetxt.setText(Common.selectedParent.getPhoneNumber());
        emailtxt.setText(Common.selectedParent.getEmail());





    }
}