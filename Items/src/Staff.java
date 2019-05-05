public class Staff extends Items{
	
	public Staff(double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level,int level) {
		this.health_level=health_level;
		this.health=health+(health_level*level);
		this.power_level=power_level;
		this.power=power+(power_level*level);
		this.damage_level=damage_level;
		this.attack_speed=attack_speed;
		this.damage=damage+(damage_level*level);
		this.range=300;
		this.level=level;
		this.health=health+(health_level*level);
		this.health_level=health_level;
			
		}
}


