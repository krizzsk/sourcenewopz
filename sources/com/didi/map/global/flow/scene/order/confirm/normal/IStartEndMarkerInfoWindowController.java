package com.didi.map.global.flow.scene.order.confirm.normal;

import android.view.View;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;
import com.didi.map.global.flow.scene.ISceneController;

public interface IStartEndMarkerInfoWindowController extends ISceneController {

    /* renamed from: com.didi.map.global.flow.scene.order.confirm.normal.IStartEndMarkerInfoWindowController$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$showEndMarkerInfoWindowAdapter(IStartEndMarkerInfoWindowController iStartEndMarkerInfoWindowController, View view, InfoWindow.Position position) {
            return false;
        }

        public static boolean $default$showStartMarkerInfoWindowAdapter(IStartEndMarkerInfoWindowController iStartEndMarkerInfoWindowController, View view, InfoWindow.Position position) {
            return false;
        }
    }

    void removeEndMarkerInfoWindow();

    void removeStartMarkerInfoWindow();

    void setOnEndMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnStartMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    boolean showEndMarkerInfoWindow(View view);

    boolean showEndMarkerInfoWindow(View view, InfoWindow.Position position);

    boolean showEndMarkerInfoWindowAdapter(View view, InfoWindow.Position position);

    boolean showStartMarkerInfoWindow(View view);

    boolean showStartMarkerInfoWindow(View view, InfoWindow.Position position);

    boolean showStartMarkerInfoWindowAdapter(View view, InfoWindow.Position position);
}
