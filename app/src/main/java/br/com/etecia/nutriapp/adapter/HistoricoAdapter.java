package br.com.etecia.nutriapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.etecia.nutriapp.classes.HistoricoPrato;
import br.com.etecia.nutriapp.R;

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

        holder.btnExcluirHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Excluir item")
                        .setMessage("Tem certeza de que deseja excluir este item?")
                        .setPositiveButton("Sim", (dialog, which) -> {
                            // Ação a ser tomada se o usuário confirmar
                            historicoList.remove(holder.getAdapterPosition());
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
        return historicoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtPratoHistorico;
        TextView txtIngredienteHistorico;
        TextView txtPrecoHistorico;
        ImageView btnExcluirHistorico;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPratoHistorico = itemView.findViewById(R.id.txtPratoGasto);
            txtIngredienteHistorico = itemView.findViewById(R.id.txtNomeIngrediente);
            txtPrecoHistorico = itemView.findViewById(R.id.txtPrecoHistorico);
            btnExcluirHistorico = itemView.findViewById(R.id.imgDeleteHistorico);

        }
    }
}
