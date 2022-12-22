package com.didi.entrega.customer.map.infowindow;

import android.view.View;
import com.didi.common.map.model.InfoWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001%B+\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/infowindow/InfoWindowOptions;", "", "position", "Lcom/didi/common/map/model/InfoWindow$Position;", "zIndex", "", "visiable", "", "contentView", "Landroid/view/View;", "(Lcom/didi/common/map/model/InfoWindow$Position;IZLandroid/view/View;)V", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getPosition", "()Lcom/didi/common/map/model/InfoWindow$Position;", "setPosition", "(Lcom/didi/common/map/model/InfoWindow$Position;)V", "getVisiable", "()Z", "setVisiable", "(Z)V", "getZIndex", "()I", "setZIndex", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Builder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MapInfoWindowManager.kt */
public final class InfoWindowOptions {

    /* renamed from: a */
    private InfoWindow.Position f20186a;

    /* renamed from: b */
    private int f20187b;

    /* renamed from: c */
    private boolean f20188c;

    /* renamed from: d */
    private View f20189d;

    public /* synthetic */ InfoWindowOptions(InfoWindow.Position position, int i, boolean z, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(position, i, z, view);
    }

    public static /* synthetic */ InfoWindowOptions copy$default(InfoWindowOptions infoWindowOptions, InfoWindow.Position position, int i, boolean z, View view, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            position = infoWindowOptions.f20186a;
        }
        if ((i2 & 2) != 0) {
            i = infoWindowOptions.f20187b;
        }
        if ((i2 & 4) != 0) {
            z = infoWindowOptions.f20188c;
        }
        if ((i2 & 8) != 0) {
            view = infoWindowOptions.f20189d;
        }
        return infoWindowOptions.copy(position, i, z, view);
    }

    public final InfoWindow.Position component1() {
        return this.f20186a;
    }

    public final int component2() {
        return this.f20187b;
    }

    public final boolean component3() {
        return this.f20188c;
    }

    public final View component4() {
        return this.f20189d;
    }

    public final InfoWindowOptions copy(InfoWindow.Position position, int i, boolean z, View view) {
        return new InfoWindowOptions(position, i, z, view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoWindowOptions)) {
            return false;
        }
        InfoWindowOptions infoWindowOptions = (InfoWindowOptions) obj;
        return this.f20186a == infoWindowOptions.f20186a && this.f20187b == infoWindowOptions.f20187b && this.f20188c == infoWindowOptions.f20188c && Intrinsics.areEqual((Object) this.f20189d, (Object) infoWindowOptions.f20189d);
    }

    public int hashCode() {
        InfoWindow.Position position = this.f20186a;
        int i = 0;
        int hashCode = (((position == null ? 0 : position.hashCode()) * 31) + this.f20187b) * 31;
        boolean z = this.f20188c;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        View view = this.f20189d;
        if (view != null) {
            i = view.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "InfoWindowOptions(position=" + this.f20186a + ", zIndex=" + this.f20187b + ", visiable=" + this.f20188c + ", contentView=" + this.f20189d + VersionRange.RIGHT_OPEN;
    }

    private InfoWindowOptions(InfoWindow.Position position, int i, boolean z, View view) {
        this.f20186a = position;
        this.f20187b = i;
        this.f20188c = z;
        this.f20189d = view;
    }

    public final InfoWindow.Position getPosition() {
        return this.f20186a;
    }

    public final void setPosition(InfoWindow.Position position) {
        this.f20186a = position;
    }

    public final int getZIndex() {
        return this.f20187b;
    }

    public final void setZIndex(int i) {
        this.f20187b = i;
    }

    public final boolean getVisiable() {
        return this.f20188c;
    }

    public final void setVisiable(boolean z) {
        this.f20188c = z;
    }

    public final View getContentView() {
        return this.f20189d;
    }

    public final void setContentView(View view) {
        this.f20189d = view;
    }

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/entrega/customer/map/infowindow/InfoWindowOptions$Builder;", "", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContentView", "()Landroid/view/View;", "<set-?>", "Lcom/didi/common/map/model/InfoWindow$Position;", "position", "getPosition", "()Lcom/didi/common/map/model/InfoWindow$Position;", "", "visible", "getVisible", "()Z", "", "zIndex", "getZIndex", "()I", "build", "Lcom/didi/entrega/customer/map/infowindow/InfoWindowOptions;", "setPosition", "setVisible", "setZIndex", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
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

        public final InfoWindow.Position getPosition() {
            return this.position;
        }

        public final int getZIndex() {
            return this.zIndex;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final Builder setPosition(InfoWindow.Position position2) {
            Intrinsics.checkNotNullParameter(position2, "position");
            this.position = position2;
            return this;
        }

        public final Builder setZIndex(int i) {
            this.zIndex = i;
            return this;
        }

        public final Builder setVisible(boolean z) {
            this.visible = z;
            return this;
        }

        public final InfoWindowOptions build() {
            return new InfoWindowOptions(this.position, this.zIndex, this.visible, this.contentView, (DefaultConstructorMarker) null);
        }
    }
}
