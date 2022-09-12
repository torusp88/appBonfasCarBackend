package danilopereira.bonfascarapi.entities

import javax.persistence.*


@Entity
class Service (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var date: Int,
    //CascadeType.MERGE evita que um carro seja excluido ao excluir um serviço
    @ManyToOne(cascade = [CascadeType.MERGE])
    //@JoinColumn(name = "plate")
    var car: Car,

    var deliver: Boolean,

    var price: Int,

    var wax: Boolean,

    var payed: Boolean,

    var obs: String

)