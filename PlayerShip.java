import java.awt.Color;
import java.awt.geom.*;

public class PlayerShip extends Area{
	private Area bod;
	private Area arm1, arm2;
	private Area gun1, gun2;
	
	private int x, y;
	public PlayerShip(int x, int y, Color bodCol) {
		this.x = x;
		this.y = y;
		
		bod = new Area(new RoundRectangle2D.Double((double)x, (double)y, 30.0, 30.0, 3.0, 3.0));
		arm1 = new Area(new Rectangle2D.Double(x+15, y, 30, 10)); 
		arm2 = new Area(new Rectangle2D.Double(x-15, y, 30, 10)); 
		gun1 = new Area(new Rectangle2D.Double(x+25, y, 10, 30));
		gun2 = new Area(new Rectangle2D.Double(x-25, y, 10, 30));
		
		super.add(bod);
		super.add(arm1);
		super.add(arm2);
		super.add(gun1);
		super.add(gun2);
		
	}
}
