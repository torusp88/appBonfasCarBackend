package danilopereira.bonfascarapi.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
class Employee (
    @Id
    var login: String,

    var password: String
)