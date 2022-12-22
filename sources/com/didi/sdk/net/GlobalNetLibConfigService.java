package com.didi.sdk.net;

import com.didi.product.global.BuildConfig;
import com.didi.sdk.net.INetLibConfigService;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({INetLibConfigService.class})
public class GlobalNetLibConfigService implements INetLibConfigService {
    public INetLibConfigService.NetLibConfig getNetLibConfig() {
        INetLibConfigService.NetLibConfig netLibConfig = new INetLibConfigService.NetLibConfig();
        if (AppUtils.getMetaDataByKey("brand").equals("DiDi")) {
            netLibConfig.terminalTag = "GJHCK";
            netLibConfig.httpDnsApolloName = "HTTP_DNS_GJHCK";
            netLibConfig.httpdnsUrl = "https://hd.didiglobal.com/d?";
            netLibConfig.httpdnsBatchHosts = new String[]{"api.didiglobal.com", "cashier.didiglobal.com", "epassport.didiglobal.com", "poimap.didiglobal.com", "as.didiglobal.com", "omgup.didiglobal.com", "catchdata.didiglobal.com", "dynamicmodule.didiglobal.com"};
        } else if (AppUtils.getMetaDataByKey("brand").equals("99")) {
            netLibConfig.terminalTag = "BXCK";
            netLibConfig.httpDnsApolloName = "httpdns_brazil_psnger";
            netLibConfig.httpdnsUrl = "https://hd.didiglobal.com/d?";
            netLibConfig.httpdnsBatchHosts = new String[]{"api.didiglobal.com", "cashier.didiglobal.com", "conf.didiglobal.com", "epassport.didiglobal.com", "common.didiglobal.com", "poimap.didiglobal.com", "as.didiglobal.com", "omgup.didiglobal.com", "catchdata.didiglobal.com", "dynamicmodule.didiglobal.com", "ct.didiglobal.com", "res.didiglobal.com", "lion.didiglobal.com", BuildConfig.PUSH_IP, "hd.didiglobal.com"};
            netLibConfig.blackHosts = new String[]{"lbssp.map.qq.com", "up-hl.3g.qq.com", "yun-hl.3g.qq.com", "wcad.tim.com.br", "meuplano.tim.com.br", "graph.facebook.com", "portalrecarga.vivo.com.br", "clients4.google.com", "t.appsflyer.com"};
        }
        return netLibConfig;
    }
}
