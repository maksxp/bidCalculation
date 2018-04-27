package com.siaivo.bid.repository;

import com.siaivo.bid.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("equipmentRepository")
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	Equipment findById(int id);
	Equipment findBySerialNumber(String serialNumber);
	List <Equipment> findByLocation(String location);
}
