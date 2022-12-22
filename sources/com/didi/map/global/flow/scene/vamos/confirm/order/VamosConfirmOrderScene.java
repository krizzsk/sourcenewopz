package com.didi.map.global.flow.scene.vamos.confirm.order;

import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.line.pax.commonline.CommonLineParam;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.order.confirm.normal.IStartEndMarkerInfoWindowController;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;
import com.didi.map.sdk.env.CacheKey;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.PointType;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.CallFrom;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@IScene.Scene(mo74615id = 2003)
public class VamosConfirmOrderScene extends PageScene<VamosConfirmOrderSceneParam> implements IVamosConfirmOrderController {
    public static final String ID_MARKER_END = "id_marker_end";
    public static final String ID_MARKER_START = "id_marker_start";
    public static final int ZINDEX_LINE = 100;

    /* renamed from: a */
    private CommonLineManager f27086a;

    /* renamed from: b */
    private MarkersComponent f27087b;

    /* renamed from: c */
    private final int f27088c = 51;

    /* renamed from: d */
    private final int f27089d = 50;

    public void onPause() {
    }

    public void onResume() {
    }

    public /* synthetic */ boolean showEndMarkerInfoWindowAdapter(View view, InfoWindow.Position position) {
        return IStartEndMarkerInfoWindowController.CC.$default$showEndMarkerInfoWindowAdapter(this, view, position);
    }

    public /* synthetic */ boolean showStartMarkerInfoWindowAdapter(View view, InfoWindow.Position position) {
        return IStartEndMarkerInfoWindowController.CC.$default$showStartMarkerInfoWindowAdapter(this, view, position);
    }

    public VamosConfirmOrderScene(VamosConfirmOrderSceneParam vamosConfirmOrderSceneParam, MapViewHolder mapViewHolder) {
        super(vamosConfirmOrderSceneParam, mapViewHolder);
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        SystemUtils.log(3, "sfs", "VamosConfirmOrderScene enter()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.confirm.order.VamosConfirmOrderScene", 67);
        m19138a();
        m19140b();
    }

    /* renamed from: a */
    private void m19138a() {
        if (this.mParam != null && getMap() != null) {
            ArrayList arrayList = new ArrayList();
            if (startEndInfoConvertToModel(((VamosConfirmOrderSceneParam) this.mParam).getStartInfo(), "id_marker_start", 51) != null) {
                arrayList.add(startEndInfoConvertToModel(((VamosConfirmOrderSceneParam) this.mParam).getStartInfo(), "id_marker_start", 51));
            }
            if (startEndInfoConvertToModel(((VamosConfirmOrderSceneParam) this.mParam).getEndInfo(), "id_marker_end", 50) != null) {
                arrayList.add(startEndInfoConvertToModel(((VamosConfirmOrderSceneParam) this.mParam).getEndInfo(), "id_marker_end", 50));
            }
            this.f27087b = new MarkersComponent();
            this.f27087b.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f27087b.create(getContext(), getMap());
        }
    }

    public MarkerModel startEndInfoConvertToModel(StartEndInfo startEndInfo, String str, int i) {
        if (startEndInfo == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        markerModel.setId(str);
        markerModel.setPoint(new LatLng(startEndInfo.addressInfo.latitude, startEndInfo.addressInfo.longitude));
        markerModel.setAnchorU(startEndInfo.anchorU);
        markerModel.setAnchorV(startEndInfo.anchorV);
        markerModel.setMarkerIcon(ImageUtil.Drawable2Bitmap(startEndInfo.markerIcon));
        markerModel.setZOrder(i);
        return markerModel;
    }

    /* renamed from: a */
    private LatLng m19136a(StartEndInfo startEndInfo) {
        if (startEndInfo == null || startEndInfo.addressInfo == null) {
            return null;
        }
        return new LatLng(startEndInfo.addressInfo.latitude, startEndInfo.addressInfo.longitude);
    }

    /* renamed from: b */
    private void m19140b() {
        int i;
        if (getMap() != null && getContext() != null && this.mParam != null) {
            if ((((VamosConfirmOrderSceneParam) this.mParam).isDrawLine() && m19136a(((VamosConfirmOrderSceneParam) this.mParam).getStartInfo()) != null) || m19136a(((VamosConfirmOrderSceneParam) this.mParam).getEndInfo()) != null) {
                CommonLineManager commonLineManager = this.f27086a;
                if (commonLineManager != null) {
                    commonLineManager.destroy();
                    this.f27086a = null;
                }
                if (((VamosConfirmOrderSceneParam) this.mParam).getLineColor() <= 0) {
                    i = getContext().getResources().getColor(R.color.global_driving_route_color);
                } else {
                    i = ((VamosConfirmOrderSceneParam) this.mParam).getLineColor();
                }
                LineParams lineParams = new LineParams((List<LatLng>) null, i, (int) ((VamosConfirmOrderSceneParam) this.mParam).getLineWidth());
                lineParams.setDidiColor(11);
                lineParams.setZIndex(100);
                LineExParam lineExParam = new LineExParam();
                lineExParam.setHasPulseAnim(false);
                lineExParam.setHasLineExtensionAnim(false);
                lineParams.setExParam(lineExParam);
                CommonLineParam commonLineParam = new CommonLineParam();
                commonLineParam.setLineParam(lineParams);
                commonLineParam.setStartPos(m19136a(((VamosConfirmOrderSceneParam) this.mParam).getStartInfo()));
                commonLineParam.setEndPos(m19136a(((VamosConfirmOrderSceneParam) this.mParam).getEndInfo()));
                commonLineParam.setCaller(CallFrom.ORDERROUTEAPI_VAMOS);
                CommonLineManager commonLineManager2 = new CommonLineManager(getContext(), getMap(), commonLineParam);
                this.f27086a = commonLineManager2;
                commonLineManager2.setListener(new OnLineDrawStatusListener() {
                    public /* synthetic */ void onLineDrawStart() {
                        OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                    }

                    public void onLineDrawFinished() {
                        if (VamosConfirmOrderScene.this.getMap() != null) {
                            VamosConfirmOrderScene vamosConfirmOrderScene = VamosConfirmOrderScene.this;
                            vamosConfirmOrderScene.doBestView(vamosConfirmOrderScene.mPadding);
                        }
                    }
                });
                this.f27086a.create();
            }
        }
    }

    public void leave() {
        super.leave();
        SystemUtils.log(3, "sfs", "VamosConfirmOrderScene leave()", (Throwable) null, "com.didi.map.global.flow.scene.vamos.confirm.order.VamosConfirmOrderScene", 171);
        MarkersComponent markersComponent = this.f27087b;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f27087b = null;
        }
        CommonLineManager commonLineManager = this.f27086a;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f27086a = null;
        }
    }

    public void doBestView(Padding padding) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            this.f27087b.setMarkerVisible("id_marker_end", true);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f27087b.getMarkers());
            CommonLineManager commonLineManager = this.f27086a;
            if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
                arrayList.addAll(this.f27086a.getBestViewElements());
            }
            if (this.mMapView != null) {
                List<IMapElement> myLocationMarkers = this.mMapView.getMyLocationMarkers();
                if (!CollectionUtil.isEmpty((Collection<?>) myLocationMarkers)) {
                    arrayList.addAll(myLocationMarkers);
                }
            }
            Padding padding2 = new Padding();
            padding2.left = DisplayUtils.dp2px(getContext(), 10.0f);
            padding2.right = DisplayUtils.dp2px(getContext(), 10.0f);
            BestViewer.doBestView(getMap(), true, (List<IMapElement>) arrayList, padding, padding2, (BestViewer.IBestViewListener) null);
        }
    }

    public boolean showStartMarkerInfoWindow(View view) {
        return showStartMarkerInfoWindow(view, (InfoWindow.Position) null);
    }

    public boolean showStartMarkerInfoWindow(View view, InfoWindow.Position position) {
        MarkersComponent markersComponent;
        if (!this.isSceneValid || (markersComponent = this.f27087b) == null) {
            return false;
        }
        markersComponent.showMarkerInfoWindow("id_marker_start", view, position);
        return true;
    }

    public void setOnStartMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f27087b) != null) {
            markersComponent.setInfoWindowClickListener("id_marker_start", new OnInfoWindowClickListener() {
                public final void onInfoWindowClick(Marker marker) {
                    VamosConfirmOrderScene.m19141b(OnInfoWindowClickListener.this, marker);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m19141b(OnInfoWindowClickListener onInfoWindowClickListener, Marker marker) {
        PaxEnvironment.getInstance().setPointType(PointType.START);
        PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, Page.START_BUBBLE.toString());
        onInfoWindowClickListener.onInfoWindowClick(marker);
    }

    public void removeStartMarkerInfoWindow() {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f27087b) != null) {
            markersComponent.hideMarkerInfoWindow("id_marker_start");
        }
    }

    public boolean showEndMarkerInfoWindow(View view) {
        return showEndMarkerInfoWindow(view, (InfoWindow.Position) null);
    }

    public boolean showEndMarkerInfoWindow(View view, InfoWindow.Position position) {
        MarkersComponent markersComponent;
        if (!this.isSceneValid || (markersComponent = this.f27087b) == null) {
            return false;
        }
        markersComponent.showMarkerInfoWindow("id_marker_end", view, position);
        return true;
    }

    public void setOnEndMarkerInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f27087b) != null) {
            markersComponent.setInfoWindowClickListener("id_marker_end", new OnInfoWindowClickListener() {
                public final void onInfoWindowClick(Marker marker) {
                    VamosConfirmOrderScene.m19139a(OnInfoWindowClickListener.this, marker);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m19139a(OnInfoWindowClickListener onInfoWindowClickListener, Marker marker) {
        PaxEnvironment.getInstance().setPointType(PointType.END);
        PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, Page.END_BUBBLE.toString());
        onInfoWindowClickListener.onInfoWindowClick(marker);
    }

    public void removeEndMarkerInfoWindow() {
        MarkersComponent markersComponent;
        if (this.isSceneValid && (markersComponent = this.f27087b) != null) {
            markersComponent.hideMarkerInfoWindow("id_marker_end");
        }
    }
}
