package danilopereira.bonfascarapi.controllers

import danilopereira.bonfascarapi.entities.Employee
import danilopereira.bonfascarapi.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException


@RestController
@RequestMapping("/users")
class UserController(private val bCrypt: BCryptPasswordEncoder) {
    @Autowired
    lateinit var repository: UserRepository


    @GetMapping
    fun index(): List<Employee>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody employee: Employee): Employee {
        val password = bCrypt.encode(employee.password)
        employee.password = password
        return repository.save(employee)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody newEmployee: Employee): Employee {
        val user = repository.findById(id).orElseThrow { EntityNotFoundException() }

        user.apply {
            this.password = newEmployee.password
        }
        return repository.save(user)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String){
        val user = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(user)
    }
}