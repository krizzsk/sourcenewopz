package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.GridInfo */
public final class GridInfo extends Message {
    public static final String DEFAULT_DETAILINFO = "";
    public static final String DEFAULT_GRID = "";
    public static final List<LocPoint> DEFAULT_VERTICES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final LocPoint center;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String detailInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String grid;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocPoint.class, tag = 3)
    public final List<LocPoint> vertices;

    public GridInfo(String str, LocPoint locPoint, List<LocPoint> list, String str2) {
        this.grid = str;
        this.center = locPoint;
        this.vertices = immutableCopyOf(list);
        this.detailInfo = str2;
    }

    private GridInfo(Builder builder) {
        this(builder.grid, builder.center, builder.vertices, builder.detailInfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridInfo)) {
            return false;
        }
        GridInfo gridInfo = (GridInfo) obj;
        if (!equals((Object) this.grid, (Object) gridInfo.grid) || !equals((Object) this.center, (Object) gridInfo.center) || !equals((List<?>) this.vertices, (List<?>) gridInfo.vertices) || !equals((Object) this.detailInfo, (Object) gridInfo.detailInfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.grid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        LocPoint locPoint = this.center;
        int hashCode2 = (hashCode + (locPoint != null ? locPoint.hashCode() : 0)) * 37;
        List<LocPoint> list = this.vertices;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.detailInfo;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.GridInfo$Builder */
    public static final class Builder extends Message.Builder<GridInfo> {
        public LocPoint center;
        public String detailInfo;
        public String grid;
        public List<LocPoint> vertices;

        public Builder() {
        }

        public Builder(GridInfo gridInfo) {
            super(gridInfo);
            if (gridInfo != null) {
                this.grid = gridInfo.grid;
                this.center = gridInfo.center;
                this.vertices = GridInfo.copyOf(gridInfo.vertices);
                this.detailInfo = gridInfo.detailInfo;
            }
        }

        public Builder grid(String str) {
            this.grid = str;
            return this;
        }

        public Builder center(LocPoint locPoint) {
            this.center = locPoint;
            return this;
        }

        public Builder vertices(List<LocPoint> list) {
            this.vertices = checkForNulls(list);
            return this;
        }

        public Builder detailInfo(String str) {
            this.detailInfo = str;
            return this;
        }

        public GridInfo build() {
            checkRequiredFields();
            return new GridInfo(this);
        }
    }
}
