package principal;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import figuras.Figura;

public class GerenciadorDeEventos extends MouseAdapter {

	private AreaDeDesenho area;

	private int x1 = 0;
	private int y1 = 0;
	private Ferramenta ferramenta;

	public GerenciadorDeEventos(AreaDeDesenho area) {
		this.area = area;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public void limpaAreaDeDesenho() {
		// TODO: limpar a área de desenho e chamar repaint
		this.area.limpa();
		this.area.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Figura f = ferramenta.criaFigura(x1, y1, e.getX(), e.getY());
		this.area.setSombra(f);
		this.area.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
