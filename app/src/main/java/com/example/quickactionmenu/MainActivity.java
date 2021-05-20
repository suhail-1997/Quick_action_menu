
package com.example.quickactionmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.circularreveal.CircularRevealLinearLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView menuRecycler;
    private FloatingActionButton floatingActionButton;
    private MainMenuAdapter mainMenuAdapter;
    private RecyclerView quickmenu;
    private QuickMenuAdapter quickMenuAdapter;
    private List<QuickMenuItem> quickMenuItems;
    private List<CacheMenuRes> cacheMenuRes;
    private CircularRevealLinearLayout circularRevealLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuRecycler = findViewById(R.id.menurecycler);
        floatingActionButton = findViewById(R.id.menuFab);
        quickmenu = findViewById(R.id.quickemenu);
        cacheMenuRes = new ArrayList<>();
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(1,1,1,"Pan cake",100,"veg"));
        menus.add(new Menu(2,1,1,"Wofl",200,"non-veg"));
        menus.add(new Menu(3,1,1,"bread nutella",100,"veg"));
        cacheMenuRes.add(new CacheMenuRes("Breakfast",menus));
        menus.clear();
        menus.add(new Menu(4,1,2,"Fried rice",50,"veg"));
        menus.add(new Menu(5,1,2,"chicken fried rice",80,"non-veg"));
        menus.add(new Menu(6,1,2,"Manchuria",100,"veg"));
        cacheMenuRes.add(new CacheMenuRes("fast food",menus));
        menus.clear();
        menus.add(new Menu(7,1,3,"chocolate Milkshake",50,"veg"));
        menus.add(new Menu(8,1,3,"dry fruit shake",80,"veg"));
        menus.add(new Menu(9,1,3,"banana orea shake",100,"veg"));
        cacheMenuRes.add(new CacheMenuRes("Milkshakes",menus));
        menus.clear();
        menus.add(new Menu(10,1,4,"veg biryani",90,"veg"));
        menus.add(new Menu(11,1,4,"chicken biryani",180,"non-veg"));
        menus.add(new Menu(12,1,4,"jeera rice",60,"veg"));
        cacheMenuRes.add(new CacheMenuRes("Rice",menus));
        menus.clear();
        menus.add(new Menu(13,1,5,"zinger burger",50,"non-veg"));
        menus.add(new Menu(14,1,5,"bbq burger",80,"non-veg"));
        menus.add(new Menu(15,1,5,"egg burger",40,"non-veg"));
        cacheMenuRes.add(new CacheMenuRes("Burgers",menus));

        mainMenuAdapter = new MainMenuAdapter(MainActivity.this,cacheMenuRes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        menuRecycler.setLayoutManager(layoutManager);
        menuRecycler.setItemViewCacheSize(20);
        menuRecycler.setAdapter(mainMenuAdapter);

        circularRevealLinearLayout = findViewById(R.id.subsheet);
        circularRevealLinearLayout.setVisibility(View.GONE);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);

        quickMenuItems = new ArrayList<>();
        for(int i=0;i<cacheMenuRes.size();i++){
            quickMenuItems.add(new QuickMenuItem(i+1,cacheMenuRes.get(i).getSubCategoryName()));
        }

        quickMenuAdapter = new QuickMenuAdapter(quickMenuItems,MainActivity.this);
        quickmenu.setLayoutManager(lm);
        quickmenu.setAdapter(quickMenuAdapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(circularRevealLinearLayout.getVisibility() == View.GONE) {
                    floatingActionButton.setExpanded(true);
                    circularRevealLinearLayout.setVisibility(View.VISIBLE);
                }
                else
                {
                    floatingActionButton.setExpanded(false);
                    circularRevealLinearLayout.setVisibility(View.GONE);
                }
            }
        });
    }
    public void changeFocusOfRecycler(int index)
    {
        menuRecycler.scrollToPosition(index);
    }
    public void hideQuickadapter(){circularRevealLinearLayout.setVisibility(View.GONE);}

}