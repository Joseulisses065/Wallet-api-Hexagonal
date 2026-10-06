package com.example.wallet_api.adapters.outbound.repositories

import com.example.wallet_api.adapters.outbound.entities.JpaWallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface WalletJpaRepository: JpaRepository<JpaWallet, UUID> {
}