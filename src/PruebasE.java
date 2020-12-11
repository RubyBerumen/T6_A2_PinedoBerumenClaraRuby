
class BusquedaBinaria{
	
    public static int busqueda(int[]matriz, int valorBuscado) {
        if(matriz.length==0) {
            return -1;
        }
        int mitad,inferior =0;
        int superior = matriz.length-1;
        do {
            mitad = (int)(inferior + superior) / 2;
            if (valorBuscado > matriz[mitad]) {
            inferior = mitad + 1;
            } else {
            superior = mitad-1;
            }
            } while (matriz[mitad] != valorBuscado && inferior <= superior);

            if (matriz[mitad] == valorBuscado) {
                System.out.println("Encontrado");
                return mitad;

            } else {
                System.out.println("No se encontro");
            return -1;
            }


    }
    
    
}//metodos busqueda

public class PruebasE {

	public static void main(String[] args) {


	}

}
