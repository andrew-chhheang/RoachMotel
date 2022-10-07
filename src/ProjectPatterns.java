import java.util.ArrayList;

public class ProjectPatterns {

	public static void main(String[] args) {

		RoachMotel rm = RoachMotel.getInstance();
        rm.createRooms();
        rm.createFile();
        
        System.out.println(rm);
        RoachColony rc1 = new  RoachColony("First colony",100,200);
        ArrayList<String> amenities = new ArrayList<String>();
        amenities.add("foodbar");
        amenities.add("spa");
        amenities.add("refillbar");
        amenities.add("shower");
        System.out.println(rc1 + "checking in...");
        Room r1 = rm.checkIn(rc1,"Suite",amenities);

        System.out.println(rm);
        System.out.println(rc1 + " setting do not disturb...");
        r1.setDoNotDisturb();
        
        RoachColony rc2 = new RoachColony("Second colony",1200,0.2);
        ArrayList<String> amenities2 = new ArrayList<String>();
        amenities2.add("foodbar");
        System.out.println(rc2 + " checking in...");
        Room r2 = rm.checkIn(rc2,"Deluxe",amenities2);
        
        System.out.println(rm);
        System.out.println(rc2 + " is throwing a party...");
        rc2.party();
        System.out.println(rc2.getName() + " after the party: " + rc2);
        
        System.out.println(rc2 + "checking out...");
        Double cost = rm.checkOut(r2,3,"MasterRoach");
        System.out.println("cost:" + cost);
        System.out.println(rm);
        
        RoachColony rc3 = new RoachColony("third colony",300,0.3);
        System.out.println(rc3 + " checking in...");
        Room r3 = rm.checkIn(rc3,"Regular",amenities2);
        
        RoachColony rc4 = new RoachColony("fourth colony",400,0.4);
        System.out.println(rc4 + " checking in...");
        Room r4 = rm.checkIn(rc4,"Regular",amenities2);
        
        System.out.println(rc3 + " setting do not disturb...");
        r3.setDoNotDisturb();
        
        System.out.println("Time to clean the rooms today "+rm);
        //rm.cleanRooms();
        
        RoachColony rc5 = new RoachColony("fifth colony",500,0.5);
        System.out.println(rc5 + " checking in...");
        Room r5 = rm.checkIn(rc5,"Deluxe",amenities2);
        
        RoachColony rc6 = new RoachColony("sixth colony",600,0.6);
        System.out.println(rc6 + " checking in...");
        Room r6 = rm.checkIn(rc6,"Deluxe",amenities2);
        
        RoachColony rc7 = new RoachColony("Seventh colony",700,0.7);
        System.out.println(rc7 + " checking in...");
        Room r7 = rm.checkIn(rc7,"Suite",amenities2);
        
        RoachColony rc8 = new RoachColony("eigth colony",800,0.8);
        System.out.println(rc8 + " checking in...");
        Room r8 = rm.checkIn(rc8,"Suite",amenities2);
        
        RoachColony rc9 = new RoachColony("ninth colony",900,0.9);
        RoachColony rc10 = new RoachColony("tenth colony",900,0.9);
        RoachColony rc11 = new RoachColony("eleventh colony",900,0.9);
        RoachColony rc12 = new RoachColony("twelveth colony",900,0.9);
        RoachColony rc13 = new RoachColony("thirteenth colony",900,0.9);
        RoachColony rc14 = new RoachColony("fourteenth colony",900,0.9);
        RoachColony rc15 = new RoachColony("fifteenth colony",900,0.9);
        RoachColony rc16 = new RoachColony("sixteenth colony",900,0.9);
        
        System.out.println("Time to clean the rooms today");
        rm.cleanRooms();
        
        System.out.println(rc3 + " checking out...");
        cost = rm.checkOut(r3,3, "RoachPay");
        System.out.println("cost:" + cost);
        
        System.out.println(rc9 + " checking in...");
        Room r9 = rm.checkIn(rc9,"Regular",amenities2);
        
        System.out.println(rc10 + " checking in...");
        Room r10 = rm.checkIn(rc10,"Regular",amenities2);
        
        System.out.println(rc11 + " checking in...");
        Room r11 = rm.checkIn(rc11,"Regular",amenities2);
        
        System.out.println(rc12 + " checking in...");
        Room r12 = rm.checkIn(rc12,"Regular",amenities2);
        
        System.out.println(rc13 + " checking in...");
        Room r13 = rm.checkIn(rc13,"Regular",amenities2);
        
        System.out.println(rc14 + " checking in...");
        Room r14 = rm.checkIn(rc14,"Regular",amenities2);
        
        System.out.println(rc15 + " checking in...");
        Room r15 = rm.checkIn(rc15,"Regular",amenities2);
        
        System.out.println(rc16 + " checking in...");
        Room r16 = rm.checkIn(rc16,"Regular",amenities2);
        
        System.out.println("Time to clean the rooms today"+ rm);
        rm.cleanRooms();
        
        System.out.println(rc9 + " checking out...\n");
        cost = rm.checkOut(r9,3, "RoachPal");
        
        System.out.println(rc10 + " checking out...\n");
        cost = rm.checkOut(r10,3, "RoachPal");
        
        System.out.println(rc4 + " checking out...\n");
        cost = rm.checkOut(r4,3, "RoachPal");
        
        System.out.println(rc5 + " checking out...\n");
        cost = rm.checkOut(r5,3, "RoachPal");
        
        System.out.println(rc6 + " checking out...\n");
        cost = rm.checkOut(r6,3, "RoachPal");

        System.out.println("Transaction Log");
        rm.readTransactionLog();
	}

}
