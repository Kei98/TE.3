package com.JKL.arbolbinario;

import java.util.ArrayList;

/**
 * @authors Aykull, Jonathana1196, Kei98
 *
 */

public class ArbolBinario {
	public NodoArbol root;

	public ArbolBinario() {
		this.root = null;
	}

	boolean contains(int element) {
		return this.contains(element, this.root);
	}

	private boolean contains(int element, NodoArbol current) {
		if (current == null) {
			return false;
		} else if (element < current.element) {
			return contains(element, current.left);
		} else if (element > current.element) {
			return contains(element, current.right);
		} else {
			return true;
		}
	}

	public NodoArbol insertar(int element) {
		return insertar(element, this.root);

	}

	private NodoArbol insertar(int element, NodoArbol current) {
		if (current == null) {
			return new NodoArbol(element);
		}
		if (element < current.element) {
			current.left = this.insertar(element, current.left);
		} else if (element > current.element) {
			current.right = this.insertar(element, current.right);
		} else {
			return current;
		}

		current.height = 1 + Max(Height(current.left), Height(current.right));

		int balance = getFB(current);

		if (balance > 1 && element < current.left.element) {
			return rotacionSimpleDerecha(current);
		}

		if (balance < -1 && element > current.right.element) {
			return rotacionSimpleIzquierda(current);
		}

		if (balance > 1 && element > current.left.element) {
			current.left = current.left;
			return rotacionSimpleDerecha(current);
		}

		if (balance < -1 && element < current.right.element) {
			current.right = rotacionSimpleDerecha(current.right);
			return rotacionSimpleIzquierda(current);
		}

		return current;
	}

	NodoArbol findMin() {
		return findMin(this.root);
	}

	private NodoArbol findMin(NodoArbol current) {
		if (current == null) {
			return null;
		} else if (current.left == null) {
			return current;
		} else {
			return findMin(current.left);
		}
	}

	NodoArbol findMax() {
		return findMax(this.root);
	}

	private NodoArbol findMax(NodoArbol current) {
		if (current == null) {
			return null;
		} else if (current.right == null) {
			return current;
		} else {
			return findMax(current.right);
		}
	}

	public void diferenciaAB(ArbolBinario ab) {
		System.out.println("La diferencia entre nodos es: " + (ab.findMax().element - ab.findMin().element));
	}

	private int getFB(NodoArbol n) {
		if (n == null) {
			return 0;
		} else {
			return (Height(n.left) - Height(n.right));
		}
	}

	private int Height(NodoArbol node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public int Max(int a, int b) {
		return (a > b) ? a : b;
	}

	private NodoArbol rotacionSimpleDerecha(NodoArbol y) {

		NodoArbol b = y.left;
		NodoArbol c = b.right;

		b.right = y;
		y.left = c;

		y.height = Max(Height(y.left), Height(y.right)) + 1;
		b.height = Max(Height(b.left), Height(b.right)) + 1;

		return b;

	}

	private NodoArbol rotacionSimpleIzquierda(NodoArbol x) {

		NodoArbol y = x.right;
		NodoArbol c = y.left;

		y.left = x;
		x.right = c;

		x.height = Max(Height(x.left), Height(x.right)) + 1;
		y.height = Max(Height(y.left), Height(y.right)) + 1;

		return y;
	}

	
	public void PreOrden(NodoArbol root) {
		if (root != null) {
			System.out.println(root.element);
			PreOrden(root.left);
			PreOrden(root.right);
		}
	}

	public void InOrden(NodoArbol root) {
		if (root != null) {
			InOrden(root.left);
			System.out.println(root.element);
			InOrden(root.right);
		}
	}

	public void PostOrden(NodoArbol root) {
		if (root != null) {
			InOrden(root.left);
			InOrden(root.right);
			System.out.println(root.element);
		}
	}
	
	static ArrayList<Integer> al = new ArrayList<>();

	public NodoArbol extrae(NodoArbol root) {
		if (root != null) {
			if(root.left != null && root.right != null) {
				root.right = extrae(root.right);
				al.add(root.element);
				root.left = extrae(root.left);
			}else if(root.left == null && root.right != null) {
				root.right = extrae(root.right);
				al.add(root.element);
				root.left = extrae(root.left);
			}else {
				root.left = extrae(root.left);
				al.add(root.element);
				root.right = extrae(root.right);
			}
			
		}
		return root;
		
	}

	public void mezcla(ArbolBinario a) {
		ArbolBinario sol = new ArbolBinario();
		this.root = extrae(this.root);
		a.root = extrae(a.root);

		for (int i = 0; i < al.size(); i++) {
			sol.insertar(al.get(i));
		}
		sol.PreOrden(sol.root);
	}

	public NodoArbol delete(int element) {
		if (this.root == null) {
			return null;
		} else {
			return delete(element, this.root);
		}
	}

	private NodoArbol delete(int element, NodoArbol current) {
		if (current == null) {
			return current;
		}
		if (current.element > element) {
			current.left = delete(element, current.left);
		} else if (current.element < element) {
			current.right = delete(element, current.right);
		} else if (current.left != null && current.right != null) {
			current.element = findMin(current.right).element;
			element = findMin(current.right).element;
			current.right = delete(element, current.right);
		} else {
			current = current.right != null ? current.right : current.left;
		}
		return current;
	}
}