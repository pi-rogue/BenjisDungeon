
public class main {

	public static void main(String[] args) {
		
	//double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level,int level	
	int i,level_max=30;
	for(i=0;i<=30;i++)
	{
	Axe Farmer_Axe_common_i = new Axe(11,1.1,0,0,0.8,0,0,i);
	Axe Farmer_Axe_unusual_i = new Axe(13,1.4,0,0,0.8,0,0,i);
	Axe Farmer_Axe_rare_i = new Axe(15,1.8,0,0,0.8,0,0,i);
	Axe Farmer_Axe_epic_i = new Axe(17,2.2,0,0,0.8,0,0,i);
	
	Axe Innacurate_Axe_common_i = new Axe(17,3.2,0,0,0.4,0,0,i);
	Axe Innacurate_Axe_unusual_i = new Axe(22,4.4,0,0,0.4,0,0,i);
	Axe Innacurate_Axe_rare_i = new Axe(25,5.6,0,0,0.4,0,0,i);
	Axe Innacurate_Axe_epic_i = new Axe(29,6.8,0,0,0.4,0,0,i);
	
	Axe Basic_Axe_common_i = new Axe(13,2.2,0,0,0.8,0,0,i);
	Axe Basic_Axe_unusual_i = new Axe(16,2.7,0,0,0.8,0,0,i);
	Axe Basic_Axe_rare_i = new Axe(19,3.2,0,0,0.8,0,0,i);
	Axe Basic_Axe_epic_i = new Axe(23,4.2,0,0,0.8,0,0,i);
	
	Axe Ancient_Axe_common_i = new Axe(13,2.2,0,0,0.8,0,0,i);
	Axe Ancient_Axe_unusual_i = new Axe(16,2.7,0,0,0.8,0,0,i);
	Axe Ancient_Axe_rare_i = new Axe(19,3.2,0,0,0.8,0,0,i);
	Axe Ancient_Axe_epic_i = new Axe(23,4.2,0,0,0.8,0,0,i);
	
	
	Swords Farmer_Sword_common_i = new Swords(10,1,0,0,1,0,0,i);
	Swords Farmer_Sword_unusual_i = new Swords(12,1.2,0,0,1,0,0,i);
	Swords Farmer_Sword_rare_i = new Swords(14,1.6,0,0,1,0,0,i);
	Swords Farmer_Sword_epic_i = new Swords(16,2,0,0,1,0,0,i);
	
	Swords Innacurate_Sword_common_i = new Swords(15,3,0,0,0.5,0,0,i);
	Swords Innacurate_Sword_unusual_i = new Swords(19,4,0,0,0.5,0,0,i);
	Swords Innacurate_Sword_rare_i = new Swords(23,5,0,0,0.5,0,0,i);
	Swords Innacurate_Sword_epic_i = new Swords(27,6,0,0,0.5,0,0,i);
	
	Swords Basic_Sword_common_i = new Swords(12,2,0,0,1,0,0,i);
	Swords Basic_Sword_unusual_i = new Swords(15,2.5,0,0,1,0,0,i);
	Swords Basic_Sword_rare_i = new Swords(18,3,0,0,1,0,0,i);
	Swords Basic_Sword_epic_i = new Swords(22,4,0,0,1,0,0,i);
	
	Swords Ancient_Sword_common_i = new Swords(12,2,0,0,1,0,0,i);
	Swords Ancient_Sword_unusual_i = new Swords(15,2.5,0,0,1,0,0,i);
	Swords Ancient_Sword_rare_i = new Swords(18,3,0,0,1,0,0,i);
	Swords Ancient_Sword_epic_i = new Swords(22,4,0,0,1,0,0,i);
	
	
	Staff Basic_Staff_common_i = new Staff(8,1,10,0.3,0.5,0,0,i);
	Staff Basic_Staff_unusual_i = new Staff(9,1.1,20,0.3,0.5,0,0,i);
	Staff Basic_Staff_rare_i = new Staff(10,1.2,30,0.3,0.5,0,0,i);
	Staff Basic_Staff_epic_i = new Staff(12,1.3,40,0.3,0.5,0,0,i);
	
	Staff Void_Staff_common_i = new Staff(8,1,8,0.3,0.5,0,0,i);
	Staff Void_Staff_unusual_i = new Staff(9,1.1,16,0.3,0.5,0,0,i);
	Staff Void_Staff_rare_i = new Staff(10,1.2,24,0.3,0.5,0,0,i);
	Staff Void_Staff_epic_i = new Staff(12,1.3,36,0.3,0.5,0,0,i);
	
	Staff Ancient_Staff_common_i = new Staff(8,1,12,0.3,0.5,0,0,i);
	Staff Ancient_Staff_unusual_i = new Staff(9,1.1,24,0.3,0.5,0,0,i);
	Staff Ancient_Staff_rare_i = new Staff(10,1.2,36,0.3,0.5,0,0,i);
	Staff Ancient_Staff_epic_i = new Staff(12,1.3,50,0.3,0.5,0,0,i);	
		
	Staff Corrupted_Staff_common_i = new Staff(8,1,20,0.3,0.5,-10,-6,i);
	Staff Corrupted_Staff_unusual_i = new Staff(9,1.1,30,0.3,0.5,-10,-6,i);
	Staff Corrupted_Staff_rare_i = new Staff(10,1.2,40,0.3,0.5,-10,-6,i);
	Staff Corrupted_Staff_epic_i = new Staff(12,1.3,50,0.3,0.5,-10,-6,i);
	
	
	Bow Basic_Bow_common_i = new Bow(18,2.2,0,0,1,0,0,i);
	Bow Basic_Bow_unusual_i = new Bow(22,2.8,0,0,1,0,0,i);
	Bow Basic_Bow_rare_i = new Bow(26,3.6,0,0,1,0,0,i);
	Bow Basic_Bow_epic_i = new Bow(30,4.4,0,0,1,0,0,i);
	
	Bow Sniper_Bow_common_i = new Bow(18,2.2,0,0,1,0,0,i);
	Bow Sniper_Bow_unusual_i = new Bow(22,2.8,0,0,1,0,0,i);
	Bow Sniper_Bow_rare_i = new Bow(26,3.6,0,0,1,0,0,i);
	Bow Sniper_Bow_epic_i = new Bow(30,4.4,0,0,1,0,0,i);

	Bow Fire_Bow_common_i = new Bow(16,2.2,0,0,1,0,0,i);
	Bow Fire_Bow_unusual_i = new Bow(20,2.8,0,0,1,0,0,i);
	Bow Fire_Bow_rare_i = new Bow(24,3.6,0,0,1,0,0,i);
	Bow Fire_Bow_epic_i = new Bow(28,4.4,0,0,1,0,0,i);

	Bow Poisonned_Bow_common_i = new Bow(16,2.2,0,0,1,0,0,i);
	Bow Poisonned_Bow_unusual_i = new Bow(20,2.8,0,0,1,0,0,i);
	Bow Poisonned_Bow_rare_i = new Bow(24,3.6,0,0,1,0,0,i);
	Bow Poisoned_Bow_epic_i = new Bow(28,4.4,0,0,1,0,0,i);
	
	Daggers Basic_Daggers_common_i = new Daggers(8,4.2,0,0,1,0,0,i);
	Daggers Basic_Daggers_unusual_i = new Daggers(10,4.8,0,0,1,0,0,i);
	Daggers Basic_Daggers_rare_i = new Daggers(12,5.4,0,0,1,0,0,i);
	Daggers Basic_Daggers_epic_i = new Daggers(14,6,0,0,1,0,0,i);

	Daggers Assassin_Daggers_common_i = new Daggers(16,4.2,0,0,1,0,0,i);
	Daggers Asssassin_Daggers_unusual_i = new Daggers(20,4.8,0,0,1,0,0,i);
	Daggers Asssassin_Daggers_rare_i = new Daggers(24,5.4,0,0,1,0,0,i);
	Daggers Assassin_Daggers_epic_i = new Daggers(18,6,0,0,1,0,0,i);

	Daggers Bloody_Daggers_common_i = new Daggers(8,4.2,0,0,1,0,0,i);
	Daggers Bloody_Daggers_unusual_i = new Daggers(10,4.8,0,0,1,0,0,i);
	Daggers Bloody_Daggers_rare_i = new Daggers(12,5.4,0,0,1,0,0,i);
	Daggers Bloody_Daggers_epic_i = new Daggers(14,6,0,0,1,0,0,i);

	Daggers Ancient_Daggers_common_i = new Daggers(9,4.2,0,0,1,0,0,i);
	Daggers Ancient_Daggers_unusual_i = new Daggers(11,4.8,0,0,1,0,0,i);
	Daggers Ancient_Daggers_rare_i = new Daggers(13,5.4,0,0,1,0,0,i);
	Daggers Ancient_Daggers_epic_i = new Daggers(15,6,0,0,1,0,0,i);
	
	
	
	
	//double health, double health_level
	
	
	Head Hat_common_i = new Head(10,5,i);
	Head Hat_unusual_i = new Head(15,6,i);
	Head Hat_rare_i = new Head(20,7,i);
	Head Hat_epic_i = new Head(30,8,i);
	
	Head Helmet_common_i = new Head(15,8,i);
	Head Helmet_unusual_i = new Head(25,9,i);
	Head Helmet_rare_i = new Head(35,10,i);
	Head Helmet_epic_i = new Head(50,12,i);

	Head Helm_common_i = new Head(12,6.5,i);
	Head Helm_unusual_i = new Head(19,7.5,i);
	Head Helm_rare_i = new Head(26,8.5,i);
	Head Helm_epic_i = new Head(40,9.5,i);

	Head Hood_common_i = new Head(10,5,i);
	Head Hood_unusual_i = new Head(15,6,i);
	Head Hood_rare_i = new Head(20,7,i);
	Head Hood_epic_i = new Head(30,8,i);
	
	
	Chestplate Breastplate_common_i = new Chestplate(20,8,i);
	Chestplate Breastplate_unusual_i = new Chestplate(30,9,i);
	Chestplate Breastplate_rare_i = new Chestplate(40,10,i);
	Chestplate Breastplate_epic_i = new Chestplate(50,12,i);
	
	Chestplate Vest_common_i = new Chestplate(10,5,i);
	Chestplate Vest_unusual_i = new Chestplate(15,6,i);
	Chestplate Vest_rare_i = new Chestplate(20,7,i);
	Chestplate Vest_epic_i = new Chestplate(30,8,i);
	
	Chestplate Chain_Mail_common_i = new Chestplate(12,6.5,i);
	Chestplate Chain_Mail_unusual_i = new Chestplate(19,7.5,i);
	Chestplate Chain_Mail_rare_i = new Chestplate(26,8.5,i);
	Chestplate Chain_Mail_epic_i = new Chestplate(40,9.5,i);
	
	Chestplate Dress_common_i = new Chestplate(10,5,i);
	Chestplate Dress_unusual_i = new Chestplate(15,6,i);
	Chestplate Dress_rare_i = new Chestplate(20,7,i);
	Chestplate Dress_epic_i = new Chestplate(30,8,i);
	
	
	Legs Legguard_common_i = new Legs(20,8,i);
	Legs Legguard_unusual_i = new Legs(30,9,i);
	Legs Legguard_rare_i = new Legs(40,10,i);
	Legs Legguard_epic_i = new Legs(50,12,i);
	
	Legs Leggings_common_i = new Legs(12,6.5,i);
	Legs Leggings_unusual_i = new Legs(19,7.5,i);
	Legs Leggings_rare_i = new Legs(26,8.5,i);
	Legs Leggings_epic_i = new Legs(40,9.5,i);
	
	Legs Pants_common_i = new Legs(10,5,i);
	Legs Pants_unusual_i = new Legs(15,6,i);
	Legs Pants_rare_i = new Legs(20,7,i);
	Legs Pants_epic_i = new Legs(30,8,i);
	
	Legs Breeches_common_i = new Legs(10,5,i);
	Legs Breeches_unusual_i = new Legs(15,6,i);
	Legs Breeches_rare_i = new Legs(20,7,i);
	Legs Breeches_epic_i = new Legs(30,8,i);
	
	
	Feet Greaves_common_i = new Feet(15,5,i);
	Feet Greaves_unusual_i = new Feet(25,6,i);
	Feet Greaves_rare_i = new Feet(35,7,i);
	Feet Greaves_epic_i = new Feet(50,8,i);
	
	Feet Footguard_common_i = new Feet(12,8,i);
	Feet Footguard_unusual_i = new Feet(19,9,i);
	Feet Footguard_rare_i = new Feet(26,10,i);
	Feet Footguard_epic_i = new Feet(40,12,i);
	
	Feet Boots_common_i = new Feet(10,6.5,i);
	Feet Boots_unusual_i = new Feet(15,7.5,i);
	Feet Boots_rare_i = new Feet(20,8.5,i);
	Feet Boots_epic_i = new Feet(30,9.5,i);
	
	Feet Slippers_common_i = new Feet(10,5,i);
	Feet Slippers_unusual_i = new Feet(15,6,i);
	Feet Slippers_rare_i = new Feet(20,7,i);
	Feet Slippers_epic_i = new Feet(30,8,i);


	}
	}

}
