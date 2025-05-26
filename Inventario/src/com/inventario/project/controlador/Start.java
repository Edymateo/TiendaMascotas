package com.inventario.project.controlador;

import java.awt.Menu;

import com.inventario.project.persitencia.PersistenciaInventario;
import com.inventario.project.vistas.MenuPrincipal;
import com.inventario.project.vistas.MostrarProducto;
import com.inventario.project.vistas.RegistarProducto;

public class Start {
	
    PersistenciaInventario persistenciaInventario;
	
	MenuPrincipal menuPrincipal;
	
	MostrarProducto mostrarProducto;
	
	RegistarProducto registarProducto;
	
    Controlador controlador;
	
	
	public static void main(String[] args) {
		Start miPrincipal=new Start();
		miPrincipal.inicio();
	}
	
	public void inicio() {
		menuPrincipal = new MenuPrincipal();
		mostrarProducto = new MostrarProducto();
		persistenciaInventario =  new PersistenciaInventario();
		registarProducto = new RegistarProducto();
		controlador = new Controlador();
		menuPrincipal.setControlador(controlador);
		persistenciaInventario.setControlador(controlador);
		mostrarProducto.setControlador(controlador);
		controlador.setMenuPrincipal(menuPrincipal);
		controlador.setMostrarProducto(mostrarProducto);
		controlador.setPersistenciaInventario(persistenciaInventario);
		controlador.setRegistarProducto(registarProducto);
		registarProducto.setControlador(controlador);
		menuPrincipal.setVisible(true);
		
	}
}
