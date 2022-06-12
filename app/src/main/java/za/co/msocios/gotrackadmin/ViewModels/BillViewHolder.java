package za.co.msocios.gotrackadmin.ViewModels;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.msocios.gotrackadmin.Interface.ItemClickListener;
import za.co.msocios.gotrackadmin.R;

public class BillViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

    public TextView childName;

    private ItemClickListener itemClickListener;
    public ImageView childPic;

    public BillViewHolder(@NonNull View itemView) {
        super(itemView);

        childName = itemView.findViewById(R.id.txtNames);

        childPic = itemView.findViewById(R.id.childImage);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
