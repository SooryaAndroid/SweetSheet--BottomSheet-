package com.android.bottomsheet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.DimEffect;
import com.mingle.sweetpick.RecyclerViewDelegate;
import com.mingle.sweetpick.SweetSheet;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button list,grid;

    RelativeLayout relativeLayout;

    SweetSheet msweetSheet,msweetSheet2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (Button)findViewById(R.id.list);
        grid = (Button)findViewById(R.id.grid);

        relativeLayout = (RelativeLayout)findViewById(R.id.relative);



        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listitems();
                Toast.makeText(MainActivity.this, "bottomsheet", Toast.LENGTH_SHORT).show();

            }
        });

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gridlist();

            }
        });

    }

    private void listitems(){
        final ArrayList<MenuEntity>list = new ArrayList<MenuEntity>();
        final MenuEntity menuEntity1 = new MenuEntity();
        final MenuEntity menuEntity2 = new MenuEntity();
        final MenuEntity menuEntity3 = new MenuEntity();

        menuEntity1.iconId = R.drawable.android;
        // menuEntity1.titleColor = 0xff000000;
        menuEntity1.title = "android";

        menuEntity2.title = "ios";
        menuEntity2.iconId = R.drawable.apple;

        menuEntity3.title = "windows";
        menuEntity3.iconId = R.drawable.windows;

        list.add(menuEntity1);
        list.add(menuEntity2);
        list.add(menuEntity3);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);
        list.add(menuEntity1);

        msweetSheet = new SweetSheet(relativeLayout);
        msweetSheet.setMenuList(list);

        msweetSheet.setDelegate(new RecyclerViewDelegate(true));

        msweetSheet.setBackgroundEffect(new DimEffect(0.5f));
        msweetSheet.toggle();



        msweetSheet.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
            @Override
            public boolean onItemClick(int position, MenuEntity menuEntity) {

                Toast.makeText(MainActivity.this, menuEntity.title +""+ position, Toast.LENGTH_SHORT).show();

                if(position==0){
                        startActivity(new Intent(MainActivity.this,AnotherActivity.class));
                }
                return false;
            }
        });
    }



//-------------code for sweet sheet or bottom sheet--------------------

private void gridlist(){
    msweetSheet2 = new SweetSheet(relativeLayout);
    msweetSheet2.setMenuList(R.menu.menu_main);

    msweetSheet2.setDelegate(new RecyclerViewDelegate(true));

    msweetSheet2.setBackgroundEffect(new DimEffect(0.5f));
    msweetSheet2.toggle();

    msweetSheet2.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
        @Override
        public boolean onItemClick(int position, MenuEntity menuEntity) {

            Toast.makeText(MainActivity.this, menuEntity.title +""+ position, Toast.LENGTH_SHORT).show();

            return false;
        }
    });

}
}
