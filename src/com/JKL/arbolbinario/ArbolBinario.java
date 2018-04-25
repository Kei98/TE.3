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

    public int getFB(NodoArbol n) {
	if (n == null) {
	    return -1;
	} else {
	    return n.fb;
	}
    }

    public NodoArbol rotacionSimpleIzquierda(NodoArbol n) {
	NodoArbol n1 = n.left;
	n.left = n1.right;
	n1.right = n;
	n.fb = Math.max(getFB(n.left), getFB(n.right)) + 1;
	n1.fb = Math.max(getFB(n1.left), getFB(n1.right)) + 1;
	return n1;

    }

    public NodoArbol rotacionSimpleDerecha(NodoArbol n) {
	NodoArbol n1 = n.right;
	n.right = n1.left;
	n1.left = n;
	n.fb = Math.max(getFB(n.left), getFB(n.right)) + 1;
	n1.fb = Math.max(getFB(n1.left), getFB(n1.right)) + 1;
	return n1;

    }

    public NodoArbol rotacionDobleIzquierdaDerecha(NodoArbol n2) {
	NodoArbol n3;
	n2.left = rotacionSimpleDerecha(n2.left);
	n3 = rotacionSimpleIzquierda(n2);
	return n3;
    }

    public NodoArbol rotacionDobleDerecha(NodoArbol n2) {
	NodoArbol n3;
	n2.right = rotacionSimpleIzquierda(n2.right);
	n3 = rotacionSimpleDerecha(n2);
	return n3;

    }

    // public void insert(int element) {
    // this.root = this.insert(element, this.root);
    // }
    //
    // public NodoArbol insert(int element, NodoArbol current) {
    // if (current == null) {
    // return new NodoArbol(element);
    // } else if (element < current.element) {
    // current.left = this.insert(element, current.left);
    // } else if (element > current.element) {
    // current.right = this.insert(element, current.right);
    // }
    // return current;
    // }

    public void insert(int element) {
	NodoArbol nuevo = new NodoArbol(element);

	if (root == null) {
	    root = nuevo;
	} else {
	    root = insertAVL(nuevo, root);
	}
    }

    public NodoArbol insertAVL(NodoArbol nuevo, NodoArbol current) {
	NodoArbol raizPadre = current;
	if (nuevo.element < current.element) {
	    if (current.left == null) {
		current.left = nuevo;
	    } else {
		current.left = insertAVL(nuevo, current.left);
		if ((getFB(current.left)) - (getFB(current.right)) == 2) {
		    if (nuevo.element < current.left.element) {
			raizPadre = rotacionSimpleIzquierda(current);
		    } else {
			raizPadre = rotacionDobleIzquierdaDerecha(current);
		    }
		}
	    }
	} else if (nuevo.element > current.element) {
	    if (current.right == null) {
		current.right = nuevo;
	    } else {
		current.right = insertAVL(nuevo, current.right);
		if ((getFB(current.right)) - (getFB(current.left)) == 2) {
		    if (nuevo.element > current.element) {
			raizPadre = rotacionDobleDerecha(current);
		    } else {
			raizPadre = rotacionDobleDerecha(current);
		    }
		}
	    }
	} else {
	    System.out.println("Elemento duplicado.");
	}
	if ((current.left == null) && (current.right != null)) {
	    current.fb = current.right.fb + 1;
	} else if ((current.right == null) && (current.left != null)) {
	    current.fb = current.left.fb + 1;
	} else {
	    current.fb = Math.max((getFB(current.left)), (getFB(current.right))) + 1;
	}
	return raizPadre;
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
