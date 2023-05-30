package Modelo;

import java.util.ArrayList;

import Procesamiento.Producto;

public class Pedido{
	
	/*Attributes*/
	
	private int numeroPedido;
	private int id;
	private String Cliente;
	private String Direccion;
	private ArrayList <Producto> ItemsPedido;
	private int precioneto=0;
	private int preciototal=0;
	private int precioiva=0;
	private int calorias=0;
	
	/*Constructor*/
	
	public Pedido(int num,int id,String nombre, String dir,ArrayList<Producto> itemsPedido2,int nu, int no,int ni) {
		
		numeroPedido=num;
		this.id=id;
		Cliente=nombre;
		Direccion=dir;
		this.ItemsPedido= itemsPedido2;
		precioneto=nu;
		preciototal=no;
		precioiva=ni;
		
	}
	
	/*Methods*/
	
	public int getID() {
		
		return id;
		
	}
	
	public ArrayList <Producto> getPedido() {
		
		return ItemsPedido;
		
	}
	public void agregarProducto(Producto nuevoItem) throws PedidoValorSuperiorException {
	    int nuevoValorTotal = precioneto + nuevoItem.getPrecio();
	    if (nuevoValorTotal > 150000) {
	        throw new PedidoValorSuperiorException(nuevoValorTotal);
	    }

	    ItemsPedido.add(nuevoItem);
	    precioneto += nuevoItem.getPrecio();
	    precioiva = (int) (precioneto * 19 / 100);
	    calorias += nuevoItem.getCalorias();
	}

	
	public int getPrecioIvaPedido() {
		
		return precioiva;
	}
	
	
	public ArrayList <String> getItemsString() {
		ArrayList<String> lista1 = new ArrayList<>();
		
		for (int i=0; i<ItemsPedido.size(); i++) {
			
			lista1.add(ItemsPedido.get(i).getNombre());	
			
		}
		
		lista1.sort(null);
		return lista1;
	}
	
	public int getPrecioNetoPedido() {
		
		return precioneto;
	}
	
	public int getPrecioTotalPedido() {
		
		preciototal=precioneto+precioiva;
		
		return preciototal;
	}
	
	public ArrayList<String> generarFacturaImprimir() {
		
		ArrayList<String> infofactura= new ArrayList<>();
		
		String headerTOP= "DPOO BURGIRS";
		String header= "--------------------------------------------------------------";
		String mainid= "ID"+Integer.toString(this.id)+"----"+"Pedido.no."+Integer.toString(this.numeroPedido);
		String cliente= "Cliente:"+Cliente;
		String direc= "Direccion:"+Direccion;
		String separador="-ITEMS------------------------------------------------------";

		
		infofactura.add(headerTOP);infofactura.add(header);infofactura.add(mainid);
		infofactura.add(cliente);infofactura.add(direc);infofactura.add(separador);
		
		
		for (int i=0; i< ItemsPedido.size(); i++) {
			
			String name= ItemsPedido.get(i).getNombre();
			String precioname= Integer.toString (ItemsPedido.get(i).getPrecio());
			infofactura.add(name+"-----------"+precioname );
		}
		
		String precionetofactura= "Precio Neto:"+precioneto;
		String ivafactura="IVA 19%:"+precioiva;
		String total="Total:"+preciototal;
		
		infofactura.add("-COSTO------------------------------------------------------");
		infofactura.add(precionetofactura);
		infofactura.add(ivafactura);
		infofactura.add(total);
		infofactura.add("-CALORIAS---------------------------------------------------");
		infofactura.add(Integer.toString(calorias));
		
		return infofactura;
		
	}


	public void setItemsPedido(ArrayList<Producto> itemsPedido) {
		ItemsPedido = itemsPedido;
	}

	public String guardar() {
		
		String lineafile=id+";"+numeroPedido+";"+Cliente+";"+Direccion+";";
		
	    for (int i=0; i< ItemsPedido.size(); i++) {
			
			String name= ItemsPedido.get(i).getNombre();
			lineafile=lineafile+name+",";
		}
	
		lineafile+=precioneto+";"+precioiva+";"+preciototal;
		
		return lineafile;
		
	}
	

}
