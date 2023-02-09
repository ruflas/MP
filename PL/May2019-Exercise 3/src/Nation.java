public class Nation {
	private String name; // name of the nation
	private String capital; // capital of the nation
	private int population; // total population of the nation
	
	// Constructor
	public Nation(String name, String capital, int population) {
		this.name = name;
		this.capital = capital;
		this.population = population;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "Nation [name=" + name + ", capital=" + capital + ", population=" + population + "]";
	}	
}
