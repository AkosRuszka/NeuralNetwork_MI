package dom;

import java.util.ArrayList;
import java.util.List;

public class NeuronLevel {
	private ArrayList<Neuron> neurons;
	private int level;
	private int neuronnumbers;
	
	public NeuronLevel(ArrayList<Neuron> neuronlist, int level) {
		this.level = level;
		neurons = neuronlist;		
		neuronnumbers = neurons.size();
	}

	public List<Neuron> getNeurons() {
		return neurons;
	}

	public int getNeuronnumbers() {
		return neuronnumbers;
	}

}
