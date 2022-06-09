package za.co.msocios.gotrackadmin.ui.drivers;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

import za.co.msocios.gotrackadmin.DriverActivity;
import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.Models.Child;
import za.co.msocios.gotrackadmin.Models.Driver;
import za.co.msocios.gotrackadmin.R;
import za.co.msocios.gotrackadmin.ViewModels.DriverViewHolder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DriversFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DriversFragment extends Fragment {

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

    public DriversFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DriversFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DriversFragment newInstance(String param1, String param2) {
        DriversFragment fragment = new DriversFragment();
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


        query= firestore.collection("Drivers");

        options = new FirestoreRecyclerOptions.Builder<Driver>().setQuery(query,Driver.class).build();

        adapter = new FirestoreRecyclerAdapter<Driver, DriverViewHolder>(options) {
            @NonNull
            @Override
            public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new DriverViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.driver,parent,false));
            }

            @Override
            protected void onBindViewHolder(@NonNull DriverViewHolder holder, int position, @NonNull Driver model) {

                holder.DriverName.setText(model.getNames()+" "+model.getSurname());
                holder.vehicle.setText(model.getCarName());
                holder.vehicleRegNo.setText(model.getCarReg());


                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        startActivity(new Intent(getActivity(), DriverActivity.class));
                    }
                });

            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drivers, container, false);

        recyclerView = view.findViewById(R.id.driverRecyleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        adapter.startListening();


        return  view;
    }
}