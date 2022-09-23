package danilopereira.bonfascarapi.repositories

import danilopereira.bonfascarapi.entities.WashService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WashServiceRepository: JpaRepository<WashService, Long> {
    fun findByDate(date: Int): List<WashService>
}