
public class Connection {
	private Neuron sender;
	private Neuron receiver;
	private double weight;
	private double partialweight;
	
	Connection(Neuron sender, Neuron receiver, double weight) {
		this.sender = sender;
		this.receiver = receiver;
		this.weight = weight;

		sender.addOutgoing(this);
		receiver.addIncoming(this);
	}

	Neuron getSender() {
		return sender;
	}

	Neuron getReceiver() {
		return receiver;
	}

	double getWeight() {
		return weight;
	}
	
	double getPartialWeight() {
		return partialweight;
	}
	
	void setPartialWeight(double weight) {
		this.partialweight = weight;
	}
	
	@Override
	public String toString() {
		return Double.toString(weight);
	}
}
