package dom;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
	private List<Connection> incoming;
	private List<Connection> outgoing;
	private double bias = 0.0;
	private double partialbias;

	/* Megfeleltethető az 's' értéknek */
	private double value;
	private double delta;
	
	public Neuron(boolean first) {
		value = 0;
		delta = 0;
		if(first) {
			incoming = null;
		} else {
			incoming = new ArrayList<>();
		}
		outgoing = new ArrayList<>();
	}
	
	void addIncoming(Connection oneconnection) {
		incoming.add(oneconnection);
	}
	
	void addOutgoing(Connection oneconnection) {
		outgoing.add(oneconnection);
	}
	
	public double getBias() {
		return bias;
	}
	
	public void setBias(double bias) {
		this.bias = bias;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public void addValue(double value) {
		this.value += value;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getDelta() {
		return delta;
	}
	
	public void setPartialBias(double partialbias) {
		this.partialbias = partialbias;
	}
	
	public double getPartialBias() {
		return this.partialbias;
	}
	
	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	public void addDelta(double delta) {
		this.delta += delta;
	}
	
	public List<Connection> getOutgoing() {
		return outgoing;
	}
	
	public List<Connection> getIncoming() {
		return incoming;
	}
 }
