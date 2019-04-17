
public class main {

	public static void main(String[] args) {
		
	//double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level	
	
	Axe Farmer_Axe_common = new Axe(11,1.1,0,0,0.8,0,0);
	Axe Farmer_Axe_unusual = new Axe(13,1.4,0,0,0.8,0,0);
	Axe Farmer_Axe_rare = new Axe(15,1.8,0,0,0.8,0,0);
	Axe Farmer_Axe_epic = new Axe(17,2.2,0,0,0.8,0,0);
	
	Axe Innacurate_Axe_common = new Axe(17,3.2,0,0,0.4,0,0);
	Axe Innacurate_Axe_unusual = new Axe(22,4.4,0,0,0.4,0,0);
	Axe Innacurate_Axe_rare = new Axe(25,5.6,0,0,0.4,0,0);
	Axe Innacurate_Axe_epic = new Axe(29,6.8,0,0,0.4,0,0);
	
	Axe Basic_Axe_common = new Axe(13,2.2,0,0,0.8,0,0);
	Axe Basic_Axe_unusual = new Axe(16,2.7,0,0,0.8,0,0);
	Axe Basic_Axe_rare = new Axe(19,3.2,0,0,0.8,0,0);
	Axe Basic_Axe_epic = new Axe(23,4.2,0,0,0.8,0,0);
	
	Axe Ancient_Axe_common = new Axe(13,2.2,0,0,0.8,0,0);
	Axe Ancient_Axe_unusual = new Axe(16,2.7,0,0,0.8,0,0);
	Axe Ancient_Axe_rare = new Axe(19,3.2,0,0,0.8,0,0);
	Axe Ancient_Axe_epic = new Axe(23,4.2,0,0,0.8,0,0);
	
	
	Swords Farmer_Sword_common = new Swords(10,1,0,0,1,0,0);
	Swords Farmer_Sword_unusual = new Swords(12,1.2,0,0,1,0,0);
	Swords Farmer_Sword_rare = new Swords(14,1.6,0,0,1,0,0);
	Swords Farmer_Sword_epic = new Swords(16,2,0,0,1,0,0);
	
	Swords Innacurate_Sword_common = new Swords(15,3,0,0,0.5,0,0);
	Swords Innacurate_Sword_unusual = new Swords(19,4,0,0,0.5,0,0);
	Swords Innacurate_Sword_rare = new Swords(23,5,0,0,0.5,0,0);
	Swords Innacurate_Sword_epic = new Swords(27,6,0,0,0.5,0,0);
	
	Swords Basic_Sword_common = new Swords(12,2,0,0,1,0,0);
	Swords Basic_Sword_unusual = new Swords(15,2.5,0,0,1,0,0);
	Swords Basic_Sword_rare = new Swords(18,3,0,0,1,0,0);
	Swords Basic_Sword_epic = new Swords(22,4,0,0,1,0,0);
	
	Swords Ancient_Sword_common = new Swords(12,2,0,0,1,0,0);
	Swords Ancient_Sword_unusual = new Swords(15,2.5,0,0,1,0,0);
	Swords Ancient_Sword_rare = new Swords(18,3,0,0,1,0,0);
	Swords Ancient_Sword_epic = new Swords(22,4,0,0,1,0,0);
	
	
	Staff Basic_Staff_common = new Staff(8,1,10,0.3,0.5,0,0);
	Staff Basic_Staff_unusual = new Staff(9,1.1,20,0.3,0.5,0,0);
	Staff Basic_Staff_rare = new Staff(10,1.2,30,0.3,0.5,0,0);
	Staff Basic_Staff_epic = new Staff(12,1.3,40,0.3,0.5,0,0);
	
	Staff Void_Staff_common = new Staff(8,1,8,0.3,0.5,0,0);
	Staff Void_Staff_unusual = new Staff(9,1.1,16,0.3,0.5,0,0);
	Staff Void_Staff_rare = new Staff(10,1.2,24,0.3,0.5,0,0);
	Staff Void_Staff_epic = new Staff(12,1.3,36,0.3,0.5,0,0);
	
	Staff Ancient_Staff_common = new Staff(8,1,12,0.3,0.5,0,0);
	Staff Ancient_Staff_unusual = new Staff(9,1.1,24,0.3,0.5,0,0);
	Staff Ancient_Staff_rare = new Staff(10,1.2,36,0.3,0.5,0,0);
	Staff Ancient_Staff_epic = new Staff(12,1.3,50,0.3,0.5,0,0);	
		
	Staff Corrupted_Staff_common = new Staff(8,1,20,0.3,0.5,-10,-6);
	Staff Corrupted_Staff_unusual = new Staff(9,1.1,30,0.3,0.5,-10,-6);
	Staff Corrupted_Staff_rare = new Staff(10,1.2,40,0.3,0.5,-10,-6);
	Staff Corrupted_Staff_epic = new Staff(12,1.3,50,0.3,0.5,-10,-6);
	
	
	Bow Basic_Bow_common = new Bow(18,2.2,0,0,1,0,0);
	Bow Basic_Bow_unusual = new Bow(22,2.8,0,0,1,0,0);
	Bow Basic_Bow_rare = new Bow(26,3.6,0,0,1,0,0);
	Bow Basic_Bow_epic = new Bow(30,4.4,0,0,1,0,0);
	
	Bow Sniper_Bow_common = new Bow(18,2.2,0,0,1,0,0);
	Bow Sniper_Bow_unusual = new Bow(22,2.8,0,0,1,0,0);
	Bow Sniper_Bow_rare = new Bow(26,3.6,0,0,1,0,0);
	Bow Sniper_Bow_epic = new Bow(30,4.4,0,0,1,0,0);

	Bow Fire_Bow_common = new Bow(16,2.2,0,0,1,0,0);
	Bow Fire_Bow_unusual = new Bow(20,2.8,0,0,1,0,0);
	Bow Fire_Bow_rare = new Bow(24,3.6,0,0,1,0,0);
	Bow Fire_Bow_epic = new Bow(28,4.4,0,0,1,0,0);

	Bow Poisonned_Bow_common = new Bow(16,2.2,0,0,1,0,0);
	Bow Poisonned_Bow_unusual = new Bow(20,2.8,0,0,1,0,0);
	Bow Poisonned_Bow_rare = new Bow(24,3.6,0,0,1,0,0);
	Bow Poisoned_Bow_epic = new Bow(28,4.4,0,0,1,0,0);
	
	Daggers Basic_Daggers_common = new Daggers(8,4.2,0,0,1,0,0);
	Daggers Basic_Daggers_unusual = new Daggers(10,4.8,0,0,1,0,0);
	Daggers Basic_Daggers_rare = new Daggers(12,5.4,0,0,1,0,0);
	Daggers Basic_Daggers_epic = new Daggers(14,6,0,0,1,0,0);

	Daggers Assassin_Daggers_common = new Daggers(16,4.2,0,0,1,0,0);
	Daggers Asssassin_Daggers_unusual = new Daggers(20,4.8,0,0,1,0,0);
	Daggers Asssassin_Daggers_rare = new Daggers(24,5.4,0,0,1,0,0);
	Daggers Assassin_Daggers_epic = new Daggers(18,6,0,0,1,0,0);

	Daggers Bloody_Daggers_common = new Daggers(8,4.2,0,0,1,0,0);
	Daggers Bloody_Daggers_unusual = new Daggers(10,4.8,0,0,1,0,0);
	Daggers Bloody_Daggers_rare = new Daggers(12,5.4,0,0,1,0,0);
	Daggers Bloody_Daggers_epic = new Daggers(14,6,0,0,1,0,0);

	Daggers Ancient_Daggers_common = new Daggers(9,4.2,0,0,1,0,0);
	Daggers Ancient_Daggers_unusual = new Daggers(11,4.8,0,0,1,0,0);
	Daggers Ancient_Daggers_rare = new Daggers(13,5.4,0,0,1,0,0);
	Daggers Ancient_Daggers_epic = new Daggers(15,6,0,0,1,0,0);
	
	
	
	
	//double health, double health_level
	
	
	Head Hat_common = new Head(10,5);
	Head Hat_unusual = new Head(15,6);
	Head Hat_rare = new Head(20,7);
	Head Hat_epic = new Head(30,8);
	
	Head Helmet_common = new Head(15,8);
	Head Helmet_unusual = new Head(25,9);
	Head Helmet_rare = new Head(35,10);
	Head Helmet_epic = new Head(50,12);

	Head Helm_common = new Head(12,6.5);
	Head Helm_unusual = new Head(19,7.5);
	Head Helm_rare = new Head(26,8.5);
	Head Helm_epic = new Head(40,9.5);

	Head Hood_common = new Head(10,5);
	Head Hood_unusual = new Head(15,6);
	Head Hood_rare = new Head(20,7);
	Head Hood_epic = new Head(30,8);
	
	
	Chestplate Breastplate_common = new Chestplate(20,8);
	Chestplate Breastplate_unusual = new Chestplate(30,9);
	Chestplate Breastplate_rare = new Chestplate(40,10);
	Chestplate Breastplate_epic = new Chestplate(50,12);
	
	Chestplate Vest_common = new Chestplate(10,5);
	Chestplate Vest_unusual = new Chestplate(15,6);
	Chestplate Vest_rare = new Chestplate(20,7);
	Chestplate Vest_epic = new Chestplate(30,8);
	
	Chestplate Chain_Mail_common = new Chestplate(12,6.5);
	Chestplate Chain_Mail_unusual = new Chestplate(19,7.5);
	Chestplate Chain_Mail_rare = new Chestplate(26,8.5);
	Chestplate Chain_Mail_epic = new Chestplate(40,9.5);
	
	Chestplate Dress_common = new Chestplate(10,5);
	Chestplate Dress_unusual = new Chestplate(15,6);
	Chestplate Dress_rare = new Chestplate(20,7);
	Chestplate Dress_epic = new Chestplate(30,8);
	
	
	Legs Legguard_common = new Legs(20,8);
	Legs Legguard_unusual = new Legs(30,9);
	Legs Legguard_rare = new Legs(40,10);
	Legs Legguard_epic = new Legs(50,12);
	
	Legs Leggings_common = new Legs(12,6.5);
	Legs Leggings_unusual = new Legs(19,7.5);
	Legs Leggings_rare = new Legs(26,8.5);
	Legs Leggings_epic = new Legs(40,9.5);
	
	Legs Pants_common = new Legs(10,5);
	Legs Pants_unusual = new Legs(15,6);
	Legs Pants_rare = new Legs(20,7);
	Legs Pants_epic = new Legs(30,8);
	
	Legs Breeches_common = new Legs(10,5);
	Legs Breeches_unusual = new Legs(15,6);
	Legs Breeches_rare = new Legs(20,7);
	Legs Breeches_epic = new Legs(30,8);
	
	
	Feet Greaves_common = new Feet(15,5);
	Feet Greaves_unusual = new Feet(25,6);
	Feet Greaves_rare = new Feet(35,7);
	Feet Greaves_epic = new Feet(50,8);
	
	Feet Footguard_common = new Feet(12,8);
	Feet Footguard_unusual = new Feet(19,9);
	Feet Footguard_rare = new Feet(26,10);
	Feet Footguard_epic = new Feet(40,12);
	
	Feet Boots_common = new Feet(10,6.5);
	Feet Boots_unusual = new Feet(15,7.5);
	Feet Boots_rare = new Feet(20,8.5);
	Feet Boots_epic = new Feet(30,9.5);
	
	Feet Slippers_common = new Feet(10,5);
	Feet Slippers_unusual = new Feet(15,6);
	Feet Slippers_rare = new Feet(20,7);
	Feet Slippers_epic = new Feet(30,8);


	}

}
