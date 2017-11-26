package com.pvt.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pvt.spring.dao.SovietTankDao;
import com.pvt.spring.model.Tank;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class SovietTanksController {

	@Autowired
	private SovietTankDao tankDAO;

    public SovietTanksController() {
    }

    public SovietTankDao getTankDAO() {
        return tankDAO;
    }

    public void setTankDAO(SovietTankDao tankDAO) {
        this.tankDAO = tankDAO;
    }

	
	@GetMapping("/tanks/soviet")
	public List getTanks() {
		return tankDAO.list();
	}

	@GetMapping("/tanks/soviet/{id}")
	public ResponseEntity getTank(@PathVariable("id") Long id) {

		Tank tank = tankDAO.get(id);
		if (tank == null) {
			return new ResponseEntity("No Tank found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(tank, HttpStatus.OK);
	}

	@PostMapping(value = "/tanks/soviet")
	public ResponseEntity createTank(@RequestBody Tank tank) {

		tankDAO.create(tank);

		return new ResponseEntity(tank, HttpStatus.OK);
	}

	@DeleteMapping("/tanks/soviet/{id}")
	public ResponseEntity deleteTank(@PathVariable Long id) {

		if (null == tankDAO.delete(id)) {
			return new ResponseEntity("No Tank found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/tanks/soviet/{id}")
	public ResponseEntity updateTank(@PathVariable Long id, @RequestBody Tank tank) {

		tank = tankDAO.update(id, tank);

		if (null == tank) {
			return new ResponseEntity("No Tank found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(tank, HttpStatus.OK);
	}

}