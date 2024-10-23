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

import br.com.etecia.nutriapp.classes.Prato;
import br.com.etecia.nutriapp.adapter.PratosAdapter;
import br.com.etecia.nutriapp.R;


public class PratosFragment extends Fragment {

    RecyclerView idRecViewPrato;
    List<Prato> pratoList;
    FloatingActionButton fabPratos;

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

        fabPratos = view.findViewById(R.id.fabPratos);
        fabPratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPratoFragment fragment = new AddPratoFragment();
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.idFragmentPrato, fragment)
                            .addToBackStack(null) // Adiciona à pilha de fragmentos
                            .commit();
                }
            }
        });

        return view;


    }
}