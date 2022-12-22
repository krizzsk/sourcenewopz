package com.yanzhenjie.permission.overlay;

import com.yanzhenjie.permission.Boot;
import com.yanzhenjie.permission.source.Source;

public class LRequestFactory implements Boot.OverlayRequestFactory {
    public OverlayRequest create(Source source) {
        return new C20716b(source);
    }
}
