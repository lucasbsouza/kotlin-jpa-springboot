package com.example.kex1.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import java.io.Serializable
import javax.persistence.*

@Entity
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long,

        @Column
        var street:String,

        @Column
        var number:Int,

        @JsonBackReference
        @JoinColumn
        @ManyToOne(fetch = FetchType.EAGER)
        val person:Person

) : Serializable