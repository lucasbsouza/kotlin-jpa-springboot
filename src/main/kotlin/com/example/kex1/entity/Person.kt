package com.example.kex1.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import javax.persistence.*

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long,

        @Column
        var name:String,

        @Column
        var age:Int,

        @Column
        val cpf:String,

        @JsonManagedReference
        @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        var address: List<Address>?,

        @JsonManagedReference
        @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.ALL))
        var card:List<Card>?
) : Serializable