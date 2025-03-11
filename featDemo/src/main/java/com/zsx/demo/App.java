package com.zsx.demo;

import tech.smartboot.feat.Feat;

public class App {

    public static void main(String[] args) {
        Feat.httpServer()
                .httpHandler(request -> request.getResponse().write("Hello World"))
                .listen(8080);
    }

}
