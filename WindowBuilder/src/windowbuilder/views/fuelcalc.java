package windowbuilder.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class fuelcalc extends JFrame {

	private JPanel contentPane;
	private JButton btCalculate;
	private JLabel lbDistance;
	private JLabel lbCost;
	private JTextField txtDistance;
	private JTextField txtCost;
	private JLabel lbFinalCost;
	private JTextField txtLitres;
	private JTextField kmOption2;
	private JLabel lblNewLabel;
	private JTextField tbFinalCost;
	private JLabel label;
	private JLabel label_1;
	private JLabel lbOpt2;
	private JTextField txtSecondLitres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fuelcalc frame = new fuelcalc();
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
	public fuelcalc() {

		initComponents();
		

	}

	private void initComponents() {
		setTitle(
				"\u0413\u043E\u0440\u0438\u0432\u0435\u043D \u041A\u0430\u043B\u043A\u0443\u043B\u0430\u0442\u043E\u0440");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(fuelcalc.class.getResource("/windowbuilder/Resources/calculator.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		btCalculate = new JButton(
				"\u041F\u0440\u0435\u0441\u043C\u0435\u0442\u043D\u0435\u0442\u0435 \u0440\u0430\u0437\u0445\u043E\u0434\u0430 \u043D\u0430 \u0432\u0430\u0448\u0435\u0442\u043E \u043F\u044A\u0442\u0443\u0432\u0430\u043D\u0435");

		btCalculate.setIcon(new ImageIcon(fuelcalc.class.getResource("/windowbuilder/Resources/calculatorButton.png")));

		lbDistance = new JLabel(
				"\u0412\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u0440\u0430\u0437\u0441\u0442\u043E\u044F\u043D\u0438\u0435\u0442\u043E \u043D\u0430 \u043F\u044A\u0442\u0443\u0432\u0430\u043D\u0435\u0442\u043E: ");

		lbCost = new JLabel(
				"\u0412\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u0446\u0435\u043D\u0430 \u043D\u0430 \u0431\u0435\u043D\u0437\u0438\u043D\u0430: ");

		txtDistance = new JTextField();
		txtDistance.setColumns(10);

		txtCost = new JTextField();
		txtCost.setColumns(10);

		lbFinalCost = new JLabel(
				"\u0426\u0435\u043D\u0430 \u043D\u0430 \u0432\u0430\u0448\u0435\u0442\u043E \u043F\u044A\u0442\u0443\u0432\u0430\u043D\u0435:");
		String[] comboComponents = { "Въведете колко литра на сто харчи вашият автомобил",
				"Въведете колко литра за колко километра е изхарчил вашият автомобил" };
		JComboBox comboBox = new JComboBox(comboComponents);
		int comboBoxState = 0;

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent option) {
				if (option.getSource() == comboBox) {
					JComboBox cb = (JComboBox) option.getSource();
					String msg = (String) cb.getSelectedItem();
					if (msg == "Въведете колко литра за колко километра е изхарчил вашият автомобил") {
						txtLitres.setEnabled(false);
						txtSecondLitres.setEnabled(true);
						kmOption2.setEnabled(true);
					} else {
						txtLitres.setEnabled(true);
						txtSecondLitres.setEnabled(false);
						kmOption2.setEnabled(false);
					}

				}
			}
		});
		btCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String comboBoxValue = (String) comboBox.getSelectedItem();
				double distance = Double.parseDouble(txtDistance.getText());
				double cost = Double.parseDouble(txtCost.getText());

				if (comboBoxValue == "Въведете колко литра на сто харчи вашият автомобил") {
					double litres = Double.parseDouble(txtLitres.getText());
					tbFinalCost.setText(Double.toString(distance / 100 * cost * litres));
				} else {
					double distanceSecond = Double.parseDouble(kmOption2.getText());
					double secondLitres = Double.parseDouble(txtSecondLitres.getText());
					tbFinalCost.setText(Double.toString(distance / distanceSecond * cost * secondLitres));
				}
			}
		});

		comboBox.setToolTipText("\u0418\u0437\u0431\u0435\u0440\u0435\u0442\u0435");

		txtLitres = new JTextField();
		txtLitres.setColumns(10);

		kmOption2 = new JTextField();
		kmOption2.setEnabled(false);
		kmOption2.setColumns(10);

		lblNewLabel = new JLabel("km");

		tbFinalCost = new JTextField();
		tbFinalCost.setColumns(10);

		label = new JLabel("\u043B.");

		label_1 = new JLabel("km");

		JLabel label_2 = new JLabel("\u043B\u0432.");

		JLabel label_3 = new JLabel("\u043B\u0432.");

		lbOpt2 = new JLabel(
				"\u0412\u044A\u0432\u0435\u0434\u0435\u0442\u0435 \u043B\u0438\u0442\u0440\u0438/\u043A\u043C: ");

		txtSecondLitres = new JTextField();
		txtSecondLitres.setColumns(10);
		txtSecondLitres.setEnabled(false);

		JLabel label_4 = new JLabel("\u043B.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lbFinalCost, GroupLayout.PREFERRED_SIZE,
																		164, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(tbFinalCost, GroupLayout.PREFERRED_SIZE,
																		52, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 16,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(comboBox, 0, 337, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtLitres,
												GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lbOpt2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtSecondLitres, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 10,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(kmOption2, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_1,
												GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
								.addGap(13).addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btCalculate).addContainerGap(121,
								Short.MAX_VALUE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addComponent(lbCost, GroupLayout.PREFERRED_SIZE, 170,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtCost, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_2)
										.addContainerGap(62, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lbDistance)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtDistance, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel)
						.addContainerGap(117, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLitres, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lbOpt2)
										.addComponent(txtSecondLitres, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
										.addComponent(kmOption2, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(label_1))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lbDistance)
								.addComponent(txtDistance, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGap(3))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lbCost)
								.addComponent(txtCost, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_2)).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btCalculate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFinalCost, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(tbFinalCost, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)).addGap(16)));
		contentPane.setLayout(gl_contentPane);

	}	
}
