/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import DB.DataBaseConnection;
import DTO.Course;
import DTO.Department;
import DTO.Grade;
import DTO.Program;
import DTO.Report;
import DTO.Student;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 *
 * @author Ali Magdy
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Label head;

     @FXML
    private Button student_btn;

    @FXML
    private Button department_btn;

    @FXML
    private Button programs_btn;
    
    @FXML
    private Button Courses_btn;
    
    @FXML
    private Button Grade_btn;
    
    
    @FXML
    private Button Report_btn;
    
    @FXML
    private AnchorPane Student_Form;
    @FXML
    private TableView<Student> Student_Table_View;

    @FXML
    private TableColumn<Student, Long> addStudents_col_studentNum;

     @FXML
    private TableColumn<Student, String> addStudents_col_FirstName;

    @FXML
    private TableColumn<Student, String> addStudents_col_LastName;
    
    @FXML
    private TableColumn<Student, String> addStudents_col_Gender;

    @FXML
    private TableColumn<Student, String> addStudents_col_Phone;

    @FXML
    private TableColumn<Student, String> addStudents_col_Email;

    @FXML
    private TableColumn<Student, String> addStudents_col_City;

    @FXML
    private TableColumn<Student, String> addStudents_col_Street;

    @FXML
    private TableColumn<Student, Long> addStudents_col_ProgramID;
    
     @FXML
    private TableColumn<Student, Float> gpa_col;

    @FXML
    private TextField nat_id;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private TextField city;

    @FXML
    private TextField street;
    
    @FXML
    private TextField searchstudent;
    
    
    @FXML
    private ComboBox<String> combo_prog;
    
    
    @FXML
    private Button Clearstudent;

    @FXML
    private Button Deletestudent;

    @FXML
    private Button updatestudent;

    @FXML
    private Button Addstudent;
    @FXML
    private ComboBox<String> combo_gender;
    
     @FXML
    private AnchorPane Department_Form;

    @FXML
    private TextField searchdepartment;

    @FXML
    private TableView<Department> Department_Table_View;

    @FXML
    private TableColumn<Department,Integer> DepID_col;

    @FXML
    private TableColumn<Department,String> DepName_col;

    @FXML
    private TextField depid;

    @FXML
    private TextField depname;

    @FXML
    private Button cleardepartment;

    @FXML
    private Button deletedepartment;

    @FXML
    private Button updatedepartment;

    @FXML
    private Button adddepartmnet;
    
    @FXML
    private AnchorPane Program_Form;

    @FXML
    private TextField searchprogram;

    @FXML
    private TableView<Program> Program_Table_View;

    @FXML
    private TableColumn<Program, Integer> ProgID_col;

    @FXML
    private TableColumn<Program,String> ProgName_col;

    @FXML
    private TableColumn<Program, Integer> DepIDF_col;

    @FXML
    private ComboBox<String> Combo_DepID;

    @FXML
    private TextField progname;

    @FXML
    private Button clearprogram;

    @FXML
    private Button deleteprogram;

    @FXML
    private Button updateprogram;

    @FXML
    private Button addprogram;

    @FXML
    private TextField progid;
    
    @FXML
    private AnchorPane Course_Form;

    @FXML
    private TextField searchcourse;

    @FXML
    private TableView<Course> Course_Table_View1;

    @FXML
    private TableColumn<Course,Integer> CourseID_col;

    @FXML
    private TableColumn<Course,String> CourseName_col;

    @FXML
    private TableColumn<Course,Integer> ProgIDF_col;

    @FXML
    private TextField Coursename;

    @FXML
    private Button clearcourse;

    @FXML
    private Button deletecourse;

    @FXML
    private Button updatecourse;

    @FXML
    private Button addcourse;

    @FXML
    private TextField coursegid;

    @FXML
    private ComboBox<String> Combo_ProgID;
    
     @FXML
    private AnchorPane Grade_Form;

    @FXML
    private TextField searchgrade;

    @FXML
    private TableView<Grade> Grade_Table_View11;

    @FXML
    private TableColumn<Grade,Long> nationalID_col;

    @FXML
    private TableColumn<Grade,Integer> courseID_col;

    @FXML
    private TableColumn<Grade,String> year_col;

    @FXML
    private TableColumn<Grade,String> semester_col;

    @FXML
    private TableColumn<Grade,Integer> grade_col;

    @FXML
    private Button cleargrade;

    @FXML
    private Button deletegrade;

    @FXML
    private Button updategrade;

    @FXML
    private Button addgrade;

    @FXML
    private TextField year;

    @FXML
    private ComboBox<String> combo_natid;

    @FXML
    private ComboBox<String> combo_courseid;

    @FXML
    private TextField grade;

    @FXML
    private ComboBox<String> combo_semester;

        @FXML
    private AnchorPane Report_Form;

    @FXML
    private TextField searchreport;

    @FXML
    private TableView<Report> Report_Table_View;

    @FXML
    private TableColumn<Report, Integer> lol1_col;

    @FXML
    private TableColumn<Report, String> lol2_col;

    @FXML
    private TableColumn<Report, Integer> lol3_col;

    @FXML
    private TableColumn<Report, Float> lol4_col;

    @FXML
    private Button print;
    
    @FXML
    private BarChart<String, Double> CourseGpaChart;
    
        @FXML
    private PieChart pieChart;

    
    public void switchForm(ActionEvent event) {
        if (event.getSource() == student_btn) {
            Student_Form.setVisible(true);
            Department_Form.setVisible(false);
            Program_Form.setVisible(false);
            Course_Form.setVisible(false);
            Grade_Form.setVisible(false);
            Report_Form.setVisible(false);
            
            student_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");
            department_btn.setStyle("-fx-background-color:transparent");
            programs_btn.setStyle("-fx-background-color:transparent");
            Courses_btn.setStyle("-fx-background-color:transparent");
            Grade_btn.setStyle("-fx-background-color:transparent");
            Report_btn.setStyle("-fx-background-color:transparent");
            
            addStudentsShowListData();
            addStudentsGenderList();
            addStudentsSearch();
        

        } else if (event.getSource() == department_btn) {
            Student_Form.setVisible(false);
            Department_Form.setVisible(true);
            Program_Form.setVisible(false);
            Course_Form.setVisible(false);
            Grade_Form.setVisible(false);
            Report_Form.setVisible(false);
            
            student_btn.setStyle("-fx-background-color:transparent");
            department_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");
            programs_btn.setStyle("-fx-background-color:transparent");
            Courses_btn.setStyle("-fx-background-color:transparent");
            Grade_btn.setStyle("-fx-background-color:transparent");
            Report_btn.setStyle("-fx-background-color:transparent");
            
            addDepartmentShowListData();
            addDepartmentSearch();
        }
        
        else if (event.getSource() == programs_btn) {
            Student_Form.setVisible(false);
            Department_Form.setVisible(false);
            Program_Form.setVisible(true);
            Course_Form.setVisible(false);
            Grade_Form.setVisible(false);
            Report_Form.setVisible(false);
            
            student_btn.setStyle("-fx-background-color: transparent;");
            department_btn.setStyle("-fx-background-color: transparent;");
            programs_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");
            Courses_btn.setStyle("-fx-background-color: transparent;");
            Grade_btn.setStyle("-fx-background-color: transparent;");
            Report_btn.setStyle("-fx-background-color: transparent;");

            
            
             addProgramShowListData();
             addProgramSearch();
             addProgramDepartmentList();
        }
        else if (event.getSource() == Courses_btn) {
            Student_Form.setVisible(false);
            Department_Form.setVisible(false);
            Program_Form.setVisible(false);
            Course_Form.setVisible(true);
            Grade_Form.setVisible(false);
            Report_Form.setVisible(false);
            
            student_btn.setStyle("-fx-background-color: transparent;");
            department_btn.setStyle("-fx-background-color: transparent;");
            programs_btn.setStyle("-fx-background-color: transparent;");
            Courses_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");
            Grade_btn.setStyle("-fx-background-color: transparent;");
            Report_btn.setStyle("-fx-background-color: transparent;");

             addCourseProgramList();
             addCourseShowListData();
             addCourseSearch();
        }
        else if (event.getSource() == Grade_btn) {
            Student_Form.setVisible(false);
            Department_Form.setVisible(false);
            Program_Form.setVisible(false);
            Course_Form.setVisible(false);
            Grade_Form.setVisible(true);
            Report_Form.setVisible(false);
            
            student_btn.setStyle("-fx-background-color: transparent;");
            department_btn.setStyle("-fx-background-color: transparent;");
            programs_btn.setStyle("-fx-background-color: transparent;");
            Courses_btn.setStyle("-fx-background-color: transparent;");
            Grade_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");
            Report_btn.setStyle("-fx-background-color: transparent;");

            addGradeSemesterList();
            addGradeNationalIDList();
            addGradeCourseIDList();
            addGradeListData();
            addGradeShowListData();
            addGradeSearch();
        }
        else if (event.getSource() == Report_btn) {
            Student_Form.setVisible(false);
            Department_Form.setVisible(false);
            Program_Form.setVisible(false);
            Course_Form.setVisible(false);
            Grade_Form.setVisible(false);
            Report_Form.setVisible(true);
            student_btn.setStyle("-fx-background-color: transparent;");
            department_btn.setStyle("-fx-background-color: transparent;");
            programs_btn.setStyle("-fx-background-color: transparent;");
            Courses_btn.setStyle("-fx-background-color: transparent;");
            Grade_btn.setStyle("-fx-background-color: transparent;");
            Report_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #3498db, #2c3e50);");

            addReportListData();
            addReportShowListData();
            addReportSearch();
            
        }
    }
    
    private String[] genderList = {"Male", "Female"};

    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        combo_gender.setItems(ObList);
    }
    
    private String[] semesterList = {"First", "Second"};

    public void addGradeSemesterList() {
        List<String> semesterL = new ArrayList<>();

        for (String data : semesterList) {
            semesterL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(semesterL);
        combo_semester.setItems(ObList);
    }
    
    public void addStudentsProgramList() {

        String listCourse = "select prog_id from program";

        connect = DataBaseConnection.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("prog_id"));
            }
            combo_prog.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addGradeNationalIDList() {

        String listCourse = "select nat_id from Student";

        connect = DataBaseConnection.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("nat_id"));
            }
            combo_natid.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addGradeCourseIDList() {

        String listCourse = "select course_id from course";

        connect = DataBaseConnection.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("course_id"));
            }
            combo_courseid.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void addProgramDepartmentList() {

        String listCourse = "select Dep_ID from department";

        connect = DataBaseConnection.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("dep_id"));
            }
            Combo_DepID.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addCourseProgramList() {

        String listCourse = "select Prog_ID from Program";

        connect = DataBaseConnection.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("prog_id"));
            }
            Combo_ProgID.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
        public ObservableList<Student> addStudentsListData() {

        ObservableList<Student> listStudents = FXCollections.observableArrayList();
        
        connect = DataBaseConnection.connectDb();
        String sql = "select NAT_ID, F_NAME, L_NAME, GENDER, PHONE, EMAIL, CITY, STREET, PROG_ID , CALCULATE_GPA (nat_ID) as GPA from student";
        

        try {
            Student studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new Student(result.getLong("NAT_ID"),
                        result.getString("F_Name"),
                        result.getString("L_Name"),
                        result.getString("GENDER"),
                        result.getString("PHONE"),
                        result.getString("EMAIL"),
                        result.getString("City"),
                        result.getString("Street"),
                        result.getLong("PROG_ID"),
                        result.getFloat("GPA"));

                listStudents.add(studentD);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }
        
    public ObservableList<Department> addDepartmentListData() {

        ObservableList<Department> listDepartment = FXCollections.observableArrayList();
        
        connect = DataBaseConnection.connectDb();
        String sql = "select * from Department";
        

        try {
            Department departmentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                departmentD = new Department(result.getInt("DEP_ID"),
                        result.getString("DEP_Name"));

                listDepartment.add(departmentD);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartment;
    }
    
    public ObservableList<Program> addProgramListData() {

        ObservableList<Program> listProgram = FXCollections.observableArrayList();
        
        connect = DataBaseConnection.connectDb();
        String sql = "select * from Program";
        

        try {
            Program programD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                programD = new Program(result.getInt("PROG_ID"),
                        result.getString("PROG_NAME"),
                        result.getInt("DEP_ID")
                );
                listProgram.add(programD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProgram;
    }
    
    public ObservableList<Course> addCourseListData() {

        ObservableList<Course> listCourse = FXCollections.observableArrayList();
        
        connect = DataBaseConnection.connectDb();
        String sql = "select * from Course";
        

        try {
            Course courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new Course(result.getInt("COURSE_ID"),
                        result.getString("COURSE_NAME"),
                        result.getInt("PROG_ID")
                );
                listCourse.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCourse;
    }
    
    public ObservableList<Grade> addGradeListData() {

    ObservableList<Grade> listGrade = FXCollections.observableArrayList();

    connect = DataBaseConnection.connectDb();
    String sql = "select * from student_course";

    try {
        Grade gradeD;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            gradeD = new Grade(
                    result.getLong("NAT_ID"),
                    result.getInt("COURSE_ID"),
                    result.getString("YEAR"),
                    result.getString("SEMESTER"),
                    result.getInt("GRADE")
            );
            listGrade.add(gradeD);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listGrade;
}
    
    public ObservableList<Report> addReportListData() {

    ObservableList<Report> listReport = FXCollections.observableArrayList();

    connect = DataBaseConnection.connectDb();
    String sql = "select course_id,course_name , count(nat_id) as Enrolled_Student , CALCULATE_COURSE_GPA(course_id) as Course_Avg_GPA\n" +
                "from student s , course c\n" +
                "where S.PROG_ID=C.PROG_ID\n" +
                "group by course_name , course_id";

    try {
        Report reportD;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()) {
            reportD = new Report(
                    result.getInt("COURSE_ID"),
                    result.getString("COURSE_NAME"),
                    result.getInt("ENROLLED_STUDENT"),
                    result.getFloat("COURSE_AVG_GPA")         
            );
            listReport.add(reportD);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return listReport;
}

    private ObservableList<Student> addStudentsListD;
    

    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("NationalID"));
        addStudents_col_FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        addStudents_col_LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        addStudents_col_Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        addStudents_col_Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        addStudents_col_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        addStudents_col_City.setCellValueFactory(new PropertyValueFactory<>("City"));
        addStudents_col_Street.setCellValueFactory(new PropertyValueFactory<>("Street"));
        addStudents_col_ProgramID.setCellValueFactory(new PropertyValueFactory<>("ProgramID"));
        gpa_col.setCellValueFactory(new PropertyValueFactory<>("GPA"));

        Student_Table_View.setItems(addStudentsListD);

    }
    
    private ObservableList<Program> addProgramListD;

    public void addProgramShowListData() {
        addProgramListD = addProgramListData();

        ProgID_col.setCellValueFactory(new PropertyValueFactory<>("ProgramID"));
        ProgName_col.setCellValueFactory(new PropertyValueFactory<>("ProgramName"));
        DepIDF_col.setCellValueFactory(new PropertyValueFactory<>("DepartmentID"));

        Program_Table_View.setItems(addProgramListD);
    }

    
    private ObservableList<Department> addDepartmentListD;
    
    public void addDepartmentShowListData() {
        addDepartmentListD = addDepartmentListData();

        DepID_col.setCellValueFactory(new PropertyValueFactory<>("DepartmentID"));
        DepName_col.setCellValueFactory(new PropertyValueFactory<>("DepartmentName"));
        Department_Table_View.setItems(addDepartmentListD);

    }
    
    private ObservableList<Course> addCourseListD;

public void addCourseShowListData() {
    addCourseListD = addCourseListData();

    CourseID_col.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
    CourseName_col.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
    ProgIDF_col.setCellValueFactory(new PropertyValueFactory<>("ProgramID"));

    Course_Table_View1.setItems(addCourseListD);
}

private ObservableList<Grade> addGradeListD;

public void addGradeShowListData() {
    addGradeListD = addGradeListData();

    nationalID_col.setCellValueFactory(new PropertyValueFactory<>("NationalID"));
    courseID_col.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
    year_col.setCellValueFactory(new PropertyValueFactory<>("Year"));
    semester_col.setCellValueFactory(new PropertyValueFactory<>("Semester"));
    grade_col.setCellValueFactory(new PropertyValueFactory<>("Grade"));

    Grade_Table_View11.setItems(addGradeListD);
}

    private ObservableList<Report> addReportListD;

public void addReportShowListData() {
    addReportListD = addReportListData();

    lol1_col.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
    lol2_col.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
    lol3_col.setCellValueFactory(new PropertyValueFactory<>("EnrolledStudent"));
    lol4_col.setCellValueFactory(new PropertyValueFactory<>("GPA"));
    

    Report_Table_View.setItems(addReportListD);
}
    
     public void addStudentsSelect() {

        Student studentD = Student_Table_View.getSelectionModel().getSelectedItem();
        int num = Student_Table_View.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        nat_id.setText(String.valueOf(studentD.getNationalID()));
        fname.setText(studentD.getFirstName());
        lname.setText(studentD.getLastName());
        phone.setText(studentD.getPhone());
        email.setText(studentD.getEmail());
        city.setText(studentD.getCity());
        street.setText(studentD.getStreet());
        combo_prog.setValue(String.valueOf(studentD.getProgramID()));
        combo_gender.setValue(String.valueOf(studentD.getGender()));
        
    }
     
     public void addDepartmentSelect() {

        Department departmentD = Department_Table_View.getSelectionModel().getSelectedItem();
        int num = Department_Table_View.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        depid.setText(String.valueOf(departmentD.getDepartmentID()));
        depname.setText(departmentD.getDepartmentName());

        
    }
     
     public void addProgramSelect() {

    Program programD = Program_Table_View.getSelectionModel().getSelectedItem();
    int num = Program_Table_View.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

    progid.setText(String.valueOf(programD.getProgramID()));
    progname.setText(programD.getProgramName());
    Combo_DepID.setValue(String.valueOf(programD.getDepartmentID()));
}
     public void addGradeSelect() {
    Grade gradeD = Grade_Table_View11.getSelectionModel().getSelectedItem();
    int num = Grade_Table_View11.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

    // Assuming you've changed NationalID to Long in your Grade class
    combo_natid.setValue(String.valueOf(gradeD.getNationalID()));
    combo_courseid.setValue(String.valueOf(gradeD.getCourseID()));
    year.setText(gradeD.getYear());
    combo_semester.setValue(gradeD.getSemester());
    grade.setText(String.valueOf(gradeD.getGrade()));
}

     
     public void addCourseSelect() {
    Course courseD = Course_Table_View1.getSelectionModel().getSelectedItem();
    int num = Course_Table_View1.getSelectionModel().getSelectedIndex();

    if ((num - 1) < -1) {
        return;
    }

    coursegid.setText(String.valueOf(courseD.getCourseID()));
    Coursename.setText(courseD.getCourseName());
    Combo_ProgID.setValue(String.valueOf(courseD.getProgramID()));
}

     
      public void addStudentsSearch() {

        FilteredList<Student> filter = new FilteredList<>(addStudentsListD, e -> true);

        searchstudent.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getNationalID().toString().contains(searchKey)) {
                    return true;
                
                } else if (predicateStudentData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGender().toLowerCase().contains(searchKey)) {
                    return true;     
                }
                else if (predicateStudentData.getPhone().toLowerCase().contains(searchKey)) {
                    return true;
                }
                else if (predicateStudentData.getProgramID().toString().contains(searchKey)) {
                    return true;
                    
                }
                else if (predicateStudentData.getCity().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStreet().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Student> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(Student_Table_View.comparatorProperty());
        Student_Table_View.setItems(sortList);

    }

    public void addDepartmentSearch() {

        FilteredList<Department> filter = new FilteredList<>(addDepartmentListD, e -> true);

        searchdepartment.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateDepartmentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateDepartmentData.getDepartmentID().toString().contains(searchKey)) {
                    return true;
                
                } else if (predicateDepartmentData.getDepartmentName().toLowerCase().contains(searchKey)) {
                    return true;
                }  else {
                    return false;
                }
            });
        });

        SortedList<Department> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(Department_Table_View.comparatorProperty());
        Department_Table_View.setItems(sortList);

    }
    
    public void addProgramSearch() {

    FilteredList<Program> filter = new FilteredList<>(addProgramListD, e -> true);

    searchprogram.textProperty().addListener((Observable, oldValue, newValue) -> {

        filter.setPredicate(predicateProgramData -> {

            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (String.valueOf(predicateProgramData.getProgramID()).contains(searchKey)) {
                return true;
            } else if (predicateProgramData.getProgramName().toLowerCase().contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateProgramData.getDepartmentID()).contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<Program> sortList = new SortedList<>(filter);

    sortList.comparatorProperty().bind(Program_Table_View.comparatorProperty());
    Program_Table_View.setItems(sortList);
}
    public void addCourseSearch() {
    FilteredList<Course> filter = new FilteredList<>(addCourseListD, e -> true);

    searchcourse.textProperty().addListener((Observable, oldValue, newValue) -> {

        filter.setPredicate(predicateCourseData -> {

            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (String.valueOf(predicateCourseData.getCourseID()).contains(searchKey)) {
                return true;
            } else if (predicateCourseData.getCourseName().toLowerCase().contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateCourseData.getProgramID()).contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<Course> sortList = new SortedList<>(filter);

    sortList.comparatorProperty().bind(Course_Table_View1.comparatorProperty());
    Course_Table_View1.setItems(sortList);
}
    
    
    public void addGradeSearch() {
    FilteredList<Grade> filter = new FilteredList<>(addGradeListD, e -> true);

    searchgrade.textProperty().addListener((Observable, oldValue, newValue) -> {

        filter.setPredicate(predicateGradeData -> {

            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (String.valueOf(predicateGradeData.getNationalID()).contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateGradeData.getCourseID()).contains(searchKey)) {
                return true;
            } else if (predicateGradeData.getYear().toLowerCase().contains(searchKey)) {
                return true;
            } else if (predicateGradeData.getSemester().toLowerCase().contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateGradeData.getGrade()).contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<Grade> sortList = new SortedList<>(filter);

    sortList.comparatorProperty().bind(Grade_Table_View11.comparatorProperty());
    Grade_Table_View11.setItems(sortList);
}
    
    public void addReportSearch() {
    FilteredList<Report> filter = new FilteredList<>(addReportListD, e -> true);

    searchreport.textProperty().addListener((Observable, oldValue, newValue) -> {

        filter.setPredicate(predicateReportData -> {

            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String searchKey = newValue.toLowerCase();

            if (String.valueOf(predicateReportData.getCourseID()).contains(searchKey)) {
                return true;
            } else if (predicateReportData.getCourseName().toLowerCase().contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateReportData.getEnrolledStudent()).contains(searchKey)) {
                return true;
            } else if (String.valueOf(predicateReportData.getGPA()).contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
    });

    SortedList<Report> sortList = new SortedList<>(filter);

    sortList.comparatorProperty().bind(Report_Table_View.comparatorProperty());
    Report_Table_View.setItems(sortList);
}


     
      public void addStudentsClear() {
        nat_id.setText("");
        fname.setText("");
        lname.setText("");
        phone.setText("");
        email.setText("");
        city.setText("");
        street.setText("");
        combo_gender.getSelectionModel().clearSelection();
        combo_prog.getSelectionModel().clearSelection();
    }
      public void adddepartmentClear() {
        depid.setText("");
        depname.setText("");
    }
      
    public void addProgramClear() {
    progid.setText("");
    progname.setText("");
    Combo_DepID.setValue(null); 
}
    public void addCourseClear() {
    coursegid.setText("");
    Coursename.setText("");
    Combo_ProgID.setValue(null);
}
    public void addGradeClear() {

    year.setText("");
    grade.setText("");
    combo_natid.setValue(null);
    combo_courseid.setValue(null);
    combo_semester.setValue(null);
}

      
      public void addStudentsAdd() {
    String insertData = "INSERT INTO student (NAT_ID, F_NAME, L_NAME, GENDER, PHONE, EMAIL, CITY, STREET, PROG_ID) VALUES (?,?,?,?,?,?,?,?,?)";
    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (nat_id.getText().isEmpty()
                || combo_gender.getSelectionModel().getSelectedItem() == null
                || combo_prog.getSelectionModel().getSelectedItem() == null
                || fname.getText().isEmpty()
                || lname.getText().isEmpty()
                || phone.getText().isEmpty()
                || email.getText().isEmpty()
                || city.getText().isEmpty()
                || street.getText().isEmpty()) 
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else if (!nat_id.getText().matches("\\d{14}")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("NAT ID must be exactly 14 digits");
            alert.showAndWait();
        }
        else if (!phone.getText().matches("\\d{11}")) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Phone number must be exactly 11 digits");
            alert.showAndWait();
        }else {
            // CHECK IF THE STUDENT NUMBER IS ALREADY EXIST
            String checkData = "SELECT nat_id FROM student WHERE nat_id = ?";
            prepare = connect.prepareStatement(checkData);
            prepare.setString(1, nat_id.getText());
            result = prepare.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student #" + nat_id.getText() + " already exists!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, nat_id.getText());
                prepare.setString(2, fname.getText());
                prepare.setString(3, lname.getText());
                prepare.setString(4, (String) combo_gender.getSelectionModel().getSelectedItem());
                prepare.setString(5, phone.getText());
                prepare.setString(6, email.getText());
                prepare.setString(7, city.getText());
                prepare.setString(8, street.getText());
                prepare.setString(9, (String) combo_prog.getSelectionModel().getSelectedItem());

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addStudentsShowListData();
                // TO CLEAR THE FIELDS
                addStudentsClear();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

      
      public void addProgramAdd() {

    String insertData = "insert into Program(PROG_ID, PROG_NAME, DEP_ID) values (?,?,?)";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (progid.getText().isEmpty()
            || progname.getText().isEmpty()
            || Combo_DepID.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else if (!progid.getText().matches("\\d+")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Program ID must contain only numbers");
                alert.showAndWait();
            }else {
            // CHECK IF THE PROGRAM ID IS ALREADY EXIST
            String checkData = "select PROG_ID from program where PROG_ID = '"
                    + progid.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Program #" + progid.getText() + " was already exist!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, progid.getText());
                prepare.setString(2, progname.getText());
                prepare.setString(3, Combo_DepID.getSelectionModel().getSelectedItem().toString());

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addProgramShowListData();
                // TO CLEAR THE FIELDS
                addProgramClear();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

     public void addDepartmentAdd() {

        String insertData = "insert into Department(DEP_ID, DEP_NAME) values (?,?)";

        connect = DataBaseConnection.connectDb();

        try {
            Alert alert;

            if (depid.getText().isEmpty()
                  || depname.getText().isEmpty()) 
            {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else if (!depid.getText().matches("\\d+")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Department ID must contain only numbers");
                alert.showAndWait();
            } else {
                // CHECK IF THE STUDENTNUMBER IS ALREADY EXIST
                String checkData = "select DEP_ID from department where DEP_ID = '"
                        + depid.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Departmnet #" + depid.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, depid.getText());
                    prepare.setString(2, depname.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addDepartmentShowListData();
                    // TO CLEAR THE FIELDS
                    adddepartmentClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
     
     
     public void addCourseAdd() {
    String insertData = "insert into Course(Course_ID, COURSE_NAME, PROG_ID) values (?,?,?)";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (coursegid.getText().isEmpty()
            || Coursename.getText().isEmpty()
            || Combo_ProgID.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else if (!coursegid.getText().matches("\\d+")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course ID must contain only numbers");
                alert.showAndWait();
            }else {
            // CHECK IF THE COURSE ID IS ALREADY EXIST
            String checkData = "select Course_ID from Course where Course_ID = '"
                    + coursegid.getText() + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(checkData);

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course #" + coursegid.getText() + " was already exist!");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, coursegid.getText());
                prepare.setString(2, Coursename.getText());
                prepare.setString(3, Combo_ProgID.getSelectionModel().getSelectedItem().toString());

                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addCourseShowListData();
                // TO CLEAR THE FIELDS
                addCourseClear();
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public void addGradeAdd() {
    String insertData = "INSERT INTO student_course(Nat_ID, Course_ID, Year, Semester, Grade) VALUES (?,?,?,?,?)";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        // Validate that grade is a positive value and not greater than 100
        if (combo_natid.getValue() == null
                || combo_courseid.getValue() == null
                || year.getText().isEmpty()
                || combo_semester.getValue() == null
                || grade.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // Validate that grade is a positive value and not greater than 100
            try {
                int gradeValue = Integer.parseInt(grade.getText());
                if (gradeValue < 0 || gradeValue > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid positive grade value (0-100)");
                alert.showAndWait();
                return;
            }

            // CHECK IF THE GRADE ENTRY ALREADY EXISTS
            String checkData = "SELECT Nat_ID, Course_ID FROM student_course WHERE Nat_ID = ? AND Course_ID = ? AND Year = ? AND Semester = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setString(1, combo_natid.getValue().toString());
            prepare.setString(2, combo_courseid.getValue().toString());
            prepare.setString(3, year.getText());
            prepare.setString(4, combo_semester.getValue().toString());

            result = prepare.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Grade entry for National ID #" + combo_natid.getValue()
                        + ", Course ID #" + combo_courseid.getValue()
                        + ", Year " + year.getText()
                        + ", and Semester " + combo_semester.getValue() + " already exists!");
                alert.showAndWait();
            } else {
                // CHECK IF THE COURSE BELONGS TO THE SAME PROGRAM AS THE STUDENT
                String checkProgram = "SELECT COUNT(*) AS Count " +
                      "FROM Program P " +
                      "JOIN Course C ON P.prog_id = C.prog_id " +
                      "JOIN Student S ON S.prog_id = P.prog_id " +
                      "WHERE C.Course_ID = ? AND S.Nat_ID = ?";

                        prepare = connect.prepareStatement(checkProgram);
                        prepare.setString(1, combo_courseid.getValue().toString());
                        prepare.setString(2, combo_natid.getValue().toString());

                        result = prepare.executeQuery();

                result = prepare.executeQuery();

                if (result.next() && result.getInt("Count") > 0) {
                    // The course belongs to the same program as the student
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, combo_natid.getValue().toString());
                    prepare.setString(2, combo_courseid.getValue().toString());
                    prepare.setString(3, year.getText());
                    prepare.setString(4, combo_semester.getValue().toString());
                    prepare.setString(5, grade.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addGradeShowListData();
                    // TO CLEAR THE FIELDS
                    addGradeClear();
                } else {
                    // The course does not belong to the same program
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The selected course does not belong to the same program as the student!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}


       public void addStudentsUpdate() {

        String updateData = "call UPDATE_STUDENT_INFO(?,?,?,?,?,?,?,?,?)";

        connect = DataBaseConnection.connectDb();

        try {
            Alert alert;
             if (nat_id.getText().isEmpty()
                    || combo_gender.getSelectionModel().getSelectedItem() == null
                    || combo_prog.getSelectionModel().getSelectedItem() == null
                    || fname.getText().isEmpty()
                    || lname.getText().isEmpty()
                    || phone.getText().isEmpty()
                    || email.getText().isEmpty()
                    || city.getText().isEmpty()
                    || street.getText().isEmpty())  {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } 
             else if (!phone.getText().matches("\\d{11}")) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Phone number must be exactly 11 digits");
                alert.showAndWait();
            }else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + nat_id.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, nat_id.getText());
                    prepare.setString(2, fname.getText());
                    prepare.setString(3, lname.getText());
                    prepare.setString(4, (String) combo_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(5, phone.getText());
                    prepare.setString(6, email.getText());
                    prepare.setString(7, city.getText());
                    prepare.setString(8, street.getText());
                    prepare.setString(9, (String) combo_prog.getSelectionModel().getSelectedItem());
                   
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       
       public void addDepartmentUpdate() {

    String updateData = "update Department set DEP_NAME = ? where DEP_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (depid.getText().isEmpty() || depname.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE DEPARTMENT ID EXISTS
            String checkData = "select DEP_ID from Department where DEP_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(depid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Department #" + depid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the update
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, depname.getText());
                prepare.setInt(2, Integer.parseInt(depid.getText()));

                int rowsUpdated = prepare.executeUpdate();

                if (rowsUpdated > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addDepartmentShowListData();
                    // TO CLEAR THE FIELDS
                    adddepartmentClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void addProgramUpdate() {

    String updateData = "update Program set PROG_NAME = ?, DEP_ID = ? where PROG_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (progid.getText().isEmpty() || progname.getText().isEmpty() || Combo_DepID.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE PROGRAM ID EXISTS
            String checkData = "select PROG_ID from Program where PROG_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(progid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Program #" + progid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the update
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, progname.getText());
                prepare.setString(2, Combo_DepID.getSelectionModel().getSelectedItem().toString());
                prepare.setInt(3, Integer.parseInt(progid.getText()));

                int rowsUpdated = prepare.executeUpdate();

                if (rowsUpdated > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addProgramShowListData();
                    // TO CLEAR THE FIELDS
                    addProgramClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void addCourseUpdate() {
    String updateData = "update Course set COURSE_NAME = ?, PROG_ID = ? where Course_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (coursegid.getText().isEmpty() || Coursename.getText().isEmpty() || Combo_ProgID.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE COURSE ID EXISTS
            String checkData = "select Course_ID from Course where Course_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(coursegid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course #" + coursegid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the update
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, Coursename.getText());
                prepare.setString(2, Combo_ProgID.getSelectionModel().getSelectedItem().toString());
                prepare.setInt(3, Integer.parseInt(coursegid.getText()));

                int rowsUpdated = prepare.executeUpdate();

                if (rowsUpdated > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addCourseShowListData();
                    // TO CLEAR THE FIELDS
                    addCourseClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void AddupdateGrade() {
    String updateData = "UPDATE student_course SET Grade = ? WHERE Nat_ID = ? AND Course_ID = ? AND Year = ? AND Semester = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        // Validate that the necessary fields are filled
        if (combo_natid.getValue() == null
                || combo_courseid.getValue() == null
                || year.getText().isEmpty()
                || combo_semester.getValue() == null
                || grade.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // Validate that the grade is a positive value and not greater than 100
            try {
                int gradeValue = Integer.parseInt(grade.getText());
                if (gradeValue < 0 || gradeValue > 100) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid positive grade value (0-100)");
                alert.showAndWait();
                return;
            }

            // CHECK IF THE GRADE ENTRY EXISTS
            String checkData = "SELECT Nat_ID, Course_ID FROM student_course WHERE Nat_ID = ? AND Course_ID = ? AND Year = ? AND Semester = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setString(1, combo_natid.getValue().toString());
            prepare.setString(2, combo_courseid.getValue().toString());
            prepare.setString(3, year.getText());
            prepare.setString(4, combo_semester.getValue().toString());

            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Grade entry not found for National ID #" + combo_natid.getValue()
                        + ", Course ID #" + combo_courseid.getValue()
                        + ", Year " + year.getText()
                        + ", and Semester " + combo_semester.getValue());
                alert.showAndWait();
            } else {
                // CHECK IF THE SELECTED COURSE BELONGS TO THE SAME PROGRAM AS THE STUDENT
                String checkProgram = "SELECT COUNT(*) AS Count " +
                        "FROM Program P " +
                        "JOIN Course C ON P.prog_id = C.prog_id " +
                        "JOIN Student S ON S.prog_id = P.prog_id " +
                        "WHERE C.Course_ID = ? AND S.Nat_ID = ?";

                prepare = connect.prepareStatement(checkProgram);
                prepare.setString(1, combo_courseid.getValue().toString());
                prepare.setString(2, combo_natid.getValue().toString());

                result = prepare.executeQuery();

                if (result.next() && result.getInt("Count") > 0) {
                    // The course belongs to the same program as the student, proceed with the update
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, grade.getText());
                    prepare.setString(2, combo_natid.getValue().toString());
                    prepare.setString(3, combo_courseid.getValue().toString());
                    prepare.setString(4, year.getText());
                    prepare.setString(5, combo_semester.getValue().toString());

                    int rowsUpdated = prepare.executeUpdate();

                    if (rowsUpdated > 0) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Updated!");
                        alert.showAndWait();

                        // TO UPDATE THE TABLEVIEW
                        addGradeShowListData();
                        // TO CLEAR THE FIELDS
                        addGradeClear();
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Update failed!");
                        alert.showAndWait();
                    }
                } else {
                    // The course does not belong to the same program
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The selected course does not belong to the same program as the student!");
                    alert.showAndWait();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


       
    public void addStudentsDelete() {

        String deleteData = "DELETE FROM student WHERE Nat_ID = '"
                + nat_id.getText() + "'";

        connect = DataBaseConnection.connectDb();

        try {
            Alert alert;
            if (nat_id.getText().isEmpty()
                    || combo_gender.getSelectionModel().getSelectedItem() == null
                    || combo_prog.getSelectionModel().getSelectedItem() == null
                    || fname.getText().isEmpty()
                    || lname.getText().isEmpty()
                    || phone.getText().isEmpty()
                    || email.getText().isEmpty()
                    || city.getText().isEmpty()
                    || street.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student #" + nat_id.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void addDepartmentDelete() {

    String deleteData = "delete from Department where DEP_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (depid.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the Department ID field");
            alert.showAndWait();
        } else {
            // CHECK IF THE DEPARTMENT ID EXISTS
            String checkData = "select DEP_ID from Department where DEP_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(depid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Department #" + depid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the delete
                prepare = connect.prepareStatement(deleteData);
                prepare.setInt(1, Integer.parseInt(depid.getText()));

                int rowsDeleted = prepare.executeUpdate();

                if (rowsDeleted > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addDepartmentShowListData();
                    // TO CLEAR THE FIELDS
                    adddepartmentClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Delete failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void addProgramDelete() {
    String deleteData = "delete from Program where PROG_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (progid.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a Program ID");
            alert.showAndWait();
        } else {
            // CHECK IF THE PROGRAM ID EXISTS
            String checkData = "select PROG_ID from Program where PROG_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(progid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Program #" + progid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the delete
                prepare = connect.prepareStatement(deleteData);
                prepare.setInt(1, Integer.parseInt(progid.getText()));

                int rowsDeleted = prepare.executeUpdate();

                if (rowsDeleted > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addProgramShowListData();
                    // TO CLEAR THE FIELDS
                    addProgramClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Delete failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public void addCourseDelete() {
    String deleteData = "delete from Course where Course_ID = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        if (coursegid.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a Course ID");
            alert.showAndWait();
        } else {
            // CHECK IF THE COURSE ID EXISTS
            String checkData = "select Course_ID from Course where Course_ID = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setInt(1, Integer.parseInt(coursegid.getText()));
            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course #" + coursegid.getText() + " does not exist!");
                alert.showAndWait();
            } else {
                // Perform the delete
                prepare = connect.prepareStatement(deleteData);
                prepare.setInt(1, Integer.parseInt(coursegid.getText()));

                int rowsDeleted = prepare.executeUpdate();

                if (rowsDeleted > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addCourseShowListData();
                    // TO CLEAR THE FIELDS
                    addCourseClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Delete failed!");
                    alert.showAndWait();
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void addGradeDelete() {
    String deleteData = "DELETE FROM student_course WHERE Nat_ID = ? AND Course_ID = ? AND Year = ? AND Semester = ?";

    connect = DataBaseConnection.connectDb();

    try {
        Alert alert;

        // Validate that the necessary fields are filled
        if (combo_natid.getValue() == null
                || combo_courseid.getValue() == null
                || year.getText().isEmpty()
                || combo_semester.getValue() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            // CHECK IF THE GRADE ENTRY EXISTS
            String checkData = "SELECT Nat_ID, Course_ID FROM student_course WHERE Nat_ID = ? AND Course_ID = ? AND Year = ? AND Semester = ?";

            prepare = connect.prepareStatement(checkData);
            prepare.setString(1, combo_natid.getValue().toString());
            prepare.setString(2, combo_courseid.getValue().toString());
            prepare.setString(3, year.getText());
            prepare.setString(4, combo_semester.getValue().toString());

            result = prepare.executeQuery();

            if (!result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Grade entry not found for National ID #" + combo_natid.getValue()
                        + ", Course ID #" + combo_courseid.getValue()
                        + ", Year " + year.getText()
                        + ", and Semester " + combo_semester.getValue());
                alert.showAndWait();
            } else {
                // Perform the delete
                prepare = connect.prepareStatement(deleteData);
                prepare.setString(1, combo_natid.getValue().toString());
                prepare.setString(2, combo_courseid.getValue().toString());
                prepare.setString(3, year.getText());
                prepare.setString(4, combo_semester.getValue().toString());

                int rowsDeleted = prepare.executeUpdate();

                if (rowsDeleted > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addGradeShowListData();
                    // TO CLEAR THE FIELDS
                    addGradeClear();
                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Delete failed!");
                    alert.showAndWait();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addStudentsShowListData();
        addDepartmentShowListData();
        addStudentsGenderList();
        addStudentsProgramList();
        addGradeSemesterList();
        addProgramDepartmentList();
        addCourseProgramList();
        addCourseShowListData();
        addProgramShowListData();
        addStudentsSearch();
        addDepartmentSearch();
        addProgramSearch();
        addCourseSearch();
        addGradeNationalIDList();
        addGradeCourseIDList();
        addGradeListData();
        addGradeShowListData();
        addGradeSearch();
        addReportListData();
        addReportShowListData();
        addReportSearch();
      
    }    
    
    
}
