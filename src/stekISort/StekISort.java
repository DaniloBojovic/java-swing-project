package stekISort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class StekISort extends JFrame {

	private JPanel contentPane;
	static DefaultListModel<Kvadrat> listaKvadrat = new DefaultListModel<>();
	public JButton btnDodavanje;
	public JButton btnIzuzimanje;
	/**
	 * Launch the application.
	 */
	/**
	 * @param args
	 */

	/**
	 * Create the frame.
	 */
	public StekISort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnDodavanje = new JButton("Dodavanje");
		btnDodavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DijalogKvadrat dijalogKv = new DijalogKvadrat();
				dijalogKv.setVisible(true);
				try{
				Kvadrat kv = new Kvadrat(new Tacka(Integer.parseInt(dijalogKv.koordinataX), 
						Integer.parseInt(dijalogKv.koordinataY)), 
						Integer.parseInt(dijalogKv.duzinaStr),
						dijalogKv.bojaUnutrasnjosti, dijalogKv.bojaIvice);
				listaKvadrat.add(0, kv);
				}catch (NumberFormatException exc) {
					
				}				
			}
		});
		btnDodavanje.setBounds(85, 30, 100, 30);
		contentPane.add(btnDodavanje);
		
		btnIzuzimanje = new JButton("Izuzimanje");
		btnIzuzimanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				DijalogKvadrat dijalogKv = new DijalogKvadrat();
				dijalogKv.txtX.setEditable(false);
				dijalogKv.txtY.setEditable(false);
				dijalogKv.txtDuzinaStranice.setEditable(false);
				dijalogKv.cmbBojaIvice.setEnabled(false);
				dijalogKv.cmbBojaUnutrasnjosti.setEnabled(false);
				
				if(listaKvadrat.isEmpty()){
					JOptionPane.showMessageDialog(null, "Lista je prazna", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					dijalogKv.txtX.setText(String.valueOf(listaKvadrat.getElementAt(0).getGoreLevo().getX()));
					dijalogKv.txtY.setText(String.valueOf(listaKvadrat.getElementAt(0).getGoreLevo().getY()));
					dijalogKv.txtDuzinaStranice.setText(String.valueOf(listaKvadrat.getElementAt(0).getDuzinaStranice()));
					dijalogKv.cmbBojaIvice.setSelectedItem(listaKvadrat.getElementAt(0).getBojaIvice());
					dijalogKv.cmbBojaUnutrasnjosti.setSelectedItem(listaKvadrat.getElementAt(0).getBojaUnutrasnjosti());
					dijalogKv.setVisible(true);
					listaKvadrat.remove(0);
				}
			}
		});
		btnIzuzimanje.setBounds(325, 30, 100, 30);
		contentPane.add(btnIzuzimanje);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 76, 340, 250);
		contentPane.add(scrollPane);
		scrollPane.setSize(340,250);
		JList lista = new JList();
		scrollPane.setViewportView(lista);
		lista.setModel(listaKvadrat);
		
		JButton btnSortiranje = new JButton("Sortiranje");
		btnSortiranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaKvadrat.isEmpty()){
					JOptionPane.showMessageDialog(null, "Lista je prazna", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					//pravim array arrKvadrat velicine kvadratListe
					Object[] arrKvadrat = new Object[listaKvadrat.getSize()];
					listaKvadrat.copyInto(arrKvadrat);
					Arrays.sort(arrKvadrat);
					//brisem sve elemente iz listaKvadrat
					listaKvadrat.removeAllElements();
					//ponovo ih dodajem
					for(Object o: arrKvadrat){
						listaKvadrat.addElement((Kvadrat) o);	
					}
				}
			}
		});
		btnSortiranje.setBounds(205, 30, 100, 30);
		contentPane.add(btnSortiranje);
	}
}
