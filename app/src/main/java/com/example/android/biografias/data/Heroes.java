package com.example.android.biografias.data;

/**
 * Created by Paviliondm4 on 6/2/2017.
 */

public class Heroes {

    private String mNombre ;
    private String mFechaNacimiento;
    private String mFechaFallecimiento;
    private String mDescripcion;
    private int mImageUrl;

    public Heroes(String mFechaNacimiento) {
        this.mFechaNacimiento = mFechaNacimiento;
    }

    public Heroes(String nombre,String fechaNacimiento , String fechaFallecimiento, int imageUrl){
        mNombre = nombre;
        mFechaNacimiento = fechaNacimiento ;
        mFechaFallecimiento = fechaFallecimiento ;
        mImageUrl = imageUrl ;

    }

    public Heroes (String nombre, String fechaNacimiento , String fechaFallecimiento,
                   String descripcion, int imageUrl){

        mNombre = nombre;
        mFechaNacimiento = fechaNacimiento ;
        mFechaFallecimiento = fechaFallecimiento ;
        mDescripcion = descripcion ;
        mImageUrl = imageUrl ;

    }

    public String getFechaNacimiento() {
        return mFechaNacimiento;
    }

    public String getNombre() {
        return mNombre;
    }

    public String getFechaFallecimiento() {
        return mFechaFallecimiento;
    }

    public String getDescripcion() {
        return mDescripcion;
    }

    public int getImageUrl() {
        return mImageUrl;
    }
}
