## Neurális hálózat implementálása

A projekt a BME Mesterséges Intelligencia tárgyhoz készült.   
Neurális hálózat implementálását mutatja be.

#### NNSolutionOne

Adott architektúrájú neurális hálózat súlyainak és bias értékeinek inicializálását végzi. 

| Érték | Leírás |
| ----- | ------ |
| Súly | nulla várható értéká, 0.1 szórású normális eloszlásból sorsolt véletlen szám |
| Bias | nulla értékű inicializáció | 

Példa bemenet és kimenet: 

```
2,3,1
0.07694805,-0.04505534,0.0
0.07036076,-0.008341249,0.0
-0.064064674,0.1687909,0.0
0.049475513,0.05999728,0.059059735,0.0
```

#### NNSolutionTwo

Bemenetként kapott neurális hálózat (MLP) architektúra leírás, súlyok és bemeneti értékek alapján kiszámolja a neurális hálózat kimenetét.

Bemenet minta:   
Architektúra --> Súlyok --> Bemenetek

```
2,3,1
1,0,-0.5
0,1,-0.5
1,1,-1
2,2,-2,0
```

Előző bemenethez tartozó kimenet:

```
4
0,0
0,1
1,0
1,1
```

#### NNSolutionThree

Az előző feladatrészben kapott bemenet alapján kiszámolja a neurális hálózat egyes súlyainak és biasainak hatását a kiemnetre nézve (parciális deriváltak).   
ReLU deriváltja nem létezik x=0 helyen így a gyakorlatban sokszor használt megoldással élve ReLU'(0)=0

Példa bemenet:

```
2,3,1
1,0,-0.5
0,1,-0.5
1,1,-1
2,2,-2,0
1
0.75,0.75
```

Hozzá tartozó elvárt kimenet:
```
2,3,1
1.5,1.5,2.0
1.5,1.5,2.0
-1.5,-1.5,-2.0
0.25,0.25,0.5,1.0
```

#### Alap neurális hálózat minta

[[/images/neuron_network.png|Neuron network]]
