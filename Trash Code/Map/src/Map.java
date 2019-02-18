
public class Map {
	public boolean grille[][] = new boolean[150][150];
	public String Blocks[][] = new String[150][150];
	private int x=0, y=0, tailleX=0, tailleY=0;
	
	public Map() {
		for(int i=0; i<150; i++) { //Si on change i de 200 à 500 par exemple ça change le résultat à la fin
			for(int j=0; j<150; j++) {
				this.grille[i][j] = false;
			}
		}
		for(int i=0; i<500; i++) {
			this.generate();
		}
		this.scanBlock();
	}
	
	
	public void generate() {
		this.x = 10 + (int)(Math.random() * ((140 - 10) + 1));
		this.y = 10 + (int)(Math.random() * ((140 - 10) + 1));
		this.tailleX = 3 + (int)(Math.random() * ((8 - 3) + 1));
		this.tailleY = 3 + (int)(Math.random() * ((8 - 3) + 1));
		
		int test = 0;
		for(int i=this.y-this.tailleY; i<=this.y+this.tailleY; i++) {
			for(int j=this.x-this.tailleX; j<=this.x+this.tailleX; j++) {
				if(this.grille[i][j] == true) {
					test++;
				}
			}
		}
		
		if(test <= 50) {
			for(int i=this.y-this.tailleY; i<=this.y+this.tailleY; i++) {
				for(int j=this.x-this.tailleX; j<=this.x+this.tailleX; j++) {
					this.grille[i][j] = true;
				}
			}
		}
	}
	
	
	public void scanBlock() {
		
	}
}