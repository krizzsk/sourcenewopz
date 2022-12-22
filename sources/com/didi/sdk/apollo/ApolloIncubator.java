package com.didi.sdk.apollo;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.data.AppDataGenerator;
import com.didi.sdk.data.CityDataGenerator;
import com.didi.sdk.data.CitySelectDataGenerator;
import com.didi.sdk.data.DataLoadUtil;
import com.didi.sdk.data.Incubator;
import com.didi.sdk.data.LocationDataGenerator2;
import com.didi.sdk.data.NLogger;
import com.didi.sdk.data.UserDataGenerator;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IUserInfoDelegate;
import com.didichuxing.apollo.sdk.log.ApolloErrorLog;
import com.didichuxing.apollo.sdk.log.ApolloLog;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider(alias = "apollo", value = {Incubator.class})
public class ApolloIncubator implements Incubator {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public NLogger f35074a = NLogger.getNLogger("ApolloModule");

    public void init(Context context) {
        this.f35074a.debug("apollo init");
        ApolloDataGenerator apolloDataGenerator = (ApolloDataGenerator) DataLoadUtil.loadGenerator(ApolloDataGenerator.class);
        final UserDataGenerator userDataGenerator = (UserDataGenerator) DataLoadUtil.loadGenerator(UserDataGenerator.class);
        final LocationDataGenerator2 locationDataGenerator2 = (LocationDataGenerator2) DataLoadUtil.loadGenerator(LocationDataGenerator2.class);
        final CityDataGenerator cityDataGenerator = (CityDataGenerator) DataLoadUtil.loadGenerator(CityDataGenerator.class);
        final CitySelectDataGenerator citySelectDataGenerator = (CitySelectDataGenerator) DataLoadUtil.loadGenerator(CitySelectDataGenerator.class);
        final AppDataGenerator appDataGenerator = (AppDataGenerator) DataLoadUtil.loadGenerator(AppDataGenerator.class);
        if (apolloDataGenerator == null) {
            this.f35074a.error("please implementation ApolloDataGenerator");
        } else if (userDataGenerator == null) {
            this.f35074a.error("please implementation userDataGenerator");
        } else if (locationDataGenerator2 == null) {
            this.f35074a.error("please implementation locationDataGenerator2");
        } else if (cityDataGenerator == null) {
            this.f35074a.error("please implementation cityDataGenerator");
        } else if (citySelectDataGenerator == null) {
            this.f35074a.error("please implementation citySelectDataGenerator");
        } else if (appDataGenerator == null) {
            this.f35074a.error("please implementation appDataGenerator");
        } else {
            Apollo.setContext(context);
            Apollo.init(context);
            Apollo.setNamespace(apolloDataGenerator.getNameSpace());
            Apollo.setLogDelegate(new ILogDelegate() {
                public void saveLog(ApolloLog apolloLog) {
                    for (Map.Entry next : apolloLog.getLogEntrySet()) {
                        NLogger a = ApolloIncubator.this.f35074a;
                        a.debug("saveLog: " + ((String) next.getKey()) + "->" + ((String) next.getValue()));
                    }
                }

                public void saveErrorLog(ApolloErrorLog apolloErrorLog) {
                    NLogger a = ApolloIncubator.this.f35074a;
                    a.debug("saveErrorLog: " + apolloErrorLog.getLogKey() + "|" + apolloErrorLog.getErrorMsg());
                }
            });
            NLogger nLogger = this.f35074a;
            nLogger.debug("getPhone: " + userDataGenerator.getPhone());
            final Context context2 = context;
            Apollo.setUserInfoDelegate(new IUserInfoDelegate() {
                public String getPhone() {
                    return userDataGenerator.getPhone();
                }

                public String getUid() {
                    return userDataGenerator.getUid();
                }

                public String getToken() {
                    return userDataGenerator.getToken();
                }

                public String getLatString() {
                    return locationDataGenerator2.getLat(context2) + "";
                }

                public String getLngString() {
                    return locationDataGenerator2.getLng(context2) + "";
                }

                public String getOrderCityId() {
                    return citySelectDataGenerator.getSelectCityID();
                }

                public String getLocationCityId() {
                    return cityDataGenerator.getCityID();
                }

                public String getLang() {
                    return appDataGenerator.getLang();
                }
            });
            Apollo.startup();
            Apollo.checkUpdate();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivityPaused(Activity activity) {
                    }

                    public void onActivityResumed(Activity activity) {
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStopped(Activity activity) {
                    }

                    public void onActivityStarted(Activity activity) {
                        if (activity.getClass().getName().equals("com.didi.sdk.app.MainActivityImpl")) {
                            ApolloIncubator.this.f35074a.debug("MainActivityStarted: apollo checkUpdate");
                            Apollo.checkUpdate();
                        }
                    }
                });
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.didi.sdk.location.changed");
            intentFilter.addAction("com.didi.sdk.city.changed");
            intentFilter.addAction("com.didi.sdk.language.changed");
            LocalBroadcastManager.getInstance(context).registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        NLogger a = ApolloIncubator.this.f35074a;
                        a.debug("receive broadcast and apollo update: " + intent.getAction());
                    }
                    Apollo.checkUpdate();
                }
            }, intentFilter);
        }
    }
}
