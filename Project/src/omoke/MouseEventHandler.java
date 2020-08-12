package omoke;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter{
	private Map map;
	private MapSize ms;
	private DrawBoard d;
	private GUI main;
	
	public MouseEventHandler(Map m, MapSize ms, DrawBoard d, GUI main) {
		map=m;
		this.ms=ms;
		this.d=d;
		this.main=main;
	}
	@Override
	public void mousePressed(MouseEvent args0) {
		super.mousePressed(args0);
		int x=(int)Math.round(args0.getX() / (double) ms.getCell())-1;
		int y=(int)Math.round(args0.getY()/ (double) ms.getCell())-2;
		if(x<0 || x>19 ||y<0 ||y>19) {
			return;
		}
		if(map.getXY(y,x)==map.getBLACK()||map.getXY(y, x)==map.getWHITE()) {
			return;
		}
		
		System.out.println(x+" "+y);
		map.setMap(y, x);
		map.changeCheck();
		((Component) d).repaint();
		if(map.winCheck(x, y)) {
			if(map.getCheck()==true) {
				main.showPopUp("백돌이 승리하였습니다");
			}else {
				main.showPopUp("흑돌이 승리하였습니다");
			}
		}
	}
}
