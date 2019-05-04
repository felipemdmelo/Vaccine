package com.felipemdmelo.vaccine.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.models.Usuario;

public class UsuarioSharedPref {

    private Context context;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public UsuarioSharedPref(Context context) {
        this.context = context;
        this.sharedPref = this.context.getSharedPreferences(
                this.context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        this.editor = sharedPref.edit();
    }

    public void putUsuario(Usuario usuario) {
        editor.putString(
                this.context.getString(R.string.usuario_numero_carteira_key),
                usuario.getNumeroCarteira());

        editor.putString(
                this.context.getString(R.string.usuario_nome_key),
                usuario.getNome());

        editor.putString(
                this.context.getString(R.string.usuario_data_nascimento_key),
                usuario.getDataNascimento().toString());

        editor.commit();
    }

    public Usuario getUsuario() {
        String numeroCarteira = this.sharedPref.getString(
                this.context.getString(R.string.usuario_numero_carteira_key),
                null);

        if(numeroCarteira == null)
            return null;

        String nome = this.sharedPref.getString(
                this.context.getString(R.string.usuario_nome_key),
                null);

        String dataNascimentoStr = this.sharedPref.getString(
                this.context.getString(R.string.usuario_data_nascimento_key),
                null);

        return new Usuario(numeroCarteira, nome, dataNascimentoStr);
    }

    public Boolean isUsuarioLogado() {
        return getUsuario() != null;
    }

    public void limpaUsuario() {
        editor.remove(this.context.getString(R.string.usuario_numero_carteira_key));
        editor.remove(this.context.getString(R.string.usuario_nome_key));
        editor.remove(this.context.getString(R.string.usuario_data_nascimento_key));
        editor.apply();
    }
}
