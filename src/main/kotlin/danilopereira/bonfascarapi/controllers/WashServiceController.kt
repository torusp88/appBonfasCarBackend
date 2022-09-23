package danilopereira.bonfascarapi.controllers

import danilopereira.bonfascarapi.entities.WashService
import danilopereira.bonfascarapi.repositories.WashServiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/washservices")
class WashServiceController {
    @Autowired
    lateinit var repository: WashServiceRepository

    //Retorna todos os serviços
    @GetMapping
    fun index(): List<WashService>{
        return repository.findAll()
    }

    @GetMapping("/{date}")
    fun dailyWashes(@PathVariable("date") date: Int) : List<WashService>{
        return repository.findByDate(date)
    }

    //Cria um novo serviço
   //Exemplo de adição de um objeto jSon -> "car": {"plate": "AAA1J38", "name": "TCross", "owner": "Thiago", "telephone": 985345612,"address":"Rua Poetisa Colombina 605"}
    @PostMapping
    fun create(@RequestBody washService: WashService): WashService {
        return repository.save(washService)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id : Long, @RequestBody newWashService: WashService): WashService {
        val service = repository.findById(id).orElseThrow{ EntityNotFoundException() }

        service.apply {
            this.date = newWashService.date
            this.car = newWashService.car
            this.deliver = newWashService.deliver
            this.price = newWashService.price
            this.wax = newWashService.wax
            this.payed = newWashService.payed
            this.obs = newWashService.obs
        }

        return repository.save(service)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long){
        val service = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(service)
    }

}