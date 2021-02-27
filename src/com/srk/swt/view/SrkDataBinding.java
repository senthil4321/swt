package com.srk.swt.view;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.srk.swt.controller.SrkDataBindingController;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.core.databinding.Binding;

public class SrkDataBinding extends Shell {

	private SrkDataBindingController m_controller;
	private Button bit0Button;
	private Button bit1Button;
	private Button bit2Button;
	private Button bit3Button;
	private Button btnNewButton;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		Display display = new Display();
		Realm.runWithDefault(DisplayRealm.getRealm(display), new Runnable() {
			public void run() {
				try {
					Display display = Display.getDefault();
					SrkDataBinding shell = new SrkDataBinding(display, SWT.SHELL_TRIM);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the shell.
	 * @param display
	 * @param style
	 */
	public SrkDataBinding(Display display, int style) {
		super(display, style);
		createContents();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("Bit0:");

		bit0Button = new Button(this, SWT.CHECK);
		bit0Button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Bit1:");

		bit1Button = new Button(this, SWT.CHECK);
		bit1Button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Bit2:");

		bit2Button = new Button(this, SWT.CHECK);
		bit2Button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Bit3:");

		bit3Button = new Button(this, SWT.CHECK);
		bit3Button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    m_controller.getSrkByte().setBit0(false);
			}
		});
		btnNewButton.setText("Update Model");
		
		m_controller = new SrkDataBindingController(this);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Button getBit0Button() {
		return bit0Button;
	}

	public Button getBit1Button() {
		return bit1Button;
	}

	public Button getBit2Button() {
		return bit2Button;
	}

	public Button getBit3Button() {
		return bit3Button;
	}

}
