package edu.sjsu.peerconnections.deannabase.views;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormAccessors 
{
	private static final double minimumGPA = 3.0;
	
	private static TextField firstNameField, lastNameField, preferredNameField, pronounsOtherField, studentIDField,
	emailField, phoneNumberField, majorField, collegeField, payRateField, certificationField,
	strength1Field, strength2Field, strength3Field, strength4Field, strength5Field;
	
	private static ComboBox<String> pronounsDropDown, shirtSizeDropDown, graduationMonthDropDown;
	
	private static CheckBox roleClassicTutor, rolePeerMentor, roleEmbeddedTutor, roleSILeader, roleLA, roleWDS,
	rolePublicity, roleTrainingLead, roleTutorLead, roleMentorLead, roleETutorLead, roleSILeaderLead,
	tlCRLATutorLvl1, tlCRLATutorLvl2, tlCRLAMentorLvl1, tlCRLAMentorLvl2, tlSJSUSILeaderLvl1,
	tlSJSUSILeaderLvl2, tlSJSULALvl1, tlSJSULALvl2, tlSJSUPELead, tlTutorEssentials, tlFERPA,
	tlPreventingDiscrimination;
	
	private static Button addCertificateButton, deleteCertificateButton;
	
	private static RadioButton pictureYes, pictureNo, studentStatusDomestic, studentStatusInternational, startSemesterFall, 
	startSemesterSpring, hireStatusNew, hireStatusReturning;
	
	private static Spinner<Integer> graduationYearSpinner, startYearSpinner;
	private static Spinner<Double> gpaSpinner;
	
	private static DatePicker evcDatePicker;
	
	private static ListView<String> certificatesListView;
	private static VBox otherCertificatesBox;
	
	
	public static void initialize() {
		//PERSONAL INFORMATION FORM
		createFirstNameField();
		
		createLastNameField();
		
		createPreferredNameField();
		
		createStudentIDField();
		
		createPronounsField();
		
		createEmailField();
		
		createPhoneNumberField();	
		
		createPictureToggles();
		
		createShirtSizeDropDown();
		
		//ACADEMIC INFORMATION FORM
		createMajorField();
		
		createCollegeField();
		
		createGraduationDateGroup();
		
		createGpaSpinner();
		
		createStudentStatusToggles();
		
		//EMPLOYEE INFORMATION FORM
		createHireStatusToggles();

		createStartDateGroup();
		
		createPayRateField();
		
		createRoleCheckBoxes();

		createTrainingLevelCheckBoxes();
		
		createCertificationBox();
		
		createEvcDatePicker();
		
		createStrengthFields();
	}
	
//INITALIZERS
	/**
	 * Initializes first name text field.
	 */
	private static final void createFirstNameField() {
		firstNameField = new TextField();
	}

	/**
	 * Initializes last name text field.
	 */
	private static final void createLastNameField() {
		lastNameField = new TextField();
	}

	/**
	 * Initializes preferred name text field.
	 */
	private static final void createPreferredNameField() {
		preferredNameField = new TextField();
		
		preferredNameField.setPromptText("Blank if no preference"); //default instructional text
	}

	/**
	 * Initializes pronouns drop down and text field for other pronouns.
	 */
	private static final void createPronounsField() {
		ObservableList<String> pronounsOptions = FXCollections.observableArrayList(
				Pronouns.SHE.getPronouns(),
				Pronouns.HE.getPronouns(),
				Pronouns.THEY.getPronouns(),
				Pronouns.OTHER.getPronouns()); //list of possible pronouns in the drop down menu
		
		pronounsDropDown = new ComboBox<String>(pronounsOptions);
		
		pronounsDropDown.setMaxWidth(Double.MAX_VALUE); //for grid purposes in FormView
		
		pronounsOtherField = new TextField(); //text field for entering any other possible pronoun
		
		pronounsOtherField.setPromptText("Other pronouns"); //default instructional text
	}

	/**
	 * Initializes student id text field.
	 */
	private static final void createStudentIDField() {
		studentIDField = new TextField();
	}

	/**
	 * Initializes email text field.
	 */
	private static final void createEmailField() {
		emailField = new TextField();
	}

	/**
	 * Initializes phone number text field.
	 */
	private static final void createPhoneNumberField() {
		phoneNumberField = new TextField();
		
		phoneNumberField.setPromptText("###-###-####"); //default instructional text
	}

	/**
	 * Initializes picture toggle group (radio buttons) for yes and no options.
	 */
	private static final void createPictureToggles() {
		final ToggleGroup picture = new ToggleGroup();
		
		pictureYes = new RadioButton("Yes");
		
		pictureYes.setToggleGroup(picture);
		
		pictureNo = new RadioButton("No");
		
		pictureNo.setToggleGroup(picture);
	}
	
	/**
	 * Initializes shirt size drop down list.
	 */
	private static final void createShirtSizeDropDown() {
		ObservableList<String> shirtSizeOptions = FXCollections.observableArrayList(
				ShirtSizes.XS.toString(),
				ShirtSizes.S.toString(),
				ShirtSizes.M.toString(),
				ShirtSizes.L.toString(),
				ShirtSizes.XL.toString());
		
		shirtSizeDropDown = new ComboBox<String>(shirtSizeOptions);
	}
	
	/**
	 * Initializes major text field.
	 */
	private static final void createMajorField() {
		majorField = new TextField();
	}

	/**
	 * Initializes college text field.
	 */
	private static final void createCollegeField() {
		collegeField = new TextField();
	}

	/**
	 * Initializes graduation menu views (month and year).
	 */
	private static final void createGraduationDateGroup() {
		ObservableList<String> graduationMonthOptions = FXCollections.observableArrayList(
				Month.JAN.toString(),
				Month.FEB.toString(),
				Month.MAR.toString(),
				Month.APR.toString(),
				Month.MAY.toString(),
				Month.JUN.toString(),
				Month.JUL.toString(),
				Month.AUG.toString(),
				Month.SEPT.toString(),
				Month.OCT.toString(),
				Month.NOV.toString(),
				Month.DEC.toString()
				); //list of possible graduation months
		
		graduationMonthDropDown = new ComboBox<String>(graduationMonthOptions);
		
		graduationMonthDropDown.setPromptText("Month"); //default instructional text
		
		graduationYearSpinner = new Spinner<Integer>();
		
		SpinnerValueFactory<Integer> gradYearValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				Calendar.getInstance().get(Calendar.YEAR) - 50, Calendar.getInstance().get(Calendar.YEAR) + 50);
		//possible years for graduation spinner is current year +/- 50
		
		graduationYearSpinner.setValueFactory(gradYearValues);
		
		graduationYearSpinner.getValueFactory().setValue(Calendar.getInstance().get(Calendar.YEAR)); 
		//set default year to current year
		
		graduationYearSpinner.setPrefWidth(75); //preferred width for grid purposes
	}
	
	/**
	 * Initializes GPA spinner.
	 */
	private static final void createGpaSpinner() {
		gpaSpinner = new Spinner<Double>();
		
		SpinnerValueFactory<Double> gpaValues = new SpinnerValueFactory.DoubleSpinnerValueFactory(3.0, 4.0, minimumGPA, .1);
		//possible GPA values are 3.0 - 4.0 to the first decimal place
		
		gpaSpinner.setValueFactory(gpaValues);
		
		gpaSpinner.setPrefWidth(75); //preferred width for grid purposes
	}
	
	/**
	 * Initializes student status toggle group for domestic and international options.
	 */
	private static final void createStudentStatusToggles() {
		final ToggleGroup studentStatus = new ToggleGroup();
		
		studentStatusDomestic = new RadioButton("Domestic");
		
		studentStatusDomestic.setToggleGroup(studentStatus);
		
		studentStatusInternational = new RadioButton("International");
		
		studentStatusInternational.setToggleGroup(studentStatus);
	}
	
	/**
	 * Initializes hire status toggle group for new and returning options.
	 */
	private static final void createHireStatusToggles() {
		ToggleGroup hireStatus = new ToggleGroup();
		
		hireStatusNew = new RadioButton("New");
		
		hireStatusNew.setToggleGroup(hireStatus);
		
		hireStatusReturning = new RadioButton("Returning");
		
		hireStatusReturning.setToggleGroup(hireStatus);
	}

	/**
	 * Initializes starting semester toggle group for spring/fall semesters, as well as spinner for starting year.
	 */
	private static final void createStartDateGroup() {
		ToggleGroup startSemester = new ToggleGroup();
			
		startSemesterFall = new RadioButton("Fall");
	
		startSemesterFall.setToggleGroup(startSemester);
		
		startSemesterSpring = new RadioButton("Spring");
		
		startSemesterSpring.setToggleGroup(startSemester);
		
		startYearSpinner = new Spinner<Integer>();
		
		SpinnerValueFactory<Integer> startYearValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				Calendar.getInstance().get(Calendar.YEAR) - 50, Calendar.getInstance().get(Calendar.YEAR) + 50);
		//create spinner for possible years to start university; possible years is +/- 50 of current years
		
		startYearSpinner.setValueFactory(startYearValues);
		
		startYearSpinner.getValueFactory().setValue(Calendar.getInstance().get(Calendar.YEAR)); //set default year to current year
		
		startYearSpinner.setPrefWidth(75); //preferred width for grid purposes
	}
	
	/**
	 * Initializes pay rate text field.
	 */
	private static final void createPayRateField() {
		payRateField = new TextField();
	}
	
	/**
	 * Initializes check boxes for roles.
	 */
	private static final void createRoleCheckBoxes() {
		roleClassicTutor = new CheckBox(); 
		
		rolePeerMentor = new CheckBox();
		
		roleEmbeddedTutor = new CheckBox(); 
		
		roleSILeader = new CheckBox();
		
		roleLA = new CheckBox();
		
		roleWDS = new CheckBox();
		
		rolePublicity = new CheckBox();
		
		roleTrainingLead = new CheckBox(); 
		
		roleTutorLead = new CheckBox(); 
		
		roleMentorLead = new CheckBox(); 
		
		roleETutorLead = new CheckBox(); 
		
		roleSILeaderLead  = new CheckBox();
	}
	
	/**
	 * Initializes check boxes for training levels.
	 */
	private static final void createTrainingLevelCheckBoxes() {
		tlCRLATutorLvl1 = new CheckBox("CRLA Level 1"); 
		
		tlCRLATutorLvl2 = new CheckBox("CRLA Level 2");
		
		tlCRLAMentorLvl1 = new CheckBox("CRLA Level 1"); 
		
		tlCRLAMentorLvl2 = new CheckBox("CRLA Level 2"); 
		
		tlSJSUSILeaderLvl1 = new CheckBox("SJSU Level 1");
		
		tlSJSUSILeaderLvl2 = new CheckBox("SJSU Level 2"); 
		
		tlSJSULALvl1 = new CheckBox("SJSU Level 1"); 
		
		tlSJSULALvl2 = new CheckBox("SJSU Level 2"); 
		
		tlSJSUPELead = new CheckBox("SJSU Peer Educator Lead"); 
		
		//required training for all PEs
		tlTutorEssentials = new CheckBox("Tutor Essentials"); 
		
		tlFERPA = new CheckBox("FERPA & Data Security");
		
		tlPreventingDiscrimination  = new CheckBox("Preventing Discrimination & Harrassment");
	}

	/**
	 * Initializes all certification objects (list, text field, buttons). 
	 */
	private static final void createCertificationBox() {
		certificatesListView = new ListView<String>(); //list containing all certification
		
		certificationField = new TextField(); //text field to input other certifications to add them to list
		
		addCertificateButton = new Button("+"); //button to add certification		
		addCertificateButton.setOnAction(e -> {
				addCertificate(); //method that adds certification to list from text field
				});
		
		deleteCertificateButton = new Button("-"); //button to delete certification
		deleteCertificateButton.setOnAction(e -> {
				deleteCertificate(); //method that deletes a highlighted item from certification list
		});
		
		HBox certificateButtonBox = new HBox(); //wrapper box for certification buttons
		certificateButtonBox.setSpacing(5);
		certificateButtonBox.setAlignment(Pos.CENTER_RIGHT); //wrapper box is aligned right
		certificateButtonBox.getChildren().add(addCertificateButton);
		certificateButtonBox.getChildren().add(deleteCertificateButton);
		
		otherCertificatesBox = new VBox(); //wrapper box for all certification objects (list, text field, buttons)
		otherCertificatesBox.setSpacing(5);
		otherCertificatesBox.getChildren().add(certificatesListView);
		otherCertificatesBox.getChildren().add(certificationField);
		otherCertificatesBox.getChildren().add(certificateButtonBox);
	}
	
	/**
	 * Initializes EVC date picker.
	 */
	private static final void createEvcDatePicker() {
		evcDatePicker = new DatePicker();
	}
	
	/**
	 * Initializes strength fields (5).
	 */
	private static final void createStrengthFields() {
		strength1Field = new TextField();
		
		strength2Field = new TextField();
		
		strength3Field = new TextField();
		
		strength4Field = new TextField();
		
		strength5Field = new TextField();
		
		//default instructional text
		strength1Field.setPromptText("Strength #1"); 
		
		strength2Field.setPromptText("Strength #2");
		
		strength3Field.setPromptText("Strength #3");
		
		strength4Field.setPromptText("Strength #4");
		
		strength5Field.setPromptText("Strength #5");
	}

	//AC	CESSORS
	/**
	 * @return the minimumgpa
	 */
	protected static final double getMinimumgpa() {
		return minimumGPA;
	}

	/**
	 * @return the firstNameField
	 */
	protected static final TextField getFirstNameField() {
		return firstNameField;
	}

	/**
	 * @return the lastNameField
	 */
	protected static final TextField getLastNameField() {
		return lastNameField;
	}

	/**
	 * @return the preferredNameField
	 */
	protected static final TextField getPreferredNameField() {
		return preferredNameField;
	}

	/**
	 * @return the pronounsOtherField
	 */
	protected static final TextField getPronounsOtherField() {
		return pronounsOtherField;
	}

	/**
	 * @return the studentIDField
	 */
	protected static final TextField getStudentIDField() {
		return studentIDField;
	}

	/**
	 * @return the emailField
	 */
	protected static final TextField getEmailField() {
		return emailField;
	}

	/**
	 * @return the phoneNumberField
	 */
	protected static final TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	/**
	 * @return the majorField
	 */
	protected static final TextField getMajorField() {
		return majorField;
	}

	/**
	 * @return the collegeField
	 */
	protected static final TextField getCollegeField() {
		return collegeField;
	}

	/**
	 * @return the payRateField
	 */
	protected static final TextField getPayRateField() {
		return payRateField;
	}

	/**
	 * @return the certificationField
	 */
	protected static final TextField getCertificationField() {
		return certificationField;
	}

	/**
	 * @return the strength1Field
	 */
	protected static final TextField getStrength1Field() {
		return strength1Field;
	}

	/**
	 * @return the strength2Field
	 */
	protected static final TextField getStrength2Field() {
		return strength2Field;
	}

	/**
	 * @return the strength3Field
	 */
	protected static final TextField getStrength3Field() {
		return strength3Field;
	}

	/**
	 * @return the strength4Field
	 */
	protected static final TextField getStrength4Field() {
		return strength4Field;
	}

	/**
	 * @return the strength5Field
	 */
	protected static final TextField getStrength5Field() {
		return strength5Field;
	}

	/**
	 * @return the pronounsDropDown
	 */
	protected static final ComboBox<String> getPronounsDropDown() {
		return pronounsDropDown;
	}

	/**
	 * @return the shirtSizeDropDown
	 */
	protected static final ComboBox<String> getShirtSizeDropDown() {
		return shirtSizeDropDown;
	}

	/**
	 * @return the graduationMonthDropDown
	 */
	protected static final ComboBox<String> getGraduationMonthDropDown() {
		return graduationMonthDropDown;
	}

	/**
	 * @return the roleClassicTutor
	 */
	protected static final CheckBox getRoleClassicTutor() {
		return roleClassicTutor;
	}

	/**
	 * @return the rolePeerMentor
	 */
	protected static final CheckBox getRolePeerMentor() {
		return rolePeerMentor;
	}

	/**
	 * @return the roleEmbeddedTutor
	 */
	protected static final CheckBox getRoleEmbeddedTutor() {
		return roleEmbeddedTutor;
	}

	/**
	 * @return the roleSILeader
	 */
	protected static final CheckBox getRoleSILeader() {
		return roleSILeader;
	}

	/**
	 * @return the roleLA
	 */
	protected static final CheckBox getRoleLA() {
		return roleLA;
	}

	/**
	 * @return the roleWDS
	 */
	protected static final CheckBox getRoleWDS() {
		return roleWDS;
	}

	/**
	 * @return the rolePublicity
	 */
	protected static final CheckBox getRolePublicity() {
		return rolePublicity;
	}

	/**
	 * @return the roleTrainingLead
	 */
	protected static final CheckBox getRoleTrainingLead() {
		return roleTrainingLead;
	}

	/**
	 * @return the roleTutorLead
	 */
	protected static final CheckBox getRoleTutorLead() {
		return roleTutorLead;
	}

	/**
	 * @return the roleMentorLead
	 */
	protected static final CheckBox getRoleMentorLead() {
		return roleMentorLead;
	}

	/**
	 * @return the roleETutorLead
	 */
	protected static final CheckBox getRoleETutorLead() {
		return roleETutorLead;
	}

	/**
	 * @return the roleSILeaderLead
	 */
	protected static final CheckBox getRoleSILeaderLead() {
		return roleSILeaderLead;
	}

	/**
	 * @return the tlCRLATutorLvl1
	 */
	protected static final CheckBox getTlCRLATutorLvl1() {
		return tlCRLATutorLvl1;
	}

	/**
	 * @return the tlCRLATutorLvl2
	 */
	protected static final CheckBox getTlCRLATutorLvl2() {
		return tlCRLATutorLvl2;
	}

	/**
	 * @return the tlCRLAMentorLvl1
	 */
	protected static final CheckBox getTlCRLAMentorLvl1() {
		return tlCRLAMentorLvl1;
	}

	/**
	 * @return the tlCRLAMentorLvl2
	 */
	protected static final CheckBox getTlCRLAMentorLvl2() {
		return tlCRLAMentorLvl2;
	}

	/**
	 * @return the tlSJSUSILeaderLvl1
	 */
	protected static final CheckBox getTlSJSUSILeaderLvl1() {
		return tlSJSUSILeaderLvl1;
	}

	/**
	 * @return the tlSJSUSILeaderLvl2
	 */
	protected static final CheckBox getTlSJSUSILeaderLvl2() {
		return tlSJSUSILeaderLvl2;
	}

	/**
	 * @return the tlSJSULALvl1
	 */
	protected static final CheckBox getTlSJSULALvl1() {
		return tlSJSULALvl1;
	}

	/**
	 * @return the tlSJSULALvl2
	 */
	protected static final CheckBox getTlSJSULALvl2() {
		return tlSJSULALvl2;
	}

	/**
	 * @return the tlSJSUPELead
	 */
	protected static final CheckBox getTlSJSUPELead() {
		return tlSJSUPELead;
	}

	/**
	 * @return the tlTutorEssentials
	 */
	protected static final CheckBox getTlTutorEssentials() {
		return tlTutorEssentials;
	}

	/**
	 * @return the tlFERPA
	 */
	protected static final CheckBox getTlFERPA() {
		return tlFERPA;
	}

	/**
	 * @return the tlPreventingDiscrimination
	 */
	protected static final CheckBox getTlPreventingDiscrimination() {
		return tlPreventingDiscrimination;
	}

	/**
	 * @return the pictureYes
	 */
	protected static final RadioButton getPictureYes() {
		return pictureYes;
	}

	/**
	 * @return the pictureNo
	 */
	protected static final RadioButton getPictureNo() {
		return pictureNo;
	}

	/**
	 * @return the studentStatusDomestic
	 */
	protected static final RadioButton getStudentStatusDomestic() {
		return studentStatusDomestic;
	}

	/**
	 * @return the studentStatusInternational
	 */
	protected static final RadioButton getStudentStatusInternational() {
		return studentStatusInternational;
	}

	/**
	 * @return the startSemesterFall
	 */
	protected static final RadioButton getStartSemesterFall() {
		return startSemesterFall;
	}

	/**
	 * @return the startSemesterSpring
	 */
	protected static final RadioButton getStartSemesterSpring() {
		return startSemesterSpring;
	}

	/**
	 * @return the hireStatusNew
	 */
	protected static final RadioButton getHireStatusNew() {
		return hireStatusNew;
	}

	/**
	 * @return the hireStatusReturning
	 */
	protected static final RadioButton getHireStatusReturning() {
		return hireStatusReturning;
	}

	/**
	 * @return the graduationYearSpinner
	 */
	protected static final Spinner<Integer> getGraduationYearSpinner() {
		return graduationYearSpinner;
	}

	/**
	 * @return the startYearSpinner
	 */
	protected static final Spinner<Integer> getStartYearSpinner() {
		return startYearSpinner;
	}

	/**
	 * @return the gpaSpinner
	 */
	protected static final Spinner<Double> getGpaSpinner() {
		return gpaSpinner;
	}

	/**
	 * @return the evcDatePicker
	 */
	protected static final DatePicker getEvcDatePicker() {
		return evcDatePicker;
	}

	/**
	 * @return the certificatesListView
	 */
	protected static final ListView<String> getCertificatesListView() {
		return certificatesListView;
	}

	/**
	 * @return the otherCertificatesBox
	 */
	protected static final VBox getOtherCertificatesBox() {
		return otherCertificatesBox;
	}

	//SETTERS
	/**
	 * Set first name.
	 * @param x
	 */
	protected static final void setFirstNameField(String x) {
		firstNameField.setText(x);
	}
	
	/**
	 * Set last name.
	 * @param x
	 */
	protected static final void setLastNameField(String x) {
		lastNameField.setText(x);
	}

	/**
	 * Set preferred name.
	 * @param x
	 */
	protected static final void setPreferredNameField(String x) {
		preferredNameField.setText(x);
	}
	
	/**
	 * Set student id.
	 * @param x
	 */
	protected static final void setStudentIDField(String x) {
		studentIDField.setText(x);
	}

	/**
	 * Sets the selected item of the pronoun drop down to the according index.
	 * 
	 * Fills in "Other" field with other pronoun if applicable.
	 * 
	 * @param pronoun
	 * @param other
	 */
	protected static final void setPronounsDropDown(Pronouns pronoun, String other) {
		pronounsDropDown.getSelectionModel().select(pronoun.getIndex());
		if(pronoun == Pronouns.OTHER)
			pronounsOtherField.setText(other);
	}

	/**
	 * Set email.
	 * @param x
	 */
	protected static final void setEmailField(String x) {
		emailField.setText(x);
	}
	
	/**
	 * Set phone number.
	 * @param x
	 */
	protected static final void getPhoneNumberField(String x) {
		phoneNumberField.setText(x);
	}

	/**
	 * Set picture toggles. 
	 * @param flag Flag value for picture permission. If 1, yes. If 0, no.
	 */
	protected static final void setPictureToggles(int flag) {
		if(flag == 1)
			pictureYes.setSelected(true);
		else
			pictureNo.setSelected(true);
	}
	
	/**
	 * Sets the selected item of the drop down list to the inputed shirt size.
	 * @param size 
	 */
	protected static final void setShirtSizeDropDown(ShirtSizes size) {
		shirtSizeDropDown.getSelectionModel().select(size.getIndex());
	}
	
	/**
	 * Set major.
	 * @param x
	 */
	protected static final void setMajorField(String x) {
		majorField.setText(x);
	}

	/**
	 * Set college.
	 * @param x
	 */
	protected static final void setCollegeField(String x) {
		collegeField.setText(x);
	}

	/**
	 * Sets graduate date objects.
	 * @param month
	 * @param year 4 digit int
	 */
	protected static final void setGraduationDateGroup(Month month, int year) {
		graduationMonthDropDown.getSelectionModel().select(month.getIndex());
		
		graduationYearSpinner.getValueFactory().setValue(year);
	}
	
	/**
	 * Sets GPA.
	 * @param gpa 3.0 to 4.0
	 */
	protected static final void setGpaSpinner(Double gpa) {
		gpaSpinner.getValueFactory().setValue(gpa);
	}
	
	/**
	 * Sets student status toggles.
	 * @param flag Flag value for student status. If 1, international. If 0, domestic.
	 */
	protected static final void setStudentStatusToggles(int flag) {
		if(flag == 1)
			studentStatusInternational.setSelected(true);
		else
			studentStatusDomestic.setSelected(true);
	}
	
	/**
	 * Sets hire status toggles.
	 * @param flag Flag value for hire status. If 1, new. If 0, returning.
	 */
	protected static final void setHireStatusToggles(int flag) {
		if(flag == 1)
			hireStatusNew.setSelected(true);
		else
			hireStatusReturning.setSelected(true);
	}

	/**
	 * Sets start date objects.
	 * @param semesterFlag Flag value for start semester. If 1, fall. If 0, spring.
	 * @param year 4 digit int
	 */
	protected static final void setStartDateGroup(int semesterFlag, int year) {
		if(semesterFlag == 1)
			startSemesterFall.setSelected(true);
		else
			startSemesterSpring.setSelected(true);
		
		startYearSpinner.getValueFactory().setValue(year);
	}
	
	/**
	 * Set pay rate.
	 * @param x
	 */
	protected static final void setPayRateField(String x) {
		payRateField.setText(x);
	}

	/**
	 * Sets role checkboxes. Params are true for role checked, false for role unchecked.
	 * @param tutorFlag
	 * @param mentorFlag
	 * @param eTutorFlag
	 * @param siFlag
	 * @param laFlag
	 * @param wdsFlag
	 * @param publicityFlag
	 * @param trainingLeadFlag
	 * @param tutorLeadFlag
	 * @param mentorLeadFlag
	 * @param eTutorLeadFlag
	 * @param siLeadFlag
	 */
	protected static final void setRoleCheckBoxes(boolean tutorFlag, boolean mentorFlag, boolean eTutorFlag,
			boolean siFlag, boolean laFlag, boolean wdsFlag, boolean publicityFlag, boolean trainingLeadFlag,
			boolean tutorLeadFlag, boolean mentorLeadFlag, boolean eTutorLeadFlag, boolean siLeadFlag) {
		roleClassicTutor.setSelected(tutorFlag);
		
		rolePeerMentor.setSelected(mentorFlag);
		
		roleEmbeddedTutor.setSelected(eTutorFlag);
		
		roleSILeader.setSelected(siFlag);
		
		roleLA.setSelected(laFlag);
		
		roleWDS.setSelected(wdsFlag);
		
		rolePublicity.setSelected(publicityFlag);
		
		roleTrainingLead.setSelected(trainingLeadFlag);
		
		roleTutorLead.setSelected(tutorLeadFlag);
		
		roleMentorLead.setSelected(mentorLeadFlag);
		
		roleETutorLead.setSelected(eTutorLeadFlag);
		
		roleSILeaderLead.setSelected(siLeadFlag);
	}

	/**
	 * Sets training level checkboxes. Params are true for checked, false for unchecked.
	 * @param crlaTutorLvl1flag
	 * @param crlaTutorLvl2flag
	 * @param crlaMentorLvl1flag
	 * @param crlaMentorLvl2flag
	 * @param sjsuSILeaderLvl1flag
	 * @param sjsuSILeaderLvl2flag
	 * @param sjsuLALvl1flag
	 * @param sjsuLALvl2flag
	 * @param sjsuPELeadflag
	 * @param tutorEssentialsflag
	 * @param ferpaflag
	 * @param preventingDiscriminationflag
	 */
	protected static final void setTrainingLevelCheckBoxes(boolean crlaTutorLvl1flag, boolean crlaTutorLvl2flag,
			boolean crlaMentorLvl1flag, boolean crlaMentorLvl2flag, boolean sjsuSILeaderLvl1flag, boolean sjsuSILeaderLvl2flag,
			boolean sjsuLALvl1flag, boolean sjsuLALvl2flag, boolean sjsuPELeadflag, boolean tutorEssentialsflag,
			boolean ferpaflag, boolean preventingDiscriminationflag) {
		tlCRLATutorLvl1.setSelected(crlaTutorLvl1flag); 
		
		tlCRLATutorLvl2.setSelected(crlaTutorLvl2flag); 
		
		tlCRLAMentorLvl1.setSelected(crlaMentorLvl1flag); 
		
		tlCRLAMentorLvl2.setSelected(crlaMentorLvl2flag); 
		
		tlSJSUSILeaderLvl1.setSelected(sjsuSILeaderLvl1flag);
		
		tlSJSUSILeaderLvl2.setSelected(sjsuSILeaderLvl2flag); 
		
		tlSJSULALvl1.setSelected(sjsuLALvl1flag); 
		
		tlSJSULALvl2.setSelected(sjsuLALvl2flag); 
		
		tlSJSUPELead.setSelected(sjsuPELeadflag); 
		
		tlTutorEssentials.setSelected(tutorEssentialsflag); 
		
		tlFERPA.setSelected(ferpaflag);
		
		tlPreventingDiscrimination.setSelected(preventingDiscriminationflag);
	}

	/**
	 * Adds certifications to the certification box
	 * @param certificates collection of certificates
	 */
	protected static final void setCertificationBox(Collection<? extends String> certificates) {
		certificatesListView.getItems().addAll(certificates);
	}
	
	/**
	 * Sets date on EVC DatePicker
	 * @param dayOfMonth
	 * @param month
	 * @param year
	 */
	protected static final void setEvcDatePicker(int dayOfMonth, int month, int year) {
		evcDatePicker.setValue(LocalDate.of(year, month, dayOfMonth));
	}
	
	/**
	 * Sets strength fields #1-5
	 * @param strengths
	 */
	protected static final void setStrengthFields(String[] strengths) {
		strength1Field.setText(strengths[0]);
		
		strength2Field.setText(strengths[1]);
		
		strength3Field.setText(strengths[2]);
		
		strength4Field.setText(strengths[3]);
		
		strength5Field.setText(strengths[4]);
	}
	
	/**
	 * Gets the add certificate button
	 * @return
	 */
	protected static final Button getAddCertificateButton() {
		return addCertificateButton;
	}
	
	/**
	 * Gets the delete certificate button
	 * @return
	 */
	protected static final Button getDeleteCertificateButton() {
		return deleteCertificateButton;
	}
	
	/**
	 * Adds a certificate to the certificate list view.
	 * 
	 * Called by addCertificateButton on action
	 */
	private static void addCertificate() {
		String certificate = certificationField.getText().trim(); //get rid of white space
		
		if(certificate.isEmpty()) //no text in field
			return;
		
		certificatesListView.getItems().add(certificate); //add textfield string to list
	}
	
	/**
	 * Deletes a highlighted certificate from the certificate list view.
	 * 
	 * Called by deleteCertificateButton on action
	 */
	private static void deleteCertificate() {
		int toDelete = certificatesListView.getSelectionModel().getSelectedIndex(); //get index of selected value
		
		if(toDelete < 0) //no item selected --> do nothing
			return;
		
		certificatesListView.getItems().remove(toDelete);
	}
}
