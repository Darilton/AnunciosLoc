package ao.co.isptec.anunciosloc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class MeusLocaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulocais);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // ListView
        ListView listView = findViewById(R.id.list_view_locais);

        // === DADOS FIXOS (exatamente como na foto) ===
        ArrayList<Local> locais = new ArrayList<>();
        locais.add(new Local("ISPTEC", "GPS: Raio de 50m", R.drawable.ic_gps_pin));
        locais.add(new Local("CASA", "wifi", R.drawable.ic_wifi));
        locais.add(new Local("SHOPPING FORTALEZA", "GPS: Raio de 200m", R.drawable.ic_gps_pin));

        // Adapter (RECUPERADO!)
        LocalAdapter adapter = new LocalAdapter(locais);
        listView.setAdapter(adapter);
    }

    // ==========================================
    // LOCALADAPTER RECUPERADO (NÃO APAGUE MAIS!)
    // ==========================================
    private class LocalAdapter extends BaseAdapter {
        private final ArrayList<Local> locais;

        public LocalAdapter(ArrayList<Local> locais) {
            this.locais = locais;
        }

        @Override
        public int getCount() {
            return locais.size();
        }

        @Override
        public Object getItem(int position) {
            return locais.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MeusLocaisActivity.this)
                        .inflate(R.layout.item_local, parent, false);
            }

            Local local = locais.get(position);

            ImageView ivIcone = convertView.findViewById(R.id.iv_icone);
            TextView tvNome = convertView.findViewById(R.id.tv_nome);
            TextView tvDescricao = convertView.findViewById(R.id.tv_descricao);

            ivIcone.setImageResource(local.icone);
            tvNome.setText(local.nome);
            tvDescricao.setText(local.descricao);

            return convertView;
        }
    }
}