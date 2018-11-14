import java.util.ArrayList;
import java.util.List;

public class NeuronLevel {
	private ArrayList<Neuron> neurons;
	private int level;
	private int neuronnumbers;
	
	NeuronLevel(ArrayList<Neuron> neuronlist, int level) {
		this.level = level;
		neurons = neuronlist;		
		neuronnumbers = neurons.size();
	}

	List<Neuron> getNeurons() {
		return neurons;
	}

	public int getLevel() {
		return level;
	}

	int getNeuronnumbers() {
		return neuronnumbers;
	}

	public void neuronsSetUpDefault() {
		neurons.forEach(x->x.clearValue());
	}
}
