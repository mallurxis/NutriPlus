package br.com.etecia.nutriapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;


import br.com.etecia.nutriapp.API.Api;
import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Produto;


public class CadastrarProdutoFragment extends Fragment {
    ImageView btnVoltarCadProd;
    Button btnSalvarProd;
    TextInputEditText txtNomeProd, txtQuantProd, txtPrecoProd, txtMultiplicador, txtQuantEstoque, txtDesc, txtDataEntrada, txtValidade;
    List<Produto> produtoList;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    boolean isUpdating = false;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastrarproduto, container, false);

        btnVoltarCadProd = view.findViewById(R.id.btnVoltarCadProd);
        btnSalvarProd = view.findViewById(R.id.btnSalvarProd);
        txtNomeProd = view.findViewById(R.id.txtInputProd);
        txtMultiplicador = view.findViewById(R.id.txtInputMult);
        txtQuantProd = view.findViewById(R.id.txtInputQuant);
        txtPrecoProd = view.findViewById(R.id.txtInputPreco);
        txtQuantEstoque = view.findViewById(R.id.txtInputQuantEstoque);
        txtDataEntrada = view.findViewById(R.id.txtInputDataEntrada);
        txtValidade = view.findViewById(R.id.txtInputValidade);
        txtDesc = view.findViewById(R.id.txtInputDesc);


        //final Produto produto = produtoList.get();

        btnVoltarCadProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack(); // Volta para o fragment anterior
                }
            }
        });

        btnSalvarProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createprodutos();

            }
        });

        return view;
    }

    public void createprodutos() throws ParseException {

        String nome = txtNomeProd.getText().toString().trim();
        String quantidade = txtQuantProd.getText().toString().trim();
        String preco = txtPrecoProd.getText().toString().trim();
        String multiplicador = txtMultiplicador.getText().toString().trim();
        String quantEstoque = txtQuantEstoque.getText().toString().trim();
        String validade = txtValidade.getText().toString().trim();
        String dataEntrada = txtDataEntrada.getText().toString().trim();
        String desc = txtDesc.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            txtNomeProd.setError("Por favor entre com o nome");
            txtNomeProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(quantidade)) {
            txtQuantProd.setError("Por favor entre com a quantidade");
            txtQuantProd.requestFocus();
            return;

        }
        if (TextUtils.isEmpty(preco)) {
            txtPrecoProd.setError("Por favor entre com o preço");
            txtPrecoProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(multiplicador)) {
            txtMultiplicador.setError("Por favor entre com o multiplicador");
            txtMultiplicador.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(quantEstoque)) {
            txtQuantEstoque.setError("Por favor entre com a quantidade em estoque");
            txtQuantEstoque.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(dataEntrada)) {
            txtDataEntrada.setError("Por favor entre com a data de entrada");
            txtDataEntrada.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(validade)) {
            txtValidade.setError("Por favor entre com a validade");
            txtValidade.requestFocus();
            return;
        }
        quantidade = String.valueOf(Double.parseDouble(quantidade));
        preco = String.valueOf(Double.parseDouble(preco));
        multiplicador = String.valueOf(Double.parseDouble(multiplicador));
        quantEstoque = String.valueOf(Double.parseDouble(quantEstoque));
        dataEntrada = String.valueOf(formato.parse(dataEntrada));
        validade = String.valueOf(formato.parse(validade));

        HashMap<String, String> params = new HashMap<>();
        //params.put("id", id);
        params.put("nome", nome);
        params.put("quantidade", quantidade);
        params.put("preco", preco);
        params.put("multiplicador", multiplicador);
        params.put("quantEstoque", quantEstoque);
        params.put("dataEntrada", dataEntrada);
        params.put("validade", validade);
        params.put("desc", desc);



    };
}