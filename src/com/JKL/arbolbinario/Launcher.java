package com.JKL.arbolbinario;

public class Launcher {
    /**
     * @param args
     */
    public static void main(String[] args) {

	ArbolBinario ab = new ArbolBinario();

	ab.insert(50);

	ab.insert(45);

	ab.insert(48);

	ab.insert(40);

	ab.insert(52);

	ab.insert(51);

	ab.insert(57);

	ab.insert(55);

	ab.insert(60);

	ab.insert(46);

	ab.insert(43);

	ab.insert(38);

	ab.insert(42);

	ab.insert(44);

	ab.insert(39);

	ab.insert(37);

	ab.insert(41);

	ab.insert(34);

	ab.insert(07);

	ab.insert(10);

	ab.insert(9);

	System.out.println("Raíz:");
	System.out.println(ab.root.element);
	System.out.println();
	ab.diferenciaAB(ab);
	System.out.println();
	System.out.println("InOrden:");
	ab.InOrden(ab.root);
	System.out.println();
	System.out.println("PreOrden");
	ab.PreOrden(ab.root);
	System.out.println();
	System.out.println("PostOrden");
	ab.PostOrden(ab.root);

	// Eliminación de una hoja
	ab.delete(46);
	// Eliminación de nodo con 2 hijos
	ab.delete(50);
	ab.delete(45);
	// Eliminación de nodo con 1 hijo
	ab.delete(38);

	System.out.println("");
	ab.diferenciaAB(ab);

	System.out.println();
	System.out.println("Raíz:");
	System.out.println(ab.root.element);

	System.out.println("InOrden:");
	ab.InOrden(ab.root);
	System.out.println();
    }

}
