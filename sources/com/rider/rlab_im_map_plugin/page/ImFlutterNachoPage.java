package com.rider.rlab_im_map_plugin.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.tool.LocaleUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Locale;
import p242io.flutter.embedding.android.BaseNachoSkeletonPage;
import p242io.flutter.embedding.engine.FlutterEngine;

public class ImFlutterNachoPage extends BaseNachoSkeletonPage {

    /* renamed from: a */
    private final Logger f55955a = LoggerFactory.getLogger("MapViewFlutterPage");

    /* renamed from: b */
    private final ViewGroup f55956b;

    public ImFlutterNachoPage(ViewGroup viewGroup) {
        this.f55956b = viewGroup;
    }

    public void onCreate(View view) {
        Bundle args = getArgs();
        if (args != null) {
            Bundle bundle = args.getBundle("params");
            if (bundle == null) {
                bundle = new Bundle();
            }
            args.putBundle("params", bundle);
        }
        super.onCreate(view);
        this.f55955a.debug(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        NavIMServiceImpl.iNavigationProvider.setPanelFrameTouchLayout((XPanelLayout) null);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
    }

    public NachoAction provideNachoAction() {
        return ImMapConfig.getInstance().getNachoAction();
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        View inflate = layoutInflater.inflate(R.layout.rider_im_flutter_page, (ViewGroup) null);
        XPanelLayout xPanelLayout = (XPanelLayout) inflate.findViewById(R.id.flutter_xpanel);
        xPanelLayout.setSodaMapView(this.f55956b);
        NavIMServiceImpl.iNavigationProvider.setPanelFrameTouchLayout(xPanelLayout);
        xPanelLayout.addView(createFlutterView(frameLayout.getContext()));
        xPanelLayout.setAlpha(0.995f);
        this.f55955a.debug("onInflateFlutterLayout", new Object[0]);
        return inflate;
    }

    public void updateLocale() {
        super.updateLocale();
        ArrayList arrayList = new ArrayList(1);
        Locale locale = ImMapConfig.getInstance().getLocale();
        if (locale != null) {
            arrayList.add(locale);
        } else {
            arrayList.add(LocaleUtils.getAppLocale(ImMapConfig.getInstance().getContext()));
        }
        ImMapConfig.getInstance().getNachoAction().getEngine().getLocalizationChannel().sendLocales(arrayList);
    }
}
