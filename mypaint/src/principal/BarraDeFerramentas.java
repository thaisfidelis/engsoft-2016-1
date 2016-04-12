package principal;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarraDeFerramentas extends JToolBar {

	private static final long serialVersionUID = -8292143412476774295L;

	ButtonGroup grupo;
	private Ferramenta ferramenta;

	public BarraDeFerramentas() {
		super("Barra de Ferramentas");
		this.grupo = new ButtonGroup();

		Ferramenta[] ferramentas = new Ferramenta[] {
				new FerramentaRetangulo(this), new FerramentaElipse(this),
				new FerramentaLinha(this) };
		for (Ferramenta f : ferramentas) {
			criarBotao(f);
		}
		this.setFloatable(false);
	}

	private JToggleButton criarBotao(Ferramenta ferramenta) {
		JToggleButton botao = new JToggleButton(ferramenta.getNome());
		botao.addActionListener(ferramenta);
		grupo.add(botao);
		this.add(botao);
		if (ferramenta.ehFerramentaPadrao()) {
			botao.getModel().setPressed(true);
			this.ferramenta = ferramenta;
		}
		return botao;
	}

	public Ferramenta leFerramentaSelecionada() {
		return this.ferramenta;
	}

	public void setFerramentaAtiva(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}

	public BarraDeFerramentas inicializaBarraDeFerramenta(JPanel painelPrincipal) {
		painelPrincipal.add(this, BorderLayout.PAGE_START);
		return this;
	}

}
