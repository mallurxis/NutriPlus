package br.com.etecia.nutriapp.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.fragment.CardapioFragment;
import br.com.etecia.nutriapp.fragment.EstoqueFragment;
import br.com.etecia.nutriapp.fragment.HistoricoFragment;
import br.com.etecia.nutriapp.fragment.PerfilFragment;
import br.com.etecia.nutriapp.fragment.PratosFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    EstoqueFragment frgEstoque = new EstoqueFragment();
    PratosFragment frgPratos = new PratosFragment();
    HistoricoFragment frgHistorico = new HistoricoFragment();
    PerfilFragment frgPerfil = new PerfilFragment();
    CardapioFragment frgCardapio = new CardapioFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bottomNavigationView = findViewById(R.id.bnbMenu);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.frmContainerMenu, frgCardapio).commit();





        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mCardapio) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.frmContainerMenu, frgCardapio).commit();
                    return true;
                }
                if (item.getItemId() == R.id.mEstoque) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.frmContainerMenu, frgEstoque).commit();
                    return true;
                }
                if (item.getItemId() == R.id.mPratos) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.frmContainerMenu, frgPratos).commit();
                    return true;
                }
                if (item.getItemId() == R.id.mHistorico) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.frmContainerMenu, frgHistorico).commit();
                    return true;
                }
                if (item.getItemId() == R.id.mPerfil) {
                    getSupportFragmentManager().
                            beginTransaction().
                            replace(R.id.frmContainerMenu, frgPerfil).commit();
                    return true;
                }


                return false;
            }
        });
    }
}