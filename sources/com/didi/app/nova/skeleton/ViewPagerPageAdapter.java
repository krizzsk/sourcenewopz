package com.didi.app.nova.skeleton;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.app.nova.skeleton.conductor.Router;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl;
import java.util.ArrayList;

public abstract class ViewPagerPageAdapter extends PagerAdapter {
    private static final String KEY_MAX_PAGES_TO_STATE_SAVE = "ViewPagerPageAdapter.maxPagesToStateSave";
    private static final String KEY_SAVED_PAGES = "ViewPagerPageAdapter.savedStates";
    private static final String KEY_SAVE_PAGE_HISTORY = "ViewPagerPageAdapter.savedPageHistory";
    private final Page host;
    private int maxPagesToStateSave = Integer.MAX_VALUE;
    private ArrayList<Integer> savedPageHistory = new ArrayList<>();
    private SparseArray<Bundle> savedPages = new SparseArray<>();
    private SparseArray<PageInstrument> visibleInstruments = new SparseArray<>();

    public long getItemId(int i) {
        return (long) i;
    }

    public abstract Page instantiatePage(int i);

    public ViewPagerPageAdapter(Page page) {
        this.host = page;
    }

    public void setMaxPagesToStateSave(int i) {
        if (i >= 0) {
            this.maxPagesToStateSave = i;
            ensurePagesSaved();
            return;
        }
        throw new IllegalArgumentException("Only positive integers may be passed for maxPagesToStateSave.");
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Bundle bundle;
        PageInstrumentImpl pageInstrumentImpl = (PageInstrumentImpl) this.host.getInstrument(viewGroup, makeRouterName(viewGroup.getId(), getItemId(i)), true);
        if (!pageInstrumentImpl.hasRootPage() && (bundle = this.savedPages.get(i)) != null) {
            pageInstrumentImpl.f61861router.restoreInstanceState(bundle);
            this.savedPages.remove(i);
        }
        pageInstrumentImpl.f61861router.rebindIfNeeded();
        if (!pageInstrumentImpl.hasRootPage()) {
            pageInstrumentImpl.setRootPage(instantiatePage(i));
        }
        this.visibleInstruments.put(i, pageInstrumentImpl);
        return pageInstrumentImpl;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Router router2 = ((PageInstrumentImpl) obj).f61861router;
        Bundle bundle = new Bundle();
        router2.saveInstanceState(bundle);
        this.savedPages.put(i, bundle);
        this.savedPageHistory.remove(Integer.valueOf(i));
        this.savedPageHistory.add(Integer.valueOf(i));
        ensurePagesSaved();
        this.host.controller.removeChildRouter(router2);
        this.visibleInstruments.remove(i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        for (RouterTransaction controller : ((PageInstrumentImpl) obj).f61861router.getBackstack()) {
            if (controller.controller().getView() == view) {
                return true;
            }
        }
        return false;
    }

    public Parcelable saveState() {
        Bundle bundle = new Bundle();
        bundle.putSparseParcelableArray(KEY_SAVED_PAGES, this.savedPages);
        bundle.putInt(KEY_MAX_PAGES_TO_STATE_SAVE, this.maxPagesToStateSave);
        bundle.putIntegerArrayList(KEY_SAVE_PAGE_HISTORY, this.savedPageHistory);
        return bundle;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Bundle bundle = (Bundle) parcelable;
        if (parcelable != null) {
            this.savedPages = bundle.getSparseParcelableArray(KEY_SAVED_PAGES);
            this.maxPagesToStateSave = bundle.getInt(KEY_MAX_PAGES_TO_STATE_SAVE);
            this.savedPageHistory = bundle.getIntegerArrayList(KEY_SAVE_PAGE_HISTORY);
        }
    }

    public PageInstrument getInstrument(int i) {
        return this.visibleInstruments.get(i);
    }

    /* access modifiers changed from: package-private */
    public SparseArray<Bundle> getSavedPages() {
        return this.savedPages;
    }

    private void ensurePagesSaved() {
        while (this.savedPages.size() > this.maxPagesToStateSave) {
            this.savedPages.remove(this.savedPageHistory.remove(0).intValue());
        }
    }

    private static String makeRouterName(int i, long j) {
        return i + ":" + j;
    }
}
