package com.example.wallet_api.utils.extensions

import com.example.wallet_api.adapters.outbound.entities.JpaWallet
import com.example.wallet_api.adapters.inbound.dto.WalletDTO
import com.example.wallet_api.domain.Wallet


fun WalletDTO.toDomain(): Wallet {
    return Wallet(
        id = this.id
    )
}
fun JpaWallet.toDomain(): Wallet {
    return Wallet(
        id = this.id
    )
}


fun Wallet.toDTO(): WalletDTO {
    return WalletDTO(
        id = this.id
    )
}


fun Wallet.toJpa(): JpaWallet {
    return JpaWallet(
        id = this.id
    )
}
