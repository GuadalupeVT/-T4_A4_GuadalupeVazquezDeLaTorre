

class Vertice {
	private String nombre;
    private int numVertice;
    
    public Vertice() {}
	
    public Vertice(String x){
    	nombre = x;
	    numVertice = -1;
	}
    
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumVertice() {
		return numVertice;
	}

	public void setNumVertice(int numVertice) {
		this.numVertice = numVertice;
	}

	
    public String nomVertice() { // devuelve identificador del vértice
    	return nombre;
    }
    public boolean equals(Vertice n) {// true, si dos vértices son iguales
    	return nombre.equals(n.nombre);
    }
    public void asigVert(int n){ // establece el número de vértices
        numVertice = n;
    }
    public String toString(){ // características del vértice
    	return nombre + " (" + numVertice + ")";
    }
    
    
}//class vetice
public class PruebaGrafos {

	public static void main(String[] args) {
		

	}

}
