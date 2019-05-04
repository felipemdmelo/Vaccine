package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Dependente;
import com.felipemdmelo.vaccine.repositories.DependenteRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;

import java.util.List;

public class MeusDependentesActivity extends BaseActivity {

    private DependenteRepository dependenteRepository;

    private UsuarioSharedPref usuarioSharedPref;

    private ListView meusDependentesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dependentes);

        initAtributos();

        carregaMeusDependentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meus_dependentes_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.novo_dependente_menu:
                irPara(this, DependenteCadastroActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initAtributos() {
        this.dependenteRepository = new DependenteRepository((App) getApplication());

        this.usuarioSharedPref = new UsuarioSharedPref(this);

        this.meusDependentesListView = findViewById(R.id.meus_dependentes_list);
        this.meusDependentesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dependente dependente = (Dependente) adapterView.getItemAtPosition(i);
                irPara(MeusDependentesActivity.this, MinhaCarteiraActivity.class, dependente);
            }
        });
    }

    private void carregaMeusDependentes() {
        String numeroCarteira = this.usuarioSharedPref.getUsuario().getNumeroCarteira();

        List<Dependente> meusDependentes = this.dependenteRepository.getAll(numeroCarteira);

        ArrayAdapter<Dependente> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, meusDependentes);

        meusDependentesListView.setAdapter(adapter);
    }
}
