package com.srk.swt.controller;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.beans.typed.PojoProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;

import com.srk.swt.model.Name;
import com.srk.swt.view.SrkDataBinding;

public class SrkDataBindingController {
    private SrkDataBinding m_srkDataBinding;
    private DataBindingContext m_bindingContext;
    private com.srk.swt.model.SrkByte srkByte = new com.srk.swt.model.SrkByte();

    private com.srk.swt.model.Name name = new com.srk.swt.model.Name();
    
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
	IObservableValue<Boolean> bit0ObserveWidget = WidgetProperties.buttonSelection().observe(m_srkDataBinding.getBit0Button());
	IObservableValue<Boolean> bit0ObserveValue = BeanProperties.value("bit0",Boolean.class).observe(srkByte);
	IObservableValue<Boolean> bit1ObserveWidget = WidgetProperties.buttonSelection().observe(m_srkDataBinding.getBit1Button());
	IObservableValue<Boolean> bit1ObserveValue = BeanProperties.value("bit1",Boolean.class).observe(srkByte);
	IObservableValue<Boolean> bit2ObserveWidget = WidgetProperties.buttonSelection().observe(m_srkDataBinding.getBit2Button());
	IObservableValue<Boolean> bit2ObserveValue = BeanProperties.value("bit2",Boolean.class).observe(srkByte);
	IObservableValue<Boolean> bit3ObserveWidget = WidgetProperties.buttonSelection().observe(m_srkDataBinding.getBit3Button());
	IObservableValue<Boolean> bit3ObserveValue = BeanProperties.value("bit3",Boolean.class).observe(srkByte);

	
	IObservableValue<String> properyChanged = PojoProperties.value("name",String.class).observe(name);
	
	properyChanged.addValueChangeListener(new IValueChangeListener<String>() {

	    @Override
	    public void handleValueChange(ValueChangeEvent<? extends String> arg0) {
		System.out.println("Name value Changed");
		
	    }
	});
	
	properyChanged.setValue("Test");
	
	bit0ObserveWidget.addValueChangeListener(new IValueChangeListener<Boolean>() {

	    @Override
	    public void handleValueChange(ValueChangeEvent<? extends Boolean> arg0) {
		System.out.println("Value Changed");
	    }
	});
	
	DataBindingContext bindingContext = new DataBindingContext();

	bindingContext.bindValue(bit0ObserveWidget, bit0ObserveValue, null, null);
	bindingContext.bindValue(bit1ObserveWidget, bit1ObserveValue, null, null);
	bindingContext.bindValue(bit2ObserveWidget, bit2ObserveValue, null, null);
	bindingContext.bindValue(bit3ObserveWidget, bit3ObserveValue, null, null);
		
	
	return bindingContext;
    }

    public com.srk.swt.model.SrkByte getSrkByte() {
	return srkByte;
    }
    public Name getName() {
	return name;
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