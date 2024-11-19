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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import br.com.etecia.nutriapp.API.Api;
import br.com.etecia.nutriapp.R;


public class EditarProdutoFragment extends Fragment {
    ImageView btnVoltarEditProd;
    TextInputEditText txtEditNomeProd, txtEditQuantProd, txtEditMultProd, txtEditQuantEstoqueProd, txtEditDescProd, txtEditDataEntProd, txtEditValidProd;
    Button btnEditProd;

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_editarproduto, container, false);

        btnVoltarEditProd = view.findViewById(R.id.btnVoltarEditProduto);
        btnEditProd = view.findViewById(R.id.btnEditarProd);

        txtEditNomeProd = view.findViewById(R.id.txtEditNomeProd);
        txtEditQuantProd = view.findViewById(R.id.txtEditQuantEstoqueProd);
        txtEditMultProd = view.findViewById(R.id.txtEditMultProd);
        txtEditQuantEstoqueProd = view.findViewById(R.id.txtEditQuantEstoqueProd);
        txtEditDescProd = view.findViewById(R.id.txtEditDescProd);
        txtEditDataEntProd = view.findViewById(R.id.txtEditDataEntProd);
        txtEditValidProd = view.findViewById(R.id.txtEditValidProd);

        btnVoltarEditProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack(); // Volta para o fragment anterior
                }
            }
        });
        btnEditProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    updateProdutos();
                    Toast.makeText(getContext(), "Produto editado com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Erro ao editar o produto", Toast.LENGTH_SHORT).show();
                }

            }
        });

        CadastrarProdutoFragment cadastrarProdutoFragment = new CadastrarProdutoFragment();
        cadastrarProdutoFragment.readProdutos();

        return view;
    }

    public void updateProdutos() {
        String nome = txtEditNomeProd.getText().toString().trim();
        String quantidade = txtEditQuantProd.getText().toString().trim();
       // String preco = txtEdit.getText().toString().trim();
        String multiplicador = txtEditMultProd.getText().toString().trim();
        String quantEstoque = txtEditQuantEstoqueProd.getText().toString().trim();
        String validade = txtEditValidProd.getText().toString().trim();
        String dataEntrada = txtEditDataEntProd.getText().toString().trim();
        String desc = txtEditDescProd.getText().toString().trim();

        if (TextUtils.isEmpty(nome)) {
            txtEditNomeProd.setError("Por favor entre com o nome");
            txtEditNomeProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(quantidade)) {
            txtEditQuantProd.setError("Por favor entre com a quantidade");
            txtEditQuantProd.requestFocus();
            return;

        }
        //if (TextUtils.isEmpty(preco)) {
          //  txtPrecoProd.setError("Por favor entre com o preço");
         //   txtPrecoProd.requestFocus();
          //  return;
       // }
        if (TextUtils.isEmpty(multiplicador)) {
            txtEditMultProd.setError("Por favor entre com o multiplicador");
            txtEditMultProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(quantEstoque)) {
            txtEditQuantEstoqueProd.setError("Por favor entre com a quantidade em estoque");
            txtEditQuantEstoqueProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(dataEntrada)) {
            txtEditDataEntProd.setError("Por favor entre com a data de entrada");
            txtEditDataEntProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(validade)) {
            txtEditValidProd.setError("Por favor entre com a validade");
            txtEditValidProd.requestFocus();
            return;
        }
        quantidade = String.valueOf(Double.parseDouble(quantidade));
        //preco = String.valueOf(Double.parseDouble(preco));
        multiplicador = String.valueOf(Double.parseDouble(multiplicador));
        quantEstoque = String.valueOf(Double.parseDouble(quantEstoque));



        HashMap<String, String> params = new HashMap<>();
        //params.put("codProd", id);
        params.put("nomeProd", nome);
        params.put("quant", quantidade);
        params.put("quantEstoque", quantEstoque);
        params.put("mult", multiplicador);
       // params.put("valorProd", preco);
        params.put("dataEntrada", dataEntrada);
        params.put("validade", validade);
        params.put("desc", desc);

        CadastrarProdutoFragment cadastrarProdutoFragment = new CadastrarProdutoFragment();
       CadastrarProdutoFragment.PerformNetworkRequest request = new CadastrarProdutoFragment.PerformNetworkRequest(Api.URL_UPDATE_PRODUTOS, params, CODE_POST_REQUEST);


    }
}