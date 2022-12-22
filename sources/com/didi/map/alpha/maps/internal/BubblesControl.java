package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.BubbleGroup;
import com.didi.map.outer.model.BubbleOptions;
import java.util.List;

public final class BubblesControl {

    /* renamed from: a */
    private IBubblesDelegate f24490a;

    public BubblesControl(IBubblesDelegate iBubblesDelegate) {
        this.f24490a = iBubblesDelegate;
    }

    public void destroy() {
        if (this.f24490a != null) {
            this.f24490a = null;
        }
    }

    public final int addBubble(BubbleOptions bubbleOptions) {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate == null) {
            return -1;
        }
        return iBubblesDelegate.addBubble(bubbleOptions, this);
    }

    public final List<Integer> addBubbles(List<BubbleOptions> list) {
        if (this.f24490a == null || list == null || list.isEmpty()) {
            return null;
        }
        return this.f24490a.addBubbles(list, this);
    }

    public final boolean removeBubble(int i) {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate == null) {
            return false;
        }
        return iBubblesDelegate.removeBubble(i);
    }

    public final void clearBubbles() {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate != null) {
            iBubblesDelegate.clearBubbles();
        }
    }

    public final BubbleGroup addBubbleGroup(List<BubbleOptions> list) {
        if (this.f24490a == null || list == null || list.isEmpty()) {
            return null;
        }
        return this.f24490a.addBubbleGroup(list, this);
    }

    public final boolean updateBubble(int i, BubbleOptions bubbleOptions) {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate == null || bubbleOptions == null) {
            return false;
        }
        return iBubblesDelegate.updateBubble(i, bubbleOptions);
    }

    public final boolean containsBubble(int i) {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate == null) {
            return false;
        }
        return iBubblesDelegate.containsBubble(i);
    }

    public final List<Integer> getBubbleIds() {
        IBubblesDelegate iBubblesDelegate = this.f24490a;
        if (iBubblesDelegate == null) {
            return null;
        }
        return iBubblesDelegate.getBubbleIds();
    }
}
