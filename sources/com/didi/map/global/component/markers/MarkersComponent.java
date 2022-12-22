package com.didi.map.global.component.markers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.ImageUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.LabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MarkersComponent implements IMarkersCompContract {

    /* renamed from: a */
    private Map f25971a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f25972b;

    /* renamed from: c */
    private List<IconLabelMarker> f25973c;

    /* renamed from: d */
    private MarkersCompParams f25974d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnMarkerCompClickListener f25975e;

    public interface ImageNetWorkCallback {
        void onImageNetFails();

        void onImageNetSuccess(Bitmap bitmap);
    }

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        List<IconLabelMarker> list;
        this.f25971a = map;
        this.f25972b = context;
        this.f25973c = new ArrayList();
        MarkersCompParams markersCompParams = this.f25974d;
        if (markersCompParams != null) {
            List<MarkerModel> markerModels = markersCompParams.getMarkerModels();
            if (!CollectionUtil.isEmpty((Collection<?>) markerModels)) {
                for (MarkerModel next : markerModels) {
                    if (next != null) {
                        final IconLabelMarker a = m18464a(next);
                        if (!(a == null || (list = this.f25973c) == null)) {
                            list.add(a);
                        }
                        if (!TextUtils.isEmpty(next.getMarkerUrl())) {
                            final float urlIconScaleParam = next.getUrlIconScaleParam();
                            markerIconNetwork(next.getMarkerUrl(), new ImageNetWorkCallback() {
                                public void onImageNetFails() {
                                }

                                public void onImageNetSuccess(Bitmap bitmap) {
                                    Bitmap a;
                                    if (bitmap != null && a != null && (a = MarkersComponent.this.m18460a(bitmap, urlIconScaleParam)) != null) {
                                        a.setMarkerIcon(a);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    public void removeMarker(String str) {
        IconLabelMarker a = m18465a(str);
        if (a != null) {
            a.destory();
            List<IconLabelMarker> list = this.f25973c;
            if (list != null) {
                list.remove(a);
            }
        }
    }

    public void destroy() {
        List<IconLabelMarker> list = this.f25973c;
        if (list != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (IconLabelMarker destory : this.f25973c) {
                destory.destory();
            }
            this.f25973c.clear();
            this.f25973c = null;
        }
        this.f25974d = null;
        this.f25971a = null;
    }

    public void setConfigParam(MarkersCompParams markersCompParams) {
        this.f25974d = markersCompParams;
    }

    public List<Marker> getMarkers() {
        ArrayList arrayList = new ArrayList();
        List<IconLabelMarker> list = this.f25973c;
        if (list != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (IconLabelMarker next : this.f25973c) {
                if (next.isVisible()) {
                    arrayList.addAll(next.getMarkers());
                }
            }
        }
        return arrayList;
    }

    public Marker getIconMarkerById(String str) {
        IconLabelMarker a = m18465a(str);
        if (a != null) {
            return a.getIconMarker();
        }
        return null;
    }

    public Marker getLabelMarkerById(String str) {
        LabelMarker labelMarker;
        IconLabelMarker a = m18465a(str);
        if (a == null || (labelMarker = a.getLabelMarker()) == null) {
            return null;
        }
        return labelMarker.getMarker();
    }

    public List<Marker> getAllMarkers() {
        ArrayList arrayList = new ArrayList();
        List<IconLabelMarker> list = this.f25973c;
        if (list != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (IconLabelMarker markers : this.f25973c) {
                arrayList.addAll(markers.getMarkers());
            }
        }
        return arrayList;
    }

    public List<Marker> getMarkers(String str) {
        if (this.f25971a == null || this.f25972b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        IconLabelMarker a = m18465a(str);
        if (a != null) {
            arrayList.add(a.getIconMarker());
            if (a.getLabelMarker() != null) {
                arrayList.add(a.getLabelMarker().getMarker());
            }
        }
        return arrayList;
    }

    public void updateMarkerIcon(String str, Bitmap bitmap) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && bitmap != null) {
            a.setMarkerIcon(bitmap);
        }
    }

    public void updatePosition(String str, LatLng latLng) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && LatLngUtils.locateCorrect(latLng)) {
            a.setPosition(latLng);
        }
    }

    public void updateMarkerZindex(String str, int i) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateMarkerZindex(i);
        }
    }

    public void updateLabelZindex(String str, int i) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateLabelZindex(i);
        }
    }

    public void updateLabelSelected(String str, boolean z) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateLabelSelected(z);
        }
    }

    public int getMarkerZindex(String str) {
        IconLabelMarker a;
        if (this.f25971a == null || this.f25972b == null || (a = m18465a(str)) == null || a.getIconMarker() == null) {
            return 0;
        }
        return a.getIconMarker().getZIndex();
    }

    public int getLabelZindex(String str) {
        IconLabelMarker a;
        if (this.f25971a == null || this.f25972b == null || (a = m18465a(str)) == null || a.getLabelMarker() == null || a.getLabelMarker().getMarker() == null) {
            return 0;
        }
        return a.getLabelMarker().getMarker().getZIndex();
    }

    public void updateMarkerLabel(String str, String str2) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateLabel(str2);
        }
    }

    public void showMarkerInfoWindow(String str, View view, InfoWindow.Position position) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && a.getIconMarker() != null) {
            Marker iconMarker = a.getIconMarker();
            Map map = this.f25971a;
            InfoWindow buildInfoWindow = iconMarker.buildInfoWindow(map, map.getContext());
            if (position != null) {
                buildInfoWindow.setPosition(position);
            }
            buildInfoWindow.showInfoWindow(view);
        }
    }

    public void showMarkerInfoWindow(String str, View view) {
        showMarkerInfoWindow(str, view, (InfoWindow.Position) null);
    }

    public void setInfoWindowClickListener(String str, OnInfoWindowClickListener onInfoWindowClickListener) {
        IconLabelMarker a;
        InfoWindow infoWindow;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && a.getIconMarker() != null && (infoWindow = a.getIconMarker().getInfoWindow()) != null) {
            infoWindow.addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void setOnClickListener(OnMarkerCompClickListener onMarkerCompClickListener) {
        this.f25975e = onMarkerCompClickListener;
    }

    public void setAllMarkersVisible(boolean z) {
        List<IconLabelMarker> list = this.f25973c;
        if (list != null && !list.isEmpty()) {
            for (IconLabelMarker next : this.f25973c) {
                if (next != null) {
                    next.setVisible(z);
                }
            }
        }
    }

    public void setMarkerVisible(String str, boolean z) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && a.getIconMarker() != null) {
            a.getIconMarker().setVisible(z);
        }
    }

    public void setLabelVisible(String str, boolean z) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.setLabelVisible(z);
        }
    }

    public float getAlpha(String str) {
        IconLabelMarker a;
        if (this.f25971a == null || this.f25972b == null || (a = m18465a(str)) == null) {
            return 0.0f;
        }
        return a.getAlpha();
    }

    public LatLng getPosition(String str) {
        IconLabelMarker a;
        if (this.f25971a == null || this.f25972b == null || (a = m18465a(str)) == null || a.getIconMarker() == null) {
            return null;
        }
        return a.getIconMarker().getPosition();
    }

    public void setAlpha(String str, float f) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.setAlpha(f);
        }
    }

    public void updateMarkerLabelDirect(String str, int i) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateMarkerLabelDirect(i);
        }
    }

    public void updateLabelView(String str, ILabelView iLabelView) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.updateLabelView(iLabelView);
        }
    }

    public void hideMarkerInfoWindow(String str) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null && a.getIconMarker() != null) {
            a.getIconMarker().hideInfoWindow();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public IconLabelMarker m18465a(String str) {
        List<IconLabelMarker> list;
        if (!TextUtils.isEmpty(str) && (list = this.f25973c) != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            for (IconLabelMarker next : this.f25973c) {
                if (str.equals(next.getMarkId())) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private IconLabelMarker m18464a(MarkerModel markerModel) {
        int i;
        String str = null;
        if (this.f25971a == null || markerModel == null || markerModel.getPoint() == null) {
            return null;
        }
        int zOrder = markerModel.getZOrder() <= 0 ? 90 : markerModel.getZOrder();
        if (markerModel.getLabelZIndex() <= 0) {
            i = zOrder;
        } else {
            i = markerModel.getLabelZIndex();
        }
        IconLabelMarker.IconLabelMarkerInfo.Builder markerIconZIndex = new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(markerModel.getPoint()).markerIcon(markerModel.getMarkerIcon()).markerIconAnchorU(markerModel.getAnchorU()).markerIconAnchorV(markerModel.getAnchorV()).markerIconPadding(markerModel.getAnchorPadding()).markerIconZIndex(zOrder);
        if (!TextUtils.isEmpty(markerModel.getAddressName())) {
            str = markerModel.getAddressName();
        }
        IconLabelMarker create = new IconLabelMarker(this.f25971a, markerModel.getId(), this.f25972b).create(markerIconZIndex.label(str).labelZIndex(i).isClickable(markerModel.isClickable()).labelView(markerModel.getLabelView()).labelDirection(markerModel.getLabelDirection()).isLabelSelected(markerModel.isLabelSelected()).labelAnchorPadding(markerModel.getLabelAnchorPadding()).strategy(markerModel.getStrategy()).build());
        create.setOnClickListener(new IconLabelMarker.IconLabelMarkerClickListener() {
            public boolean onClick(IconLabelMarker iconLabelMarker) {
                if (MarkersComponent.this.f25975e == null || iconLabelMarker == null) {
                    return false;
                }
                MarkersComponent.this.f25975e.onClick(iconLabelMarker.getMarkId());
                return false;
            }
        });
        return create;
    }

    public void changeMarkerIcon(final String str, String str2, final float f, ImageNetWorkCallback imageNetWorkCallback) {
        if (TextUtils.isEmpty(str) || this.f25972b == null) {
            return;
        }
        if (imageNetWorkCallback == null) {
            markerIconNetwork(str2, new ImageNetWorkCallback() {
                public void onImageNetFails() {
                }

                public void onImageNetSuccess(Bitmap bitmap) {
                    Bitmap a;
                    IconLabelMarker a2 = MarkersComponent.this.m18465a(str);
                    if (bitmap != null && a2 != null && (a = MarkersComponent.this.m18460a(bitmap, f)) != null) {
                        a2.setMarkerIcon(a);
                    }
                }
            });
        } else {
            markerIconNetwork(str2, imageNetWorkCallback);
        }
    }

    public int getMarkerLabelDirect(String str) {
        IconLabelMarker a;
        if (this.f25971a == null || this.f25972b == null || (a = m18465a(str)) == null) {
            return 0;
        }
        return a.getMarkerLabelDirect();
    }

    public void addMarkerLabel(String str, MarkerModel markerModel) {
        IconLabelMarker a;
        if (this.f25971a != null && this.f25972b != null && (a = m18465a(str)) != null) {
            a.addMarkerLabel(new IconLabelMarker.IconLabelMarkerInfo.Builder().label(!TextUtils.isEmpty(markerModel.getAddressName()) ? markerModel.getAddressName() : null).labelZIndex(markerModel.getLabelZIndex()).labelView(markerModel.getLabelView()).labelDirection(markerModel.getLabelDirection()).isLabelSelected(markerModel.isLabelSelected()).labelAnchorPadding(markerModel.getLabelAnchorPadding()).strategy(markerModel.getStrategy()).build());
        }
    }

    public IconLabelMarker addNewMarkerToComponent(final MarkerModel markerModel, ImageNetWorkCallback imageNetWorkCallback) {
        if (markerModel == null) {
            return null;
        }
        final IconLabelMarker a = m18464a(markerModel);
        if (this.f25973c == null) {
            this.f25973c = new ArrayList();
        }
        if (a != null) {
            this.f25973c.add(a);
        }
        if (!TextUtils.isEmpty(markerModel.getMarkerUrl())) {
            if (imageNetWorkCallback == null) {
                markerIconNetwork(markerModel.getMarkerUrl(), new ImageNetWorkCallback() {
                    public void onImageNetFails() {
                    }

                    public void onImageNetSuccess(Bitmap bitmap) {
                        IconLabelMarker iconLabelMarker;
                        MarkerModel markerModel;
                        Bitmap a;
                        if (bitmap != null && (iconLabelMarker = a) != null && iconLabelMarker.getIconMarker() != null && (markerModel = markerModel) != null && (a = MarkersComponent.this.m18460a(bitmap, markerModel.getUrlIconScaleParam())) != null) {
                            a.getIconMarker().setIcon(MarkersComponent.this.f25972b, BitmapDescriptorFactory.fromBitmap(a));
                        }
                    }
                });
            } else {
                markerIconNetwork(markerModel.getMarkerUrl(), imageNetWorkCallback);
            }
        } else if (imageNetWorkCallback != null) {
            imageNetWorkCallback.onImageNetFails();
        }
        return a;
    }

    public void markerIconNetwork(String str, final ImageNetWorkCallback imageNetWorkCallback) {
        try {
            Glide.with(this.f25972b).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    ImageNetWorkCallback imageNetWorkCallback = imageNetWorkCallback;
                    if (imageNetWorkCallback != null) {
                        imageNetWorkCallback.onImageNetSuccess(bitmap);
                    }
                }

                public void onLoadCleared(Drawable drawable) {
                    ImageNetWorkCallback imageNetWorkCallback = imageNetWorkCallback;
                    if (imageNetWorkCallback != null) {
                        imageNetWorkCallback.onImageNetFails();
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m18460a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        if (f == 0.0f || f == 1.0f) {
            return bitmap;
        }
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }
}
