import java.util.ArrayList;
import java.util.List;

class Neuron {
	private List<Connection> incoming;
	private List<Connection> outgoing;
	private double bias = 0.0;
	private double partialbias;
	
	private double value; /* Megfeleltethető az 's' értéknek */
	private double delta;
	
	Neuron(boolean first) {
		value = 0;
		delta = 0;
		if(first) {
			incoming = null;
		} else {
			incoming = new ArrayList<Connection>();
		}
		outgoing = new ArrayList<Connection>();
	}
	
	void addIncoming(Connection oneconnection) {
		incoming.add(oneconnection);
	}
	
	void addOutgoing(Connection oneconnection) {
		outgoing.add(oneconnection);
	}
	
	double getBias() {
		return bias;
	}

	void clearValue() {
		value = 0;
	}
	
	void setBias(double bias) {
		this.bias = bias;
	}
	
	void setValue(double value) {
		this.value = value;
	}
	
	void addValue(double value) {
		this.value += value;
	}
	
	double getValue() {
		return value;
	}
	
	double getDelta() {
		return delta;
	}
	
	void setPartialBias(double partialbias) {
		this.partialbias = partialbias;
	}
	
	double getPartialBias() {
		return this.partialbias;
	}
	
	void setDelta(double delta) {
		this.delta = delta;
	}
	
	void addDelta(double delta) {
		this.delta += delta;
	}
	
	List<Connection> getOutgoing() {
		return outgoing;
	}
	
	List<Connection> getIncoming() {
		return incoming;
	}
 }
