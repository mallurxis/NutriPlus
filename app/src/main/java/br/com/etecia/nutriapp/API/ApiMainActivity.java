package br.com.etecia.nutriapp.API;

import static android.view.View.GONE;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.adapter.EstoqueAdapter;
import br.com.etecia.nutriapp.classes.Produto;

public class ApiMainActivity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    TextInputLayout txtNomeProd, txtQuantProd, txtPrecoProd, txtMultiplicador, txtQuantEstoque, txtDesc, txtDataEntrada, txtValidade;
    EditText editTextProdId;
    Button btnSalvarProd;
    List<Produto> produtoList;

    boolean isUpdating = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_main);

        editTextProdId = findViewById(R.id.editTextProdutoId);
        txtNomeProd = findViewById(R.id.textProduto);
        txtQuantProd = findViewById(R.id.textPeso);
        txtPrecoProd = findViewById(R.id.textMult);
        txtMultiplicador = findViewById(R.id.textMult);
        txtQuantEstoque = findViewById(R.id.textQuantEstoque);
        txtDesc = findViewById(R.id.textDesc);
        txtDataEntrada = findViewById(R.id.textDataEnt);
        txtValidade = findViewById(R.id.textValidade);

        btnSalvarProd = findViewById(R.id.btnSalvarProd);



        btnSalvarProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isUpdating) {
                    updateHero();
                } else {
                    createHero();
                }
            }
    });
        readHeroes();
    }
    private void createHero() {
        String nome = txtNomeProd.getEditText().getText().toString().trim();
        String quantidade = txtQuantProd.getEditText().getText().toString().trim();
        String preco = txtPrecoProd.getEditText().getText().toString().trim();
        String multiplicador = txtMultiplicador.getEditText().getText().toString().trim();
        String quantEstoque = txtQuantEstoque.getEditText().getText().toString().trim();
        String desc = txtDesc.getEditText().getText().toString().trim();
        String dataEntrada = txtDataEntrada.getEditText().getText().toString().trim();
        String validade = txtValidade.getEditText().getText().toString().trim();


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


        //Conexão entre o Android e o PHP através do Hash.
        HashMap<String, String> params = new HashMap<>();
        params.put("nome", nome);
        params.put("quantidade", quantidade);
        params.put("preco", preco);
        params.put("multiplicador", multiplicador);
        params.put("quantEstoque", quantEstoque);
        params.put("desc", desc);
        params.put("dataEntrada", dataEntrada);
        params.put("validade", validade);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_HERO, params, CODE_POST_REQUEST);
        request.execute();
    }

    private void readHeroes() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_READ_HEROES, null, CODE_GET_REQUEST);
        request.execute();
    }

    private void updateHero() {
        String id = editTextProdId.getText().toString();
        String nome = txtNomeProd.getEditText().getText().toString().trim();
        String quantidade = txtQuantProd.getEditText().getText().toString().trim();
        String preco = txtPrecoProd.getEditText().getText().toString().trim();
        String multiplicador = txtMultiplicador.getEditText().getText().toString().trim();
        String quantEstoque = txtQuantEstoque.getEditText().getText().toString().trim();
        String desc = txtDesc.getEditText().getText().toString().trim();
        String dataEntrada = txtDataEntrada.getEditText().getText().toString().trim();
        String validade = txtValidade.getEditText().getText().toString().trim();

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

        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("nome", nome);
        params.put("quantidade", quantidade);
        params.put("preco", preco);
        params.put("multiplicador", multiplicador);
        params.put("quantEstoque", quantEstoque);
        params.put("desc", desc);
        params.put("dataEntrada", dataEntrada);
        params.put("validade", validade);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_UPDATE_HERO, params, CODE_POST_REQUEST);
        request.execute();

        btnSalvarProd.setText("Adicionar");

        txtNomeProd.getEditText().setText("");
        txtQuantProd.getEditText().setText("");
        txtPrecoProd.getEditText().setText("");
        txtMultiplicador.getEditText().setText("");
        txtQuantEstoque.getEditText().setText("");
        txtDesc.getEditText().setText("");
        txtDataEntrada.getEditText().setText("");
        txtValidade.getEditText().setText("");

        isUpdating = false;
    }
    private void deleteHero(int id) {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_DELETE_HERO + id, null, CODE_GET_REQUEST);
        request.execute();
    }
    private void refreshHeroList(JSONArray produtos) throws JSONException {
        produtoList.clear();
        for (int i = 0; i < produtos.length(); i++) {
            JSONObject obj = produtos.getJSONObject(i);



            produtoList.add(new Produto(
                    obj.getInt("id"),
                    obj.getString("nome"),
                    obj.getDouble("quantidade"),
                    obj.getDouble("preco"),
                    obj.getDouble("multiplicador"),
                    obj.getDouble("quantEstoque"),
                    obj.getString("desc"),
                    obj.getString("dataEntrada"),
                    obj.getString("validade")
            ));
        }
        EstoqueAdapter adapter = new EstoqueAdapter(this, produtoList); // Use o contexto e a lista

    }
    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    refreshHeroList(object.getJSONArray("heroes"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);


            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }

    }

}
