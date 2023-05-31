import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
public class ReceiverAgent extends Agent {
    protected void setup() {
        System.out.println("ReceiverAgent " + getAID().getName() + " is ready.");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = receive();
                
                if (msg != null) {
                    System.out.println("Received message: " + msg.getContent());
                }
                
                block();
            }
        });
    }
}