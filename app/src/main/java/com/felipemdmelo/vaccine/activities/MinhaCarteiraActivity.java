package com.felipemdmelo.vaccine.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Dependente;
import com.felipemdmelo.vaccine.models.MinhaVacina;
import com.felipemdmelo.vaccine.repositories.MinhaVacinaRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;

import java.util.List;

public class MinhaCarteiraActivity extends BaseActivity {

    private MinhaVacinaRepository minhaVacinaRepository;

    private UsuarioSharedPref usuarioSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minha_carteira);

        initAtributos();

        carregaMinhaCarteira();
    }

    private void initAtributos() {
        this.minhaVacinaRepository = new MinhaVacinaRepository((App) getApplication());

        this.usuarioSharedPref = new UsuarioSharedPref(this);
    }

    private void carregaMinhaCarteira() {
        String numeroCarteira = this.usuarioSharedPref.getUsuario().getNumeroCarteira();

        // Caso venha com dependente, exibir minha carteira para dependente..
        Intent intent = getIntent();
        Dependente dependente = (Dependente) intent.getSerializableExtra("dependente");
        if(dependente != null) {
            numeroCarteira = dependente.getNumeroCarteira();
            // Settar o título da página para conter o nome do dependente para diferenciar..
        }

        List<MinhaVacina> carteira = this.minhaVacinaRepository.getAll(numeroCarteira);

        ListView listView = findViewById(R.id.minha_carteira_list);

        ArrayAdapter<MinhaVacina> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, carteira);

        listView.setAdapter(adapter);
    }
}
