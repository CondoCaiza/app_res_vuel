package com.example.app_res_vuel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_res_vuel.R;
import com.example.app_res_vuel.model.Persona;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHolder> {
    private List<Persona> lstPersona;
    private Context context;
    private LayoutInflater mInfalter;
    private ItemClickListener mClickListe;
    public PersonaAdapter(List<Persona> _lstPersona, Context _context)  {
        this.lstPersona=_lstPersona;
        this.context=_context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInfalter.inflate(R.layout.item_personas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }
    public Persona getPer(int id) {
        return lstPersona.get(id);
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        private TextView lbNombre;
        private TextView lbApellido;
        private TextView lbdni;
        private TextView lbfecha_nac;
        private TextView lbest_civil;
        private TextView lbe_mail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.lbNombre = (TextView) itemView.findViewById(R.id.lbnombre);
            this.lbApellido = (TextView) itemView.findViewById(R.id.lbapellido);
            this.lbdni = (TextView) itemView.findViewById(R.id.lbdni);
            this.lbfecha_nac = (TextView) itemView.findViewById(R.id.lbfecga_nac);
            this.lbest_civil = (TextView) itemView.findViewById(R.id.lbest_civil);
            //this.lbe_mail = (TextView) itemView.findViewById(R.id.lb_email);
         }
         @Override
        public void onClick(View view) {
            if(mClickListe != null) mClickListe.onItemClick(view, getAdapterPosition());
         }
    }
    void setClickListener(ItemClickListener iClickLis) {
        this.mClickListe=iClickLis;
    }
    public interface ItemClickListener {
        void onItemClick(View v, int pos);
    }
}
