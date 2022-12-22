package com.didi.soda.blocks.style;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.blocks.widget.image.ImageBinder;
import com.didi.soda.blocks.widget.scroller.HorizontalScroller;
import com.didi.soda.blocks.widget.scroller.VerticalScroller;
import com.facebook.yoga.YogaOverflow;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "View")
@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J0\u0010\u000b\u001a\u00020\u00072&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J0\u0010\u0012\u001a\u00020\u00072&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J0\u0010\u0017\u001a\u00020\u00182&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0016¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/blocks/style/DynamicContainerBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Lcom/didi/soda/blocks/style/BlockLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindChildren", "", "children", "", "Lcom/didi/soda/blocks/widget/Buildable;", "bindStyles", "styles", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "createView", "onBindFinish", "props", "setWidgetNode", "widgetNode", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "shouldShow", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DynamicContainerBinder.kt */
public class DynamicContainerBinder extends BaseBinder<BlockLayout> {
    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicContainerBinder(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public BlockLayout createView(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new BlockLayout(context);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        super.setWidgetNode(widgetNodeModel);
        ((BlockLayout) getView()).setBlockNode(widgetNodeModel);
        WidgetNodeModel virtualNode = getVirtualNode();
        if (virtualNode != null) {
            boolean isRoot = virtualNode.isRoot();
        }
    }

    public void bindChildren(List<? extends Buildable> list) {
        Intrinsics.checkParameterIsNotNull(list, "children");
        for (Buildable buildable : list) {
            if (buildable instanceof BaseBinder) {
                if ((buildable instanceof ImageBinder) || (buildable instanceof VerticalScroller) || (buildable instanceof HorizontalScroller)) {
                    View view = getView();
                    if (!(view instanceof ViewGroup)) {
                        view = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup != null) {
                        viewGroup.setClipChildren(true);
                    }
                }
                ((BlockLayout) getView()).addView((BaseBinder) buildable);
            }
        }
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        String str;
        Object obj;
        String obj2;
        super.bindStyles(hashMap);
        ViewGroup viewGroup = null;
        if (hashMap == null || (obj = hashMap.get(Const.YogaConst.YOGA_OVERFLOW)) == null || (obj2 = obj.toString()) == null) {
            str = null;
        } else if (obj2 != null) {
            str = obj2.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toUpperCase()");
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        if (Intrinsics.areEqual((Object) str, (Object) YogaOverflow.HIDDEN.name())) {
            View view = getView();
            if (view instanceof ViewGroup) {
                viewGroup = view;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.setClipChildren(true);
            }
        }
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        super.onBindFinish(hashMap);
        WidgetNodeModel virtualNode = getVirtualNode();
        if (virtualNode != null && virtualNode.isRoot()) {
            refreshLayout();
        }
        super.onBindFinish(hashMap);
    }
}
