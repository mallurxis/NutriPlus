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
import br.com.etecia.nutriapp.classes.Prato;
import br.com.etecia.nutriapp.fragment.EditarPratoFragment;
import br.com.etecia.nutriapp.fragment.EditarProdutoFragment;

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

        holder.btnEditarPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                EditarPratoFragment fragment = new EditarPratoFragment();
                fragmentManager.beginTransaction()
                        .replace(R.id.idFragmentPrato, fragment) // Substitua pelo ID do seu container de fragmentos
                        .addToBackStack(null)
                        .commit();
            }
        });

        holder.btnExcluirPrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Excluir item")
                        .setMessage("Tem certeza de que deseja excluir este item?")
                        .setPositiveButton("Sim", (dialog, which) -> {
                            // Ação a ser tomada se o usuário confirmar
                            pratoList.remove(holder.getAdapterPosition());
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
        return pratoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNomePrato;
        TextView txtPrecoPrato;
        ImageView btnEditarPrato;
        ImageView btnExcluirPrato;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomePrato = itemView.findViewById(R.id.txtNomePrato);
            txtPrecoPrato = itemView.findViewById(R.id.txtPrecoPrato);
            btnEditarPrato = itemView.findViewById(R.id.btnEditarPrato);
            btnExcluirPrato = itemView.findViewById(R.id.imgDeletePrato);
        }
    }
}
