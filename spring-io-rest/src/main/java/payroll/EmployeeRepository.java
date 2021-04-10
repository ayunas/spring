package payroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

