package com.didi.map.global.flow.scene.order.confirm.component;

import com.didi.common.map.model.Marker;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineShowListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*¨\u00064"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/MultiLineParam;", "", "lineParams", "", "Lcom/didi/map/global/flow/scene/order/confirm/component/LineParam;", "onLineSelectListener", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "onLineShowListener", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineShowListener;", "(Ljava/util/List;Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineShowListener;)V", "educBubbleContent", "", "getEducBubbleContent", "()Ljava/lang/String;", "setEducBubbleContent", "(Ljava/lang/String;)V", "isShowEducBubble", "", "()Z", "setShowEducBubble", "(Z)V", "getLineParams", "()Ljava/util/List;", "setLineParams", "(Ljava/util/List;)V", "markersCollide", "Lcom/didi/common/map/model/Marker;", "getMarkersCollide", "setMarkersCollide", "getOnLineSelectListener", "()Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "setOnLineSelectListener", "(Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;)V", "getOnLineShowListener", "()Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineShowListener;", "setOnLineShowListener", "(Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineShowListener;)V", "selectLineColor", "", "getSelectLineColor", "()I", "setSelectLineColor", "(I)V", "selectLineWidth", "getSelectLineWidth", "setSelectLineWidth", "unSelectLineColor", "getUnSelectLineColor", "setUnSelectLineColor", "unSelectLineWidth", "getUnSelectLineWidth", "setUnSelectLineWidth", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MultiLineParam.kt */
public final class MultiLineParam {

    /* renamed from: a */
    private List<LineParam> f26617a;

    /* renamed from: b */
    private ILineSelectedListener f26618b;

    /* renamed from: c */
    private ILineShowListener f26619c;

    /* renamed from: d */
    private int f26620d;

    /* renamed from: e */
    private int f26621e;

    /* renamed from: f */
    private int f26622f;

    /* renamed from: g */
    private int f26623g;

    /* renamed from: h */
    private boolean f26624h;

    /* renamed from: i */
    private String f26625i;

    /* renamed from: j */
    private List<? extends Marker> f26626j;

    public MultiLineParam(List<LineParam> list, ILineSelectedListener iLineSelectedListener, ILineShowListener iLineShowListener) {
        this.f26617a = list;
        this.f26618b = iLineSelectedListener;
        this.f26619c = iLineShowListener;
    }

    public final List<LineParam> getLineParams() {
        return this.f26617a;
    }

    public final void setLineParams(List<LineParam> list) {
        this.f26617a = list;
    }

    public final ILineSelectedListener getOnLineSelectListener() {
        return this.f26618b;
    }

    public final void setOnLineSelectListener(ILineSelectedListener iLineSelectedListener) {
        this.f26618b = iLineSelectedListener;
    }

    public final ILineShowListener getOnLineShowListener() {
        return this.f26619c;
    }

    public final void setOnLineShowListener(ILineShowListener iLineShowListener) {
        this.f26619c = iLineShowListener;
    }

    public final int getSelectLineColor() {
        return this.f26620d;
    }

    public final void setSelectLineColor(int i) {
        this.f26620d = i;
    }

    public final int getSelectLineWidth() {
        return this.f26621e;
    }

    public final void setSelectLineWidth(int i) {
        this.f26621e = i;
    }

    public final int getUnSelectLineColor() {
        return this.f26622f;
    }

    public final void setUnSelectLineColor(int i) {
        this.f26622f = i;
    }

    public final int getUnSelectLineWidth() {
        return this.f26623g;
    }

    public final void setUnSelectLineWidth(int i) {
        this.f26623g = i;
    }

    public final boolean isShowEducBubble() {
        return this.f26624h;
    }

    public final void setShowEducBubble(boolean z) {
        this.f26624h = z;
    }

    public final String getEducBubbleContent() {
        return this.f26625i;
    }

    public final void setEducBubbleContent(String str) {
        this.f26625i = str;
    }

    public final List<Marker> getMarkersCollide() {
        return this.f26626j;
    }

    public final void setMarkersCollide(List<? extends Marker> list) {
        this.f26626j = list;
    }
}
