package com.didi.soda.customer.biz.sliding;

import com.didi.soda.customer.biz.sliding.SlidingLooperService;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;

public interface ISlidingLooperService {
    void addDriverSlidingListener(SlidingLooperService.DriverSlidingListener driverSlidingListener);

    void removeDriverSlidingListener(SlidingLooperService.DriverSlidingListener driverSlidingListener);

    void start(OrderMapStatusModel orderMapStatusModel);

    void stop();
}
