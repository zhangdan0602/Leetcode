package code20180118_OXGame;
import javax.swing.JApplet;

@SuppressWarnings("serial")
public class Applet_Game extends JApplet
{
	public void init()
	{
		add(new PlayBoard());
	}
}

