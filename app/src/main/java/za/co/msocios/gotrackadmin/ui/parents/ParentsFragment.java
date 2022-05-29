package za.co.msocios.gotrackadmin.ui.parents;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import za.co.msocios.gotrackadmin.R;

public class ParentsFragment extends Fragment {

    private ParentsViewModel mViewModel;

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;





    public static ParentsFragment newInstance() {
        return new ParentsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,arrayList);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        firestore.collection("Parents").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshots: task.getResult())
                    {
                        arrayList.add(documentSnapshots.getId());
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            }
        });


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.parents_fragment, container, false);

       listView = view.findViewById(R.id.parentsList);

       listView.setAdapter(arrayAdapter);

       return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ParentsViewModel.class);
        // TODO: Use the ViewModel
    }

}