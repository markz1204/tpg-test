package question2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by markz on 2/7/17.
 */
public class SortStudentInfo {

    private StudentInfo map(String info, String separator){

        String[] details = info.split(separator);

        return new StudentInfo(Integer.parseInt(details[0]), details[1], Double.parseDouble(details[2]));
    }

    public String sort(Set<String> studentInfoSet){

        List<String> results = studentInfoSet.stream().map(sInfo->map(sInfo, " ")).sorted((o1, o2) -> {
            if(o1.getGpa() == o2.getGpa()){
                if(o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getId() > o2.getId() ? 1 : -1;
                }else{
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
            }else {
                return o1.getGpa() > o2.getGpa() ? -1 : 1;
            }
        }).map(studentInfo -> studentInfo.getFirstName()).collect(Collectors.toList());

        return results.toString();

    }


    class StudentInfo{
        private int id;
        private String firstName;
        private double gpa;

        StudentInfo(int id, String firstName, double gpa) {
            this.id = id;
            this.firstName = firstName;
            this.gpa = gpa;
        }

        int getId() {
            return id;
        }

        String getFirstName() {
            return firstName;
        }

        double getGpa() {
            return gpa;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StudentInfo that = (StudentInfo) o;

            if (id != that.id) return false;
            if (Double.compare(that.gpa, gpa) != 0) return false;
            return firstName != null ? firstName.equals(that.firstName) : that.firstName == null;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = id;
            result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
            temp = Double.doubleToLongBits(gpa);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
