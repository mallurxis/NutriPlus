package br.com.etecia.nutriapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.etecia.nutriapp.R;


public class PerfilFragment extends Fragment {

    Button btnEditarPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_perfil, container, false);

       btnEditarPerfil = view.findViewById(R.id.btnEditarPerfil);
       btnEditarPerfil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Manipule o clique do txtSegunda aqui
               FragmentManager fragmentManager = getParentFragmentManager();
               EditarPerfilFragment fragment = new EditarPerfilFragment();
               fragmentManager.beginTransaction()
                       .replace(R.id.idFragmentPerfil, fragment)
                       .addToBackStack(null)
                       .commit();
           }

       });
        return view;
    }
}