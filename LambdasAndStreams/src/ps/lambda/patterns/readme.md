https://app.pluralsight.com/library/courses/implementing-design-patterns-java-8-lambda-expression/table-of-contents
Implementing Design Patterns Using Java 8 Lambda


```
# https://www.baeldung.com/java-streams-find-list-items
# how to filter list

List<Employee> filteredList = emplList.stream()
  .filter(empl -> deptList.stream()
    .anyMatch(dept -> 
      dept.getDepartment().equals("sales") && 
      empl.getEmployeeId().equals(dept.getEmployeeId())))
    .collect(Collectors.toList());
```