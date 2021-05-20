package com.example.quickactionmenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickactionmenu.Menu;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Designed and Developed by Mohammad suhail ahmed on 24/02/2020
 */
public class SubMenuAdapter extends RecyclerView.Adapter<SubMenuAdapter.SubMenuViewHolder> {
    private List<Menu> menus;
    private Context context;
    private String[] mDataset;
    private int[] countervalues;
    private MainActivity menuActivity;
    private Date date;
    private DateFormat dateFormat;
    private int orderid;
    private SharedPreferences sharedPreferences;

    public class SubMenuViewHolder extends  RecyclerView.ViewHolder
    {
        private TextView name;
        private TextView price;
        private ImageView type;
        private Button buttonadd;
        private int itemcount=0;


        public SubMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.menuname);
            price = itemView.findViewById(R.id.price);
            type = itemView.findViewById(R.id.menutype);
            buttonadd = itemView.findViewById(R.id.add);
        }
    }
    public SubMenuAdapter(Context context, List<Menu> menus, String[] mDataset)
    {
        this.context = context;
        this.menus = menus;
        this.mDataset=mDataset;
        this.menuActivity = (MainActivity) context;
        this.date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.orderid = (int) (date.getTime()/1000);
        countervalues=new int[mDataset.length];
    }
    @NonNull
    @Override
    public SubMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_menu_item,parent,false);
        return new SubMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubMenuViewHolder holder, int position) {
        Menu menu = menus.get(position);
        holder.name.setText(menu.getName());
       if(!(countervalues[position]>=1))
        holder.price.setText(String.valueOf(mDataset[position]));
       
        if (menu.getType().equals("veg"))
        {

            holder.type.setImageResource(R.drawable.veg);
        }
        else
        {
            holder.type.setImageResource(R.drawable.non_veg);
        }


    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
