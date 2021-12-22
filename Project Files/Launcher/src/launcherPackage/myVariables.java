/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcherPackage;

import java.awt.Font;

/**
 *
 * @author Phil Rey
 */
public class myVariables {
    private static boolean debugModeOn = false;
    
    private static String ipAddress = "";
    private static String ipAddressOnly = "";
    private static String schoolName;
    private static String schoolId;
    private static String region;
    private static String division;
    private static String district;
    private static String principal;
    private static String divisionRepresentative;
    private static String divisionSuperintendent;
    private static String schoolAddress;
    
    private static int loadingSpeed = 0;
    //Fonts
    public static final Font COLUMN_HEADER_FONT = new Font("Arial",Font.BOLD,13);
    public static final Font COLUMN_FONT = new Font("Arial",Font.PLAIN,13);
    
    public static final Font BUTTON_FONT = new Font("Century Gothic",Font.BOLD,12);
    public static final Font TAB_HEADER_FONT = new Font("Century Gothic",Font.BOLD,13);
    public static final Font TAB_FONT = new Font("Century Gothic",Font.PLAIN,11);
    
    public static final Font TEXTFIELD_HEADER_FONT = new Font("Century Gothic",Font.BOLD,12);//e.g. First Name
    public static final Font TEXTFIELD_FONT = new Font("Century Gothic",Font.PLAIN,12);
    public static final Font SEARCH_TEXTFIELD_FONT = new Font("Century Gothic",Font.BOLD,12);
    
    public static final Font TITLE_HEADER_FONT = new Font("Century Gothic",Font.BOLD,18); //e.g. Add New Subject
    public static final Font FORMS_HEADER_FONT = new Font("Arial",Font.BOLD,14); // e.g. Basic Information
    
    public static final Font LABEL_FONT = new Font("Century Gothic",Font.BOLD,13); // e.g. Showing 5 results of 'to search'
    
    //Logged In User Details
    private static int userLoggedInId;
    private static String userLoggedInName;
    private static int accessLevel;
    
    //Selected Variables
    private static int adviserIdSelected;
    private static String adviserNameSeleced;
    private static int sectionSelected;
    private static String sectionSelectedName;
    private static int gradeLevelSelected;
    private static int schoolYearSelected;
    
    private static int sectionsSchoolYearSelected;
    private static int sf4GradeLevelSelected;
    private static boolean includingWeekends;
    
    private static String yearSelected,monthSelected,daySelected;
    
    
    //Table Orders
    private static final int [] usersOrder = new int [] {6,4,3,7,1,2,0,5};
    private static final int [] usersPersonalInfoOrder = new int [] {5,7,8,9,6,3,4,1,2,0};
    private static final int [] studentsOrder = new int [] {6,5,0,2,7,4,1,3,8};
    private static final int [] gradesOrder = new int [] {4,0,5,8,1,6,3,7,2,9,10};
    private static final int [] studentsPersonalInfoOrder = new int[] {14,10,12,16,8,17,4,11,3,5,6,0,9,15,2,7,13,1};
    private static final int [] subjectLoadsOrder = new int [] {0,3,2,1};
    private static final int [] sectionsOrder = new int [] {9,0,4,6,5,10,1,2,11,7,8,3};
    
    private static final int [] enrollmentViewOrder = new int [] {15,7,3,0,9,16,1,5,8,11,4,2,17,10,6,12,13,14};
    private static final int [] enrollmentViewMinimalOrder = new int [] {5,0,4,1,2,7,3,6};
    private static final int [] teacherLoadsViewOrder = new int [] {6,7,1,4,3,8,2,10,9,5,0};
    private static final int [] managedSubjectsViewOrder = new int [] {10,4,6,8,2,1,11,0,5,12,3,7,9};
    
    private static final int [] sectionViewRev3Order = new int [] {8,0,2,4,5,6,3,1,7};
    private static final int [] jhsf1Order= new int [] {18,11,5,20,0,9,12,1,8,21,13,23,4,10,3,7,17,14,2,15,6,19,16,22};
    private static final int [] sf2StudentListViewOrder = new int [] {4,5,0,2,6,1,3};
    private static final int [] sf2StudentListViewOrderRev2 = new int [] {4,5,0,2,6,1,3,7};
    private static final int [] attendanceOrder = new int [] {2,0,3,4,6,5,1};
    private static final int [] subjectOrder = new int[] {2,3,1,0};
    private static final int [] booksViewOrder = new int [] {14,21,8,0,4,23,1,3,9,12,7,5,19,24,2,17,26,20,16,18,25,13,22,6,15,10,11};
    
    //Icons
    private static final String studentsIcon = "icons/icons8_user_groups_skin_type_7_20px_1.png";
    private static final String studentsPrsnlInfIcon = "icons/icons8_resume_20px.png";
    private static final String subjectsIcon = "icons/icons8_book_shelf_20px.png";
    private static final String subjeLoadsIcon = "icons/icons8_books_20px.png";
    private static final String usersIcon = "icons/icons8_teacher_20px.png";
    private static final String usersPrsnlInfIcon = "icons/icons8_name_tag_20px.png";
    private static final String formsIcon = "Imagez/Icons/icons8_microsoft_excel_2019_25px.png";
    private static final String enrollmentIcon = "icons/icons8_user_groups_skin_type_7_20px_1.png";
    private static final String assignSubjectTeacherIcon = "icons/icons8_audit_20px.png";
    
    private static final String sectionsIcon = "icons/icons8_page_20px.png";
    private static final String viewStudentsIcon = "icons/icons8_read_online_20px.png";
    
    private static final String homeIcon = "icons/icons8_home_20px_1.png";
    private static final String settingsIcon = "icons/icons8_settings_20px.png";
    private static final String aboutIcon = "icons/icons8_about_20px.png";
    //Window Icons
    private static final String attendanceWindowIcon = "icons/attendanceIcon.png";
    private static final String registrationWindowIcon = "icons/registerIcon.png";
    private static final String enrollmentWindowIcon = "icons/enrollmentIcon.png";
    private static final String formsWindowIcon = "Imagez/Window Icons/forms.png";
    private static final String gradingWindowIcon = "icons/gradingIcon.png";
    private static final String launcherIcon = "icons/hisrms_icon.png";
    //Dropdown Icons
    private static final String maleIcon = "icons/icons8_male_16px.png";
    private static final String femaleIcon = "icons/icons8_female_16px.png";
    
    //Buttons 
    private static final String registrationBtnIcon = "buttons/Registration.png";
    private static final String registrationActBtnIcon = "buttons/Registration_Active.png";
    private static final String enrollmentBtnIcon = "buttons/Enrollment.png";
    private static final String enrollmentActBtnIcon = "buttons/Enrollment_Active.png";
    private static final String attendanceBtnIcon = "buttons/Attendance.png";
    private static final String attendanceActBtnIcon = "buttons/Attendance_Active.png";
    private static final String weighingBtnIcon = "buttons/Weighing_.png";
    private static final String weighingActBtnIcon = "buttons/Weighing_Active.png";
    private static final String bookKeepBtnIcon = "buttons/Book Keeping.png";
    private static final String bookKeepActBtnIcon = "buttons/Book Keeping_Active.png";
    private static final String gradingBtnIcon = "buttons/Grading.png";
    private static final String gradingActBtnIcon = "buttons/Grading_Active.png";
    private static final String formsBtnIcon = "buttons/Forms.png";
    private static final String formsActBtnIcon = "buttons/Forms_Active.png";
    //<editor-fold desc="showMessage & getConfirmation Variables">
    private static String msgUrlIcon = "icons/icons8_info_50px.png";
    private static String msgUrlIconSuccess = "icons/icons8_ok_hand_50px.png";
    private static String msgUrlIconFailed = "icons/icons8_cancel_50px.png";
    private static String msgUrlIconWarning = "icons/icons8_error_50px.png";
    
    private static String confirmUrlIcon = "icons/icons8_help_50px.png";

    public static int getSectionSelected() {
        return sectionSelected;
    }

    public static boolean isIncludingWeekends() {
        return includingWeekends;
    }

    public static void setIncludingWeekends(boolean includingWeekends) {
        myVariables.includingWeekends = includingWeekends;
    }
    
    public static int getSectionsSchoolYearSelected() {
        return sectionsSchoolYearSelected;
    }

    public static void setSectionsSchoolYearSelected(int sectionsSchoolYearSelected) {
        myVariables.sectionsSchoolYearSelected = sectionsSchoolYearSelected;
    }

    public static int getSf4GradeLevelSelected() {
        return sf4GradeLevelSelected;
    }

    public static void setSf4GradeLevelSelected(int sf4GradeLevelSelected) {
        myVariables.sf4GradeLevelSelected = sf4GradeLevelSelected;
    }
    
    public static int[] getSf2StudentListViewOrderRev2() {
        return sf2StudentListViewOrderRev2;
    }
    
    public static Font getColFont() {
        return COLUMN_FONT;
    }
    
    public static int[] getBooksViewOrder() {
        return booksViewOrder;
    }

    public static String getSectionSelectedName() {
        return sectionSelectedName;
    }

    public static void setSectionSelectedName(String sectionSelectedName) {
        myVariables.sectionSelectedName = sectionSelectedName;
    }
    
    public static boolean isDebugModeOn() {
        return debugModeOn;
    }
    
    public static String getYearSelected() {
        return yearSelected;
    }

    public static void setYearSelected(String yearSelected) {
        myVariables.yearSelected = yearSelected;
    }

    public static String getMonthSelected() {
        return monthSelected;
    }

    public static void setMonthSelected(String monthSelected) {
        myVariables.monthSelected = monthSelected;
    }

    public static String getDaySelected() {
        return daySelected;
    }

    public static void setDaySelected(String daySelected) {
        myVariables.daySelected = daySelected;
    }
    
    public static int[] getSubjectOrder() {
        return subjectOrder;
    }
    
    public static int[] getAttendanceOrder() {
        return attendanceOrder;
    }
    
    public static int getSchoolYearSelected() {
        return schoolYearSelected;
    }

    public static void setSchoolYearSelected(int schoolYearSelected) {
        myVariables.schoolYearSelected = schoolYearSelected;
    }
    
    public static int getAdviserIdSelected() {
        return adviserIdSelected;
    }

    public static void setAdviserIdSelected(int adviserIdSelected) {
        myVariables.adviserIdSelected = adviserIdSelected;
    }

    public static String getAdviserNameSeleced() {
        return adviserNameSeleced;
    }

    public static void setAdviserNameSeleced(String adviserNameSeleced) {
        myVariables.adviserNameSeleced = adviserNameSeleced;
    }

    public static int getGradeLevelSelected() {
        return gradeLevelSelected;
    }

    public static void setGradeLevelSelected(int gradeLevelSelected) {
        myVariables.gradeLevelSelected = gradeLevelSelected;
    }
    
    public static String getFormsWindowIcon() {
        return formsWindowIcon;
    }
    
    public static int[] getSf2StudentListViewOrder() {
        return sf2StudentListViewOrder;
    }
    
    public static void setSectionSelected(int sectionSelected) {
        myVariables.sectionSelected = sectionSelected;
    }

    public static int[] getJhsf1Order() {
        return jhsf1Order;
    }
    
    public static int[] getSectionViewRev3Order() {
        return sectionViewRev3Order;
    }
    
    public static int[] getUsersOrder() {
        return usersOrder;
    }
    
    public static int getUserLoggedInId() {
        return userLoggedInId;
    }

    public static void setUserLoggedInId(int userLoggedInId) {
        myVariables.userLoggedInId = userLoggedInId;
    }

    public static String getUserLoggedInName() {
        return userLoggedInName;
    }

    public static void setUserLoggedInName(String userLoggedInName) {
        myVariables.userLoggedInName = userLoggedInName;
    }
    
    public static int getAccessLevel() {
        return accessLevel;
    }
    public static String getAccessLevelName(int customLevel){
        //Use -1 if you want to get the access level of the current user logged in...put a value in custom otherwise.
        switch(getAccessLevel()){
            case 1:{
                return "Teacher";
            }case 2:{
                return "Department Head";
            }case 3:{
                return "Curriculum Head";
            }case 4:{
                return "Registrar";
            }case 5:{
                return "Administrator";
            }default:{
                return "Guest";
            }
        }
    }
    public static void setAccessLevel(int accessLevel) {
        myVariables.accessLevel = accessLevel;
    }

    public static String getMsgUrlIconSuccess() {
        return msgUrlIconSuccess;
    }

    public static String getMsgUrlIconFailed() {
        return msgUrlIconFailed;
    }

    public static String getMsgUrlIconWarning() {
        return msgUrlIconWarning;
    }
    
    
    public static String getMsgUrlIcon() {
        return msgUrlIcon;
    }

    public static String getConfirmUrlIcon() {
        return confirmUrlIcon;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">

    public static String getLauncherIcon() {
        return launcherIcon;
    }
    
    public static String getHomeIcon() {
        return homeIcon;
    }

    public static String getSettingsIcon() {
        return settingsIcon;
    }

    public static String getAboutIcon() {
        return aboutIcon;
    }

    public static String getDivisionRepresentative() {
        return divisionRepresentative;
    }

    public static void setDivisionRepresentative(String divisionRepresentative) {
        myVariables.divisionRepresentative = divisionRepresentative;
    }

    public static String getDivisionSuperintendent() {
        return divisionSuperintendent;
    }

    public static void setDivisionSuperintendent(String divisionSuperintendent) {
        myVariables.divisionSuperintendent = divisionSuperintendent;
    }
    
    
    public static String getIpAddressOnly() {
        return ipAddressOnly;
    }

    public static void setIpAddressOnly(String ipAddressOnly) {
        myVariables.ipAddressOnly = ipAddressOnly;
    }
        
    public static String getFormsBtnIcon() {
        return formsBtnIcon;
    }

    public static String getFormsActBtnIcon() {
        return formsActBtnIcon;
    }
    
    public static String getRegistrationBtnIcon() {
        return registrationBtnIcon;
    }

    public static String getRegistrationActBtnIcon() {
        return registrationActBtnIcon;
    }

    public static String getEnrollmentBtnIcon() {
        return enrollmentBtnIcon;
    }

    public static String getEnrollmentActBtnIcon() {
        return enrollmentActBtnIcon;
    }

    public static String getAttendanceBtnIcon() {
        return attendanceBtnIcon;
    }

    public static String getAttendanceActBtnIcon() {
        return attendanceActBtnIcon;
    }

    public static String getWeighingBtnIcon() {
        return weighingBtnIcon;
    }

    public static String getWeighingActBtnIcon() {
        return weighingActBtnIcon;
    }

    public static String getBookKeepBtnIcon() {
        return bookKeepBtnIcon;
    }

    public static String getBookKeepActBtnIcon() {
        return bookKeepActBtnIcon;
    }

    public static String getGradingBtnIcon() {
        return gradingBtnIcon;
    }

    public static String getGradingActBtnIcon() {
        return gradingActBtnIcon;
    }
    
    
    
    public static int[] getGradesOrder() {
        return gradesOrder;
    }

    public static String getViewStudentsIcon() {
        return viewStudentsIcon;
    }

    public static String getGradingWindowIcon() {
        return gradingWindowIcon;
    }
    
    
    public static int[] getEnrollmentViewMinimalOrder(){
        return enrollmentViewMinimalOrder;
    }

    public static int[] getManagedSubjectsViewOrder() {
        return managedSubjectsViewOrder;
    }

    public static String getAttendanceWindowIcon() {
        return attendanceWindowIcon;
    }

    public static int[] getTeacherLoadsViewOrder() {
        return teacherLoadsViewOrder;
    }

    public static void setDebugMode(boolean onOff) {
        debugModeOn = onOff;
    }
    public static String getAssignSubjectTeacherIcon() {
        return assignSubjectTeacherIcon;
    }

    public static int[] getEnrollmentViewOrder() {
        return enrollmentViewOrder;
    }

    public static String getEnrollmentIcon() {
        return enrollmentIcon;
    }

    public static int[] getSectionsOrder() {
        return sectionsOrder;
    }
    
    
    public static String getSectionsIcon() {
        return sectionsIcon;
    }

    public static String getEnrollmentWindowIcon() {
        return enrollmentWindowIcon;
    }
    
    public static String getSchoolAddress() {
        return schoolAddress;
    }

    public static void setSchoolAddress(String schoolAddress) {
        myVariables.schoolAddress = schoolAddress;
    }
    
    
    public static int[] getSubjectLoadsOrder() {
        return subjectLoadsOrder;
    }

    public static int[] getUsersPersonalInfoOrder() {
        return usersPersonalInfoOrder;
    }
    
    
    public static int[] getStudentsPersonalInfoOrder() {
        return studentsPersonalInfoOrder;
    }
    
    public static String getFemaleIcon() {    
        return femaleIcon;
    }
    
    public static String getMaleIcon() {
        return maleIcon;
    }

    public static int[] getStudentsOrder() {
        return studentsOrder;
    }
    
    public static String getFormsIcon() {
        return formsIcon;
    }
    
    public static String getRegistrationWindowIcon() {
        return registrationWindowIcon;
    }
    
    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        myVariables.schoolName = schoolName;
    }

    public static String getSchoolId() {
        return schoolId;
    }

    public static void setSchoolId(String schoolId) {
        myVariables.schoolId = schoolId;
    }

    public static String getRegion() {
        return region;
    }

    public static void setRegion(String region) {
        myVariables.region = region;
    }

    public static String getDivision() {
        return division;
    }

    public static void setDivision(String division) {
        myVariables.division = division;
    }

    public static String getDistrict() {
        return district;
    }

    public static void setDistrict(String district) {
        myVariables.district = district;
    }

    public static String getPrincipal() {
        return principal;
    }

    public static void setPrincipal(String principal) {
        myVariables.principal = principal;
    }
    
    
    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        myVariables.ipAddress = ipAddress;
    }
    
    
    public static String getStudentsIcon() {
        return studentsIcon;
    }

    public static String getStudentsPrsnlInfIcon() {
        return studentsPrsnlInfIcon;
    }

    public static String getSubjectsIcon() {
        return subjectsIcon;
    }

    public static String getSubjeLoadsIcon() {
        return subjeLoadsIcon;
    }

    public static String getUsersIcon() {
        return usersIcon;
    }

    public static String getUsersPrsnlInfIcon() {
        return usersPrsnlInfIcon;
    }
    
    public static int getLoadingSpeed() {
        return loadingSpeed;
    }

    public static void setLoadingSpeed(int loadingSpeed) {
        myVariables.loadingSpeed = loadingSpeed;
    }
    //</editor-fold>

}
