

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


class GrafoMatriz{
    int numVerts;
    static int maxVerts;
    Vertice [] verts;
    int [][] matAd;
    
    public GrafoMatriz(){
    	this(maxVerts);
    }
    public GrafoMatriz(int mx){
    	maxVerts=mx;
        matAd = new int [mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++)
        	for (int j = 0; i < mx; i++)
        		matAd[i][j] = 0;
        numVerts = 0;
    }
    
    public int numVertice(String vs) {
         Vertice v = new Vertice(vs);
         boolean encontrado = false;
         int i = 0;
         for (; (i < numVerts) && !encontrado;){
        	 encontrado = verts[i].equals(v);
        	 if (!encontrado) 
        		 i++ ;
        	 }
         return (i < numVerts) ? i : -1 ;
    }
    
    public void nuevoVertice (String nom){
    	boolean esta = numVertice(nom) >= 0;
    	if (!esta){
    		Vertice v = new Vertice(nom);
    		v.asigVert(numVerts);
    		verts[numVerts++] = v;
    	}
    }
    
    public void nuevoArco(String a, String b)throws Exception{
    	int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
        matAd[va][vb] = 1;
    }
    
    public boolean adyacente(String a, String b)throws Exception{
    	int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");
        return matAd[va][vb] == 1;
    }
    
    public static int[]recorrerAnchura(GrafoMatriz g, String org) throws Exception{
    	int w, v;
        int [] m;
     
        v = g.numVertice(org);
        
        int CLAVE =-1;
        if (v < 0) throw new Exception("Vértice origen no existe");
        
        ColaLista cola = new ColaLista();
        m = new int[g.numVerts];
        // inicializa los vértices como no marcados
        for (int i = 0; i < g.numVerts; i++)
        m[i] = CLAVE;
        m[v] = 0; // vértice origen queda marcado
        cola.insertar(new Integer(v));
        while (! cola.colaVacia()){
        	Integer cw;
        	cw = (Integer) cola.quitar();
        	w = cw.intValue();
        	System.out.println("Vértice " + g.verts[w] + "visitado");
        	// inserta en la cola los adyacentes de w no marcados
        	for (int u = 0; u < g.numVerts; u++)
        	if ((g.matAd[w][u] == 1) && (m[u] == CLAVE))
        	{
        	// se marca vertice u con número de arcos hasta el
        	m[u] = m[w] + 1;
        	cola.insertar(new Integer(u));
        	}
        }
        return m;
        }
    
    /*static public int[] recorrerProf(GrafoAdcia g, String org) throws Exception {
    	int CLAVE =-1;
    	int v, w;
        PilaLista pila = new PilaLista();
        int [] m;
        m = new int[g.numVerts];
        // inicializa los vértices como no marcados
        v = g.numVertice(org);
        if (v < 0) throw new Exception("Vértice origen no existe");
        for (int i = 0; i < g.numVerts; i++)
        	m[i] = CLAVE;
        m[v] = 0; // vértice origen queda marcado
        pila.insertar(new Integer(v));
        while (!pila.pilaVacia()){
        	Integer cw;
        	cw = (Integer) pila.quitar();
        	w = cw.intValue();
        	System.out.println("Vértice" + g.tablAdc[w] + "visitado");
        	// inserta en la pila los adyacentes de w no marcados
        	// recorre la lista con un iterador
        	ListaIterador list = new ListaIterador(g.tablAdc[w].lad);
        	Arco ck;
        	do{
        		int k;
        		ck = (Arco) list.siguiente();
        		if (ck != null){
        			k = ck.getDestino(); // vértice adyacente
        			if (m[k] == CLAVE){
        				pila.insertar(new Integer(k));
        				m[k] = 1; // vértice queda marcado
        			}
        	    }
        	} while (ck != null);
        }
        return m;
        }   */
} //Class GrafoMatriz

class Nodo {
	Object elemento;
	Nodo siguiente;
	public Nodo(Object x){
		elemento = x;
		siguiente = null;
		}
	int dato;
	public Nodo(int x){
		dato = x;
	    siguiente = null;
	}
	public Nodo(int x, Nodo n){
	    dato = x;
	    siguiente = n;
	}
	public int getDato(){
	    return dato;
	}
	public Nodo getEnlace(){
	    return siguiente;
	}
	public void setEnlace(Nodo enlace){
	    this.siguiente = enlace;
	}
}//Class nodo

class ColaLista { 
	protected Nodo frente;
	protected Nodo fin;
// constructor: crea cola vacía
	public ColaLista(){
		frente = fin = null;
	}
// insertar: pone elemento por el final
    public void insertar(Object elemento){
    	Nodo a;
        a = new Nodo(elemento);
        if (colaVacia()){
        	frente = a;
        	}else{
        		fin.siguiente = a;
        	}
        fin = a;
}
// quitar: sale el elemento frente
    public Object quitar() throws Exception{
    	Object aux;
    	if (!colaVacia()){
    		aux = frente.elemento;
    		frente = frente.siguiente;
    	}else
    		throw new Exception("Eliminar de una cola vacía");
    	return aux;
    }
 // libera todos los nodos de la cola
    public void borrarCola(){
    	for (; frente != null;){
    		frente = frente.siguiente;
        }
    	System.gc();
    }
 // acceso al primero de la cola
    public Object frenteCola() throws Exception{
    	if (colaVacia()){
    		throw new Exception("Error: cola vacía");
        }
    	return (frente.elemento);
    }
 // verificación del estado de la cola
    public boolean colaVacia(){
    	return (frente == null);
    	}
}//class ColaLista
public class PruebaGrafos {

	public static void main(String[] args) {
		

	}

}
