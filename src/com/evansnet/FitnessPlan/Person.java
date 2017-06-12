package com.evansnet.FitnessPlan;

import java.util.Calendar;

import com.evansnet.measurement.HEIGHT_UNITS;
import com.evansnet.measurement.MEASUREMENT_SYSTEM;

public class Person implements IPerson, IGender {

	protected String name;				// The name of the person.
	protected SEX gender; 
	protected Double startWeight;
	protected Double currentWeight;
	protected Double targetWeight;
	protected Calendar birthDate;			// The user's birth date.
	protected Double height;				// The user's height
	protected int age;					// The user's current age.
	protected Double bmr;					// The user's Basal Metabolic Rate
	protected Double bmi;					// The user's Body Mass Index.
	
    protected MEASUREMENT_SYSTEM uomSystem;
    protected HEIGHT_UNITS units;
    protected ACTIVITY_LEVEL activityLvl; 

	public Person() {
		this.startWeight = new Double(0.0);
		this.currentWeight = new Double(0.0);
		this.targetWeight = new Double(0.0);
		this.birthDate = Calendar.getInstance();
		this.height = new Double(0.0);
		this.bmr = new Double(0.0);
		this.bmi = new Double(0.0);
	}
	
	public Person (SEX s, MEASUREMENT_SYSTEM m, HEIGHT_UNITS h) {
		super();
		gender = s;
		uomSystem = m;
		units = h;
	}

	@SuppressWarnings("static-access")
	@Override
	public int calcCurrentAge() {
		Calendar today = Calendar.getInstance();
		int currentAge = 0;
		int currentYr = today.get(today.YEAR);
		int currentMo = today.get(today.MONTH) + 1;
		currentAge =  currentYr - birthDate.get(birthDate.YEAR);		
		
		if (currentMo > birthDate.get(birthDate.MONTH)+1) {		
			currentAge =  (currentYr - birthDate.get(birthDate.YEAR) - 1);
		} 
		setAge(currentAge);
		return currentAge;
	}
	
	public Double getWeight() {
		return currentWeight;
	}
	
	public Double getHeight() {
		return height;
	}
		
	public boolean areFeet() {
		if (units == HEIGHT_UNITS.FEET)
			return true;
		
		return false;
	}
	
	public boolean areCentimeters() {
		if (units == HEIGHT_UNITS.CENTIMETERS)
			return true;
		return false;
	}
	
	public boolean areInches() {
		if (units == HEIGHT_UNITS.INCHES) 
			return true;
		return false;
	}
		
	public boolean areMeters() {
		if (units == HEIGHT_UNITS.METERS)
			return true;
		return false;
	}
	
	@Override
	public boolean isMetric() {
		if (uomSystem == MEASUREMENT_SYSTEM.Metric)
			return true;
		return false;
	}
	
	public boolean isMale() {
		if (gender == SEX.MALE)
			return true;
		return false;
	}
	
	public void setMale(){
		gender = SEX.MALE;
	}

	public void setFemale() {
		gender = SEX.FEMALE;
	}
	
	public void setStartWeight(Double w) {
		startWeight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public Double getStartWeight() {
		return startWeight;
	}
	
	public void setCurrentWeight(Double w) {
		currentWeight = w;
	}
	
	public double getCurrentWeight() {
		return currentWeight;
	}
	
	public void setTargetWeight(Double w) {
		targetWeight = w;
	}
	
	public Double getTargetWeight() {
		return targetWeight;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setBirthDate(Calendar c) {
		birthDate = c;
	}
	
	public Calendar getBirthdate(){
		return birthDate;
	}

	@Override
	public void setGender(SEX g) {
		gender = g;
	}

	@Override
	public SEX genderIs() {
		return gender;
	}

	@Override
	public void useMeasurementSystem(MEASUREMENT_SYSTEM measurementSystem) {
		uomSystem = measurementSystem;
	}

	@Override
	public void hgtUnits(HEIGHT_UNITS h) {
		units = h;
	}

	@Override
	public void activityLvl(ACTIVITY_LEVEL a) {
		activityLvl = a;
	}

	@Override
	public void setConstants(Double[] c) {
		for (int i = 0; i<4; i++) {
			BMRConst[i] = c[i];
		}
	}

	@Override
	public Double getBMRConst(int i) {
		return BMRConst[i];
	}
	
	public void setHeight(Double h) {
		this.height = h;
	}

	/**
	 *@ref MEN BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) - (5.677 x age in years) 
	 */
	public void calcBMR(Double[] bmrConst) {
		this.bmr = bmrConst[1]+(bmrConst[2]*this.getCurrentWeight())+ 
				(bmrConst[3]*this.getHeight())-(bmrConst[4]*this.getAge());
		
	}

	/**
	 * Calculates the user's Body Mass Index (BMI) using the information provided.
	 * 
	 * @ref BMI = (mass(kg)/(height(m))^2 OR (mass(lb)/height(in))^2))*703
	 * @return The users BMI (Body mass index)
	 *
	
	/* The class needs to have an object based on the IPerson interface
	 * That interface should have the units of measure etc defined for the
	 * person that we are planning for.
	 */
	
	protected void calcBMI() {
		BMICalculator bmi = new BMICalculator();
		this.bmi = bmi.calcBMI(this);
	}
	
	public Double getBMI() {
		calcBMI();
		return this.bmi;
	}
	
	//Bindings 
	
}
