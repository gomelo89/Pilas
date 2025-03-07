
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

}
