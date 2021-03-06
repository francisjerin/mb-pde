package jdomain.jdraw.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/*
 * InfoClip.java - created on 22.11.2003 by J-Domain
 * 
 * @author Michaela Behling
 */

public final class InfoClip extends FloatingClip {

	/** */
   private static final long serialVersionUID = 1L;

   public static final InfoClip INSTANCE = new InfoClip();

	private static final int X_OFFSET = 15;
	private static final int Y_OFFSET = -10;

	private final JLabel info = new JLabel();
	private MouseEvent lastEvent;
	private Point lastViewPoint;

	private InfoClip() {
		super(DrawLayers.INFO_CLIP_LAYER);
		info.setFont(MainFrame.DEFAULT_FONT);
		info.setForeground(Color.white);
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		add(info);
	}

	public String getName() {
		return "Info";
	}

	private Point translate(MouseEvent e) {
		Point p =
			SwingUtilities.convertPoint(
				Tool.getDrawPanel(),
				e.getX(),
				e.getY(),
				MainFrame.INSTANCE.getGlassPane());				
		return p;
	}

	private String getInfo(MouseEvent e) {
		StringBuffer buf = new StringBuffer();
		Point p = Tool.getRealPixel(e);
		if (p == null) {
			return "";
		}
		buf.append(p.x);
		buf.append(",");
		buf.append(p.y);
		return buf.toString();
	}

	private void updateInfo(MouseEvent e) {
		info.setText(getInfo(e));
		Dimension dim = getPreferredSize();
		Point p = translate(e);		
		int x = p.x + X_OFFSET;
		int y = p.y + Y_OFFSET;
		
		defineClip(x, y, dim.width, dim.height);
	}

	public Integer getLayer() {
		return super.getLayer();
	}
	

	public void mouseDragged(MouseEvent e) {
		deactivate();		
		//updateInfo(e);
	}

	public void mouseEntered(MouseEvent e) {
		updateInfo(e);
	}

	public void mouseExited(MouseEvent e) {
		deactivate();
		lastEvent = null;
	}

	public void mouseMoved(MouseEvent e) {
		updateInfo(e);
		lastEvent = e;
		lastViewPoint = Tool.getViewPoint();
	}

	public void mousePressed(MouseEvent e) {
		deactivate();
		//updateInfo(e);
	}


	public final void paint(Graphics g) {
		if (isActive()) {
			g.setXORMode(Color.black);
			super.paint(g);			
			g.setPaintMode();	
		}
	}

	protected void repeat() {
		if (lastEvent != null) {
			Point p = Tool.getViewPoint();
			int xDiff = p.x - lastViewPoint.x;
			int yDiff = p.y - lastViewPoint.y;
			lastEvent.translatePoint(xDiff, yDiff);
			mouseMoved(lastEvent);
		}
	}

	public void mouseReleased(MouseEvent e) {
		updateInfo(e);
	}

}
