package com.example.android.biografias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.android.biografias.data.Heroes;
import com.example.android.biografias.data.HeroesAdapter;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setTitle("Bibliografías");
        myToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);


        // 1. Crear fuente de información
        Heroes[] heroesArray = {
            new Heroes("Jose Maria Morelos", "1778", "1815", R.drawable.head) ,
                new Heroes("Miguel Hidalgo", "1778", "1815", R.drawable.head),
                new Heroes("Francisco Villa", "1892", "1919", R.drawable.head)

        };

        // 2. Crear adaptador y pasarle la fuente de información
        HeroesAdapter heroAdapter = new HeroesAdapter(this, Arrays.asList(heroesArray)) ;


        // 3. Encontrar listView con su id y asignar adaptador al listView
                ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(heroAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out: {
                // do your sign-out stuff
                break;
            }
            // case blocks for other MenuItems (if any)
        }
        return false;
    }

}
