package danilopereira.bonfascarapi.controllers

import danilopereira.bonfascarapi.entities.Car
import danilopereira.bonfascarapi.repositories.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/cars")
class CarController {

    @Autowired
    lateinit var repository: CarRepository

    //Retorna todos os carros cadastrados
    @GetMapping
    fun index(): List<Car>{
        return repository.findAll()
    }

    //Retorna o carro a partir de uma placa
    @GetMapping("/{id}")
    fun show(@PathVariable("id") id : String): Car {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }



    //Cria um novo carro
    @PostMapping
    fun create(@RequestBody car: Car):Car {
        return repository.save(car)
    }
    //Faz o update de informações de um carro a partir da sua placa
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody newCar: Car): Car {
        val car = repository.findById(id).orElseThrow { EntityNotFoundException() }

        car.apply {
            this.name = newCar.name
            this.owner = newCar.owner
            this.telephone = newCar.telephone
            this.address = newCar.address
        }

        return repository.save(car)
    }
    //Deleta um carro a partir de sua placa
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String){
        val car = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(car)
    }
}