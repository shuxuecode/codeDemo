package com.zsx;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * @date 2022/4/2
 */
public class PrintMyActorRefActor extends AbstractActor {

    static Props props() {
        return Props.create(PrintMyActorRefActor.class, PrintMyActorRefActor::new);
    }

    @Override
    public Receive createReceive() {

        return receiveBuilder().matchEquals("printit", p -> {
            ActorRef actorRef = getContext().actorOf(Props.empty(), "scond-actor");
            System.out.println("secod: " + actorRef);
        }).build();
    }
}
