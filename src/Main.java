import jade.core.Agent;
import jade.core.AgentContainer;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


public class Main {
    public static void main(String[] args) {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        profile.setParameter(Profile.GUI, "true");

        jade.wrapper.AgentContainer container = runtime.createMainContainer(profile);

        try {
            AgentController senderAgent = container.createNewAgent("SenderAgent", SenderAgent.class.getName(), null);
            senderAgent.start();

            AgentController receiverAgent = container.createNewAgent("ReceiverAgent", ReceiverAgent.class.getName(), null);
            receiverAgent.start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}