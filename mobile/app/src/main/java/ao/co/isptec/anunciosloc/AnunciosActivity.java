package ao.co.isptec.anunciosloc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class AnunciosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recycler = findViewById(R.id.recycler_anuncios);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Anuncio> lista = new ArrayList<>();
        lista.add(new Anuncio(
                "Promoção de Café da Manhã", "Café Central",
                "Activo", 0xFF4CAF50, "Centralizado", R.drawable.ic_close
        ));
        lista.add(new Anuncio(
                "Serviço de Jardinagem", "Vários Locais",
                "Expirado", 0xFF2196F3, "Descentralizado", R.drawable.ic_volume
        ));

        recycler.setAdapter(new AnuncioAdapter(lista));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
