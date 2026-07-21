package modelos;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private LocalDate data;
    private String status;
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(Cliente cliente, LocalDate data,
                  String status, List<Produto> produtos) {
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}