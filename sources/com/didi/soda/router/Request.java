package com.didi.soda.router;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import java.io.Serializable;

public class Request {

    /* renamed from: a */
    private Route f43655a;

    /* renamed from: b */
    private Bundle f43656b;

    /* renamed from: c */
    private Class<?> f43657c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f43658d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f43659e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Object f43660f;

    Request(Route route, Bundle bundle, Class<?> cls) {
        this.f43655a = route;
        this.f43656b = bundle;
        this.f43657c = cls;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Route mo108729a() {
        return this.f43655a;
    }

    public String getPath() {
        return this.f43655a.getAbsolutePath();
    }

    public Bundle getExtras() {
        return this.f43656b;
    }

    public Class<?> getTarget() {
        return this.f43657c;
    }

    public Object getFromPage() {
        return this.f43660f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo108731b() {
        return this.f43658d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo108730a(boolean z) {
        this.f43658d = z;
    }

    public static class Builder {
        private Object fromPage;
        private boolean httpCompat = true;
        private Bundle params;
        private String path;
        /* access modifiers changed from: private */

        /* renamed from: router  reason: collision with root package name */
        public DiRouter f61873router;
        private boolean syncCall;

        Builder(DiRouter diRouter) {
            this.f61873router = diRouter;
        }

        public Builder path(String str) {
            if (!C14171c.m30994a(str)) {
                this.path = str.trim();
            }
            return this;
        }

        public Builder params(Bundle bundle) {
            Bundle bundle2 = this.params;
            if (bundle2 == null) {
                this.params = bundle;
            } else {
                bundle2.putAll(bundle);
            }
            return this;
        }

        public Builder putBundle(String str, Bundle bundle) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putBundle(str, bundle);
            return this;
        }

        public Builder putInt(String str, int i) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putInt(str, i);
            return this;
        }

        public Builder putLong(String str, long j) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putLong(str, j);
            return this;
        }

        public Builder putDouble(String str, double d) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putDouble(str, d);
            return this;
        }

        public Builder putBoolean(String str, boolean z) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putBoolean(str, z);
            return this;
        }

        public Builder putString(String str, String str2) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putString(str, str2);
            return this;
        }

        public Builder putSerializable(String str, Serializable serializable) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putSerializable(str, serializable);
            return this;
        }

        public Builder putParcelable(String str, Parcelable parcelable) {
            if (this.params == null) {
                this.params = new Bundle();
            }
            this.params.putParcelable(str, parcelable);
            return this;
        }

        public Builder setSyncCall(boolean z) {
            this.syncCall = z;
            return this;
        }

        public Builder httpCompat(boolean z) {
            this.httpCompat = z;
            return this;
        }

        public Builder setFromPage(Object obj) {
            if (obj != null) {
                this.fromPage = obj;
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Request build() {
            Route parse = Route.parse(this.path);
            if (parse.getScheme() == null) {
                parse.setScheme(this.f61873router.f43649a.getScheme());
            }
            if (parse.getHost() == null) {
                parse.setHost(this.f61873router.f43649a.getHost());
            }
            if (parse.getParams() != null) {
                if (this.params == null) {
                    this.params = new Bundle();
                }
                C14170b.m30992a(parse.getParams(), this.params);
            }
            Class<?> a = HubTable.m30964a(parse.getPath());
            if (a == null) {
                a = HubTable.m30964a(C14170b.m30993b(parse.getAbsolutePath()));
            }
            Request request = new Request(parse, this.params, a);
            boolean unused = request.f43659e = this.syncCall;
            boolean unused2 = request.f43658d = this.httpCompat;
            Object unused3 = request.f43660f = this.fromPage;
            return request;
        }

        public Response open() {
            Request build = build();
            if (this.syncCall) {
                return this.f61873router.mo108726a(build);
            }
            open((Callback) null);
            Response response = new Response(build);
            response.mo108754a(-7);
            return response;
        }

        public void open(Callback callback) {
            open(callback, 0);
        }

        public void open(final Callback callback, long j) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    Response a = Builder.this.f61873router.mo108726a(Builder.this.build());
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onResponse(a);
                    }
                }
            }, j);
        }
    }
}
