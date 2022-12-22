package com.didi.component.common.view.recyclerdecoration;

public class Y_DividerBuilder {

    /* renamed from: a */
    private Y_SideLine f11911a;

    /* renamed from: b */
    private Y_SideLine f11912b;

    /* renamed from: c */
    private Y_SideLine f11913c;

    /* renamed from: d */
    private Y_SideLine f11914d;

    /* renamed from: e */
    private Y_SideLine f11915e = new Y_SideLine(false, -10066330, 0, 0, 0);

    public Y_DividerBuilder setLeftSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f11911a = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setTopSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f11912b = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setRightSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f11913c = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_DividerBuilder setBottomSideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f11914d = new Y_SideLine(z, i, i2, i3, i4);
        return this;
    }

    public Y_Divider create() {
        Y_SideLine y_SideLine = this.f11911a;
        if (y_SideLine == null) {
            y_SideLine = this.f11915e;
        }
        this.f11911a = y_SideLine;
        Y_SideLine y_SideLine2 = this.f11912b;
        if (y_SideLine2 == null) {
            y_SideLine2 = this.f11915e;
        }
        this.f11912b = y_SideLine2;
        Y_SideLine y_SideLine3 = this.f11913c;
        if (y_SideLine3 == null) {
            y_SideLine3 = this.f11915e;
        }
        this.f11913c = y_SideLine3;
        Y_SideLine y_SideLine4 = this.f11914d;
        if (y_SideLine4 == null) {
            y_SideLine4 = this.f11915e;
        }
        this.f11914d = y_SideLine4;
        return new Y_Divider(this.f11911a, this.f11912b, this.f11913c, y_SideLine4);
    }
}
