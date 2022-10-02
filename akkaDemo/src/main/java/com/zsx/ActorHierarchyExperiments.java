package com.zsx;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.io.IOException;

/**
 * @date 2022/4/2
 */
public class ActorHierarchyExperiments {

    public static void main(String[] args) throws IOException {

        ActorSystem system = ActorSystem.create("test");

        ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");

        System.out.println("firstRef : " + firstRef);

        firstRef.tell("printit", ActorRef.noSender());

        System.out.println("点击 ENTER 退出");

        try {
            System.in.read();
        } finally {
            system.terminate();
        }


    }

}
