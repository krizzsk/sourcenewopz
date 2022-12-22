package com.didi.soda.customer.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.util.NetworkUtil;
import com.didi.soda.customer.app.ServerConfigManager;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.RpcErrorConsumer;
import com.didi.soda.customer.foundation.rpc.entity.PreLoadEntity;
import com.didi.soda.customer.foundation.rpc.entity.ServerConfigEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.ThreadPoolManager;
import java.util.ArrayList;

public final class ServerConfigManager {

    public interface OnInitConfigCallback {
        void onRequestCompleted(ServerConfigEntity serverConfigEntity);
    }

    private ServerConfigManager() {
    }

    public static ServerConfigManager getInstance() {
        return Holder.INSTANCE;
    }

    public void initConfig(final OnInitConfigCallback onInitConfigCallback) {
        m28591a(onInitConfigCallback);
        LoginUtil.registerLoginOutListener(new LoginCallbacks.LoginOutListener(onInitConfigCallback) {
            public final /* synthetic */ ServerConfigManager.OnInitConfigCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void onSuccess() {
                ServerConfigManager.this.m28591a(this.f$1);
            }
        });
        LoginUtil.registerLoginListener(new LoginCallbacks.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                ServerConfigManager.this.m28591a(onInitConfigCallback);
            }
        });
    }

    /* renamed from: getServerConfig */
    public void m28591a(final OnInitConfigCallback onInitConfigCallback) {
        CustomerRpcManagerProxy.get().getServerConfig(new CustomerRpcCallback<ServerConfigEntity>(new RpcErrorConsumer.Empty()) {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                OnInitConfigCallback onInitConfigCallback = onInitConfigCallback;
                if (onInitConfigCallback != null) {
                    onInitConfigCallback.onRequestCompleted((ServerConfigEntity) null);
                }
            }

            public void onRpcSuccess(ServerConfigEntity serverConfigEntity, long j) {
                if (serverConfigEntity != null) {
                    ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).setData(serverConfigEntity);
                }
                OnInitConfigCallback onInitConfigCallback = onInitConfigCallback;
                if (onInitConfigCallback != null) {
                    onInitConfigCallback.onRequestCompleted(serverConfigEntity);
                }
            }
        });
    }

    public void initTabIn() {
        ThreadPoolManager.getInstance().execute(new Runnable() {
            public void run() {
                CustomerRpcManagerProxy.get().postTabIn((float) LocationUtil.getCurrentLat(), (float) LocationUtil.getCurrentLng(), "", new CustomerRpcCallback<Object>() {
                    public void onRpcFailure(SFRpcException sFRpcException) {
                    }

                    public void onRpcSuccess(Object obj, long j) {
                    }
                });
            }
        });
    }

    public void startPreLoad() {
        if (Build.VERSION.SDK_INT >= 19) {
            CustomerRpcManagerProxy.get().getH5PreLoad(new CustomerRpcCallback<PreLoadEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                }

                public void onRpcSuccess(PreLoadEntity preLoadEntity, long j) {
                    if (preLoadEntity != null && preLoadEntity.modules != null && !preLoadEntity.modules.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        for (PreLoadEntity.PreLoadModulesEntity next : preLoadEntity.modules) {
                            if (!(next == null || next.list == null || next.list.isEmpty())) {
                                for (PreLoadEntity.PreLoadItemEntity next2 : next.list) {
                                    if (!TextUtils.isEmpty(next2.url)) {
                                        arrayList.add(next2.url);
                                    }
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
                            AppConfig data = appConfigStorage.getData();
                            data.mPreloadList = arrayList;
                            appConfigStorage.setData(data);
                            ServerConfigManager.this.m28590a();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28590a() {
        if (NetworkUtil.isNetworkWifi(GlobalContext.getContext())) {
            FusionEngine.preloadResource(GlobalContext.getContext());
            return;
        }
        try {
            GlobalContext.getContext().registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    FusionEngine.preloadResource(context);
                }
            }, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final ServerConfigManager INSTANCE = new ServerConfigManager();

        private Holder() {
        }
    }
}
