package za.co.msocios.gotrackadmin.ViewModels;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.msocios.gotrackadmin.Interface.ItemClickListener;

public class ParentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    private ItemClickListener itemClickListener;

    public TextView parentTxt;

    public ParentViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
