package com.JKL.arbolbinario;

public class Launcher {
    /**
     * @param args
     */
    public static void main(String[] args) {

	 ArbolBinario ab = new ArbolBinario();
	
	 ab.root = ab.insertar(50);
	
	 ab.root = ab.insertar(45);
	
	 ab.root = ab.insertar(48);
	
	 ab.root = ab.insertar(40);
	
	 ab.root = ab.insertar(42);
	
	 ab.root = ab.insertar(44);
	
	 ab.root = ab.insertar(39);
	
	 ab.root = ab.insertar(37);
	
	 ab.root = ab.insertar(41);
	
	 ab.root = ab.insertar(34);
	
	 ab.root = ab.insertar(07);
	
	 ab.root = ab.insertar(10);
	
	 ab.root = ab.insertar(9);
	
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
	
//	 Eliminación de una hoja
	 ab.delete(10);
//	 Eliminación de nodo con 2 hijos
	 ab.delete(42);
	 ab.delete(34);
//	 Eliminación de nodo con 1 hijo
	 ab.delete(50);
	
	 System.out.println("");
	 ab.diferenciaAB(ab);
	
	 System.out.println();
	 System.out.println("Raíz:");
	 System.out.println(ab.root.element);
	
	 System.out.println();
	 System.out.println("InOrden:");
	 ab.InOrden(ab.root);
	 System.out.println();

	 ArbolBinario ab2 = new ArbolBinario();



	 ab2.root = ab2.insertar(2);
	 ab2.root = ab2.insertar(6);
	 ab2.root = ab2.insertar(1);


	 System.out.println();
	 ab2.InOrden(ab2.root);
	 System.out.println();
	 ab2.PostOrden(ab2.root);
	

	// a1.mezcla(a2);
	 
	 ab.mezcla(ab2);
    }

}
