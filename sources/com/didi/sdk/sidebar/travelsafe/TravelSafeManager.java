package com.didi.sdk.sidebar.travelsafe;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.sdk.commonapi.Consts;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;

public class TravelSafeManager {

    /* renamed from: a */
    private static final String f37458a = "auto_share_travel_db";

    /* renamed from: b */
    private static final String f37459b = "auto_share_data";

    /* renamed from: c */
    private static TravelSafeManager f37460c = null;

    /* renamed from: d */
    private static final int f37461d = 0;

    /* renamed from: e */
    private static final int f37462e = 1;

    /* renamed from: f */
    private static final int f37463f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TravelSafetyState f37464g = new TravelSafetyState();

    /* renamed from: h */
    private Context f37465h = null;

    public interface IRefreshState {
        void dataRefresh(TravelSafetyState travelSafetyState);
    }

    private TravelSafeManager(Context context) {
        this.f37465h = context;
    }

    public static TravelSafeManager getInstance(Context context) {
        if (f37460c == null) {
            f37460c = new TravelSafeManager(context);
        }
        return f37460c;
    }

    public void init(IRefreshState iRefreshState) {
        m26618b(iRefreshState);
        m26616a(iRefreshState);
    }

    public TravelSafetyState getTravelSafeState() {
        return this.f37464g;
    }

    /* renamed from: a */
    private void m26616a(final IRefreshState iRefreshState) {
        m26615a(1, (RpcService.Callback<TripSecurityResponse>) new RpcService.Callback<TripSecurityResponse>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(TripSecurityResponse tripSecurityResponse) {
                if (tripSecurityResponse != null && tripSecurityResponse.errno == 0 && tripSecurityResponse.result != null) {
                    TravelSafetyState unused = TravelSafeManager.this.f37464g = tripSecurityResponse.result;
                    iRefreshState.dataRefresh(TravelSafeManager.this.f37464g);
                }
            }
        });
    }

    public void saveAndSync() {
        m26614a();
        m26617a((RpcService.Callback<TripSecurityResponse>) new RpcService.Callback<TripSecurityResponse>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(TripSecurityResponse tripSecurityResponse) {
            }
        });
    }

    /* renamed from: a */
    private void m26617a(RpcService.Callback<TripSecurityResponse> callback) {
        m26615a(0, callback);
    }

    /* renamed from: a */
    private void m26615a(int i, RpcService.Callback<TripSecurityResponse> callback) {
        TravelSafetyService travelSafetyService = (TravelSafetyService) new RpcServiceFactory(this.f37465h).newRpcService(TravelSafetyService.class, Consts.getCommonApiByEnviroment(this.f37465h));
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        if (token != null && !token.isEmpty()) {
            if (i == 0) {
                TravelSafetyState travelSafetyState = this.f37464g;
                if (travelSafetyState != null) {
                    travelSafetyService.syncAutoShareTravel(token, travelSafetyState.toJsonString(), i, callback);
                }
            } else if (i == 1) {
                travelSafetyService.syncAutoShareTravel(token, "", i, callback);
            }
        }
    }

    /* renamed from: b */
    private void m26618b(IRefreshState iRefreshState) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f37465h, f37458a, 0);
        TravelSafetyState fromJsonString = TravelSafetyState.fromJsonString(sharedPreferences.getString(f37459b + NationTypeUtil.getNationComponentData().getLoginInfo().getUid(), ""));
        if (fromJsonString != null) {
            this.f37464g = fromJsonString;
            iRefreshState.dataRefresh(fromJsonString);
        }
    }

    /* renamed from: a */
    private void m26614a() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f37465h, f37458a, 0);
        if (this.f37464g != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(f37459b + NationTypeUtil.getNationComponentData().getLoginInfo().getUid(), this.f37464g.toJsonString());
            edit.apply();
        }
    }
}
