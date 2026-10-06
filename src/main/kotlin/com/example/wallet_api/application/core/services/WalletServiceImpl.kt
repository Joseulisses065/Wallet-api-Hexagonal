package com.example.wallet_api.application.core.services

import com.example.wallet_api.application.ports.`in`.WalletService
import com.example.wallet_api.application.ports.out.WalletRepository
import com.example.wallet_api.domain.Wallet
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WalletServiceImpl(
    private val walletRepository: WalletRepository
): WalletService {
    override fun findById(id: UUID): Wallet {
        return walletRepository.findById(id).orElseThrow { EntityNotFoundException("Wallet não encontrada") }
    }

    override fun save(wallet: Wallet): Wallet {
        return walletRepository.save(wallet)
    }

    override fun delete(id: UUID) {
        walletRepository.delete(id)
    }

    override fun findAll(): List<Wallet> {
        return walletRepository.findAll()
    }

    override fun update(
        id: UUID,
        wallet: Wallet
    ): Wallet {
       return walletRepository.update(id, wallet)
    }
}