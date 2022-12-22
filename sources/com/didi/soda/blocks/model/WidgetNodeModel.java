package com.didi.soda.blocks.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.widget.Buildable;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010N\u001a\u00020\u0000J\u0010\u0010O\u001a\u0004\u0018\u00010\u00002\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020&R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0000\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013RD\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR:\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001c\u0010 \u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\u001c\u0010.\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R\u001c\u00101\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R:\u00106\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR:\u00109\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\u001c\u0010<\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0011\"\u0004\b>\u0010\u0013R\u001a\u0010?\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0011\"\u0004\bA\u0010\u0013R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006S"}, mo175978d2 = {"Lcom/didi/soda/blocks/model/WidgetNodeModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "callbacks", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/model/CallBackModel;", "Lkotlin/collections/ArrayList;", "getCallbacks", "()Ljava/util/ArrayList;", "setCallbacks", "(Ljava/util/ArrayList;)V", "children", "getChildren", "setChildren", "condition", "", "getCondition", "()Ljava/lang/String;", "setCondition", "(Ljava/lang/String;)V", "context", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "context$annotations", "getContext", "()Ljava/util/HashMap;", "setContext", "(Ljava/util/HashMap;)V", "contextParams", "getContextParams", "setContextParams", "dataModel", "getDataModel", "()Ljava/lang/Object;", "setDataModel", "(Ljava/lang/Object;)V", "hasShown", "", "getHasShown", "()Z", "setHasShown", "(Z)V", "id", "getId", "setId", "name", "getName", "setName", "parent", "getParent", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setParent", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "props", "getProps", "setProps", "styles", "getStyles", "setStyles", "templateId", "getTemplateId", "setTemplateId", "version", "getVersion", "setVersion", "widget", "Lcom/didi/soda/blocks/widget/Buildable;", "getWidget", "()Lcom/didi/soda/blocks/widget/Buildable;", "setWidget", "(Lcom/didi/soda/blocks/widget/Buildable;)V", "yogaNode", "Lcom/facebook/yoga/YogaNode;", "getYogaNode", "()Lcom/facebook/yoga/YogaNode;", "setYogaNode", "(Lcom/facebook/yoga/YogaNode;)V", "getRoot", "getUpLevelNode", "upLevel", "", "isRoot", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WidgetNodeModel.kt */
public final class WidgetNodeModel implements RecyclerModel {
    private ArrayList<CallBackModel> callbacks;
    private ArrayList<WidgetNodeModel> children;
    private String condition;
    private HashMap<String, Object> context;
    private HashMap<String, Object> contextParams;
    private Object dataModel;
    private boolean hasShown;

    /* renamed from: id */
    private String f39330id;
    private String name;
    private WidgetNodeModel parent;
    private HashMap<String, Object> props;
    private HashMap<String, Object> styles;
    private String templateId;
    private String version = "1";
    private Buildable widget;
    private YogaNode yogaNode;

    @Deprecated(message = "Use contextParams instead", replaceWith = @ReplaceWith(expression = "contextParams", imports = {}))
    public static /* synthetic */ void context$annotations() {
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getId() {
        return this.f39330id;
    }

    public final void setId(String str) {
        this.f39330id = str;
    }

    public final Buildable getWidget() {
        return this.widget;
    }

    public final void setWidget(Buildable buildable) {
        this.widget = buildable;
    }

    public final YogaNode getYogaNode() {
        return this.yogaNode;
    }

    public final void setYogaNode(YogaNode yogaNode2) {
        this.yogaNode = yogaNode2;
    }

    public final Object getDataModel() {
        return this.dataModel;
    }

    public final void setDataModel(Object obj) {
        this.dataModel = obj;
    }

    public final HashMap<String, Object> getContext() {
        return this.context;
    }

    public final void setContext(HashMap<String, Object> hashMap) {
        this.context = hashMap;
    }

    public final WidgetNodeModel getParent() {
        return this.parent;
    }

    public final void setParent(WidgetNodeModel widgetNodeModel) {
        this.parent = widgetNodeModel;
    }

    public final HashMap<String, Object> getProps() {
        return this.props;
    }

    public final void setProps(HashMap<String, Object> hashMap) {
        this.props = hashMap;
    }

    public final HashMap<String, Object> getStyles() {
        return this.styles;
    }

    public final void setStyles(HashMap<String, Object> hashMap) {
        this.styles = hashMap;
    }

    public final HashMap<String, Object> getContextParams() {
        return this.contextParams;
    }

    public final void setContextParams(HashMap<String, Object> hashMap) {
        this.contextParams = hashMap;
    }

    public final ArrayList<WidgetNodeModel> getChildren() {
        return this.children;
    }

    public final void setChildren(ArrayList<WidgetNodeModel> arrayList) {
        this.children = arrayList;
    }

    public final ArrayList<CallBackModel> getCallbacks() {
        return this.callbacks;
    }

    public final void setCallbacks(ArrayList<CallBackModel> arrayList) {
        this.callbacks = arrayList;
    }

    public final boolean getHasShown() {
        return this.hasShown;
    }

    public final void setHasShown(boolean z) {
        this.hasShown = z;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.version = str;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final void setCondition(String str) {
        this.condition = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.f39330id;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isRoot() {
        /*
            r3 = this;
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r3.parent
            r1 = 1
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.f39330id
            if (r0 == 0) goto L_0x0012
            java.lang.String r2 = "fade_root"
            boolean r0 = r0.equals(r2)
            if (r0 != r1) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.model.WidgetNodeModel.isRoot():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000b, code lost:
        r0 = r0.getRoot();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.blocks.model.WidgetNodeModel getRoot() {
        /*
            r1 = this;
            boolean r0 = r1.isRoot()
            if (r0 == 0) goto L_0x0007
            return r1
        L_0x0007:
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r1.parent
            if (r0 == 0) goto L_0x0012
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r0.getRoot()
            if (r0 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.model.WidgetNodeModel.getRoot():com.didi.soda.blocks.model.WidgetNodeModel");
    }

    public final WidgetNodeModel getUpLevelNode(int i) {
        if (i <= -1) {
            return getRoot();
        }
        if (i == 0) {
            return this;
        }
        WidgetNodeModel widgetNodeModel = this;
        while (i > 0 && widgetNodeModel != null) {
            widgetNodeModel = widgetNodeModel.parent;
            i--;
        }
        return widgetNodeModel;
    }
}
