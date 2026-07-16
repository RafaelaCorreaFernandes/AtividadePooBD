

import java.util.List;
import java.util.Scanner;

import dao.ClienteDao;
import dao.ProdutoDao;
import modelos.Cliente;
import modelos.Produto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProdutoDao produtoDao = new ProdutoDao();
		ClienteDao clienteDao = new ClienteDao();
		int opcao;

		do {
			System.out.println("\n===== MENU =====");
			System.out.println("--- Produtos ---");
			System.out.println("1 - Cadastrar produto");
			System.out.println("--- Clientes ---");
			System.out.println("2 - Cadastrar cliente");
			System.out.println("3 - Consultar cliente por id");
			System.out.println("4 - Listar clientes");
			System.out.println("5 - Alterar cliente");
			System.out.println("6 - Deletar cliente");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // limpar buffer

			switch (opcao) {
			case 1:
				System.out.print("Descrição do produto: ");
				String descricao = sc.nextLine();
				System.out.print("Preço: ");
				double preco = sc.nextDouble();
				sc.nextLine();
				System.out.print("Quantidade em estoque: ");
				int estoque = sc.nextInt();
				sc.nextLine();

				Produto novoProduto = new Produto(descricao, preco, estoque);
				Produto produtoSalvo = produtoDao.salvar(novoProduto);

				if (produtoSalvo != null) {
					System.out.println("Produto cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar produto.");
				}
				break;

			case 2:
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("Rua: ");
				String rua = sc.nextLine();
				System.out.print("Número: ");
				String numero = sc.nextLine();
				System.out.print("Bairro: ");
				String bairro = sc.nextLine();
				System.out.print("CEP: ");
				String cep = sc.nextLine();
				System.out.print("Cidade: ");
				String cidade = sc.nextLine();
				System.out.print("Estado (UF): ");
				String estado = sc.nextLine();

				Cliente novoCliente = new Cliente(cpf, nome, email, rua, numero, bairro, cep, cidade, estado);
				Cliente clienteSalvo = clienteDao.salvar(novoCliente);

				if (clienteSalvo != null) {
					System.out.println("Cliente cadastrado com sucesso!");
				} else {
					System.out.println("Erro ao cadastrar cliente.");
				}
				break;

			case 3:
				System.out.print("Digite o id do cliente: ");
				int idBusca = sc.nextInt();
				sc.nextLine();

				Cliente clienteEncontrado = clienteDao.consultar(idBusca);
				if (clienteEncontrado != null) {
					System.out.println("Id: " + clienteEncontrado.getId());
					System.out.println("Nome: " + clienteEncontrado.getNome());
					System.out.println("CPF: " + clienteEncontrado.getCpf());
					System.out.println("Email: " + clienteEncontrado.getEmail());
					System.out.println("Endereço: " + clienteEncontrado.getRua() + ", " + clienteEncontrado.getNumero()
							+ " - " + clienteEncontrado.getBairro() + " - " + clienteEncontrado.getCidade() + "/"
							+ clienteEncontrado.getEstado());
				} else {
					System.out.println("Cliente não encontrado.");
				}
				break;

			case 4:
				List<Cliente> clientes = clienteDao.consultar();
				if (clientes.isEmpty()) {
					System.out.println("Nenhum cliente cadastrado.");
				} else {
					for (Cliente c : clientes) {
						System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getCpf());
					}
				}
				break;

			case 5:
				System.out.print("Digite o id do cliente que deseja alterar: ");
				int idAlterar = sc.nextInt();
				sc.nextLine();

				Cliente clienteParaAlterar = clienteDao.consultar(idAlterar);
				if (clienteParaAlterar == null) {
					System.out.println("Cliente não encontrado.");
					break;
				}

				System.out.print("Novo CPF (" + clienteParaAlterar.getCpf() + "): ");
				clienteParaAlterar.setCpf(sc.nextLine());
				System.out.print("Novo nome (" + clienteParaAlterar.getNome() + "): ");
				clienteParaAlterar.setNome(sc.nextLine());
				System.out.print("Novo email (" + clienteParaAlterar.getEmail() + "): ");
				clienteParaAlterar.setEmail(sc.nextLine());
				System.out.print("Nova rua (" + clienteParaAlterar.getRua() + "): ");
				clienteParaAlterar.setRua(sc.nextLine());
				System.out.print("Novo número (" + clienteParaAlterar.getNumero() + "): ");
				clienteParaAlterar.setNumero(sc.nextLine());
				System.out.print("Novo bairro (" + clienteParaAlterar.getBairro() + "): ");
				clienteParaAlterar.setBairro(sc.nextLine());
				System.out.print("Novo CEP (" + clienteParaAlterar.getCep() + "): ");
				clienteParaAlterar.setCep(sc.nextLine());
				System.out.print("Nova cidade (" + clienteParaAlterar.getCidade() + "): ");
				clienteParaAlterar.setCidade(sc.nextLine());
				System.out.print("Novo estado (" + clienteParaAlterar.getEstado() + "): ");
				clienteParaAlterar.setEstado(sc.nextLine());

				clienteDao.alterar(clienteParaAlterar);
				break;

			case 6:
				System.out.print("Digite o id do cliente que deseja deletar: ");
				int idDeletar = sc.nextInt();
				sc.nextLine();

				clienteDao.deletar(idDeletar);
				break;

			case 0:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (opcao != 0);

		sc.close();
	}
}