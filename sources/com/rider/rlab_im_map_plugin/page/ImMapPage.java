package com.rider.rlab_im_map_plugin.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl;
import com.rider.rlab_im_map_plugin.map.IMapReadyCallBack;
import com.rider.rlab_im_map_plugin.map.ImMapView;
import com.rider.rlab_im_map_plugin.tool.ImCommons;

public class ImMapPage extends Page {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f55957a = LoggerFactory.getLogger("ImMapPage");

    /* renamed from: b */
    private ImMapView f55958b;

    /* renamed from: c */
    private int f55959c;

    /* renamed from: d */
    private double f55960d;

    /* renamed from: e */
    private double f55961e;

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        m40300a();
        final long currentTimeMillis = System.currentTimeMillis();
        ImMapView imMapView = new ImMapView(viewGroup.getContext());
        this.f55958b = imMapView;
        imMapView.setMapData(this.f55959c, this.f55960d, this.f55961e);
        boolean isDowngradeMap = this.f55958b.isDowngradeMap();
        Logger logger = this.f55957a;
        logger.info("map downgrade toggle is " + isDowngradeMap, new Object[0]);
        if (isDowngradeMap) {
            this.f55957a.info("map downgrade true , no add mapView to parent", new Object[0]);
            return new View(viewGroup.getContext());
        }
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.addView(this.f55958b);
        this.f55958b.getMapAsync(new IMapReadyCallBack() {
            public void onMapReady() {
                ImMapPage.this.f55957a.info("map init ready", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                Logger a = ImMapPage.this.f55957a;
                a.debug("map init ready time cost:" + (currentTimeMillis - currentTimeMillis), new Object[0]);
            }
        });
        this.f55957a.debug("map add view success", new Object[0]);
        MapIMServiceImpl.iMapViewProvider.setMapView(this.f55958b);
        return frameLayout;
    }

    /* renamed from: a */
    private void m40300a() {
        Bundle args = getArgs();
        if (args != null) {
            this.f55959c = args.getInt(ImCommons.BUNDLE_TYPE);
            this.f55960d = args.getDouble("lat");
            this.f55961e = args.getDouble("lng");
        }
    }

    public void onCreate(View view) {
        super.onCreate(view);
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onCreate();
        }
    }

    public void onStart() {
        super.onStart();
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onStop();
        }
    }

    public void onResume() {
        super.onResume();
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onPause();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ImMapView imMapView = this.f55958b;
        if (imMapView != null) {
            imMapView.onDestroy();
        }
        MapIMServiceImpl.iMapViewProvider.setMapView((ImMapView) null);
    }
}
