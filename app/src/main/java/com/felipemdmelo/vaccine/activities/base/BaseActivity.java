package com.felipemdmelo.vaccine.activities.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.felipemdmelo.vaccine.models.Dependente;

public class BaseActivity extends AppCompatActivity {

    protected void irPara(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

    protected void irPara(Context context, Class<?> cls, Dependente dependente) {
        Intent intent = new Intent(context, cls);

        if(dependente != null) // Ajustar isso!!!!
            intent.putExtra("dependente", dependente);

        startActivity(intent);
    }

}
