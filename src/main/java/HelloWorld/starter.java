package HelloWorld;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.Encoder;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class starter {
	String seek = "false";
	PlaySound player = new PlaySound();

	public static void main(String[] args) {
		starter s = new starter();

		s.Kies();
//		
//		String bip = "src/main/resources/Snollebollekes-Snollebolleke.mp3";
//		String file = new File(bip).toURI().toString();
//		s.player.play(file);
//		
//		
//		JFrame frame = new JFrame();
//		frame.setSize(800, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);

	}

	JTextField SongName;
	DefaultListModel<String> list;

	JList<String> result;

	JButton submitButton = new JButton("Zoeken...");

	public void Kies() {
		{

			JFrame frame = new JFrame("Search in database");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// Create fields for I/O
			SongName = new JTextField(10);
			list = new DefaultListModel<>();
			result = new JList<>(list);

			result.setBounds(100, 100, 75, 75);

			// Add labelled input fields to display
			JPanel inFieldPane = new JPanel();
			inFieldPane.setLayout(new GridLayout(2, 2));
			inFieldPane.add(new JLabel("Give Song Name"));
			inFieldPane.add(SongName);

			frame.add(inFieldPane, BorderLayout.NORTH);
			// Add submission button
			JPanel submitPane = new JPanel();
			submitPane.setLayout(new FlowLayout());
			submitPane.add(new JLabel("Press Button to Search"));

			submitPane.add(submitButton);

			// Add Output fields
			JPanel outFieldPane = new JPanel();
			outFieldPane.add(new JLabel("Results"));
			outFieldPane.add(new JScrollPane(result));
			outFieldPane.add(new JLabel("             "));

			outFieldPane.setSize(200, 204);
			frame.add(outFieldPane);
			frame.add(submitPane, BorderLayout.SOUTH);

			frame.pack();
			frame.setSize(400, 600);
			frame.setVisible(true);
			submitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						list.removeAllElements();
						String NoData = "Geen zoek resultaten, probeer iets anders";
						String fullString = SongName.getText().trim();

						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamusic", "root", "");

						PreparedStatement s = c.prepareStatement("SELECT t.Name from Tracks t where t.Name like ? '%'");
						s.setString(1, fullString);
						s.execute();
						ResultSet r = s.getResultSet();

						while (r.next()) {
							
							list.addElement(r.getString("Name"));
						}
						if (list.size() == 0) {

							list.addElement(NoData);
						}
					} catch (SQLException i) {

						System.err.println("Sorry, Er is een fout met de Database!");
						i.printStackTrace();
					}
				}
			});

			result.addMouseListener(new MouseAdapter() {
				String link;
				String img;

				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						try {

							String Values = result.getSelectedValue();

							Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamusic", "root",
									"");

							PreparedStatement s = c.prepareStatement("SELECT t.Link from Tracks t where t.Name = ?");

							s.setString(1, Values);
							s.execute();
							ResultSet r = s.getResultSet();
							while (r.next()) {
								link = r.getString("Link");
							}
							PreparedStatement k = c.prepareStatement("SELECT t.img from Tracks t where t.Name = ?");

							k.setString(1, Values);
							k.execute();
							ResultSet r2 = k.getResultSet();
							while (r2.next()) {
								img = r2.getString("img");
							}

						} catch (SQLException h) {

							System.err.println("Sorry, Er is een fout met de Database!");
							h.printStackTrace();
						}
						try {
							String bip = link;
							String file = new File(bip).toURI().toString();
							player.play(file);

							frame.setVisible(false);
							JFrame frame2 = new JFrame();
							JPanel playPause = new JPanel();
							JPanel imgPanel = new JPanel();
							frame2.getContentPane().setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));
							JButton pause = new JButton("Pause");
							JButton play = new JButton("Play");
							pause.setBackground(Color.orange);
							play.setBackground(Color.orange);
							playPause.add(pause);
							playPause.add(play);
							frame2.add(playPause);
							BufferedImage myPicture = ImageIO.read(new File(img));
							JLabel picLabel = new JLabel(new ImageIcon(myPicture));
							picLabel.setSize(new Dimension(500,500));
							imgPanel.add(picLabel);
							frame2.add(imgPanel);
							playPause.setBackground(Color.BLACK);
							imgPanel.setBackground(Color.BLACK);
							pause.addMouseListener(new MouseAdapter() {

								public void mouseClicked(MouseEvent e) {

									player.mediaPlayer.pause();
								}
							});
							play.addMouseListener(new MouseAdapter() {

								public void mouseClicked(MouseEvent e) {

									player.mediaPlayer.play();
								}
							});

							JSlider scroll = new JSlider();
							playPause.add(scroll);
							JSlider scroll2 = new JSlider();
							scroll.setBackground(Color.orange);
							scroll2.setBackground(Color.orange);
							JLabel scroll2label = new JLabel("Doorspoelen");
							scroll2label.setForeground(Color.white);
							playPause.add(scroll2label);
							playPause.add(scroll2);

							JLabel timeCur = new JLabel("0.0");
							timeCur.setForeground(Color.white);
							playPause.add(timeCur);
							player.mediaPlayer.setOnReady(new Runnable() {
								@Override

								public void run() {

									Duration duration = player.mediaPlayer.getTotalDuration();
									double dur = duration.toSeconds();
									double start = player.mediaPlayer.getStartTime().toSeconds();
									scroll.setValue((int) start);
									scroll.setMaximum((int) dur);
									scroll2.setValue((int) start);
									scroll2.setMaximum((int) dur);
									scroll2.addChangeListener(new ChangeListener() {
										public void stateChanged(ChangeEvent event) {
											int value = scroll2.getValue();
											
											new Thread(() -> player.mediaPlayer.seek(Duration.seconds(value))).start();

										}
									});

									boolean playing = player.mediaPlayer.getStatus().equals(Status.READY);
									System.out.println(playing);
									while (playing == true) {

										Duration time = player.mediaPlayer.getCurrentTime();
										String timeCurrent = String.format("%4d:%02d:%04.1f", (int) time.toHours(),
												(int) time.toMinutes() % 60, time.toSeconds() % 3600);

										scroll.setValue((int) time.toSeconds());
										timeCur.setText(timeCurrent);
									}

								}
							});

							frame2.setSize(800, 800);
							frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame2.setVisible(true);

						} catch (Exception y) {

							System.err.println("Sorry, Er is een fout met de mediaplayer!");
							y.printStackTrace();
						}

					}
				}
			});
		}
	}

}
