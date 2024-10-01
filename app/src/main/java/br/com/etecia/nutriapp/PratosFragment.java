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


public class PratosFragment extends Fragment {

    RecyclerView idRecViewPrato;
    List<Prato> pratoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pratos, container, false);

        idRecViewPrato = view.findViewById(R.id.idRecPratos);

        pratoList = new ArrayList<>();
        pratoList.add(new Prato("Feijoada", 20.00));

        PratosAdapter pratosAdapter = new PratosAdapter(getContext(), pratoList);
        idRecViewPrato.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecViewPrato.setHasFixedSize(true);

        idRecViewPrato.setAdapter(pratosAdapter);

        pratosAdapter = new PratosAdapter(getContext(), pratoList);

        idRecViewPrato.setHasFixedSize(true);

        idRecViewPrato.setAdapter(pratosAdapter);
        return view;

    }
}