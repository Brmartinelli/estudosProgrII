package design_patterns.pizzas;

public abstract class Cozinha {
	public static Pizza fornoDaPizzaria(TiposDePizza tipoDePizza) {
		switch (tipoDePizza) {
		case DOCE:
			return new ChocolateComMorango();
		case SALGADA:
			return new FrangoComCatupiry();
		case FITNESS:
			return new Brocolos();
		default:
			break;
		}
		return null;
	}
}
