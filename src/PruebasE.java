import java.util.Arrays;

class BusquedaBinaria{
	
	static long tInicio, tFin;
	static long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;
	
    public static int busqueda(int[]matriz, int valorBuscado) {
        if(matriz.length==0) {
            return -1;
        }
        int mitad,inferior =0;
        int superior = matriz.length-1;
        do {
        	recorridos+=1;
            mitad = (int)(inferior + superior) / 2;
            comparaciones+=1;
            if (valorBuscado > matriz[mitad]) {
            inferior = mitad + 1;
            } else {
            superior = mitad-1;
            }
            } while (matriz[mitad] != valorBuscado && inferior <= superior);
        comparaciones+=1;
            if (matriz[mitad] == valorBuscado) {
                System.out.println("Encontrado");
                return mitad;

            } else {
                System.out.println("No se encontro");
            return -1;
            }
    }
    
    public static void llamadaBusquedaBinaria(int[]nums, int valorB) {
    	shell(nums);
    	tInicio = System.nanoTime();
    	busqueda(nums,valorB);
		tFin = System.nanoTime();
		
		tiempo = tFin-tInicio;
		System.out.print("Tiempo: "+tiempo);
		System.out.print("Recorridos: "+recorridos);
		System.out.print("Comparaciones: "+comparaciones);
		System.out.println("Intercambios: "+intercambios);
		
    }
    
    
    public static void shell(int[] numeros) {
		int intervalo;
		intervalo = numeros.length/2;
		
		while(intervalo>0) {
			for(int i = intervalo; i<numeros.length; i++) {
				int j=i-intervalo;
				while(j>=0) {
					int k=j+intervalo;
					if(numeros[j] <= numeros[k]) {
						j-=1;
					}else {
						int aux = numeros[j];
						numeros[j] = numeros[k];
						numeros[k] = aux;
						j-=intervalo;
					}
				}
			}
			intervalo=intervalo/2;
		}
		
	}
    
    
}//BusquedaBinaria



class Hash{
	String[] arreglo;
	int tamaño;
	int contador;
	static long tInicio, tFin;
	static long  recorridos = 0, comparaciones = 0, intercambios = 0, tiempo = 0;

	public Hash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		for (i = 0; i < cadArreglo.length; i++) {
			recorridos+=1;
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 20;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			while (arreglo[indiceArreglo] != "-1") {
				recorridos+=1;
				comparaciones+=1;
				indiceArreglo++;
				System.out.println("ColisiÃ³n en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				indiceArreglo %= tamaño; 
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 100;
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 100; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			System.out.println();
			for (j = incremento - 100; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			System.out.println("");
		}
	}

	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 99;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			recorridos+=1;
			comparaciones+=1;
			if (arreglo[indiceArrglo].equals(elemento)) {
				System.out.println("Elemento " + elemento + " se encontro en el indice " + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			comparaciones+=1;
			if (contador > 100) {
				System.out.println("Error");
				break;
			}
		}
		return null;
	}
	
	
	public void llamadaHash(String[]nums, String valorB) {
		tInicio = System.nanoTime();
		funcionHash(nums, this.arreglo);
		String buscarElemento = buscarClave(valorB);
		if(buscarElemento == null) {
			System.out.print("\n Elemento no encontrado");
		}
		tFin = System.nanoTime();
		
		tiempo = tFin-tInicio;
		System.out.print("Tiempo: "+tiempo);
		System.out.print("Recorridos: "+recorridos);
		System.out.print("Comparaciones: "+comparaciones);
		System.out.println("Intercambios: "+intercambios);
		
	}
	
}//Hash

public class PruebasE {

	public static void main(String[] args) {


	}

}
