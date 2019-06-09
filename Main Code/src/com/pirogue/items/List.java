package com.pirogue.items;

public class List {

	//double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_levelnt level	
	private Item[] items = new Item[2001];
	
	public List() {
	
	/*items[0] = new Axe("Farmer_Axe_common_","Farmer_Axe",11,1.1,0,0,0.8,0,0);
	items[1] = new Axe("Farmer_Axe_unusual_",1,"Farmer_Axe",13,1.4,0,0,0.8,0,0);
	items[2] = new Axe("Farmer_Axe_rare_",2,"Farmer_Axe",15,1.8,0,0,0.8,0,0);
	items[3] = new Axe("Farmer_Axe_epic_",3,"Farmer_Axe",17,2.2,0,0,0.8,0,0);
	
	items[4] = new Axe("Innacurate_Axe_common_",4,"Innacurate_Axe",17,3.2,0,0,0.4,0,0);
	items[5] = new Axe("Innacurate_Axe_unusual_",5,"Innacurate_Axe",22,4.4,0,0,0.4,0,0);
	items[6] = new Axe("Innacurate_Axe_rare_",6,"Innacurate_Axe",25,5.6,0,0,0.4,0,0);
	items[7] = new Axe("Innacurate_Axe_epic_",7,"Innacurate_Axe",29,6.8,0,0,0.4,0,0);
	
	items[8] = new Axe("Basic_Axe_common_",8,"Basic_Axe",13,2.2,0,0,0.8,0,0);
	items[9] = new Axe("Basic_Axe_unusual_",9,"Basic_Axe",16,2.7,0,0,0.8,0,0);
	items[10] = new Axe("Basic_Axe_rare_",10,"Basic_Axe",19,3.2,0,0,0.8,0,0);
	items[11] = new Axe("Basic_Axe_epic_",11,"Basic_Axe",23,4.2,0,0,0.8,0,0);
	
	items[12] = new Axe("ancient_daggers_Axe_common_",12,"ancient_daggers_Axe",13,2.2,0,0,0.8,0,0);
	items[13] = new Axe("ancient_daggers_Axe_unusual_",13,"ancient_daggers_Axe",16,2.7,0,0,0.8,0,0);
	items[14] = new Axe("ancient_daggers_Axe_rare_",14,"ancient_daggers_Axe",19,3.2,0,0,0.8,0,0);
	items[15] = new Axe("ancient_daggers_Axe_epic_",15,"ancient_daggers_Axe",23,4.2,0,0,0.8,0,0);
	
	
	items[100] = new Swords("Farmer_sword_common_",1,"Farmer_sword",10,1,0,0,1,0,0);
	items[101] = new Swords("Farmer_sword_unusual_",101,"Farmer_sword",12,1.2,0,0,1,0,0);
	items[102] = new Swords("Farmer_sword_rare_",102,"Farmer_sword",14,1.6,0,0,1,0,0);
	items[103] = new Swords("Farmer_sword_epic_",103,"Farmer_sword",16,2,0,0,1,0,0);
	
	items[104] = new Swords("Innacurate_sword_common_",104,"Innacurate_sword",15,3,0,0,0.5,0,0);
	items[105] = new Swords("Innacurate_sword_unusual_",105,"Innacurate_sword",19,4,0,0,0.5,0,0);
	items[106] = new Swords("Innacurate_sword_rare_",106,"Innacurate_sword",23,5,0,0,0.5,0,0);
	items[107] = new Swords("Innacurate_sword_epic_",107,"Innacurate_sword",27,6,0,0,0.5,0,0);
	
	items[108] = new Swords("Basic_sword_common_",108,"Basic_sword",12,2,0,0,1,0,0);
	items[109] = new Swords("Basic_sword_unusual_",109,"Basic_sword",15,2.5,0,0,1,0,0);
	items[110] = new Swords("Basic_sword_rare_",110,"Basic_sword",18,3,0,0,1,0,0);
	items[111] = new Swords("Basic_sword_epic_",111,"Basic_sword",22,4,0,0,1,0,0);
	
	items[112] = new Swords("Ancient_sword_common_",112,"Ancient_sword",12,2,0,0,1,0,0);
	items[113] = new Swords("Ancient_sword_unusual_",113,"Ancient_sword",15,2.5,0,0,1,0,0);
	items[114] = new Swords("Ancient_sword_rare_",114,"Ancient_sword",18,3,0,0,1,0,0);
	items[115] = new Swords("Ancient_sword_epic_",115,"Ancient_sword",22,4,0,0,1,0,0);
	
	
	items[200] = new Staff("Basic_Staff_common_",2,"Basic_Staff",8,1,10,0.3,0.5,0,0);
	items[201] = new Staff("Basic_Staff_unusual_",201,"Basic_Staff",9,1.1,20,0.3,0.5,0,0);
	items[202] = new Staff("Basic_Staff_rare_",202,"Basic_Staff",10,1.2,30,0.3,0.5,0,0);
	items[203] = new Staff("Basic_Staff_epic_",203,"Basic_Staff",12,1.3,40,0.3,0.5,0,0);
	
	items[204] = new Staff("Void_Staff_common_",204,"Void_Staff",8,1,8,0.3,0.5,0,0);
	items[205] = new Staff("Void_Staff_unusual_",205,"Void_Staff",9,1.1,16,0.3,0.5,0,0);
	items[206] = new Staff("Void_Staff_rare_",206,"Void_Staff",10,1.2,24,0.3,0.5,0,0);
	items[207] = new Staff("Void_Staff_epic_",207,"Void_Staff",12,1.3,36,0.3,0.5,0,0);
	
	items[208] = new Staff("ancient_daggers_Staff_common_",208,"ancient_daggers_Staff",8,1,12,0.3,0.5,0,0);
	items[209] = new Staff("ancient_daggers_Staff_unusual_",209,"ancient_daggers_Staff",9,1.1,24,0.3,0.5,0,0);
	items[210] = new Staff("ancient_daggers_Staff_rare_",210,"ancient_daggers_Staff",10,1.2,36,0.3,0.5,0,0);
	items[211] = new Staff("ancient_daggers_Staff_epic_",211,"ancient_daggers_Staff",12,1.3,50,0.3,0.5,0,0);	
		
	items[212] = new Staff("Corrupted_Staff_common_",212,"Corrupted_Staff",8,1,20,0.3,0.5,-10,-6);
	items[213] = new Staff("Corrupted_Staff_unusual_",213,"Corrupted_Staff",9,1.1,30,0.3,0.5,-10,-6);
	items[214] = new Staff("Corrupted_Staff_rare_",214,"Corrupted_Staff",10,1.2,40,0.3,0.5,-10,-6);
	items[215] = new Staff("Corrupted_Staff_epic_",215,"Corrupted_Staff",12,1.3,50,0.3,0.5,-10,-6);
	
	
	items[300] = new Bow("Basic_Bow_common_",3,"Basic_Bow",18,2.2,0,0,1,0,0);
	items[301] = new Bow("Basic_Bow_unusual_",301,"Basic_Bow",22,2.8,0,0,1,0,0);
	items[302] = new Bow("Basic_Bow_rare_",302,"Basic_Bow",26,3.6,0,0,1,0,0);
	items[303] = new Bow("Basic_Bow_epic_",303,"Basic_Bow",30,4.4,0,0,1,0,0);
	
	items[304] = new Bow("Sniper_Bow_common_",304,"Sniper_Bow",18,2.2,0,0,1,0,0);
	items[305] = new Bow("Sniper_Bow_unusual_",305,"Sniper_Bow",22,2.8,0,0,1,0,0);
	items[306] = new Bow("Sniper_Bow_rare_",306,"Sniper_Bow",26,3.6,0,0,1,0,0);
	items[307] = new Bow("Sniper_Bow_epic_",307,"Sniper_Bow",30,4.4,0,0,1,0,0);

	items[308] = new Bow("Fire_Bow_common_",308,"Fire_Bow",16,2.2,0,0,1,0,0);
	items[309] = new Bow("Fire_Bow_unusual_",309,"Fire_Bow",20,2.8,0,0,1,0,0);
	items[310] = new Bow("Fire_Bow_rare_",310,"Fire_Bow",24,3.6,0,0,1,0,0);
	items[311] = new Bow("Fire_Bow_epic_",311,"Fire_Bow",28,4.4,0,0,1,0,0);

	items[312] = new Bow("Poisonned_Bow_common_",312,"Poisonned_Bow",16,2.2,0,0,1,0,0);
	items[313] = new Bow("Poisonned_Bow_unusual_",313,"Poisonned_Bow",20,2.8,0,0,1,0,0);
	items[314] = new Bow("Poisonned_Bow_rare_",314,"Poisonned_Bow",24,3.6,0,0,1,0,0);
	items[315] = new Bow("Poisonned_Bow_epic_",315,"Poisonned_Bow",28,4.4,0,0,1,0,0);
	
	*/
	items[400] = new Daggers("basic_daggers_common_",4,"basic_daggers",8,4.2,0,0,1,0,0);
	items[401] = new Daggers("basic_daggers_unusual_",401,"basic_daggers",10,4.8,0,0,1,0,0);
	items[402] = new Daggers("basic_daggers_rare_",402,"basic_daggers",12,5.4,0,0,1,0,0);
	items[403] = new Daggers("basic_daggers_epic_",403,"basic_daggers",14,6,0,0,1,0,0);
	
	items[404] = new Daggers("assassin_daggers_common_",404,"assassin_daggers",16,4.2,0,0,1,0,0);
	items[405] = new Daggers("assassin_daggers_unusual_",405,"assassin_daggers",20,4.8,0,0,1,0,0);
	items[406] = new Daggers("assassin_daggers_rare_",406,"assassin_daggers",24,5.4,0,0,1,0,0);
	items[407] = new Daggers("assassin_daggers_epic_",407,"assassin_daggers",18,6,0,0,1,0,0);

	items[408] = new Daggers("bloody_daggers_common_",408,"bloody_daggers",8,4.2,0,0,1,0,0);
	items[409] = new Daggers("bloody_daggers_unusual_",409,"bloody_daggers",10,4.8,0,0,1,0,0);
	items[410] = new Daggers("bloody_daggers_rare_",410,"bloody_daggers",12,5.4,0,0,1,0,0);
	items[411] = new Daggers("bloody_daggers_epic_",411,"bloody_daggers",14,6,0,0,1,0,0);

	items[412] = new Daggers("ancient_daggers_common_",412,"ancient_daggers",9,4.2,0,0,1,0,0);
	items[413] = new Daggers("ancient_daggers_unusual_",413,"ancient_daggers",11,4.8,0,0,1,0,0);
	items[414] = new Daggers("ancient_daggers_rare_",414,"ancient_daggers",13,5.4,0,0,1,0,0);
	items[415] = new Daggers("ancient_daggers_epic_",415,"ancient_daggers",15,6,0,0,1,0,0);
	
	//double health, double health_level
	
	
		/*items[1000] = new Head("Hat_common_",10,"Hat",10,5);
		items[1001] = new Head("Hat_unusual_",11,"Hat",15,6);
		items[1002] = new Head("Hat_rare_",12,"Hat",20,7);
		items[1003] = new Head("Hat_epic_",13,"Hat",30,8);
		
		items[1004] = new Head("Helmet_common_",14,"Helmet",15,8);
		items[1005] = new Head("Helmet_unusual_",15,"Helmet",25,9);
		items[1006] = new Head("Helmet_rare_",16,"Helmet",35,10);
		items[1007] = new Head("Helmet_epic_",17,"Helmet",50,12);

		items[1008] = new Head("Helm_common_",18,"Helm",12,6.5);
		items[1009] = new Head("Helm_unusual_",19,"Helm",19,7.5);
		items[1010] = new Head("Helm_rare_",1010,"Helm",26,8.5);
		items[1011] = new Head("Helm_epic_",1011,"Helm",40,9.5);
		
		items[1012] = new Head("Hood_common_",1012,"Hood",10,5);
		items[1013] = new Head("Hood_unusual_",1013,"Hood",15,6);
		items[1014] = new Head("Hood_rare_",1014,"Hood",20,7);
		items[1015] = new Head("Hood_epic_",1015,"Hood",30,8);
		
		
		items[1100] = new Chestplate("Breastplate_common_",11,"Breastplate",20,8);
		items[1101] = new Chestplate("Breastplate_unusual_",1101,"Breastplate",30,9);
		items[1102] = new Chestplate("Breastplate_rare_",1102,"Breastplate",40,10);
		items[1103] = new Chestplate("Breastplate_epic_",1103,"Breastplate",50,12);
		
		items[1104] = new Chestplate("Vest_common_",1104,"Vest",10,5);
		items[1105] = new Chestplate("Vest_unusual_",1105,"Vest",15,6);
		items[1106] = new Chestplate("Vest_rare_",1106,"Vest",20,7);
		items[1107] = new Chestplate("Vest_epic_",1107,"Vest",30,8);
		
		items[1108] = new Chestplate("Chain_Mail_common_",1108,"Chain_Mail",12,6.5);
		items[1109] = new Chestplate("Chain_Mail_unusual_",1109,"Chain_Mail",19,7.5);
		items[1110] = new Chestplate("Chain_Mail_rare_",1110,"Chain_Mail",26,8.5);
		items[1111] = new Chestplate("Chain_Mail_epic_",1111,"Chain_Mail",40,9.5);
		
		items[1112] = new Chestplate("Dress_common_",1112,"Dress",10,5);
		items[1113] = new Chestplate("Dress_unusual_",1113,"Dress",15,6);
		items[1114] = new Chestplate("Dress_rare_",1114,"Dress",20,7);
		items[1115] = new Chestplate("Dress_epic_",1115,"Dress",30,8);
		
		
		items[1200] = new Legs("Legguard_common_",12,"Legguard",20,8);
		items[1201] = new Legs("Legguard_unusual_",1201,"Legguard",30,9);
		items[1202] = new Legs("Legguard_rare_",1202,"Legguard",40,10);
		items[1203] = new Legs("Legguard_epic_",1203,"Legguard",50,12);
		
		items[1204] = new Legs("Leggings_common_",1204,"Leggings",12,6.5);
		items[1205] = new Legs("Leggings_unusual_",1205,"Leggings",19,7.5);
		items[1206] = new Legs("Leggings_rare_",1206,"Leggings",26,8.5);
		items[1207] = new Legs("Leggings_epic_",1207,"Leggings",40,9.5);
		
		items[1208] = new Legs("Pants_common_",1208,"Pants",10,5);
		items[1209] = new Legs("Pants_unusual_",1209,"Pants",15,6);
		items[1210] = new Legs("Pants_rare_",1210,"Pants",20,7);
		items[1211] = new Legs("Pants_epic_",1211,"Pants",30,8);
		
		items[1212] = new Legs("Breeches_common_",1212,"Breeches",10,5);
		items[1213] = new Legs("Breeches_unusual_",1213,"Breeches",15,6);
		items[1214] = new Legs("Breeches_rare_",1214,"Breeches",20,7);
		items[1215] = new Legs("Breeches_epic_",1215,"Breeches",30,8);
		
		
		items[1300] = new Feet("Greaves_common_",13,"Greaves",15,5);
		items[1301] = new Feet("Greaves_unusual_",1301,"Greaves",25,6);
		items[1302] = new Feet("Greaves_rare_",1302,"Greaves",35,7);
		items[1303] = new Feet("Greaves_epic_",1303,"Greaves",50,8);
		
		items[1304] = new Feet("Footguard_common_",1304,"Footguard",12,8);
		items[1305] = new Feet("Footguard_unusual_",1305,"Footguard",19,9);
		items[1306] = new Feet("Footguard_rare_",1306,"Footguard",26,10);
		items[1307] = new Feet("Footguard_epic_",1307,"Footguard",40,12);
		
		items[1308] = new Feet("Boots_common_",1308,"Boots",10,6.5);
		items[1309] = new Feet("Boots_unusual_",1309,"Boots",15,7.5);
		items[1310] = new Feet("Boots_rare_",1310,"Boots",20,8.5);
		items[1311] = new Feet("Boots_epic_",1311,"Boots",30,9.5);
		
		items[1312] = new Feet("Slippers_common_",1312,"Slippers",10,5);
		items[1313] = new Feet("Slippers_unusual_",1313,"Slippers",15,6);
		items[1314] = new Feet("Slippers_rare_",1314,"Slippers",20,7);
		items[1315] = new Feet("Slippers_epic_",1315,"Slippers",30,8);*/
	}
	
	public Item get(int ID) {
		return items[ID];
	}
}