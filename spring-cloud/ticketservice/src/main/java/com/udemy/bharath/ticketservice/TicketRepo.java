package com.udemy.bharath.ticketservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
	@Override
	List<Ticket> findAll();
}
