package com.xdatacore.sportslineapi.services

import com.xdatacore.sportslineapi.models.Counter
import com.xdatacore.sportslineapi.repositories.CounterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CounterService(@Autowired private val counterRepository: CounterRepository) {

    @Transactional
    fun getNextSequence(sequenceName: String): Int {
        val counter = counterRepository.findById(sequenceName).orElse(Counter(sequenceName, 0))
        counter.seq = counter.seq + 1
        counterRepository.save(counter)
        return counter.seq
    }
}
