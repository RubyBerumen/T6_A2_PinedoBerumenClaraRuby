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
    	tInicio = System.nanoTime();
    	busqueda(nums,valorB);
		tFin = System.nanoTime();
		
		tiempo = tFin-tInicio;
		System.out.print("Tiempo: "+tiempo);
		System.out.print("Recorridos: "+recorridos);
		System.out.print("Comparaciones: "+comparaciones);
		System.out.println("Intercambios: "+intercambios);
		
    }
    
    
}//BusquedaBinaria

public class PruebasE {

	public static void main(String[] args) {


	}

}
