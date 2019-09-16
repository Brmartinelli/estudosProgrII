package design_patterns.pizzas;

public class App {
	
	public static void main(String[] args) {
		
		Pizza pizza = Cozinha.fornoDaPizzaria(TiposDePizza.SALGADA);
		System.out.println(pizza.getTipoDaPizza());
	}	
}
