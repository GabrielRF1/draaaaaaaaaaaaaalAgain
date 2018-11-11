package modelo.tabuleiro;

public enum TipoSolo {
	
	
	GRAMA("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/grass_green2y_d.jpg"),
	
	AGUA("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/grass_autumn_n.jpg"),
		
	PONTE("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/desert_mntn_s.jpg"),
		
	MONTANHA("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/mntn_canyon_d.jpg"),
	
	BASE_1("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/ground_ferns_d.jpg"),
	
	BASE_2("/home/leopoldo/Jean/Code/Java/draaaaaaaaaaaaaalAgain/src/main/snow_grass3_d.jpg");
	
	private String imagePath;
	
	TipoSolo(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return this.imagePath;
	}
}
