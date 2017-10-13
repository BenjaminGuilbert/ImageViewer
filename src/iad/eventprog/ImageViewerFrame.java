package iad.eventprog;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;


public class ImageViewerFrame extends JFrame implements ActionListener, FocusListener, ImageChangedListener {

	JLabel imageName;
	JTextField pathName; 
	JButton previous;
	JButton next;
	ImageViewerBean imageViewer;
	LogImageChanged logImageChanged;
	
	ImageViewerFrame() {
		
		String initPath = "/Users/benjaminguilbert/Pictures/PhotosIAD";
		imageViewer = new ImageViewerBean(initPath);
		add(imageViewer, BorderLayout.CENTER);
		
		JPanel tfPanel = new JPanel(new BorderLayout());	
		
		pathName = new JTextField(initPath);
		tfPanel.add(pathName, BorderLayout.NORTH);
		
		imageName = new JLabel(" ");
		imageName.setBorder(BorderFactory.createLineBorder(Color.RED));
		tfPanel.add(imageName,BorderLayout.SOUTH);

		add(tfPanel, BorderLayout.NORTH);
		
		
		JPanel btnPanel = new JPanel();
		previous = new JButton("<-");
		btnPanel.add(previous);
	
		
		next = new JButton("->");
		btnPanel.add(next);
			
		add(btnPanel, BorderLayout.SOUTH);
		setSize(600, 400);
		
		logImageChanged = new LogImageChanged();
		imageViewer.addImageChangedListener(logImageChanged);
		
		previous.addActionListener(this);
		next.addActionListener(this);
		pathName.addFocusListener(this);
		// add this class as consumer of image changed event
		imageViewer.addImageChangedListener(this);
		
		imageViewer.first();
		
		
	}

	
	public static void main(String args[]) {
		ImageViewerFrame frame = new ImageViewerFrame();
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == previous){
			imageViewer.previous();
		}else if(source == next){
			imageViewer.next();
		}
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		imageViewer.setPathName(pathName.getText());
		imageViewer.first();
	}


	@Override
	public void imageChanged(ImageChangedEvent e) {
		// TODO Auto-generated method stub
		imageName.setText(e.name());
	}
}
