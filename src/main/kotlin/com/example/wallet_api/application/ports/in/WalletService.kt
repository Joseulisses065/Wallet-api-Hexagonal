package com.example.wallet_api.application.ports.`in`

import com.example.wallet_api.domain.Wallet
import java.util.Optional
import java.util.UUID


interface WalletService {
    fun findById(id: UUID): Wallet
    fun save(wallet: Wallet): Wallet
    fun delete(id: UUID): Unit
    fun findAll(): List<Wallet>
    fun update(id: UUID, wallet: Wallet): Wallet
}