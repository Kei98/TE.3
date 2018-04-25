package com.JKL.arbolbinario;

public class NodoArbol {
    int element;
    int fb;
    NodoArbol right;
    NodoArbol left;

    public NodoArbol(int element) {
	this.element = element;
	this.right = this.left = null;
	this.fb = -1;
    }

}
