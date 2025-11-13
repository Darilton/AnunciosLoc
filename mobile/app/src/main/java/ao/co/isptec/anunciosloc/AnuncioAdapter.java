package ao.co.isptec.anunciosloc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.ViewHolder> {

    private final ArrayList<Anuncio> lista;

    public AnuncioAdapter(ArrayList<Anuncio> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anuncio, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        Anuncio a = lista.get(i);
        h.tvTitulo.setText(a.titulo);
        h.tvLocal.setText(a.local);
        h.tvStatus.setText(a.status);
        h.tvStatus.setTextColor(a.corStatus);
        h.btnAcao.setText(a.acao);
        h.btnAcao.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.iconeAcao, 0);
    }

    @Override
    public int getItemCount() { return lista.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvLocal, tvStatus;
        Button btnAcao;
        ViewHolder(View v) {
            super(v);
            tvTitulo = v.findViewById(R.id.tv_titulo);
            tvLocal = v.findViewById(R.id.tv_local);
            tvStatus = v.findViewById(R.id.tv_status);
            btnAcao = v.findViewById(R.id.btn_acao);
        }
    }
}