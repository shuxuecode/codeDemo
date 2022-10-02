package com.zsx.remoting;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigIncluderClasspath;
import com.typesafe.config.ConfigIncluderFile;
import com.typesafe.config.parser.ConfigDocument;
import com.typesafe.config.parser.ConfigDocumentFactory;

/**
 * @date 2022/7/13
 */
public class Server {

    public static void main(String[] args) {

        Config config = ConfigFactory.load().getConfig("server");
        ActorSystem actorSystem = ActorSystem.create("test", config);
        actorSystem.actorOf(null, "");


    }
}
