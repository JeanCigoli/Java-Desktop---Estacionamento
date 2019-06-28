package br.senai.sp.app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.senai.sp.dao.UsuarioDAO;
import br.senai.sp.model.Usuario;
import br.senai.sp.view.FrmLogin;
import br.senai.sp.view.FrmPrincipal;

public class AppEstacionamento {

	public static void main(String[] args) {
		
		try {
            //	Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(
//			UIManager.getCrossPlatformLookAndFeelClassName());
        	UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }

		 UIManager.put("OptionPane.yesButtonText", "Sim");
		 UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		 UIManager.put("OptionPane.noButtonText", "Não");
		 UIManager.put("OptionPane.okButtonText", "Ok");
		 
		 FrmLogin login = new FrmLogin();

	}

}
