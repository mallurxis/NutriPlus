package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.etecia.nutriapp.R;


public class CalendarioFragment extends Fragment {
    TextView txtSegunda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        txtSegunda = view.findViewById(R.id.txtSegunda);
        // Configura o clique para o txtSegunda aqui
        txtSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Manipule o clique do txtSegunda aqui
                FragmentManager fragmentManager = getParentFragmentManager();
                RefeicoesFragment fragment = new RefeicoesFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.idFragmentCalendario, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}