package edu.sjsu.peerconnections.deannabase.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FormView extends View
{
	private final String mainHeaderText = "Student-Employee Information Sheet";
	private final String personalInfoHeaderText = "Personal Information";
	private final String academicInfoHeaderText = "Academic Information";
	private final String employeeInfoHeaderText = "Employee Information";
	
	private Label mainHeader, personalInfoHeader, academicInfoHeader, employeeInfoHeader, 
				firstNameLabel, lastNameLabel, preferredNameLabel, pronounsLabel, studentIDLabel,	emailLabel, 
				phoneNumberLabel, shirtSizeLabel, picturePermissionLabel, graduationDateLabel, majorLabel,
				collegeLabel, studentStatusLabel, gpaLabel, roleLabel, hireStatusLabel, startDateLabel, payRateLabel,
				trainingLevelLabel, tutorLevelLabel, mentorLevelLabel, siLeaderLevelLabel, laLevelLabel,
				peLeadLevelLabel, onlineTrainingLevelLabel, certificatesLabel, evcDateLabel, strengthsLabel;
	
	public FormView()
	{
		super(12, 5);
		
		mainHeader = new Label(mainHeaderText);
		mainHeader.setId("header-1");
		
		GridPane formWrapperGrid = new GridPane();
		formWrapperGrid.setAlignment(Pos.TOP_CENTER);
//		formWrapperGrid.setGridLinesVisible(true);
		formWrapperGrid.setPadding(new Insets(10, 10, 10, 10));
		formWrapperGrid.setHgap(10);
		formWrapperGrid.setVgap(5);
		
		FormAccessors.initialize();
		
		//personal information form
		personalInfoHeader = new Label(personalInfoHeaderText);
		personalInfoHeader.setId("header-2");
		
		firstNameLabel = new Label("First Name");
		
		lastNameLabel = new Label("Last Name");
		
		studentIDLabel = new Label("SJSU ID #");
		
		preferredNameLabel = new Label("Preferred Name");
		
		pronounsLabel = new Label("Pronouns");
		
		emailLabel = new Label("Email Address");
		
		phoneNumberLabel = new Label("Phone Number");
		
		picturePermissionLabel = new Label("Picture Permission");
		
		shirtSizeLabel = new Label("Shirt Size");

		
		//Academic information form
		academicInfoHeader = new Label(academicInfoHeaderText);
		academicInfoHeader.setId("header-2");
		
		majorLabel = new Label("Major");

		collegeLabel = new Label("College");
		
		graduationDateLabel = new Label("Estimated Graduation Date");
		
		gpaLabel = new Label("GPA");
		
		studentStatusLabel = new Label("Student Status");
		
		
		//Employee information form
		employeeInfoHeader = new Label(employeeInfoHeaderText);
		
		roleLabel = new Label("Role"); //group role check boxes
		GridPane roleGrid = new GridPane();
		roleGrid.setHgap(10);
		roleGrid.setVgap(5);
		roleGrid.add(FormAccessors.getRoleClassicTutor(), 0, 0);
		roleGrid.add(FormAccessors.getRoleTutorLead(), 0, 1);
		roleGrid.add(FormAccessors.getRolePeerMentor(), 1, 0);
		roleGrid.add(FormAccessors.getRoleMentorLead(), 1, 1);
		roleGrid.add(FormAccessors.getRoleEmbeddedTutor(), 2, 0);
		roleGrid.add(FormAccessors.getRoleETutorLead(), 2, 1);
		roleGrid.add(FormAccessors.getRoleSILeader(), 3, 0);
		roleGrid.add(FormAccessors.getRoleSILeaderLead(), 3, 1);
		roleGrid.add(FormAccessors.getRoleLA(), 4, 0);
		roleGrid.add(FormAccessors.getRoleTrainingLead(), 4, 1);
		roleGrid.add(FormAccessors.getRoleWDS(), 0, 2);
		roleGrid.add(FormAccessors.getRolePublicity(), 1, 2);
		
		hireStatusLabel = new Label("Hire Status");
		
		startDateLabel = new Label("Semester Start Date");
		
		payRateLabel = new Label("Pay Rate");
		
		trainingLevelLabel = new Label("Training Level");

		tutorLevelLabel = new Label("Tutor");
		
		mentorLevelLabel = new Label("Mentor"); 
		
		siLeaderLevelLabel = new Label("SI Leader"); 
		
		laLevelLabel = new Label("Learning Assistant");
		
		peLeadLevelLabel = new Label("Peer Educator Lead"); 
	
		onlineTrainingLevelLabel = new Label("Online Training");
		
		GridPane trainingGrid = new GridPane(); //group training level check boxes
		trainingGrid.setHgap(5);
		trainingGrid.setVgap(10);
		trainingGrid.add(makeCategoryWrapper(tutorLevelLabel), 0, 0);
		trainingGrid.add(makeNodeWrapper(FormAccessors.getTlCRLATutorLvl1(), FormAccessors.getTlCRLATutorLvl2()), 0, 1);
		trainingGrid.add(makeCategoryWrapper(mentorLevelLabel), 0, 2);
		trainingGrid.add(makeNodeWrapper(FormAccessors.getTlCRLAMentorLvl1(), FormAccessors.getTlCRLAMentorLvl2()), 0, 3);
		trainingGrid.add(makeCategoryWrapper(siLeaderLevelLabel), 0, 4);
		trainingGrid.add(makeNodeWrapper(FormAccessors.getTlSJSUSILeaderLvl1(), FormAccessors.getTlSJSUSILeaderLvl2()), 0, 5);
		trainingGrid.add(makeCategoryWrapper(laLevelLabel), 0, 6);
		trainingGrid.add(makeNodeWrapper(FormAccessors.getTlSJSULALvl1(), FormAccessors.getTlSJSULALvl2()), 0, 7);
		trainingGrid.add(makeCategoryWrapper(peLeadLevelLabel), 0, 8);
		trainingGrid.add(FormAccessors.getTlSJSUPELead(), 0, 9);
		trainingGrid.add(makeCategoryWrapper(onlineTrainingLevelLabel), 0, 10);
		trainingGrid.add(FormAccessors.getTlTutorEssentials(), 0, 11);
		trainingGrid.add(FormAccessors.getTlFERPA(), 0, 12);
		trainingGrid.add(FormAccessors.getTlPreventingDiscrimination(), 0, 13, 2, 1);
	
		certificatesLabel = new Label("Other Certifications");
		
		evcDateLabel = new Label("EVC Date");
		
		strengthsLabel = new Label("Strengths"); //group strength text fields
		FlowPane strengthsPane = new FlowPane();
		strengthsPane.getChildren().add(FormAccessors.getStrength1Field());
		strengthsPane.getChildren().add(FormAccessors.getStrength2Field());
		strengthsPane.getChildren().add(FormAccessors.getStrength3Field());
		strengthsPane.getChildren().add(FormAccessors.getStrength4Field());
		strengthsPane.getChildren().add(FormAccessors.getStrength5Field());
		
		//Add all objects to form gridpane
		formWrapperGrid.add(makeCategoryWrapper(personalInfoHeader), 0, 0, 3, 1);
		
		formWrapperGrid.add(firstNameLabel, 0, 1);
		formWrapperGrid.add(FormAccessors.getFirstNameField(), 0, 2);
		
		formWrapperGrid.add(lastNameLabel, 1, 1);
		formWrapperGrid.add(FormAccessors.getLastNameField(), 1, 2);
		
		formWrapperGrid.add(studentIDLabel, 2, 1);
		formWrapperGrid.add(FormAccessors.getStudentIDField(), 2, 2);
		
		formWrapperGrid.add(preferredNameLabel, 0, 4);
		formWrapperGrid.add(FormAccessors.getPreferredNameField(), 0, 5);
		
		formWrapperGrid.add(pronounsLabel, 1, 4);
		formWrapperGrid.add(FormAccessors.getPronounsDropDown(), 1, 5);
		formWrapperGrid.add(FormAccessors.getPronounsOtherField(), 2, 5);
		
		formWrapperGrid.add(emailLabel, 0, 7);
		formWrapperGrid.add(FormAccessors.getEmailField(), 0, 8, 2, 1);
		
		formWrapperGrid.add(phoneNumberLabel, 2, 7);
		formWrapperGrid.add(FormAccessors.getPhoneNumberField(), 2, 8);
		
		formWrapperGrid.add(picturePermissionLabel, 0, 10);
		formWrapperGrid.add(makeNodeWrapper(FormAccessors.getPictureYes(), FormAccessors.getPictureNo()), 0, 11);
		
		formWrapperGrid.add(shirtSizeLabel, 1, 10);
		formWrapperGrid.add(FormAccessors.getShirtSizeDropDown(), 1, 11);

		formWrapperGrid.add(makeCategoryWrapper(academicInfoHeader), 0, 14, 3, 1);
		
		formWrapperGrid.add(majorLabel, 0, 15);
		formWrapperGrid.add(FormAccessors.getMajorField(), 0, 16);
		
		formWrapperGrid.add(collegeLabel, 1, 15);
		formWrapperGrid.add(FormAccessors.getCollegeField(), 1, 16);
		
		formWrapperGrid.add(graduationDateLabel, 2, 15);
		formWrapperGrid.add(makeNodeWrapper(FormAccessors.getGraduationMonthDropDown(), FormAccessors.getGraduationYearSpinner()), 2, 16);
		
		formWrapperGrid.add(gpaLabel, 0, 18);
		formWrapperGrid.add(FormAccessors.getGpaSpinner(), 0, 19);
		
		formWrapperGrid.add(studentStatusLabel, 1, 18);
		formWrapperGrid.add(makeNodeWrapper(FormAccessors.getStudentStatusDomestic(), FormAccessors.getStudentStatusInternational()), 1, 19);
	
		formWrapperGrid.add(makeCategoryWrapper(employeeInfoHeader), 0, 22, 3, 1);
		
		formWrapperGrid.add(roleLabel, 0, 23);
		formWrapperGrid.add(roleGrid, 0, 24, 3, 3);
		
		formWrapperGrid.add(hireStatusLabel, 0, 28);
		formWrapperGrid.add(makeNodeWrapper(FormAccessors.getHireStatusNew(), FormAccessors.getHireStatusReturning()), 0, 29);
		
		formWrapperGrid.add(startDateLabel, 1, 28);
		formWrapperGrid.add(makeNodeWrapper(makeNodeWrapper(FormAccessors.getStartSemesterFall(), FormAccessors.getStartSemesterSpring()), FormAccessors.getStartYearSpinner()), 1, 29);
		
		formWrapperGrid.add(payRateLabel, 2, 28);
		formWrapperGrid.add(FormAccessors.getPayRateField(), 2, 29);
		
		formWrapperGrid.add(trainingLevelLabel, 0, 31);
		formWrapperGrid.add(trainingGrid, 0, 32, 2, 13);
		
		formWrapperGrid.add(certificatesLabel, 2, 31);
		formWrapperGrid.add(FormAccessors.getOtherCertificatesBox(), 2, 32, 1, 5);
		
		formWrapperGrid.add(evcDateLabel, 0, 46);
		formWrapperGrid.add(FormAccessors.getEvcDatePicker(), 0, 47);
		
		formWrapperGrid.add(strengthsLabel, 0, 49);
		formWrapperGrid.add(strengthsPane, 0, 50, 3, 1);
		
		ScrollPane sc = new ScrollPane(formWrapperGrid);
		sc.setPannable(true);
		sc.setFitToWidth(true);
		sc.setFitToHeight(true);
		add(sc, 0, 1, 5, 10);
		add(makeCategoryWrapper(mainHeader), 1, 0, 3, 1);
	}
	
	/**
	 * Factory method to create center-aligning HBox wrappers for category headers.
	 * @param header category label made in constructor
	 * @return
	 */
	private HBox makeCategoryWrapper(Label header)
	{
		HBox wrapper = new HBox();
		
		wrapper.getChildren().add(header);
		
		wrapper.setAlignment(Pos.CENTER);
		
		return wrapper;
	}
	
	/**
	 * Factory method to create center-left-aligning GridPane wrappers for 2 nodes.
	 * 
	 * The nodes appear side by side (same row).
	 * 
	 * @param x first node
	 * @param y second node
	 * @return
	 */
	private GridPane makeNodeWrapper(Node x, Node y)
	{
		GridPane wrapper = new GridPane();
		
		wrapper.add(x, 0, 0);
		
		wrapper.add(y, 1, 0);
		
		wrapper.setHgap(5);
		
		wrapper.setAlignment(Pos.CENTER_LEFT);
		
		return wrapper;
	}
}
