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
	
	
	Items[10000+i] = new Swords("Farmer_Sword_common_"+Integer.toString(i),10000+i,"Farmer_Sword",10,1,0,0,1,0,0,i);
	Items[10100+i] = new Swords("Farmer_Sword_unusual_"+Integer.toString(i),10100+i,"Farmer_Sword",12,1.2,0,0,1,0,0,i);
	Items[10200+i] = new Swords("Farmer_Sword_rare_"+Integer.toString(i),10200+i,"Farmer_Sword",14,1.6,0,0,1,0,0,i);
	Items[10300+i] = new Swords("Farmer_Sword_epic_"+Integer.toString(i),10300+i,"Farmer_Sword",16,2,0,0,1,0,0,i);
	
	Items[10400+i] = new Swords("Innacurate_Sword_common_"+Integer.toString(i),10400+i,"Innacurate_Sword",15,3,0,0,0.5,0,0,i);
	Items[10500+i] = new Swords("Innacurate_Sword_unusual_"+Integer.toString(i),10500+i,"Innacurate_Sword",19,4,0,0,0.5,0,0,i);
	Items[10600+i] = new Swords("Innacurate_Sword_rare_"+Integer.toString(i),10600+i,"Innacurate_Sword",23,5,0,0,0.5,0,0,i);
	Items[10700+i] = new Swords("Innacurate_Sword_epic_"+Integer.toString(i),10700+i,"Innacurate_Sword",27,6,0,0,0.5,0,0,i);
	
	Items[10800+i] = new Swords("Basic_Sword_common_"+Integer.toString(i),10800+i,"Basic_Sword",12,2,0,0,1,0,0,i);
	Items[10900+i] = new Swords("Basic_Sword_unusual_"+Integer.toString(i),10900+i,"Basic_Sword",15,2.5,0,0,1,0,0,i);
	Items[11000+i] = new Swords("Basic_Sword_rare_"+Integer.toString(i),11000+i,"Basic_Sword",18,3,0,0,1,0,0,i);
	Items[11100+i] = new Swords("Basic_Sword_epic_"+Integer.toString(i),11100+i,"Basic_Sword",22,4,0,0,1,0,0,i);
	
	Items[11200+i] = new Swords("ancient_daggers_Sword_common_"+Integer.toString(i),11200+i,"ancient_daggers_Sword",12,2,0,0,1,0,0,i);
	Items[11300+i] = new Swords("ancient_daggers_Sword_unusual_"+Integer.toString(i),11300+i,"ancient_daggers_Sword",15,2.5,0,0,1,0,0,i);
	Items[11400+i] = new Swords("ancient_daggers_Sword_rare_"+Integer.toString(i),11400+i,"ancient_daggers_Sword",18,3,0,0,1,0,0,i);
	Items[11500+i] = new Swords("ancient_daggers_Sword_epic_"+Integer.toString(i),11500+i,"ancient_daggers_Sword",22,4,0,0,1,0,0,i);
	
	
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
	}
}
}

