package com.didi.map.outer.model;

import android.content.Context;
import com.didi.map.alpha.maps.internal.ICollisionGroupDelegate;
import com.didi.map.alpha.maps.internal.IMarkerDelegate;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DidiMap;
import java.util.ArrayList;
import java.util.List;

public final class CollisionMarker extends DMarker<DidiMap.CollisionMarkerInfoWindowAdapter, DidiMap.OnCollisionMarkerClickListener, DidiMap.OnCollisionInfoWindowClickListener> {
    private String collisionGroupId;
    private final ICollisionGroupDelegate control;
    private DidiMap.CollisionMarkerInfoWindowAdapter mInfoWindowAdapter;
    private DidiMap.OnCollisionInfoWindowClickListener mOnInfoWindowClickListener;
    private CollisionMarkerOption option;

    public CollisionMarker(CollisionMarkerOption collisionMarkerOption, ICollisionGroupDelegate iCollisionGroupDelegate, IMarkerDelegate iMarkerDelegate, String str, String str2) {
        super(collisionMarkerOption, iMarkerDelegate, str);
        this.control = iCollisionGroupDelegate;
        this.option = collisionMarkerOption;
        this.collisionGroupId = str2;
    }

    public void remove() {
        this.control.removeCollisionOverlay(this.collisionGroupId, this.strId);
    }

    public void setPosition(LatLng latLng) {
        this.control.updateCollisionMarkerPosition(this.collisionGroupId, this.strId, latLng);
        this.option.position(latLng);
    }

    public void setNeedCollision(boolean z) {
        this.option.setNeedCollision(z);
        this.control.updateCollisionMarkerOption(this.collisionGroupId, this.strId, this.option);
    }

    public void setAnchorBitmap(List<AnchorBitmapDescriptor> list) {
        if (list != null && list.size() > 0) {
            this.option.clearAllAnchorBitmap();
            for (AnchorBitmapDescriptor addAnchorBitmap : list) {
                this.option.addAnchorBitmap(addAnchorBitmap);
            }
            this.control.updateCollisionMarkerOption(this.collisionGroupId, this.strId, this.option);
        }
    }

    public void setCollisionType(int i) {
        this.option.setType(i);
        this.control.updateCollisionMarkerOption(this.collisionGroupId, this.strId, this.option);
    }

    public void setCollisionOption(CollisionMarkerOption collisionMarkerOption) {
        this.option.setType(collisionMarkerOption.getType());
        this.option.setPriority(collisionMarkerOption.getPriority());
        this.option.position(collisionMarkerOption.getPosition());
        this.option.zIndex(collisionMarkerOption.getZIndex());
        ArrayList<AnchorBitmapDescriptor> arrayList = new ArrayList<>();
        if (collisionMarkerOption.getAllAnchorBitmap() != null && collisionMarkerOption.getAllAnchorBitmap().size() > 0) {
            arrayList.addAll(collisionMarkerOption.getAllAnchorBitmap());
            this.option.clearAllAnchorBitmap();
            for (AnchorBitmapDescriptor addAnchorBitmap : arrayList) {
                this.option.addAnchorBitmap(addAnchorBitmap);
            }
        }
        this.control.updateCollisionMarkerOption(this.collisionGroupId, this.strId, this.option);
    }

    public void setPriority(int i) {
        this.option.setPriority(i);
        this.control.updateCollisionMarkerOption(this.collisionGroupId, this.strId, this.option);
    }

    public void setVisible(boolean z) {
        this.control.setVisible(this.collisionGroupId, this.strId, z);
        this.option.visible(z);
    }

    public boolean isVisible() {
        return this.control.isVisible(this.collisionGroupId, this.strId);
    }

    public CollisionMarkerOption getOptions() {
        return this.option;
    }

    public int getWidth(Context context) {
        int curShowTexture = this.control.getCurShowTexture(this.collisionGroupId, this.strId);
        if (curShowTexture == -1 || curShowTexture >= this.option.getAllAnchorBitmap().size()) {
            return 0;
        }
        return this.option.getAllAnchorBitmap().get(curShowTexture).getWidth();
    }

    public int getHeight(Context context) {
        int curShowTexture = this.control.getCurShowTexture(this.collisionGroupId, this.strId);
        if (curShowTexture == -1 || curShowTexture >= this.option.getAllAnchorBitmap().size()) {
            return 0;
        }
        return this.option.getAllAnchorBitmap().get(curShowTexture).getHeight();
    }

    public float getAnchorU() {
        int curShowTexture = this.control.getCurShowTexture(this.collisionGroupId, this.strId);
        if (curShowTexture == -1 || curShowTexture >= this.option.getAllAnchorBitmap().size()) {
            return 0.0f;
        }
        return this.option.getAllAnchorBitmap().get(curShowTexture).getAnchorX();
    }

    public float getAnchorV() {
        int curShowTexture = this.control.getCurShowTexture(this.collisionGroupId, this.strId);
        if (curShowTexture == -1 || curShowTexture >= this.option.getAllAnchorBitmap().size()) {
            return 0.0f;
        }
        return this.option.getAllAnchorBitmap().get(curShowTexture).getAnchorY();
    }

    public void setInfoWindowAdapter(DidiMap.CollisionMarkerInfoWindowAdapter collisionMarkerInfoWindowAdapter) {
        this.mInfoWindowAdapter = collisionMarkerInfoWindowAdapter;
    }

    public DidiMap.CollisionMarkerInfoWindowAdapter getInfoWindowAdapter() {
        return this.mInfoWindowAdapter;
    }

    public void setOnClickListener(DidiMap.OnCollisionMarkerClickListener onCollisionMarkerClickListener) {
        this.markerControl.setOnClickListener(this.strId, onCollisionMarkerClickListener);
    }

    public void setOnInfoWindowClickListener(DidiMap.OnCollisionInfoWindowClickListener onCollisionInfoWindowClickListener) {
        this.mOnInfoWindowClickListener = onCollisionInfoWindowClickListener;
    }

    public DidiMap.OnCollisionInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.mOnInfoWindowClickListener;
    }
}
