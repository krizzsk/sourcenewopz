package com.didi.map.core.element;

public interface OnMapElementClickListener {

    /* renamed from: com.didi.map.core.element.OnMapElementClickListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onClickBubble(OnMapElementClickListener onMapElementClickListener, BaseClickBubbleParam baseClickBubbleParam) {
        }
    }

    void onAnnoClick(MapAnnotation mapAnnotation);

    void onClickBubble(BaseClickBubbleParam baseClickBubbleParam);

    void onExtendIconClick(MapExtendIcon mapExtendIcon);

    void onPoiIconClick(String str);

    void onTrafficIconClick(MapTrafficIcon mapTrafficIcon);
}
