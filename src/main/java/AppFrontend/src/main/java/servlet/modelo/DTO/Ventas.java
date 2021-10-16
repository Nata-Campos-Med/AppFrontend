package AppFrontend.src.main.java.servlet.modelo.DTO;

public class Ventas {

	private long codigoVenta;
	private long cedulaCliente;
	private long cedulaUsuario;
	private double valorVenta;
	private double ivaVenta;
	private double totalVenta;

	public long getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(long cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

}
