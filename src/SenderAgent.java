import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {
    protected void setup() {
        System.out.println("SenderAgent " + getAID().getName() + " is ready.");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.setContent("Hello, ReceiverAgent!");

                msg.addReceiver(new AID("ReceiverAgent", AID.ISLOCALNAME));
                send(msg);
                
                block();
            }
        });
    }
}

