package com.acv.appfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoA extends Fragment {

    private EnviarMensaje mensaje;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_a,container,false);

        view.findViewById(R.id.Enviar).setOnClickListener(v -> {
            TextView tv = view.findViewById(R.id.Texto);
            String msg = tv.getText().toString();
            mensaje.enviarDato(msg);
        });
        return view;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText tv = getActivity().findViewById(R.id.Texto);
        String texto = tv.getText().toString();
        outState.putString("MENSAJE",texto);
    }


    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState!=null){
            String mensaje = savedInstanceState.getString("MENSAJE");
            EditText tv = getActivity().findViewById(R.id.Texto);
            tv.setText(tv.getText());
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mensaje = (EnviarMensaje) context;
    }
}
