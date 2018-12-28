package com.evansnet.FitnessPlan.persistence;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.evansnet.FitnessPlan.Person;

/*	<PERSON>
		<NAME></NAME>
		<GENDER></GENDER>
		<DATEOFBIRTH></DATEOFBIRTH>
		<AGE></AGE>
		<START_WEIGHT></START_WEIGHT>
		<TARGET_WEIGHT></TARGET_WEIGHT>
		<CURRENT_WEIGHT></CURRENT_WEIGHT>
		<UOM_SYSTEM></UOM_SYSTEM>
		<UNITS></UNITS>
		<ACTIVITY_LVL></ACTIVITY_LVL>
		<BMI></BMI>
		<BMR></BMR>
</PERSON>
*/	
@XmlType( propOrder = {"name",
		 "gender",
		 "dateOfBirth",
		 "age",
		 "start_weight",
		 "target_weight",
		 "current_weight",
		 "uom_system",
		 "units",
		 "activity_lvl",
		 "bmi",
		 "bmr"
		 } )
@XmlRootElement(name = "PERSON")
/**
 * Provides classes for marshalling the definition of a person to pesistent storage.
 * @author Dan Evans
 *
 */
public class PersonMarshalling {
	//TODO: TRANSFER THIS STUFF TO THE PERSON CLASS. You could leave the actual marshalling method.
	public static Logger marshallLogger = Logger.getLogger(PersonMarshalling.class.getName());
	String name;
	String gender;
	Date dateOfBirth;
	int  age;
	double startWgt;
	double targetWgt;
	double currentWgt;
	String uom_system;
	String units;
	String activity_lvl;
	double bmi;
	double bmr;

	@XmlElement (name = "NAME")
	public void setName(String n) {
		name = n;
	}
	
	@XmlElement (name = "GENDER") 
	public void setGender(String g) {
		gender = g;
	}
	
	@XmlElement (name = "DATEOFBIRTH") 
	public void setDob( Date d ) {
		dateOfBirth = d;
	}

	@XmlElement (name = "AGE") 
	public void setAge(int a) {
		age = a;
	}
	
	@XmlElement (name = "START_WEIGHT") 
	public void setStartWeight(double sw) {
		startWgt = sw;
	}

	@XmlElement (name = "TARGET_WEIGHT")
	public void setTargetWgt(double targetWgt) {
		this.targetWgt = targetWgt;
	}

	@XmlElement (name = "CURRENT_WEIGHT")
	public void setCurrentWgt(double currentWgt) {
		this.currentWgt = currentWgt;
	}

	@XmlElement (name = "UOM_SYSTEM")
	public void setUom_system(String uom_system) {
		this.uom_system = uom_system;
	}

	@XmlElement (name = "UNITS")
	public void setUnits(String units) {
		this.units = units;
	}

	@XmlElement (name = "ACTIVITY_LVL")
	public void setActivity_lvl(String activity_lvl) {
		this.activity_lvl = activity_lvl;
	}

	@XmlElement (name = "BMI")
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	@XmlElement (name = "BMR")
	public void setBmr(double bmr) {
		this.bmr = bmr;
	}
	
	
	public void marshalPerson() {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Person.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(jaxbContext, new FileOutputStream("C:\testPersonMarshal.xml"));
		} catch (JAXBException e) {
			marshallLogger.logp(Level.SEVERE, PersonMarshalling.class.getName(), "marshallPerson()",
					"Caught jaxb exception when attempting to marshall a person./n" + e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException fe) {
			marshallLogger.logp(Level.SEVERE, PersonMarshalling.class.getName(), "marshallPerson()",
					"Caught FileNotFoundException when attempting to marshall a person./n" + fe.getMessage());
			fe.printStackTrace();
		}
	}
}
