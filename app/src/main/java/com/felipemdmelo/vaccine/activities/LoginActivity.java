package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Usuario;
import com.felipemdmelo.vaccine.repositories.MinhaVacinaRepository;
import com.felipemdmelo.vaccine.repositories.UsuarioRepository;
import com.felipemdmelo.vaccine.repositories.VacinaRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;
import com.felipemdmelo.vaccine.utils.PasswordUtils;

public class LoginActivity extends BaseActivity {

    private UsuarioSharedPref usuarioSharedPref;

    private UsuarioRepository usuarioRepository;
    private VacinaRepository vacinaRepository;
    private MinhaVacinaRepository minhaVacinaRepository;

    private EditText loginEdt;
    private EditText senhaEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initAtributos();

        initDatabase();
    }

    private void initDatabase() {
        vacinaRepository.initTable();
    }

    private void initAtributos() {
        this.usuarioSharedPref = new UsuarioSharedPref(this);
        this.usuarioRepository = new UsuarioRepository((App) getApplication());
        this.vacinaRepository = new VacinaRepository((App) getApplication());
        this.minhaVacinaRepository = new MinhaVacinaRepository((App) getApplication());

        loginEdt = findViewById(R.id.loginEdt);
        senhaEdt = findViewById(R.id.senhaEdt);
    }

    public void entrarBtnClick(View view) {
        try {
            String login = loginEdt.getText().toString().trim();
            String senha = senhaEdt.getText().toString();

            if (login.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha login e senha.", Toast.LENGTH_SHORT).show();
                return;
            }

            String senhaHash = PasswordUtils.hash(senha);
            Usuario usuario = usuarioRepository.validaLogin(login, senhaHash);

            if (usuario != null) {
                usuarioSharedPref.putUsuario(usuario);
                minhaVacinaRepository.initTable(usuario.getNumeroCarteira());
                irPara(this, MapsActivity.class);
            } else {
                Toast.makeText(this,
                        "Login e/ou senha inv\u00e1lidos!",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            android.util.Log.e("LoginActivity", "Erro ao realizar login", e);
            Toast.makeText(this,
                    getString(R.string.erro_generico),
                    Toast.LENGTH_LONG).show();
        }
    }

    public void cadastrarBtnClick(View view) {
        irPara(this, UsuarioCadastroActivity.class);
    }

    public void loginFacebookBtnClick(View view) {
        Toast.makeText(this, "Em Dev!", Toast.LENGTH_LONG).show();
    }
}
