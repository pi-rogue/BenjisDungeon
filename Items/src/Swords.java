public class Swords extends Items{
	
	public Swords(double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level,int level) {
		
		this.power_level=power_level;
		this.power=power+(power_level*level);
		this.damage_level=damage_level;
		this.damage=damage+(damage_level*level);
		this.attack_speed=attack_speed;
		this.range=32;
		this.level=level;
		this.health=health+(health_level*level);
		this.health_level=health_level;
	
}
}
