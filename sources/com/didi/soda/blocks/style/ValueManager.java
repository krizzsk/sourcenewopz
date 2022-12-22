package com.didi.soda.blocks.style;

import com.didi.soda.blocks.constant.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/ValueManager;", "", "()V", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ValueManager.kt */
public final class ValueManager {
    /* access modifiers changed from: private */
    public static final List<String> COMMON_STYLES = CollectionsKt.listOf("backgroundColor", "opacity", "borderColor", Const.StyleConst.BORDER_TOP_COLOR, Const.StyleConst.BORDER_RIGHT_COLOR, Const.StyleConst.BORDER_BOTTOM_COLOR, Const.StyleConst.BORDER_LEFT_COLOR, Const.StyleConst.BORDER_START_COLOR, Const.StyleConst.BORDER_END_COLOR, "borderWidth", Const.StyleConst.BORDER_LEFT_WIDTH, Const.StyleConst.BORDER_TOP_WIDTH, Const.StyleConst.BORDER_RIGHT_WIDTH, Const.StyleConst.BORDER_BOTTOM_WIDTH, Const.StyleConst.BORDER_START_WIDTH, Const.StyleConst.BORDER_END_WIDTH, Const.StyleConst.BORDER_STYLE, "borderRadius", Const.StyleConst.BORDER_TOP_LEFT_RADIUS, Const.StyleConst.BORDER_TOP_RIGHT_RADIUS, Const.StyleConst.BORDER_TOP_START_RADIUS, Const.StyleConst.BORDER_TOP_END_RADIUS, Const.StyleConst.BORDER_BOTTOM_LEFT_RADIUS, Const.StyleConst.BORDER_BOTTOM_RIGHT_RADIUS, Const.StyleConst.BORDER_BOTTOM_START_RADIUS, Const.StyleConst.BORDER_BOTTOM_END_RADIUS, Const.StyleConst.BOX_SHADOW);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> NO_DP_STYLES = CollectionsKt.listOf(Const.YogaConst.YOGA_FLEX, Const.YogaConst.YOGA_FLEX_GROW, Const.YogaConst.YOGA_FLEX_SHRINK, Const.YogaConst.ASPECT_RATIO);
    public static final String TAG = "ValueManager";
    /* access modifiers changed from: private */
    public static final List<String> YOGA_STYLES = CollectionsKt.listOf(Const.YogaConst.YOGA_DIRECTION, Const.YogaConst.YOGA_FLEX_DIRECTION, Const.YogaConst.YOGA_JUSTIFY_CONTENT, Const.YogaConst.YOGA_ALIGN_CONTENT, Const.YogaConst.YOGA_ALIGN_ITEMS, Const.YogaConst.YOGA_ALIGN_SELF, "position", Const.YogaConst.YOGA_FLEX_WRAP, Const.YogaConst.YOGA_OVERFLOW, "display", Const.YogaConst.YOGA_FLEX, Const.YogaConst.YOGA_FLEX_GROW, Const.YogaConst.YOGA_FLEX_SHRINK, Const.YogaConst.YOGA_FLEX_BASIS, "left", "top", "right", "bottom", "start", "end", Const.YogaConst.EDGE_HORIZONTAL, Const.YogaConst.EDGE_VERTICAL, "all", "marginLeft", "marginTop", "marginRight", Const.YogaConst.MARGIN_BOTTOM, Const.YogaConst.MARGIN_START, Const.YogaConst.MARGIN_END, Const.YogaConst.MARGIN_HORIZONTAL, Const.YogaConst.MARGIN_VERTICAL, Const.YogaConst.MARGIN_MARGIN, "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", Const.YogaConst.PADDING_START, Const.YogaConst.PADDING_END, "paddingHorizontal", Const.YogaConst.PADDING_VERTICAL, Const.YogaConst.PADDING_PADDING, "width", "height", Const.YogaConst.ASPECT_RATIO, Const.YogaConst.MIN_WIDTH, Const.YogaConst.MIN_HEIGHT, Const.YogaConst.MAX_WIDTH, Const.YogaConst.MAX_HEIGHT);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/ValueManager$Companion;", "", "()V", "COMMON_STYLES", "", "", "getCOMMON_STYLES", "()Ljava/util/List;", "NO_DP_STYLES", "getNO_DP_STYLES", "TAG", "YOGA_STYLES", "getYOGA_STYLES", "isCommonStyle", "", "key", "isDPStyle", "isYogaStyle", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ValueManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<String> getYOGA_STYLES() {
            return ValueManager.YOGA_STYLES;
        }

        public final List<String> getCOMMON_STYLES() {
            return ValueManager.COMMON_STYLES;
        }

        public final List<String> getNO_DP_STYLES() {
            return ValueManager.NO_DP_STYLES;
        }

        public final boolean isYogaStyle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            return getYOGA_STYLES().contains(str);
        }

        public final boolean isCommonStyle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            return getCOMMON_STYLES().contains(str);
        }

        public final boolean isDPStyle(String str) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            return !getNO_DP_STYLES().contains(str);
        }
    }
}
