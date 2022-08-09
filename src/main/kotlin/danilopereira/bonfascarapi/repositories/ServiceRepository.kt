package danilopereira.bonfascarapi.repositories

import danilopereira.bonfascarapi.entities.Service
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository: JpaRepository<Service, Long> {
    fun findByDate(date: Int): List<Service>
}