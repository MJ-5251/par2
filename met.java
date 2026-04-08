import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class met {
    public Stack<ObjDato> llenarPila(Stack<ObjDato> p, Scanner sc) {
    Stack<ObjDato> pila = new Stack<>();
    System.out.println("Ingrese la cantidad de elementos: ");
    int n = sc.nextInt();
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = new ObjDato();
        System.out.println("Ingrese el nombre: ");
        o.setNombre(sc.next());
        System.out.println("Ingrese la edad: ");
        o.setEdad(sc.nextInt());
        p.push(o);
    }
    return p;
}
public void mostrarPila(Stack<ObjDato> p) {
    for (ObjDato o : p) {
        System.out.println("Nombre: " + o.getNombre() + " Edad: " + o.getEdad());
    }
}
public Queue<ObjDato> llenarCola(Queue<ObjDato> c, Scanner sc) {
    Queue<ObjDato> cola = new LinkedList<>();
    System.out.println("Ingrese la cantidad de elementos: ");
    int n = sc.nextInt();
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = new ObjDato();
        System.out.println("Ingrese el nombre: ");
        o.setNombre(sc.next());
        System.out.println("Ingrese la edad: ");
        o.setEdad(sc.nextInt());
        c.offer(o);
    }
    return c;
}
    public void mostrarCola(Queue<ObjDato> c) {
    for (ObjDato o : c) {
        System.out.println("Nombre: " + o.getNombre() + " Edad: " + o.getEdad());
    }
}
//Recorrer una pila de objetos con pop() y modificar un atributo:
    public void actualizarEdad(Stack<ObjDato> p) {
    int n = p.size();
    Stack<ObjDato> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = p.pop();
        if (o.getEdad() < 18) {
            o.setEdad(18);        // modifica el objeto directamente
        }
        aux.push(o);
    }
    for (int i = 0; i < n; i = i + 1) {
        p.push(aux.pop());
    }
}
//Pasar de pila de objetos a cola de objetos:
    public Queue<ObjDato> pilaACola(Stack<ObjDato> p) {
    Queue<ObjDato> cola = new LinkedList<>();
    int n = p.size();
    Stack<ObjDato> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        aux.push(p.pop());
    }
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = aux.pop();
        cola.offer(o);
        p.push(o);
    }
    return cola;
}
//Buscar un objeto en la pila por un atributo:
    public void buscarPorNombre(Stack<ObjDato> p, Scanner sc) {
    System.out.println("Ingrese el nombre a buscar: ");
    String buscar = sc.next();
    int n = p.size();
    int posicion = -1;
    int pos = 1;
    Stack<ObjDato> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = p.pop();
        if (o.getNombre().equalsIgnoreCase(buscar)) {
            posicion = pos;
        }
        aux.push(o);
        pos = pos + 1;
    }
    for (int i = 0; i < n; i = i + 1) {
        p.push(aux.pop());
    }
    if (posicion != -1) {
        System.out.println("Encontrado en la posicion: " + posicion);
    } else {
        System.out.println("No encontrado.");
    }
}

// Forma segura de sacar elementos:
//if (!pila.isEmpty()) {
//    int elemento = pila.pop();
//}

//Eliminar un elemento de una Pila:
//Como la pila no tiene acceso directo por índice, se usa la auxiliar para buscar y eliminar:
    public Stack<Integer> eliminarDePila(Stack<Integer> p, Scanner sc) {
    System.out.println("Ingrese el numero a eliminar: ");
    int eliminar = sc.nextInt();
    int n = p.size();
    Stack<Integer> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        int elemento = p.pop();
        if (elemento != eliminar) {
            aux.push(elemento);   // solo guarda los que NO son el buscado
        }
    }
    int nuevoTam = aux.size();
    for (int i = 0; i < nuevoTam; i = i + 1) {
        p.push(aux.pop());
    }
    return p;
}

//Modificar un elemento de una Pila:
    public Stack<Integer> modificarEnPila(Stack<Integer> p, Scanner sc) {
    System.out.println("Ingrese el numero a modificar: ");
    int buscar = sc.nextInt();
    System.out.println("Ingrese el nuevo valor: ");
    int nuevoValor = sc.nextInt();
    int n = p.size();
    Stack<Integer> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        int elemento = p.pop();
        if (elemento == buscar) {
            aux.push(nuevoValor);  // reemplaza por el nuevo valor
        } else {
            aux.push(elemento);
        }
    }
    for (int i = 0; i < n; i = i + 1) {
        p.push(aux.pop());
    }
    return p;
}

//Eliminar un elemento de una Cola:
    public Queue<Integer> eliminarDeCola(Queue<Integer> c, Scanner sc) {
    System.out.println("Ingrese el numero a eliminar: ");
    int eliminar = sc.nextInt();
    int n = c.size();
    for (int i = 0; i < n; i = i + 1) {
        int elemento = c.poll();
        if (elemento != eliminar) {
            c.offer(elemento);    // vuelve a encolar los que NO son el buscado
        }
    }
    return c;
}
//La cola es más sencilla porque puedes sacar del frente y volver a meter al final en el mismo recorrido.

//Modificar un elemento de una Cola:
    public Queue<Integer> modificarEnCola(Queue<Integer> c, Scanner sc) {
    System.out.println("Ingrese el numero a modificar: ");
    int buscar = sc.nextInt();
    System.out.println("Ingrese el nuevo valor: ");
    int nuevoValor = sc.nextInt();
    int n = c.size();
    for (int i = 0; i < n; i = i + 1) {
        int elemento = c.poll();
        if (elemento == buscar) {
            c.offer(nuevoValor);  // encola el nuevo valor
        } else {
            c.offer(elemento);
        }
    }
    return c;
}

//Con objetos (ObjDato) la lógica es la misma, solo que comparas con getters:
    public Stack<ObjDato> eliminarDePilaobj(Stack<ObjDato> p, Scanner sc) {
    System.out.println("Ingrese el nombre a eliminar: ");
    String eliminar = sc.next();
    int n = p.size();
    Stack<ObjDato> aux = new Stack<>();
    for (int i = 0; i < n; i = i + 1) {
        ObjDato o = p.pop();
        if (!o.getNombre().equalsIgnoreCase(eliminar)) {
            aux.push(o);
        }
    }
    int nuevoTam = aux.size();
    for (int i = 0; i < nuevoTam; i = i + 1) {
        p.push(aux.pop());
    }
    return p;
}

}
