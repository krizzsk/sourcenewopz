package com.didi.map.global.component.dropoff.core;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.IDropOffComponentCallback;
import com.didi.map.global.component.dropoff.card.DropOffCardViewController;
import com.didi.map.global.component.dropoff.card.IDropOffCard;
import com.didi.map.global.component.dropoff.card.RichTextInfo;
import com.didi.map.global.component.dropoff.controller.BestViewController;
import com.didi.map.global.component.dropoff.controller.DiscountPoiController;
import com.didi.map.global.component.dropoff.core.DropOffContract;
import com.didi.map.global.component.dropoff.core.DropOffView;
import com.didi.map.global.component.dropoff.core.IDropOffMapListerer;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.DropOffPinView;
import com.didi.map.global.component.dropoff.pin.IDropOffPinView;
import com.didi.map.global.component.dropoff.recmarker.DropOffBubbleView;
import com.didi.map.global.component.dropoff.util.DropOffOmegaTracker;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.recmarker.IRecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerControllerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class DropOffView implements IDropOffCard.DropOffCardCallback, DropOffContract.View, IDropOffMapListerer {

    /* renamed from: a */
    private static final String f25480a = "DropOffView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f25481b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f25482c;

    /* renamed from: d */
    private DropOffCompParam f25483d;

    /* renamed from: e */
    private DropOffContract.Presenter f25484e;

    /* renamed from: f */
    private IDropOffComponentCallback f25485f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DropOffLocationInfo f25486g;

    /* renamed from: h */
    private DropOffAddress f25487h;

    /* renamed from: i */
    private boolean f25488i;

    /* renamed from: j */
    private boolean f25489j;

    /* renamed from: k */
    private IDropOffPinView f25490k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IRecMarkerController f25491l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DropOffCardViewController f25492m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f25493n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BestViewController f25494o;

    /* renamed from: p */
    private float f25495p;

    /* renamed from: q */
    private Padding f25496q;

    /* renamed from: r */
    private boolean f25497r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f25498s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public DiscountPoiController f25499t;

    /* renamed from: u */
    private ICollideStrategy f25500u;

    /* renamed from: v */
    private DiscountPoiController.WalkLineResultListener f25501v = new DiscountPoiController.WalkLineResultListener() {
        public void onGetEtaEda(boolean z, int i, int i2) {
            if (DropOffView.this.f25499t != null && DropOffView.this.f25498s && DropOffView.this.f25492m != null && !TextUtils.isEmpty(DropOffView.this.f25486g.sugPoi.xpanelDesc)) {
                String str = DropOffView.this.f25486g.sugPoi.xpanelDesc;
                String generateSubTitleRichJson = DropOffView.this.f25499t.generateSubTitleRichJson(str.replace("{{distance}}", String.valueOf(i2) + "m").replace("{{duration}}", String.valueOf(i)));
                DropOffUtils.LOGD("discountXXX desc = " + generateSubTitleRichJson);
                DropOffView.this.f25492m.setSubTitle(generateSubTitleRichJson);
                if (DropOffView.this.f25493n != null) {
                    DropOffView.this.f25493n.postDelayed(new Runnable() {
                        public final void run() {
                            DropOffView.C94811.this.lambda$onGetEtaEda$0$DropOffView$1();
                        }
                    }, 100);
                }
            }
        }

        public /* synthetic */ void lambda$onGetEtaEda$0$DropOffView$1() {
            if (DropOffView.this.f25494o != null && DropOffView.this.f25499t != null && DropOffView.this.f25493n != null) {
                DropOffView.this.f25494o.setMapPadding(new Padding(0, 0, 0, DropOffView.this.f25493n.getHeight() + DisplayUtils.dp2px(DropOffView.this.f25481b, 10.0f)));
                DropOffView.this.f25494o.discountAdjustMapCameraIncludesInternal(DropOffView.this.f25486g, DropOffView.this.f25499t.getMapElements());
            }
        }
    };

    /* renamed from: w */
    private double f25502w;

    /* renamed from: x */
    private boolean f25503x;

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18221d() {
    }

    /* renamed from: e */
    private int m18222e() {
        return 1;
    }

    public /* synthetic */ boolean onDoubleTap(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onDoubleTap(this, f, f2);
    }

    public /* synthetic */ boolean onFling(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onFling(this, f, f2);
    }

    public /* synthetic */ boolean onLongPress(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onLongPress(this, f, f2);
    }

    public /* synthetic */ boolean onSingleTap(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onSingleTap(this, f, f2);
    }

    public DropOffView(Context context, Map map, DropOffCompParam dropOffCompParam) {
        this.f25481b = context;
        this.f25482c = map;
        this.f25483d = dropOffCompParam;
        this.f25486g = dropOffCompParam.getLocationInfo();
        this.f25485f = dropOffCompParam.getComponentCallback();
        this.f25494o = new BestViewController(this.f25482c);
        DropOffPresenter dropOffPresenter = new DropOffPresenter(this, dropOffCompParam);
        this.f25484e = dropOffPresenter;
        dropOffPresenter.setContext(this.f25481b, this.f25482c);
        this.f25495p = dropOffCompParam.getZoom();
        int dp2px = DisplayUtils.dp2px(this.f25481b, 90.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f25481b, 45.0f);
        Map map2 = this.f25482c;
        if (map2 != null && map2.getMapVendor() == MapVendor.GOOGLE) {
            dp2px2 = DisplayUtils.dp2px(this.f25481b, 50.0f);
        }
        Padding padding = new Padding(dp2px, dp2px2, dp2px, dp2px2);
        this.f25496q = padding;
        this.f25494o.setInPadding(padding);
    }

    public void start() {
        DropOffLocationInfo dropOffLocationInfo = this.f25486g;
        if (dropOffLocationInfo != null && dropOffLocationInfo.sugPoi != null) {
            m18213b();
            m18218c();
            this.f25492m = new DropOffCardViewController(this.f25481b, this);
            if (this.f25486g.sugPoi.isDiscountPoi) {
                DiscountPoiController discountPoiController = new DiscountPoiController(this.f25481b, this.f25482c, this.f25486g);
                this.f25499t = discountPoiController;
                discountPoiController.setWalkLineResultListener(this.f25501v);
                this.f25499t.start();
                m18208a();
                this.f25494o.discountStart(this.f25486g);
            } else {
                getDropOffData(this.f25486g, false);
                this.f25494o.start(this.f25486g);
            }
            this.f25498s = true;
        }
    }

    /* renamed from: a */
    private void m18208a() {
        DropOffContract.Presenter presenter = this.f25484e;
        if (presenter != null) {
            presenter.getDiscountData();
        }
    }

    public void getDropOffData(DropOffLocationInfo dropOffLocationInfo, boolean z) {
        DropOffContract.Presenter presenter = this.f25484e;
        if (presenter != null) {
            presenter.startDataTask(dropOffLocationInfo, z);
        }
    }

    /* renamed from: b */
    private void m18213b() {
        Map map = this.f25482c;
        if (map != null) {
            map.addOnMapGestureListener(this);
            this.f25482c.addOnCameraChangeListener(this);
        }
    }

    /* renamed from: c */
    private void m18218c() {
        if (this.f25483d != null && this.f25482c != null) {
            m18232j();
            DropOffPinView dropOffPinView = new DropOffPinView(this.f25481b);
            this.f25490k = dropOffPinView;
            dropOffPinView.create(this.f25481b, this.f25482c);
            this.f25490k.setConfigParam(this.f25483d.getPinStyle());
            this.f25490k.add();
        }
    }

    public void adjustMapCamera(Padding padding) {
        this.f25494o.setMapPadding(padding);
        this.f25494o.setPinViewAttachListener(new BestViewController.PinViewAttachListener() {
            public final void onAttach(LatLng latLng) {
                DropOffView.this.m18209a(latLng);
            }
        });
        m18212a(!this.f25489j);
    }

    /* renamed from: a */
    private void m18212a(boolean z) {
        if (this.f25494o != null) {
            DropOffContract.Presenter presenter = this.f25484e;
            List<RpcPoi> list = null;
            RpcPoi adsorptionPoi = presenter != null ? presenter.getAdsorptionPoi() : null;
            DropOffContract.Presenter presenter2 = this.f25484e;
            if (presenter2 != null) {
                list = presenter2.getReconmmendRpcPois();
            }
            List<RpcPoi> list2 = list;
            if (!this.f25486g.sugPoi.isDiscountPoi || this.f25499t == null) {
                this.f25494o.adjustMapCameraInternal(z, adsorptionPoi, this.f25486g, list2, this.f25503x, this.f25495p, new BestViewer.IBestViewListener() {
                    public final void onFinished() {
                        DropOffView.this.m18221d();
                    }
                });
            } else {
                this.f25494o.discountAdjustMapCameraInternal(this.f25486g, new BestViewer.IBestViewListener() {
                    public final void onFinished() {
                        DropOffView.this.m18221d();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18209a(LatLng latLng) {
        IRecMarkerController iRecMarkerController = this.f25491l;
        if (iRecMarkerController != null) {
            ((RecMarkerController) iRecMarkerController).updateMarkerPinedState(latLng);
        }
    }

    public void onMapVisible(boolean z) {
        this.f25497r = z;
    }

    public void onDataLoading() {
        IDropOffPinView iDropOffPinView = this.f25490k;
        if (iDropOffPinView != null) {
            iDropOffPinView.startLoading(false);
        }
        DropOffCardViewController dropOffCardViewController = this.f25492m;
        if (dropOffCardViewController != null) {
            this.f25493n = dropOffCardViewController.onDataLoading();
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f25485f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onDropoffLoading(this.f25493n);
        }
    }

    /* renamed from: a */
    private String m18207a(DropOffAddress dropOffAddress) {
        if (dropOffAddress == null || dropOffAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(dropOffAddress.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    public void showCardView(DropOffAddress dropOffAddress) {
        if (this.f25492m != null) {
            this.f25493n = this.f25492m.getView(m18222e(), dropOffAddress);
            DropOffUtils.LOGD(" show card view ");
        }
    }

    public void refreshPinView(DropOffAddress dropOffAddress) {
        m18219c(dropOffAddress);
    }

    public void onAddressFetchResult(boolean z, DropOffAddress dropOffAddress) {
        m18215b(dropOffAddress);
        this.f25487h = dropOffAddress;
        IDropOffComponentCallback iDropOffComponentCallback = this.f25485f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onDropOffAddressChanged(z, dropOffAddress, this.f25493n);
        }
        DropOffUtils.LOGD(" notify Address = " + dropOffAddress);
    }

    /* renamed from: b */
    private void m18215b(DropOffAddress dropOffAddress) {
        DropOffAddress dropOffAddress2 = this.f25487h;
        if (dropOffAddress2 != null && dropOffAddress != null && dropOffAddress2.getAddress() != null && dropOffAddress.getAddress() != null) {
            double d = 0.0d;
            Map map = this.f25482c;
            if (map != null) {
                d = map.getCameraPosition().zoom;
            }
            DropOffOmegaTracker.trackMapDragged(this.f25487h, dropOffAddress, d);
        }
    }

    public void onCardItemClick(int i) {
        if (i == 0) {
            int i2 = 1;
            RpcPoi rpcPoi = null;
            DropOffContract.Presenter presenter = this.f25484e;
            if (presenter != null) {
                rpcPoi = presenter.getAdsorptionPoi();
            }
            if (this.f25489j) {
                i2 = rpcPoi != null ? 2 : 3;
            }
            DropOffAddress dropOffAddress = this.f25487h;
            if (!(dropOffAddress == null || dropOffAddress.getAddress() == null)) {
                DropOffOmegaTracker.trackConfirmClick(this.f25487h, i2);
            }
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f25485f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onCardViewOperation(i);
        }
        DropOffUtils.LOGD(" on card operation = " + i);
    }

    /* renamed from: c */
    private void m18219c(DropOffAddress dropOffAddress) {
        if (this.f25490k != null) {
            String a = dropOffAddress != null ? m18207a(dropOffAddress) : "";
            if (TextUtils.isEmpty(a)) {
                a = this.f25481b.getResources().getString(R.string.GRider_destination_Departure_point_lmkd);
            }
            this.f25490k.showText(a);
        }
    }

    public void showReconmmnedMarkers(List<RecPoint> list, RecPoint recPoint) {
        DropOffUtils.LOGD(" show rec markers ");
        m18211a(list, recPoint);
    }

    /* renamed from: a */
    private void m18211a(List<RecPoint> list, RecPoint recPoint) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && this.f25483d != null && this.f25482c != null && this.f25481b != null) {
            m18225f();
            RecMarkerController recMarkerController = new RecMarkerController();
            this.f25491l = recMarkerController;
            recMarkerController.create(this.f25482c.getContext(), this.f25482c);
            this.f25491l.setNeedShowInfoWindow(false);
            RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
            recMarkerControllerParam.list = list;
            recMarkerControllerParam.pinedPoint = recPoint;
            RecPointStyle recPointStyle = DropOffUtils.getRecPointStyle(this.f25481b, this.f25483d.getRecPointStyle());
            if (recPointStyle != null) {
                recMarkerControllerParam.icon = recPointStyle.icon;
                recMarkerControllerParam.selectedIcon = recPointStyle.selectedIcon;
            }
            recMarkerControllerParam.isClickable = true;
            recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener() {
                public final void onClick(IRecMarker iRecMarker) {
                    DropOffView.this.m18210a(iRecMarker);
                }
            };
            recMarkerControllerParam.isShowLabel = true;
            recMarkerControllerParam.labelView = new DropOffBubbleView();
            recMarkerControllerParam.labelDirection = 4;
            ICollideStrategy collideStrategyV1 = CollideStrategyFactory.getCollideStrategyV1(new IDMarkerContractV1() {
                public int getDefaultLabelPosition() {
                    return 4;
                }

                public /* synthetic */ List<Rect> getDisabledRect() {
                    return IDMarkerContractV1.CC.$default$getDisabledRect(this);
                }

                public int getEnableLabelPosition() {
                    return 68;
                }

                public /* synthetic */ int getHot(String str) {
                    return IDMarkerContractV1.CC.$default$getHot(this, str);
                }

                public /* synthetic */ boolean getIsLabelHideWhenPined() {
                    return IDMarkerContractV1.CC.$default$getIsLabelHideWhenPined(this);
                }

                public boolean isCanWork() {
                    return true;
                }

                public boolean isLabelDirectClockwise() {
                    return true;
                }

                public /* synthetic */ boolean isPined(String str) {
                    return IDMarkerContractV1.CC.$default$isPined(this, str);
                }

                public /* synthetic */ boolean isZoomConditionOnly() {
                    return IDMarkerContractV1.CC.$default$isZoomConditionOnly(this);
                }

                public Map getMap() {
                    return DropOffView.this.f25482c;
                }

                public void setLabelDirect(String str, int i) {
                    if (DropOffView.this.f25491l != null) {
                        DropOffView.this.f25491l.setLabelDirect(str, i);
                    }
                }

                public void setVisible(String str, boolean z) {
                    if (DropOffView.this.f25491l != null) {
                        DropOffView.this.f25491l.setVisible(str, z);
                    }
                }
            });
            this.f25500u = collideStrategyV1;
            recMarkerControllerParam.strategy = collideStrategyV1;
            this.f25491l.setConfigParam(recMarkerControllerParam);
            this.f25491l.add();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18210a(IRecMarker iRecMarker) {
        if (this.f25484e != null && !LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DropOffUtils.getMapCenterPoint(this.f25482c))) {
            RpcPoi neareatReconmmendPoi = this.f25484e.getNeareatReconmmendPoi(iRecMarker.getLocation());
            if (neareatReconmmendPoi == null) {
                DropOffUtils.LOGD(" rec click point == null ");
                return;
            }
            DropOffAddress dropOffAddress = this.f25484e.getDropOffAddress(neareatReconmmendPoi);
            this.f25503x = true;
            RpcPoi rpcPoi = neareatReconmmendPoi;
            this.f25494o.attachPinViewToAdsorptionPoi(rpcPoi, new LatLng(neareatReconmmendPoi.base_info.lat, neareatReconmmendPoi.base_info.lng), true, true, false, this.f25495p);
            showCardView(dropOffAddress);
            onAddressFetchResult(true, dropOffAddress);
            if (neareatReconmmendPoi != null && neareatReconmmendPoi.base_info != null) {
                DropOffOmegaTracker.trackRecMarkerClick(neareatReconmmendPoi);
            }
        }
    }

    /* renamed from: f */
    private void m18225f() {
        ICollideStrategy iCollideStrategy = this.f25500u;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f25500u = null;
        }
        IRecMarkerController iRecMarkerController = this.f25491l;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f25491l = null;
        }
    }

    public boolean onDown(float f, float f2) {
        Map map = this.f25482c;
        if (map == null) {
            return false;
        }
        this.f25502w = map.getCameraPosition().zoom;
        return false;
    }

    public boolean onUp(float f, float f2) {
        Map map = this.f25482c;
        if (map == null) {
            return false;
        }
        double d = map.getCameraPosition().zoom;
        if (Math.abs(this.f25502w - d) <= 0.30000001192092896d) {
            return false;
        }
        this.f25503x = true;
        LatLng mapCenterPoint = DropOffUtils.getMapCenterPoint(this.f25482c);
        if (mapCenterPoint == null) {
            return false;
        }
        DropOffOmegaTracker.trackMapZoomChanged(this.f25486g.sugPoi.poiId, mapCenterPoint, this.f25502w, d);
        return false;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        DropOffUtils.LOGD("camera position zoom = " + cameraPosition.zoom);
    }

    public boolean onScroll(float f, float f2) {
        IRecMarkerController iRecMarkerController = this.f25491l;
        if (iRecMarkerController != null) {
            iRecMarkerController.onMapScroll();
        }
        m18227g();
        this.f25488i = true;
        return false;
    }

    /* renamed from: g */
    private void m18227g() {
        IDropOffPinView iDropOffPinView = this.f25490k;
        if (iDropOffPinView != null) {
            iDropOffPinView.startDragging();
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f25485f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onStartDragging();
        }
    }

    public void onMapStable() {
        m18229h();
        this.f25488i = false;
    }

    /* renamed from: h */
    private void m18229h() {
        IRecMarkerController iRecMarkerController = this.f25491l;
        if (iRecMarkerController != null) {
            iRecMarkerController.onMapStable();
        }
        if (this.f25488i) {
            m18214b(DropOffUtils.getMapCenterPoint(this.f25482c));
            this.f25489j = true;
        }
    }

    /* renamed from: b */
    private void m18214b(LatLng latLng) {
        DropOffLocationInfo dropOffLocationInfo;
        if (!LatLngUtils.locateCorrect(latLng) || (dropOffLocationInfo = this.f25486g) == null || !this.f25497r) {
            m18219c(this.f25487h);
        } else if (LatLngUtils.isSameLatLng(dropOffLocationInfo.latLng, latLng)) {
            m18219c(this.f25487h);
        } else {
            this.f25486g.latLng = latLng;
            m18231i();
            DropOffCardViewController dropOffCardViewController = this.f25492m;
            if (dropOffCardViewController != null) {
                dropOffCardViewController.setSubTitle("");
            }
            getDropOffData(this.f25486g, true);
        }
    }

    /* renamed from: i */
    private void m18231i() {
        DiscountPoiController discountPoiController = this.f25499t;
        if (discountPoiController != null) {
            discountPoiController.destroy();
            this.f25499t = null;
        }
    }

    public void destroy() {
        this.f25488i = false;
        this.f25489j = false;
        this.f25503x = false;
        this.f25502w = 0.0d;
        m18233k();
        m18232j();
        m18225f();
        BestViewController bestViewController = this.f25494o;
        if (bestViewController != null) {
            bestViewController.destroy();
            this.f25494o = null;
        }
        m18231i();
        Map map = this.f25482c;
        if (map != null) {
            map.stopAnimation();
        }
        this.f25482c = null;
        this.f25487h = null;
        this.f25484e.destroy();
        this.f25484e = null;
        this.f25485f = null;
        this.f25498s = false;
    }

    /* renamed from: j */
    private void m18232j() {
        IDropOffPinView iDropOffPinView = this.f25490k;
        if (iDropOffPinView != null) {
            iDropOffPinView.destroy();
            this.f25490k = null;
        }
    }

    /* renamed from: k */
    private void m18233k() {
        Map map = this.f25482c;
        if (map != null) {
            map.removeOnMapGestureListener(this);
            this.f25482c.removeOnCameraChangeListener(this);
        }
    }
}
