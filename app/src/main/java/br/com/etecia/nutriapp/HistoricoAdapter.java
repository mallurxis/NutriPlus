package br.com.etecia.nutriapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricoAdapter extends RecyclerView.Adapter<HistoricoAdapter.ViewHolder> {
  private Context context;
  private List<HistoricoPrato> historicoList;

    public HistoricoAdapter(Context context, List<HistoricoPrato> historicoList) {
        this.context = context;
        this.historicoList = historicoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.historicomodelo, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoricoPrato historicoPrato = historicoList.get(position);

        holder.txtPratoHistorico.setText(historicoPrato.getPratoHistorico());
        holder.txtIngredienteHistorico.setText(historicoPrato.getIngredienteHistorico());
        holder.txtPrecoHistorico.setText(String.format("R$ %.2f", historicoPrato.getPrecoHistorico()));
    }

    @Override
    public int getItemCount() {
        return historicoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtPratoHistorico;
        TextView txtIngredienteHistorico;
        TextView txtPrecoHistorico;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPratoHistorico = itemView.findViewById(R.id.txtPratoGasto);
            txtIngredienteHistorico = itemView.findViewById(R.id.txtNomeIngrediente);
            txtPrecoHistorico = itemView.findViewById(R.id.txtPrecoHistorico);

        }
    }
}
