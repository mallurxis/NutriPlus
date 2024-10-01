package br.com.etecia.nutriapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.ViewHolder> {

    private Context context;
    private List<Prato> pratoList;

    public PratosAdapter(Context context, List<Prato> pratoList) {
        this.context = context;
        this.pratoList = pratoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.pratomodelo, parent, false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Prato prato = pratoList.get(position);

        holder.txtNomePrato.setText(prato.getNomePrato());
        holder.txtPrecoPrato.setText(String.format("R$ %.2f", prato.getPrecoPrato()));
    }

    @Override
    public int getItemCount() {
        return pratoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomePrato;
        TextView txtPrecoPrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomePrato = itemView.findViewById(R.id.txtNomePrato);
            txtPrecoPrato = itemView.findViewById(R.id.txtPrecoPrato);
        }
    }
}
