package com.didi.soda.blocks.style;

import android.graphics.RectF;
import android.view.View;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.widget.image.BackgroundHelper;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import rui.config.RConfigConstants;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\u00020\u000e2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0012J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0012\u0010%\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u001bH\u0002J\u001a\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/CommonStylePainter;", "", "binder", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/view/View;", "(Lcom/didi/soda/blocks/style/BaseBinder;)V", "mBackgroundHelper", "Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "mTargetView", "mYogaNode", "Lcom/facebook/yoga/YogaNode;", "getBackgroundHelper", "getTargetView", "paint", "", "styles", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "refreshBoxSizing", "resetAllCommonStyles", "setBackgroundColor", "color", "", "setBorderBottomColor", "setBorderBottomLeftRadius", "radius", "", "setBorderBottomRightRadius", "setBorderBottomWidth", "width", "setBorderColor", "setBorderLeftColor", "setBorderLeftWidth", "setBorderRadius", "setBorderRightColor", "setBorderRightWidth", "setBorderStyle", "style", "setBorderTopColor", "setBorderTopLeftRadius", "setBorderTopRightRadius", "setBorderTopWidth", "setBorderWidth", "setOpacity", "opacity", "setShadow", "key", "shadow", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonStylePainter.kt */
public final class CommonStylePainter {
    private final BackgroundHelper mBackgroundHelper;
    private final View mTargetView;
    private final YogaNode mYogaNode;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.didi.soda.blocks.style.BaseBinder, java.lang.Object, com.didi.soda.blocks.style.BaseBinder<? extends android.view.View>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CommonStylePainter(com.didi.soda.blocks.style.BaseBinder<? extends android.view.View> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "binder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            r1.<init>()
            android.view.View r0 = r2.getView()
            r1.mTargetView = r0
            com.facebook.yoga.YogaNode r0 = r2.getYogaNode()
            r1.mYogaNode = r0
            com.didi.soda.blocks.widget.image.BackgroundHelper r2 = r2.getBackGroundHelper()
            r1.mBackgroundHelper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.style.CommonStylePainter.<init>(com.didi.soda.blocks.style.BaseBinder):void");
    }

    public final void paint(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str.hashCode()) {
                    case -1989576717:
                        if (!str.equals(Const.StyleConst.BORDER_RIGHT_COLOR)) {
                            break;
                        } else {
                            setBorderRightColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case -1971292586:
                        if (!str.equals(Const.StyleConst.BORDER_RIGHT_WIDTH)) {
                            break;
                        } else {
                            setBorderRightWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1470826662:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_COLOR)) {
                            break;
                        } else {
                            setBorderTopColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case -1452542531:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_WIDTH)) {
                            break;
                        } else {
                            setBorderTopWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1308858324:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_COLOR)) {
                            break;
                        } else {
                            setBorderBottomColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case -1290574193:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_WIDTH)) {
                            break;
                        } else {
                            setBorderBottomWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1267206133:
                        if (!str.equals("opacity")) {
                            break;
                        } else {
                            setOpacity(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1228066334:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_LEFT_RADIUS)) {
                            break;
                        } else {
                            setBorderTopLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -1122140597:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_START_RADIUS)) {
                            break;
                        } else {
                            setBorderTopLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -867333731:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_START_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -483490364:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_END_RADIUS)) {
                            break;
                        } else {
                            setBorderTopRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -242276144:
                        if (!str.equals(Const.StyleConst.BORDER_LEFT_COLOR)) {
                            break;
                        } else {
                            setBorderLeftColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case -223992013:
                        if (!str.equals(Const.StyleConst.BORDER_LEFT_WIDTH)) {
                            break;
                        } else {
                            setBorderLeftWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case -148030058:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_END_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 333432965:
                        if (!str.equals(Const.StyleConst.BORDER_TOP_RIGHT_RADIUS)) {
                            break;
                        } else {
                            setBorderTopRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 581268560:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_LEFT_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomLeftRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 588239831:
                        if (!str.equals(Const.StyleConst.BORDER_BOTTOM_RIGHT_RADIUS)) {
                            break;
                        } else {
                            setBorderBottomRightRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 722830999:
                        if (!str.equals("borderColor")) {
                            break;
                        } else {
                            setBorderColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case 737768677:
                        if (!str.equals(Const.StyleConst.BORDER_STYLE)) {
                            break;
                        } else {
                            setBorderStyle(value.toString());
                            break;
                        }
                    case 741115130:
                        if (!str.equals("borderWidth")) {
                            break;
                        } else {
                            setBorderWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 743055051:
                        if (!str.equals(Const.StyleConst.BOX_SHADOW)) {
                            break;
                        } else {
                            setShadow(Const.StyleConst.BOX_SHADOW, value.toString());
                            break;
                        }
                    case 1220735892:
                        if (!str.equals(Const.StyleConst.BORDER_END_COLOR)) {
                            break;
                        } else {
                            setBorderRightColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case 1239020023:
                        if (!str.equals(Const.StyleConst.BORDER_END_WIDTH)) {
                            break;
                        } else {
                            setBorderRightWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 1287124693:
                        if (!str.equals("backgroundColor")) {
                            break;
                        } else {
                            setBackgroundColor(value);
                            break;
                        }
                    case 1349188574:
                        if (!str.equals("borderRadius")) {
                            break;
                        } else {
                            setBorderRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                    case 2119889261:
                        if (!str.equals(Const.StyleConst.BORDER_START_COLOR)) {
                            break;
                        } else {
                            setBorderLeftColor(ColorUtils.parseColor(value.toString()));
                            break;
                        }
                    case 2138173392:
                        if (!str.equals(Const.StyleConst.BORDER_START_WIDTH)) {
                            break;
                        } else {
                            setBorderLeftWidth(ValueManagerKt.convert2Num(value));
                            break;
                        }
                }
            }
        }
    }

    private final BackgroundHelper getBackgroundHelper() {
        return this.mBackgroundHelper;
    }

    private final void setBackgroundColor(int i) {
        getBackgroundHelper().setBackgroundColor(i);
    }

    private final void setBackgroundColor(Object obj) {
        if (obj != null) {
            getBackgroundHelper().setBackgroundColor(ColorUtils.convertColor(obj));
        }
    }

    private final void setOpacity(float f) {
        getTargetView().setAlpha(f);
    }

    private final void setBorderStyle(String str) {
        this.mBackgroundHelper.setBorderStyle(str);
    }

    private final void setBorderWidth(float f) {
        this.mBackgroundHelper.setBorderWidth(f);
        refreshBoxSizing();
    }

    private final void setBorderLeftWidth(float f) {
        this.mBackgroundHelper.setBorderLeftWidth(f);
        refreshBoxSizing();
    }

    private final void setBorderTopWidth(float f) {
        this.mBackgroundHelper.setBorderTopWidth(f);
        refreshBoxSizing();
    }

    private final void setBorderRightWidth(float f) {
        this.mBackgroundHelper.setBorderRightWidth(f);
        refreshBoxSizing();
    }

    private final void setBorderBottomWidth(float f) {
        this.mBackgroundHelper.setBorderBottomWidth(f);
        refreshBoxSizing();
    }

    private final void setBorderColor(int i) {
        this.mBackgroundHelper.setBorderColor(i);
    }

    private final void setBorderLeftColor(int i) {
        this.mBackgroundHelper.setBorderLeftColor(i);
    }

    private final void setBorderTopColor(int i) {
        this.mBackgroundHelper.setBorderTopColor(i);
    }

    private final void setBorderRightColor(int i) {
        this.mBackgroundHelper.setBorderRightColor(i);
    }

    private final void setBorderBottomColor(int i) {
        this.mBackgroundHelper.setBorderBottomColor(i);
    }

    private final void setBorderRadius(float f) {
        this.mBackgroundHelper.setBorderRadius(f);
    }

    private final void setBorderTopLeftRadius(float f) {
        this.mBackgroundHelper.setBorderTopLeftRadius(f);
    }

    private final void setBorderTopRightRadius(float f) {
        this.mBackgroundHelper.setBorderTopRightRadius(f);
    }

    private final void setBorderBottomRightRadius(float f) {
        this.mBackgroundHelper.setBorderBottomRightRadius(f);
    }

    private final void setBorderBottomLeftRadius(float f) {
        this.mBackgroundHelper.setBorderBottomLeftRadius(f);
    }

    private final void setShadow(String str, String str2) {
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Object[] array = new Regex(" ").split(charSequence, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length >= 2) {
                    float[] fArr = new float[3];
                    int length = strArr.length;
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!StringsKt.startsWith$default(strArr[i2], RConfigConstants.KEYWORD_COLOR_SIGN, false, 2, (Object) null)) {
                            fArr[i2] = ValueManagerKt.convert2Num((Object) strArr[i2], str);
                        } else {
                            i = ColorUtils.parseColor(strArr[3]);
                        }
                    }
                    this.mBackgroundHelper.setShadow(fArr[2], fArr[0], fArr[1], i);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private final void refreshBoxSizing() {
        RectF rectF = this.mBackgroundHelper.getBorder().width;
        Intrinsics.checkExpressionValueIsNotNull(rectF, "mBackgroundHelper.border.width");
        this.mYogaNode.setBorder(YogaEdge.LEFT, rectF.left);
        this.mYogaNode.setBorder(YogaEdge.TOP, rectF.top);
        this.mYogaNode.setBorder(YogaEdge.RIGHT, rectF.right);
        this.mYogaNode.setBorder(YogaEdge.BOTTOM, rectF.bottom);
    }

    private final View getTargetView() {
        return this.mTargetView;
    }

    public final void resetAllCommonStyles() {
        setBackgroundColor(0);
        setBorderWidth(0.0f);
        setBorderColor(0);
        setBorderRadius(0.0f);
        setBorderStyle((String) null);
        setShadow("", (String) null);
        setOpacity(1.0f);
    }
}
