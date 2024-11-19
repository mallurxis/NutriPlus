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

import br.com.etecia.nutriapp.adapter.EstoqueAdapter;
import br.com.etecia.nutriapp.classes.Produto;
import br.com.etecia.nutriapp.R;


public class EstoqueFragment extends Fragment {

    RecyclerView idRecViewEstoque;
    List<Produto> produtoList;
    FloatingActionButton fabEstoque;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estoque, container, false);

        idRecViewEstoque = view.findViewById(R.id.idRecEstoque);
        produtoList = new ArrayList<>();
        produtoList.add(new Produto("Arroz", 20.00, 20.00));
        produtoList.add(new Produto("Feijão", 50.00, 20.00));
        produtoList.add(new Produto("Contra-Filé", 40.00, 1));
        produtoList.add(new Produto("Batata", 50.00, 30.00));
        produtoList.add(new Produto("Frango", 40.00, 30.00));
        produtoList.add(new Produto("Sal", 15.00, 5));

        EstoqueAdapter estoqueAdapter = new EstoqueAdapter(getContext(), produtoList);
        idRecViewEstoque.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecViewEstoque.setHasFixedSize(true);

        idRecViewEstoque.setAdapter(estoqueAdapter);


        fabEstoque = view.findViewById(R.id.fabEstoque);
        fabEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastrarProdutoFragment fragment = new CadastrarProdutoFragment();
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.idFragmentEstoque, fragment)
                            .addToBackStack(null) // Adiciona à pilha de fragmentos
                            .commit();
                }
            }
        });

        return view;
    }



}