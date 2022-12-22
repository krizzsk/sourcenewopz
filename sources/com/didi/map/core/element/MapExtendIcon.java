package com.didi.map.core.element;

import com.didi.map.outer.model.LatLng;

public class MapExtendIcon {
    public static final int MAP_EXTEND_ICON_TYPE = 5;
    public static final int MAP_EXTEND_ICON_TYPE_DANGER = 6;
    private final byte[] mData;
    private final long mId;
    private final int mItemType;
    private LatLng mLatLng;

    private MapExtendIcon(Builder builder) {
        this.mId = builder.mId;
        this.mData = builder.mData;
        this.mItemType = builder.mItemType;
        this.mLatLng = builder.mLatLng;
    }

    public long getId() {
        return this.mId;
    }

    public byte[] getData() {
        return this.mData;
    }

    public int getItemType() {
        return this.mItemType;
    }

    public LatLng getLatLng() {
        return this.mLatLng;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public byte[] mData;
        /* access modifiers changed from: private */
        public long mId;
        /* access modifiers changed from: private */
        public int mItemType;
        /* access modifiers changed from: private */
        public LatLng mLatLng;

        /* renamed from: id */
        public Builder mo72570id(long j) {
            this.mId = j;
            return this;
        }

        public Builder data(byte[] bArr) {
            this.mData = bArr;
            return this;
        }

        public Builder itemType(int i) {
            this.mItemType = i;
            return this;
        }

        public Builder latLng(LatLng latLng) {
            this.mLatLng = latLng;
            return this;
        }

        public MapExtendIcon builder() {
            return new MapExtendIcon(this);
        }
    }

    public String toString() {
        return "MapExtendIcon{mId=" + this.mId + ", mItemType=" + this.mItemType + ", mLatLng=" + this.mLatLng + '}';
    }
}
