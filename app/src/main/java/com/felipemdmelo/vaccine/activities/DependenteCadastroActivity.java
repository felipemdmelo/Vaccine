package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Dependente;
import com.felipemdmelo.vaccine.repositories.DependenteRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;

public class DependenteCadastroActivity extends BaseActivity {

    private DependenteRepository dependenteRepository;

    private UsuarioSharedPref usuarioSharedPref;

    EditText numeroCarteiraEdt;
    EditText nomeEdt;
    EditText dataNascimentoEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependente_cadastro);

        initAtributos();
    }

    public void initAtributos() {
        this.dependenteRepository = new DependenteRepository((App) getApplication());

        this.usuarioSharedPref = new UsuarioSharedPref(this);

        numeroCarteiraEdt = findViewById(R.id.numeroCarteiraEdt);
        nomeEdt = findViewById(R.id.nomeEdt);
        dataNascimentoEdt = findViewById(R.id.dataNascimentoEdt);
    }

    public void salvarBtnClick(View view) {
        try {
            String numeroCarteira = numeroCarteiraEdt.getText().toString();
            String numeroCarteiraPai = this.usuarioSharedPref.getUsuario().getNumeroCarteira();
            String nome = nomeEdt.getText().toString();
            String dataNascimentoStr = dataNascimentoEdt.getText().toString();

            Dependente dependente = new Dependente(null, numeroCarteira, numeroCarteiraPai, nome, dataNascimentoStr);

            String msg = dependenteRepository.insert(dependente);

            irPara(this, MeusDependentesActivity.class);

            Toast.makeText(this,
                    msg,
                    Toast.LENGTH_LONG).show();
        } catch(Exception e) {
            // TODO: registrar o erro em log

            Toast.makeText(this,
                    getString(R.string.erro_generico),
                    Toast.LENGTH_LONG).show();
        }
    }
}
