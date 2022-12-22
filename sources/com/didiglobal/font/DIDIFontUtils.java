package com.didiglobal.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.IFontConfig;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p245io.ByteStreamsKt;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didiglobal/font/DIDIFontUtils;", "", "()V", "Companion", "fontlib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DIDIFontUtils.kt */
public final class DIDIFontUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f50214a = f50214a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f50215b = f50215b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final HashMap<String, Typeface> f50216c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Lazy f50217d = LazyKt.lazy(DIDIFontUtils$Companion$isSupportFont$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Lazy f50218e = LazyKt.lazy(DIDIFontUtils$Companion$isH5Support$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Lazy f50219f = LazyKt.lazy(DIDIFontUtils$Companion$isFlutterSupport$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Lazy f50220g = LazyKt.lazy(DIDIFontUtils$Companion$cssConfig$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final Lazy f50221h = LazyKt.lazy(DIDIFontUtils$Companion$weightRule$2.INSTANCE);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final Lazy f50222i = LazyKt.lazy(DIDIFontUtils$Companion$mContext$2.INSTANCE);

    /* renamed from: j */
    private static final int f50223j = 0;

    /* renamed from: k */
    private static final int f50224k = 1;

    /* renamed from: l */
    private static final int f50225l = 2;

    /* renamed from: m */
    private static final int f50226m = 3;

    /* renamed from: n */
    private static final int f50227n = 4;

    /* renamed from: o */
    private static final int f50228o = 6;

    /* renamed from: p */
    private static final int f50229p = 5;

    /* renamed from: q */
    private static final int f50230q = 7;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static final Map<Integer, String> f50231r = MapsKt.mapOf(new Pair(0, "DiDiSans-Regular.otf"), new Pair(2, "DiDiSans-RegularItalic.otf"), new Pair(1, "DiDiSans-Bold.otf"), new Pair(3, "DiDiSans-BoldItalic.otf"), new Pair(4, "DiDiSans-Thin.otf"), new Pair(6, "DiDiSans-ThinItalic.otf"), new Pair(5, "DiDiSans-Medium.otf"), new Pair(7, "DiDiSans-MediumItalic.otf"));
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static DiDiWeightRule f50232s;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020\rH\u0002J\u0016\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001cJ\u001a\u00107\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010$2\b\u00108\u001a\u0004\u0018\u00010+J\u0018\u00107\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00109\u001a\u00020:J\u0018\u00107\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00108\u001a\u00020\u0004J \u00107\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u0004H\u0002J \u0010?\u001a\u00020+2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001cJ\u001a\u0010@\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010@\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0002J\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000201\u0018\u00010\u001a2\b\u00102\u001a\u0004\u0018\u00010$J\"\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00102\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u0004\u0018\u00010\rJ\u0016\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020\rJ\u0010\u0010K\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\rH\u0002J \u0010L\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0004J(\u0010L\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001cJ\u0018\u0010N\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010O\u001a\u00020PJ \u0010N\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010O\u001a\u00020P2\u0006\u00108\u001a\u00020+J\u0018\u0010Q\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u0001J \u0010Q\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u00012\u0006\u00108\u001a\u00020+J \u0010Q\u001a\u00020H2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u00012\u0006\u00108\u001a\u00020RJ\u0018\u0010S\u001a\u00020H2\u0006\u00108\u001a\u00020+2\u0006\u0010>\u001a\u00020\u0004H\u0002J\u000e\u0010T\u001a\u00020H2\u0006\u0010M\u001a\u00020UR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001b\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u001c8FX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001f\u0010\u001dR\u001b\u0010!\u001a\u00020\u001c8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b!\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010$8FX\u0002¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\rXD¢\u0006\u0002\n\u0000R*\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020+0*j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020+`,X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b.\u0010\u0010¨\u0006V"}, mo175978d2 = {"Lcom/didiglobal/font/DIDIFontUtils$Companion;", "", "()V", "FONT_BOLD", "", "FONT_BOLD_ITALIC", "FONT_ITALIC", "FONT_MEDIUM", "FONT_MEDIUM_ITALIC", "FONT_REGULAR", "FONT_THIN", "FONT_THIN_ITALIC", "TAG", "", "cssConfig", "getCssConfig", "()Ljava/lang/String;", "cssConfig$delegate", "Lkotlin/Lazy;", "didiWeightRules", "Lcom/didiglobal/font/DiDiWeightRule;", "getDidiWeightRules", "()Lcom/didiglobal/font/DiDiWeightRule;", "setDidiWeightRules", "(Lcom/didiglobal/font/DiDiWeightRule;)V", "didisansMap", "", "isFlutterSupport", "", "()Z", "isFlutterSupport$delegate", "isH5Support", "isH5Support$delegate", "isSupportFont", "isSupportFont$delegate", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext$delegate", "matchKey", "typefaceMap", "Ljava/util/HashMap;", "Landroid/graphics/Typeface;", "Lkotlin/collections/HashMap;", "weightRule", "getWeightRule", "weightRule$delegate", "getByteArray", "", "context", "fontName", "getDidiTypeFaceValueByWeight", "weight", "italic", "getDidiTypeface", "typeface", "attrs", "Landroid/util/AttributeSet;", "assets", "Landroid/content/res/AssetManager;", "path", "style", "getDidiTypefaceByWeight", "getDidiTypefaceValue", "getFontByteArrayMap", "getWebResourceResponse", "Landroid/webkit/WebResourceResponse;", "resourceResponse", "url", "getWeightRuleConfig", "injectCss", "", "webView", "Landroid/webkit/WebView;", "isBlackList", "setFontWeight", "view", "setPaintTypeface", "paint", "Landroid/graphics/Paint;", "setTypeface", "Lcom/didiglobal/font/DiDiTypeface;", "updateTypefaceStyle", "updateViewGroupTypeface", "Landroid/view/View;", "fontlib_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DIDIFontUtils.kt */
    public static final class Companion {
        public final String getCssConfig() {
            Lazy access$getCssConfig$cp = DIDIFontUtils.f50220g;
            Companion companion = DIDIFontUtils.Companion;
            return (String) access$getCssConfig$cp.getValue();
        }

        public final Context getMContext() {
            Lazy access$getMContext$cp = DIDIFontUtils.f50222i;
            Companion companion = DIDIFontUtils.Companion;
            return (Context) access$getMContext$cp.getValue();
        }

        public final String getWeightRule() {
            Lazy access$getWeightRule$cp = DIDIFontUtils.f50221h;
            Companion companion = DIDIFontUtils.Companion;
            return (String) access$getWeightRule$cp.getValue();
        }

        public final boolean isFlutterSupport() {
            Lazy access$isFlutterSupport$cp = DIDIFontUtils.f50219f;
            Companion companion = DIDIFontUtils.Companion;
            return ((Boolean) access$isFlutterSupport$cp.getValue()).booleanValue();
        }

        public final boolean isH5Support() {
            Lazy access$isH5Support$cp = DIDIFontUtils.f50218e;
            Companion companion = DIDIFontUtils.Companion;
            return ((Boolean) access$isH5Support$cp.getValue()).booleanValue();
        }

        public final boolean isSupportFont() {
            Lazy access$isSupportFont$cp = DIDIFontUtils.f50217d;
            Companion companion = DIDIFontUtils.Companion;
            return ((Boolean) access$isSupportFont$cp.getValue()).booleanValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getDidiTypefaceValue(Context context, AttributeSet attributeSet) {
            TypedArray typedArray;
            if (context == null) {
                Context mContext = getMContext();
                typedArray = mContext != null ? mContext.obtainStyledAttributes(attributeSet, C10448R.styleable.didi_text_view_attr_getter) : null;
            } else {
                typedArray = context.obtainStyledAttributes(attributeSet, C10448R.styleable.didi_text_view_attr_getter);
            }
            Companion companion = this;
            if (typedArray == null) {
                Intrinsics.throwNpe();
            }
            int didiTypefaceValue = companion.getDidiTypefaceValue(typedArray.getInt(0, 0));
            typedArray.recycle();
            return didiTypefaceValue;
        }

        public final DiDiWeightRule getDidiWeightRules() {
            return DIDIFontUtils.f50232s;
        }

        public final void setDidiWeightRules(DiDiWeightRule diDiWeightRule) {
            DIDIFontUtils.f50232s = diDiWeightRule;
        }

        public final int getDidiTypeFaceValueByWeight(int i, boolean z) {
            Companion companion = this;
            if (companion.getDidiWeightRules() == null) {
                companion.setDidiWeightRules(new DiDiWeightRule());
            }
            DiDiWeightRule didiWeightRules = companion.getDidiWeightRules();
            if (didiWeightRules == null) {
                Intrinsics.throwNpe();
            }
            didiWeightRules.parse(companion.getWeightRule());
            DiDiWeightRule didiWeightRules2 = companion.getDidiWeightRules();
            if (didiWeightRules2 == null) {
                Intrinsics.throwNpe();
            }
            int weightType = didiWeightRules2.getWeightType(i);
            int i2 = 4;
            int i3 = 0;
            if (!companion.isSupportFont()) {
                if (!(weightType == 1 || weightType == 2 || (weightType != 3 && weightType != 4))) {
                    i3 = 1;
                }
                if (z) {
                    if (i3 == 1) {
                        return 3;
                    }
                    if (i3 == 0) {
                        return 2;
                    }
                }
                return i3;
            }
            if (weightType != 1) {
                if (weightType != 2) {
                    if (weightType == 3) {
                        i2 = 5;
                    } else if (weightType == 4) {
                        i2 = 1;
                    }
                }
                i2 = 0;
            }
            return z ? i2 + 2 : i2;
        }

        public final Typeface getDidiTypefaceByWeight(Context context, int i, boolean z) {
            AssetManager assetManager;
            Companion companion = this;
            int didiTypefaceValue = companion.getDidiTypefaceValue(companion.getDidiTypeFaceValueByWeight(i, z));
            String str = (String) DIDIFontUtils.f50231r.get(Integer.valueOf(didiTypefaceValue));
            if (str != null) {
                Typeface typeface = null;
                if (context == null) {
                    Context mContext = companion.getMContext();
                    assetManager = mContext != null ? mContext.getAssets() : null;
                } else {
                    assetManager = context.getAssets();
                }
                if (assetManager != null) {
                    Companion companion2 = DIDIFontUtils.Companion;
                    typeface = companion2.getDidiTypeface(assetManager, "font/" + str, didiTypefaceValue);
                }
                if (typeface == null) {
                    Intrinsics.throwNpe();
                }
                return typeface;
            }
            Typeface defaultFromStyle = Typeface.defaultFromStyle(0);
            Intrinsics.checkExpressionValueIsNotNull(defaultFromStyle, "Typeface.defaultFromStyle(Typeface.NORMAL)");
            return defaultFromStyle;
        }

        private final int getDidiTypefaceValue(int i) {
            if (!isSupportFont()) {
                return i;
            }
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i != 3) {
                return i;
            }
            return 3;
        }

        public final Typeface getDidiTypeface(Context context, AttributeSet attributeSet) {
            AssetManager assetManager;
            Intrinsics.checkParameterIsNotNull(attributeSet, RavenKey.ATTRS);
            Companion companion = this;
            int didiTypefaceValue = companion.getDidiTypefaceValue(context, attributeSet);
            if (!companion.isSupportFont()) {
                Typeface defaultFromStyle = Typeface.defaultFromStyle(didiTypefaceValue);
                Intrinsics.checkExpressionValueIsNotNull(defaultFromStyle, "Typeface.defaultFromStyle(style)");
                return defaultFromStyle;
            }
            String str = (String) DIDIFontUtils.f50231r.get(Integer.valueOf(didiTypefaceValue));
            if (str == null) {
                str = (String) MapsKt.getValue(DIDIFontUtils.f50231r, 0);
            }
            Typeface typeface = null;
            if (context == null) {
                Context mContext = companion.getMContext();
                assetManager = mContext != null ? mContext.getAssets() : null;
            } else {
                assetManager = context.getAssets();
            }
            if (assetManager != null) {
                Companion companion2 = DIDIFontUtils.Companion;
                typeface = companion2.getDidiTypeface(assetManager, "font/" + str, didiTypefaceValue);
            }
            if (typeface == null) {
                Intrinsics.throwNpe();
            }
            return typeface;
        }

        public final Typeface getDidiTypeface(Context context, Typeface typeface) {
            AssetManager assetManager;
            if (typeface == null) {
                Typeface defaultFromStyle = Typeface.defaultFromStyle(0);
                Intrinsics.checkExpressionValueIsNotNull(defaultFromStyle, "Typeface.defaultFromStyle(Typeface.NORMAL)");
                return defaultFromStyle;
            }
            Companion companion = this;
            if (!companion.isSupportFont()) {
                return typeface;
            }
            int didiTypefaceValue = companion.getDidiTypefaceValue(typeface.getStyle());
            String str = (String) DIDIFontUtils.f50231r.get(Integer.valueOf(didiTypefaceValue));
            if (str != null) {
                typeface = null;
                if (context == null) {
                    Context mContext = companion.getMContext();
                    assetManager = mContext != null ? mContext.getAssets() : null;
                } else {
                    assetManager = context.getAssets();
                }
                if (assetManager != null) {
                    Companion companion2 = DIDIFontUtils.Companion;
                    typeface = companion2.getDidiTypeface(assetManager, "font/" + str, didiTypefaceValue);
                }
                if (typeface == null) {
                    Intrinsics.throwNpe();
                }
            }
            return typeface;
        }

        public final Typeface getDidiTypeface(Context context, int i) {
            AssetManager assetManager;
            Companion companion = this;
            int didiTypefaceValue = companion.getDidiTypefaceValue(i);
            String str = (String) DIDIFontUtils.f50231r.get(Integer.valueOf(didiTypefaceValue));
            if (str != null) {
                Typeface typeface = null;
                if (context == null) {
                    Context mContext = companion.getMContext();
                    assetManager = mContext != null ? mContext.getAssets() : null;
                } else {
                    assetManager = context.getAssets();
                }
                if (assetManager != null) {
                    Companion companion2 = DIDIFontUtils.Companion;
                    typeface = companion2.getDidiTypeface(assetManager, "font/" + str, didiTypefaceValue);
                }
                if (typeface == null) {
                    Intrinsics.throwNpe();
                }
                return typeface;
            }
            Typeface defaultFromStyle = Typeface.defaultFromStyle(0);
            Intrinsics.checkExpressionValueIsNotNull(defaultFromStyle, "Typeface.defaultFromStyle(Typeface.NORMAL)");
            return defaultFromStyle;
        }

        private final Typeface getDidiTypeface(AssetManager assetManager, String str, int i) {
            Typeface typeface = (Typeface) DIDIFontUtils.f50216c.get(str);
            if (typeface == null) {
                typeface = Typeface.createFromAsset(assetManager, str);
                Intrinsics.checkExpressionValueIsNotNull(typeface, "typeface");
                DIDIFontUtils.f50216c.put(str, typeface);
            }
            updateTypefaceStyle(typeface, i);
            return typeface;
        }

        public final void setPaintTypeface(Context context, Paint paint, Typeface typeface) {
            Intrinsics.checkParameterIsNotNull(paint, "paint");
            Intrinsics.checkParameterIsNotNull(typeface, "typeface");
            paint.setTypeface(getDidiTypeface(context, typeface));
        }

        public final void setPaintTypeface(Context context, Paint paint) {
            Intrinsics.checkParameterIsNotNull(paint, "paint");
            Companion companion = this;
            Typeface typeface = paint.getTypeface();
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            paint.setTypeface(companion.getDidiTypeface(context, typeface));
        }

        public final void setTypeface(Context context, Object obj) {
            Intrinsics.checkParameterIsNotNull(obj, "view");
            if ((obj instanceof Paint) || (obj instanceof TextPaint)) {
                Paint paint = (Paint) obj;
                Companion companion = this;
                Typeface typeface = paint.getTypeface();
                if (typeface == null) {
                    typeface = Typeface.DEFAULT;
                }
                paint.setTypeface(companion.getDidiTypeface(context, typeface));
            } else if ((obj instanceof TextView) || (obj instanceof Button) || (obj instanceof EditText)) {
                TextView textView = (TextView) obj;
                Companion companion2 = this;
                Typeface typeface2 = textView.getTypeface();
                if (typeface2 == null) {
                    typeface2 = Typeface.DEFAULT;
                }
                textView.setTypeface(companion2.getDidiTypeface(context, typeface2));
            } else {
                String access$getTAG$cp = DIDIFontUtils.f50214a;
                SystemUtils.log(6, access$getTAG$cp, "view name " + obj.getClass().getName(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 289);
            }
        }

        public final void setTypeface(Context context, Object obj, Typeface typeface) {
            Intrinsics.checkParameterIsNotNull(obj, "view");
            Intrinsics.checkParameterIsNotNull(typeface, "typeface");
            if ((obj instanceof Paint) || (obj instanceof TextPaint)) {
                ((Paint) obj).setTypeface(getDidiTypeface(context, typeface));
            } else if ((obj instanceof TextView) || (obj instanceof Button) || (obj instanceof EditText)) {
                ((TextView) obj).setTypeface(getDidiTypeface(context, typeface));
            } else {
                String access$getTAG$cp = DIDIFontUtils.f50214a;
                SystemUtils.log(6, access$getTAG$cp, "view name " + obj.getClass().getName(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 304);
            }
        }

        public final void setTypeface(Context context, Object obj, DiDiTypeface diDiTypeface) {
            Intrinsics.checkParameterIsNotNull(obj, "view");
            Intrinsics.checkParameterIsNotNull(diDiTypeface, "typeface");
            if ((obj instanceof Paint) || (obj instanceof TextPaint)) {
                ((Paint) obj).setTypeface(getDidiTypeface(context, diDiTypeface.getType()));
            } else if ((obj instanceof TextView) || (obj instanceof Button) || (obj instanceof EditText)) {
                ((TextView) obj).setTypeface(getDidiTypeface(context, diDiTypeface.getType()));
            } else {
                String access$getTAG$cp = DIDIFontUtils.f50214a;
                SystemUtils.log(6, access$getTAG$cp, "view name " + obj.getClass().getName(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 319);
            }
        }

        public final void setFontWeight(Context context, Object obj, int i) {
            Intrinsics.checkParameterIsNotNull(obj, "view");
            Companion companion = this;
            int didiTypeFaceValueByWeight = companion.getDidiTypeFaceValueByWeight(i, false);
            if ((obj instanceof Paint) || (obj instanceof TextPaint)) {
                ((Paint) obj).setTypeface(companion.getDidiTypeface(context, didiTypeFaceValueByWeight));
            } else if ((obj instanceof TextView) || (obj instanceof Button) || (obj instanceof EditText)) {
                ((TextView) obj).setTypeface(companion.getDidiTypeface(context, didiTypeFaceValueByWeight));
            } else {
                String access$getTAG$cp = DIDIFontUtils.f50214a;
                SystemUtils.log(6, access$getTAG$cp, "view name " + obj.getClass().getName(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 332);
            }
        }

        public final void setFontWeight(Context context, Object obj, int i, boolean z) {
            Intrinsics.checkParameterIsNotNull(obj, "view");
            Companion companion = this;
            int didiTypeFaceValueByWeight = companion.getDidiTypeFaceValueByWeight(i, z);
            if ((obj instanceof Paint) || (obj instanceof TextPaint)) {
                ((Paint) obj).setTypeface(companion.getDidiTypeface(context, didiTypeFaceValueByWeight));
            } else if ((obj instanceof TextView) || (obj instanceof Button) || (obj instanceof EditText)) {
                ((TextView) obj).setTypeface(companion.getDidiTypeface(context, didiTypeFaceValueByWeight));
            } else {
                String access$getTAG$cp = DIDIFontUtils.f50214a;
                SystemUtils.log(6, access$getTAG$cp, "view name " + obj.getClass().getName(), (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 344);
            }
        }

        private final void updateTypefaceStyle(Typeface typeface, int i) {
            try {
                Field declaredField = typeface.getClass().getDeclaredField("mStyle");
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "clazz.getDeclaredField(\"mStyle\")");
                declaredField.setAccessible(true);
                declaredField.setInt(typeface, i);
                declaredField.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void updateViewGroupTypeface(View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            if (isSupportFont()) {
                Field[] declaredFields = view.getClass().getDeclaredFields();
                Intrinsics.checkExpressionValueIsNotNull(declaredFields, "clazz.declaredFields");
                for (Field field : declaredFields) {
                    Intrinsics.checkExpressionValueIsNotNull(field, "field");
                    field.setAccessible(true);
                    try {
                        Object obj = field.get(view);
                        if (obj instanceof ViewGroup) {
                            updateViewGroupTypeface((View) obj);
                        } else {
                            Context context = view.getContext();
                            Intrinsics.checkExpressionValueIsNotNull(obj, "subView");
                            setTypeface(context, obj);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    field.setAccessible(false);
                }
            }
        }

        private final boolean isBlackList(String str) {
            ServiceLoader<S> load = ServiceLoader.load(IFontConfig.class);
            Intrinsics.checkExpressionValueIsNotNull(load, "support");
            Iterator it = load.iterator();
            if (!it.hasNext()) {
                return false;
            }
            Boolean isH5Support = ((IFontConfig) it.next()).isH5Support(str);
            String access$getTAG$cp = DIDIFontUtils.f50214a;
            SystemUtils.log(3, access$getTAG$cp, "h5BlackList support " + isH5Support, (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion", 387);
            Intrinsics.checkExpressionValueIsNotNull(isH5Support, "isSupport");
            return isH5Support.booleanValue();
        }

        public final void injectCss(WebView webView, String str) {
            Intrinsics.checkParameterIsNotNull(webView, "webView");
            Intrinsics.checkParameterIsNotNull(str, "url");
            Companion companion = this;
            if (companion.isSupportFont() && companion.isH5Support() && !companion.isBlackList(str)) {
                webView.loadUrl(companion.getCssConfig());
            }
        }

        public final WebResourceResponse getWebResourceResponse(Context context, WebResourceResponse webResourceResponse, String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "url");
            Companion companion = this;
            if (companion.isSupportFont() && companion.isH5Support()) {
                CharSequence charSequence = str;
                if (!TextUtils.isEmpty(charSequence) && StringsKt.contains$default(charSequence, (CharSequence) DIDIFontUtils.f50215b, false, 2, (Object) null)) {
                    String substring = str.substring(StringsKt.indexOf$default(charSequence, DIDIFontUtils.f50215b, 0, false, 6, (Object) null) + DIDIFontUtils.f50215b.length());
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    try {
                        AssetManager assets = context.getAssets();
                        return new WebResourceResponse("application/x-font-otf", "UTF8", assets.open("font/" + substring));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return webResourceResponse;
        }

        public final String getWeightRuleConfig() {
            Companion companion = this;
            if (!companion.isSupportFont() || !companion.isFlutterSupport()) {
                return null;
            }
            return companion.getWeightRule();
        }

        public final Map<String, byte[]> getFontByteArrayMap(Context context) {
            Companion companion = this;
            if (!companion.isSupportFont() || !companion.isFlutterSupport()) {
                return null;
            }
            byte[] bArr = null;
            HashMap hashMap = new HashMap();
            byte[] byteArray = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 0));
            byte[] byteArray2 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 1));
            byte[] byteArray3 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 2));
            byte[] byteArray4 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 3));
            byte[] byteArray5 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 4));
            byte[] byteArray6 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 6));
            byte[] byteArray7 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 5));
            byte[] byteArray8 = companion.getByteArray(context, (String) MapsKt.getValue(DIDIFontUtils.f50231r, 7));
            if (byteArray != null) {
                hashMap.put(BlocksConst.BLOCK_FONT_REGULAR, byteArray);
            }
            if (byteArray2 != null) {
                hashMap.put(BlocksConst.BLOCK_FONT_BOLD, byteArray2);
            }
            if (byteArray4 != null) {
                hashMap.put("bold_italic", byteArray4);
            }
            if (byteArray3 != null) {
                hashMap.put("regular_italic", byteArray3);
            }
            if (byteArray5 != null) {
                hashMap.put("thin", byteArray5);
            }
            if (byteArray6 != null) {
                hashMap.put("thin_italic", byteArray6);
            }
            if (byteArray7 != null) {
                hashMap.put("medium", byteArray7);
            }
            if (byteArray8 != null) {
                hashMap.put("medium_italic", byteArray8);
            }
            return hashMap;
        }

        private final byte[] getByteArray(Context context, String str) {
            InputStream inputStream;
            AssetManager assets;
            byte[] bArr = null;
            byte[] bArr2 = null;
            InputStream inputStream2 = null;
            if (context != null) {
                try {
                    inputStream = context.getAssets().open("font/" + str);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (inputStream2 == null) {
                        return bArr2;
                    }
                    inputStream2.close();
                    return bArr2;
                } catch (Throwable th) {
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    throw th;
                }
            } else {
                Context mContext = getMContext();
                if (mContext == null || (assets = mContext.getAssets()) == null) {
                    inputStream = null;
                } else {
                    inputStream = assets.open("font/" + str);
                }
            }
            InputStream inputStream3 = inputStream;
            if (inputStream3 != null) {
                bArr = ByteStreamsKt.readBytes(inputStream3);
            }
            if (inputStream3 != null) {
                inputStream3.close();
            }
            return bArr;
        }
    }
}
