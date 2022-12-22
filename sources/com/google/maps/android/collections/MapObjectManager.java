package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

abstract class MapObjectManager<O, C extends Collection> {
    protected final Map<O, C> mAllObjects = new HashMap();
    protected final GoogleMap mMap;
    private final Map<String, C> mNamedCollections = new HashMap();

    public abstract C newCollection();

    /* access modifiers changed from: protected */
    public abstract void removeObjectFromMap(O o);

    /* access modifiers changed from: package-private */
    public abstract void setListenersOnUiThread();

    public MapObjectManager(GoogleMap googleMap) {
        this.mMap = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public C newCollection(String str) {
        if (this.mNamedCollections.get(str) == null) {
            C newCollection = newCollection();
            this.mNamedCollections.put(str, newCollection);
            return newCollection;
        }
        throw new IllegalArgumentException("collection id is not unique: " + str);
    }

    public C getCollection(String str) {
        return (Collection) this.mNamedCollections.get(str);
    }

    public boolean remove(O o) {
        Collection collection = (Collection) this.mAllObjects.get(o);
        return collection != null && collection.remove(o);
    }

    public class Collection {
        private final Set<O> mObjects = new LinkedHashSet();

        public Collection() {
        }

        /* access modifiers changed from: protected */
        public void add(O o) {
            this.mObjects.add(o);
            MapObjectManager.this.mAllObjects.put(o, this);
        }

        /* access modifiers changed from: protected */
        public boolean remove(O o) {
            if (!this.mObjects.remove(o)) {
                return false;
            }
            MapObjectManager.this.mAllObjects.remove(o);
            MapObjectManager.this.removeObjectFromMap(o);
            return true;
        }

        public void clear() {
            for (O next : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(next);
                MapObjectManager.this.mAllObjects.remove(next);
            }
            this.mObjects.clear();
        }

        /* access modifiers changed from: protected */
        public java.util.Collection<O> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }
    }
}
