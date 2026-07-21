package interfaces;

import java.util.List;
import modelos.Pedido;

public interface ICRUDPedido {
    Pedido salvar(Pedido pedido);
    List<Pedido> consultar();
}

