package danilopereira.bonfascarapi.repositories

import danilopereira.bonfascarapi.entities.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<Employee, String> {
}