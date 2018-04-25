package com.JKL.arbolbinario;

public class ArbolBinario {
	 NodoArbol root;

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

	    NodoArbol findMin() {
		return findMin(this.root);
	    }

	    private NodoArbol findMin(NodoArbol current) {
		if (current == null) {
		    return null;
		} else if (current.left == null) {
		    System.out.println(current.element);
		    return current;
		} else {
		    return findMin(current.left);
		}
	    }

	    NodoArbol findMax() {
		return findMax(this.root);
	    }

	    public void diferenciaAB(ArbolBinario ab) {
		System.out.println("La diferencia entre nodos es: " + (ab.findMax().element - ab.findMin().element));
	    }

	    private NodoArbol findMax(NodoArbol current) {
		if (current == null) {
		    return null;
		} else if (current.right == null) {
		    System.out.println(current.element);
		    return current;
		} else {
		    return findMax(current.right);
		}
	    }

	    public void insert(int element) {
		this.root = this.insert(element, this.root);
	    }

	    public NodoArbol insert(int element, NodoArbol current) {
		if (current == null) {
		    return new NodoArbol(element);
		} else if (element < current.element) {
		    current.left = this.insert(element, current.left);
		} else if (element > current.element) {
		    current.right = this.insert(element, current.right);
		}
		return current;
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
		
		public void delete(NodoArbol nodo) {
			if(nodo.right == null && nodo.left == null) {
				
			}
		}
   }

