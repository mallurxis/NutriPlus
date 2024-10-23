package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.etecia.nutriapp.R;


public class AddPratoFragment extends Fragment {
    ImageView  btnVoltarAddPrato;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addprato, container, false);

        btnVoltarAddPrato = view.findViewById(R.id.btnVoltarAddPrato);

      btnVoltarAddPrato.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if (getActivity() != null) {
                  getActivity().getSupportFragmentManager().popBackStack(); // Volta para o fragment anterior
              }
          }
      });

        return view;
    }
}