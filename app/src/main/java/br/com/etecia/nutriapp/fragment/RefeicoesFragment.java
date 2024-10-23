package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Produto;

public class RefeicoesFragment extends Fragment {
    String[] items = {"Arroz", "feijão"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    ImageView btnVoltarRefeicoes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refeicoes, container, false);

        autoCompleteTextView = view.findViewById(R.id.idInputPratoPrincipalA);
        btnVoltarRefeicoes = view.findViewById(R.id.btnVoltarRefeicoes);

        // Inicialize o ArrayAdapter com um contexto válido
        adapterItems = new ArrayAdapter<String>(getContext(), R.layout.list_item,items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });

        btnVoltarRefeicoes.setOnClickListener(new View.OnClickListener() {
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
