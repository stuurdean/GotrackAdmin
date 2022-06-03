package za.co.msocios.gotrackadmin.ViewModels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.msocios.gotrackadmin.Interface.ItemClickListener;

public class DriverViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView DriverName;
    public TextView vehicle;
    public TextView vehicleRegNo;
    public ImageView childPic;

    private ItemClickListener itemClickListener;

    public DriverViewHolder(@NonNull View itemView) {
        super(itemView);


        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

    }
}
