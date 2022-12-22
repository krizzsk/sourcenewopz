package com.didi.dimina.container.secondparty.permission.overlay;

import com.didi.dimina.container.secondparty.permission.Boot;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MRequestFactory implements Boot.OverlayRequestFactory {
    public OverlayRequest create(Source source) {
        return new C7605c(source);
    }
}
