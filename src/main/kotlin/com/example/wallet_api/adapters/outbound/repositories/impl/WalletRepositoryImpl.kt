package com.example.wallet_api.adapters.outbound.repositories.impl

import com.example.wallet_api.adapters.outbound.repositories.WalletJpaRepository
import com.example.wallet_api.application.ports.out.WalletRepository
import com.example.wallet_api.domain.Wallet
import com.example.wallet_api.utils.extensions.toDomain
import com.example.wallet_api.utils.extensions.toJpa
import jakarta.persistence.EntityNotFoundException
import java.util.Optional
import java.util.UUID

class WalletRepositoryImpl(
    private val walletRepository: WalletJpaRepository
): WalletRepository {
    override fun findById(id: UUID): Optional<Wallet> {
        return walletRepository.findById(id).map {
            it.toDomain()
        }
    }

    override fun save(wallet: Wallet): Wallet {
       return this.walletRepository.save(wallet.toJpa()).toDomain()
    }

    override fun delete(id: UUID) {
        this.walletRepository.findById(id).orElseThrow{ EntityNotFoundException() }
    }

    override fun findAll(): List<Wallet> {
        return this.walletRepository.findAll().map {
            it.toDomain()
        }
    }

    override fun update(id: UUID, wallet: Wallet): Wallet {
        val find = this.walletRepository.findById(id).orElseThrow{ EntityNotFoundException() }
        find.copy(wallet.id)
        return this.walletRepository.save(find).toDomain()
    }
}