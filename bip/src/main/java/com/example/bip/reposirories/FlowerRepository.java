package com.example.bip.reposirories;

import com.example.sitairis.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower,Long> {
}
