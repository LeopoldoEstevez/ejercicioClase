package zEjerEntregar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class E00ListEle extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRuta;
	private JList<String> listFiles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E00ListEle frame = new E00ListEle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public E00ListEle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelLista = new JPanel();
		contentPane.add(panelLista, BorderLayout.NORTH);
		
		JLabel lblInserteRuta = new JLabel("Insertar ruta : ");
		panelLista.add(lblInserteRuta);
		
		txtRuta = new JTextField();
		txtRuta.setText("");
		panelLista.add(txtRuta);
		txtRuta.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listar();
			}
		});
		panelLista.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		listFiles = new JList<String>();
		scrollPane.setViewportView(listFiles);
		

	}
	
	public void listar(){
		DefaultListModel<String> dlm = new DefaultListModel<String>();
	    File o = new File(txtRuta.getText());

	    File[] yourFileList = o.listFiles();
	    for(File f : yourFileList) {
	        dlm.addElement(f.getName());
	    }
	    listFiles.setModel(dlm);
	}
}
