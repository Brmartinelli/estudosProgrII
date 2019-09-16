package design_patterns.pizza_builder;

public class Pizza {
	public MetadeDaPizza1 metade1; 
	private MetadeDaPizza2 metade2;
	
	public Pizza() {}

	public MetadeDaPizza1 getMetade1() {
		return metade1;
	}

	public void setMetade1(MetadeDaPizza1 metade1) {
		this.metade1 = metade1;
	}

	public MetadeDaPizza2 getMetade2() {
		return metade2;
	}

	public void setMetade2(MetadeDaPizza2 metade2) {
		this.metade2 = metade2;
	}
	public static PizzaBuilder builder() {
		return new PizzaBuilder();
	}
	
	static class PizzaBuilder {
		private MetadeDaPizza1 metade1;
		private MetadeDaPizza2 metade2;

		public PizzaBuilder metade1(MetadeDaPizza1 metade1) {
			this.metade1 = metade1;
			return this;
		}

		public PizzaBuilder metade2(MetadeDaPizza2 metade2) {
			this.metade2 = metade2;
			return this;
		}

		public Pizza build() {
			Pizza novo = new Pizza();
			if (this.metade1 != null) {
				novo.metade1 = this.metade1;
			}
			if (this.metade2 != null) {
				novo.metade2 = this.metade2;
			}
			return novo;
		}
		
	}
}
