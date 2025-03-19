
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Metodos {

    public Stack<Vehiculo> LlenarPila() {
        Scanner sc = new Scanner(System.in);
        Stack<Vehiculo> pila = new Stack<>();
        boolean bandera = true;
        int opt = 0;

        while (bandera) {
            Vehiculo o = new Vehiculo();
            o.setMarca(JOptionPane.showInputDialog("ingrese la marca del vehiculo"));
            o.setColor(JOptionPane.showInputDialog("ingrese el color del vehiculo"));
            o.setPrecio(Integer.parseInt(JOptionPane.showInputDialog("ingrese el color de vehiculo")));
            pila.push(o);
            System.out.println("desea agregar mas registros; 1: si, 2: no");
            while (!sc.hasNextInt()) {
                System.out.println("esto no es confama dato numerico");
                sc.next();
            }
            opt = sc.nextInt();
            while (opt < 0 && opt > 2) {
                System.out.println("ingrese un dato entre 1 y 2");
                opt = sc.nextInt();
            }
            if (opt == 2) {
                bandera = false;
            }
        

        }

        return pila;

    }

    public void MostrarPila(Stack<Vehiculo> pila) {
        for (Vehiculo o : pila) {
            System.out.println(o.getMarca());
            System.out.println(o.getColor());
            System.out.println(o.getPrecio());

        }
    }
// EJERCICIO DE REPUESTOS;

public Stack<ObjRepuestos> IngresarRepuesto() {
        Scanner sc = new Scanner(System.in);
        Stack<ObjRepuestos> pila = new Stack<>();
        boolean bandera = true;
        int opt = 0;

        while (bandera) {
            ObjRepuestos o = new ObjRepuestos();
            System.out.println("ingrese el nombre del repuesto");
            o.setNombre(sc.next);
            System.out.println("ingrese la marca del repuesto");
            o.setMarca(sc.next);
            System.out.println("ingrese la referencia");
            o.setReferencia(sc.nextInt);
            System.out.println("ingrese el precio");
            o.setPrecio(sc.nextInt);
            System.out.println("ingrese la cantidad");
            o.setCantidad(sc.nextInt);
            // validar si existe
            boolean encontrado = false;
            for (ObjRepuestos repuesto : pila) {
                if(repuesto.getReferencia() == o.getReferencia()){
                    repuesto.setCantidad(repuesto.getCantidad() + o.getCantidad());
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                pila.push(o);
            }

            System.out.println("desea agregar mas registros; 1: si, 2: no");
            while (!sc.hasNextInt()) {
                System.out.println("¡¡ERROR!! ingrese un dato numerico");
                sc.next();
            }
            opt = sc.nextInt();
            while (opt < 0 && opt > 2) {
                System.out.println("ingrese un dato entre 1 y 2");
                opt = sc.nextInt();
            }
            if (opt == 2) {
                bandera = false;
            }
            

        }

        return pila;

    }

    public void MostrarInventario(Stack<ObjRepuestos> pila) {
        for (ObjRepuestos o : pila) {
            System.out.println(o.getNombre());
            System.out.println(o.getMarca());
            System.out.println(o.getReferencia());
            System.out.println(o.getPrecio());
            System.out.println(o.getCantidad());

        }
    }

    public Stack<ObjRepuestos> VenderRepuesto(Stack<ObjRepuestos> pila){
        boolean opcion = true;
        while(opcion){
            System.out.println("Ingrese la referencia del repuesto que desea comprar:");
            int referencia = sc.nextInt();

            ObjRepuestos repuesto_venta = null;
            for (ObjRepuestos repuesto : pila) {
                if (repuesto.getReferencia() == referencia) {
                    repuesto_venta = repuesto;
                    break;
                }
            }

            if (repuesto_venta != null) {
                System.out.println("Repuesto Existente:");
                System.out.println("Nombre: " + repuesto_venta.getNombre());
                System.out.println("Marca: " + repuesto_venta.getMarca());
                System.out.println("Precio: " + repuesto_venta.getPrecio());

                System.out.println("Ingrese la cantidad de venta:");
                int cantidad_Deseada = sc.nextInt();

                if (cantidad_Deseada <= repuesto_venta.getCantidad()) {
                    repuesto_venta.setCantidad(repuesto_venta.getCantidad() - cantidad_Deseada); //actualizo el stock
                    System.out.println("Venta exitosa. Ha comprado " + repuesto_venta.getNombre());
                    System.out.println(cantidad_Deseada + "unidad/es");
                } else {
                    System.out.println("No hay suficiente stock (hay " + repuesto_venta.getCantidad() + " unidades disponibles");
                }
            } else {
                System.out.println("No se encontró un repuesto con esa referencia.");
            }
            System.out.println("desea comprar otro producto 1. si, 2. no");
            int opt=sc.nextInt();
            if(opt == 2){
                opcion = false
            }
            
        }


    }

    public void MostrarInventarioActualizado(Stack<ObjRepuestos> pila) {
        for (ObjRepuestos repuesto : pila) {
            System.out.println(repuesto.getNombre());
            System.out.println(repuesto.getMarca());
            System.out.println(repuesto.getReferencia());
            System.out.println(repuesto.getPrecio());
            System.out.println(repuesto.getCantidad());

        }
    }

    
}
