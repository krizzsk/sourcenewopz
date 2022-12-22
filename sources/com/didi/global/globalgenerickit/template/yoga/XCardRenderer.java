package com.didi.global.globalgenerickit.template.yoga;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.eventtracker.ImgLoadTracker;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didi.global.globalgenerickit.template.yoga.util.NinePatchBuilder;
import com.didi.global.globalgenerickit.template.yoga.view.Border;
import com.didi.global.globalgenerickit.template.yoga.view.Corner;
import com.didi.global.globalgenerickit.template.yoga.view.LottieView;
import com.didi.global.globalgenerickit.template.yoga.view.Patch;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelHorizontalScrollView;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelImageView;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelProgressBar;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelRoundColorDrawable;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelRoundDrawable;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelTextView;
import com.didi.global.globalgenerickit.template.yoga.view.XPanelYogaLayout;
import com.didi.global.globalgenerickit.template.yoga.view.recyclerview.XPanelHorizontalRecyclerView;
import com.didi.global.globalresource.utils.GRUtils;
import com.didi.sdk.apm.SystemUtils;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.soloader.SoLoader;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.taxis99.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.w3c.dom.Element;

public class XCardRenderer {
    public static final String TAG = "XCardRenderer";

    /* renamed from: a */
    GGKData f22231a;

    /* renamed from: b */
    String f22232b = "";

    /* renamed from: c */
    private Context f22233c;

    /* renamed from: d */
    private float f22234d;

    /* renamed from: e */
    private int f22235e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public EventListener f22236f;

    static class ContextLoader {
        private static float sDensity;

        ContextLoader() {
        }

        static synchronized void loadOnce(Context context) {
            synchronized (ContextLoader.class) {
                SoLoader.init(context, false);
                if (sDensity == 0.0f) {
                    sDensity = context.getResources().getDisplayMetrics().density;
                }
            }
        }

        static float getDensity() {
            return sDensity;
        }
    }

    public XCardRenderer(Context context, int i, GGKData gGKData) {
        ContextLoader.loadOnce(context);
        this.f22234d = ContextLoader.getDensity();
        this.f22233c = context;
        this.f22235e = i;
        this.f22231a = gGKData;
        String str = this.f22233c.getCacheDir() + File.separator + "cdn_cache";
        if (gGKData != null) {
            this.f22232b = str + File.separator + gGKData.getTemplate() + File.separator + KitHelper.MD5encode(gGKData.getCdn());
        }
        SystemUtils.log(3, "Yoga", "===GGK Yoga engine 旧的XML解析引擎==", (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.XCardRenderer", 104);
    }

    public void bindEventListener(EventListener eventListener) {
        this.f22236f = eventListener;
    }

    public View render(XCardNode xCardNode) {
        if (xCardNode == null) {
            return null;
        }
        try {
            Element element = xCardNode.reference;
            if (element == null) {
                return null;
            }
            if ("card".equals(element.getTagName())) {
                return m16065a(xCardNode, (ViewGroup) null);
            }
            throw new RuntimeException("root tagName must be card");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m16065a(com.didi.global.globalgenerickit.template.yoga.XCardNode r6, android.view.ViewGroup r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return r7
        L_0x0003:
            org.w3c.dom.Element r0 = r6.reference
            r1 = 0
            if (r0 == 0) goto L_0x008c
            java.lang.String r2 = r0.getTagName()
            java.lang.String r3 = "block"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x002e
            java.util.List<com.didi.global.globalgenerickit.template.yoga.XCardNode> r6 = r6.children
            if (r6 != 0) goto L_0x0019
            return r7
        L_0x0019:
            java.util.Iterator r6 = r6.iterator()
        L_0x001d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r6.next()
            com.didi.global.globalgenerickit.template.yoga.XCardNode r0 = (com.didi.global.globalgenerickit.template.yoga.XCardNode) r0
            r5.m16065a((com.didi.global.globalgenerickit.template.yoga.XCardNode) r0, (android.view.ViewGroup) r7)
            goto L_0x001d
        L_0x002d:
            return r7
        L_0x002e:
            java.lang.String r2 = r0.getTagName()
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r6.attributes
            com.didi.global.globalgenerickit.template.yoga.IParser r2 = r5.m16067a((java.lang.String) r2, (java.util.HashMap<java.lang.String, java.lang.Object>) r3)
            if (r2 != 0) goto L_0x003b
            return r7
        L_0x003b:
            android.view.View r3 = r2.getView()
            if (r7 != 0) goto L_0x0045
            r7 = r3
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L_0x0048
        L_0x0045:
            r7.addView(r3)
        L_0x0048:
            boolean r4 = r2 instanceof com.facebook.yoga.android.YogaLayout
            if (r4 == 0) goto L_0x0054
            r1 = r2
            com.facebook.yoga.android.YogaLayout r1 = (com.facebook.yoga.android.YogaLayout) r1
            com.facebook.yoga.YogaNode r1 = r1.getYogaNode()
            goto L_0x005f
        L_0x0054:
            boolean r4 = r7 instanceof com.facebook.yoga.android.YogaLayout
            if (r4 == 0) goto L_0x005f
            r1 = r7
            com.facebook.yoga.android.YogaLayout r1 = (com.facebook.yoga.android.YogaLayout) r1
            com.facebook.yoga.YogaNode r1 = r1.getYogaNodeForView(r3)
        L_0x005f:
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r6.attributes
            java.lang.String r0 = r0.getTagName()
            r5.m16077a((java.util.HashMap<java.lang.String, java.lang.Object>) r3, (com.didi.global.globalgenerickit.template.yoga.IParser) r2, (com.facebook.yoga.YogaNode) r1, (java.lang.String) r0)
            r2.onParseEnd()
            boolean r0 = r2 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0072
            r7 = r2
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
        L_0x0072:
            java.util.List<com.didi.global.globalgenerickit.template.yoga.XCardNode> r6 = r6.children
            if (r6 != 0) goto L_0x0077
            return r7
        L_0x0077:
            java.util.Iterator r6 = r6.iterator()
        L_0x007b:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x008b
            java.lang.Object r0 = r6.next()
            com.didi.global.globalgenerickit.template.yoga.XCardNode r0 = (com.didi.global.globalgenerickit.template.yoga.XCardNode) r0
            r5.m16065a((com.didi.global.globalgenerickit.template.yoga.XCardNode) r0, (android.view.ViewGroup) r7)
            goto L_0x007b
        L_0x008b:
            return r7
        L_0x008c:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "xcard node has no dom node mapping, its reference is null"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.XCardRenderer.m16065a(com.didi.global.globalgenerickit.template.yoga.XCardNode, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    private IParser m16067a(String str, HashMap<String, Object> hashMap) {
        if ("view".equals(str) || "card".equals(str)) {
            XPanelYogaLayout xPanelYogaLayout = new XPanelYogaLayout(this.f22233c);
            if ("card".equals(str)) {
                m16071a((View) xPanelYogaLayout, "", "card");
            }
            return xPanelYogaLayout;
        } else if ("image".equals(str)) {
            if (!TextUtils.isEmpty((String) hashMap.get("url"))) {
                return new XPanelImageView(this.f22233c);
            }
            return null;
        } else if ("label".equals(str)) {
            if (!TextUtils.isEmpty((String) hashMap.get("text"))) {
                return new XPanelTextView(this.f22233c);
            }
            return null;
        } else if ("progressBar".equals(str)) {
            return new XPanelProgressBar(this.f22233c);
        } else {
            if ("scrollview".equals(str)) {
                return new XPanelHorizontalScrollView(this.f22233c);
            }
            if ("scroll".equals(str)) {
                XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView = new XPanelHorizontalRecyclerView(this.f22233c);
                xPanelHorizontalRecyclerView.setDecorationPadding(this.f22235e);
                xPanelHorizontalRecyclerView.bindXCardListener(this.f22236f);
                return xPanelHorizontalRecyclerView;
            } else if ("lottie".equals(str)) {
                return new LottieView(this.f22233c);
            } else {
                throw new IllegalArgumentException("Unknown view type: " + str);
            }
        }
    }

    public void setLeftRightMargin(int i) {
        this.f22235e = i;
    }

    /* renamed from: a */
    private void m16077a(HashMap<String, Object> hashMap, IParser iParser, YogaNode yogaNode, String str) {
        IParser iParser2 = iParser;
        Corner corner = new Corner();
        Border border = new Border();
        Patch patch = new Patch();
        Iterator<Map.Entry<String, Object>> it = hashMap.entrySet().iterator();
        String str2 = "";
        String str3 = str2;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str7 = (String) next.getKey();
            String obj = next.getValue().toString();
            String str8 = obj;
            String str9 = str7;
            String str10 = str4;
            Iterator<Map.Entry<String, Object>> it2 = it;
            String str11 = str5;
            String str12 = str2;
            String str13 = str3;
            if (!m16078a(str7, obj, iParser.getView(), yogaNode, corner, border, str, patch)) {
                if ("selectedColor".equals(str9)) {
                    YogaNode yogaNode2 = yogaNode;
                    str5 = str11;
                    str6 = str8;
                } else if ("backgroundColor".equals(str9)) {
                    str4 = getRealColorString(str8);
                    YogaNode yogaNode3 = yogaNode;
                    str5 = str11;
                    str2 = str12;
                    str3 = str13;
                    it = it2;
                } else if ("url".equals(str9)) {
                    YogaNode yogaNode4 = yogaNode;
                    str5 = str8;
                } else if ("startColor".equals(str9)) {
                    YogaNode yogaNode5 = yogaNode;
                    str3 = XPanelProgressBar.getFullColorString(str8);
                    str5 = str11;
                    str4 = str10;
                    str2 = str12;
                    it = it2;
                } else if ("endColor".equals(str9)) {
                    YogaNode yogaNode6 = yogaNode;
                    str5 = str11;
                    str2 = str8;
                    str4 = str10;
                    str3 = str13;
                    it = it2;
                } else {
                    if (iParser2 instanceof XPanelProgressBar) {
                        ((XPanelProgressBar) iParser2).setStartColor(Color.parseColor(str10));
                    }
                    iParser2.parse(str9, str8, yogaNode);
                }
                str4 = str10;
                str2 = str12;
                str3 = str13;
                it = it2;
            } else {
                YogaNode yogaNode7 = yogaNode;
            }
            str5 = str11;
            str4 = str10;
            str2 = str12;
            str3 = str13;
            it = it2;
        }
        YogaNode yogaNode8 = yogaNode;
        String str14 = str4;
        String str15 = str5;
        String str16 = str2;
        String str17 = str3;
        if (str15 == null) {
            String str18 = str14;
            if (!border.isEmpty || str18 != null || (!TextUtils.isEmpty(str17) && !TextUtils.isEmpty(str16))) {
                Drawable a = m16064a(corner, str17, str16, str18);
                StateListDrawable stateListDrawable = new StateListDrawable();
                if (str6 != null) {
                    stateListDrawable.addState(new int[]{16842919}, new XPanelRoundColorDrawable(Color.parseColor(str6), corner));
                }
                stateListDrawable.addState(new int[0], a);
                IView iView = (IView) iParser2;
                iView.setBorder(border);
                iView.setCorner(corner);
                if ("default".equals(hashMap.get("shadow"))) {
                    iParser.getView().setBackground(this.f22233c.getResources().getDrawable(R.drawable.oc_x_panel_card_bg));
                } else {
                    iParser.getView().setBackground(stateListDrawable);
                }
            }
        } else if (iParser2 instanceof XPanelImageView) {
            m16076a(str15, (XPanelImageView) iParser.getView(), yogaNode, corner, border, patch);
        } else if (iParser2 instanceof LottieView) {
            File file = new File(this.f22232b);
            if (file.exists() && file.isDirectory()) {
                String resourceNameWithoutSuffix = GRUtils.getResourceNameWithoutSuffix(str15);
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    for (String str19 : list) {
                        String resourceRealName = GRUtils.getResourceRealName(str19);
                        if (!TextUtils.isEmpty(resourceNameWithoutSuffix) && resourceNameWithoutSuffix.equals(resourceRealName)) {
                            try {
                                try {
                                    ((LottieView) iParser2).setAnimation(new FileInputStream(this.f22232b + File.separator + str19), (String) null);
                                    return;
                                } catch (FileNotFoundException e) {
                                    e = e;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            ((LottieView) iParser2).setAnimationFromUrl(str15);
        }
    }

    /* renamed from: a */
    private Drawable m16064a(Corner corner, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new XPanelRoundColorDrawable(Color.parseColor(str3), corner);
        }
        int[] iArr = {getRealColor(str), getRealColor(str2)};
        float[] fArr = {corner.getLeftTopCorner(), corner.getLeftTopCorner(), corner.getRightTopCorner(), corner.getRightTopCorner(), corner.getRightBottomCorner(), corner.getRightBottomCorner(), corner.getLeftBottomCorner(), corner.getLeftBottomCorner()};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public static String getRealColorString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() == 8) {
            return "#0" + str.substring(1, str.length());
        } else if (str.length() != 2) {
            return str;
        } else {
            return "#0000000" + str.substring(1, str.length());
        }
    }

    public static int getRealColor(String str) {
        try {
            return Color.parseColor(getRealColorString(str));
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private void m16076a(String str, XPanelImageView xPanelImageView, YogaNode yogaNode, Corner corner, Border border, Patch patch) {
        String str2 = str;
        XPanelImageView xPanelImageView2 = xPanelImageView;
        if (this.f22233c != null && !TextUtils.isEmpty(str)) {
            xPanelImageView2.setTag(str);
            final Map<String, Object> mapFromAgentData = ImgLoadTracker.getMapFromAgentData(this.f22231a);
            final long currentTimeMillis = System.currentTimeMillis();
            ImgLoadTracker.loadUrlOmega(str, mapFromAgentData);
            if (!str.endsWith(".gif")) {
                File file = new File(this.f22232b);
                if (file.exists() && file.isDirectory()) {
                    String resourceNameWithoutSuffix = GRUtils.getResourceNameWithoutSuffix(str);
                    String[] list = file.list();
                    if (list != null && list.length > 0) {
                        for (String str3 : list) {
                            String resourceRealName = GRUtils.getResourceRealName(str3);
                            if (!TextUtils.isEmpty(resourceNameWithoutSuffix) && resourceNameWithoutSuffix.equals(resourceRealName)) {
                                Bitmap decodeFile = BitmapFactory.decodeFile(this.f22232b + File.separator + str3);
                                if (str.equals(xPanelImageView.getTag())) {
                                    m16069a(decodeFile, str, mapFromAgentData, currentTimeMillis, patch, xPanelImageView, corner, border);
                                    return;
                                }
                            }
                        }
                    }
                }
                final String str4 = str;
                final XPanelImageView xPanelImageView3 = xPanelImageView;
                final Patch patch2 = patch;
                final Corner corner2 = corner;
                final Border border2 = border;
                final YogaNode yogaNode2 = yogaNode;
                Glide.with(this.f22233c).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onLoadStarted(Drawable drawable) {
                        super.onLoadStarted(drawable);
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        if (str4.equals(xPanelImageView3.getTag())) {
                            XCardRenderer.this.m16069a(bitmap, str4, (Map<String, Object>) mapFromAgentData, currentTimeMillis, patch2, xPanelImageView3, corner2, border2);
                        }
                    }

                    public void onLoadFailed(Drawable drawable) {
                        ImgLoadTracker.loadUrlRetOmega(str4, mapFromAgentData, 1, currentTimeMillis);
                        yogaNode2.setHeight(0.0f);
                        yogaNode2.setWidth(0.0f);
                        yogaNode2.setMargin(YogaEdge.END, 0.0f);
                        yogaNode2.setMargin(YogaEdge.START, 0.0f);
                        yogaNode2.setMargin(YogaEdge.TOP, 0.0f);
                        yogaNode2.setMargin(YogaEdge.BOTTOM, 0.0f);
                        xPanelImageView3.setVisibility(8);
                    }
                });
                return;
            }
            ((RequestBuilder) Glide.with(this.f22233c).asGif().load(str).diskCacheStrategy(DiskCacheStrategy.DATA)).into((ImageView) xPanelImageView2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16069a(Bitmap bitmap, String str, Map<String, Object> map, long j, Patch patch, XPanelImageView xPanelImageView, Corner corner, Border border) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        ImgLoadTracker.loadUrlRetOmega(str, map, 0, j);
        if (patch == null || (patch.getUnScalableLeft() <= 0 && patch.getUnScalableTop() <= 0 && patch.getUnScalableRight() <= 0 && patch.getUnScalableBottom() <= 0)) {
            XPanelRoundDrawable fromBitmap = XPanelRoundDrawable.fromBitmap(bitmap, corner);
            fromBitmap.setBorderColor(border.getBorderColor());
            fromBitmap.setBorderWidth(border.getBorderWidth());
            xPanelImageView.setImageDrawable(fromBitmap);
            SystemUtils.log(3, "lxsLoadImgTimeNet", (System.currentTimeMillis() - j) + " : " + str, (Throwable) null, "com.didi.global.globalgenerickit.template.yoga.XCardRenderer", 458);
            return;
        }
        NinePatchBuilder ninePatchBuilder = new NinePatchBuilder(this.f22233c.getResources(), bitmap);
        if (patch.getUnScalableLeft() > 0 && patch.getUnScalableRight() > 0) {
            i2 = patch.getUnScalableLeft();
            i = patch.getUnScalableRight();
        } else if (patch.getUnScalableLeft() > 0) {
            i2 = patch.getUnScalableLeft();
            i = patch.getUnScalableLeft() + 1;
        } else {
            i2 = 0;
            i = 0;
        }
        if (patch.getUnScalableTop() > 0 && patch.getUnScalableBottom() > 0) {
            i4 = patch.getUnScalableTop();
            i3 = patch.getUnScalableBottom();
        } else if (patch.getUnScalableTop() > 0) {
            i4 = patch.getUnScalableTop();
            i3 = patch.getUnScalableTop() + 1;
        } else {
            i3 = 0;
        }
        if (i2 > 0) {
            ninePatchBuilder = ninePatchBuilder.addXRegionPoints(i2, i);
        }
        if (i4 > 0) {
            ninePatchBuilder = ninePatchBuilder.addYRegionPoints(i4, i3);
        }
        NinePatchDrawable build = ninePatchBuilder.build();
        xPanelImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        xPanelImageView.setImageDrawable(build);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m16078a(java.lang.String r4, java.lang.String r5, android.view.View r6, com.facebook.yoga.YogaNode r7, com.didi.global.globalgenerickit.template.yoga.view.Corner r8, com.didi.global.globalgenerickit.template.yoga.view.Border r9, java.lang.String r10, com.didi.global.globalgenerickit.template.yoga.view.Patch r11) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1866641174: goto L_0x01d3;
                case -1802976921: goto L_0x01c8;
                case -1546463658: goto L_0x01bd;
                case -1502084711: goto L_0x01b1;
                case -1458636154: goto L_0x01a5;
                case -1454606755: goto L_0x019a;
                case -1383228885: goto L_0x018f;
                case -1367605173: goto L_0x0184;
                case -1336101728: goto L_0x0178;
                case -1221029593: goto L_0x016d;
                case -1089145580: goto L_0x0161;
                case -1081309778: goto L_0x0156;
                case -887955139: goto L_0x014b;
                case -806339567: goto L_0x013e;
                case -506906468: goto L_0x0131;
                case -396426912: goto L_0x0124;
                case -278063181: goto L_0x0117;
                case -80043069: goto L_0x010b;
                case -62830230: goto L_0x00ff;
                case -39712434: goto L_0x00f2;
                case 3355: goto L_0x00e7;
                case 115029: goto L_0x00da;
                case 3145721: goto L_0x00ce;
                case 3317767: goto L_0x00c2;
                case 92909918: goto L_0x00b6;
                case 108511772: goto L_0x00a9;
                case 113126854: goto L_0x009d;
                case 143541095: goto L_0x0090;
                case 583595847: goto L_0x0084;
                case 593989127: goto L_0x0078;
                case 679766083: goto L_0x006b;
                case 722830999: goto L_0x005f;
                case 741115130: goto L_0x0053;
                case 747804969: goto L_0x0046;
                case 922786550: goto L_0x0039;
                case 941004998: goto L_0x002e;
                case 1970025654: goto L_0x0023;
                case 2032580477: goto L_0x0016;
                case 2086035242: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x01df
        L_0x000b:
            java.lang.String r0 = "margin-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 7
            goto L_0x01e0
        L_0x0016:
            java.lang.String r0 = "unscalable-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 28
            goto L_0x01e0
        L_0x0023:
            java.lang.String r0 = "margin-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 6
            goto L_0x01e0
        L_0x002e:
            java.lang.String r0 = "margin-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 4
            goto L_0x01e0
        L_0x0039:
            java.lang.String r0 = "unscalable-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 25
            goto L_0x01e0
        L_0x0046:
            java.lang.String r0 = "position"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 13
            goto L_0x01e0
        L_0x0053:
            java.lang.String r0 = "borderWidth"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 19
            goto L_0x01e0
        L_0x005f:
            java.lang.String r0 = "borderColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 18
            goto L_0x01e0
        L_0x006b:
            java.lang.String r0 = "padding-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 9
            goto L_0x01e0
        L_0x0078:
            java.lang.String r0 = "leftBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 21
            goto L_0x01e0
        L_0x0084:
            java.lang.String r0 = "cornerRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 24
            goto L_0x01e0
        L_0x0090:
            java.lang.String r0 = "padding-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 12
            goto L_0x01e0
        L_0x009d:
            java.lang.String r0 = "width"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 1
            goto L_0x01e0
        L_0x00a9:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 15
            goto L_0x01e0
        L_0x00b6:
            java.lang.String r0 = "alpha"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 36
            goto L_0x01e0
        L_0x00c2:
            java.lang.String r0 = "left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 14
            goto L_0x01e0
        L_0x00ce:
            java.lang.String r0 = "flex"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 32
            goto L_0x01e0
        L_0x00da:
            java.lang.String r0 = "top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 16
            goto L_0x01e0
        L_0x00e7:
            java.lang.String r0 = "id"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 0
            goto L_0x01e0
        L_0x00f2:
            java.lang.String r0 = "rightTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 22
            goto L_0x01e0
        L_0x00ff:
            java.lang.String r0 = "flex-basis"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 31
            goto L_0x01e0
        L_0x010b:
            java.lang.String r0 = "leftTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 20
            goto L_0x01e0
        L_0x0117:
            java.lang.String r0 = "outsideMargin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 38
            goto L_0x01e0
        L_0x0124:
            java.lang.String r0 = "padding-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 10
            goto L_0x01e0
        L_0x0131:
            java.lang.String r0 = "rightBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 23
            goto L_0x01e0
        L_0x013e:
            java.lang.String r0 = "padding"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 8
            goto L_0x01e0
        L_0x014b:
            java.lang.String r0 = "margin-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 5
            goto L_0x01e0
        L_0x0156:
            java.lang.String r0 = "margin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 3
            goto L_0x01e0
        L_0x0161:
            java.lang.String r0 = "align-self"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 35
            goto L_0x01e0
        L_0x016d:
            java.lang.String r0 = "height"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 2
            goto L_0x01e0
        L_0x0178:
            java.lang.String r0 = "onTouch"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 34
            goto L_0x01e0
        L_0x0184:
            java.lang.String r0 = "cardId"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 37
            goto L_0x01e0
        L_0x018f:
            java.lang.String r0 = "bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 17
            goto L_0x01e0
        L_0x019a:
            java.lang.String r0 = "flex-shrink"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 30
            goto L_0x01e0
        L_0x01a5:
            java.lang.String r0 = "unscalable-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 26
            goto L_0x01e0
        L_0x01b1:
            java.lang.String r0 = "padding-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 11
            goto L_0x01e0
        L_0x01bd:
            java.lang.String r0 = "aspect-ratio"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 33
            goto L_0x01e0
        L_0x01c8:
            java.lang.String r0 = "flex-grow"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 29
            goto L_0x01e0
        L_0x01d3:
            java.lang.String r0 = "unscalable-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01df
            r4 = 27
            goto L_0x01e0
        L_0x01df:
            r4 = -1
        L_0x01e0:
            r0 = 2131428078(0x7f0b02ee, float:1.847779E38)
            switch(r4) {
                case 0: goto L_0x0318;
                case 1: goto L_0x0314;
                case 2: goto L_0x0310;
                case 3: goto L_0x030a;
                case 4: goto L_0x0304;
                case 5: goto L_0x02fe;
                case 6: goto L_0x02f8;
                case 7: goto L_0x02f2;
                case 8: goto L_0x02ec;
                case 9: goto L_0x02e6;
                case 10: goto L_0x02e0;
                case 11: goto L_0x02da;
                case 12: goto L_0x02d4;
                case 13: goto L_0x02cc;
                case 14: goto L_0x02c6;
                case 15: goto L_0x02c0;
                case 16: goto L_0x02ba;
                case 17: goto L_0x02b3;
                case 18: goto L_0x02aa;
                case 19: goto L_0x02a1;
                case 20: goto L_0x0294;
                case 21: goto L_0x0287;
                case 22: goto L_0x027a;
                case 23: goto L_0x026d;
                case 24: goto L_0x0264;
                case 25: goto L_0x025b;
                case 26: goto L_0x0252;
                case 27: goto L_0x0249;
                case 28: goto L_0x0240;
                case 29: goto L_0x0237;
                case 30: goto L_0x022e;
                case 31: goto L_0x0225;
                case 32: goto L_0x021c;
                case 33: goto L_0x0213;
                case 34: goto L_0x020e;
                case 35: goto L_0x0205;
                case 36: goto L_0x01fc;
                case 37: goto L_0x01f7;
                case 38: goto L_0x01e7;
                default: goto L_0x01e6;
            }
        L_0x01e6:
            return r2
        L_0x01e7:
            r4 = 2131433102(0x7f0b168e, float:1.848798E38)
            float r5 = r3.m16079b(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r6.setTag(r4, r5)
            goto L_0x031b
        L_0x01f7:
            r6.setTag(r0, r5)
            goto L_0x031b
        L_0x01fc:
            float r4 = java.lang.Float.parseFloat(r5)
            r6.setAlpha(r4)
            goto L_0x031b
        L_0x0205:
            com.facebook.yoga.YogaAlign r4 = r3.m16082c(r5)
            r7.setAlignSelf(r4)
            goto L_0x031b
        L_0x020e:
            r3.m16071a((android.view.View) r6, (java.lang.String) r5, (java.lang.String) r10)
            goto L_0x031b
        L_0x0213:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setAspectRatio(r4)
            goto L_0x031b
        L_0x021c:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlex(r4)
            goto L_0x031b
        L_0x0225:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexBasis(r4)
            goto L_0x031b
        L_0x022e:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexShrink(r4)
            goto L_0x031b
        L_0x0237:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexGrow(r4)
            goto L_0x031b
        L_0x0240:
            int r4 = java.lang.Integer.parseInt(r5)
            r11.setUnScalableRight(r4)
            goto L_0x031b
        L_0x0249:
            int r4 = java.lang.Integer.parseInt(r5)
            r11.setUnScalableBottom(r4)
            goto L_0x031b
        L_0x0252:
            int r4 = java.lang.Integer.parseInt(r5)
            r11.setUnScalableLeft(r4)
            goto L_0x031b
        L_0x025b:
            int r4 = java.lang.Integer.parseInt(r5)
            r11.setUnScalableTop(r4)
            goto L_0x031b
        L_0x0264:
            float r4 = r3.m16079b(r5)
            r8.setCorners(r4)
            goto L_0x031b
        L_0x026d:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f22234d
            float r4 = r4 * r5
            r8.setRightBottomCorner(r4)
            goto L_0x031b
        L_0x027a:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f22234d
            float r4 = r4 * r5
            r8.setRightTopCorner(r4)
            goto L_0x031b
        L_0x0287:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f22234d
            float r4 = r4 * r5
            r8.setLeftBottomCorner(r4)
            goto L_0x031b
        L_0x0294:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f22234d
            float r4 = r4 * r5
            r8.setLeftTopCorner(r4)
            goto L_0x031b
        L_0x02a1:
            float r4 = java.lang.Float.parseFloat(r5)
            r9.setBorderWidth(r4)
            goto L_0x031b
        L_0x02aa:
            int r4 = android.graphics.Color.parseColor(r5)
            r9.setBorderColor(r4)
            goto L_0x031b
        L_0x02b3:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m16080b(r4, r7, r5)
            goto L_0x031b
        L_0x02ba:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m16080b(r4, r7, r5)
            goto L_0x031b
        L_0x02c0:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m16080b(r4, r7, r5)
            goto L_0x031b
        L_0x02c6:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m16080b(r4, r7, r5)
            goto L_0x031b
        L_0x02cc:
            com.facebook.yoga.YogaPositionType r4 = r3.m16068a((java.lang.String) r5)
            r7.setPositionType(r4)
            goto L_0x031b
        L_0x02d4:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m16074a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x031b
        L_0x02da:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m16074a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x031b
        L_0x02e0:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m16074a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x031b
        L_0x02e6:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m16074a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x031b
        L_0x02ec:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m16074a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x031b
        L_0x02f2:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m16073a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x02f8:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m16073a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x02fe:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m16073a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x0304:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m16073a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x030a:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m16073a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x0310:
            r3.m16075a((com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x031b
        L_0x0314:
            r3.m16081b(r7, r5)
            goto L_0x031b
        L_0x0318:
            r6.setTag(r0, r5)
        L_0x031b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.XCardRenderer.m16078a(java.lang.String, java.lang.String, android.view.View, com.facebook.yoga.YogaNode, com.didi.global.globalgenerickit.template.yoga.view.Corner, com.didi.global.globalgenerickit.template.yoga.view.Border, java.lang.String, com.didi.global.globalgenerickit.template.yoga.view.Patch):boolean");
    }

    /* renamed from: a */
    private void m16073a(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setMarginPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str) * this.f22234d);
        }
    }

    /* renamed from: a */
    private void m16074a(YogaEdge yogaEdge, YogaNode yogaNode, String str, View view) {
        if ((view instanceof XPanelHorizontalRecyclerView) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPaddingPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 2));
            yogaNode.setPadding(yogaEdge, (float) parseFloat);
            m16070a(view, yogaEdge, parseFloat);
        } else {
            int parseFloat2 = (int) (Float.parseFloat(str) * this.f22234d);
            yogaNode.setPadding(yogaEdge, (float) parseFloat2);
            m16070a(view, yogaEdge, parseFloat2);
        }
    }

    /* renamed from: a */
    private void m16070a(View view, YogaEdge yogaEdge, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        switch (C85983.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
            case 1:
                view.setPadding(i, i, i, i);
                return;
            case 2:
            case 3:
                view.setPadding(i, paddingTop, paddingRight, paddingBottom);
                return;
            case 4:
                view.setPadding(paddingLeft, i, paddingRight, paddingBottom);
                return;
            case 5:
            case 6:
                view.setPadding(paddingLeft, paddingTop, i, paddingBottom);
                return;
            case 7:
                view.setPadding(paddingLeft, paddingTop, paddingRight, i);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.didi.global.globalgenerickit.template.yoga.XCardRenderer$3 */
    static /* synthetic */ class C85983 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.yoga.YogaEdge[] r0 = com.facebook.yoga.YogaEdge.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$yoga$YogaEdge = r0
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.START     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.yoga.YogaEdge r1 = com.facebook.yoga.YogaEdge.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.global.globalgenerickit.template.yoga.XCardRenderer.C85983.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m16080b(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPositionPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str) * this.f22234d);
        }
    }

    /* renamed from: a */
    private void m16071a(final View view, final String str, final String str2) {
        view.setTag(str);
        if (("card".equals(str2) || !TextUtils.isEmpty(str)) && !"scroll".equals(str2)) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (XCardRenderer.this.f22236f != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", str);
                        if ("card".equals(str2)) {
                            XCardRenderer.this.f22236f.handleEvent("xpanel_card_ck", str, hashMap);
                        } else if (view.getTag(R.id.cardId) != null) {
                            hashMap.put(Const.BUTTON_ID, (String) view.getTag(R.id.cardId));
                            XCardRenderer.this.f22236f.handleEvent("xpanel_button_ck", str, hashMap);
                        } else {
                            XCardRenderer.this.f22236f.handleEvent("click", str, hashMap);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private YogaPositionType m16068a(String str) {
        if (TextUtils.isEmpty(str) || !Constants.PATH_TYPE_ABSOLUTE.equals(str)) {
            return YogaPositionType.RELATIVE;
        }
        return YogaPositionType.ABSOLUTE;
    }

    /* renamed from: a */
    private void m16075a(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setHeightPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setHeight(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setHeight((float) ((int) (Float.parseFloat(str) * this.f22234d)));
        }
    }

    /* renamed from: b */
    private void m16081b(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setWidthPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setWidth(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setWidth((float) ((int) (Float.parseFloat(str) * this.f22234d)));
        }
    }

    /* renamed from: b */
    private float m16079b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) ((int) (Float.parseFloat(str) * this.f22234d));
    }

    public static float getNumValue(Context context, String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) KitHelper.dip2px(context, (float) ((int) Float.parseFloat(str)));
    }

    /* renamed from: c */
    private YogaAlign m16082c(String str) {
        if (TextUtils.isEmpty(str)) {
            return YogaAlign.AUTO;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 3;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c = 4;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c = 0;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0) {
            return YogaAlign.FLEX_START;
        }
        if (c == 1) {
            return YogaAlign.CENTER;
        }
        if (c == 2) {
            return YogaAlign.FLEX_END;
        }
        if (c == 3) {
            return YogaAlign.STRETCH;
        }
        if (c != 4) {
            return YogaAlign.AUTO;
        }
        return YogaAlign.BASELINE;
    }
}
