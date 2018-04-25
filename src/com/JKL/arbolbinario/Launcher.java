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

	System.out.println();
	ab.diferenciaAB(ab);
	System.out.println();
	ab.InOrden(ab.root);
	System.out.println();
	ab.PreOrden(ab.root);
	System.out.println();
	ab.PostOrden(ab.root);

    }

}
