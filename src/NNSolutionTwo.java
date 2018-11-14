import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NNSolutionTwo {
	static List<NeuronLevel> neuronlevels;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		neuronlevels = new ArrayList<NeuronLevel>();
		
		try {
			NNSolutionOne.entering(scanner, neuronlevels);
			weighting(scanner, neuronlevels);
				
			int esemeny = Integer.parseInt(scanner.nextLine());
			System.out.println(esemeny);
			
			for(int i=0; i<esemeny; i++) {
				neuronsValueCalculated(scanner.nextLine().split(","), neuronlevels);
				Neuron neur;
				int size = neuronlevels.get(neuronlevels.size()-1).getNeurons().size();
				for(int k=0; k<size; k++) {
					neur = neuronlevels.get(neuronlevels.size()-1).getNeurons().get(k);
					if(k<size-1)
						System.out.print(neur.getValue()+",");
					else {
						System.out.println(neur.getValue());
					}
				}
				//neuronlevels.forEach(x->x.neuronsSetUpDefault());
				System.out.println("\n\n\n");
				for(NeuronLevel neurons : neuronlevels) {
					for(Neuron neuron : neurons.getNeurons()) {
						System.out.print(neuron.getValue()+",");
					}
					System.out.println();
				}
			}			
		} finally {
			scanner.close();
		}		
	}
	
	public static void weighting(Scanner scanner, List<NeuronLevel> neuronlevels) {
		String[] ss;
		int ll = 0;
			for(int i=1; i<neuronlevels.size(); i++) {				
				for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
					ss = scanner.nextLine().split(",");
					ll=0;
					for (Neuron previousneuron : neuronlevels.get(i-1).getNeurons()) {
						new Connection(previousneuron, neuron, Double.parseDouble(ss[ll]));						
						ll++;
					}
				neuron.setBias(Double.parseDouble(ss[ll]));
			}
		}
	}
	
	public static void neuronsValueCalculated(String[] gerjesztoertekek, List<NeuronLevel> neuronlevels) {		
		/* Gerjesztőértékek beállítása */
		int i=0;
		for (Neuron neuron : neuronlevels.get(0).getNeurons()) {
			neuron.setValue(Double.parseDouble(gerjesztoertekek[i++]));
		}

		for(i=1; i<neuronlevels.size(); i++) {
			for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
				for (Connection conn : neuron.getIncoming()) {
					neuron.addValue(conn.getSender().getValue()*conn.getWeight());
				}
				/* Hozzáadjuk még a bias értékét. */
				neuron.addValue(neuron.getBias());
				
				/* Meghívjuk rá a súlyfüggvényt */
				if(i<neuronlevels.size()-1)
					neuron.setValue(ActivatedFunctions.relu(neuron.getValue()));
				else {
					/* Meghívjuk az utolsó rétegre (kimenetre) a lineáris-t */
					neuron.setValue(ActivatedFunctions.linear(neuron.getValue()));
				}
			}
		}
	}		
}












