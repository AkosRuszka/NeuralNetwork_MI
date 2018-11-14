package app;

import dom.Connection;
import dom.Neuron;
import dom.NeuronLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NNSolutionOne {
	static List<NeuronLevel> neuronlevels;
	
	public static void main(String[] args) {
		neuronlevels = new ArrayList<NeuronLevel>();
		
		/* Bekérés */
		try (Scanner scanner = new Scanner(System.in)) {
			entering(scanner, neuronlevels);
		}
		
		/* Sulyozas */
		weighting(neuronlevels);
	
		for(int i=0; i<neuronlevels.size()-1; i++) {
			System.out.print(neuronlevels.get(i).getNeuronnumbers()+",");
		}
		System.out.println(neuronlevels.get(neuronlevels.size()-1).getNeuronnumbers());
		
		for(int i=1; i<neuronlevels.size(); i++) {
			for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
				for (Connection conn : neuron.getIncoming()) {
					System.out.print(conn+", ");					
				}
				System.out.println(neuron.getBias());
			}
		}

	}
	
	private static double random_value() {
		return (new Random().nextGaussian()*0.1);
	}
	
	static void entering(Scanner scanner, List<NeuronLevel> neuronlevels) throws RuntimeException{
		
		String[] ss = scanner.nextLine().split(",");
		
		if(Integer.parseInt(ss[0]) < 1 || Integer.parseInt(ss[0]) > 100) {
			throw new RuntimeException();
		}
		
		for(int i=1; i<ss.length-1; i++) {
			if(Integer.parseInt(ss[i]) < 1 || Integer.parseInt(ss[i]) > 100) {
				throw new RuntimeException();
			}
		}
		
		if(Integer.parseInt(ss[ss.length-1]) < 1 || Integer.parseInt(ss[ss.length-1]) > 100) {
			throw new RuntimeException();
		}
		
		ArrayList<Neuron> neurons = new ArrayList<Neuron>();
		/* Első neuronok száma */		
		int neuronl = Integer.parseInt(ss[0]);
		for(int i=0; i<neuronl; i++) {
			neurons.add(new Neuron(true));
		}
		neuronlevels.add(new NeuronLevel(neurons, neuronlevels.size()));
		neurons = new ArrayList<Neuron>();
		
		/* Rejtett Szintek beolvasása */
		/* ss.length-2 -ig megyünk, mivel a 0. indexen a gerjesztő neuronok
		 * a utolsó indexen pedig a kimenő neuronok vannak, így a rejtett neuronok száma
		 * az összes beolvasott neuronok -2 -vel felel meg
		 */	
		int actlevel;
		for(int i = 0; i < (ss.length-2); i++) {
			actlevel = Integer.parseInt(ss[i+1]);
			for(int k = 0; k < actlevel; k++) {
				neurons.add(new Neuron(false));
			}
			neuronlevels.add(new NeuronLevel(neurons, neuronlevels.size()));
			neurons = new ArrayList<Neuron>();
		}
		
		/* Kimenő neuron elkészítése */
		actlevel = Integer.parseInt(ss[ss.length-1]);
		for(int k=0; k<actlevel; k++) {
			neurons.add(new Neuron(false));
		}
		neuronlevels.add(new NeuronLevel(neurons, neuronlevels.size()));
	}
	
	private static void weighting(List<NeuronLevel> neuronlevels) {
		for(int i=1; i<neuronlevels.size(); i++) {
			for (Neuron neuron : neuronlevels.get(i).getNeurons()) {
				for (Neuron previousneuron : neuronlevels.get(i-1).getNeurons()) {
					new Connection(previousneuron, neuron, random_value());
				}
			}
		}
	}
	
}
