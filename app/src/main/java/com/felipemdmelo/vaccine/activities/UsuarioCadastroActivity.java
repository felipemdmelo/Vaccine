package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Usuario;
import com.felipemdmelo.vaccine.repositories.UsuarioRepository;
import com.felipemdmelo.vaccine.utils.PasswordUtils;

public class UsuarioCadastroActivity extends BaseActivity {

    private UsuarioRepository usuarioRepository;

    private EditText numeroCarteiraEdt;
    private EditText nomeEdt;
    private EditText dataNascimentoEdt;
    private EditText senhaEdt;
    private EditText confirmarSenhaEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_cadastro);

        initAtributos();
    }

    private void initAtributos() {
        this.usuarioRepository = new UsuarioRepository((App) getApplication());

        numeroCarteiraEdt = findViewById(R.id.numeroCarteiraEdt);
        nomeEdt = findViewById(R.id.nomeEdt);
        dataNascimentoEdt = findViewById(R.id.dataNascimentoEdt);
        senhaEdt = findViewById(R.id.senhaEdt);
        confirmarSenhaEdt = findViewById(R.id.confirmarSenhaEdt);
    }

    public void salvarBtnClick(View view) {
        try {
            String numeroCarteira = numeroCarteiraEdt.getText().toString().trim();
            String nome = nomeEdt.getText().toString().trim();
            String dataNascimentoStr = dataNascimentoEdt.getText().toString().trim();
            String senha = senhaEdt.getText().toString();
            String confirmarSenha = confirmarSenhaEdt.getText().toString();

            if (numeroCarteira.isEmpty() || nome.isEmpty() || dataNascimentoStr.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!senha.equals(confirmarSenha)) {
                Toast.makeText(this, "As senhas n\u00e3o coincidem.", Toast.LENGTH_SHORT).show();
                return;
            }

            String senhaHash = PasswordUtils.hash(senha);
            Usuario usuario = new Usuario(numeroCarteira, nome, dataNascimentoStr, senhaHash);

            String msg = usuarioRepository.adiciona(usuario);

            irPara(this, LoginActivity.class);

            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            android.util.Log.e("UsuarioCadastroActivity", "Erro ao cadastrar usu\u00e1rio", e);
            Toast.makeText(this,
                    getString(R.string.erro_generico),
                    Toast.LENGTH_LONG).show();
        }
    }
}
