package com.megvii.licensemanager;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private static final String AUTHURL = "http://api.faceid.com/faceid/v1/sdk/authm";
    private static List<ILicenseManager> managers = new ArrayList();
    private Context mContext;

    private void findAllManager() {
    }

    public Manager(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            return;
        }
        throw new InvalidParameterException("context can not be null");
    }

    public String getContext(String str) {
        if (this.mContext == null || managers.size() == 0) {
            return null;
        }
        this.mContext = this.mContext.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        for (ILicenseManager context : managers) {
            sb.append(context.getContext(str));
            sb.append('$');
        }
        String sb2 = sb.toString();
        return sb2.substring(0, sb2.length() - 1);
    }

    public Map<String, Long> setLicense(String str) {
        HashMap hashMap = null;
        if (!(str == null || this.mContext == null)) {
            String[] split = str.split("\\$");
            if (split.length != managers.size()) {
                return null;
            }
            this.mContext = this.mContext.getApplicationContext();
            hashMap = new HashMap(split.length);
            for (int i = 0; i < managers.size(); i++) {
                hashMap.put(managers.get(i).getVersion(), Long.valueOf(managers.get(i).setLicense(split[i])));
            }
        }
        return hashMap;
    }

    public HashMap<String, Long> checkCachedLicense() {
        HashMap<String, Long> hashMap = new HashMap<>();
        for (ILicenseManager next : managers) {
            hashMap.put(next.getVersion(), Long.valueOf(next.checkCachedLicense()));
        }
        return hashMap;
    }

    public synchronized boolean registerLicenseManager(ILicenseManager iLicenseManager) {
        boolean z;
        z = false;
        for (ILicenseManager version : managers) {
            if (version.getVersion().equals(iLicenseManager.getVersion())) {
                z = true;
            }
        }
        if (!z) {
            managers.add(iLicenseManager);
        }
        return !z;
    }

    public synchronized Map<String, Long> takeLicenseFromNetwork(String str) {
        return setLicense(doPost(getContext(str)));
    }

    private static String doPost(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(AUTHURL).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-type", "text/plain");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
