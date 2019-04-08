package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.models.Usuario;
import com.felipemdmelo.vaccine.repositories.UsuarioRepository;

import java.sql.Date;

public class UsuarioCadastroActivity extends BaseActivity {

    private UsuarioRepository usuarioRepository;

    EditText numeroCarteiraEdt;
    EditText nomeEdt;
    EditText dataNascimentoEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_cadastro);

        initAtributos();
    }

    public void initAtributos() {
        this.usuarioRepository = new UsuarioRepository();

        numeroCarteiraEdt = findViewById(R.id.numeroCarteiraEdt);
        nomeEdt = findViewById(R.id.nomeEdt);
        dataNascimentoEdt = findViewById(R.id.dataNascimentoEdt);
    }

    public void salvarBtnClick(View view) {
        try {
            String numeroCarteira = numeroCarteiraEdt.getText().toString();
            String nome = nomeEdt.getText().toString();
            String dataNascimentoStr = dataNascimentoEdt.getText().toString();
            Date dataNascimento = Date.valueOf(dataNascimentoStr);

            Usuario usuario = new Usuario(numeroCarteira, nome, dataNascimento);

            String msg = usuarioRepository.adiciona(usuario);

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
