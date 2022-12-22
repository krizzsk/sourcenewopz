package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.BubblesControl;
import java.util.List;

public class BubbleGroup {
    public static final int INVALID_BUBBLE_ID = -1;

    /* renamed from: a */
    private BubblesControl f27892a;

    public BubbleGroup(BubblesControl bubblesControl) {
        this.f27892a = bubblesControl;
    }

    public int addBubble(BubbleOptions bubbleOptions) {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl == null) {
            return -1;
        }
        return bubblesControl.addBubble(bubbleOptions);
    }

    public boolean remove(int i) {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl == null) {
            return false;
        }
        return bubblesControl.removeBubble(i);
    }

    public void clearBubbleGroup() {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl != null) {
            bubblesControl.clearBubbles();
        }
    }

    public boolean updateBubble(int i, BubbleOptions bubbleOptions) {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl == null || bubbleOptions == null) {
            return false;
        }
        return bubblesControl.updateBubble(i, bubbleOptions);
    }

    public boolean containsBubble(int i) {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl == null) {
            return false;
        }
        return bubblesControl.containsBubble(i);
    }

    public List<Integer> getBubbleIds() {
        BubblesControl bubblesControl = this.f27892a;
        if (bubblesControl == null) {
            return null;
        }
        return bubblesControl.getBubbleIds();
    }
}
