package br.com.knight.estoque.adaptador;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author rogerio
 *
 */
public class AdaptadorDate extends XmlAdapter<XMLGregorianCalendar, Date> {

	@Override
	public Date unmarshal(XMLGregorianCalendar v) throws Exception {
		return v.toGregorianCalendar().getTime();
	}

	@Override
	public XMLGregorianCalendar marshal(Date date) throws Exception {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
				.newInstance().newXMLGregorianCalendar(calendar);
		xmlGregorianCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
		xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		return xmlGregorianCalendar;
	}


}
