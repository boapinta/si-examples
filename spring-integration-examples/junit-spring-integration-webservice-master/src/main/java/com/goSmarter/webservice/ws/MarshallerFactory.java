package com.goSmarter.webservice.ws;

import javax.xml.bind.JAXBContext;

import net.gosmarter.it.enterprise.data.v1.ObjectFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class MarshallerFactory implements FactoryBean<Jaxb2Marshaller> {

	@Override
	public Jaxb2Marshaller getObject() throws Exception {
//		ClassLoader cl = ObjectFactory.class.getClassLoader();
//		JAXBContext jc = JAXBContext.newInstance("net.gosmarter.it.enterprise.contract.testservice.v1", cl);
		Jaxb2Marshaller x = new Jaxb2Marshaller();
		x.setContextPath("net.gosmarter.it.enterprise.contract.testservice.v1");
		return x;
	}

	@Override
	public Class<Jaxb2Marshaller> getObjectType() {
		return Jaxb2Marshaller.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
