package com.didi.soda.blocks.widget.image;

import android.content.Context;
import android.widget.ImageView;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.style.ValueManagerKt;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.utils.ImageRenderUtil;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "Image")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016J0\u0010\r\u001a\u00020\u00072&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0015H\u0002J\u0012\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0002J0\u0010#\u001a\u00020$2&\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0016¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/blocks/widget/image/ImageBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Lcom/didi/soda/blocks/widget/image/RoundedImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindInterceptedStyles", "", "styles", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "bindProps", "props", "createView", "loadImage", "url", "placeholder", "setBorderBottomLeftRadius", "radius", "", "setBorderBottomRightRadius", "setBorderColor", "color", "", "setBorderRadius", "setBorderStyle", "style", "setBorderTopLeftRadius", "setBorderTopRightRadius", "setBorderWidth", "width", "setContentMode", "resize", "shouldShow", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ImageBinder.kt */
public final class ImageBinder extends BaseBinder<RoundedImageView> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageBinder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public RoundedImageView createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new RoundedImageView(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.get(com.didi.soda.blocks.constant.Const.BlockParamConst.SRC);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldShow(java.util.HashMap<java.lang.String, java.lang.Object> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            java.lang.String r0 = "src"
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.widget.image.ImageBinder.shouldShow(java.util.HashMap):boolean");
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            String str = null;
            String str2 = str;
            for (Map.Entry entry : hashMap.entrySet()) {
                String str3 = (String) entry.getKey();
                Object value = entry.getValue();
                int hashCode = str3.hashCode();
                if (hashCode != -934437708) {
                    if (hashCode != 114148) {
                        if (hashCode == 598246771 && str3.equals(Const.BlockParamConst.PLACEHOLDER)) {
                            str2 = value.toString();
                        }
                    } else if (str3.equals(Const.BlockParamConst.SRC)) {
                        str = value.toString();
                    }
                } else if (str3.equals(Const.BlockParamConst.RESIZE)) {
                    setContentMode(value.toString());
                }
            }
            loadImage(str, str2);
            super.bindProps(hashMap);
        }
    }

    public void bindInterceptedStyles(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                switch (str.hashCode()) {
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
                    case 1349188574:
                        if (!str.equals("borderRadius")) {
                            break;
                        } else {
                            setBorderRadius(ValueManagerKt.convert2Num(value));
                            break;
                        }
                }
            }
        }
        super.bindInterceptedStyles(hashMap);
    }

    private final void loadImage(String str, String str2) {
        ImageRenderUtil.renderImage(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), (ImageView) getView(), str, str2);
    }

    private final void setContentMode(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
                        return;
                    }
                    break;
                case -1008619738:
                    if (str.equals("origin")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.CENTER);
                        return;
                    }
                    break;
                case 94852023:
                    if (str.equals("cover")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.CENTER_CROP);
                        return;
                    }
                    break;
                case 951526612:
                    if (str.equals("contain")) {
                        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_CENTER);
                        return;
                    }
                    break;
            }
        }
        ((RoundedImageView) getView()).setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void setBorderWidth(float f) {
        ((RoundedImageView) getView()).setBorderWidth(f);
    }

    private final void setBorderColor(int i) {
        ((RoundedImageView) getView()).setBorderColor(i);
    }

    private final void setBorderStyle(String str) {
        ((RoundedImageView) getView()).setBorderStyle(str);
    }

    private final void setBorderRadius(float f) {
        getMBackgroundHelper().setBorderRadius(f);
        ((RoundedImageView) getView()).setBorderRadius(f);
    }

    private final void setBorderTopLeftRadius(float f) {
        getMBackgroundHelper().setBorderTopLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderTopRightRadius(float f) {
        getMBackgroundHelper().setBorderTopLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderBottomRightRadius(float f) {
        getMBackgroundHelper().setBorderBottomRightRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }

    private final void setBorderBottomLeftRadius(float f) {
        getMBackgroundHelper().setBorderBottomLeftRadius(f);
        ((RoundedImageView) getView()).setCornerRadii(getMBackgroundHelper().getBorderRadii());
    }
}
