
import java.util.Comparator;

class Heap {
    private Paciente[] heap;
    private int capacidad;
    private int tamaño;
    /**
     * Constructs a new heap with the specified capacity.
     *
     * @param capacity The maximum capacity of the heap.
     */
    public Heap(int capacidad) {
        this.capacidad = capacidad;
        this.heap = new Paciente[capacidad];
        this.tamaño = 0;
    }
    /**
     * Inserts a patient into the heap.
     *
     * @param patient The patient to insert.
     */
    public void insertar(Paciente paciente) {
        if (tamaño == capacidad) {
            System.out.println("La cola está llena");
            return;
        }
        heap[tamaño] = paciente;
        OrdenHeap(tamaño);
        tamaño++;
    }
    /**
     * Removes and returns the highest priority patient from the heap.
     *
     * @return The highest priority patient.
     * @throws IllegalStateException if the heap is empty.
     */
    public Paciente Eliminacion() {
        if (tamaño == 0) {
            throw new IllegalStateException("La cola está vacía");
        }
        Paciente pacientePrioritario = heap[0];
        heap[0] = heap[tamaño - 1];
        tamaño--;
        OrdenBajoHeap(0);
        return pacientePrioritario;
    }
   /**
     * Maintains the heap property upward from the specified index.
     *
     * @param index The index from which to start heapifying.
     */
    private void OrdenHeap(int indice) {
        int padre = (indice - 1) / 2;
        while (indice > 0 && comparar(heap[indice], heap[padre]) < 0) {
            SwitchP(indice, padre);
            indice = padre;
            padre = (indice - 1) / 2;
        }
    }
  /**
     * Maintains the heap property downward from the specified index.
     *
     * @param index The index from which to start heapifying.
     */
    private void OrdenBajoHeap(int indice) {
        int hijoIzquierdo = 2 * indice + 1;
        int hijoDerecho = 2 * indice + 2;
        int hijoMenor = indice;

        if (hijoIzquierdo < tamaño && comparar(heap[hijoIzquierdo], heap[hijoMenor]) < 0) {
            hijoMenor = hijoIzquierdo;
        }

        if (hijoDerecho < tamaño && comparar(heap[hijoDerecho], heap[hijoMenor]) < 0) {
            hijoMenor = hijoDerecho;
        }

        if (hijoMenor != indice) {
            SwitchP(indice, hijoMenor);
            OrdenBajoHeap(hijoMenor);
        }
    }
   /**
     * Swaps two elements in the heap.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void SwitchP(int i, int j) {
        Paciente temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    /**
     * Compares two patients based on their priority.
     *
     * @param p1 The first patient.
     * @param p2 The second patient.
     * @return A negative value if p1 has higher priority than p2, zero if they are equal, and a positive value if p2 has higher priority than p1.
     */
    private int comparar(Paciente p1, Paciente p2) {
        return p1.prioridad - p2.prioridad;
    }
}