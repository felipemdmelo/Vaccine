package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.models.MinhaVacina;
import com.felipemdmelo.vaccine.repositories.MinhaCarteiraRepository;

import java.util.List;

public class MinhaCarteiraActivity extends BaseActivity {

    private MinhaCarteiraRepository minhaCarteiraRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minha_carteira);

        initAtributos();

        carregaMinhaCarteira();
    }

    private void initAtributos() {
        this.minhaCarteiraRepository = new MinhaCarteiraRepository();
    }

    private void carregaMinhaCarteira() {
        List<MinhaVacina> minhaCarteira = this.minhaCarteiraRepository.getMinhaCarteira();

        ListView minhaCarteiraListView = findViewById(R.id.minha_carteira_list);

        ArrayAdapter<MinhaVacina> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, minhaCarteira);

        minhaCarteiraListView.setAdapter(adapter);
    }
}
