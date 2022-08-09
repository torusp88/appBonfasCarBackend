package danilopereira.bonfascarapi.controllers

import danilopereira.bonfascarapi.entities.Service
import danilopereira.bonfascarapi.repositories.ServiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/services")
class ServiceController {
    @Autowired
    lateinit var repository: ServiceRepository

    //Retorna todos os serviços
    @GetMapping
    fun index(): List<Service>{
        return repository.findAll()
    }

    @GetMapping("/{date}")
    fun dailyWashes(@PathVariable("date") date: Int) : List<Service>{
        return repository.findByDate(date)
    }

    //Cria um novo serviço
   //Exemplo de adição de um objeto jSon -> "car": {"plate": "AAA1J38", "name": "TCross", "owner": "Thiago", "telephone": 985345612,"address":"Rua Poetisa Colombina 605"}
    @PostMapping
    fun create(@RequestBody service: Service): Service {
        return repository.save(service)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id : Long, @RequestBody newService: Service): Service {
        val service = repository.findById(id).orElseThrow{ EntityNotFoundException() }

        service.apply {
            this.date = newService.date
            this.car = newService.car
            this.deliver = newService.deliver
            this.price = newService.price
            this.wax = newService.wax
            this.payed = newService.payed
            this.obs = newService.obs
        }

        return repository.save(service)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long){
        val service = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(service)
    }

}