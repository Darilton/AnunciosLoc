package ao.co.isptec.anunciosloc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.tabs.TabLayout;

public class AdicionarLocalActivity extends AppCompatActivity {

    private EditText etNomeLocal, etLatitude, etLongitude, etRaio;
    private TabLayout tabTipoLocal;
    private Button btnUsarGps, btnCancelar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_local);

        // === ENCONTRAR VIEWS ===
        Toolbar toolbar = findViewById(R.id.toolbar);
        etNomeLocal = findViewById(R.id.et_nome_local);
        etLatitude = findViewById(R.id.et_latitude);
        etLongitude = findViewById(R.id.et_longitude);
        etRaio = findViewById(R.id.et_raio);
        tabTipoLocal = findViewById(R.id.tab_tipo_local);
        btnUsarGps = findViewById(R.id.btn_usar_gps);
        btnCancelar = findViewById(R.id.btn_cancelar);
        btnGuardar = findViewById(R.id.btn_guardar);

        // === TOOLBAR ===
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Adicionar Novo Local");
        }

        // === TAB LAYOUT (GPS / WiFi) ===
        tabTipoLocal.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    // GPS selecionado
                    etLatitude.setEnabled(true);
                    etLongitude.setEnabled(true);
                    etRaio.setEnabled(true);
                    btnUsarGps.setEnabled(true);
                } else {
                    // WiFi ID selecionado
                    etLatitude.setEnabled(false);
                    etLongitude.setEnabled(false);
                    etRaio.setEnabled(false);
                    btnUsarGps.setEnabled(false);
                }
            }

            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });

        // === BOTÃO USAR GPS ===
        btnUsarGps.setOnClickListener(v -> {
            Toast.makeText(this, "GPS atual usado!", Toast.LENGTH_SHORT).show();
            // Futuro: pegar localização real
        });

        // === BOTÃO CANCELAR ===
        btnCancelar.setOnClickListener(v -> finish());

        // === BOTÃO GUARDAR ===
        btnGuardar.setOnClickListener(v -> {
            String nome = etNomeLocal.getText().toString().trim();
            if (nome.isEmpty()) {
                Toast.makeText(this, "Insira um nome!", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Local \"" + nome + "\" guardado!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}