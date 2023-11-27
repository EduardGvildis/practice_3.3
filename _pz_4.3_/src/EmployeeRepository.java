import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {
    List<Employee> employeeList = new ArrayList<>(
            List.of(
                    new Employee(1,"Vasya","Voloshin",Gender.MALE,18,10000,5,Speciality.HR),
                    new Employee(2,"Petya","Petrov",Gender.MALE,20,20000,1,Speciality.HR),
                    new Employee(3,"Dusya","Gusev",Gender.FEMALE,34,15000,2,Speciality.HR),
                    new Employee(4,"Karina","Powers",Gender.FEMALE,52,150000,0,Speciality.HR),
                    new Employee(5,"Andriy","Valun",Gender.MALE,18,10000,3,Speciality.PM),
                    new Employee(6,"Danya","Crubskiy",Gender.MALE,23,17000,5,Speciality.PM),
                    new Employee(7,"Edik","Gvaldis",Gender.MALE,26,50000,4,Speciality.PM),
                    new Employee(8,"Andriy","Hetun",Gender.MALE,76,10000,8,Speciality.PM),
                    new Employee(9,"Petya","Voloshin",Gender.MALE,45,4000,9,Speciality.QA),
                    new Employee(10,"Alec","Orlov",Gender.MALE,20,7000,2,Speciality.QA),
                    new Employee(11,"Vera","Buzinarska",Gender.FEMALE,20,20000,3,Speciality.QA),
                    new Employee(12,"Dusya","Orlova",Gender.FEMALE,30,10500,5,Speciality.QA),
                    new Employee(13,"Karina","Buzinarska",Gender.FEMALE,15,1000,5,Speciality.DEV_OPS),
                    new Employee(14,"Viktoria","Burchak",Gender.FEMALE,25,40000,4,Speciality.DEV_OPS),
                    new Employee(15,"Danya","Sorocotyaga",Gender.MALE,23,100000,2,Speciality.DEV_OPS),
                    new Employee(16,"Alec","Voloshin",Gender.MALE,42,120000,3,Speciality.DEV_OPS),
                    new Employee(17,"Andriy","Homenko",Gender.MALE,34,4000,1,Speciality.BACKAND_DEVELOPER),
                    new Employee(18,"Edik","Ivanov",Gender.MALE,32,50000,9,Speciality.BACKAND_DEVELOPER),
                    new Employee(19,"Valera","Hetun",Gender.MALE,65,9000,7,Speciality.BACKAND_DEVELOPER),
                    new Employee(20,"Vera","Budanova",Gender.FEMALE,56,3000,8,Speciality.BACKAND_DEVELOPER),
                    new Employee(21,"Vasya","Petrov",Gender.MALE,73,1000,9,Speciality.FRONTEND_DEVELOPER),
                    new Employee(22,"Edik","Miniva",Gender.MALE,84,8000,0,Speciality.FRONTEND_DEVELOPER),
                    new Employee(23,"Andriy","Dubin",Gender.MALE,18,23000,15,Speciality.FRONTEND_DEVELOPER),
                    new Employee(24,"Andriy","Litvyakov",Gender.MALE,18,15,15,Speciality.FRONTEND_DEVELOPER)
            )
    );
    public String[] getNameAndSurnameOfTop3BySalary(){
        return employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .map(employee -> employee.getName() + " " + employee.getLastName())
                .toArray(String[]::new);
    }
    public  Map<Speciality, List<Employee>> groupBySpeciality(){
          return  employeeList.stream()
                .collect(Collectors.groupingBy(Employee :: getSpeciality));
    }
    public int getSalaryByHugeCriteriaList(){
       return employeeList.stream()
                .filter((salary)->salary.getGender() == Gender.FEMALE && salary.getSpeciality() == Speciality.QA && salary.getAge() <=30
                && salary.getWorkExperience() <= 5)
               .mapToInt(Employee :: getSalary)
               .sum();
    }
    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty(){
       return employeeList.stream()
                .anyMatch((male)->(male.getWorkExperience() >= 20 && male.getGender() == Gender.MALE && (male.getSpeciality() == Speciality.BACKAND_DEVELOPER
                        || male.getSpeciality() == Speciality.DEV_OPS)));
    }
    public String getDescendingSalaryWithFullName(){
      return employeeList.stream()
              .sorted(Comparator.comparing(Employee::getSalary).reversed())
              .map(employee -> employee.getName() + " " + employee.getLastName() + " " + employee.getSalary())
              .collect(Collectors.joining("; "));
    }
    public Map<Speciality,Double> getAverageSalaryBySpeciality(){
                return employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getSpeciality,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
