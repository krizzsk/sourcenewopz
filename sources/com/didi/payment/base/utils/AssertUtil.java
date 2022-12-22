package com.didi.payment.base.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class AssertUtil {
    public static String readAssetsFile(Context context, String str) {
        InputStreamReader inputStreamReader;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getAssets().open(str), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                inputStreamReader = null;
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                    stringBuffer.append("\n");
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return stringBuffer.toString();
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
