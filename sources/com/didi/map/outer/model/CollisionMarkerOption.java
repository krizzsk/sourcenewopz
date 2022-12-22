package com.didi.map.outer.model;

import com.didi.map.base.bubble.AnimationSetting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollisionMarkerOption extends BaseMarkerOption {
    public static final int COLLISION_NOT_DISAPPEAR_FIRST_CONSIDER_OUTSCREEN = 32768;
    public static final int NO_GROUP = -1;
    public static final int NO_SCREEN_COLLISION_TYPE = 256;
    public static final int OUT_SCREEN_AND_COLLISION_TYPE = 2;
    public static final int SCREEN_AND_COLLISION_NOT_DISAPPEAR = 16;
    public static final int SECTION_COLLISION_TYPE = 32768;
    private AnimationSetting animationSetting;
    private int collisionType = 33042;
    private int groupId = -1;
    private boolean isInfoWindowCollied = true;
    private int priority;
    private final List<AnchorBitmapDescriptor> rects;
    private final List<AnchorBitmapDescriptor> rectsOriginal;
    private final Section section;
    private int type = 256;

    public static class Section {
        public int[] endNums;
        public long routeID;
        public List<LatLng> routePoints;
        public int sectionCount;
        public int[] startNums;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface collisionType {
    }

    public CollisionMarkerOption(Section section2) {
        super((LatLng) null);
        ArrayList arrayList = new ArrayList();
        this.rectsOriginal = arrayList;
        this.rects = Collections.synchronizedList(arrayList);
        this.section = section2;
    }

    public CollisionMarkerOption(LatLng latLng) {
        super(latLng);
        ArrayList arrayList = new ArrayList();
        this.rectsOriginal = arrayList;
        this.rects = Collections.synchronizedList(arrayList);
        this.section = null;
    }

    public int getPriority() {
        return this.priority;
    }

    public CollisionMarkerOption setPriority(int i) {
        this.priority = i;
        return this;
    }

    public CollisionMarkerOption setType(int i) {
        this.type = i;
        return this;
    }

    public AnimationSetting getAnimationSetting() {
        return this.animationSetting;
    }

    public void setAnimatiomSetting(int i, long j, int i2) {
        this.animationSetting = new AnimationSetting(i, j, i2);
    }

    public Section getSection() {
        return this.section;
    }

    public CollisionMarkerOption setInfoWindowCollied(boolean z) {
        this.isInfoWindowCollied = z;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public CollisionMarkerOption addAnchorBitmap(AnchorBitmapDescriptor anchorBitmapDescriptor) {
        this.rects.add(anchorBitmapDescriptor);
        return this;
    }

    public void clearAllAnchorBitmap() {
        this.rects.clear();
    }

    public int getAnchorBitmapsSize() {
        return this.rects.size();
    }

    public AnchorBitmapDescriptor getAnchorBitmap(int i) {
        if (i >= this.rects.size()) {
            return null;
        }
        return this.rects.get(i);
    }

    public List<AnchorBitmapDescriptor> getAllAnchorBitmap() {
        return this.rects;
    }

    public int getCollisionType() {
        return this.collisionType;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setNeedCollision(boolean z) {
        if (!z) {
            this.collisionType = 0;
            this.type = 0;
            return;
        }
        this.collisionType = 33042;
        this.type = 256;
    }

    public boolean isInfoWindowCollied() {
        return this.isInfoWindowCollied;
    }
}
