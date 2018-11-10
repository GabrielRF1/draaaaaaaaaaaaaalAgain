package modelo.tabuleiro;

public enum TipoSolo {
	
	
	GRAMA("/grass_green2y_d.jpg"),
	
	AGUA("/grass_autumn_n.jpg"),
		
	PONTE("/desert_mntn_s.jpg"),
		
	MONTANHA("/mntn_canyon_d.jpg"),
	
	BASE_1("/ground_ferns_d.jpg"),
	
	BASE_2("/snow_grass3_d.jpg");
	
	private String imagePath;
	
	TipoSolo(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return this.imagePath;
	}
}
