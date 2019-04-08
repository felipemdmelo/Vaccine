package com.felipemdmelo.vaccine.activities.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

public class BaseFragmentActivity extends FragmentActivity {

    protected void irPara(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }

}
