import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import play.Application;
import play.GlobalSettings;
import play.libs.Akka;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        super.onStart(app);

        //Using Play default ActorSystem
        ActorRef testActor = Akka.system().actorOf(Props.create(actors.HelloWorldActor.class), "testActor");

        //Using your own ActorSystem
        //ActorSystem system = ActorSystem.create("ActorSystem");
        //ActorRef testActor = system.actorOf(Props.create(actors.HelloWorldActor.class), "testActor");

        Akka.system().scheduler().schedule(
                Duration.create(0, TimeUnit.MILLISECONDS),
                Duration.create(5, TimeUnit.SECONDS),
                testActor,
                "Hello World",
                Akka.system().dispatcher(),
                null
        );
    }
}
