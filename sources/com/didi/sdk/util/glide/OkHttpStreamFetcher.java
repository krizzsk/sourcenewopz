package com.didi.sdk.util.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream> {

    /* renamed from: a */
    private final OkHttpClient f37736a;

    /* renamed from: b */
    private final GlideUrl f37737b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InputStream f37738c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ResponseBody f37739d;

    public void cancel() {
    }

    public OkHttpStreamFetcher(OkHttpClient okHttpClient, GlideUrl glideUrl) {
        this.f37736a = okHttpClient;
        this.f37737b = glideUrl;
    }

    public void loadData(Priority priority, final DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder url = new Request.Builder().url(this.f37737b.toStringUrl());
        for (Map.Entry next : this.f37737b.getHeaders().entrySet()) {
            url.addHeader((String) next.getKey(), (String) next.getValue());
        }
        this.f37736a.newCall(url.build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                dataCallback.onLoadFailed(iOException);
            }

            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody unused = OkHttpStreamFetcher.this.f37739d = response.body();
                if (response.isSuccessful()) {
                    long contentLength = OkHttpStreamFetcher.this.f37739d.contentLength();
                    OkHttpStreamFetcher okHttpStreamFetcher = OkHttpStreamFetcher.this;
                    InputStream unused2 = okHttpStreamFetcher.f37738c = ContentLengthInputStream.obtain(okHttpStreamFetcher.f37739d.byteStream(), contentLength);
                    dataCallback.onDataReady(OkHttpStreamFetcher.this.f37738c);
                    return;
                }
                dataCallback.onLoadFailed(new HttpException(response.message(), response.code()));
            }
        });
    }

    public void cleanup() {
        InputStream inputStream = this.f37738c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ResponseBody responseBody = this.f37739d;
        if (responseBody != null) {
            responseBody.close();
        }
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
