package com.didi.drouter.loader.host;

import androidx.core.util.Consumer;
import com.didi.drouter.service.IFeatureMatcher;
import com.didi.drouter.store.MetaLoader;
import com.didi.drouter.store.RouterMeta;
import com.didi.nova.kyc.jumio.spi.JumioServiceProviderImp;
import com.didi.payment.base.screenshot.IRegisterScreenShotFirstListener;
import com.didi.payment.commonsdk.spi.JumioServiceProvider;
import com.didi.payment.wallet.global.risk.RiskScreenShotImpl;
import com.didi.payment.wallet_ui.IWalletUI;
import com.didi.wallet.dimina.WalletDiminaImpl;
import com.pay99.diff_passenger.PassengerUIImpl;
import com.wallet.flutter.wallet_flutter.http.WalletFlutterHttpPluginImpl;
import java.util.Map;
import java.util.Set;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;

public class ServiceLoader extends MetaLoader {
    @Override
    public void load(Map map) {
        put((Class<?>) Consumer.class, RouterMeta.build(RouterMeta.SERVICE).assembleService(WalletDiminaImpl.class, "WalletDiminaImpl", (IFeatureMatcher<?>) null, 0, 0), (Map<Class<?>, Set<RouterMeta>>) map);
        put((Class<?>) IRegisterScreenShotFirstListener.class, RouterMeta.build(RouterMeta.SERVICE).assembleService(RiskScreenShotImpl.class, "", (IFeatureMatcher<?>) null, 0, 0), (Map<Class<?>, Set<RouterMeta>>) map);
        put((Class<?>) JumioServiceProvider.class, RouterMeta.build(RouterMeta.SERVICE).assembleService(JumioServiceProviderImp.class, "", (IFeatureMatcher<?>) null, 0, 0), (Map<Class<?>, Set<RouterMeta>>) map);
        put((Class<?>) IWalletUI.class, RouterMeta.build(RouterMeta.SERVICE).assembleService(PassengerUIImpl.class, "", (IFeatureMatcher<?>) null, 0, 0), (Map<Class<?>, Set<RouterMeta>>) map);
        put((Class<?>) FlutterPlugin.class, RouterMeta.build(RouterMeta.SERVICE).assembleService(WalletFlutterHttpPluginImpl.class, "WalletFlutterHttpPluginImpl", (IFeatureMatcher<?>) null, 0, 0), (Map<Class<?>, Set<RouterMeta>>) map);
    }
}
