package com.didichuxing.mas.sdk.quality.collect.crash;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultipartUtility {

    /* renamed from: a */
    private HttpURLConnection f47789a;

    /* renamed from: b */
    private DataOutputStream f47790b;

    /* renamed from: c */
    private final String f47791c = "7d4a6d158c9";

    /* renamed from: d */
    private final String f47792d = "\r\n";

    /* renamed from: e */
    private final String f47793e = "--";

    public MultipartUtility(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f47789a = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f47789a.setDoOutput(true);
        this.f47789a.setDoInput(true);
        this.f47789a.setRequestMethod("POST");
        this.f47789a.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
        this.f47789a.setRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
        HttpURLConnection httpURLConnection2 = this.f47789a;
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data;boundary=");
        getClass();
        sb.append("7d4a6d158c9");
        httpURLConnection2.setRequestProperty("Content-Type", sb.toString());
        this.f47790b = new DataOutputStream(this.f47789a.getOutputStream());
    }

    public void addFormField(String str, String str2) throws IOException {
        DataOutputStream dataOutputStream = this.f47790b;
        StringBuilder sb = new StringBuilder();
        getClass();
        sb.append("--");
        getClass();
        sb.append("7d4a6d158c9");
        getClass();
        sb.append("\r\n");
        dataOutputStream.writeBytes(sb.toString());
        DataOutputStream dataOutputStream2 = this.f47790b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Content-Disposition: form-data; name=\"");
        sb2.append(str);
        sb2.append(Const.jsQuote);
        getClass();
        sb2.append("\r\n");
        dataOutputStream2.writeBytes(sb2.toString());
        DataOutputStream dataOutputStream3 = this.f47790b;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Content-Type: text/plain; charset=UTF-8");
        getClass();
        sb3.append("\r\n");
        dataOutputStream3.writeBytes(sb3.toString());
        DataOutputStream dataOutputStream4 = this.f47790b;
        getClass();
        dataOutputStream4.writeBytes("\r\n");
        DataOutputStream dataOutputStream5 = this.f47790b;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        getClass();
        sb4.append("\r\n");
        dataOutputStream5.writeBytes(sb4.toString());
        this.f47790b.flush();
    }

    public void addFilePart(String str, File file) throws IOException {
        String name = file.getName();
        DataOutputStream dataOutputStream = this.f47790b;
        StringBuilder sb = new StringBuilder();
        getClass();
        sb.append("--");
        getClass();
        sb.append("7d4a6d158c9");
        getClass();
        sb.append("\r\n");
        dataOutputStream.writeBytes(sb.toString());
        DataOutputStream dataOutputStream2 = this.f47790b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Content-Disposition: form-data; name=\"");
        sb2.append(str);
        sb2.append("\";filename=\"");
        sb2.append(name);
        sb2.append(Const.jsQuote);
        getClass();
        sb2.append("\r\n");
        dataOutputStream2.writeBytes(sb2.toString());
        DataOutputStream dataOutputStream3 = this.f47790b;
        getClass();
        dataOutputStream3.writeBytes("\r\n");
        byte[] a = m34209a(file);
        if (a != null && a.length > 0) {
            this.f47790b.write(a);
        }
    }

    public String finish() throws IOException {
        DataOutputStream dataOutputStream = this.f47790b;
        getClass();
        dataOutputStream.writeBytes("\r\n");
        DataOutputStream dataOutputStream2 = this.f47790b;
        StringBuilder sb = new StringBuilder();
        getClass();
        sb.append("--");
        getClass();
        sb.append("7d4a6d158c9");
        getClass();
        sb.append("--");
        getClass();
        sb.append("\r\n");
        dataOutputStream2.writeBytes(sb.toString());
        this.f47790b.flush();
        this.f47790b.close();
        int responseCode = this.f47789a.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(this.f47789a.getInputStream())));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                    sb2.append("\n");
                } else {
                    bufferedReader.close();
                    String sb3 = sb2.toString();
                    this.f47789a.disconnect();
                    return sb3;
                }
            }
        } else {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
    }

    /* renamed from: a */
    private byte[] m34209a(File file) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
