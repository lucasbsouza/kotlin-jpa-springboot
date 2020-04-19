package com.example.kex1.controller.impl

import com.example.kex1.entity.Address
import com.example.kex1.entity.Card
import com.example.kex1.entity.Person
import com.example.kex1.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class PersonController {

    @Autowired
    lateinit var personRepository:PersonRepository

    fun findByDocument(cpf: String): Optional<Person> {
        return Optional.of(personRepository.getPersonByCpf(cpf))
    }

    fun getCardByDocument(cpf: String): List<Card>? {
        return personRepository.getCardByCpf(cpf)
    }

    fun getAddressByDocument(cpf: String): Optional<List<Address?>> {
        return Optional.of(personRepository.getAddressByCpf(cpf))
    }

    fun updatePerson(person: Person) {
        personRepository.save(person);
    }

    fun findAll(): List<Person>? {
        return personRepository.findAll()
    }
}