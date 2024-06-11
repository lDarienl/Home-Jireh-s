package controlador;

import dao.VentaDao;
import dao.Cliente;
        
import dto.DtoVenta;
import dto.DtoCliente;
import dto.DtoEmpleado;
import dto.DtoProducto;

import vista.panel_control_vendedor;
import vista.Registro_Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendedorControlador implements ActionListener {
    
    private panel_control_vendedor vista;
    private VentaDao ventaDao;
    private Registro_Ventas registroVentasView;
    private Cliente clienteDao;
    private DtoEmpleado empleadoDto;
    private DtoProducto productoDto;

    public VendedorControlador(panel_control_vendedor vista) {
        this.vista = vista;
        this.ventaDao = new VentaDao();
        this.clienteDao = new Cliente();
        this.empleadoDto = new DtoEmpleado();
        this.productoDto = new DtoProducto();
        this.registroVentasView = new Registro_Ventas();

        this.vista.TButtonAgregarVenta.addActionListener(this);
        this.vista.TButtonModificarVenta.addActionListener(this);
        this.vista.TButtonVerListaVentas.addActionListener(this);
        this.vista.JButtonEliminarDatos.addActionListener(this);
        this.vista.JButtonModificarDatos.addActionListener(this);
        this.vista.JButtonAgregarCliente.addActionListener(this);
        this.registroVentasView.jButton2.addActionListener(this);

        actualizarTablaVentas();
    }

    public void registrarVenta(int idVenta, LocalDate fecha, DtoCliente cliente, ArrayList<DtoProducto> productos, DtoEmpleado vendedor) {
        DtoVenta nuevaVenta = new DtoVenta();
        nuevaVenta.setIdVenta(idVenta);
        nuevaVenta.setFecha(fecha);
        nuevaVenta.setCliente(cliente);
        nuevaVenta.setProductos(productos);
        nuevaVenta.setVendedor(vendedor);
        nuevaVenta.calcularTotal();
        ventaDao.crearVenta(nuevaVenta);
        actualizarTablaVentas();
    }

    public void modificarVenta(DtoVenta venta) {
        ventaDao.modificarVenta(venta);
        actualizarTablaVentas();
    }

    public void eliminarVenta(int idVenta) {
        ventaDao.eliminarVenta(idVenta);
        actualizarTablaVentas();
    }

    public List<DtoVenta> verVentas() {
        return ventaDao.todasLasVentas();
    }

    public List<DtoVenta> buscarVentas(String criterio, String valor) {
        switch (criterio) {
            case "Cliente":
                return buscarVentasPorCliente(valor);
            case "ID":
                return buscarVentasPorId(Integer.parseInt(valor));
            case "Producto":
                return buscarVentasPorProducto(valor);
            case "Fecha":
                return buscarVentasPorFecha(LocalDate.parse(valor));
            case "Vendedor":
                return buscarVentasPorVendedor(valor);
            default:
                return new ArrayList<>();
        }
    }

    public List<DtoVenta> buscarVentasPorCliente(String nombreCliente) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getCliente().getNombre().equalsIgnoreCase(nombreCliente))
                .collect(Collectors.toList());
    }

    public List<DtoVenta> buscarVentasPorId(int idVenta) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getIdVenta() == idVenta)
                .collect(Collectors.toList());
    }

    public List<DtoVenta> buscarVentasPorProducto(String nombreProducto) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getProductos().stream()
                        .anyMatch(producto -> producto.getNombreProducto().equalsIgnoreCase(nombreProducto)))
                .collect(Collectors.toList());
    }

    public List<DtoVenta> buscarVentasPorFecha(LocalDate fecha) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getFecha().isEqual(fecha))
                .collect(Collectors.toList());
    }

    public List<DtoVenta> buscarVentasPorVendedor(String nombreVendedor) {
        return ventaDao.todasLasVentas().stream()
                .filter(venta -> venta.getVendedor().getNombre().equalsIgnoreCase(nombreVendedor))
                .collect(Collectors.toList());
    }

    private void actualizarTablaVentas() {
        List<DtoVenta> ventas = verVentas();
        DefaultTableModel model = (DefaultTableModel) vista.jTable2.getModel();
        model.setRowCount(0);
        for (DtoVenta venta : ventas) {
            Object[] row = new Object[]{
                venta.getIdVenta(),
                venta.getFecha(),
                venta.getCliente().getNombre(),
                venta.getTotal()
            };
            model.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.TButtonAgregarVenta) {
            registroVentasView.setVisible(true); // Mostrar la vista de agregar venta
        } else if (e.getSource() == registroVentasView.jButton2) {
            // Capturar datos de la vista de agregar venta y registrar la venta
            int idVenta = Integer.parseInt(registroVentasView.IdVenta.getText());
            LocalDate fecha = LocalDate.now(); // Suponemos que la fecha es la actual
            int idCliente = (int) registroVentasView.IdCliente.getValue();
            DtoCliente cliente = clienteDao.buscarCliente(idCliente);
            String nombreVendedor = registroVentasView.NombreVendedor.getText();
            String vendedor = empleadoDto.getNombre();
            String productos = productoDto.getDescripcion();

            registrarVenta(idVenta, fecha, cliente, productos, vendedor);
            registroVentasView.dispose(); // Cerrar la vista después de registrar la venta
        } else if (e.getSource() == vista.JButtonEliminarDatos) {
            int selectedRow = vista.jTable2.getSelectedRow();
            if (selectedRow != -1) {
                int idVenta = (int) vista.jTable2.getValueAt(selectedRow, 0);
                eliminarVenta(idVenta);
                JOptionPane.showMessageDialog(vista, "Venta eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "Seleccione una venta para eliminar.");
            }
        } else if (e.getSource() == vista.TextFieldBuscar) {
            String criterio = vista.JComboBoxFiltrar.getSelectedItem().toString();
            String valor = vista.TextFieldBuscar.getText();
            List<DtoVenta> ventas = buscarVentas(criterio, valor);
            actualizarTablaVentas(ventas);
        }
    }

    private void actualizarTablaVentas(List<DtoVenta> ventas) {
        DefaultTableModel model = (DefaultTableModel) vista.jTable2.getModel();
        model.setRowCount(0);
        for (DtoVenta venta : ventas) {
            Object[] row = new Object[]{
                venta.getIdVenta(),
                venta.getFecha(),
                venta.getCliente().getNombre(),
                venta.getTotal()
            };
            model.addRow(row);
        }
    }

    private void registrarVenta(int idVenta, LocalDate fecha, DtoCliente cliente, String productos, String vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
