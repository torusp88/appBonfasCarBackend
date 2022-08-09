package danilopereira.bonfascarapi.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cars")
class Car (
    @Id
    var plate: String,

    var name: String,

    var owner: String,

    var telephone: Int,

    var address: String
)