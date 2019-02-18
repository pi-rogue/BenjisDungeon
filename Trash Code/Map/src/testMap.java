import java.io.*;

public class testMap {
	public static void main(String args[]) throws FileNotFoundException {
		Map map1 = new Map();
		File file = new File("src/Map.txt");
		PrintWriter writer = new PrintWriter(file);
		int cpt = 0;
		
		for(int i=0; i<150; i++) {
			for(int j=0; j<150; j++) {
				if(map1.grille[i][j] == true) {
					writer.print("OOO");
				}
				else {
					writer.print("___");
				}
			}
			writer.print("...\n");
			cpt++;
		}
		
		
		Map map[] = new Map[1000000];
		for(int i=0; i<10; i++) {
			map[i] = new Map();
		}
		System.out.println("Gotta go fast !!!");
	}
}
