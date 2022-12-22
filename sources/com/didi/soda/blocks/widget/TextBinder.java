package com.didi.soda.blocks.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksFontHandler;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.utils.FontManager;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@WidgetNameMeta(widgetName = "Text")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\nH\u0002J\u0012\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\nH\u0002J\u0010\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0007H\u0002J\u001e\u00101\u001a\u00020(2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/TextBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fontStyle", "", "fontWeight", "xGravity", "", "yGravity", "bindProps", "", "props", "Ljava/util/HashMap;", "", "createView", "processTextTypeface", "requestLayout", "setColor", "color", "setFontFamily", "fontFamily", "setFontFamilyByInject", "setFontSize", "fontSize", "", "setFontStyle", "setFontWeight", "setLetterSpacing", "letterSpacing", "setLineHeight", "lineHeight", "setText", "text", "setTextAlign", "textAlign", "setTextCopyEnable", "textCopyEnable", "", "setTextDecoration", "textDecoration", "setTextLineClamp", "lines", "setTextOverflow", "overflow", "setTextVerticalAlign", "textVerticalAlign", "shouldShow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: TextBinder.kt */
public class TextBinder extends BaseBinder<TextView> {
    private String fontStyle;
    private String fontWeight;
    private int xGravity;
    private int yGravity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextBinder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public TextView createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new TextView(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.get("text");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            java.lang.String r0 = "text"
            java.lang.Object r2 = r2.get(r0)
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = r2.toString()
            goto L_0x0011
        L_0x0010:
            r2 = 0
        L_0x0011:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r2 = r2 ^ 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.TextBinder.shouldShow(java.util.HashMap):boolean");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str.hashCode()) {
                    case -1550943582:
                        if (!str.equals(Const.BlockParamConst.FONT_STYLE)) {
                            break;
                        } else {
                            setFontStyle(value.toString());
                            break;
                        }
                    case -1547288966:
                        if (!str.equals(Const.BlockParamConst.TEXT_LINE_CLAMP)) {
                            break;
                        } else {
                            setTextLineClamp(Integer.parseInt(value.toString()));
                            break;
                        }
                    case -1387535771:
                        if (!str.equals(Const.BlockParamConst.TEXT_COPY_ENABLE)) {
                            break;
                        } else {
                            setTextCopyEnable(Intrinsics.areEqual((Object) value.toString(), (Object) "1"));
                            break;
                        }
                    case -1224696685:
                        if (!str.equals(Const.BlockParamConst.FONT_FAMILY)) {
                            break;
                        } else {
                            setFontFamilyByInject(value.toString());
                            break;
                        }
                    case -1065511464:
                        if (!str.equals(Const.BlockParamConst.TEXT_ALIGN)) {
                            break;
                        } else {
                            setTextAlign(value.toString());
                            break;
                        }
                    case -879295043:
                        if (!str.equals(Const.BlockParamConst.TEXT_DECORATION)) {
                            break;
                        } else {
                            setTextDecoration(value.toString());
                            break;
                        }
                    case -734428249:
                        if (!str.equals(Const.BlockParamConst.FONT_WEIGHT)) {
                            break;
                        } else {
                            setFontWeight(value.toString());
                            break;
                        }
                    case -515807685:
                        if (!str.equals(Const.BlockParamConst.LINE_HEIGHT)) {
                            break;
                        } else {
                            setLineHeight((int) ValueManagerKt.convert2Num(value, str));
                            break;
                        }
                    case -292817662:
                        if (!str.equals(Const.BlockParamConst.TEXT_VERTICAL_ALIGN)) {
                            break;
                        } else {
                            setTextVerticalAlign(value.toString());
                            break;
                        }
                    case 3556653:
                        if (!str.equals("text")) {
                            break;
                        } else {
                            setText(value.toString());
                            break;
                        }
                    case 94842723:
                        if (!str.equals("color")) {
                            break;
                        } else {
                            setColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case 261414991:
                        if (!str.equals(Const.BlockParamConst.TEXT_OVERFLOW)) {
                            break;
                        } else {
                            setTextOverflow(value.toString());
                            break;
                        }
                    case 365601008:
                        if (!str.equals(Const.BlockParamConst.FONT_SIZE)) {
                            break;
                        } else {
                            setFontSize(ValueManagerKt.convert2Num(value, str));
                            break;
                        }
                    case 2111078717:
                        if (!str.equals(Const.BlockParamConst.LETTER_SPACING)) {
                            break;
                        } else {
                            setLetterSpacing(ValueManagerKt.convert2Num(value, str));
                            break;
                        }
                }
            }
            super.bindProps(hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void setText(String str) {
        ((TextView) getView()).setText(str);
        requestLayout();
    }

    private final void setColor(int i) {
        ((TextView) getView()).setTextColor(i);
    }

    private final void setFontFamilyByInject(String str) {
        IBlocksFontHandler fontHandler;
        if (str != null && (fontHandler = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getFontHandler()) != null) {
            fontHandler.setTypeFace((TextView) getView(), str);
        }
    }

    private final void setFontFamily(String str) {
        int i;
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            Object[] array = new Regex(" ").split(charSequence, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (!(strArr.length == 0)) {
                    String fontsAssetsPath = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getFontsAssetsPath();
                    if (((TextView) getView()).getTypeface() != null) {
                        Typeface typeface = ((TextView) getView()).getTypeface();
                        Intrinsics.checkExpressionValueIsNotNull(typeface, "getView().typeface");
                        i = typeface.getStyle();
                    } else {
                        i = 0;
                    }
                    for (String str2 : strArr) {
                        FontManager instance = FontManager.getInstance();
                        int length = r6.length() - 1;
                        int i2 = 0;
                        boolean z = false;
                        while (i2 <= length) {
                            boolean z2 = r6.charAt(!z ? i2 : length) <= ' ';
                            if (!z) {
                                if (!z2) {
                                    z = true;
                                } else {
                                    i2++;
                                }
                            } else if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        }
                        Typeface typeface2 = instance.getTypeface(r6.subSequence(i2, length + 1).toString(), fontsAssetsPath, i, getContext().getAssets());
                        Intrinsics.checkExpressionValueIsNotNull(typeface2, "FontManager.getInstance(…xt().assets\n            )");
                        if (typeface2 != null) {
                            ((TextView) getView()).setTypeface(typeface2);
                            requestLayout();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private final void setFontSize(float f) {
        ((TextView) getView()).setTextSize(0, f);
        requestLayout();
    }

    private final void setFontWeight(String str) {
        if (!TextUtils.isEmpty(str)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                this.fontWeight = lowerCase;
                processTextTypeface(str, this.fontStyle);
                requestLayout();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void setFontStyle(String str) {
        if (!TextUtils.isEmpty(str)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                this.fontStyle = lowerCase;
                processTextTypeface(this.fontWeight, lowerCase);
                requestLayout();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void processTextTypeface(String str, String str2) {
        if (Intrinsics.areEqual((Object) BlocksConst.BLOCK_FONT_BOLD, (Object) str) && Intrinsics.areEqual((Object) "italic", (Object) str2)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 3);
        } else if (Intrinsics.areEqual((Object) BlocksConst.BLOCK_FONT_BOLD, (Object) str)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 1);
        } else if (Intrinsics.areEqual((Object) "italic", (Object) str2)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 2);
        } else {
            ((TextView) getView()).setTypeface((Typeface) null, 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setTextAlign(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x000e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000c
            goto L_0x000e
        L_0x000c:
            r0 = 0
            goto L_0x000f
        L_0x000e:
            r0 = 1
        L_0x000f:
            if (r0 == 0) goto L_0x0012
            return
        L_0x0012:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "Locale.getDefault()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            if (r4 == 0) goto L_0x009d
            java.lang.String r4 = r4.toLowerCase(r0)
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            int r0 = r4.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r2 = 8388627(0x800013, float:1.175497E-38)
            if (r0 == r1) goto L_0x0069
            r1 = 3317767(0x32a007, float:4.649182E-39)
            if (r0 == r1) goto L_0x0055
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L_0x003d
            goto L_0x007f
        L_0x003d:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x007f
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 8388629(0x800015, float:1.1754973E-38)
            r4.setGravity(r0)
            r3.xGravity = r0
            goto L_0x008a
        L_0x0055:
            java.lang.String r0 = "left"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x007f
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setGravity(r2)
            r3.xGravity = r2
            goto L_0x008a
        L_0x0069:
            java.lang.String r0 = "center"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x007f
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 17
            r4.setGravity(r0)
            r3.xGravity = r0
            goto L_0x008a
        L_0x007f:
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setGravity(r2)
            r3.xGravity = r2
        L_0x008a:
            int r4 = r3.yGravity
            if (r4 == 0) goto L_0x009c
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r0 = r3.xGravity
            int r1 = r3.yGravity
            r0 = r0 | r1
            r4.setGravity(r0)
        L_0x009c:
            return
        L_0x009d:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.TextBinder.setTextAlign(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setTextVerticalAlign(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r1 = "Locale.getDefault()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            if (r4 == 0) goto L_0x0093
            java.lang.String r4 = r4.toLowerCase(r0)
            java.lang.String r0 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            int r0 = r4.hashCode()
            r1 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
            r2 = 16
            if (r0 == r1) goto L_0x005f
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r0 == r1) goto L_0x004b
            r1 = 115029(0x1c155, float:1.6119E-40)
            if (r0 == r1) goto L_0x0034
            goto L_0x0075
        L_0x0034:
            java.lang.String r0 = "top"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0075
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 48
            r4.setGravity(r0)
            r3.yGravity = r0
            goto L_0x0080
        L_0x004b:
            java.lang.String r0 = "center"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0075
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setGravity(r2)
            r3.yGravity = r2
            goto L_0x0080
        L_0x005f:
            java.lang.String r0 = "bottom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0075
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r0 = 80
            r4.setGravity(r0)
            r3.yGravity = r0
            goto L_0x0080
        L_0x0075:
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setGravity(r2)
            r3.yGravity = r2
        L_0x0080:
            int r4 = r3.xGravity
            if (r4 == 0) goto L_0x0092
            android.view.View r4 = r3.getView()
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r0 = r3.xGravity
            int r1 = r3.yGravity
            r0 = r0 | r1
            r4.setGravity(r0)
        L_0x0092:
            return
        L_0x0093:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.TextBinder.setTextVerticalAlign(java.lang.String):void");
    }

    private final void setTextDecoration(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                int hashCode = lowerCase.hashCode();
                if (hashCode != -1171789332) {
                    if (hashCode == -1026963764 && lowerCase.equals("underline")) {
                        TextPaint paint = ((TextView) getView()).getPaint();
                        Intrinsics.checkExpressionValueIsNotNull(paint, "getView().paint");
                        paint.setFlags(8);
                        return;
                    }
                } else if (lowerCase.equals("line-through")) {
                    TextPaint paint2 = ((TextView) getView()).getPaint();
                    Intrinsics.checkExpressionValueIsNotNull(paint2, "getView().paint");
                    paint2.setFlags(16);
                    return;
                }
                TextPaint paint3 = ((TextView) getView()).getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint3, "getView().paint");
                paint3.setFlags(0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void setTextOverflow(String str) {
        if (!TextUtils.isEmpty(str)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (str != null) {
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                int hashCode = lowerCase.hashCode();
                if (hashCode != 3056464) {
                    if (hashCode == 188702929 && lowerCase.equals("ellipsis")) {
                        ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.END);
                        requestLayout();
                        return;
                    }
                } else if (lowerCase.equals("clip")) {
                    ((TextView) getView()).setEllipsize((TextUtils.TruncateAt) null);
                    requestLayout();
                    return;
                }
                ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.END);
                requestLayout();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void setTextLineClamp(int i) {
        TextView textView = (TextView) getView();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        textView.setSingleLine(z);
        TextView textView2 = (TextView) getView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        textView2.setMaxLines(i);
        requestLayout();
    }

    private final void setLetterSpacing(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((TextView) getView()).setLetterSpacing(f);
            requestLayout();
        }
    }

    private final void setLineHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            ((TextView) getView()).setLineHeight(i);
            requestLayout();
        }
    }

    private final void setTextCopyEnable(boolean z) {
        ((TextView) getView()).setTextIsSelectable(z);
    }

    private final void requestLayout() {
        ((TextView) getView()).requestLayout();
    }
}
