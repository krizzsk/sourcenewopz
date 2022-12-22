package com.didi.flutter.nacho.p114ui;

import android.app.Activity;
import android.graphics.Bitmap;

/* renamed from: com.didi.flutter.nacho.ui.SnapshotFetcher */
public class SnapshotFetcher {

    /* renamed from: a */
    private static final SnapshotFetcher f21112a = new SnapshotFetcher();

    /* renamed from: b */
    private MapSnapshotFetcher f21113b;

    /* renamed from: com.didi.flutter.nacho.ui.SnapshotFetcher$MapSnapshotFetcher */
    public interface MapSnapshotFetcher {
        Bitmap getMapSnapshot(Activity activity);
    }

    public void setMapSnapshotFetcher(MapSnapshotFetcher mapSnapshotFetcher) {
        this.f21113b = mapSnapshotFetcher;
    }

    public static SnapshotFetcher getInstance() {
        return f21112a;
    }

    public Bitmap getMapSnapshot(Activity activity) {
        MapSnapshotFetcher mapSnapshotFetcher = this.f21113b;
        if (mapSnapshotFetcher == null) {
            return null;
        }
        return mapSnapshotFetcher.getMapSnapshot(activity);
    }
}
