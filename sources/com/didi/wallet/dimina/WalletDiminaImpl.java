package com.didi.wallet.dimina;

import android.app.Application;
import android.content.Context;
import androidx.core.util.Consumer;
import com.didi.dimina.config.national.InternationalConfig;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.starbox.StarBox;
import com.didi.payment.base.utils.PayBaseConfigUtil;
import com.didi.wallet.dimina.rpc.WalletPreLoad;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/wallet/dimina/WalletDiminaImpl;", "Landroidx/core/util/Consumer;", "", "()V", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "accept", "", "t", "callbackFromH5", "json", "Lorg/json/JSONObject;", "getWalletDiminaConfig", "Lcom/didi/dimina/container/secondparty/Dimina4Di$Config;", "init", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletDiminaImpl.kt */
public final class WalletDiminaImpl implements Consumer<Object> {

    /* renamed from: a */
    private Application f45171a;

    public final Application getApplication() {
        return this.f45171a;
    }

    public final void setApplication(Application application) {
        this.f45171a = application;
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f45171a = application;
        MMKV.initialize((Context) application);
        Dimina4Di.init(m32448a(application));
        Dimina.registerJSModule(DiminaWalletModule.class);
        new WalletPreLoad().launchPreLoad(application);
    }

    /* renamed from: a */
    private final Dimina4Di.Config m32448a(Application application) {
        Dimina4Di.Config config = new Dimina4Di.Config();
        config.setApp(application);
        config.setIsDebug(PayBaseConfigUtil.isDebugMode());
        config.getAdapterConfig().setRegionConfigService(new InternationalConfig());
        config.setStarBoxAppId("dd23110d502e086efa");
        config.setJsSdkId("923888");
        config.setPckManagerHostDomain("https://pkg-dimina.didiglobal.com");
        return config;
    }

    /* renamed from: a */
    private final void m32449a(JSONObject jSONObject) {
        DiminaWalletModule.callbackFromH5(jSONObject);
    }

    public void accept(Object obj) {
        Application application;
        if (obj instanceof Application) {
            init((Application) obj);
        } else if (obj instanceof JSONObject) {
            m32449a((JSONObject) obj);
        } else if ((obj instanceof Integer) && Intrinsics.areEqual(obj, (Object) 1) && (application = this.f45171a) != null) {
            StarBox.init(application);
        }
    }
}
