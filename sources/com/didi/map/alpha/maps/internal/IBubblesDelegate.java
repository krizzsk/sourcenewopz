package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.BubbleGroup;
import com.didi.map.outer.model.BubbleOptions;
import java.util.List;

interface IBubblesDelegate {
    int addBubble(BubbleOptions bubbleOptions, BubblesControl bubblesControl);

    BubbleGroup addBubbleGroup(List<BubbleOptions> list, BubblesControl bubblesControl);

    List<Integer> addBubbles(List<BubbleOptions> list, BubblesControl bubblesControl);

    void clearBubbles();

    boolean containsBubble(int i);

    List<Integer> getBubbleIds();

    boolean removeBubble(int i);

    boolean updateBubble(int i, BubbleOptions bubbleOptions);
}
