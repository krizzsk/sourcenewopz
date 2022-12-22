package com.didi.soda.blocks.style;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000eJ\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0001J\u0016\u0010\u0014\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nJ\u0016\u0010\u0015\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/StyleProcessor;", "", "()V", "TAG", "", "applyStyles", "", "context", "Landroid/content/Context;", "binder", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/view/View;", "styles", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "applyYogaStyles", "node", "Lcom/facebook/yoga/YogaNode;", "key", "value", "resetCommonStyles", "resetYogaStyles", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: StyleProcessor.kt */
public final class StyleProcessor {
    public static final StyleProcessor INSTANCE = new StyleProcessor();
    public static final String TAG = "StyleProcessor";

    public final void resetCommonStyles(BaseBinder<? extends View> baseBinder) {
        Intrinsics.checkParameterIsNotNull(baseBinder, "binder");
    }

    private StyleProcessor() {
    }

    public final void applyStyles(Context context, BaseBinder<? extends View> baseBinder, HashMap<String, Object> hashMap) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(baseBinder, "binder");
        resetYogaStyles(baseBinder);
        CommonStylePainter commonStylePainter = new CommonStylePainter(baseBinder);
        commonStylePainter.resetAllCommonStyles();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (ValueManager.Companion.isYogaStyle(str)) {
                    INSTANCE.applyYogaStyles(baseBinder.getYogaNode(), str, value);
                } else if (ValueManager.Companion.isCommonStyle(str)) {
                    commonStylePainter.paint(hashMap);
                    if (!baseBinder.getYogaNode().isDirty() && baseBinder.getYogaNode().isMeasureDefined()) {
                        baseBinder.getYogaNode().dirty();
                    }
                }
            }
        }
    }

    public final void applyYogaStyles(YogaNode yogaNode, String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(yogaNode, "node");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(obj, "value");
        switch (str.hashCode()) {
            case -1984141450:
                if (str.equals(Const.YogaConst.EDGE_VERTICAL)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.VERTICAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.VERTICAL, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case -1906103182:
                if (str.equals(Const.YogaConst.MARGIN_HORIZONTAL)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1783760955:
                if (str.equals(Const.YogaConst.YOGA_FLEX_BASIS)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setFlexBasisAuto();
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setFlexBasisPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setFlexBasis(ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.LEFT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.LEFT, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.BOTTOM, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.BOTTOM, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case -1375815020:
                if (str.equals(Const.YogaConst.MIN_WIDTH)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMinWidth(0.0f);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMinWidthPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMinWidth(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setHeightAuto();
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setHeightPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setHeight(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1081309778:
                if (str.equals(Const.YogaConst.MARGIN_MARGIN)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.ALL);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.ALL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.ALL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1063257157:
                if (str.equals(Const.YogaConst.YOGA_ALIGN_ITEMS)) {
                    yogaNode.setAlignItems(YogaAlign.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case -1044806579:
                if (str.equals(Const.YogaConst.MARGIN_END)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.END);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.END, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.END, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.TOP);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.TOP, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.TOP, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -975171706:
                if (str.equals(Const.YogaConst.YOGA_FLEX_DIRECTION)) {
                    yogaNode.setFlexDirection(YogaFlexDirection.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case -962590849:
                if (str.equals(Const.YogaConst.YOGA_DIRECTION)) {
                    yogaNode.setDirection(YogaDirection.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case -906066005:
                if (str.equals(Const.YogaConst.MAX_HEIGHT)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMaxHeight((float) Integer.MAX_VALUE);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMaxHeightPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMaxHeight(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -806339567:
                if (str.equals(Const.YogaConst.PADDING_PADDING)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.ALL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.ALL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -752601676:
                if (str.equals(Const.YogaConst.YOGA_ALIGN_CONTENT)) {
                    yogaNode.setAlignContent(YogaAlign.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case -359890155:
                if (str.equals("paddingHorizontal")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -289173127:
                if (str.equals(Const.YogaConst.MARGIN_BOTTOM)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.BOTTOM);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.BOTTOM, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.BOTTOM, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case -133587431:
                if (str.equals(Const.YogaConst.MIN_HEIGHT)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMinHeight(0.0f);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMinHeightPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMinHeight(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 96673:
                if (str.equals("all")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.ALL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.ALL, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.END, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.END, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.TOP, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.TOP, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 3145721:
                if (str.equals(Const.YogaConst.YOGA_FLEX)) {
                    yogaNode.setFlex(ValueManagerKt.convert2Num(obj, str));
                    return;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.LEFT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.LEFT, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 90115850:
                if (str.equals(Const.YogaConst.PADDING_END)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.END, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.END, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.TOP, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.TOP, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.RIGHT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.RIGHT, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.START, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.START, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setWidthAuto();
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setWidthPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setWidth(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.BOTTOM, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.BOTTOM, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 400381634:
                if (str.equals(Const.YogaConst.MAX_WIDTH)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMaxWidth((float) Integer.MAX_VALUE);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMaxWidthPercent(ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMaxWidth(ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 529642498:
                if (str.equals(Const.YogaConst.YOGA_OVERFLOW)) {
                    yogaNode.setOverflow(YogaOverflow.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.RIGHT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.RIGHT, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 715094737:
                if (str.equals(Const.YogaConst.PADDING_START)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.START, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.START, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    yogaNode.setPositionType(YogaPositionType.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.RIGHT);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.RIGHT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.RIGHT, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 976333652:
                if (str.equals(Const.YogaConst.MARGIN_START)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.START);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.START, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.START, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 1031115618:
                if (str.equals(Const.YogaConst.YOGA_FLEX_SHRINK)) {
                    yogaNode.setFlexShrink(ValueManagerKt.convert2Num(obj, str));
                    return;
                }
                break;
            case 1092174483:
                if (str.equals(Const.YogaConst.ASPECT_RATIO)) {
                    yogaNode.setAspectRatio(ValueManagerKt.convert2Num(obj, str));
                    return;
                }
                break;
            case 1343645351:
                if (str.equals(Const.YogaConst.PADDING_VERTICAL)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPaddingPercent(YogaEdge.VERTICAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPadding(YogaEdge.VERTICAL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 1387629604:
                if (str.equals(Const.YogaConst.EDGE_HORIZONTAL)) {
                    if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setPositionPercent(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setPosition(YogaEdge.HORIZONTAL, ValueManagerKt.convert2Num(obj));
                        return;
                    }
                }
                break;
            case 1431421764:
                if (str.equals(Const.YogaConst.MARGIN_VERTICAL)) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.VERTICAL);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.VERTICAL, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.VERTICAL, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    yogaNode.setDisplay(YogaDisplay.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case 1743739820:
                if (str.equals(Const.YogaConst.YOGA_FLEX_GROW)) {
                    yogaNode.setFlexGrow(ValueManagerKt.convert2Num(obj, str));
                    return;
                }
                break;
            case 1744216035:
                if (str.equals(Const.YogaConst.YOGA_FLEX_WRAP)) {
                    if ("nowrap".equals(obj.toString())) {
                        yogaNode.setWrap(YogaWrap.NO_WRAP);
                        return;
                    } else {
                        yogaNode.setWrap(YogaWrap.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                        return;
                    }
                }
                break;
            case 1767100401:
                if (str.equals(Const.YogaConst.YOGA_ALIGN_SELF)) {
                    yogaNode.setAlignSelf(YogaAlign.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case 1860657097:
                if (str.equals(Const.YogaConst.YOGA_JUSTIFY_CONTENT)) {
                    yogaNode.setJustifyContent(YogaJustify.valueOf(ValueManagerKt.convert2YogaEnumString(obj)));
                    return;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    if (ValueManagerKt.isAutoValue(obj)) {
                        yogaNode.setMarginAuto(YogaEdge.LEFT);
                        return;
                    } else if (ValueManagerKt.isPercentValue(obj)) {
                        yogaNode.setMarginPercent(YogaEdge.LEFT, ValueManagerKt.convert2Percent(obj));
                        return;
                    } else {
                        yogaNode.setMargin(YogaEdge.LEFT, ValueManagerKt.convert2Num(obj, str));
                        return;
                    }
                }
                break;
        }
        if (BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).isDebug()) {
            Context context = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext();
            Toast.makeText(context, "StyleProcessor unresolved Yoga property:" + str, 1);
        }
    }

    public final void resetYogaStyles(BaseBinder<? extends View> baseBinder) {
        Intrinsics.checkParameterIsNotNull(baseBinder, "binder");
        YogaNode yogaNode = baseBinder.getYogaNode();
        yogaNode.setDirection(YogaDirection.LTR);
        yogaNode.setFlexDirection(YogaFlexDirection.ROW);
        yogaNode.setJustifyContent(YogaJustify.FLEX_START);
        yogaNode.setAlignContent(YogaAlign.STRETCH);
        yogaNode.setAlignItems(YogaAlign.STRETCH);
        yogaNode.setAlignSelf(YogaAlign.AUTO);
        yogaNode.setPositionType(YogaPositionType.RELATIVE);
        yogaNode.setWrap(YogaWrap.NO_WRAP);
        yogaNode.setOverflow(YogaOverflow.VISIBLE);
        yogaNode.setDisplay(YogaDisplay.FLEX);
        yogaNode.setFlex(FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setFlexGrow(FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setFlexShrink(FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setAspectRatio(FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setFlexBasisAuto();
        yogaNode.setPosition(YogaEdge.ALL, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPosition(YogaEdge.LEFT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPosition(YogaEdge.TOP, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPosition(YogaEdge.RIGHT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPosition(YogaEdge.BOTTOM, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setMargin(YogaEdge.ALL, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setMargin(YogaEdge.LEFT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setMargin(YogaEdge.TOP, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setMargin(YogaEdge.RIGHT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setMargin(YogaEdge.BOTTOM, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPadding(YogaEdge.ALL, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPadding(YogaEdge.LEFT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPadding(YogaEdge.TOP, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPadding(YogaEdge.RIGHT, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setPadding(YogaEdge.BOTTOM, FloatCompanionObject.INSTANCE.getNaN());
        yogaNode.setWidthAuto();
        yogaNode.setHeightAuto();
        float f = (float) Integer.MAX_VALUE;
        yogaNode.setMaxWidth(f);
        yogaNode.setMaxHeight(f);
        yogaNode.setMinWidth(0.0f);
        yogaNode.setMinHeight(0.0f);
    }
}
