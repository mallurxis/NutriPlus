package br.com.etecia.nutriapp.fragment;

import android.annotation.SuppressLint;
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
    String[] items = {"Feijoada", "Galinhada", "Purê de Batata", "Prato executivo", "Contra-Filé com Fritas", "Strogonoff", "Arroz carreteiro", "Tutu de feijão"};
    AutoCompleteTextView AcPratoPrincipal, AcEntradaFria, AcGuarnicao, AcSobremesa, AcSobremesaDiet, AcOpcao, AcEntradaQuente, AcPure, AcDlax;
    ArrayAdapter<String> adapterItems;
    ImageView btnVoltarRefeicoes;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refeicoes, container, false);

        AcPratoPrincipal = view.findViewById(R.id.idInputPratoPrincipalA);
        AcEntradaFria = view.findViewById(R.id.idInputEntradaFriaA);
        AcGuarnicao = view.findViewById(R.id.idInputGuarnicaoA);
        AcSobremesa = view.findViewById(R.id.idInputSobremesaA);
        AcSobremesaDiet = view.findViewById(R.id.idInputSobremesaDietA);
        AcOpcao = view.findViewById(R.id.idInputOpcaoA);
        AcEntradaQuente = view.findViewById(R.id.idInputEntradaQuenteA);
        AcPure = view.findViewById(R.id.idInputPureA);
        AcDlax = view.findViewById(R.id.idInputDiabeteA);
        btnVoltarRefeicoes = view.findViewById(R.id.btnVoltarRefeicoes);

        // Inicialize o ArrayAdapter com um contexto válido
        adapterItems = new ArrayAdapter<String>(getContext(), R.layout.list_item, items);
        AcPratoPrincipal.setAdapter(adapterItems);
        AcEntradaFria.setAdapter(adapterItems);
        AcGuarnicao.setAdapter(adapterItems);
        AcSobremesa.setAdapter(adapterItems);
        AcSobremesaDiet.setAdapter(adapterItems);
        AcOpcao.setAdapter(adapterItems);
        AcEntradaQuente.setAdapter(adapterItems);
        AcPure.setAdapter(adapterItems);
        AcDlax.setAdapter(adapterItems);

        AcPratoPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcEntradaFria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcGuarnicao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcSobremesa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcSobremesaDiet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcOpcao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcEntradaQuente.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcPure.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), "Item" + item, Toast.LENGTH_SHORT).show();
            }
        });
        AcDlax.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
