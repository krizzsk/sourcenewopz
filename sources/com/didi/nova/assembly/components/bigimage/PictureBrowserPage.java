package com.didi.nova.assembly.components.bigimage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ViewPagerPageAdapter;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.FadeChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.TransitionChangeHandlerCompat;
import com.didi.app.nova.skeleton.image.Fly;
import com.didi.nova.assembly.components.bigimage.photoview.PhotoView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class PictureBrowserPage extends Page {
    public static final String KEY_INDEX = "PictureBrowserPage.Key.Index";
    public static final String KEY_URL_ARRAY = "PictureBrowserPage.Key.Urls";

    /* renamed from: a */
    ViewPager f29091a;

    /* renamed from: b */
    ViewPagerPageAdapter f29092b;

    /* renamed from: c */
    private ControllerChangeHandler f29093c;

    /* renamed from: d */
    private ControllerChangeHandler f29094d;

    public static void show(Page page, ImageView imageView, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        show(page, imageView, (Collection<String>) arrayList);
    }

    public static void show(Page page, ImageView imageView, Collection<String> collection) {
        show(page, imageView, collection, 0);
    }

    public static void show(Page page, ImageView imageView, Collection<String> collection, int i) {
        ControllerChangeHandler controllerChangeHandler;
        ControllerChangeHandler controllerChangeHandler2;
        if (page != null && collection != null && collection.size() != 0 && i >= 0 && i < collection.size()) {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList(collection);
            bundle.putStringArrayList(KEY_URL_ARRAY, arrayList);
            bundle.putInt(KEY_INDEX, i);
            PictureBrowserPage pictureBrowserPage = new PictureBrowserPage();
            pictureBrowserPage.setArgs(bundle);
            if (imageView != null) {
                String format = String.format("transition.image${%s}", new Object[]{arrayList.get(i)});
                ViewCompat.setTransitionName(imageView, format);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(format);
                controllerChangeHandler = new TransitionChangeHandlerCompat(new PictureSharedElementTransitionChangeHandler(arrayList2), new FadeChangeHandler());
                controllerChangeHandler2 = new TransitionChangeHandlerCompat(new PictureSharedElementTransitionChangeHandler(arrayList2), new FadeChangeHandler());
            } else {
                controllerChangeHandler = new FadeChangeHandler();
                controllerChangeHandler2 = new FadeChangeHandler();
            }
            pictureBrowserPage.setPushHandler(controllerChangeHandler);
            pictureBrowserPage.setPopHandler(controllerChangeHandler2);
            page.push(pictureBrowserPage);
        }
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.nova_assemblyunit_page_picture_browser, viewGroup, false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        getTitleBar().setHidden(true);
        this.f29091a = (ViewPager) view.findViewById(R.id.page_picture_browser_vp);
        final ArrayList<String> stringArrayList = getArgs().getStringArrayList(KEY_URL_ARRAY);
        if (stringArrayList == null || stringArrayList.size() == 0) {
            finish();
            return;
        }
        int max = Math.max(0, Math.min(getArgs().getInt(KEY_INDEX, 0), stringArrayList.size() - 1));
        C102551 r1 = new ViewPagerPageAdapter(this) {
            public Page instantiatePage(int i) {
                PhotoItemPage photoItemPage = new PhotoItemPage();
                Bundle bundle = new Bundle();
                bundle.putString("url", (String) stringArrayList.get(i));
                photoItemPage.setArgs(bundle);
                return photoItemPage;
            }

            public int getCount() {
                return stringArrayList.size();
            }
        };
        this.f29092b = r1;
        this.f29091a.setAdapter(r1);
        this.f29091a.setCurrentItem(max);
    }

    public boolean onHandleBack() {
        this.f29091a.getCurrentItem();
        getArgs().getInt(KEY_INDEX);
        return super.onHandleBack();
    }

    static class PhotoItemPage extends Page {
        private PhotoView photoView;

        PhotoItemPage() {
        }

        public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            this.photoView = (PhotoView) layoutInflater.inflate(R.layout.nova_assemblyunit_page_item_picture, viewGroup, false);
            String string = getArgs().getString("url");
            Fly.with((Context) this).load(string).into((ImageView) this.photoView);
            ViewCompat.setTransitionName(this.photoView, String.format("transition.image${%s}", new Object[]{string}));
            return this.photoView;
        }
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f29093c;
    }

    public ControllerChangeHandler getPopHandler() {
        return this.f29094d;
    }

    public void setPushHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f29093c = controllerChangeHandler;
    }

    public void setPopHandler(ControllerChangeHandler controllerChangeHandler) {
        this.f29094d = controllerChangeHandler;
    }
}
