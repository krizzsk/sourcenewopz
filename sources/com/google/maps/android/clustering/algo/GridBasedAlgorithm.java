package com.google.maps.android.clustering.algo;

import androidx.collection.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GridBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_GRID_SIZE = 100;
    private int mGridSize = 100;
    private final Set<T> mItems = Collections.synchronizedSet(new HashSet());

    public boolean addItem(T t) {
        return this.mItems.add(t);
    }

    public boolean addItems(Collection<T> collection) {
        return this.mItems.addAll(collection);
    }

    public void clearItems() {
        this.mItems.clear();
    }

    public boolean removeItem(T t) {
        return this.mItems.remove(t);
    }

    public boolean removeItems(Collection<T> collection) {
        return this.mItems.removeAll(collection);
    }

    public boolean updateItem(T t) {
        boolean removeItem;
        synchronized (this.mItems) {
            removeItem = removeItem(t);
            if (removeItem) {
                removeItem = addItem(t);
            }
        }
        return removeItem;
    }

    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.mGridSize = i;
    }

    public int getMaxDistanceBetweenClusteredItems() {
        return this.mGridSize;
    }

    public Set<? extends Cluster<T>> getClusters(float f) {
        long j;
        long ceil = (long) Math.ceil((Math.pow(2.0d, (double) f) * 256.0d) / ((double) this.mGridSize));
        SphericalMercatorProjection sphericalMercatorProjection = new SphericalMercatorProjection((double) ceil);
        HashSet hashSet = new HashSet();
        LongSparseArray longSparseArray = new LongSparseArray();
        synchronized (this.mItems) {
            for (T t : this.mItems) {
                Point point = sphericalMercatorProjection.toPoint(t.getPosition());
                long coord = getCoord(ceil, point.f53781x, point.f53782y);
                StaticCluster staticCluster = (StaticCluster) longSparseArray.get(coord);
                if (staticCluster == null) {
                    j = ceil;
                    staticCluster = new StaticCluster(sphericalMercatorProjection.toLatLng(new com.google.maps.android.geometry.Point(Math.floor(point.f53781x) + 0.5d, Math.floor(point.f53782y) + 0.5d)));
                    longSparseArray.put(coord, staticCluster);
                    hashSet.add(staticCluster);
                } else {
                    j = ceil;
                }
                staticCluster.add(t);
                ceil = j;
            }
        }
        return hashSet;
    }

    public Collection<T> getItems() {
        return this.mItems;
    }

    private static long getCoord(long j, double d, double d2) {
        return (long) ((((double) j) * Math.floor(d)) + Math.floor(d2));
    }
}
