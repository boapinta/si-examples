package org.krams.tutorial.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.krams.tutorial.oxm.Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CRUD service for handling {@link Record} entities like Sales
 * <p>
 * This is a normal Spring MVC annotated service.
 */
@Service("commerceService")
@Transactional
public class CommerceService {

	protected static Logger logger = Logger.getLogger("service");
	
	/**
	 *  An in-memory list to store our data. Feel free to use a DAO or JDBC instead
	 */
	private Map<String, Entity> inMemoryDb = new HashMap<String, Entity>();
	
	/**
	 * Adds a new record.
	 */
	public void add(Entity record) {
		// Search HashMap
		if ( inMemoryDb.get(record.getId()) != null ) {
			logger.error("Record already exist!");
			throw new RuntimeException("Record already exist!");
		}
		
		// Add to HashMap
		inMemoryDb.put(record.getId(), record);
	}
	
	/**
	 * Retrieves all records. 
	 * 
	 * @return list of subscribed users
	 */
	public ArrayList<Entity> getAll() {
		ArrayList<Entity> records = new ArrayList<Entity>();
		
		logger.debug("Retrieving all records");
		for (Map.Entry<String, Entity> entry: inMemoryDb.entrySet()) {
			records.add(entry.getValue());
			logger.debug(entry.getValue());
		}
		
		// Return all records
		return records;
	}
}
