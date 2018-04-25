package com.JKL.arbolbinario;


/**
 * @authors Aykull, Jonathana1196, Kei98 
 *
 */

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
		
		public NodoArbol delete(int element) {
			if(this.root == null) {
				return null;
			} else {
				return delete(element, this.root);
			}
		}
		private NodoArbol delete(int element, NodoArbol current) {
			if(current == null) {
				return current;
			}
			if(current.element > element) {
				current.left = delete(element, current.left);
			} else if(current.element < element) {
				current.right = delete(element, current.right);
			} else if(current.left != null && current.right != null) {
				current.element = findMin(current.right).element;
				element = findMin(current.right).element;
				current.right = delete(element, current.right);
			} else {
				current = current.right != null ? current.right : current.left;
			}
			return current;
		}
   }

