package za.co.msocios.gotrackadmin.ui.drivers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import za.co.msocios.gotrackadmin.R;
import za.co.msocios.gotrackadmin.databinding.DriversFragmentBinding;
import za.co.msocios.gotrackadmin.databinding.FragmentGalleryBinding;
import za.co.msocios.gotrackadmin.ui.gallery.GalleryViewModel;

public class Drivers extends Fragment {

    private DriversFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DriversViewModel driverViewModel =
                new ViewModelProvider(this).get(DriversViewModel.class);

        binding = DriversFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDriver;
        driverViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}