import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    void testInsertar() {
        Heap heap = new Heap(5);
        Paciente p1 = new Paciente("Juan", "Lesión", 'C');
        Paciente p2 = new Paciente("María", "Fiebre", 'A');
        heap.insertar(p1);
        heap.insertar(p2);
        assertEquals(2, heap.tamaño);
    }

    @Test
    void testEliminacion() {
        Heap heap = new Heap(5);
        Paciente p1 = new Paciente("Juan", "Lesión", 'C');
        Paciente p2 = new Paciente("María", "Fiebre", 'A');
        heap.insertar(p1);
        heap.insertar(p2);
        Paciente pacienteEliminado = heap.Eliminacion();
        assertEquals("María", pacienteEliminado.nombre);
        assertEquals(1, heap.tamaño);
    }

    @Test
    void testOrdenHeap() {
        Heap heap = new Heap(5);
        Paciente p1 = new Paciente("Juan", "Lesión", 'C');
        Paciente p2 = new Paciente("María", "Fiebre", 'A');
        Paciente p3 = new Paciente("Pedro", "Dolor de cabeza", 'B');
        heap.insertar(p1);
        heap.insertar(p2);
        heap.insertar(p3);
        assertEquals("María", heap.heap[0].nombre);
    }

    @Test
    void testOrdenBajoHeap() {
        Heap heap = new Heap(5);
        Paciente p1 = new Paciente("Juan", "Lesión", 'C');
        Paciente p2 = new Paciente("María", "Fiebre", 'A');
        Paciente p3 = new Paciente("Pedro", "Dolor de cabeza", 'B');
        heap.insertar(p1);
        heap.insertar(p2);
        heap.insertar(p3);
        heap.Eliminacion(); // Eliminar paciente de mayor prioridad
        assertEquals("Pedro", heap.heap[0].nombre);
    }

    @Test
    void testComparar() {
        Heap heap = new Heap(5);
        Paciente p1 = new Paciente("Juan", "Lesión", 'C');
        Paciente p2 = new Paciente("María", "Fiebre", 'A');
        assertTrue(heap.comparar(p1, p2) > 0);
    }
}