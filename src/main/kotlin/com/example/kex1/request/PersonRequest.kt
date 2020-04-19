package com.example.kex1.request

import com.example.kex1.controller.impl.PersonController
import com.example.kex1.entity.Person
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("person")
class PersonRequest (val personController:PersonController) {

    @GetMapping
    fun getPerson() = personController.findAll()

    @GetMapping("/cpf/{document}")
    fun getPerson(@PathVariable("cpf") document: String) = personController.findByDocument(document)

    @GetMapping("/card/{cpf}")
    fun getCard(@PathVariable("cpf") document: String) = personController.getCardByDocument(document)

    @GetMapping("/address/{cpf}")
    fun getAddress(@PathVariable("cpf") document: String) = personController.getAddressByDocument(document)

    @PutMapping("{cpf}")
    fun updatePerson(@PathVariable("cpf") cpf: String, @RequestBody person: Person): ResponseEntity.BodyBuilder {
        val p = personController.findByDocument(cpf);
        var personDB = p.orElseThrow { RuntimeException("cpf $cpf not found") }
        var saved = personController.updatePerson(personDB.copy(age = person.age))
        return ResponseEntity.ok()
    }
}