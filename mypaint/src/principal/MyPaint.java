package principal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPaint extends JFrame {

	private static final long serialVersionUID = 9090561553377008406L;

	public static void main(String[] args) {
		new MyPaint();
	}

	public MyPaint() {
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout(new BorderLayout());

		BarraDeFerramentas barraDeFerramentas = new BarraDeFerramentas().inicializaBarraDeFerramenta(painelPrincipal);

		AreaDeDesenho areaDeDesenho = new AreaDeDesenho();
		painelPrincipal.add(areaDeDesenho, BorderLayout.CENTER);

		GerenciadorDeEventos gerenciador = new GerenciadorDeEventos(areaDeDesenho, barraDeFerramentas);
		areaDeDesenho.addMouseListener(gerenciador);
		areaDeDesenho.addMouseMotionListener(gerenciador);

		this.setContentPane(painelPrincipal);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
