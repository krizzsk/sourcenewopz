package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.adapt.MapUtil;
import rui.config.RConfigConstants;

public class BitmapFormater {
    public static final int FORMAT_ASSET = 2;
    public static final int FORMAT_BITMAP = 7;
    public static final int FORMAT_DEFAULT = 5;
    public static final int FORMAT_DEFAULT_F = 6;
    public static final int FORMAT_FILE = 3;
    public static final int FORMAT_NONE = -1;
    public static final int FORMAT_PATH = 4;
    public static final int FORMAT_RESOURCE = 1;

    /* renamed from: a */
    private static final String f24458a = "marker_default.png";

    /* renamed from: b */
    private int f24459b = -1;

    /* renamed from: c */
    private int f24460c = -1;

    /* renamed from: d */
    private String f24461d = "";

    /* renamed from: e */
    private String f24462e = "";

    /* renamed from: f */
    private String f24463f = "";

    /* renamed from: g */
    private float f24464g = -1.0f;

    /* renamed from: h */
    private Bitmap f24465h = null;

    /* renamed from: i */
    private String f24466i = null;

    /* renamed from: a */
    private String m17481a(float f) {
        if (f < 30.0f) {
            return "RED.png";
        }
        if (f >= 30.0f && f < 60.0f) {
            return "ORANGE.png";
        }
        if (f >= 60.0f && f < 120.0f) {
            return "YELLOW.png";
        }
        if (f >= 120.0f && f < 180.0f) {
            return "GREEN.png";
        }
        if (f >= 180.0f && f < 210.0f) {
            return "CYAN.png";
        }
        if (f >= 210.0f && f < 240.0f) {
            return "AZURE.png";
        }
        if (f >= 240.0f && f < 270.0f) {
            return "BLUE.png";
        }
        if (f >= 270.0f && f < 300.0f) {
            return "VIOLET.png";
        }
        if (f >= 300.0f && f < 330.0f) {
            return "MAGENTAV.png";
        }
        if (f >= 330.0f) {
            return "ROSE.png";
        }
        return null;
    }

    public BitmapFormater(int i) {
        this.f24459b = i;
    }

    public String getBitmapId() {
        return this.f24466i;
    }

    /* renamed from: a */
    private String m17482a(Bitmap bitmap) {
        String obj = bitmap.toString();
        if (obj == null) {
            obj = "";
        }
        String replace = obj.replace("android.graphics.Bitmap@", "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return (replace + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.hashCode() + RConfigConstants.KEYWORD_COLOR_SIGN + width + RConfigConstants.KEYWORD_COLOR_SIGN + height + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getRowBytes()) + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getPixel(width / 2, height / 2);
    }

    public Bitmap getBitmap(Context context) {
        Bitmap bitmap = this.f24465h;
        if (bitmap != null) {
            this.f24466i = m17482a(bitmap);
            return this.f24465h;
        } else if (context == null) {
            return null;
        } else {
            switch (this.f24459b) {
                case 1:
                    this.f24466i = "res_" + this.f24460c;
                    if (MapUtil.bimMapCach != null) {
                        this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                    }
                    if (this.f24465h == null) {
                        this.f24465h = MapUtil.decodeBitmapFromRes(context, this.f24460c);
                        if (!(MapUtil.bimMapCach == null || this.f24465h == null)) {
                            MapUtil.bimMapCach.put(this.f24466i, this.f24465h);
                            break;
                        }
                    }
                    break;
                case 2:
                    this.f24466i = "asset_" + this.f24461d;
                    if (MapUtil.bimMapCach != null) {
                        this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                    }
                    if (this.f24465h == null) {
                        Bitmap bimpaFromAsset2 = MapUtil.getBimpaFromAsset2(context, this.f24461d);
                        this.f24465h = bimpaFromAsset2;
                        if (bimpaFromAsset2 == null) {
                            Bitmap bitmapFromAsset = MapUtil.getBitmapFromAsset(context, this.f24461d);
                            this.f24465h = bitmapFromAsset;
                            if (bitmapFromAsset != null) {
                                this.f24465h = MapUtil.adaptFromXhResource(bitmapFromAsset);
                            }
                        }
                        if (!(MapUtil.bimMapCach == null || this.f24465h == null)) {
                            MapUtil.bimMapCach.put(this.f24466i, this.f24465h);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.f24466i = "file_" + this.f24462e;
                    if (MapUtil.bimMapCach != null) {
                        this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                    }
                    if (this.f24465h == null) {
                        this.f24465h = MapUtil.decodeBitmapFromFile(context, this.f24462e);
                        break;
                    }
                    break;
                case 4:
                    this.f24466i = "path_" + this.f24463f;
                    if (MapUtil.bimMapCach != null) {
                        this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                    }
                    if (this.f24465h == null) {
                        this.f24465h = MapUtil.decodeBitmapFromPath(this.f24463f);
                        if (!(MapUtil.bimMapCach == null || this.f24465h == null)) {
                            MapUtil.bimMapCach.put(this.f24466i, this.f24465h);
                            break;
                        }
                    }
                    break;
                case 5:
                    this.f24466i = "asset_marker_default.png";
                    if (MapUtil.bimMapCach != null) {
                        this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                    }
                    if (this.f24465h == null) {
                        this.f24465h = MapUtil.getBitmapFromAsset(context, f24458a);
                        if (!(MapUtil.bimMapCach == null || this.f24465h == null)) {
                            MapUtil.bimMapCach.put(this.f24466i, this.f24465h);
                            break;
                        }
                    }
                    break;
                case 6:
                    String a = m17481a(this.f24464g);
                    if (a != null) {
                        this.f24466i = "asset_" + a;
                        if (MapUtil.bimMapCach != null) {
                            this.f24465h = MapUtil.bimMapCach.get(this.f24466i);
                        }
                        if (this.f24465h == null) {
                            this.f24465h = MapUtil.getBitmapFromAsset(context, a);
                            if (!(MapUtil.bimMapCach == null || this.f24465h == null)) {
                                MapUtil.bimMapCach.put(this.f24466i, this.f24465h);
                                break;
                            }
                        }
                    }
                    break;
            }
            return this.f24465h;
        }
    }

    public void setResourceId(int i) {
        this.f24460c = i;
    }

    public void setAssetsName(String str) {
        this.f24461d = str;
    }

    public void setFileName(String str) {
        this.f24462e = str;
    }

    public void setPathName(String str) {
        this.f24463f = str;
    }

    public void setDefuatlColor(float f) {
        this.f24464g = f;
    }

    public void setBitmap(Bitmap bitmap) {
        this.f24465h = bitmap;
    }

    public int getFormateType() {
        return this.f24459b;
    }
}
