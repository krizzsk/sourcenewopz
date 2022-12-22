package com.didi.soda.customer.map;

import android.view.View;
import com.didi.common.map.model.InfoWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001%B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/customer/map/InfoWindowOptions;", "", "zIndex", "", "visiable", "", "position", "Lcom/didi/common/map/model/InfoWindow$Position;", "contentView", "Landroid/view/View;", "(IZLcom/didi/common/map/model/InfoWindow$Position;Landroid/view/View;)V", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getPosition", "()Lcom/didi/common/map/model/InfoWindow$Position;", "setPosition", "(Lcom/didi/common/map/model/InfoWindow$Position;)V", "getVisiable", "()Z", "setVisiable", "(Z)V", "getZIndex", "()I", "setZIndex", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Builder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapInfoWindowManager.kt */
public final class InfoWindowOptions {

    /* renamed from: a */
    private int f41358a;

    /* renamed from: b */
    private boolean f41359b;

    /* renamed from: c */
    private InfoWindow.Position f41360c;

    /* renamed from: d */
    private View f41361d;

    public /* synthetic */ InfoWindowOptions(int i, boolean z, InfoWindow.Position position, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, position, view);
    }

    public static /* synthetic */ InfoWindowOptions copy$default(InfoWindowOptions infoWindowOptions, int i, boolean z, InfoWindow.Position position, View view, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = infoWindowOptions.f41358a;
        }
        if ((i2 & 2) != 0) {
            z = infoWindowOptions.f41359b;
        }
        if ((i2 & 4) != 0) {
            position = infoWindowOptions.f41360c;
        }
        if ((i2 & 8) != 0) {
            view = infoWindowOptions.f41361d;
        }
        return infoWindowOptions.copy(i, z, position, view);
    }

    public final int component1() {
        return this.f41358a;
    }

    public final boolean component2() {
        return this.f41359b;
    }

    public final InfoWindow.Position component3() {
        return this.f41360c;
    }

    public final View component4() {
        return this.f41361d;
    }

    public final InfoWindowOptions copy(int i, boolean z, InfoWindow.Position position, View view) {
        return new InfoWindowOptions(i, z, position, view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoWindowOptions)) {
            return false;
        }
        InfoWindowOptions infoWindowOptions = (InfoWindowOptions) obj;
        return this.f41358a == infoWindowOptions.f41358a && this.f41359b == infoWindowOptions.f41359b && this.f41360c == infoWindowOptions.f41360c && Intrinsics.areEqual((Object) this.f41361d, (Object) infoWindowOptions.f41361d);
    }

    public int hashCode() {
        int i = this.f41358a * 31;
        boolean z = this.f41359b;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        InfoWindow.Position position = this.f41360c;
        int i3 = 0;
        int hashCode = (i2 + (position == null ? 0 : position.hashCode())) * 31;
        View view = this.f41361d;
        if (view != null) {
            i3 = view.hashCode();
        }
        return hashCode + i3;
    }

    public String toString() {
        return "InfoWindowOptions(zIndex=" + this.f41358a + ", visiable=" + this.f41359b + ", position=" + this.f41360c + ", contentView=" + this.f41361d + VersionRange.RIGHT_OPEN;
    }

    private InfoWindowOptions(int i, boolean z, InfoWindow.Position position, View view) {
        this.f41358a = i;
        this.f41359b = z;
        this.f41360c = position;
        this.f41361d = view;
    }

    public final int getZIndex() {
        return this.f41358a;
    }

    public final void setZIndex(int i) {
        this.f41358a = i;
    }

    public final boolean getVisiable() {
        return this.f41359b;
    }

    public final void setVisiable(boolean z) {
        this.f41359b = z;
    }

    public final InfoWindow.Position getPosition() {
        return this.f41360c;
    }

    public final void setPosition(InfoWindow.Position position) {
        this.f41360c = position;
    }

    public final View getContentView() {
        return this.f41361d;
    }

    public final void setContentView(View view) {
        this.f41361d = view;
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/customer/map/InfoWindowOptions$Builder;", "", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContentView", "()Landroid/view/View;", "<set-?>", "Lcom/didi/common/map/model/InfoWindow$Position;", "position", "getPosition", "()Lcom/didi/common/map/model/InfoWindow$Position;", "", "visible", "getVisible", "()Z", "", "zIndex", "getZIndex", "()I", "build", "Lcom/didi/soda/customer/map/InfoWindowOptions;", "setPosition", "setVisible", "setZIndex", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MapInfoWindowManager.kt */
    public static final class Builder {
        private final View contentView;
        private InfoWindow.Position position = InfoWindow.Position.TOP;
        private boolean visible = true;
        private int zIndex;

        public Builder(View view) {
            this.contentView = view;
        }

        public final View getContentView() {
            return this.contentView;
        }

        public final int getZIndex() {
            return this.zIndex;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final InfoWindow.Position getPosition() {
            return this.position;
        }

        public final Builder setZIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public final Builder setVisible(boolean z) {
            this.visible = z;
            return this;
        }

        public final Builder setPosition(InfoWindow.Position position2) {
            Intrinsics.checkNotNullParameter(position2, "position");
            this.position = position2;
            return this;
        }

        public final InfoWindowOptions build() {
            return new InfoWindowOptions(this.zIndex, this.visible, this.position, this.contentView, (DefaultConstructorMarker) null);
        }
    }
}
