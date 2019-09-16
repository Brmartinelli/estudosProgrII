package design_patterns.pizza_builder;

public class App {
	public static void main(String[] args) {
		Pizza pizza = Pizza.builder()
				.metade1(MetadeDaPizza1.SALGADA)
				.metade2(MetadeDaPizza2.DOCE)
				.build();
		
		System.out.println(pizza.getMetade1());
		System.out.println(pizza.getMetade2());
		
		Cliente p = new Cliente();
		p.setNome("Rafael Junior").setIdade(22); 
	}
}
