package com.example.wallet_api.adapters.inbound.controllers

import com.example.wallet_api.adapters.inbound.dto.WalletDTO
import com.example.wallet_api.application.ports.`in`.WalletService
import com.example.wallet_api.utils.extensions.toDTO
import com.example.wallet_api.utils.extensions.toDomain
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/v1/wallet")
class WalletController (
    private val walletService: WalletService
){
    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<WalletDTO>{
      return ResponseEntity.ok(walletService.findById(id).toDTO())
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<WalletDTO>>{
        return ResponseEntity.ok(walletService.findAll().map { it.toDTO() })
    }

    @PostMapping
    fun save(@RequestBody wallet: WalletDTO): ResponseEntity<WalletDTO>{
        return ResponseEntity.ok(walletService.save(wallet.toDomain()).toDTO())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID,@RequestBody wallet: WalletDTO): ResponseEntity<WalletDTO>{
        return ResponseEntity.ok(walletService.update(id,wallet.toDomain()).toDTO())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Void>{
        walletService.delete(id)
        return ResponseEntity.noContent().build()
    }
}