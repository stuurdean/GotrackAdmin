package za.co.msocios.gotrackadmin.ui.children;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import  com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import za.co.msocios.gotrackadmin.ChildDetails;
import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.Models.Child;
import za.co.msocios.gotrackadmin.R;
import za.co.msocios.gotrackadmin.ViewModels.ChildViewHolder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildrenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildrenFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    Query query;

    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions options;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChildrenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildrenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildrenFragment newInstance(String param1, String param2) {
        ChildrenFragment fragment = new ChildrenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        query= firestore.collection("Children");

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
                        Toast.makeText(getContext(),"Clicked"+model.getFullNames(),Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getActivity(), ChildDetails.class);
                        intent.putExtra("docId",docId);
                        startActivity(intent);
                    }
                });
            }
        };


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_children, container, false);

        recyclerView = view.findViewById(R.id.childview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        adapter.startListening();
        return view;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        adapter.startListening();
    }
}