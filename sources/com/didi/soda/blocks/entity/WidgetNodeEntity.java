package com.didi.soda.blocks.entity;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001c\u0010/\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001c\u00102\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001c\u00105\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/WidgetNodeEntity;", "Ljava/io/Serializable;", "()V", "actions", "", "Lcom/didi/soda/blocks/entity/CallBackEntity;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "callbacks", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCallbacks", "()Ljava/util/ArrayList;", "setCallbacks", "(Ljava/util/ArrayList;)V", "children", "getChildren", "setChildren", "componentId", "", "getComponentId", "()Ljava/lang/String;", "setComponentId", "(Ljava/lang/String;)V", "componentName", "getComponentName", "setComponentName", "condition", "getCondition", "setCondition", "context", "Lcom/google/gson/JsonObject;", "getContext", "()Lcom/google/gson/JsonObject;", "setContext", "(Lcom/google/gson/JsonObject;)V", "id", "getId", "setId", "loop", "getLoop", "setLoop", "loopArgs", "getLoopArgs", "setLoopArgs", "name", "getName", "setName", "props", "getProps", "setProps", "style", "getStyle", "setStyle", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: WidgetNodeEntity.kt */
public final class WidgetNodeEntity implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -7535823249547489088L;
    private List<CallBackEntity> actions;
    private ArrayList<CallBackEntity> callbacks;
    private List<WidgetNodeEntity> children;
    private String componentId;
    private String componentName;
    private String condition;
    private JsonObject context;

    /* renamed from: id */
    private String f39329id;
    private String loop;
    private List<String> loopArgs;
    private String name;
    private JsonObject props;
    private JsonObject style;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getId() {
        return this.f39329id;
    }

    public final void setId(String str) {
        this.f39329id = str;
    }

    public final ArrayList<CallBackEntity> getCallbacks() {
        return this.callbacks;
    }

    public final void setCallbacks(ArrayList<CallBackEntity> arrayList) {
        this.callbacks = arrayList;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final void setComponentName(String str) {
        this.componentName = str;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final void setComponentId(String str) {
        this.componentId = str;
    }

    public final JsonObject getProps() {
        return this.props;
    }

    public final void setProps(JsonObject jsonObject) {
        this.props = jsonObject;
    }

    public final JsonObject getStyle() {
        return this.style;
    }

    public final void setStyle(JsonObject jsonObject) {
        this.style = jsonObject;
    }

    public final JsonObject getContext() {
        return this.context;
    }

    public final void setContext(JsonObject jsonObject) {
        this.context = jsonObject;
    }

    public final String getLoop() {
        return this.loop;
    }

    public final void setLoop(String str) {
        this.loop = str;
    }

    public final List<String> getLoopArgs() {
        return this.loopArgs;
    }

    public final void setLoopArgs(List<String> list) {
        this.loopArgs = list;
    }

    public final List<WidgetNodeEntity> getChildren() {
        return this.children;
    }

    public final void setChildren(List<WidgetNodeEntity> list) {
        this.children = list;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final void setCondition(String str) {
        this.condition = str;
    }

    public final List<CallBackEntity> getActions() {
        return this.actions;
    }

    public final void setActions(List<CallBackEntity> list) {
        this.actions = list;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/entity/WidgetNodeEntity$Companion;", "", "()V", "serialVersionUID", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: WidgetNodeEntity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
