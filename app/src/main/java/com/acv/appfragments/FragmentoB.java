package com.acv.appfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoB extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_b,container,false);
        return view;

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView tv = getActivity().findViewById(R.id.Mensaje);
        String msgtv = tv.getText().toString();
        outState.putString("MENSAJETV",msgtv);
    }


    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState!=null){
            String msj = savedInstanceState.getString("MENSAJETV");
            TextView tvB = getActivity().findViewById(R.id.Mensaje);
            tvB.setText(msj);
        }
    }

    public void recibir(String dato){
        TextView tv = getActivity().findViewById(R.id.Mensaje);
        tv.setText(dato);
    }

}
