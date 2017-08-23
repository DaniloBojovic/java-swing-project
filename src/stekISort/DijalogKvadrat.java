package stekISort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DijalogKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtX;
	protected JTextField txtY;
	protected JTextField txtDuzinaStranice;
	protected String koordinataX;
	protected String koordinataY;
	protected String duzinaStr;
	protected String bojaIvice;
	protected String bojaUnutrasnjosti;
	protected JComboBox<String> cmbBojaIvice;
	protected JComboBox<String> cmbBojaUnutrasnjosti;
	protected JButton btnPotvrdi;
	public JButton btnPonisti;
	boolean pogresan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrat dialog = new DijalogKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKvadrat() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setTitle("Kvadrat");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblX = new JLabel("X koordinata ta\u010Dke gore levo:");
		lblX.setBounds(30, 25, 170, 20);
		contentPanel.add(lblX);
		
		JLabel lblY = new JLabel("Y koordinata ta\u010Dke gore levo:");
		lblY.setBounds(30, 61, 170, 20);
		contentPanel.add(lblY);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice");
		lblDuzinaStranice.setBounds(30, 96, 140, 20);
		contentPanel.add(lblDuzinaStranice);
		
		txtX = new JTextField();
		txtX.setBounds(210, 25, 100, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setBounds(210, 61, 100, 20);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setBounds(210, 96, 100, 20);
		contentPanel.add(txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice");
		lblBojaIvice.setBounds(30, 138, 140, 20);
		contentPanel.add(lblBojaIvice);
		
		cmbBojaIvice = new JComboBox<String>();
		cmbBojaIvice.setModel(new DefaultComboBoxModel<>(new String[] {"Crna", "Crvena", 
				"Bela", "Zuta", "Plava", "Zelena", "Pink" }));
		cmbBojaIvice.setBounds(210, 138, 100, 20);
		contentPanel.add(cmbBojaIvice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti");
		lblBojaUnutrasnjosti.setBounds(30, 169, 140, 20);
		contentPanel.add(lblBojaUnutrasnjosti);
		
		cmbBojaUnutrasnjosti = new JComboBox<String>();
		cmbBojaUnutrasnjosti.setModel(new DefaultComboBoxModel<>(new String[] {"Crna", "Crvena", 
				"Bela", "Zuta", "Plava", "Zelena", "Pink" }));
		cmbBojaUnutrasnjosti.setBounds(210, 169, 100, 20);
		contentPanel.add(cmbBojaUnutrasnjosti);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
						koordinataX = txtX.getText();
						koordinataY = txtY.getText();
						duzinaStr = txtDuzinaStranice.getText();
						bojaIvice = cmbBojaIvice.getSelectedItem().toString();
						bojaUnutrasnjosti = cmbBojaUnutrasnjosti.getSelectedItem().toString();
						pogresan = false;
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(getParent(), "Neispravni brojevi", "Greska", ERROR);
						}
						if(koordinataX.length() > 0 || koordinataY.length() > 0 || duzinaStr.length() > 0){
							try{
								Integer.parseInt(koordinataX);
								Integer.parseInt(koordinataY);
								Integer.parseInt(duzinaStr);
							}catch (Exception ex) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, "Neispravni brojevi");
								txtX.requestFocus();
								txtX.setText("");
								txtY.setText("");
								txtDuzinaStranice.setText("");
								pogresan = true;
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Niste popunili sva polja");
						}
						if(pogresan == false){
							setVisible(false);
						}
					}
					
				});				
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				btnPonisti = new JButton("Poni\u0161ti");
				btnPonisti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnPonisti.setActionCommand("Cancel");
				buttonPane.add(btnPonisti);
			}
		}
	}
}
