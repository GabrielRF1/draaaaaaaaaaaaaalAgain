package modelo.tabuleiro;

public enum TipoSolo {
	
	GRAMA("resources/terrain/grass_green_d.jpg"),
	
	/*NEVE("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\snow_grass2_d.jpg"),
	
	AGUA("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\snow_mntn2_n.jpg"),
	
	CHAO_PEDRA("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\grass_ground_h.jpg"),
	
	PONTE("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\mntn_brown_d.jpg"),
	
	AREIA("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\desert_sand_d.jpg"),
	
	MONTANHA("\\home\\leopoldo\\Jean\\Code\\Dral\\resources\\terrain\\mntn_canyon_d.jpg"),*/
	
	BASE_1("resources/terrain/grass_green_d.jpg"),
	
	BASE_2("resources/terrain/grass_green_d.jpg");
	
	private String imagePath;
	
	TipoSolo(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return this.imagePath;
	}
}
