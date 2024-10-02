package br.com.etecia.nutriapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class EstoqueFragment extends Fragment {

    RecyclerView idRecViewEstoque;
    List<Produto> produtoList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estoque, container, false);

        FloatingActionButton fabEstoque;
        fabEstoque = view.findViewById(R.id.floating_action_button);
        fabEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CadastrarProdutoFragment.class);
                startActivity(intent);

            }
        });


        idRecViewEstoque = view.findViewById(R.id.idRecEstoque);

        produtoList = new ArrayList<>();
        produtoList.add(new Produto("Arroz",  50, 20.50));
        produtoList.add(new Produto("Feijão", 30, 40.50));
        produtoList.add(new Produto("Batata", 25, 30.40));

        EstoqueAdapter estoqueAdapter = new EstoqueAdapter(getContext(), produtoList);
        idRecViewEstoque.setLayoutManager(new GridLayoutManager(getContext(), 1));
        idRecViewEstoque.setHasFixedSize(true);

        idRecViewEstoque.setAdapter(estoqueAdapter);

        estoqueAdapter = new EstoqueAdapter(getContext(), produtoList);


        idRecViewEstoque.setLayoutManager(new
                GridLayoutManager(
                getContext(), 1));

        //fixador de tamanho da lista - deixar a lista mais rápida
        idRecViewEstoque.setHasFixedSize(true);

        //ligar o recyclerview ao adaptador
        idRecViewEstoque.setAdapter(estoqueAdapter);





        return view;





    }




}