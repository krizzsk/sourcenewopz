package com.didi.sdk.oneconf;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.store.BaseStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneConfStore extends BaseStore {

    /* renamed from: a */
    private static final String f36862a = "OneConfStore";

    /* renamed from: d */
    private static OneConfStore f36863d;

    /* renamed from: b */
    private Logger f36864b;

    /* renamed from: c */
    private RpcServiceFactory f36865c;

    /* renamed from: e */
    private List<OneConfConfigChangeListener> f36866e;

    /* renamed from: f */
    private SharedPreferences f36867f;

    /* renamed from: g */
    private OneConfData f36868g;

    /* renamed from: h */
    private Context f36869h;

    /* renamed from: i */
    private int f36870i;

    /* renamed from: j */
    private int f36871j;

    /* renamed from: k */
    private double f36872k;

    /* renamed from: l */
    private double f36873l;

    public interface OneConfConfigChangeListener {
        void onChanged(OneConfData oneConfData, double d, double d2);
    }

    private OneConfStore() {
        super("framework_oneconf");
        this.f36864b = LoggerFactory.getLogger(f36862a);
        this.f36866e = new ArrayList();
        this.f36867f = null;
        this.f36868g = new OneConfData();
        this.f36867f = SystemUtils.getSharedPreferences(DIDIApplicationDelegate.getAppContext(), "framework_oneconf", 0);
    }

    public static OneConfStore getInstance() {
        if (f36863d == null) {
            f36863d = new OneConfStore();
        }
        return f36863d;
    }

    /* renamed from: a */
    private RpcServiceFactory m26109a(Context context) {
        if (this.f36865c == null) {
            this.f36865c = new RpcServiceFactory(context);
        }
        return this.f36865c;
    }

    /* renamed from: a */
    private void m26111a(int i) {
        this.f36867f.edit().putInt("city_id", i).apply();
    }

    /* renamed from: b */
    private void m26114b(int i) {
        this.f36867f.edit().putInt("country_id", i).apply();
    }

    public int getCityId() {
        if (this.f36868g.cityId != -1) {
            return this.f36868g.cityId;
        }
        return this.f36867f.getInt("city_id", this.f36868g.cityId);
    }

    public int getCountryId() {
        if (this.f36868g.countryId != -1) {
            return this.f36868g.countryId;
        }
        return this.f36867f.getInt("country_id", this.f36868g.countryId);
    }

    public double getLatitude() {
        return this.f36872k;
    }

    public double getLongitude() {
        return this.f36873l;
    }

    public void getOneConf(Context context, double d, double d2) {
        final double d3 = d;
        final double d4 = d2;
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABLITY_CLIENT_GCONF).setCallback(new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
                OneConfStore.this.m26113a(jsonObject.toString(), d3, d4);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26113a(String str, double d, double d2) {
        this.f36868g.parse(str);
        m26111a(this.f36868g.cityId);
        m26114b(this.f36868g.countryId);
        m26110a(d, d2, this.f36868g.countryId, this.f36868g.cityId);
        synchronized (this.f36866e) {
            for (int i = 0; i < this.f36866e.size(); i++) {
                this.f36866e.get(i).onChanged(this.f36868g, d, d2);
            }
        }
    }

    /* renamed from: a */
    private void m26110a(double d, double d2, int i, int i2) {
        this.f36872k = d;
        this.f36873l = d2;
        if (this.f36870i != i || this.f36871j != i2) {
            this.f36870i = i;
            this.f36871j = i2;
            Address address = new Address();
            address.setCityId(i2);
            address.setLatitude(d);
            address.setLongitude(d2);
            dispatchEvent(new CityChangeEvent(CityChangeEvent.EVENT_GUARANA_CITY_CHANGE, address));
        }
    }

    public void addOneConfChangeListener(OneConfConfigChangeListener oneConfConfigChangeListener) {
        synchronized (this.f36866e) {
            this.f36866e.add(oneConfConfigChangeListener);
        }
    }

    public void removeOneConfChangeListener(OneConfConfigChangeListener oneConfConfigChangeListener) {
        synchronized (this.f36866e) {
            this.f36866e.remove(oneConfConfigChangeListener);
        }
    }
}
