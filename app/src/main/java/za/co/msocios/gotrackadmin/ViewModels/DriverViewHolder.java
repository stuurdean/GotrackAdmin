package za.co.msocios.gotrackadmin.ViewModels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.R;

public class DriverViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView DriverName;
    public TextView vehicle;
    public TextView vehicleRegNo;
    public ImageView DriverImage;

    private ItemClickListener itemClickListener;

    public DriverViewHolder(@NonNull View itemView) {
        super(itemView);

        DriverName = itemView.findViewById(R.id.txtDriver);
        vehicle = itemView.findViewById(R.id.txtVehicle);
        vehicleRegNo = itemView.findViewById(R.id.txtRegNo);

        DriverImage =itemView.findViewById(R.id.driverimg);

        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

    }
}
