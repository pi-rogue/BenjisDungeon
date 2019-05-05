
public class Chestplate extends Armor {
	
	public Chestplate(double health, double health_level,int level)
	{
		this.health=health+(health_level*level);
		this.health_level=health_level;
		this.level=level;
		
	}

}
