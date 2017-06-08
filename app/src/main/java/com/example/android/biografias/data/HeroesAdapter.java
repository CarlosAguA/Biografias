package com.example.android.biografias.data;

/*
 * Created by Paviliondm4 on 6/2/2017.
 */

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.biografias.R;

import java.util.List;

public class HeroesAdapter extends ArrayAdapter<Heroes> {

    private Context context ;
    private Heroes currentHeroe ;

    public HeroesAdapter(Context context , List<Heroes> heroe){
        super(context,0 ,heroe);
        this.context = context ;

    }
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        currentHeroe = getItem(position);

        // Find the TextView with view IDs tv_nombre, tv_fechas, im_view_cara
        TextView nombreTextView = (TextView) listItemView.findViewById(R.id.tv_nombre) ;
        nombreTextView.setText(currentHeroe.getNombre()) ;

        TextView fechasTextView = (TextView) listItemView.findViewById(R.id.tv_fechas) ;
        // * Implementar logica para pintar bien las fechas en el formato del textView.
        String nacimiento = currentHeroe.getFechaNacimiento() ;
        String defuncion = currentHeroe.getFechaFallecimiento();
        fechasTextView.setText(nacimiento + " - " + defuncion) ;

        ImageView caraImageView = (ImageView) listItemView.findViewById(R.id.im_view_cara);
        //Logica para chechar si poner un Place Holder o poner una imagen adecuada al personaje
        caraImageView.setImageResource(currentHeroe.getImageUrl());

        return listItemView ;
    }
}
