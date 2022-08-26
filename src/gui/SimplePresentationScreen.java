package gui;

import java.awt.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import entities.Student;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private GroupLayout layout;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		Image icon = Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png"));
		setIconImage(icon);

		init();
	}

	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));

		//Foto de aiba
		JLabel LFoto = new JLabel("");
		LFoto.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));




		//Creamos los Labels
		JLabel LLU = new JLabel("LU");
		JLabel LApellido = new JLabel("Apellido");
		JLabel Lnombre = new JLabel("Nombre");
		JLabel LMail = new JLabel("E-mail");
		JLabel LGit = new JLabel("Github URL");

		//Label que muestra la fecha y hora
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
		JLabel LFecha = new JLabel("Esta ventana fue generada el "+ dtf.format(now)+" a las "+dtf2.format(now));



		//Creamos los TextField
		JTextField TLU = new JTextField(16);
		JTextField TApellido = new JTextField(16);
		JTextField TNombre = new JTextField(16);
		JTextField TMail = new JTextField(16);
		JTextField TGit = new JTextField(16);
		TLU.setText(Integer.toString(studentData.getId()));
		TApellido.setText(studentData.getLastName());
		TNombre.setText(studentData.getFirstName());
		TMail.setText(studentData.getMail());
		TGit.setText(studentData.getGithubURL());


		//Creamos el group Layout
		layout = new GroupLayout(tabInformation);
		tabInformation.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//
		layout.setHorizontalGroup(
				layout.createSequentialGroup()

						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(LLU)
								.addComponent(LApellido)
								.addComponent(Lnombre)
								.addComponent(LMail)
								.addComponent(LGit)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(TLU)
								.addComponent(TApellido)
								.addComponent(TNombre)
								.addComponent(TMail)
								.addComponent(TGit)
						)



		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(LLU)
								.addComponent(TLU)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(LApellido)
								.addComponent(TApellido)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(Lnombre)
								.addComponent(TNombre)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(LMail)
								.addComponent(TMail)
						)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(LGit)
								.addComponent(TGit)
						)

		);


		//Agregamos todos los componentes a sus paneles correspondientes
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		contentPane.add(LFoto, BorderLayout.EAST);
		contentPane.add(LFecha, BorderLayout.SOUTH);
		setVisible(true);
	}
}
