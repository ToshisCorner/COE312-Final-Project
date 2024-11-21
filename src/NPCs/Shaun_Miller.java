package NPCs;

import Default.NPC;
import Supplement.Message;

public class Shaun_Miller extends NPC {
    public Shaun_Miller() {
        super("Shaun Miller", 200, "So, Jack Stone... you've come to the end of your journey.");
    }
    
    @Override
    public void interact() {
        System.out.println("Shaun Miller smirks, his eyes cold and calculating.");
        System.out.println("\"You think you can stop me? This city belongs to me, Stone.\"");
        // Add interaction logic (e.g., branching dialogue, decisions)
    }

	@Override
	public void update(Message m) {
		// TODO Auto-generated method stub
		
	}
}
