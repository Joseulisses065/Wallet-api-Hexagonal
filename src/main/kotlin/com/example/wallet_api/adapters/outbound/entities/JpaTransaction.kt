package com.example.wallet_api.adapters.outbound.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import java.util.UUID

@Entity
@Table(name = "transaction")
data class JpaTransaction(
    @Id
    var id: UUID
)
