package com.google.android.cameraview;

import androidx.collection.ArrayMap;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class SizeMap {
    private final SortedSet<Size> mAllSize = new TreeSet(new Comparator<Size>() {
        public int compare(Size size, Size size2) {
            if (size.getWidth() < size2.getWidth()) {
                return -1;
            }
            if (size.getWidth() == size2.getWidth()) {
                return size.getHeight() - size2.getHeight();
            }
            return 1;
        }
    });
    private Size mDefaultSize;
    private final ArrayMap<AspectRatio, SortedSet<Size>> mRatios = new ArrayMap<>();

    SizeMap() {
    }

    public boolean add(Size size) {
        this.mAllSize.add(size);
        for (AspectRatio next : this.mRatios.keySet()) {
            if (next.matches(size)) {
                SortedSet sortedSet = this.mRatios.get(next);
                if (sortedSet.contains(size)) {
                    return false;
                }
                sortedSet.add(size);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(size);
        this.mRatios.put(AspectRatio.m37333of(size.getWidth(), size.getHeight()), treeSet);
        return true;
    }

    public void remove(AspectRatio aspectRatio) {
        this.mRatios.remove(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> ratios() {
        return this.mRatios.keySet();
    }

    /* access modifiers changed from: package-private */
    public SortedSet<Size> sizes(AspectRatio aspectRatio) {
        if (aspectRatio.getX() < 0 || aspectRatio.getY() < 0) {
            return this.mAllSize;
        }
        return this.mRatios.get(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mRatios.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.mRatios.isEmpty();
    }

    public Size getDefaultSize() {
        return this.mDefaultSize;
    }

    public void setDefaultSize(Size size) {
        this.mDefaultSize = size;
    }
}
