package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.etecia.nutriapp.adapter.CardapioAdapter;
import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Semana;


public class CardapioFragment extends Fragment {
    RecyclerView idRecViewCardapio;
    List<Semana> semanaList;
    FloatingActionButton fabCardapio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        idRecViewCardapio = view.findViewById(R.id.idRecCardapio);
        semanaList = new ArrayList<>();
        semanaList.add(new Semana("Semana 1", "01/03/2025"));
        semanaList.add(new Semana("Semana 2", "08/03/2025"));
        semanaList.add(new Semana("Semana 3", "16/03/2025"));
        semanaList.add(new Semana("Semana 4", "24/03/2025"));
        semanaList.add(new Semana("Semana 5", "01/04/2025"));
        semanaList.add(new Semana("Semana 6", "08/04/2025"));
        semanaList.add(new Semana("Semana 7", "16/04/2025"));

        CardapioAdapter cardapioAdapter = new CardapioAdapter(getContext(), semanaList);
        idRecViewCardapio.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecViewCardapio.setHasFixedSize(true);
        idRecViewCardapio.setAdapter(cardapioAdapter);

        fabCardapio = view.findViewById(R.id.fabCardapio);
        fabCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CadastrarSemanaFragment fragment = new CadastrarSemanaFragment();
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.idFragmentCardapio, fragment)
                            .addToBackStack(null) // Adiciona à pilha de fragmentos
                            .commit();
                }
            }
        });


        return view;
    }

}