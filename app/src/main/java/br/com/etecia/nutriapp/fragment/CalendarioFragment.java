package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.etecia.nutriapp.R;


public class CalendarioFragment extends Fragment {

    TextView btnSegunda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        btnSegunda = view.findViewById(R.id.txtSegunda);

        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RefeicoesFragment fragment = new RefeicoesFragment();
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.idFragmentCalendario, fragment)
                            .commit();
                }
            }
        });


        return view;
    }
}