package br.com.etecia.nutriapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class CardapioFragment extends Fragment {
RecyclerView idRecViewCardapio;
List<Semana> semanaList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cardapio, container, false);

        idRecViewCardapio = view.findViewById(R.id.idRecCardapio);
        semanaList = new ArrayList<>();
        semanaList.add(new Semana("Feijoada", "01/03/2025"));

        CardapioAdapter cardapioAdapter = new CardapioAdapter(getContext(), semanaList);
        idRecViewCardapio.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecViewCardapio.setHasFixedSize(true);

        idRecViewCardapio.setAdapter(cardapioAdapter);

        cardapioAdapter = new CardapioAdapter(getContext(), semanaList);

        idRecViewCardapio.setHasFixedSize(true);
        idRecViewCardapio.setAdapter(cardapioAdapter);
        return view;
    }
}