package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICRUDPedido;
import modelos.Pedido;
import modelos.Produto;
import utils.ConectaDB;

public class PedidoDao implements ICRUDPedido {

    @Override
    public Pedido salvar(Pedido pedido) {
        String sqlPedido = "INSERT INTO tb_pedidos(cliente_id, data, status) VALUES(?,?,?)";
        String sqlItem = "INSERT INTO tb_pedido_produtos(pedido_id, produto_id) VALUES(?,?)";

        Connection con = ConectaDB.conectar();

        try {
            PreparedStatement stmPedido = con.prepareStatement(sqlPedido,
                    Statement.RETURN_GENERATED_KEYS);

            stmPedido.setInt(1, pedido.getCliente().getId());
            stmPedido.setDate(2, Date.valueOf(pedido.getData()));
            stmPedido.setString(3, pedido.getStatus());
            stmPedido.executeUpdate();

            ResultSet rs = stmPedido.getGeneratedKeys();
            int pedidoId = 0;

            if (rs.next()) {
                pedidoId = rs.getInt(1);
            }

            PreparedStatement stmItem = con.prepareStatement(sqlItem);

            for (Produto p : pedido.getProdutos()) {
                stmItem.setInt(1, pedidoId);
                stmItem.setInt(2, p.getId());
                stmItem.executeUpdate();
            }

            stmItem.close();
            stmPedido.close();
            con.close();

            pedido.setId(pedidoId);
            return pedido;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pedido> consultar() {
        return new ArrayList<>();
    }
}