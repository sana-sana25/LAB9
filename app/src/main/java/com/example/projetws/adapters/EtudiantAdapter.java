package com.example.projetws.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetws.R;
import com.example.projetws.models.Etudiant;
import java.util.List;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder> {

    private List<Etudiant> etudiantList;

    // Constructeur
    public EtudiantAdapter(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @NonNull
    @Override
    public EtudiantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_etudiant, parent, false);
        return new EtudiantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EtudiantViewHolder holder, int position) {
        Etudiant etudiant = etudiantList.get(position);

        // Nom complet
        holder.tvNomPrenom.setText(etudiant.getNom() + " " + etudiant.getPrenom());

        // Ville
        holder.tvVille.setText("📍 " + etudiant.getVille());

        // Sexe
        holder.tvSexe.setText("👤 " + etudiant.getSexe());

        // ID badge
        holder.tvId.setText("#" + etudiant.getId());

        // Initiale (première lettre du nom)
        if (etudiant.getNom() != null && !etudiant.getNom().isEmpty()) {
            holder.tvInitiale.setText(String.valueOf(etudiant.getNom().charAt(0)).toUpperCase());
        }
    }

    @Override
    public int getItemCount() {
        return etudiantList.size();
    }

    // ViewHolder
    public static class EtudiantViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomPrenom, tvVille, tvSexe, tvId, tvInitiale;

        public EtudiantViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomPrenom = itemView.findViewById(R.id.tvNomPrenom);
            tvVille     = itemView.findViewById(R.id.tvVille);
            tvSexe      = itemView.findViewById(R.id.tvSexe);
            tvId        = itemView.findViewById(R.id.tvId);
            tvInitiale  = itemView.findViewById(R.id.tvInitiale);
        }
    }
}