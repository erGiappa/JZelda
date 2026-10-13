package it.zelda;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class JZelda {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JOptionPane.showMessageDialog(
					null,
					"JZelda è stato avviato correttamente",
					"JZelda",
					JOptionPane.INFORMATION_MESSAGE
					);
		});
		}

	}


