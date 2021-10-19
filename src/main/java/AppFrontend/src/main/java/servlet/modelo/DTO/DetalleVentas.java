package AppFrontend.src.main.java.servlet.modelo.DTO;

public class DetalleVentas {

	private long codigoDetalleVenta;
	private Integer cantidadProducto;
	private String descripcionProducto; // temporal
	private Long codigoProducto;
	private Long codigoVenta;
	private double valorTotal;
	private double valorVenta;
	private double valorIva;
	private double precioProducto; // temporal
	public long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}
	public void setCodigoDetalleVenta(long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}
	public Integer getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public Long getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorVenta() {
		return valorVenta;
	}
	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	public double getValorIva() {
		return valorIva;
	}
	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	
}
