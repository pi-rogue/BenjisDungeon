package com.pirogue.items;

public class List {

	//double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level,int level	
	public Item[] Items = new Item[200000];
	
	
	private int i,level_max=29;
	{
		
	for(i=0;i<=level_max;i++)
	
	{
	/*Items[i] = new Axe("Farmer_Axe_common_"+Integer.toString(i),i,"Farmer_Axe",11,1.1,0,0,0.8,0,0,i);
	Items[100+i] = new Axe("Farmer_Axe_unusual_"+Integer.toString(i),100+i,"Farmer_Axe",13,1.4,0,0,0.8,0,0,i);
	Items[200+i] = new Axe("Farmer_Axe_rare_"+Integer.toString(i),200+i,"Farmer_Axe",15,1.8,0,0,0.8,0,0,i);
	Items[300+i] = new Axe("Farmer_Axe_epic_"+Integer.toString(i),300+i,"Farmer_Axe",17,2.2,0,0,0.8,0,0,i);
	
	Items[400+i] = new Axe("Innacurate_Axe_common_"+Integer.toString(i),400+i,"Innacurate_Axe",17,3.2,0,0,0.4,0,0,i);
	Items[500+i] = new Axe("Innacurate_Axe_unusual_"+Integer.toString(i),500+i,"Innacurate_Axe",22,4.4,0,0,0.4,0,0,i);
	Items[600+i] = new Axe("Innacurate_Axe_rare_"+Integer.toString(i),600+i,"Innacurate_Axe",25,5.6,0,0,0.4,0,0,i);
	Items[700+i] = new Axe("Innacurate_Axe_epic_"+Integer.toString(i),700+i,"Innacurate_Axe",29,6.8,0,0,0.4,0,0,i);
	
	Items[800+i] = new Axe("Basic_Axe_common_"+Integer.toString(i),800+i,"Basic_Axe",13,2.2,0,0,0.8,0,0,i);
	Items[900+i] = new Axe("Basic_Axe_unusual_"+Integer.toString(i),900+i,"Basic_Axe",16,2.7,0,0,0.8,0,0,i);
	Items[1000+i] = new Axe("Basic_Axe_rare_"+Integer.toString(i),1000+i,"Basic_Axe",19,3.2,0,0,0.8,0,0,i);
	Items[1100+i] = new Axe("Basic_Axe_epic_"+Integer.toString(i),1100+i,"Basic_Axe",23,4.2,0,0,0.8,0,0,i);
	
	Items[1200+i] = new Axe("ancient_daggers_Axe_common_"+Integer.toString(i),1200+i,"ancient_daggers_Axe",13,2.2,0,0,0.8,0,0,i);
	Items[1300+i] = new Axe("ancient_daggers_Axe_unusual_"+Integer.toString(i),1300+i,"ancient_daggers_Axe",16,2.7,0,0,0.8,0,0,i);
	Items[1400+i] = new Axe("ancient_daggers_Axe_rare_"+Integer.toString(i),1400+i,"ancient_daggers_Axe",19,3.2,0,0,0.8,0,0,i);
	Items[1500+i] = new Axe("ancient_daggers_Axe_epic_"+Integer.toString(i),1500+i,"ancient_daggers_Axe",23,4.2,0,0,0.8,0,0,i);
	
	*/
	Items[10000+i] = new Swords("Farmer_sword_common_"+Integer.toString(i),10000+i,"Farmer_sword",10,1,0,0,1,0,0,i);
	Items[10100+i] = new Swords("Farmer_sword_unusual_"+Integer.toString(i),10100+i,"Farmer_sword",12,1.2,0,0,1,0,0,i);
	Items[10200+i] = new Swords("Farmer_sword_rare_"+Integer.toString(i),10200+i,"Farmer_sword",14,1.6,0,0,1,0,0,i);
	Items[10300+i] = new Swords("Farmer_sword_epic_"+Integer.toString(i),10300+i,"Farmer_sword",16,2,0,0,1,0,0,i);
	
	Items[10400+i] = new Swords("Innacurate_sword_common_"+Integer.toString(i),10400+i,"Innacurate_sword",15,3,0,0,0.5,0,0,i);
	Items[10500+i] = new Swords("Innacurate_sword_unusual_"+Integer.toString(i),10500+i,"Innacurate_sword",19,4,0,0,0.5,0,0,i);
	Items[10600+i] = new Swords("Innacurate_sword_rare_"+Integer.toString(i),10600+i,"Innacurate_sword",23,5,0,0,0.5,0,0,i);
	Items[10700+i] = new Swords("Innacurate_sword_epic_"+Integer.toString(i),10700+i,"Innacurate_sword",27,6,0,0,0.5,0,0,i);
	
	Items[10800+i] = new Swords("Basic_sword_common_"+Integer.toString(i),10800+i,"Basic_sword",12,2,0,0,1,0,0,i);
	Items[10900+i] = new Swords("Basic_sword_unusual_"+Integer.toString(i),10900+i,"Basic_sword",15,2.5,0,0,1,0,0,i);
	Items[11000+i] = new Swords("Basic_sword_rare_"+Integer.toString(i),11000+i,"Basic_sword",18,3,0,0,1,0,0,i);
	Items[11100+i] = new Swords("Basic_sword_epic_"+Integer.toString(i),11100+i,"Basic_sword",22,4,0,0,1,0,0,i);
	
	Items[11200+i] = new Swords("ancient_daggers_sword_common_"+Integer.toString(i),11200+i,"ancient_sword",12,2,0,0,1,0,0,i);
	Items[11300+i] = new Swords("ancient_daggers_sword_unusual_"+Integer.toString(i),11300+i,"ancient_sword",15,2.5,0,0,1,0,0,i);
	Items[11400+i] = new Swords("ancient_daggers_sword_rare_"+Integer.toString(i),11400+i,"ancient_sword",18,3,0,0,1,0,0,i);
	Items[11500+i] = new Swords("ancient_daggers_sword_epic_"+Integer.toString(i),11500+i,"ancient_sword",22,4,0,0,1,0,0,i);
	/*
	
	Items[20000+i] = new Staff("Basic_Staff_common_"+Integer.toString(i),20000+i,"Basic_Staff",8,1,10,0.3,0.5,0,0,i);
	Items[20100+i] = new Staff("Basic_Staff_unusual_"+Integer.toString(i),20100+i,"Basic_Staff",9,1.1,20,0.3,0.5,0,0,i);
	Items[20200+i] = new Staff("Basic_Staff_rare_"+Integer.toString(i),20200+i,"Basic_Staff",10,1.2,30,0.3,0.5,0,0,i);
	Items[20300+i] = new Staff("Basic_Staff_epic_"+Integer.toString(i),20300+i,"Basic_Staff",12,1.3,40,0.3,0.5,0,0,i);
	
	Items[20400+i] = new Staff("Void_Staff_common_"+Integer.toString(i),20400+i,"Void_Staff",8,1,8,0.3,0.5,0,0,i);
	Items[20500+i] = new Staff("Void_Staff_unusual_"+Integer.toString(i),20500+i,"Void_Staff",9,1.1,16,0.3,0.5,0,0,i);
	Items[20600+i] = new Staff("Void_Staff_rare_"+Integer.toString(i),20600+i,"Void_Staff",10,1.2,24,0.3,0.5,0,0,i);
	Items[20700+i] = new Staff("Void_Staff_epic_"+Integer.toString(i),20700+i,"Void_Staff",12,1.3,36,0.3,0.5,0,0,i);
	
	Items[20800+i] = new Staff("ancient_daggers_Staff_common_"+Integer.toString(i),20800+i,"ancient_daggers_Staff",8,1,12,0.3,0.5,0,0,i);
	Items[20900+i] = new Staff("ancient_daggers_Staff_unusual_"+Integer.toString(i),20900+i,"ancient_daggers_Staff",9,1.1,24,0.3,0.5,0,0,i);
	Items[21000+i] = new Staff("ancient_daggers_Staff_rare_"+Integer.toString(i),21000+i,"ancient_daggers_Staff",10,1.2,36,0.3,0.5,0,0,i);
	Items[21100+i] = new Staff("ancient_daggers_Staff_epic_"+Integer.toString(i),21100+i,"ancient_daggers_Staff",12,1.3,50,0.3,0.5,0,0,i);	
		
	Items[21200+i] = new Staff("Corrupted_Staff_common_"+Integer.toString(i),21200+i,"Corrupted_Staff",8,1,20,0.3,0.5,-10,-6,i);
	Items[21300+i] = new Staff("Corrupted_Staff_unusual_"+Integer.toString(i),21300+i,"Corrupted_Staff",9,1.1,30,0.3,0.5,-10,-6,i);
	Items[21400+i] = new Staff("Corrupted_Staff_rare_"+Integer.toString(i),21400+i,"Corrupted_Staff",10,1.2,40,0.3,0.5,-10,-6,i);
	Items[21500+i] = new Staff("Corrupted_Staff_epic_"+Integer.toString(i),21500+i,"Corrupted_Staff",12,1.3,50,0.3,0.5,-10,-6,i);
	
	
	Items[30000+i] = new Bow("Basic_Bow_common_"+Integer.toString(i),30000+i,"Basic_Bow",18,2.2,0,0,1,0,0,i);
	Items[30100+i] = new Bow("Basic_Bow_unusual_"+Integer.toString(i),30100+i,"Basic_Bow",22,2.8,0,0,1,0,0,i);
	Items[30200+i] = new Bow("Basic_Bow_rare_"+Integer.toString(i),30200+i,"Basic_Bow",26,3.6,0,0,1,0,0,i);
	Items[30300+i] = new Bow("Basic_Bow_epic_"+Integer.toString(i),30300+i,"Basic_Bow",30,4.4,0,0,1,0,0,i);
	
	Items[30400+i] = new Bow("Sniper_Bow_common_"+Integer.toString(i),30400+i,"Sniper_Bow",18,2.2,0,0,1,0,0,i);
	Items[30500+i] = new Bow("Sniper_Bow_unusual_"+Integer.toString(i),30500+i,"Sniper_Bow",22,2.8,0,0,1,0,0,i);
	Items[30600+i] = new Bow("Sniper_Bow_rare_"+Integer.toString(i),30600+i,"Sniper_Bow",26,3.6,0,0,1,0,0,i);
	Items[30700+i] = new Bow("Sniper_Bow_epic_"+Integer.toString(i),30700+i,"Sniper_Bow",30,4.4,0,0,1,0,0,i);

	Items[30800+i] = new Bow("Fire_Bow_common_"+Integer.toString(i),30800+i,"Fire_Bow",16,2.2,0,0,1,0,0,i);
	Items[30900+i] = new Bow("Fire_Bow_unusual_"+Integer.toString(i),30900+i,"Fire_Bow",20,2.8,0,0,1,0,0,i);
	Items[31000+i] = new Bow("Fire_Bow_rare_"+Integer.toString(i),31000+i,"Fire_Bow",24,3.6,0,0,1,0,0,i);
	Items[31100+i] = new Bow("Fire_Bow_epic_"+Integer.toString(i),31100+i,"Fire_Bow",28,4.4,0,0,1,0,0,i);

	Items[31200+i] = new Bow("Poisonned_Bow_common_"+Integer.toString(i),31200+i,"Poisonned_Bow",16,2.2,0,0,1,0,0,i);
	Items[31300+i] = new Bow("Poisonned_Bow_unusual_"+Integer.toString(i),31300+i,"Poisonned_Bow",20,2.8,0,0,1,0,0,i);
	Items[31400+i] = new Bow("Poisonned_Bow_rare_"+Integer.toString(i),31400+i,"Poisonned_Bow",24,3.6,0,0,1,0,0,i);
	Items[31500+i] = new Bow("Poisonned_Bow_epic_"+Integer.toString(i),31500+i,"Poisonned_Bow",28,4.4,0,0,1,0,0,i);
	
	*/
	Items[40000+i] = new Daggers("basic_daggers_common_"+Integer.toString(i),40000+i,"basic_daggers",8,4.2,0,0,1,0,0,i);
	Items[40100+i] = new Daggers("basic_daggers_unusual_"+Integer.toString(i),40100+i,"basic_daggers",10,4.8,0,0,1,0,0,i);
	Items[40200+i] = new Daggers("basic_daggers_rare_"+Integer.toString(i),40200+i,"basic_daggers",12,5.4,0,0,1,0,0,i);
	Items[40300+i] = new Daggers("basic_daggers_epic_"+Integer.toString(i),40300+i,"basic_daggers",14,6,0,0,1,0,0,i);
	
	Items[40400+i] = new Daggers("assassin_daggers_common_"+Integer.toString(i),40400+i,"assassin_daggers",16,4.2,0,0,1,0,0,i);
	Items[40500+i] = new Daggers("assassin_daggers_unusual_"+Integer.toString(i),40500+i,"assassin_daggers",20,4.8,0,0,1,0,0,i);
	Items[40600+i] = new Daggers("assassin_daggers_rare_"+Integer.toString(i),40600+i,"assassin_daggers",24,5.4,0,0,1,0,0,i);
	Items[40700+i] = new Daggers("assassin_daggers_epic_"+Integer.toString(i),40700+i,"assassin_daggers",18,6,0,0,1,0,0,i);

	Items[40800+i] = new Daggers("bloody_daggers_common_"+Integer.toString(i),40800+i,"bloody_daggers",8,4.2,0,0,1,0,0,i);
	Items[40900+i] = new Daggers("bloody_daggers_unusual_"+Integer.toString(i),40900+i,"bloody_daggers",10,4.8,0,0,1,0,0,i);
	Items[41000+i] = new Daggers("bloody_daggers_rare_"+Integer.toString(i),41000+i,"bloody_daggers",12,5.4,0,0,1,0,0,i);
	Items[41100+i] = new Daggers("bloody_daggers_epic_"+Integer.toString(i),41100+i,"bloody_daggers",14,6,0,0,1,0,0,i);

	Items[41200+i] = new Daggers("ancient_daggers_common_"+Integer.toString(i),41200+i,"ancient_daggers",9,4.2,0,0,1,0,0,i);
	Items[41300+i] = new Daggers("ancient_daggers_unusual_"+Integer.toString(i),41300+i,"ancient_daggers",11,4.8,0,0,1,0,0,i);
	Items[41400+i] = new Daggers("ancient_daggers_rare_"+Integer.toString(i),41400+i,"ancient_daggers",13,5.4,0,0,1,0,0,i);
	Items[41500+i] = new Daggers("ancient_daggers_epic_"+Integer.toString(i),41500+i,"ancient_daggers",15,6,0,0,1,0,0,i);
	
	//double health, double health_level
	
	
		/*Items[100000+i] = new Head("Hat_common_"+Integer.toString(i),100000+i,"Hat",10,5,i);
		Items[100100+i] = new Head("Hat_unusual_"+Integer.toString(i),100100+i,"Hat",15,6,i);
		Items[100200+i] = new Head("Hat_rare_"+Integer.toString(i),100200+i,"Hat",20,7,i);
		Items[100300+i] = new Head("Hat_epic_"+Integer.toString(i),100300+i,"Hat",30,8,i);
		
		Items[100400+i] = new Head("Helmet_common_"+Integer.toString(i),100400+i,"Helmet",15,8,i);
		Items[100500+i] = new Head("Helmet_unusual_"+Integer.toString(i),100500+i,"Helmet",25,9,i);
		Items[100600+i] = new Head("Helmet_rare_"+Integer.toString(i),100600+i,"Helmet",35,10,i);
		Items[100700+i] = new Head("Helmet_epic_"+Integer.toString(i),100700+i,"Helmet",50,12,i);

		Items[100800+i] = new Head("Helm_common_"+Integer.toString(i),100800+i,"Helm",12,6.5,i);
		Items[100900+i] = new Head("Helm_unusual_"+Integer.toString(i),100900+i,"Helm",19,7.5,i);
		Items[101000+i] = new Head("Helm_rare_"+Integer.toString(i),101000+i,"Helm",26,8.5,i);
		Items[101100+i] = new Head("Helm_epic_"+Integer.toString(i),101100+i,"Helm",40,9.5,i);
		
		Items[101200+i] = new Head("Hood_common_"+Integer.toString(i),101200+i,"Hood",10,5,i);
		Items[101300+i] = new Head("Hood_unusual_"+Integer.toString(i),101300+i,"Hood",15,6,i);
		Items[101400+i] = new Head("Hood_rare_"+Integer.toString(i),101400+i,"Hood",20,7,i);
		Items[101500+i] = new Head("Hood_epic_"+Integer.toString(i),101500+i,"Hood",30,8,i);
		
		
		Items[110000+i] = new Chestplate("Breastplate_common_"+Integer.toString(i),110000+i,"Breastplate",20,8,i);
		Items[110100+i] = new Chestplate("Breastplate_unusual_"+Integer.toString(i),110100+i,"Breastplate",30,9,i);
		Items[110200+i] = new Chestplate("Breastplate_rare_"+Integer.toString(i),110200+i,"Breastplate",40,10,i);
		Items[110300+i] = new Chestplate("Breastplate_epic_"+Integer.toString(i),110300+i,"Breastplate",50,12,i);
		
		Items[110400+i] = new Chestplate("Vest_common_"+Integer.toString(i),110400+i,"Vest",10,5,i);
		Items[110500+i] = new Chestplate("Vest_unusual_"+Integer.toString(i),110500+i,"Vest",15,6,i);
		Items[110600+i] = new Chestplate("Vest_rare_"+Integer.toString(i),110600+i,"Vest",20,7,i);
		Items[110700+i] = new Chestplate("Vest_epic_"+Integer.toString(i),110700+i,"Vest",30,8,i);
		
		Items[110800+i] = new Chestplate("Chain_Mail_common_"+Integer.toString(i),110800+i,"Chain_Mail",12,6.5,i);
		Items[110900+i] = new Chestplate("Chain_Mail_unusual_"+Integer.toString(i),110900+i,"Chain_Mail",19,7.5,i);
		Items[111000+i] = new Chestplate("Chain_Mail_rare_"+Integer.toString(i),111000+i,"Chain_Mail",26,8.5,i);
		Items[111100+i] = new Chestplate("Chain_Mail_epic_"+Integer.toString(i),111100+i,"Chain_Mail",40,9.5,i);
		
		Items[111200+i] = new Chestplate("Dress_common_"+Integer.toString(i),111200+i,"Dress",10,5,i);
		Items[111300+i] = new Chestplate("Dress_unusual_"+Integer.toString(i),111300+i,"Dress",15,6,i);
		Items[111400+i] = new Chestplate("Dress_rare_"+Integer.toString(i),111400+i,"Dress",20,7,i);
		Items[111500+i] = new Chestplate("Dress_epic_"+Integer.toString(i),111500+i,"Dress",30,8,i);
		
		
		Items[120000+i] = new Legs("Legguard_common_"+Integer.toString(i),120000+i,"Legguard",20,8,i);
		Items[120100+i] = new Legs("Legguard_unusual_"+Integer.toString(i),120100+i,"Legguard",30,9,i);
		Items[120200+i] = new Legs("Legguard_rare_"+Integer.toString(i),120200+i,"Legguard",40,10,i);
		Items[120300+i] = new Legs("Legguard_epic_"+Integer.toString(i),120300+i,"Legguard",50,12,i);
		
		Items[120400+i] = new Legs("Leggings_common_"+Integer.toString(i),120400+i,"Leggings",12,6.5,i);
		Items[120500+i] = new Legs("Leggings_unusual_"+Integer.toString(i),120500+i,"Leggings",19,7.5,i);
		Items[120600+i] = new Legs("Leggings_rare_"+Integer.toString(i),120600+i,"Leggings",26,8.5,i);
		Items[120700+i] = new Legs("Leggings_epic_"+Integer.toString(i),120700+i,"Leggings",40,9.5,i);
		
		Items[120800+i] = new Legs("Pants_common_"+Integer.toString(i),120800+i,"Pants",10,5,i);
		Items[120900+i] = new Legs("Pants_unusual_"+Integer.toString(i),120900+i,"Pants",15,6,i);
		Items[121000+i] = new Legs("Pants_rare_"+Integer.toString(i),121000+i,"Pants",20,7,i);
		Items[121100+i] = new Legs("Pants_epic_"+Integer.toString(i),121100+i,"Pants",30,8,i);
		
		Items[121200+i] = new Legs("Breeches_common_"+Integer.toString(i),121200+i,"Breeches",10,5,i);
		Items[121300+i] = new Legs("Breeches_unusual_"+Integer.toString(i),121300+i,"Breeches",15,6,i);
		Items[121400+i] = new Legs("Breeches_rare_"+Integer.toString(i),121400+i,"Breeches",20,7,i);
		Items[121500+i] = new Legs("Breeches_epic_"+Integer.toString(i),121500+i,"Breeches",30,8,i);
		
		
		Items[130000+i] = new Feet("Greaves_common_"+Integer.toString(i),130000+i,"Greaves",15,5,i);
		Items[130100+i] = new Feet("Greaves_unusual_"+Integer.toString(i),130100+i,"Greaves",25,6,i);
		Items[130200+i] = new Feet("Greaves_rare_"+Integer.toString(i),130200+i,"Greaves",35,7,i);
		Items[130300+i] = new Feet("Greaves_epic_"+Integer.toString(i),130300+i,"Greaves",50,8,i);
		
		Items[130400+i] = new Feet("Footguard_common_"+Integer.toString(i),130400+i,"Footguard",12,8,i);
		Items[130500+i] = new Feet("Footguard_unusual_"+Integer.toString(i),130500+i,"Footguard",19,9,i);
		Items[130600+i] = new Feet("Footguard_rare_"+Integer.toString(i),130600+i,"Footguard",26,10,i);
		Items[130700+i] = new Feet("Footguard_epic_"+Integer.toString(i),130700+i,"Footguard",40,12,i);
		
		Items[130800+i] = new Feet("Boots_common_"+Integer.toString(i),130800+i,"Boots",10,6.5,i);
		Items[130900+i] = new Feet("Boots_unusual_"+Integer.toString(i),130900+i,"Boots",15,7.5,i);
		Items[131000+i] = new Feet("Boots_rare_"+Integer.toString(i),131000+i,"Boots",20,8.5,i);
		Items[131100+i] = new Feet("Boots_epic_"+Integer.toString(i),131100+i,"Boots",30,9.5,i);
		
		Items[131200+i] = new Feet("Slippers_common_"+Integer.toString(i),131200+i,"Slippers",10,5,i);
		Items[131300+i] = new Feet("Slippers_unusual_"+Integer.toString(i),131300+i,"Slippers",15,6,i);
		Items[131400+i] = new Feet("Slippers_rare_"+Integer.toString(i),131400+i,"Slippers",20,7,i);
		Items[131500+i] = new Feet("Slippers_epic_"+Integer.toString(i),131500+i,"Slippers",30,8,i);*/
}
}}

