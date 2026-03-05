package com.felipemdmelo.vaccine.repositories;

import android.database.Cursor;

import com.felipemdmelo.vaccine.application.App;
import com.felipemdmelo.vaccine.models.Usuario;

import org.greenrobot.greendao.database.Database;

public class UsuarioRepository {

    private static final String TABLE = "USUARIO";
    private static final String COL_NUMERO_CARTEIRA = "NUMERO_CARTEIRA";
    private static final String COL_NOME = "NOME";
    private static final String COL_DATA_NASCIMENTO = "DATA_NASCIMENTO";
    private static final String COL_SENHA_HASH = "SENHA_HASH";

    private final Database db;

    public UsuarioRepository(App app) {
        this.db = app.getDaoSession().getDatabase();
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS " + TABLE + " (" +
            COL_NUMERO_CARTEIRA + " TEXT PRIMARY KEY, " +
            COL_NOME + " TEXT NOT NULL, " +
            COL_DATA_NASCIMENTO + " TEXT, " +
            COL_SENHA_HASH + " TEXT NOT NULL)"
        );
    }

    public String adiciona(Usuario usuario) {
        if (usuarioExiste(usuario.getNumeroCarteira())) {
            return "Número de carteira já cadastrado.";
        }

        db.execSQL(
            "INSERT INTO " + TABLE + " (" +
            COL_NUMERO_CARTEIRA + ", " + COL_NOME + ", " +
            COL_DATA_NASCIMENTO + ", " + COL_SENHA_HASH + ") VALUES (?, ?, ?, ?)",
            new Object[]{
                usuario.getNumeroCarteira(),
                usuario.getNome(),
                usuario.getDataNascimento(),
                usuario.getSenhaHash()
            }
        );

        return "Usuário adicionado com sucesso!";
    }

    public Usuario validaLogin(String numeroCarteira, String senhaHash) {
        Cursor cursor = db.rawQuery(
            "SELECT " + COL_NUMERO_CARTEIRA + ", " + COL_NOME + ", " + COL_DATA_NASCIMENTO +
            " FROM " + TABLE +
            " WHERE " + COL_NUMERO_CARTEIRA + " = ? AND " + COL_SENHA_HASH + " = ?",
            new String[]{ numeroCarteira, senhaHash }
        );

        if (cursor != null && cursor.moveToFirst()) {
            String nc = cursor.getString(0);
            String nome = cursor.getString(1);
            String dataNascimento = cursor.getString(2);
            cursor.close();
            return new Usuario(nc, nome, dataNascimento);
        }

        if (cursor != null) cursor.close();
        return null;
    }

    private boolean usuarioExiste(String numeroCarteira) {
        Cursor cursor = db.rawQuery(
            "SELECT 1 FROM " + TABLE + " WHERE " + COL_NUMERO_CARTEIRA + " = ?",
            new String[]{ numeroCarteira }
        );
        boolean existe = cursor != null && cursor.moveToFirst();
        if (cursor != null) cursor.close();
        return existe;
    }
}
