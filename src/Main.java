import java.util.List;
import java.util.Scanner;

import dao.ProdutoDao;
import modelos.Produto;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProdutoDao dao = new ProdutoDao();
		int opcao;
		
		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1 - Cadastrar produto");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine(); // LIMPAR

			switch (opcao) {
				case 1:
					System.out.print("Descrição do produto: ");
					String descricao = sc.nextLine();
					System.out.print("Preço: ");
					double preco = sc.nextDouble();
					sc.nextLine();

					Produto novoProduto = new Produto(descricao, preco);
					Produto salvo = dao.salvar(novoProduto);

					if (salvo != null) {
						System.out.println("Produto cadastrado com sucesso!");
					} else {
						System.out.println("Erro ao cadastrar produto.");
					}
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
