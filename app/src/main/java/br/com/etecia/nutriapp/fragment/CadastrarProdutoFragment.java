package br.com.etecia.nutriapp.fragment;

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

import java.util.List;

import br.com.etecia.nutriapp.API.ApiMainActivity;
import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Produto;


public class CadastrarProdutoFragment extends Fragment {
    ImageView btnVoltarCadProd;
    Button btnSalvarProd;
    EditText editTextProdId;
    TextInputEditText txtNomeProd, txtQuantProd, txtPrecoProd, txtMultiplicador, txtQuantEstoque, txtDesc, txtDataEntrada, txtValidade;
    List<Produto> produtoList;

    boolean isUpdating = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastrarproduto, container, false);

        btnVoltarCadProd = view.findViewById(R.id.btnVoltarCadProd);
        btnSalvarProd = view.findViewById(R.id.btnSalvarProd);

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
               // isUpdating = true;
                //editTextProdId.setText(String.valueOf(produto.getCodProd()));
                ApiMainActivity cr = new ApiMainActivity();
                String nome = txtNomeProd.getText().toString().trim();
                String quantidade = txtQuantProd.getText().toString().trim();
                String preco = txtPrecoProd.getText().toString().trim();
                String multiplicador = txtMultiplicador.getText().toString().trim();
                String quantEstoque = txtQuantEstoque.getText().toString().trim();
                String desc = txtDesc.getText().toString().trim();
                String dataEntrada = txtDataEntrada.getText().toString().trim();
                String validade = txtValidade.getText().toString().trim();


                if (TextUtils.isEmpty(nome)) {
                    txtNomeProd.setError("Por favor entre com o nome do produto");
                    txtNomeProd.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(quantidade)) {
                    txtQuantProd.setError("Por favor entre com a quantidade ");
                    txtQuantProd.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(preco)) {
                    txtPrecoProd.setError("Por favor entre com o nome preço");
                    txtPrecoProd.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(multiplicador)) {
                    txtMultiplicador.setError("Por favor, entre com o multiplicador");
                    txtMultiplicador.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(quantEstoque)) {
                    txtQuantEstoque.setError("Por favor, entre com a quantidade em estoque");
                    txtQuantEstoque.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(desc)) {
                    txtDesc.setError("Por favor, entre com a descrição");
                    txtDesc.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(dataEntrada)) {
                    txtDataEntrada.setError("Por favor, entre com a data de entrada");
                    txtDataEntrada.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(validade)) {
                    txtValidade.setError("Por favor, entre com a validade");
                    txtValidade.requestFocus();
                    return;
                }
                cr.createHero();



            }
        });

        return view;
    }
}