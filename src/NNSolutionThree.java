import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NNSolutionThree {
	
	static List<NeuronLevel> neuronlevels;
	static double outp = 1.0;
	
	public static void main(String[] args) {
		neuronlevels = new ArrayList<NeuronLevel>();
		Scanner scanner = new Scanner(System.in);
		try {
			
			/* Beolvasás */
			NNSolutionOne.entering(scanner, neuronlevels);
			
			/* Súlyozás */
			NNSolutionTwo.weighting(scanner, neuronlevels);
						
			int event = Integer.parseInt(scanner.nextLine());
			for(int i=0; i<event; i++) {
				NNSolutionTwo.neuronsValueCalculated(scanner.nextLine().split(","), neuronlevels);			
			}
			partialDerivatedCalculate();
			
			/* Neuronszintekben tárolt neuronszámok kiírása*/
			int i;
			for(i=0; i<neuronlevels.size()-1; i++) {
				System.out.print(neuronlevels.get(i).getNeuronnumbers()+",");
			}
			System.out.println(neuronlevels.get(i).getNeuronnumbers());
			
			for(i=1; i<neuronlevels.size(); i++) {
				for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
					for (Connection conn : neuron.getIncoming()) {
						System.out.print(conn.getPartialWeight()+",");
					}
					System.out.println(neuron.getPartialBias());
				}
			}
		} finally {
			scanner.close();
		}
	}
	
	public static void partialDerivatedCalculate() {
		/* Fordított neuron szint bejárás a neuronok delta kiszámítására és parciális bias beállítására */
		for(int i=neuronlevels.size()-1; i>0; i--) {
			for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
				/* Delta kiszámítása */
				if(i==(neuronlevels.size()-1)) {
					/* Akkor a kimeneti szintnél járunk */
					neuron.setDelta(outp);
				} else {
					/* Ha a rejtett rétegekben vagyunk */
					for (Connection conn : neuron.getOutgoing()) {
						neuron.addDelta(conn.getWeight()*conn.getReceiver().getDelta());
					}
					neuron.setDelta(neuron.getDelta()*ActivatedFunctions.derivated_relu(neuron.getValue()));
				}				
				/* Bias parciális derivált beállítása */
				neuron.setPartialBias(neuron.getDelta());
				for (Connection conn : neuron.getIncoming()) {
					if(i==1) {
						conn.setPartialWeight(neuron.getDelta()*conn.getSender().getValue());
					} else {
						conn.setPartialWeight(neuron.getDelta()*ActivatedFunctions.relu(conn.getSender().getValue()));
					}
				}
			}
		}	
	}
}
