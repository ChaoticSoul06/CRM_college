package newcus.customer;

public class Interaction {
    private int interactionId;
    private int customerId;
    private String interactionDetails;

    public Interaction(int interactionId, int customerId, String interactionDetails) {
        this.interactionId = interactionId;
        this.customerId = customerId;
        this.interactionDetails = interactionDetails;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "customerId=" + customerId +
                ", interactionId=" + interactionId +
                ", interactionDetails='" + interactionDetails + '\'' +
                '}';
    }

    public int getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getInteractionDetails() {
        return interactionDetails;
    }

    public void setInteractionDetails(String interactionDetails) {
        this.interactionDetails = interactionDetails;
    }
}
