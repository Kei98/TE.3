package com.JKL.arbolbinario;

public class NodoArbol {
    int element;
    int fb;
    NodoArbol right;
    NodoArbol left;
    int height;

    public NodoArbol(int element) {
	this.element = element;
	this.right = this.left = null;
	this.height = 1;
    }

}
