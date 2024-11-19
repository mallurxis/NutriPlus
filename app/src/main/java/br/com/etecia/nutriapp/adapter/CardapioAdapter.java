package br.com.etecia.nutriapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.etecia.nutriapp.R;
import br.com.etecia.nutriapp.classes.Semana;
import br.com.etecia.nutriapp.fragment.CalendarioFragment;
import br.com.etecia.nutriapp.fragment.EditarSemanaFragment;
import br.com.etecia.nutriapp.fragment.RefeicoesFragment;

public class CardapioAdapter extends RecyclerView.Adapter<CardapioAdapter.ViewHolder> {
    private Context context;
    private List<Semana> semanaList;

    public CardapioAdapter(Context context, List<Semana> semanaList) {
        this.context = context;
        this.semanaList = semanaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardapiomodelo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Semana semana = semanaList.get(position);

        holder.btnSemanaCardapio.setText(semana.getNomeSemana());
        holder.txtDataSemana.setText(String.format(semana.getDataSemana()));

        holder.btnSemanaCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                CalendarioFragment fragment = new CalendarioFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.idFragmentCardapio, fragment) // Substitua pelo ID do seu container de fragmentos
                        .addToBackStack(null)
                        .commit();
            }

        });
        holder.btnEditarSemana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                EditarSemanaFragment fragment = new EditarSemanaFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.idFragmentCardapio, fragment) // Substitua pelo ID do seu container de fragmentos
                        .addToBackStack(null)
                        .commit();

            }
        });

        holder.btnExcluirSemana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Excluir item")
                        .setMessage("Tem certeza de que deseja excluir este item?")
                        .setPositiveButton("Sim", (dialog, which) -> {
                            // Ação a ser tomada se o usuário confirmar
                            semanaList.remove(holder.getAdapterPosition());
                            notifyItemRemoved(holder.getAdapterPosition());
                        })
                        .setNegativeButton("Não", (dialog, which) -> {
                            // Se o usuário cancelar, apenas fechar o diálogo
                            dialog.dismiss();
                        })
                        .create()
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return semanaList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnSemanaCardapio;
        TextView txtDataSemana;
        ImageView btnEditarSemana;
        ImageView btnExcluirSemana;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSemanaCardapio = itemView.findViewById(R.id.btnSemanaCardapio);
            txtDataSemana = itemView.findViewById(R.id.txtDataSemana);
            btnEditarSemana = itemView.findViewById(R.id.btnEditarSemana);
            btnExcluirSemana = itemView.findViewById(R.id.btnExcluirSemana);

        }
    }
}
