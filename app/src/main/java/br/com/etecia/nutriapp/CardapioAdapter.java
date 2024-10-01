package br.com.etecia.nutriapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        holder.txtDataSemana.setText(String.format("dd/mm/yyyy"));
    }

    @Override
    public int getItemCount() {
        return semanaList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnSemanaCardapio;
        TextView txtDataSemana;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSemanaCardapio = itemView.findViewById(R.id.btnSemanaCardapio);
            txtDataSemana = itemView.findViewById(R.id.txtDataSemana);
        }
    }
}
