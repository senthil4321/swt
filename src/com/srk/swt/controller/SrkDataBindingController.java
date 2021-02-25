package com.srk.swt.controller;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;

import com.srk.swt.view.SrkDataBinding;

public class SrkDataBindingController {
	private SrkDataBinding m_srkDataBinding;
	private DataBindingContext m_bindingContext;
	private com.srk.swt.model.SrkByte srkByte = new com.srk.swt.model.SrkByte();

	public SrkDataBindingController(SrkDataBinding srkDataBinding, com.srk.swt.model.SrkByte newSrkByte) {
		m_srkDataBinding = srkDataBinding;
		setSrkByte(newSrkByte);
	}

	public SrkDataBindingController(SrkDataBinding srkDataBinding) {
		m_srkDataBinding = srkDataBinding;
		if (srkByte != null) {
			m_bindingContext = initDataBindings();
		}
	}

	private DataBindingContext initDataBindings() {
		IObservableValue bit0ObserveWidget = WidgetProperties.buttonSelection()
				.observe(m_srkDataBinding.getBit0Button());
		IObservableValue bit0ObserveValue = BeanProperties.value("bit0").observe(srkByte);
		IObservableValue bit1ObserveWidget = WidgetProperties.buttonSelection()
				.observe(m_srkDataBinding.getBit1Button());
		IObservableValue bit1ObserveValue = BeanProperties.value("bit1").observe(srkByte);
		IObservableValue bit2ObserveWidget = WidgetProperties.buttonSelection()
				.observe(m_srkDataBinding.getBit2Button());
		IObservableValue bit2ObserveValue = BeanProperties.value("bit2").observe(srkByte);
		IObservableValue bit3ObserveWidget = WidgetProperties.buttonSelection()
				.observe(m_srkDataBinding.getBit3Button());
		IObservableValue bit3ObserveValue = BeanProperties.value("bit3").observe(srkByte);

		DataBindingContext bindingContext = new DataBindingContext();
		
		bindingContext.bindValue(bit0ObserveWidget, bit0ObserveValue, null, null);
		bindingContext.bindValue(bit1ObserveWidget, bit1ObserveValue, null, null);
		bindingContext.bindValue(bit2ObserveWidget, bit2ObserveValue, null, null);
		bindingContext.bindValue(bit3ObserveWidget, bit3ObserveValue, null, null);
		//
		return bindingContext;
	}

	public com.srk.swt.model.SrkByte getSrkByte() {
		return srkByte;
	}

	public void setSrkByte(com.srk.swt.model.SrkByte newSrkByte) {
		setSrkByte(newSrkByte, true);
	}

	public void setSrkByte(com.srk.swt.model.SrkByte newSrkByte, boolean update) {
		srkByte = newSrkByte;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (srkByte != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
}