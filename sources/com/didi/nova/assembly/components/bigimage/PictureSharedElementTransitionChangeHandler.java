package com.didi.nova.assembly.components.bigimage;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.changehandler.SharedElementTransitionChangeHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PictureSharedElementTransitionChangeHandler extends SharedElementTransitionChangeHandler {

    /* renamed from: a */
    private static final String f29095a = "PictureSharedElementTransitionChangeHandler.names";

    /* renamed from: b */
    private final ArrayList<String> f29096b;

    public PictureSharedElementTransitionChangeHandler() {
        this.f29096b = new ArrayList<>();
    }

    public PictureSharedElementTransitionChangeHandler(List<String> list) {
        this.f29096b = new ArrayList<>(list);
    }

    public void configureSharedElements(ViewGroup viewGroup, View view, View view2, boolean z) {
        Iterator<String> it = this.f29096b.iterator();
        while (it.hasNext()) {
            String next = it.next();
            addSharedElement(next);
            waitOnSharedElementNamed(next);
        }
    }

    public Transition getExitTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        return new Fade();
    }

    public Transition getSharedElementTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new TransitionSet().addTransition(new ChangeBounds()).addTransition(new ChangeClipBounds()).addTransition(new ChangeTransform());
        }
        return new Fade();
    }

    public Transition getEnterTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        return new Fade();
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putStringArrayList(f29095a, this.f29096b);
    }

    public void restoreFromBundle(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(f29095a);
        if (stringArrayList != null) {
            this.f29096b.addAll(stringArrayList);
        }
    }
}
