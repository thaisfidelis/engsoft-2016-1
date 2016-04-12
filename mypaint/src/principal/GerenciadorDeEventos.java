package principal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import figuras.Figura;

public class GerenciadorDeEventos extends MouseAdapter {

	private AreaDeDesenho area;
	private BarraDeFerramentas barraDeFerramentas;

	private int x1 = 0;
	private int y1 = 0;

	public GerenciadorDeEventos(AreaDeDesenho area, BarraDeFerramentas barraDeFerramentas) {
		this.area = area;
		this.barraDeFerramentas = barraDeFerramentas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Ferramenta ferramenta = barraDeFerramentas.leFerramentaSelecionada();
		Figura f = ferramenta.criaFigura(x1, y1, e.getX(), e.getY());
		this.area.setSombra(f);
		this.area.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Ferramenta ferramenta = barraDeFerramentas.leFerramentaSelecionada();
		Figura f = ferramenta.criaFigura(x1, y1, e.getX(), e.getY());
		this.area.adicionaFigura(f);
		this.area.setSombra(null);
		this.area.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x1 = e.getX();
		this.y1 = e.getY();
	}

}
