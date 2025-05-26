package com.inventario.project.controlador;

import java.util.ArrayList;

import com.inventario.project.controlador.modelo.Producto;
import com.inventario.project.persitencia.PersistenciaInventario;
import com.inventario.project.vistas.MenuPrincipal;
import com.inventario.project.vistas.MostrarProducto;
import com.inventario.project.vistas.RegistarProducto;

public class Controlador {
	
	PersistenciaInventario persistenciaInventario;
	
	MenuPrincipal menuPrincipal;
	
	MostrarProducto mostrarProducto;
	
	RegistarProducto registarProducto;

	public PersistenciaInventario getPersistenciaInventario() {
		return persistenciaInventario;
	}

	public void setPersistenciaInventario(PersistenciaInventario persistenciaInventario) {
		this.persistenciaInventario = persistenciaInventario;
	}

	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	public MostrarProducto getMostrarProducto() {
		return mostrarProducto;
	}

	public RegistarProducto getRegistarProducto() {
		return registarProducto;
	}

	public void setRegistarProducto(RegistarProducto registarProducto) {
		this.registarProducto = registarProducto;
	}

	public void setMostrarProducto(MostrarProducto mostrarProducto) {
		this.mostrarProducto = mostrarProducto;
	}

	///////////
	public ArrayList<Producto> mostrarProducto(){
		return persistenciaInventario.verInventario();
	}
	
	public void mostrarVentanaConsultaProducto() {
		mostrarProducto.setVisible(true);
	}
	
	public void mostrarVentanaRegistrarProducto() {
		registarProducto.setVisible(true);
	}
	
}
