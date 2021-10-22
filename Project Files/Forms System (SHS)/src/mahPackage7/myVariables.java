/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahPackage7;
import java.awt.Font;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Phil Rey
 */
public class myVariables {
    private static boolean debugModeOn = false;
    
    private static String ipAddress = "localhost";
    private static String schoolName = "Default_School_Name";
    private static String schoolId = "000001";
    private static String region = "XI";
    private static String division = "Default_Division";
    private static String district = "Default_Distict";
    private static String principal = "Default_Principal";
    private static String divisionRepresentative = "Default_Representative";
    private static String divisionSuperintendent = "Default_Superintendent";
    private static String schoolAddress = "Default_School_Address";
    
    private static int processingSpeed = 0;
    //Fonts
    public static final Font COLUMN_HEADER_FONT = new Font("Poppins SemiBold",Font.PLAIN,13);
    public static final Font COLUMN_FONT = new Font("Poppins",Font.PLAIN,13);
    
    public static final Font BUTTON_FONT = new Font("Poppins SemiBold",Font.PLAIN,12);
    public static final Font TAB_HEADER_FONT = new Font("Poppins SemiBold",Font.PLAIN,13);
    public static final Font TAB_FONT = new Font("Poppins SemiBold",Font.PLAIN,11);
    
    public static final Font TEXTFIELD_HEADER_FONT = new Font("Poppins SemiBold",Font.PLAIN,12);//e.g. First Name
    public static final Font TEXTFIELD_FONT = new Font("Poppins SemiBold",Font.PLAIN,12);
    public static final Font SEARCH_TEXTFIELD_FONT = new Font("Poppins SemiBold",Font.PLAIN,12);
    
    public static final Font TITLE_HEADER_FONT = new Font("Poppins SemiBold",Font.PLAIN,18); //e.g. Add New Subject
    public static final Font FORMS_HEADER_FONT = new Font("Poppins SemiBold",Font.PLAIN,14); // e.g. Basic Information
    
    public static final Font LABEL_FONT = new Font("Poppins SemiBold",Font.PLAIN,13); // e.g. Showing 5 results of 'to search'
    
    //Logged In User Details
    private static int userLoggedInId;
    private static String userLoggedInName;
    private static int accessLevel;
    
    //Selected Variables
    private static int formSelected;
    private static boolean selectAllSectionsForSf4;
    private static boolean selectAllSectionsForSf6;
    
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
    //Loading Dialog
    private static JProgressBar progressBar;
    private static JLabel lbLoadingMessage;
    private static JPanel loadingPanel;
    private static JFrame currentLoadingFrame;
    
    private static String [] return_values_result;
    
    //Table Orders
    private static final int [] usersOrder = new int [] {6,4,3,7,1,2,0,5};
    private static final int [] usersPersonalInfoOrder = new int [] {5,7,8,9,6,3,4,1,2,0};
    private static final int [] studentsOrder = new int [] {9,7,1,3,10,5,2,4,6,11,8};
    private static final int [] gradesOrder = new int [] {4,0,5,8,1,6,3,7,2,9,10};
    private static final int [] studentsPersonalInfoOrder = new int[] {13,9,11,15,16,4,10,3,5,6,0,8,14,2,7,12,1};
    private static final int [] subjectLoadsOrder = new int [] {0,3,2,1};
    private static final int [] sectionsOrder = new int [] {9,0,4,6,5,10,1,2,11,7,8,3};
    private static final int [] booksTemplatesOrder = new int [] {2,1,0,3};
    private static final int [] booksOrder = new int [] {2,0,3,1};
    private static final int [] booksIssuedReturnedOrder = new int [] {2,3,0,5,1,4,6};
    private static final int [] bmiOrder = new int [] {5,0,6,8,4,9,7,10,1,2,3};
    private static final int [] hfaChartOrder = new int [] {5,2,0,6,4,3,1};
    private static final int [] bmiChartOrder = new int [] {6,2,1,5,0,3,4};
    
    private static final int [] enrollmentViewOrder = new int [] {15,7,3,0,9,16,1,5,8,11,4,2,17,10,6,12,13,14};
    private static final int [] enrollmentViewMinimalOrder = new int [] {5,0,4,1,2,7,3,6};
    private static final int [] enrollmentViewMinWBdateOrder = new int [] {6,0,5,1,2,8,4,3,7};
    private static final int [] teacherLoadsViewOrder = new int [] {6,7,1,4,3,8,2,10,9,5,0};
    private static final int [] managedSubjectsViewOrder = new int [] {10,4,6,8,2,1,11,0,5,12,3,7,9};
    private static final int [] managedSubjectsWTemplateViewOrder = new int [] {13,5,8,10,3,2,14,1,7,15,4,9,12,0,11,6};
    private static final int [] managedSubjectsWSubjectsContainedViewOrder = new int [] {13,5,8,10,3,1,14,0,6,15,4,9,12,11,7,2};
        
    private static final int [] attendanceOrder = new int [] {2,0,3,4,6,5,1};
    private static final int [] subjectOrder = new int[] {2,3,1,0};
    
    //School Form Views
    private static final int [] jhsf1Order= new int [] {18,12,8,7,1,13,19,5,15,20,22,6,14,4,9,10,0,3,16,2,11,17,21};
    private static final int [] jhsf2Order= new int [] {5,6,0,1,2,7,3,4,8};
    private static final int [] jhsf3Order= new int [] {4,5,0,1,2,6,3};
    private static final int [] jhsf5MinimalOrder=new int [] {11,4,8,7,3,0,9,12,2,13,1,10,5,6};
    private static final int [] jhsf5FullOrder=new int [] {15,6,8,14,10,13,4,3,16,9,5,0,11,17,2,18,1,12,7};
    private static final int [] jhsf7TeachersOrder= new int [] {10,6,5,3,12,0,7,11,2,4,8,1,9};
    private static final int [] jhsf7LoadsOrder= new int [] {5,2,6,0,8,7,3,1,4};
    private static final int [] jhsf8Order= new int [] {12,7,6,4,0,9,13,10,3,1,15,5,16,14,17,8,2,11};
    private static final int [] jhsf9Order= new int [] {9,7,3,5,11,2,0,10,1,4,8,12,6};
    private static final int [] jhsf10Order= new int [] {17,9,5,0,12,18,2,7,10,14,6,3,19,1,13,8,11,4,15,20,16};
    private static int [] finalGradesOrder = new int [] {3,4,0,1,2,5,6};
    private static int [] gradesViewOrder = new int []{11,4,7,10,2,1,12,0,5,13,3,9,8,14,6};
    
    //Icons
    private static final String studentsIcon = "icons/icons8_user_groups_skin_type_7_20px_1.png";
    private static final String studentsPrsnlInfIcon = "icons/icons8_resume_20px.png";
    private static final String subjectsIcon = "icons/icons8_book_shelf_20px.png";
    private static final String subjeLoadsIcon = "icons/icons8_books_20px.png";
    private static final String usersIcon = "icons/icons8_teacher_20px.png";
    private static final String usersPrsnlInfIcon = "icons/icons8_name_tag_20px.png";
    private static final String formsIcon = "icons/icons8_microsoft_excel_2019_20px.png";
    private static final String selectFormsIcon = "icons/icons8_google_forms_20px.png";
    private static final String enrollmentIcon = "icons/icons8_user_groups_skin_type_7_20px_1.png";
    private static final String assignSubjectTeacherIcon = "icons/icons8_audit_20px.png";
    private static final String booksIcon = "icons/icons8_books_20px.png";
    private static final String bookTemplatesIcon = "icons/icons8_book_shelf_20px.png";
    private static final String dailyIcon = "icons/icons8_haze_16px.png";
    private static final String monthlyIcon = "icons/icons8_calendar_16px.png";
    private static final String promotionIcon = "icons/icons8_graduate_20px.png";
    private static final String summaryOfPromotionIcon = "icons/icons8_combo_chart_20px.png";
    
    private static final String sectionsIcon = "icons/icons8_page_20px.png";
    private static final String viewStudentsIcon = "icons/icons8_read_online_20px.png";
    
    private static final String lateCommerIcon = "icons/late_commer.png";
    private static final String cuttingClassesIcon = "icons/cutting_classes.png";
    
    private static final String freshemenIcon = "icons/icons8_babys_room_20px.png";
    private static final String sophomoreIcon = "icons/icons8_boy_20px.png";
    private static final String juniorIcon = "icons/icons8_students_20px.png";
    private static final String seniorIcon = "icons/icons8_student_male_20px.png";
    
    private static final String selectStudentIcon = "icons/icons8_read_online_16px.png";
    private static final String selectEnrolledSectionsIcon = "icons/icons8_classroom_16px.png";
    private static final String permanentRecordIcon = "icons/icons8_mortarboard_16px_1.png";
    
    //Window Icons
    private static final String attendanceWindowIcon = "icons/attendanceIcon.png";
    private static final String registrationWindowIcon = "icons/registerIcon.png";
    private static final String enrollmentWindowIcon = "icons/enrollmentIcon.png";
    private static final String formsWindowIcon = "icons/formsIcon.png";
    private static final String gradingWindowIcon = "icons/gradingIcon.png";
    private static final String bookKeepingWindowIcon = "icons/bookIcon.png";
    private static final String weighingWindowIcon = "icons/weighingIcon.png";
    //Dropdown Icons
    private static final String maleIcon = "icons/icons8_male_16px.png";
    private static final String femaleIcon = "icons/icons8_female_16px.png";
    private static final String infoIcon = "icons/icons8_info_16px.png";
    
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
    
    public static Font getColFont() {
        return COLUMN_FONT;
    }
    
    public static int[] getBooksOrder() {
        return booksOrder;
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
    
    public static void setSectionSelected(int sectionSelected) {
        myVariables.sectionSelected = sectionSelected;
    }

    public static int[] getJhsf1Order() {
        return jhsf1Order;
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
        if(customLevel != -1){
            switch(customLevel){
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
        }else{
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

    public static String getFreshemenIcon() {
        return freshemenIcon;
    }

    public static String getSophomoreIcon() {
        return sophomoreIcon;
    }

    public static String getJuniorIcon() {
        return juniorIcon;
    }

    public static String getSeniorIcon() {
        return seniorIcon;
    }
    
    public static String getSelectStudentIcon() {
        return selectStudentIcon;
    }

    public static String getSelectEnrolledSectionsIcon() {
        return selectEnrolledSectionsIcon;
    }

    public static String getPermanentRecordIcon() {
        return permanentRecordIcon;
    }
    
    public static int[] getJhsf3Order() {
        return jhsf3Order;
    }

    public static boolean isSelectAllSectionsForSf4() {
        return selectAllSectionsForSf4;
    }
    
    public static void setSelectAllSectionsForSf4(boolean selectAllSectionsForSf4) {    
        myVariables.selectAllSectionsForSf4 = selectAllSectionsForSf4;
    }

    public static String getInfoIcon() {
        return infoIcon;
    }

    public static int[] getJhsf2Order() {
        return jhsf2Order;
    }

    public static String getDailyIcon() {
        return dailyIcon;
    }
    
    public static String getMonthlyIcon() {    
        return monthlyIcon;
    }

    public static String getSelectFormsIcon() {
        return selectFormsIcon;
    }

    public static int getFormSelected() {
        return formSelected;
    }
    public static void setFormSelected(int formSelected) {    
        myVariables.formSelected = formSelected;
    }

    public static JProgressBar getProgressBar() {
        return progressBar;
    }

    public static void setProgressBar(JProgressBar progressBar) {
        myVariables.progressBar = progressBar;
    }

    public static JLabel getLbLoadingMessage() {
        return lbLoadingMessage;
    }

    public static void setLbLoadingMessage(JLabel lbLoadingMessage) {
        myVariables.lbLoadingMessage = lbLoadingMessage;
    }

    public static JPanel getLoadingPanel() {
        return loadingPanel;
    }
    public static String[] getReturn_values_result() {
        return return_values_result;
    }

    public static void setReturn_values_result(String[] return_values_result) {    
        myVariables.return_values_result = return_values_result;
    }

    public static JFrame getCurrentLoadingFrame() {
        return currentLoadingFrame;
    }

    public static void setCurrentLoadingFrame(JFrame currentLoadingFrame) {
        myVariables.currentLoadingFrame = currentLoadingFrame;
    }
    
    
    public static void setLoadingPanel(JPanel loadingPanel) {    
        myVariables.loadingPanel = loadingPanel;
    }

    public static int[] getBmiOrder() {
        return bmiOrder;
    }

    public static int[] getBmiChartOrder() {
        return bmiChartOrder;
    }

    public static int[] getHfaChartOrder() {
        return hfaChartOrder;
    }

    public static int[] getEnrollmentViewMinWBdateOrder() {
        return enrollmentViewMinWBdateOrder;
    }

    public static String getWeighingWindowIcon() {
        return weighingWindowIcon;
    }

    public static int[] getBooksIssuedReturnedOrder() {
        return booksIssuedReturnedOrder;
    }

    public static int[] getManagedSubjectsWTemplateViewOrder() {
        return managedSubjectsWTemplateViewOrder;
    }

    public static int[] getBooksTemplatesOrder() {
        return booksTemplatesOrder;
    }
        
    public static String getBooksIcon() {
        return booksIcon;
    }
    
    public static String getBookTemplatesIcon() {    
        return bookTemplatesIcon;
    }

    public static String getBookKeepingWindowIcon() {
        return bookKeepingWindowIcon;
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

    public static int[] getJhsf5MinimalOrder() {
        return jhsf5MinimalOrder;
    }

    public static String getPromotionIcon() {
        return promotionIcon;
    }

    public static String getSummaryOfPromotionIcon() {
        return summaryOfPromotionIcon;
    }
    
    public static String getUsersPrsnlInfIcon() {
        return usersPrsnlInfIcon;
    }
    
    public static boolean isSelectAllSectionsForSf6() {
        return selectAllSectionsForSf6;
    }

    public static int[] getJhsf8Order() {
        return jhsf8Order;
    }
    public static void setSelectAllSectionsForSf6(boolean selectAllSectionsForSf6) {    
        myVariables.selectAllSectionsForSf6 = selectAllSectionsForSf6;
    }

    public static int[] getManagedSubjectsWSubjectsContainedViewOrder() {
        return managedSubjectsWSubjectsContainedViewOrder;
    }
    
    public static int[] getGradesViewOrder() {
        return gradesViewOrder;
    }
    
    public static int[] getFinalGradesOrder() {
        return finalGradesOrder;
    }
    
    public static int[] getJhsf5FullOrder() {
        return jhsf5FullOrder;
    }

    public static int[] getJhsf10Order() {
        return jhsf10Order;
    }

    public static int[] getJhsf9Order() {
        return jhsf9Order;
    }

    public static int[] getJhsf7TeachersOrder() {
        return jhsf7TeachersOrder;
    }

    public static int[] getJhsf7LoadsOrder() {
        return jhsf7LoadsOrder;
    }
    
    public static String getLateCommerIcon() {
        return lateCommerIcon;
    }

    public static String getCuttingClassesIcon() {
        return cuttingClassesIcon;
    }
    public static int getProcessingSpeed() {
        return processingSpeed;
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
    
    public static long [] getProcessingSpeedValue(){
        switch (getProcessingSpeed()){
            case 0:{
                return new long[] {100,500};
            }case 1:{
                return new long[] {50,250};
            }case 2:{
                return new long[] {25,125};
            }case 3:{
                //Hidden Value WARNING: may cause stuttering
                return new long[] {0,0};
            }default:{
                return new long[] {100,500};
            }
        }
    }
    public static void setProcessingSpeed(int processingSpeed) {
        myVariables.processingSpeed = processingSpeed;
    }
    //</editor-fold>
}