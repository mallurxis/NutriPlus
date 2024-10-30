package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.etecia.nutriapp.adapter.HistoricoAdapter;
import br.com.etecia.nutriapp.classes.HistoricoPrato;
import br.com.etecia.nutriapp.R;


public class HistoricoFragment extends Fragment {
    RecyclerView idRecHistorico;
    List<HistoricoPrato> historicoList;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_historico, container, false);
        idRecHistorico = view.findViewById(R.id.idRecHistorico);

        historicoList = new ArrayList<>();
        historicoList.add(new HistoricoPrato("Feijoada", "Feijão", 20.50));
        historicoList.add(new HistoricoPrato("Galinhada", "Frango", 20.50));
        historicoList.add(new HistoricoPrato("Purê de batata", "Batata", 20.50));
        historicoList.add(new HistoricoPrato("Arroz Carreteiro", "Arroz", 20.50));
        historicoList.add(new HistoricoPrato("Contra-Filé com fritas", "Contra-Filé", 20.50));


        HistoricoAdapter historicoAdapter = new HistoricoAdapter(getContext(), historicoList);
        idRecHistorico.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecHistorico.setHasFixedSize(true);

        idRecHistorico.setAdapter(historicoAdapter);

        return view;
    }
}