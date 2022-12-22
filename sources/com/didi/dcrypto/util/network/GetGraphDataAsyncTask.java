package com.didi.dcrypto.util.network;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.didi.dcrypto.chart.ChartCallback;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.api.OneLoginFacade;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetGraphDataAsyncTask extends AsyncTask<String, Void, String> {

    /* renamed from: a */
    String f16517a;

    /* renamed from: b */
    ChartCallback f16518b;

    /* renamed from: c */
    String f16519c;

    public GetGraphDataAsyncTask(ChartCallback chartCallback, String str) {
        this.f16518b = chartCallback;
        this.f16519c = str;
        this.f16519c = str;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* access modifiers changed from: protected */
    public String doInBackground(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(NetworkConstants.URL_GET_GRAPH_DATA + ("?cryptoCurrencySymbol=" + this.f16519c + "&lang=en-US&token=") + OneLoginFacade.getStore().getToken()).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            SystemUtils.log(4, "Dcrypto HTTP", "GetGraphData requets raw = " + httpURLConnection.getURL().toString(), (Throwable) null, "com.didi.dcrypto.util.network.GetGraphDataAsyncTask", 48);
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            this.f16517a = NetworkUtils.readStream(httpURLConnection.getInputStream());
            SystemUtils.log(4, "Dcrypto HTTP", "GetGraphData response raw = " + this.f16517a, (Throwable) null, "com.didi.dcrypto.util.network.GetGraphDataAsyncTask", 53);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    GetGraphDataAsyncTask.this.m12130a();
                }
            });
            SystemUtils.log(2, "Dcrypto HTTP", "GetGraphData result = " + this.f16517a, (Throwable) null, "com.didi.dcrypto.util.network.GetGraphDataAsyncTask", 58);
            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12130a() {
        this.f16518b.onReceiveData(this.f16517a, this.f16519c);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
    }
}
