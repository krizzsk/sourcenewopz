package com.didi.map.global.flow.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.ImageUtil;
import com.didi.map.global.flow.scene.order.confirm.normal.StartEndInfo;

public class StartEndMarkerModel {
    public float eAnchorU;
    public float eAnchorV;
    public LatLng end;
    public String endAddressName;
    public Bitmap endIcon;
    public float sAnchorU;
    public float sAnchorV;
    public LatLng start;
    public String startAddressName;
    public Bitmap startIcon;
    public String startPoiId;

    public StartEndMarkerModel() {
    }

    public StartEndMarkerModel(Context context, LatLng latLng, String str, int i, float f, float f2, LatLng latLng2, String str2, int i2, float f3, float f4) {
        this.start = latLng;
        this.startAddressName = str;
        this.startIcon = BitmapFactory.decodeStream(context.getResources().openRawResource(i));
        this.sAnchorU = f;
        this.sAnchorV = f2;
        this.end = latLng2;
        this.endAddressName = str2;
        this.endIcon = BitmapFactory.decodeStream(context.getResources().openRawResource(i2));
        this.eAnchorU = f3;
        this.eAnchorV = f4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StartEndMarkerModel(StartEndInfo startEndInfo, StartEndInfo startEndInfo2) {
        this(new LatLng(startEndInfo.addressInfo.latitude, startEndInfo.addressInfo.longitude), startEndInfo.isShowAddressName ? startEndInfo.addressInfo.displayName : "", startEndInfo.markerIcon, startEndInfo.anchorU, startEndInfo.anchorV, new LatLng(startEndInfo2.addressInfo.latitude, startEndInfo2.addressInfo.longitude), startEndInfo2.isShowAddressName ? startEndInfo2.addressInfo.displayName : "", startEndInfo2.markerIcon, startEndInfo2.anchorU, startEndInfo2.anchorV);
    }

    public StartEndMarkerModel(LatLng latLng, String str, Drawable drawable, float f, float f2, LatLng latLng2, String str2, Drawable drawable2, float f3, float f4) {
        this.start = latLng;
        this.startAddressName = str;
        this.startIcon = ImageUtil.Drawable2Bitmap(drawable);
        this.sAnchorU = f;
        this.sAnchorV = f2;
        this.end = latLng2;
        this.endAddressName = str2;
        this.endIcon = ImageUtil.Drawable2Bitmap(drawable2);
        this.eAnchorU = f3;
        this.eAnchorV = f4;
    }

    public StartEndMarkerModel(LatLng latLng, String str, String str2, Drawable drawable, float f, float f2, LatLng latLng2, String str3, Drawable drawable2, float f3, float f4) {
        this.start = latLng;
        this.startPoiId = str;
        this.startAddressName = str2;
        this.startIcon = ImageUtil.Drawable2Bitmap(drawable);
        this.sAnchorU = f;
        this.sAnchorV = f2;
        this.end = latLng2;
        this.endAddressName = str3;
        this.endIcon = ImageUtil.Drawable2Bitmap(drawable2);
        this.eAnchorU = f3;
        this.eAnchorV = f4;
    }

    public StartEndMarkerModel(LatLng latLng, String str, Bitmap bitmap, float f, float f2, LatLng latLng2, String str2, Bitmap bitmap2, float f3, float f4) {
        this.start = latLng;
        this.startAddressName = str;
        this.startIcon = bitmap;
        this.sAnchorU = f;
        this.sAnchorV = f2;
        this.end = latLng2;
        this.endAddressName = str2;
        this.endIcon = bitmap2;
        this.eAnchorU = f3;
        this.eAnchorV = f4;
    }

    public String toString() {
        return "StartEndMarkerModel{start=" + this.start + ", startAddressName='" + this.startAddressName + '\'' + ", startIcon=" + this.startIcon + ", sAnchorU=" + this.sAnchorU + ", sAnchorV=" + this.sAnchorV + ", end=" + this.end + ", endAddressName='" + this.endAddressName + '\'' + ", endIcon=" + this.endIcon + ", eAnchorU=" + this.eAnchorU + ", eAnchorV=" + this.eAnchorV + '}';
    }
}
