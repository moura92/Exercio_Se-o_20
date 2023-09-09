package entidade;

import java.util.List;
import java.util.function.Predicate;

public class ProdutoSoma {

	public double soma(List<Produto> lista, Predicate<Produto> criterio) {
		double soma = 0.0;
		for (Produto p : lista) {
			if (criterio.test(p)) {
				soma += p.getSalario();
			}
		}
		return soma;
	}
}
