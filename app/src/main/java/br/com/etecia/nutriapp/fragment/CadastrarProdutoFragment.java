package br.com.etecia.nutriapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;
import java.util.List;


import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Produto;


public class CadastrarProdutoFragment extends Fragment {
    ImageView btnVoltarCadProd;
    Button btnSalvarProd;
    TextInputEditText txtNomeProd, txtQuantProd, txtPrecoProd, txtMultiplicador, txtQuantEstoque, txtDesc, txtDataEntrada, txtValidade;
    List<Produto> produtoList;

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

    public void createprodutos() {

        String nome = txtNomeProd.getText().toString().trim();
        Double quantidade = Double.valueOf(txtQuantProd.getText().toString().trim());
        Double preco = Double.valueOf(txtPrecoProd.getText().toString().trim());
        Double multiplicador = Double.valueOf(txtMultiplicador.getText().toString().trim());
        Double quantEstoque = Double.valueOf(txtQuantEstoque.getText().toString().trim());
        Date validade = (Date) txtValidade.getText();
        Date dataEntrada = (Date) txtDataEntrada.getText();


        if (TextUtils.isEmpty(nome)) {
            txtNomeProd.setError("Por favor entre com o nome");
            txtNomeProd.requestFocus();
            return;
        }
        if (Double(quantidade)) {
            txtQuantProd.setError("Por favor entre com o nome");
            txtQuantProd.requestFocus();
            return;
        }



    }

    ;
}