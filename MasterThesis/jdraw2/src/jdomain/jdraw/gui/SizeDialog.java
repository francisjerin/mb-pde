package jdomain.jdraw.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jdomain.util.gui.WidgetFactory;

/*
 * SizeDialog.java - created on 30.10.2003
 * 
 * @author Michaela Behling
 */

public class SizeDialog extends DrawDialog implements DocumentListener {

	/** */
   private static final long serialVersionUID = 1L;
   private static final int MAX_WIDTH = 1024;
	private static final int MAX_HEIGHT = 768;

	private Dimension dim = Tool.getPictureDimension();

	private final JTextField widthField =
		new JTextField(String.valueOf(dim.width), 4);

	private final JTextField heightField =
		new JTextField(String.valueOf(dim.height), 4);

	public SizeDialog() {
		super("Please enter image size:");

		WidgetFactory.addFocusAdapter(widthField);
		WidgetFactory.addFocusAdapter(heightField);
		setDefaultBorder();
		setModal(true);
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		widthField.getDocument().addDocumentListener(this);
		heightField.getDocument().addDocumentListener(this);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.insets = new Insets(0, 2, 2, 2);
		gc.gridwidth = 2;
		JLabel text = new JLabel("<html><b>Please enter image size:</b></html>");
		text.setBorder(new EmptyBorder(0, 0, 10, 0));
		p.add(text, gc);

		gc.gridwidth = 1;
		gc.gridy++;
		JLabel l = new JLabel("Width: ");
		p.add(l, gc);

		gc.gridx++;
		p.add(widthField, gc);

		gc.gridx = 0;
		gc.gridy++;
		l = new JLabel("Height: ");
		p.add(l, gc);

		gc.gridx++;
		p.add(heightField, gc);
		
		main.add(p, BorderLayout.CENTER);

		addRightButton(getApproveButton());
		getRootPane().setDefaultButton(getApproveButton());

		addRightButton(getCancelButton());
		addButtonPanel();

		setFirstFocusComponent(widthField);
	}

	public Dimension getInput() {
		return dim;
	}

	private void checkInput() {
		boolean isValid = true;
		try {
			dim.width = Integer.parseInt(widthField.getText().trim());
			dim.height = Integer.parseInt(heightField.getText().trim());

			isValid =
				(dim.width > 0)
					&& (dim.height > 0)
					&& (dim.width < MAX_WIDTH)
					&& (dim.height < MAX_HEIGHT);
		}
		catch (NumberFormatException e) {
			isValid = false;
		}
		getApproveButton().setEnabled(isValid);
	}

	public void changedUpdate(DocumentEvent e) {
		checkInput();
	}

	public void insertUpdate(DocumentEvent e) {
		checkInput();
	}

	public void removeUpdate(DocumentEvent e) {
		checkInput();
	}

}
