package br.com.etecia.nutriapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import br.com.etecia.nutriapp.R;

public class CadastroActivity extends AppCompatActivity {
ImageView btnVoltarCadastro;
Button btnCadastrar;
TextInputEditText edtRegEmail, edtRegSenha;

FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastro_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        edtRegSenha = findViewById(R.id.edtRegSenha);
        edtRegEmail = findViewById(R.id.edtRegEmail);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnVoltarCadastro = findViewById(R.id.btnVoltarCadastro);


        btnVoltarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, senha;
                email = String.valueOf(edtRegEmail.getText());
                senha = String.valueOf(edtRegSenha.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(CadastroActivity.this, "Insira o E-mail!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(senha)){
                    Toast.makeText(CadastroActivity.this, "Insira a Senha!", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(CadastroActivity.this, "Registrado!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(CadastroActivity.this, "Algo deu errado!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}