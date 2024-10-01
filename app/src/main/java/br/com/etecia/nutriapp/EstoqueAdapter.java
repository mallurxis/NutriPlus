package br.com.etecia.nutriapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EstoqueAdapter extends RecyclerView.Adapter<EstoqueAdapter.ViewHolder> {

    private Context context;
    private List<Produto> produtoList;

    // Construtor do Adaptador
    public EstoqueAdapter(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout para um item de produto
        View view = LayoutInflater.from(context).inflate(R.layout.produtomodelo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Obtém o produto para a posição atual
        Produto produto = produtoList.get(position);

        // Configura o texto das views
        holder.txtProdModelo.setText(produto.getNome());
        holder.txtQuantModelo.setText(String.valueOf(produto.getQuantidade()));
        holder.txtPrecoModelo.setText(String.format("R$ %.2f", produto.getPreco())); // Ajuste conforme necessário
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    // Classe ViewHolder para armazenar as views
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtProdModelo;
        TextView txtQuantModelo;
        TextView txtPrecoModelo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProdModelo = itemView.findViewById(R.id.txtProdModelo);
            txtQuantModelo = itemView.findViewById(R.id.txtQuantModelo);
            txtPrecoModelo = itemView.findViewById(R.id.txtPrecoModelo);
        }
    }
}
