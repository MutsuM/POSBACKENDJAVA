package com.koleapp.service.impl;

import java.util.ArrayList;
import java.util.List;

public class mainPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] meses= new String[13];
		meses[0]="";//LA BASE DE DATOS RETORNA MESES DEL 1 AL 12, SE DEJA LA POSICIÓN 0  PARA PODER HACER BÚSQUEDAS POR INDICE
		meses[1]="ENERO";
		meses[2]="FEBRERO";
		meses[3]="MARZO";
		meses[4]="ABRIL";
		meses[5]="MAYO";
		meses[6]="JUNIO";
		meses[7]="JULIO";
		meses[8]="AGOSTO";
		meses[9]="SEPTIEMBRE";
		meses[10]="OCTUBRE";
		meses[11]="NOVIEMBRE";
		meses[12]="DICIEMBRE";
		
		Double[] total = new Double[13];
		total[0]=0.0;
		total[1]=0.0;
		total[2]=0.0;
		total[3]=0.0;
		total[4]=0.0;
		total[5]=0.0;
		total[6]=0.0;
		total[7]=0.0;
		total[8]=0.0;
		total[9]=0.0;
		total[10]=0.0;
		total[11]=0.0;
		total[12]=0.0;
		
		
		String[] mesesBuscar= new String[4];
		mesesBuscar[0]="";//LA BASE DE DATOS RETORNA MESES DEL 1 AL 12, SE DEJA LA POSICIÓN 0  PARA PODER HACER BÚSQUEDAS POR INDICE
		mesesBuscar[1]="ENERO";
		mesesBuscar[2]="FEBRERO";
		mesesBuscar[3]="MARZO";
		
		
		ArrayList<String> mesesLista = new ArrayList<>();
		mesesLista.add(" ");
		mesesLista.add("ENERO");
		mesesLista.add("FEBRERO");
		mesesLista.add("MARZO");
		mesesLista.add("ABRIL");
		mesesLista.add("MAYO");
		mesesLista.add("JUNIO");
		mesesLista.add("JULIO");
		mesesLista.add("AGOSTO");
		mesesLista.add("SEPTIEMBRE");
		mesesLista.add("OCTUBRE");
		mesesLista.add("NOVIEMBRE");
		mesesLista.add("DICIEMBRE");
		
		
		
		ArrayList<Double> totalLista = new ArrayList<>();
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		totalLista.add(0.0);
		
		
		String busqueda = "MARZO";
		
		int indice = mesesLista.indexOf(busqueda);
		if (indice != -1) {
			System.out.println("La búsqueda está en el índice " + indice);
			totalLista.set(indice, 500.0);
		} else {
			System.out.println("El elemento no existe");
		}
		
		
		for (int i = 0; i < totalLista.size(); i++) {
			System.out.println("La búsqueda TOTALES " + totalLista.get(i));
			
		}
		
		
		
		
		
		
		
		
		
		

	}

}
