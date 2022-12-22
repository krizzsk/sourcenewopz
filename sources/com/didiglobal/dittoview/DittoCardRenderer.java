package com.didiglobal.dittoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
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
import com.didi.global.globalresource.utils.GRUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.util.DittoImgLoadTracker;
import com.didiglobal.dittoview.util.DittoNinePatchBuilder;
import com.didiglobal.dittoview.util.DittoUtil;
import com.didiglobal.dittoview.view.DittoBorder;
import com.didiglobal.dittoview.view.DittoCorner;
import com.didiglobal.dittoview.view.DittoHorizontalScrollView;
import com.didiglobal.dittoview.view.DittoImageView;
import com.didiglobal.dittoview.view.DittoLottieView;
import com.didiglobal.dittoview.view.DittoPatch;
import com.didiglobal.dittoview.view.DittoProgressBar;
import com.didiglobal.dittoview.view.DittoRoundColorDrawable;
import com.didiglobal.dittoview.view.DittoRoundDrawable;
import com.didiglobal.dittoview.view.DittoShadow;
import com.didiglobal.dittoview.view.DittoTextView;
import com.didiglobal.dittoview.view.DittoYogaLayout;
import com.didiglobal.dittoview.view.recyclerview.DittoRecyclerView;
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
import java.util.Map;
import org.w3c.dom.Element;

public class DittoCardRenderer {
    public static final String TAG = "DittoCardRenderer";

    /* renamed from: a */
    DittoData f49873a;

    /* renamed from: b */
    String f49874b = "";

    /* renamed from: c */
    private Context f49875c;

    /* renamed from: d */
    private float f49876d;

    /* renamed from: e */
    private int f49877e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DittoEventListener f49878f;

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

    public DittoCardRenderer(Context context, int i, DittoData dittoData) {
        ContextLoader.loadOnce(context);
        this.f49876d = ContextLoader.getDensity();
        this.f49875c = context;
        this.f49877e = i;
        this.f49873a = dittoData;
        String str = this.f49875c.getCacheDir() + File.separator + "cdn_cache";
        if (dittoData != null) {
            this.f49874b = str + File.separator + dittoData.getTemplate() + File.separator + DittoUtil.MD5encode(dittoData.getCdn());
        }
        SystemUtils.log(3, "Yoga", "===Ditto Yoga engine 新的XML解析引擎==", (Throwable) null, "com.didiglobal.dittoview.DittoCardRenderer", 102);
    }

    public void bindEventListener(DittoEventListener dittoEventListener) {
        this.f49878f = dittoEventListener;
    }

    public View render(DittoCardNode dittoCardNode) {
        if (dittoCardNode == null) {
            return null;
        }
        try {
            Element element = dittoCardNode.reference;
            if (element == null) {
                return null;
            }
            if ("card".equals(element.getTagName())) {
                return m35972a(dittoCardNode, (ViewGroup) null);
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
    private android.view.View m35972a(com.didiglobal.dittoview.DittoCardNode r6, android.view.ViewGroup r7) {
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
            java.util.List<com.didiglobal.dittoview.DittoCardNode> r6 = r6.children
            if (r6 != 0) goto L_0x0019
            return r7
        L_0x0019:
            java.util.Iterator r6 = r6.iterator()
        L_0x001d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x002d
            java.lang.Object r0 = r6.next()
            com.didiglobal.dittoview.DittoCardNode r0 = (com.didiglobal.dittoview.DittoCardNode) r0
            r5.m35972a((com.didiglobal.dittoview.DittoCardNode) r0, (android.view.ViewGroup) r7)
            goto L_0x001d
        L_0x002d:
            return r7
        L_0x002e:
            java.lang.String r2 = r0.getTagName()
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r6.attributes
            com.didiglobal.dittoview.IParser r2 = r5.m35974a((java.lang.String) r2, (java.util.HashMap<java.lang.String, java.lang.Object>) r3)
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
            r5.m35984a((java.util.HashMap<java.lang.String, java.lang.Object>) r3, (com.didiglobal.dittoview.IParser) r2, (com.facebook.yoga.YogaNode) r1, (java.lang.String) r0)
            r2.onParseEnd()
            boolean r0 = r2 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0072
            r7 = r2
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
        L_0x0072:
            java.util.List<com.didiglobal.dittoview.DittoCardNode> r6 = r6.children
            if (r6 != 0) goto L_0x0077
            return r7
        L_0x0077:
            java.util.Iterator r6 = r6.iterator()
        L_0x007b:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x008b
            java.lang.Object r0 = r6.next()
            com.didiglobal.dittoview.DittoCardNode r0 = (com.didiglobal.dittoview.DittoCardNode) r0
            r5.m35972a((com.didiglobal.dittoview.DittoCardNode) r0, (android.view.ViewGroup) r7)
            goto L_0x007b
        L_0x008b:
            return r7
        L_0x008c:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "xcard node has no dom node mapping, its reference is null"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCardRenderer.m35972a(com.didiglobal.dittoview.DittoCardNode, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    private IParser m35974a(String str, HashMap<String, Object> hashMap) {
        if ("view".equals(str) || "card".equals(str)) {
            DittoYogaLayout dittoYogaLayout = new DittoYogaLayout(this.f49875c);
            if ("card".equals(str)) {
                m35978a((View) dittoYogaLayout, "", "card");
            }
            return dittoYogaLayout;
        } else if ("image".equals(str)) {
            if (!TextUtils.isEmpty((String) hashMap.get("url"))) {
                return new DittoImageView(this.f49875c);
            }
            return null;
        } else if ("label".equals(str)) {
            if (!TextUtils.isEmpty((String) hashMap.get("text"))) {
                return new DittoTextView(this.f49875c);
            }
            return null;
        } else if ("progressBar".equals(str)) {
            return new DittoProgressBar(this.f49875c);
        } else {
            if ("scrollview".equals(str)) {
                return new DittoHorizontalScrollView(this.f49875c);
            }
            if ("scroll".equals(str)) {
                DittoRecyclerView dittoRecyclerView = new DittoRecyclerView(this.f49875c);
                dittoRecyclerView.bindXCardListener(this.f49878f);
                return dittoRecyclerView;
            } else if ("lottie".equals(str)) {
                return new DittoLottieView(this.f49875c);
            } else {
                throw new IllegalArgumentException("Unknown view type: " + str);
            }
        }
    }

    public void setLeftRightMargin(int i) {
        this.f49877e = i;
    }

    /* renamed from: a */
    private void m35984a(HashMap<String, Object> hashMap, IParser iParser, YogaNode yogaNode, String str) {
        IParser iParser2 = iParser;
        DittoCorner dittoCorner = new DittoCorner();
        DittoBorder dittoBorder = new DittoBorder();
        DittoShadow dittoShadow = new DittoShadow();
        DittoPatch dittoPatch = new DittoPatch();
        String str2 = null;
        String str3 = "";
        String str4 = str3;
        String str5 = str4;
        String str6 = null;
        String str7 = null;
        float f = -1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        float f4 = -1.0f;
        for (Map.Entry next : hashMap.entrySet()) {
            String str8 = (String) next.getKey();
            String obj = next.getValue().toString();
            String str9 = str8;
            String str10 = str6;
            float f5 = f;
            float f6 = f2;
            float f7 = f3;
            float f8 = f4;
            String str11 = str3;
            DittoShadow dittoShadow2 = dittoShadow;
            String str12 = str2;
            if (!m35985a(str8, obj, iParser.getView(), yogaNode, dittoCorner, dittoBorder, dittoShadow, str, dittoPatch)) {
                String str13 = str9;
                if (!"selectedColor".equals(str13)) {
                    if ("backgroundColor".equals(str13)) {
                        YogaNode yogaNode2 = yogaNode;
                        str7 = getRealColorString(obj);
                    } else if ("url".equals(str13)) {
                        YogaNode yogaNode3 = yogaNode;
                        str10 = obj;
                    } else if ("startColor".equals(str13)) {
                        YogaNode yogaNode4 = yogaNode;
                        str4 = DittoProgressBar.getFullColorString(obj);
                    } else if ("endColor".equals(str13)) {
                        YogaNode yogaNode5 = yogaNode;
                        str5 = DittoProgressBar.getFullColorString(obj);
                    } else if ("startPoint".equals(str13)) {
                        String[] split = obj.replace(Const.joLeft, str11).replace("}", str11).trim().split(",");
                        if (split == null || split.length <= 1) {
                            f3 = f7;
                            f4 = f8;
                        } else {
                            f4 = Float.parseFloat(split[0]);
                            f3 = Float.parseFloat(split[1]);
                        }
                        YogaNode yogaNode6 = yogaNode;
                        f = f5;
                        f2 = f6;
                        str3 = str11;
                        str2 = str12;
                        str6 = str10;
                        dittoShadow = dittoShadow2;
                    } else {
                        String str14 = obj;
                        if ("endPoint".equals(str13)) {
                            String[] split2 = str14.replace(Const.joLeft, str11).replace("}", str11).trim().split(",");
                            if (split2 == null || split2.length <= 1) {
                                f = f5;
                                f2 = f6;
                            } else {
                                f2 = Float.parseFloat(split2[0]);
                                f = Float.parseFloat(split2[1]);
                            }
                            YogaNode yogaNode7 = yogaNode;
                            f3 = f7;
                            f4 = f8;
                            str3 = str11;
                            str2 = str12;
                            str6 = str10;
                            dittoShadow = dittoShadow2;
                        } else {
                            if (iParser2 instanceof DittoProgressBar) {
                                ((DittoProgressBar) iParser2).setStartColor(Color.parseColor(str7));
                            }
                            iParser2.parse(str13, str14, yogaNode);
                        }
                    }
                    f = f5;
                    f2 = f6;
                    f3 = f7;
                    f4 = f8;
                    str3 = str11;
                    str2 = str12;
                    str6 = str10;
                    dittoShadow = dittoShadow2;
                }
            }
            YogaNode yogaNode8 = yogaNode;
            f = f5;
            f2 = f6;
            f3 = f7;
            f4 = f8;
            str3 = str11;
            str2 = str12;
            str6 = str10;
            dittoShadow = dittoShadow2;
        }
        float f9 = f;
        float f10 = f2;
        float f11 = f3;
        float f12 = f4;
        DittoShadow dittoShadow3 = dittoShadow;
        String str15 = str2;
        String str16 = str6;
        YogaNode yogaNode9 = yogaNode;
        if (str16 == null) {
            if (!dittoCorner.isEmpty) {
                ((IView) iParser2).setCorner(dittoCorner);
            }
            if (!dittoBorder.isEmpty) {
                ((IView) iParser2).setBorder(dittoBorder);
            }
            if (!dittoShadow3.isEmpty()) {
                ((IView) iParser2).setShadow(dittoShadow3);
            } else if ("default".equals(hashMap.get("shadow"))) {
                iParser.getView().setBackground(this.f49875c.getResources().getDrawable(R.drawable.oc_x_panel_card_bg));
            } else if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                int[] iArr = {getRealColor(str4), getRealColor(str5)};
                float[] fArr = {dittoCorner.getLeftTopCorner(), dittoCorner.getLeftTopCorner(), dittoCorner.getRightTopCorner(), dittoCorner.getRightTopCorner(), dittoCorner.getRightBottomCorner(), dittoCorner.getRightBottomCorner(), dittoCorner.getLeftBottomCorner(), dittoCorner.getLeftBottomCorner()};
                GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
                float f13 = f12;
                if (f13 >= 0.0f) {
                    float f14 = f11;
                    if (f14 >= 0.0f) {
                        float f15 = f10;
                        if (f15 >= 0.0f) {
                            float f16 = f9;
                            if (f16 >= 0.0f) {
                                orientation = m35971a(new PointF(f13, f14), new PointF(f15, f16));
                            }
                        }
                    }
                }
                GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
                gradientDrawable.setCornerRadii(fArr);
                iParser.getView().setBackground(gradientDrawable);
            } else if (str7 != null) {
                iParser.getView().setBackground(new DittoRoundColorDrawable(Color.parseColor(str7), dittoCorner));
            }
        } else if (iParser2 instanceof DittoImageView) {
            m35983a(str16, (DittoImageView) iParser.getView(), yogaNode, dittoCorner, dittoBorder, dittoPatch);
        } else if (iParser2 instanceof DittoLottieView) {
            File file = new File(this.f49874b);
            if (file.exists() && file.isDirectory()) {
                String resourceNameWithoutSuffix = GRUtils.getResourceNameWithoutSuffix(str16);
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    for (String str17 : list) {
                        String resourceRealName = GRUtils.getResourceRealName(str17);
                        if (!TextUtils.isEmpty(resourceNameWithoutSuffix) && resourceNameWithoutSuffix.equals(resourceRealName)) {
                            try {
                                ((DittoLottieView) iParser2).setAnimation(new FileInputStream(this.f49874b + File.separator + str17), str15);
                                return;
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            ((DittoLottieView) iParser2).setAnimationFromUrl(str16);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x002d, code lost:
        if (r9.y >= r8.y) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.GradientDrawable.Orientation m35971a(android.graphics.PointF r8, android.graphics.PointF r9) {
        /*
            r7 = this;
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            float r1 = r9.y
            float r2 = r8.y
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            double r1 = (double) r1
            float r3 = r9.x
            float r4 = r8.x
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            double r3 = (double) r3
            double r1 = java.lang.Math.atan2(r1, r3)
            float r3 = r9.x
            float r4 = r8.x
            r5 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x0030
            float r9 = r9.y
            float r8 = r8.y
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x003b
            goto L_0x003c
        L_0x0030:
            float r9 = r9.y
            float r8 = r8.y
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x003b
            double r1 = r5 - r1
            goto L_0x003c
        L_0x003b:
            double r1 = r1 + r5
        L_0x003c:
            r8 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r1 = r1 * r8
            double r1 = r1 / r5
            r8 = 0
            r3 = 1102315520(0x41b40000, float:22.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0055
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0055
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            goto L_0x00d4
        L_0x0055:
            double r8 = (double) r3
            r3 = 1116143616(0x42870000, float:67.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0065
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0065
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.BL_TR
            goto L_0x00d4
        L_0x0065:
            double r8 = (double) r3
            r3 = 1122041856(0x42e10000, float:112.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0074
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0074
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP
            goto L_0x00d4
        L_0x0074:
            double r8 = (double) r3
            r3 = 1126006784(0x431d8000, float:157.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0084
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0084
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.BR_TL
            goto L_0x00d4
        L_0x0084:
            double r8 = (double) r3
            r3 = 1128955904(0x434a8000, float:202.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0094
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0094
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT
            goto L_0x00d4
        L_0x0094:
            double r8 = (double) r3
            r3 = 1131905024(0x43778000, float:247.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a4
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x00a4
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.TR_BL
            goto L_0x00d4
        L_0x00a4:
            double r8 = (double) r3
            r3 = 1133658112(0x43924000, float:292.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b4
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x00b4
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM
            goto L_0x00d4
        L_0x00b4:
            double r8 = (double) r3
            r3 = 1135132672(0x43a8c000, float:337.5)
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x00c4
            double r8 = (double) r3
            int r4 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x00c4
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.TL_BR
            goto L_0x00d4
        L_0x00c4:
            double r8 = (double) r3
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d4
            r8 = 4645040803167600640(0x4076800000000000, double:360.0)
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x00d4
            android.graphics.drawable.GradientDrawable$Orientation r0 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCardRenderer.m35971a(android.graphics.PointF, android.graphics.PointF):android.graphics.drawable.GradientDrawable$Orientation");
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
    private void m35983a(String str, DittoImageView dittoImageView, YogaNode yogaNode, DittoCorner dittoCorner, DittoBorder dittoBorder, DittoPatch dittoPatch) {
        String str2 = str;
        DittoImageView dittoImageView2 = dittoImageView;
        if (this.f49875c != null && !TextUtils.isEmpty(str)) {
            dittoImageView2.setTag(str);
            final Map<String, Object> mapFromAgentData = DittoImgLoadTracker.getMapFromAgentData(this.f49873a);
            final long currentTimeMillis = System.currentTimeMillis();
            DittoImgLoadTracker.loadUrlOmega(str, mapFromAgentData);
            if (!str.endsWith(".gif")) {
                File file = new File(this.f49874b);
                if (file.exists() && file.isDirectory()) {
                    String resourceNameWithoutSuffix = GRUtils.getResourceNameWithoutSuffix(str);
                    String[] list = file.list();
                    if (list != null && list.length > 0) {
                        for (String str3 : list) {
                            String resourceRealName = GRUtils.getResourceRealName(str3);
                            if (!TextUtils.isEmpty(resourceNameWithoutSuffix) && resourceNameWithoutSuffix.equals(resourceRealName)) {
                                Bitmap decodeFile = BitmapFactory.decodeFile(this.f49874b + File.separator + str3);
                                if (str.equals(dittoImageView.getTag())) {
                                    m35976a(decodeFile, str, mapFromAgentData, currentTimeMillis, dittoPatch, dittoImageView, dittoCorner, dittoBorder);
                                    return;
                                }
                            }
                        }
                    }
                }
                final String str4 = str;
                final DittoImageView dittoImageView3 = dittoImageView;
                final DittoPatch dittoPatch2 = dittoPatch;
                final DittoCorner dittoCorner2 = dittoCorner;
                final DittoBorder dittoBorder2 = dittoBorder;
                final YogaNode yogaNode2 = yogaNode;
                Glide.with(this.f49875c).asBitmap().load(str).into(new CustomTarget<Bitmap>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onLoadStarted(Drawable drawable) {
                        super.onLoadStarted(drawable);
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        if (str4.equals(dittoImageView3.getTag())) {
                            DittoCardRenderer.this.m35976a(bitmap, str4, mapFromAgentData, currentTimeMillis, dittoPatch2, dittoImageView3, dittoCorner2, dittoBorder2);
                        }
                    }

                    public void onLoadFailed(Drawable drawable) {
                        DittoImgLoadTracker.loadUrlRetOmega(str4, mapFromAgentData, 1, currentTimeMillis);
                        yogaNode2.setHeight(0.0f);
                        yogaNode2.setWidth(0.0f);
                        yogaNode2.setMargin(YogaEdge.END, 0.0f);
                        yogaNode2.setMargin(YogaEdge.START, 0.0f);
                        yogaNode2.setMargin(YogaEdge.TOP, 0.0f);
                        yogaNode2.setMargin(YogaEdge.BOTTOM, 0.0f);
                        dittoImageView3.setVisibility(8);
                    }
                });
                return;
            }
            ((RequestBuilder) Glide.with(this.f49875c).asGif().load(str).diskCacheStrategy(DiskCacheStrategy.DATA)).into((ImageView) dittoImageView2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35976a(Bitmap bitmap, String str, Map<String, Object> map, long j, DittoPatch dittoPatch, DittoImageView dittoImageView, DittoCorner dittoCorner, DittoBorder dittoBorder) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        DittoImgLoadTracker.loadUrlRetOmega(str, map, 0, j);
        if (dittoPatch == null || (dittoPatch.getUnScalableLeft() <= 0 && dittoPatch.getUnScalableTop() <= 0 && dittoPatch.getUnScalableRight() <= 0 && dittoPatch.getUnScalableBottom() <= 0)) {
            DittoRoundDrawable fromBitmap = DittoRoundDrawable.fromBitmap(bitmap, dittoCorner);
            fromBitmap.setBorderColor(dittoBorder.getBorderColor());
            fromBitmap.setBorderWidth(dittoBorder.getBorderWidth());
            dittoImageView.setImageDrawable(fromBitmap);
            SystemUtils.log(3, "lxsLoadImgTimeNet", (System.currentTimeMillis() - j) + " : " + str, (Throwable) null, "com.didiglobal.dittoview.DittoCardRenderer", 513);
            return;
        }
        DittoNinePatchBuilder dittoNinePatchBuilder = new DittoNinePatchBuilder(this.f49875c.getResources(), bitmap);
        if (dittoPatch.getUnScalableLeft() > 0 && dittoPatch.getUnScalableRight() > 0) {
            i2 = dittoPatch.getUnScalableLeft();
            i = dittoPatch.getUnScalableRight();
        } else if (dittoPatch.getUnScalableLeft() > 0) {
            i2 = dittoPatch.getUnScalableLeft();
            i = dittoPatch.getUnScalableLeft() + 1;
        } else {
            i2 = 0;
            i = 0;
        }
        if (dittoPatch.getUnScalableTop() > 0 && dittoPatch.getUnScalableBottom() > 0) {
            i4 = dittoPatch.getUnScalableTop();
            i3 = dittoPatch.getUnScalableBottom();
        } else if (dittoPatch.getUnScalableTop() > 0) {
            i4 = dittoPatch.getUnScalableTop();
            i3 = dittoPatch.getUnScalableTop() + 1;
        } else {
            i3 = 0;
        }
        if (i2 > 0) {
            dittoNinePatchBuilder = dittoNinePatchBuilder.addXRegionPoints(i2, i);
        }
        if (i4 > 0) {
            dittoNinePatchBuilder = dittoNinePatchBuilder.addYRegionPoints(i4, i3);
        }
        NinePatchDrawable build = dittoNinePatchBuilder.build();
        dittoImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        dittoImageView.setImageDrawable(build);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m35985a(java.lang.String r4, java.lang.String r5, android.view.View r6, com.facebook.yoga.YogaNode r7, com.didiglobal.dittoview.view.DittoCorner r8, com.didiglobal.dittoview.view.DittoBorder r9, com.didiglobal.dittoview.view.DittoShadow r10, java.lang.String r11, com.didiglobal.dittoview.view.DittoPatch r12) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1866641174: goto L_0x01f3;
                case -1802976921: goto L_0x01e8;
                case -1702268461: goto L_0x01dd;
                case -1621067310: goto L_0x01d2;
                case -1589741021: goto L_0x01c7;
                case -1546463658: goto L_0x01bc;
                case -1502084711: goto L_0x01b1;
                case -1458636154: goto L_0x01a6;
                case -1454606755: goto L_0x019b;
                case -1383228885: goto L_0x018f;
                case -1367605173: goto L_0x0183;
                case -1336101728: goto L_0x0177;
                case -1221029593: goto L_0x016c;
                case -1089145580: goto L_0x0160;
                case -1081309778: goto L_0x0155;
                case -949513525: goto L_0x0149;
                case -887955139: goto L_0x013e;
                case -806339567: goto L_0x0132;
                case -506906468: goto L_0x0126;
                case -396426912: goto L_0x011a;
                case -278063181: goto L_0x010e;
                case -80043069: goto L_0x0102;
                case -62830230: goto L_0x00f6;
                case -39712434: goto L_0x00ea;
                case 3355: goto L_0x00df;
                case 115029: goto L_0x00d3;
                case 3145721: goto L_0x00c7;
                case 3317767: goto L_0x00bb;
                case 92909918: goto L_0x00af;
                case 108511772: goto L_0x00a3;
                case 113126854: goto L_0x0098;
                case 143541095: goto L_0x008c;
                case 583595847: goto L_0x0080;
                case 593989127: goto L_0x0074;
                case 679766083: goto L_0x0068;
                case 722830999: goto L_0x005c;
                case 741115130: goto L_0x0050;
                case 747804969: goto L_0x0044;
                case 922786550: goto L_0x0038;
                case 941004998: goto L_0x002d;
                case 1970025654: goto L_0x0022;
                case 2032580477: goto L_0x0016;
                case 2086035242: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x01fe
        L_0x000b:
            java.lang.String r0 = "margin-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 7
            goto L_0x01ff
        L_0x0016:
            java.lang.String r0 = "unscalable-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 32
            goto L_0x01ff
        L_0x0022:
            java.lang.String r0 = "margin-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 6
            goto L_0x01ff
        L_0x002d:
            java.lang.String r0 = "margin-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 4
            goto L_0x01ff
        L_0x0038:
            java.lang.String r0 = "unscalable-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 29
            goto L_0x01ff
        L_0x0044:
            java.lang.String r0 = "position"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 13
            goto L_0x01ff
        L_0x0050:
            java.lang.String r0 = "borderWidth"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 19
            goto L_0x01ff
        L_0x005c:
            java.lang.String r0 = "borderColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 18
            goto L_0x01ff
        L_0x0068:
            java.lang.String r0 = "padding-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 9
            goto L_0x01ff
        L_0x0074:
            java.lang.String r0 = "leftBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 21
            goto L_0x01ff
        L_0x0080:
            java.lang.String r0 = "cornerRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 24
            goto L_0x01ff
        L_0x008c:
            java.lang.String r0 = "padding-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 12
            goto L_0x01ff
        L_0x0098:
            java.lang.String r0 = "width"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 1
            goto L_0x01ff
        L_0x00a3:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 15
            goto L_0x01ff
        L_0x00af:
            java.lang.String r0 = "alpha"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 40
            goto L_0x01ff
        L_0x00bb:
            java.lang.String r0 = "left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 14
            goto L_0x01ff
        L_0x00c7:
            java.lang.String r0 = "flex"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 36
            goto L_0x01ff
        L_0x00d3:
            java.lang.String r0 = "top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 16
            goto L_0x01ff
        L_0x00df:
            java.lang.String r0 = "id"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 0
            goto L_0x01ff
        L_0x00ea:
            java.lang.String r0 = "rightTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 22
            goto L_0x01ff
        L_0x00f6:
            java.lang.String r0 = "flex-basis"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 35
            goto L_0x01ff
        L_0x0102:
            java.lang.String r0 = "leftTopCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 20
            goto L_0x01ff
        L_0x010e:
            java.lang.String r0 = "outsideMargin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 42
            goto L_0x01ff
        L_0x011a:
            java.lang.String r0 = "padding-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 10
            goto L_0x01ff
        L_0x0126:
            java.lang.String r0 = "rightBottomCorner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 23
            goto L_0x01ff
        L_0x0132:
            java.lang.String r0 = "padding"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 8
            goto L_0x01ff
        L_0x013e:
            java.lang.String r0 = "margin-right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 5
            goto L_0x01ff
        L_0x0149:
            java.lang.String r0 = "shadowOpacity"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 26
            goto L_0x01ff
        L_0x0155:
            java.lang.String r0 = "margin"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 3
            goto L_0x01ff
        L_0x0160:
            java.lang.String r0 = "align-self"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 39
            goto L_0x01ff
        L_0x016c:
            java.lang.String r0 = "height"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 2
            goto L_0x01ff
        L_0x0177:
            java.lang.String r0 = "onTouch"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 38
            goto L_0x01ff
        L_0x0183:
            java.lang.String r0 = "cardId"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 41
            goto L_0x01ff
        L_0x018f:
            java.lang.String r0 = "bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 17
            goto L_0x01ff
        L_0x019b:
            java.lang.String r0 = "flex-shrink"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 34
            goto L_0x01ff
        L_0x01a6:
            java.lang.String r0 = "unscalable-left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 30
            goto L_0x01ff
        L_0x01b1:
            java.lang.String r0 = "padding-top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 11
            goto L_0x01ff
        L_0x01bc:
            java.lang.String r0 = "aspect-ratio"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 37
            goto L_0x01ff
        L_0x01c7:
            java.lang.String r0 = "shadowColor"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 25
            goto L_0x01ff
        L_0x01d2:
            java.lang.String r0 = "shadowRadius"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 27
            goto L_0x01ff
        L_0x01dd:
            java.lang.String r0 = "shadowOffset"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 28
            goto L_0x01ff
        L_0x01e8:
            java.lang.String r0 = "flex-grow"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 33
            goto L_0x01ff
        L_0x01f3:
            java.lang.String r0 = "unscalable-bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x01fe
            r4 = 31
            goto L_0x01ff
        L_0x01fe:
            r4 = -1
        L_0x01ff:
            r0 = 2131428078(0x7f0b02ee, float:1.847779E38)
            switch(r4) {
                case 0: goto L_0x0367;
                case 1: goto L_0x0363;
                case 2: goto L_0x035f;
                case 3: goto L_0x0359;
                case 4: goto L_0x0353;
                case 5: goto L_0x034d;
                case 6: goto L_0x0347;
                case 7: goto L_0x0341;
                case 8: goto L_0x033b;
                case 9: goto L_0x0335;
                case 10: goto L_0x032f;
                case 11: goto L_0x0329;
                case 12: goto L_0x0323;
                case 13: goto L_0x031b;
                case 14: goto L_0x0315;
                case 15: goto L_0x030f;
                case 16: goto L_0x0309;
                case 17: goto L_0x0302;
                case 18: goto L_0x02f9;
                case 19: goto L_0x02f0;
                case 20: goto L_0x02e3;
                case 21: goto L_0x02d6;
                case 22: goto L_0x02c9;
                case 23: goto L_0x02bc;
                case 24: goto L_0x02b3;
                case 25: goto L_0x02ae;
                case 26: goto L_0x02a5;
                case 27: goto L_0x0288;
                case 28: goto L_0x0283;
                case 29: goto L_0x027a;
                case 30: goto L_0x0271;
                case 31: goto L_0x0268;
                case 32: goto L_0x025f;
                case 33: goto L_0x0256;
                case 34: goto L_0x024d;
                case 35: goto L_0x0244;
                case 36: goto L_0x023b;
                case 37: goto L_0x0232;
                case 38: goto L_0x022d;
                case 39: goto L_0x0224;
                case 40: goto L_0x021b;
                case 41: goto L_0x0216;
                case 42: goto L_0x0206;
                default: goto L_0x0205;
            }
        L_0x0205:
            return r2
        L_0x0206:
            r4 = 2131433102(0x7f0b168e, float:1.848798E38)
            float r5 = r3.m35986b(r5)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r6.setTag(r4, r5)
            goto L_0x036a
        L_0x0216:
            r6.setTag(r0, r5)
            goto L_0x036a
        L_0x021b:
            float r4 = java.lang.Float.parseFloat(r5)
            r6.setAlpha(r4)
            goto L_0x036a
        L_0x0224:
            com.facebook.yoga.YogaAlign r4 = r3.m35989c(r5)
            r7.setAlignSelf(r4)
            goto L_0x036a
        L_0x022d:
            r3.m35978a((android.view.View) r6, (java.lang.String) r5, (java.lang.String) r11)
            goto L_0x036a
        L_0x0232:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setAspectRatio(r4)
            goto L_0x036a
        L_0x023b:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlex(r4)
            goto L_0x036a
        L_0x0244:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexBasis(r4)
            goto L_0x036a
        L_0x024d:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexShrink(r4)
            goto L_0x036a
        L_0x0256:
            float r4 = java.lang.Float.parseFloat(r5)
            r7.setFlexGrow(r4)
            goto L_0x036a
        L_0x025f:
            int r4 = java.lang.Integer.parseInt(r5)
            r12.setUnScalableRight(r4)
            goto L_0x036a
        L_0x0268:
            int r4 = java.lang.Integer.parseInt(r5)
            r12.setUnScalableBottom(r4)
            goto L_0x036a
        L_0x0271:
            int r4 = java.lang.Integer.parseInt(r5)
            r12.setUnScalableLeft(r4)
            goto L_0x036a
        L_0x027a:
            int r4 = java.lang.Integer.parseInt(r5)
            r12.setUnScalableTop(r4)
            goto L_0x036a
        L_0x0283:
            r10.setShadowOffset(r5)
            goto L_0x036a
        L_0x0288:
            float r4 = java.lang.Float.parseFloat(r5)
            float r6 = r3.f49876d
            float r4 = r4 * r6
            int r4 = (int) r4
            r10.setShadowRadius(r4)
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49876d
            float r4 = r4 * r5
            int r4 = (int) r4
            com.facebook.yoga.YogaEdge r5 = com.facebook.yoga.YogaEdge.ALL
            float r4 = (float) r4
            r7.setPadding(r5, r4)
            goto L_0x036a
        L_0x02a5:
            float r4 = java.lang.Float.parseFloat(r5)
            r10.setShadowOpacity(r4)
            goto L_0x036a
        L_0x02ae:
            r10.setShadowColor(r5)
            goto L_0x036a
        L_0x02b3:
            float r4 = r3.m35986b(r5)
            r8.setCorners(r4)
            goto L_0x036a
        L_0x02bc:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49876d
            float r4 = r4 * r5
            r8.setRightBottomCorner(r4)
            goto L_0x036a
        L_0x02c9:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49876d
            float r4 = r4 * r5
            r8.setRightTopCorner(r4)
            goto L_0x036a
        L_0x02d6:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49876d
            float r4 = r4 * r5
            r8.setLeftBottomCorner(r4)
            goto L_0x036a
        L_0x02e3:
            float r4 = java.lang.Float.parseFloat(r5)
            float r5 = r3.f49876d
            float r4 = r4 * r5
            r8.setLeftTopCorner(r4)
            goto L_0x036a
        L_0x02f0:
            float r4 = java.lang.Float.parseFloat(r5)
            r9.setBorderWidth(r4)
            goto L_0x036a
        L_0x02f9:
            int r4 = android.graphics.Color.parseColor(r5)
            r9.setBorderColor(r4)
            goto L_0x036a
        L_0x0302:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35987b(r4, r7, r5)
            goto L_0x036a
        L_0x0309:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35987b(r4, r7, r5)
            goto L_0x036a
        L_0x030f:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35987b(r4, r7, r5)
            goto L_0x036a
        L_0x0315:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35987b(r4, r7, r5)
            goto L_0x036a
        L_0x031b:
            com.facebook.yoga.YogaPositionType r4 = r3.m35975a((java.lang.String) r5)
            r7.setPositionType(r4)
            goto L_0x036a
        L_0x0323:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35981a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x036a
        L_0x0329:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35981a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x036a
        L_0x032f:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35981a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x036a
        L_0x0335:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35981a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x036a
        L_0x033b:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m35981a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5, (android.view.View) r6)
            goto L_0x036a
        L_0x0341:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.BOTTOM
            r3.m35980a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x0347:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.TOP
            r3.m35980a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x034d:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.END
            r3.m35980a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x0353:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.START
            r3.m35980a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x0359:
            com.facebook.yoga.YogaEdge r4 = com.facebook.yoga.YogaEdge.ALL
            r3.m35980a((com.facebook.yoga.YogaEdge) r4, (com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x035f:
            r3.m35982a((com.facebook.yoga.YogaNode) r7, (java.lang.String) r5)
            goto L_0x036a
        L_0x0363:
            r3.m35988b(r7, r5)
            goto L_0x036a
        L_0x0367:
            r6.setTag(r0, r5)
        L_0x036a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCardRenderer.m35985a(java.lang.String, java.lang.String, android.view.View, com.facebook.yoga.YogaNode, com.didiglobal.dittoview.view.DittoCorner, com.didiglobal.dittoview.view.DittoBorder, com.didiglobal.dittoview.view.DittoShadow, java.lang.String, com.didiglobal.dittoview.view.DittoPatch):boolean");
    }

    /* renamed from: a */
    private void m35980a(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setMarginPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setMargin(yogaEdge, Float.parseFloat(str) * this.f49876d);
        }
    }

    /* renamed from: a */
    private void m35981a(YogaEdge yogaEdge, YogaNode yogaNode, String str, View view) {
        if ((view instanceof DittoRecyclerView) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPaddingPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 2));
            yogaNode.setPadding(yogaEdge, (float) parseFloat);
            m35977a(view, yogaEdge, parseFloat);
        } else {
            int parseFloat2 = (int) (Float.parseFloat(str) * this.f49876d);
            yogaNode.setPadding(yogaEdge, (float) parseFloat2);
            m35977a(view, yogaEdge, parseFloat2);
        }
    }

    /* renamed from: a */
    private void m35977a(View view, YogaEdge yogaEdge, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        switch (C167123.$SwitchMap$com$facebook$yoga$YogaEdge[yogaEdge.ordinal()]) {
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

    /* renamed from: com.didiglobal.dittoview.DittoCardRenderer$3 */
    static /* synthetic */ class C167123 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.DittoCardRenderer.C167123.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m35987b(YogaEdge yogaEdge, YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setPositionPercent(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setPosition(yogaEdge, Float.parseFloat(str) * this.f49876d);
        }
    }

    /* renamed from: a */
    private void m35978a(final View view, final String str, final String str2) {
        view.setTag(str);
        if (("card".equals(str2) || !TextUtils.isEmpty(str)) && !"scroll".equals(str2)) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (DittoCardRenderer.this.f49878f != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", str);
                        hashMap.put("k", "click");
                        if ("card".equals(str2)) {
                            DittoCardRenderer.this.f49878f.handleEvent("xpanel_card_ck", str, hashMap);
                        } else if (view.getTag(R.id.cardId) != null) {
                            hashMap.put(com.didi.global.globalgenerickit.eventtracker.Const.BUTTON_ID, (String) view.getTag(R.id.cardId));
                            DittoCardRenderer.this.f49878f.handleEvent("xpanel_button_ck", str, hashMap);
                        } else {
                            DittoCardRenderer.this.f49878f.handleEvent("click", str, hashMap);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private YogaPositionType m35975a(String str) {
        if (TextUtils.isEmpty(str) || !Constants.PATH_TYPE_ABSOLUTE.equals(str)) {
            return YogaPositionType.RELATIVE;
        }
        return YogaPositionType.ABSOLUTE;
    }

    /* renamed from: a */
    private void m35982a(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setHeightPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setHeight(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setHeight((float) ((int) (Float.parseFloat(str) * this.f49876d)));
        }
    }

    /* renamed from: b */
    private void m35988b(YogaNode yogaNode, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("%")) {
            yogaNode.setWidthPercent(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else if (str.endsWith("px")) {
            yogaNode.setWidth(Float.parseFloat(str.substring(0, str.length() - 2)));
        } else {
            yogaNode.setWidth((float) ((int) (Float.parseFloat(str) * this.f49876d)));
        }
    }

    /* renamed from: b */
    private float m35986b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) ((int) (Float.parseFloat(str) * this.f49876d));
    }

    public static float getNumValue(Context context, String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        if (str.endsWith("px")) {
            return Float.parseFloat(str.substring(0, str.length() - 2));
        }
        return (float) DittoUtil.dip2px(context, (float) ((int) Float.parseFloat(str)));
    }

    /* renamed from: c */
    private YogaAlign m35989c(String str) {
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
