package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.Boot;
import com.yanzhenjie.permission.source.Source;

public class MRequestFactory implements Boot.OverlayRequestFactory {
    public OverlayRequest create(Source source) {
        return new C20717c(source);
    }
}
