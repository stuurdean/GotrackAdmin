package za.co.msocios.gotrackadmin.ui.billing;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import za.co.msocios.gotrackadmin.BillingChild;
import za.co.msocios.gotrackadmin.ChildDetails;
import za.co.msocios.gotrackadmin.Common.Common;
import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.Models.Child;
import za.co.msocios.gotrackadmin.R;
import za.co.msocios.gotrackadmin.ViewModels.BillViewHolder;
import za.co.msocios.gotrackadmin.ViewModels.ChildViewHolder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BillingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BillingFragment extends Fragment {



    RecyclerView recyclerView;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    Query query;

    FirestoreRecyclerAdapter adapter;
    FirestoreRecyclerOptions options;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BillingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BillingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BillingFragment newInstance(String param1, String param2) {
        BillingFragment fragment = new BillingFragment();
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

        adapter = new FirestoreRecyclerAdapter<Child, BillViewHolder>(options) {
            @NonNull
            @Override
            public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new BillViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false));
            }

            @Override
            protected void onBindViewHolder(@NonNull BillViewHolder holder, int position, @NonNull Child model) {

                holder.childName.setText(model.getFullNames());

                Picasso.get().load(model.getImage()).into(holder.childPic);
                final  String docId = getSnapshots().getSnapshot(position).getId();

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Common.selectedChild = model;

                        Intent intent = new Intent(getActivity(), BillingChild.class);
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
        return inflater.inflate(R.layout.fragment_billing, container, false);
    }
}