package dom;

public class Connection {
	private Neuron sender;
	private Neuron receiver;
	private double weight;
	private double partialweight;
	
	public Connection(Neuron sender, Neuron receiver, double weight) {
		this.sender = sender;
		this.receiver = receiver;
		this.weight = weight;

		sender.addOutgoing(this);
		receiver.addIncoming(this);
	}

	public Neuron getSender() {
		return sender;
	}

	public Neuron getReceiver() {
		return receiver;
	}

	public double getWeight() {
		return weight;
	}
	
	public double getPartialWeight() {
		return partialweight;
	}
	
	public void setPartialWeight(double weight) {
		this.partialweight = weight;
	}
	
	@Override
	public String toString() {
		return Double.toString(weight);
	}
}
