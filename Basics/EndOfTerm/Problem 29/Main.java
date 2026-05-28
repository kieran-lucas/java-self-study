/*
1. Code này có smell là god class, một class đảm nhiệm quá nhiều
trách nhiệm, gần như là nắm toàn bộ chức năng của hệ thống,
cách khác phục là mỗi cụm chức năng liên quan ta sẽ tách thành một class
 */
class StudentService {
    public void addStudent() {}
    public void removeStudent() {}
}
class StudentScoreCalculator {
    public void calculateStudentAverageScore() {}
}
class StudentReposity {
    public void savaStudentToDatabase() {}
}
class StudentEmailService {
    public void sendEmailToParent() {}
}
class StudentReportService {
    public void printStudentService () {}
}
class TeacherSalaryManager {
    public void manageTeacherSalary() {}
}
class SchoolReportService {
    public void generateSchoolReport () {}
}

