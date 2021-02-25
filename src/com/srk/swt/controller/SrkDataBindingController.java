package com.srk.swt.controller;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;

import com.srk.swt.model.SrkByte;
import com.srk.swt.view.SrkDataBinding;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;


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
		IObservableValue bit0ObserveWidget = SWTObservables.observeSelection(m_srkDataBinding.getBit0Button());
		IObservableValue bit0ObserveValue = BeansObservables.observeValue(srkByte, "bit0");
		IObservableValue bit1ObserveWidget = SWTObservables.observeSelection(m_srkDataBinding.getBit1Button());
		IObservableValue bit1ObserveValue = BeansObservables.observeValue(srkByte, "bit1");
		IObservableValue bit2ObserveWidget = SWTObservables.observeSelection(m_srkDataBinding.getBit2Button());
		IObservableValue bit2ObserveValue = BeansObservables.observeValue(srkByte, "bit2");
		IObservableValue bit3ObserveWidget = SWTObservables.observeSelection(m_srkDataBinding.getBit3Button());
		IObservableValue bit3ObserveValue = BeansObservables.observeValue(srkByte, "bit3");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
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