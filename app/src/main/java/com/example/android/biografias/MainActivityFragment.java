package com.example.android.biografias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.biografias.data.Heroes;
import com.example.android.biografias.data.HeroesAdapter;

import java.util.Arrays;


public class MainActivityFragment extends Fragment {

    private HeroesAdapter heroeAdapter ;

    // 1. Crear fuente de información
    Heroes[] heroesArray = {
            new Heroes("Jose Maria Morelos", "1778", "1815", R.drawable.head) ,
            new Heroes("Miguel Hidalgo", "1778", "1815", R.drawable.head),
            new Heroes("Francisco Villa", "1892", "1919", R.drawable.head)

    };

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        heroeAdapter = new HeroesAdapter(getActivity(), Arrays.asList(heroesArray)) ;

        // 3. Encontrar listView con su id y asignar adaptador al listView
        ListView lv = (ListView) rootView.findViewById(R.id.list);
        lv.setAdapter(heroeAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Heroes heroeSeleccionado =  heroeAdapter.getItem(position);

                String name = heroeSeleccionado.getNombre();

                Toast.makeText(getActivity(),name ,
                        Toast.LENGTH_SHORT).show();

                showDescripcion(position);

            }
        });

        return rootView ;
    }

    private void showDescripcion(int position) {

        // Create an intent for starting the DetailsActivity
        Intent intent = new Intent();

        // explicitly set the activity context and class
        // associated with the intent (context, class)
        intent.setClass(getActivity(), DetailsActivity.class);

        startActivity(intent);

    }


}
