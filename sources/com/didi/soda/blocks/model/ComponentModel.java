package com.didi.soda.blocks.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/blocks/model/ComponentModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "dataModel", "", "getDataModel", "()Ljava/lang/Object;", "setDataModel", "(Ljava/lang/Object;)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "widgetNodeModel", "Lcom/didi/soda/blocks/model/WidgetNodeModel;", "getWidgetNodeModel", "()Lcom/didi/soda/blocks/model/WidgetNodeModel;", "setWidgetNodeModel", "(Lcom/didi/soda/blocks/model/WidgetNodeModel;)V", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ComponentModel.kt */
public final class ComponentModel implements RecyclerModel {
    private Object dataModel;
    private String templateId;
    private WidgetNodeModel widgetNodeModel;

    public final Object getDataModel() {
        return this.dataModel;
    }

    public final void setDataModel(Object obj) {
        this.dataModel = obj;
    }

    public final WidgetNodeModel getWidgetNodeModel() {
        return this.widgetNodeModel;
    }

    public final void setWidgetNodeModel(WidgetNodeModel widgetNodeModel2) {
        this.widgetNodeModel = widgetNodeModel2;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }
}
