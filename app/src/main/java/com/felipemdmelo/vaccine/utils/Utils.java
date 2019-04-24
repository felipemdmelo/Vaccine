package com.felipemdmelo.vaccine.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Utils {

    public static String getDateStr(Date data) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }

    public static int getIntRandom() {
        Random random = new Random();
        return random.nextInt(25);
    }

}
