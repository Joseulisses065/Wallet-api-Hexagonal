package com.example.wallet_api.application.ports.out

import com.example.wallet_api.domain.Wallet
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface WalletRepository {
    fun findById(id: UUID): Optional<Wallet>
    fun save(wallet: Wallet): Wallet
    fun delete(id: UUID): Unit
    fun findAll(): List<Wallet>
    fun update(id: UUID, wallet: Wallet): Wallet
}