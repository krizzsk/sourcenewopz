package com.didi.component.openride.qrcodescanner;

import com.didi.util.DefaultDecodeConfigImpl;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({DecodeConfig.class})
public class GlobalDecodConfigImpl extends DefaultDecodeConfigImpl {
}
