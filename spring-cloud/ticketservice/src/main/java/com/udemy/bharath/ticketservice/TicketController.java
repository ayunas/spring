package com.udemy.bharath.ticketservice;

//import lombok.NonNull;

//import com.udemy.bharath.priceservice.Price;

import com.udemy.bharath.ticketservice.dto.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	PriceAPI priceAPI;

	@GetMapping
	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
		Optional<Ticket> ticket = ticketRepo.findById(id);

		if (ticket.isEmpty()) {
			return new ResponseEntity("No ticket found with id : " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(ticket.get(), HttpStatus.OK);
	}

	@PostMapping
	public Ticket addTicket(@RequestParam Long id, @RequestBody Ticket ticket) {
		Price price = priceAPI.getPrice(id);
		System.out.println(price.toString());
		ticket.setPrice(price.getPrice());
		Ticket tkt = ticketRepo.save(ticket);
		System.out.println(tkt);
		return tkt;
	}
}