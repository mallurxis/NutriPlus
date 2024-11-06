package br.com.etecia.nutriapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.activity.LoginActivity;


public class PerfilFragment extends Fragment {

    Button btnEditarPerfil, btnSair;


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
       btnSair = view.findViewById(R.id.btnSair);
       btnSair.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getActivity(), LoginActivity.class);
               // Se você quiser limpar a pilha de atividades e não permitir voltar para a activity anterior
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
               // Se necessário, pode finalizar a Activity atual para evitar que o usuário volte para ela
               getActivity().finish();
           }
       });

        return view;
    }
}