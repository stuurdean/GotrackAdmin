package za.co.msocios.gotrackadmin.ui.parents;



import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.Models.Child;
import za.co.msocios.gotrackadmin.Models.Parent;
import za.co.msocios.gotrackadmin.ParentActivity;
import za.co.msocios.gotrackadmin.R;
import za.co.msocios.gotrackadmin.ViewModels.ChildViewHolder;
import za.co.msocios.gotrackadmin.ViewModels.ParentViewHolder;

public class ParentsFragment extends Fragment {



    RecyclerView recyclerView;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    Query query;

    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions options;

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;





    public static ParentsFragment newInstance() {
        return new ParentsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        query= firestore.collection("Parents");

        options = new FirestoreRecyclerOptions.Builder<Parent>().setQuery(query,Parent.class).build();

        adapter = new FirestoreRecyclerAdapter<Parent, ParentViewHolder>(options) {


            @NonNull
            @Override
            public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new  ParentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.parents,parent,false));
            }

            @Override
            protected void onBindViewHolder(@NonNull ParentViewHolder holder, int position, @NonNull Parent model) {

               holder.parentTxt.setText(model.getNames());

               final String uid= getSnapshots().getSnapshot(position).getId();

                final Parent ClickedItem = model;

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent parentView =new Intent(getActivity(), ParentActivity.class);
                        parentView.putExtra("uid",uid);
                        startActivity(parentView);
                    }
                });


            }

        };


    /*    arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,arrayList);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();



        firestore.collection("Parents").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

            }
        });

       firestore.collection("Parents").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshots: task.getResult())
                    {
                        Parent parent = documentSnapshots.toObject(Parent.class);
                        arrayList.add(parent.getNames());
                        arrayAdapter.notifyDataSetChanged();
                        Log.d("firebase", String.valueOf(task.getResult().size()));
                    }


                }
            }
        });  */




    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.parents_fragment, container, false);

        recyclerView = view.findViewById(R.id.parentRecycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        adapter.startListening();

       return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}