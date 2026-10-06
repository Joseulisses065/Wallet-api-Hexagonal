package com.example.wallet_api.adapters.outbound.entities

import com.example.wallet_api.domain.Wallet
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import java.util.UUID

@Entity
@Table(name = "wallet")
data class JpaWallet(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID
)