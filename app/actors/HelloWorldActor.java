package actors;

import akka.actor.UntypedActor;

/**
 * Simple Actor that will print out any String sent to it.
 */
public class HelloWorldActor extends UntypedActor {

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof String) {
            System.out.println(msg);
        } else {
            unhandled(msg);
        }
    }

}
