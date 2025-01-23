package demo.impl;

import demo.DemoReq;
import demo.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public void test(DemoReq req) {
        System.out.println(req.getId());
    }
}
