package com.example.quickactionmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Designed and Developed by Mohammad suhail ahmed on 05/03/2020
 */
public class QuickMenuAdapter extends RecyclerView.Adapter<QuickMenuAdapter.QuickMenuViewHolder> {

    private List<QuickMenuItem> quickMenuItems;
    private Context context;
    private MainActivity menuActivity;


    public QuickMenuAdapter(List<QuickMenuItem> quickMenuItems,Context context)
    {
        this.quickMenuItems = quickMenuItems;
        this.context = context;
        menuActivity = (MainActivity) context;
    }

    public class QuickMenuViewHolder extends RecyclerView.ViewHolder
    {
        private TextView catname;
        private LinearLayout linearLayout;

        public QuickMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            catname = itemView.findViewById(R.id.quickemenuname);
            linearLayout = itemView.findViewById(R.id.quickmenulay);
        }
    }
    @NonNull
    @Override
    public QuickMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_menu_item,parent,false);
        return new QuickMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuickMenuViewHolder holder, int position) {
        QuickMenuItem quickMenuItem = quickMenuItems.get(position);
        holder.catname.setText(quickMenuItem.getCategoryname());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuActivity.changeFocusOfRecycler(quickMenuItem.getCategotyid());
                menuActivity.hideQuickadapter();
            }
        });

    }

    @Override
    public int getItemCount() {
        return quickMenuItems.size();
    }
    public void setQuickMenuItems(List<QuickMenuItem> quickMenuItems)
    {
        this.quickMenuItems =quickMenuItems;
        notifyDataSetChanged();
    }
}
