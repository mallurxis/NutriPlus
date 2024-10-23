package br.com.etecia.nutriapp.API;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.List;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Produto;

public class ApiMainActivity extends AppCompatActivity {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    TextView txtNomeProd, txtQuantProd, txtPrecoProd;

    List<Produto> produtoList;

    boolean isUpdating = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_main);

        txtNomeProd = findViewById(R.id.txtProdModelo);
        txtQuantProd = findViewById(R.id.txtQuantModelo);
        txtPrecoProd = findViewById(R.id.txtPrecoModelo);

    }

    private void createHero() {
        String nome = txtNomeProd.getText().toString().trim();
        String quantidade = txtQuantProd.getText().toString().trim();
        String preco = txtPrecoProd.getText().toString().trim();


        int rating = (int) ratingBar.getRating();

        String team = spinnerTeam.getSelectedItem().toString();

        if (TextUtils.isEmpty(nome)) {
            txtNomeProd.setError("Por favor entre com o nome");
            txtNomeProd.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(quantidade)) {
            txtQuantProd.setError("Por favor entre com o nome real");
            txtQuantProd.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(preco)) {
            txtPrecoProd.setError("Por favor entre com o nome real");
            txtPrecoProd.requestFocus();
            return;
        }


        //Conexão entre o Android e o PHP através do Hash.
        HashMap<String, String> params = new HashMap<>();
        params.put("nome", nome);
        params.put("quantidade", quantidade);
        params.put("preco", preco);
        params.put("rating", String.valueOf(rating));
        params.put("teamaffiliation", team);

        PerformNetworkRequest request = new PerformNetworkRequest(Api.URL_CREATE_HERO, params, CODE_POST_REQUEST);
        request.execute();
    }
}
