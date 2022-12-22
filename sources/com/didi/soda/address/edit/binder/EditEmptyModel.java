package com.didi.soda.address.edit.binder;

import kotlin.Metadata;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/address/edit/binder/EditEmptyModel;", "", "height", "", "(I)V", "getHeight", "()I", "setHeight", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditEmptyModel.kt */
public final class EditEmptyModel {

    /* renamed from: a */
    private int f38727a;

    public static /* synthetic */ EditEmptyModel copy$default(EditEmptyModel editEmptyModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = editEmptyModel.f38727a;
        }
        return editEmptyModel.copy(i);
    }

    public final int component1() {
        return this.f38727a;
    }

    public final EditEmptyModel copy(int i) {
        return new EditEmptyModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EditEmptyModel) && this.f38727a == ((EditEmptyModel) obj).f38727a;
    }

    public int hashCode() {
        return this.f38727a;
    }

    public String toString() {
        return "EditEmptyModel(height=" + this.f38727a + VersionRange.RIGHT_OPEN;
    }

    public EditEmptyModel(int i) {
        this.f38727a = i;
    }

    public final int getHeight() {
        return this.f38727a;
    }

    public final void setHeight(int i) {
        this.f38727a = i;
    }
}
